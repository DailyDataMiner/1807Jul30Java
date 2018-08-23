CREATE TABLE reimbursements (
  id number(10) PRIMARY KEY,
  amount number(15,2) not null,
  submitted DATE not null,
  resolved DATE,
  description varchar2(256),
  receipt blob,
  author number not null,
  resolver number,
  statusId number not null,
  typeId number not null,
  CONSTRAINT fk_author FOREIGN KEY (author)
    REFERENCES users(id),
  CONSTRAINT fk_resolver FOREIGN KEY (resolver)
    REFERENCES users(id),
  CONSTRAINT fk_statusId FOREIGN KEY (statusId)
    REFERENCES reimbursementStatus(id),
  CONSTRAINT fk_typeId FOREIGN KEY (typeId)
    REFERENCES reimbursementType(id)
);

CREATE TABLE users (
  id number(10) PRIMARY KEY,
  username varchar2(50) not null unique,
  password varchar2(50) not null,
  firstname varchar2(100) not null,
  lastname varchar2(100) not null,
  email varchar(150) not null,
  roleId number not null,
  CONSTRAINT fk_roleId FOREIGN KEY (roleId)
    REFERENCES userRoles(id)
);

ALTER TABLE users
DROP CONSTRAINT fk_roleId;

ALTER TABLE users
ADD CONSTRAINT fk_roleId FOREIGN KEY (roleid)
  REFERENCES userRoles(id);

CREATE TABLE userRoles (
  id number(10) PRIMARY KEY,
  role varchar(10) not null
);


CREATE TABLE reimbursementStatus (
  id number PRIMARY KEY,
  status varchar2(10) not null
);

CREATE TABLE reimbursementType (
  id number PRIMARY KEY,
  type varchar2(10) not null
);



CREATE SEQUENCE users_Seq
minvalue 1
start with 1
increment by 1;
CREATE SEQUENCE userRoles_seq
minvalue 1
start with 1
increment by 1;
CREATE SEQUENCE reimbursements_Seq
minvalue 1
start with 1
increment by 1;
CREATE SEQUENCE reimbursementStatus_Seq
minvalue 1
start with 1
increment by 1;
CREATE SEQUENCE reimbursementType_Seq
minvalue 1
start with 1
increment by 1;


CREATE OR REPLACE TRIGGER user_seq_trig --declare and name trigger
BEFORE INSERT ON  users --When we will execute
FOR EACH ROW --necessary to change value of table
BEGIN
  -- What to do when trigger is fired
  SELECT users_seq.nextVAl INTO :new.id FROM dual;
END;
/

CREATE OR REPLACE TRIGGER userRoles_seq_trig --declare and name trigger
BEFORE INSERT ON  users --When we will execute
FOR EACH ROW --necessary to change value of table
BEGIN
  -- What to do when trigger is fired
  SELECT userRoles_seq.nextVAl INTO :new.id FROM dual;
END;
/

CREATE OR REPLACE TRIGGER reimbursements_seq_trig --declare and name trigger
BEFORE INSERT ON reimbursements --When we will execute
FOR EACH ROW --necessary to change value of table
BEGIN
  -- What to do when trigger is fired
  SELECT reimbursements_seq.nextVAl INTO :new.id FROM dual;
END;
/

CREATE OR REPLACE TRIGGER reimbursementstatus_seq_trig --declare and name trigger
BEFORE INSERT ON reimbursementstatus --When we will execute
FOR EACH ROW --necessary to change value of table
BEGIN
  -- What to do when trigger is fired
  SELECT reimbursementstatus_seq.nextVAl INTO :new.id FROM dual;
END;
/
CREATE OR REPLACE TRIGGER reimbursementtype_seq_trig --declare and name trigger
BEFORE INSERT ON reimbursementtype --When we will execute
FOR EACH ROW --necessary to change value of table
BEGIN
  -- What to do when trigger is fired
  SELECT reimbursementtype_seq.nextVAl INTO :new.id FROM dual;
END;
/
INSERT INTO userroles VALUES (1,'bob');

INSERT INTO users (username,password,firstname,lastname,email,roleid)VALUES('bobber','123','bob','ber','bob@bob.com',1);

commit;

INSERT INTO reimbursementstatus VALUES (1,'Pending');
INSERT INTO reimbursementtype VALUES (1, 'Travel');

