create table ers_reimbursement_status
(
  reimb_status_id number primary key,
  reimb_status varchar2(10)
);

create table ers_reimbursement_type
(
  reimb_type_id number primary key,
  reimb_type varchar2(10)
);

create table ers_user_roles
(
  ers_user_role_id number primary key,
  user_role varchar2(10)
);


create table ERS_Reimbursement
(
  Reimb_id number primary key,
  reim_amount number,
  reimb_submitted timestamp,
  reimb_resolved timestamp,
  reim_description varchar2(250),
  reimb_receipt blob,
  reimb_author number,
  reimb_resolver number,
  reim_status_id number,
  reim_type_id number
  
);

alter table ers_reimbursement
add constraint ers_users_fk_auth foreign key(reimb_author) references ers_users(ers_users_id);
alter table ers_reimbursement
add constraint ers_users_fk_reslvr foreign key(reimb_resolver) references ers_users(ers_users_id); 
alter table ers_reimbursement
add constraint ers_reimbursement_status_fk foreign key(reimb_status_id) references ers_reimbursement_status(reimb_status_id);
alter table ers_reimbursement
add constraint ers_reimbursement_type_fk foreign key(reimb_type_id) references ers_reimbursement_type(reimb_type_id);




create table ERS_Users
(
  ers_users_id number primary key,
  ers_username varchar2(50) unique,
  ers_password varchar(50),
  user_first_name varchar2(100),
  user_last_name varchar2(100),
  user_email varchar(150) unique,
  user_role_id number
);

alter table ers_users
add constraint user_roles_fk 
foreign key (user_role_id) references ers_user_roles(ers_user_role_id);


---------------------------------------Populate Preliminary Tables------------------
select * from ers_reimbursement_status;
Insert into ers_reimbursement_status values (1,'Pending');
Insert into ers_reimbursement_status values (2,'Approved');
Insert into ers_reimbursement_status values (3,'Denied');

select * from ers_reimbursement_type;
Insert into ers_reimbursement_type values(1,'Lodging');
Insert into ers_reimbursement_type values(2,'Travel');
Insert into ers_reimbursement_type values(3,'Food');
Insert into ers_reimbursement_type values(4,'Training');
Insert into ers_reimbursement_type values(5,'Misc');

select * from ers_user_roles;
Insert into ers_user_roles values (1,'Finance Manager');
Insert into ers_user_roles values (2,'Employee');

Alter table ers_user_roles
modify (user_role varchar2(50));
commit;

------------------Triggers and Sequences---------------------
Create Sequence reimb_seq;
/
Create or replace trigger reimb_trig
before insert on ers_reimbursement
for each row
Begin
  select reimb_seq.nextval into :new.Reimb_Id from dual;
end;
/

Create Sequence users_seq;
/
Create or replace trigger users_trig
before insert on ers_users
for each row
Begin
  select users_seq.nextval into :new.ers_users_id from dual;
end;
/

commit;

-------------------------Populate the Database with Dummy Data----------------
select * from ers_reimbursement;
select * from ERS_REIMBURSEMENT
full join ERS_REIMBURSEMENT_TYPE 
on ERS_REIMBURSEMENT.REIMB_TYPE_ID=ERS_REIMBURSEMENT_TYPE.REIMB_TYPE_id
where ERS_REIMBURSEMENT.REIMB_TYPE_ID is null or ERS_REIMBURSEMENT_TYPE.REIMB_TYPE_id is null;


select * from ERS_REIMBURSEMENT
union
select reimb_type from ERS_REIMBURSEMENT_TYPE;

