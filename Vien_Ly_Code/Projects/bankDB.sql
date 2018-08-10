/*******************************************************************************
   Create Tables
********************************************************************************/
CREATE TABLE Account
(
  AccountId NUMBER NOT NULL,
  Balance NUMBER(32,2) NOT NULL,
  CustomerId NUMBER NOT NULL,
  CONSTRAINT PK_AccountId PRIMARY KEY (AccountId)
);

CREATE TABLE ClosedAccount
(
  ClosedAccountId NUMBER NOT NULL,
  CustomerId NUMBER NOT NULL,
  CONSTRAINT PK_ClosedAccountId PRIMARY KEY (ClosedAccountId)
);
 
CREATE TABLE Customer
(
  CustomerId NUMBER NOT NULL,
  FirstName VARCHAR2(20) NOT NULL,
  LastName VARCHAR2(20) NOT NULL,
  UserName VARCHAR2(40) NOT NULL,
  PwdHash VARCHAR2(128) NOT NULL,
  CONSTRAINT PK_CustomerId PRIMARY KEY (CustomerId)
);

/*******************************************************************************
   Create Foreign Keys
********************************************************************************/
ALTER TABLE Account ADD CONSTRAINT FK_AccountCustomerId
  FOREIGN KEY (CustomerId) REFERENCES Customer (CustomerId);

ALTER TABLE ClosedAccount ADD CONSTRAINT FK_ClosedAccountCustomerId
  FOREIGN KEY (CustomerId) REFERENCES Customer (CustomerId);
  
/*******************************************************************************
   Create Sequences
********************************************************************************/
CREATE SEQUENCE account_seq;
CREATE SEQUENCE closedaccount_seq;
CREATE SEQUENCE customer_seq;

CREATE OR REPLACE TRIGGER account_seq_trig
BEFORE INSERT ON Account
FOR EACH ROW
BEGIN
    SELECT account_seq.NEXTVAL INTO :NEW.AccountId FROM dual;
END;
/

CREATE OR REPLACE TRIGGER closedaccount_seq_trig
BEFORE INSERT ON ClosedAccount
FOR EACH ROW
BEGIN
    SELECT closedaccount_seq.NEXTVAL INTO :NEW.ClosedAccountId FROM dual;
END;
/
CREATE OR REPLACE TRIGGER customer_seq_trig
BEFORE INSERT ON Customer
FOR EACH ROW
BEGIN
    SELECT customer_seq.NEXTVAL INTO :NEW.CustomerId FROM dual;
END;
/

/*******************************************************************************
   Triggers
********************************************************************************/

CREATE OR REPLACE TRIGGER Closing_Account
BEFORE DELETE ON Account
FOR EACH ROW
BEGIN
  INSERT INTO ClosedAccount (CustomerId)
  VALUES(:old.CustomerId);
end;
/

/*******************************************************************************
   Stored procedures
********************************************************************************/

CREATE OR REPLACE PROCEDURE Get_All_Customer_Account(cp OUT SYS_REFCURSOR, custId NUMBER)
IS
BEGIN
  OPEN cp FOR SELECT * FROM Account WHERE CustomerId = custId;
END;
/

CREATE OR REPLACE PROCEDURE Get_All_Account(cp OUT SYS_REFCURSOR)
IS
BEGIN
  OPEN cp FOR SELECT * FROM Account;
END;
/
  
CREATE OR REPLACE PROCEDURE Get_All_ClosedAccount(cp OUT SYS_REFCURSOR)
IS
BEGIN
  OPEN cp FOR SELECT * FROM ClosedAccount;
END;
/

CREATE OR REPLACE PROCEDURE Get_All_Customer(cp OUT SYS_REFCURSOR)
IS
BEGIN
  OPEN cp FOR SELECT * FROM Customer;
END;
/

commit;

select * from customer;  
select * from account where customerid = 5;  

variable rc REFCURSOR;
exec Get_All_Customer_Account(:rc, 5);
print rc;