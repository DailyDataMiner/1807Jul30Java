-- User information
CREATE TABLE UserInfo
(
  User_ID number(10) PRIMARY KEY,
  First_Name varchar2(50) NOT NULL,
  Last_Name varchar2(50) NOT NULL,
  User_Name varchar2(50) UNIQUE NOT NULL,
  Pass_Word varchar2(50) UNIQUE NOT NULL
);

-- Defines a specific account type
CREATE TABLE Account
(
  Account_ID number(10) PRIMARY KEY,
  Type VARCHAR2(50) NOT NULL,
  Balance number(8,2),
  User_ID number(10),
  CONSTRAINT fk_user_account FOREIGN KEY(User_ID)
      REFERENCES UserInfo(User_ID)
);

-- Sequences to add unique values to user and account ids
CREATE SEQUENCE user_seq
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;

CREATE SEQUENCE acc_seq
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;

-- Triggers to increment id numbers
CREATE OR REPLACE TRIGGER u_i_seq_trig
BEFORE INSERT ON UserInfo
FOR EACH ROW
BEGIN
  SELECT user_seq.nextVal INTO :new.User_ID FROM dual;
END;
/

CREATE OR REPLACE TRIGGER a_seq_trig
BEFORE INSERT ON Account
FOR EACH ROW
BEGIN
  SELECT acc_seq.nextVal INTO :new.Account_ID FROM dual;
END;
/

CREATE OR REPLACE PROCEDURE findUsersAccounts(u_id in number, cursorParam out SYS_REFCURSOR)
is
begin
  open cursorParam for select * from account where user_id = u_id;
end;
/