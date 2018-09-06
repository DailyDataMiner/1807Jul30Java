--------------- TABLES
create table ERS_REIMBURSEMENT(
  REIMB_ID number,        -- primary key
  REIMB_AMOUNT number,
  REIMB_SUBMITTED timestamp,
  REIMB_RESOLVED timestamp,
  REIMB_DESCRIPTION varchar2(250),
  REIMB_RECEIPT blob,
  REIMB_AUTHOR number,    -- foreign key
  REIMB_RESOLVER number,  -- foreign key
  REIMB_STATUS_ID number, -- foreign key
  REIMB_TYPE_ID number,   -- foreign key
  primary key (REIMB_ID),
  foreign key (REIMB_AUTHOR) references ERS_USERS(ERS_USERS_ID),
  foreign key (REIMB_RESOLVER) references ERS_USERS(ERS_USERS_ID),
  foreign key (REIMB_STATUS_ID) references ERS_REIMBURSEMENT_STATUS(REIMB_STATUS_ID),
  foreign key (REIMB_TYPE_ID) references ERS_REIMBURSEMENT_TYPE(REIMB_TYPE_ID)
);

create table ERS_USERS(
  ERS_USERS_ID number,    -- primary key
  ERS_USERNAME varchar2(50) unique,
  ERS_PASSWORD varchar2(50),
  USER_FIRST_NAME varchar2(100),
  USER_LAST_NAME varchar2(100),
  USER_EMAIL varchar2(150) unique,
  USER_ROLE_ID number,    -- foreign key
  primary key (ERS_USERS_ID),
  foreign key (USER_ROLE_ID) references ERS_USER_ROLES(ERS_USER_ROLE_ID)
);
select * from ers_users;

create table ERS_REIMBURSEMENT_STATUS(
  REIMB_STATUS_ID number, -- primary key
  REIMB_STATUS varchar2(10),
  primary key (REIMB_STATUS_ID)
);

create table ERS_REIMBURSEMENT_TYPE(
  REIMB_TYPE_ID number,   -- primary key
  REIMB_TYPE varchar2(10),
  primary key (REIMB_TYPE_ID)
);

create table ERS_USER_ROLES(
  ERS_USER_ROLE_ID number,    -- primary key
  USER_ROLE varchar2(10),
  primary key (ERS_USER_ROLE_ID)
);
commit;

--------------- SEQUENCES
CREATE SEQUENCE ers_users_seq
   MINVALUE 1 
   MAXVALUE 9999999999999999999999999999
   START WITH 1
   INCREMENT BY 1 
   CACHE 20 NOORDER  NOCYCLE  NOPARTITION;
select ers_users_seq.nextval from dual;
   
CREATE SEQUENCE ers_reimbursement_seq
   MINVALUE 1 
   MAXVALUE 9999999999999999999999999999
   START WITH 1
   INCREMENT BY 1 
   CACHE 20 NOORDER  NOCYCLE  NOPARTITION;


--------------- TRIGGERS
CREATE OR REPLACE TRIGGER ers_users_seq_trig
before insert on ERS_USERS
for each row
begin
    select ers_users_seq.nextVal into :new.ERS_USERS_ID from dual;
end;
/

CREATE OR REPLACE TRIGGER ers_reimbursement_seq_trig
before insert on ERS_REIMBURSEMENT
for each row
begin
    select ers_reimbursement_seq.nextVal into :new.REIMB_ID from dual;
end;
/



--------------- CREATE PROCEDURES
create or replace PROCEDURE get_all_users(
  c_users OUT SYS_REFCURSOR)
IS
BEGIN
  OPEN c_users for SELECT * FROM ers_users;
END;
/

create or replace PROCEDURE get_all_reimbursements(
  c_reimbursements OUT SYS_REFCURSOR)
IS
BEGIN
  OPEN c_reimbursements for SELECT * FROM ers_reimbursement;
END;
/



