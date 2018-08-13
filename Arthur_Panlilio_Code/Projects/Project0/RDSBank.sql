CREATE TABLE users
(
  userId number(10) PRIMARY KEY,
  firstName varchar2(256) NOT NULL,
  lastName varchar2(256) NOT NULL,
  pwd varchar2(256) NOT NULL

);

CREATE TABLE account
(
  accountId number(10) PRIMARY KEY,
  accId number(10),
  userId number(10),
  CONSTRAINT fk_user_id FOREIGN KEY (userId)
    REFERENCES users(userId)

);

ALTER TABLE account ADD balance number(15,2) NOT NULL;
ALTER TABLE account DROP COLUMN accId;
ALTER TABLE account ADD accTypeId number(10) NOT NULL;
ALTER TABLE account ADD CONSTRAINT fk_accType_id FOREIGN KEY (accTypeId)
  REFERENCES accountType(accountTypeId);
ALTER TABLE account DROP CONSTRAINT fk_accType_id;

CREATE TABLE accountType 
(
  accountTypeId number(10) PRIMARY KEY,
  name varchar2(256) UNIQUE NOT NULL
);


CREATE SEQUENCE users_Seq
minvalue 1
start with 1
increment by 1;

CREATE SEQUENCE account_Seq
minvalue 1
start with 1
increment by 1;

CREATE SEQUENCE accountType_Seq
minvalue 1
start with 1
increment by 1;

CREATE OR REPLACE TRIGGER u_seq_trig --declare and name trigger
BEFORE INSERT ON  users --When we will execute
FOR EACH ROW --necessary to change value of table
BEGIN
  -- What to do when trigger is fired
  SELECT users_seq.nextVAl INTO :new.userId FROM dual;
END;

/
ALTER TABLE account
ENABLE CONSTRAINT fk_user_id;
TRUNCATE TABLE users;

ALTER TABLE users ADD username varchar2(256) UNIQUE NOT NULL;


CREATE OR REPLACE TRIGGER a_seq_trig --declare and name trigger
BEFORE INSERT ON  account --When we will execute
FOR EACH ROW --necessary to change value of table
BEGIN
  -- What to do when trigger is fired
  SELECT account_seq.nextVAl INTO :new.accountId FROM dual;
END;
/

ALTER TABLE account ADD lastUpdated DATE NOT NULL;

INSERT INTO accountType VALUES (1, 'Checking');
INSERT INTO accountType VALUES (2, 'Savings');
INSERT INTO accountType VALUES (3, 'Communal');
INSERT INTO accountType VALUES (4, 'Gambling');
INSERT INTO accountType VALUES (5, 'Admin');

DELEtE FROM account WHERE accountId = 21;

commit;

SELECT * FROM account where userID = 21 and acctypeid = 1;
TRUNCATE TABLE account;

CREATE OR REPLACE PROCEDURE deposit(amount number, accId number)
IS 
BEGIN
UPDATE account SET balance = balance + amount WHERE accountId = accId;
END;
/

UPDATE account SET balance = 0 WHERE accountId = 32;
commit;
EXEC deposit(20.00, 32);

CREATE OR REPLACE PROCEDURE withdraw(amount number, accId number)
AS
b number;
BEGIN
SELECT balance INTO b FROM account WHERE accountID = accId;
IF amount <= b THEN
  UPDATE account SET balance = balance-amount WHERE accountId = accId;
END IF;
END;
/

Exec withdraw(5772, 32);