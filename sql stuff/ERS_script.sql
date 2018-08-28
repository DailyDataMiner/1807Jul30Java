/*...CREATE THESE FOR SURE...*/

create table ers_users
(
    userid number(10) Primary Key,
    username varchar2(50),
    userpassword varchar2(50),
    firstname varchar2(100),
    lastname varchar2(100),
    email varchar2(150),
    roleid varchar2(10)
);

drop table ers_users;

create table ers_reimbursements
(
    reimb_id number(10) Primary Key,
    reimb_amount number(10, 2) not null,
    reimb_submitted timestamp,
    reimb_resolved timestamp,
    reimb_description varchar2(500),
    reimb_author varchar2(50),
    reimb_resolver varchar2(50),
    reimb_status_id varchar2(50),
    reimb_type_id varchar2(50)
);

drop table ers_reimbursements;

create sequence ers_users_sequence
minvalue 1
start with 1
increment by 1
cache 2;

drop sequence ers_users_sequence;

create sequence reimbursements_sequence
minvalue 1
start with 1
increment by 1
cache 2;

drop sequence reimbursements_sequence;

create or replace trigger ers_users_sequence_trigger 
before insert on ers_users 
for each row 
begin
  select ers_users_sequence.nextval into :new.userid from dual;
end;

/

drop trigger ers_users_sequence_trigger;

create or replace trigger reimb_sequence_trigger 
before insert on ers_reimbursements 
for each row 
begin
  select reimbursements_sequence.nextval into :new.reimb_id from dual;
end;

/

drop trigger reimb_sequence_trigger;

insert into ers_users (username, userpassword, firstname, lastname, email, roleid) 
      values('JohnSmith', 'password', 'John', 'Smith', 'johnsmith@gmail.com', 'user');
      
insert into ers_users (username, userpassword, firstname, lastname, email, roleid) 
      values('JaneSmith', 'password', 'Jane', 'Smith', 'janesmith@gmail.com', 'user');      

select * from ers_users;


insert into ers_reimbursements (reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_author, reimb_resolver, reimb_status_id, reimb_type_id) 
      values('1000', '', '', 'this is a reimbursement request', 'JohnSmith', 'an admin', 'unresolved', 'Lodging');

insert into ers_reimbursements (reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_author, reimb_resolver, reimb_status_id, reimb_type_id) 
      values('59.99', '', '', 'this is another reimbursement request', 'JaneSmith', 'an admin', 'resolved', 'Travel');

select * from ers_reimbursements;