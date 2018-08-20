/*******************************************************************************
   Create Tables
********************************************************************************/
CREATE TABLE Ers_Reimbursement
(
  Reimb_Id NUMBER(10, 0) PRIMARY KEY,
  Reimb_Amount NUMBER(10, 2) NOT NULL,
  Reimb_Submitted TIMESTAMP NOT NULL,
  Reimb_Resolved TIMESTAMP,
  Reimb_Description VARCHAR2(250),
  Reimb_Receipt BLOB,
  Reimb_Author NUMBER(10,0) NOT NULL REFERENCES Ers_Users(Ers_User_Id),
  Reimb_Resolver NUMBER(10, 0) REFERENCES Ers_Users(Ers_User_Id),
  Reimb_Status_Id NUMBER(10, 0) NOT NULL REFERENCES Ers_Reimbursement_Status(Ers_Status_Id),
  Reimb_Type_Id NUMBER(10, 0) NOT NULL REFERENCES Ers_Reimbursement_Type(Ers_Type_Id)
);

CREATE TABLE Ers_Users
(
  Ers_User_Id NUMBER(10, 0) PRIMARY KEY,
  Ers_Username VARCHAR2(50) UNIQUE NOT NULL,
  Ers_Password VARCHAR2(50) NOT NULL,
  User_First_Name VARCHAR2(100) NOT NULL,
  User_Last_name VARCHAR2(100) NOT NULL,
  User_Email VARCHAR2(250) UNIQUE NOT NULL,
  User_Role_Id NUMBER(10, 0) NOT NULL REFERENCES Ers_User_Roles(Ers_User_Role_Id)
);

CREATE TABLE Ers_Reimbursement_Status
(
  Ers_Status_Id NUMBER(10, 0) PRIMARY KEY,
  Ers_Status VARCHAR2(10) NOT NULL
);

CREATE TABLE Ers_Reimbursement_Type
(
  Ers_Type_Id NUMBER(10, 0) PRIMARY KEY,
  Ers_Type VARCHAR2(10) NOT NULL
);

CREATE TABLE Ers_User_Roles
(
  Ers_User_Role_Id NUMBER(10, 0) PRIMARY KEY,
  User_Role VARCHAR2(10) NOT NULL
);

DROP TABLE Ers_Users;
DROP TABLE Ers_Reimbursement;


