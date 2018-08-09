/*******************************************************************************
   Create Tables
********************************************************************************/
CREATE TABLE account
(
  AccountId NUMBER NOT NULL,
  Balance NUMBER(32,2) NOT NULL,
  CONSTRAINT PK_AccountId PRIMARY KEY (AccountId)
);

CREATE TABLE customer
(
  CustomerId NUMBER NOT NULL,
  FirstName VARCHAR2(20) NOT NULL,
  LastName VARCHAR2(20) NOT NULL,
  UserName VARCHAR2(40) NOT NULL,
  PwdSalt BINARY(64) NOT NULL,
  PwdHash BINARY(64) NOT NULL,
  CONSTRAINT PK_CustomerId PRIMARY KEY (CustomerId)
);

/*******************************************************************************
   Create Foreign Keys
********************************************************************************/
ALTER TABLE account 