--------------- POPULATE TABLES
insert into ERS_REIMBURSEMENT_TYPE values(1, 'Lodging');
insert into ERS_REIMBURSEMENT_TYPE values(2, 'Travel');
insert into ERS_REIMBURSEMENT_TYPE values(3, 'Food');
insert into ERS_REIMBURSEMENT_TYPE values(4, 'Education');
select * from ERS_REIMBURSEMENT_TYPE;

insert into ERS_REIMBURSEMENT_STATUS values(1, 'Pending');
insert into ERS_REIMBURSEMENT_STATUS values(2, 'Approved');
insert into ERS_REIMBURSEMENT_STATUS values(3, 'Denied');
select * from ERS_REIMBURSEMENT_STATUS;
commit;

insert into ERS_USER_ROLES values(1, 'Employee');
insert into ERS_USER_ROLES values(2, 'Manager');
select * from ERS_USER_ROLES;

select * from ERS_USERS;
update ERS_USERS set USER_FIRST_NAME = 'MyFirstName' where ERS_USERS_ID = 1;



--------------- PASSWORD HASH
CREATE OR REPLACE FUNCTION GET_USER_HASH(ERS_USERNAME VARCHAR2, ERS_PASSWORD VARCHAR2) RETURN VARCHAR2
IS
EXTRA VARCHAR2(10) := 'SALT';
BEGIN
  RETURN TO_CHAR(DBMS_OBFUSCATION_TOOLKIT.MD5(
  INPUT => UTL_I18N.STRING_TO_RAW(DATA => ERS_USERNAME || ERS_PASSWORD || EXTRA)));
END;
/

-- BEFORE TRIGGER THAT HASHES USER PASSWORD
CREATE OR REPLACE TRIGGER before_insert_ers_user
BEFORE INSERT
ON ERS_USERS
FOR EACH ROW 
BEGIN 
    SELECT GET_USER_HASH(:new.ers_username, :new.ers_password) INTO :new.ers_password FROM dual;
END;
/

select * from ers_users;
delete from ers_users;
commit;
insert into ERS_USERS(ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id)
  values('mollymerritt', 'password', 'Molly', 'Merritt', 'merritt.mry@gmail.com', 1);
insert into ERS_USERS(ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id)
  values('myUsername', 'myPassword', 'myFirstname', 'myLastname', 'myEmail@email.com', 1);
insert into ERS_USERS(ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id)
  values('iamamanager2', 'thisismypassword', 'Michael', 'Scott', 'email2@email.com', 2);
  
insert into ERS_REIMBURSEMENT(reimb_amount, reimb_author, reimb_status_id, reimb_type_id)
  values(10, 41, 1, 2);
select * from ERS_REIMBURSEMENT;


CREATE OR REPLACE TRIGGER submitted_time
   BEFORE INSERT ON ERS_REIMBURSEMENT FOR EACH ROW
 BEGIN
   :new.reimb_submitted := current_timestamp();
 END;
 /

CREATE OR REPLACE TRIGGER resolved_time
   BEFORE UPDATE ON ERS_REIMBURSEMENT FOR EACH ROW
 BEGIN
   :new.reimb_resolved := current_timestamp();
 END;
 /

CREATE OR REPLACE TRIGGER set_default_status
   BEFORE INSERT ON ers_reimbursement FOR EACH ROW
 BEGIN
   :new.reimb_status_id := 1;
 END;
 /
 
CREATE OR REPLACE TRIGGER set_default_status
   BEFORE INSERT ON ers_reimbursement FOR EACH ROW
 BEGIN
   :new.reimb_status_id := 1;
 END;
 /
 
 delete from ers_reimbursement where reimb_author = 41;
 insert into ERS_REIMBURSEMENT(reimb_amount, reimb_author, reimb_status_id, reimb_type_id)
  values(10, 41, 1, 2);
  insert into ERS_REIMBURSEMENT(reimb_amount, reimb_author, reimb_status_id, reimb_type_id)
  values(7.5, 42, 1, 3);
select * from ERS_REIMBURSEMENT;
commit;