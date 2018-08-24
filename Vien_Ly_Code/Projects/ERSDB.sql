/*******************************************************************************
   Create Tables
********************************************************************************/
CREATE TABLE Ers_Reimbursements
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
  Ers_Pwd_Hash RAW(16) NOT NULL,
  Ers_Pwd_Salt RAW(16) NOT NULL,
  User_First_Name VARCHAR2(100) NOT NULL,
  User_Last_Name VARCHAR2(100) NOT NULL,
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

/*******************************************************************************
   Create Sequences for ID
********************************************************************************/
CREATE SEQUENCE Ers_Users_Seq;
CREATE SEQUENCE Ers_Reimbursements_Seq;

CREATE OR REPLACE TRIGGER Ers_Users_Seq_Trig
BEFORE INSERT ON Ers_Users
FOR EACH ROW
BEGIN
    SELECT Ers_Users_Seq.NEXTVAL INTO :NEW.Ers_User_Id FROM dual;
END;
/

CREATE OR REPLACE TRIGGER Ers_Reimbursements_Seq_Trig
BEFORE INSERT ON Ers_Reimbursements
FOR EACH ROW
BEGIN
    SELECT Ers_Reimbursements_Seq.NEXTVAL INTO :NEW.Reimb_Id FROM dual;
END;
/

/*******************************************************************************
   Stored procedures
********************************************************************************/
CREATE OR REPLACE PROCEDURE Find_Reimbs_By_Username(Username IN VARCHAR2, cp OUT SYS_REFCURSOR)
AS
BEGIN
  OPEN cp FOR
    SELECT *
    FROM Ers_Reimbursements
    WHERE Reimb_Author = (
      SELECT Ers_User_Id
      FROM Ers_Users
      WHERE Ers_Username = Username
    )
    ORDER BY Reimb_Submitted;
END;
/

CREATE OR REPLACE PROCEDURE Find_Reimbs_By_Status(status IN NUMBER, cp OUT SYS_REFCURSOR)
AS
BEGIN
  OPEN cp FOR
    SELECT *
    FROM Ers_Reimbursements
    WHERE Reimb_Status_Id = status
    ORDER BY Reimb_Submitted;
END;
/

CREATE OR REPLACE PROCEDURE Find_Reimbs_By_Type(type_id IN NUMBER, cp OUT SYS_REFCURSOR)
AS
BEGIN
  OPEN cp FOR
    SELECT *
    FROM Ers_Reimbursements
    WHERE Reimb_Type_Id = type_id
    ORDER BY Reimb_Submitted;
END;
/


/*******************************************************************************
   Set Up Lookup Tables
********************************************************************************/
INSERT INTO Ers_User_Roles(Ers_User_Role_Id, User_Role)
VALUES(1, 'EMPLOYEE');

INSERT INTO Ers_User_Roles(Ers_User_Role_Id, User_Role)
VALUES(2, 'MANAGER');

INSERT INTO Ers_Reimbursement_Type(Ers_Type_Id, Ers_Type)
VALUES(1, 'LODGING');

INSERT INTO Ers_Reimbursement_Type(Ers_Type_Id, Ers_Type)
VALUES(2, 'TRAVEL');

INSERT INTO Ers_Reimbursement_Type(Ers_Type_Id, Ers_Type)
VALUES(3, 'FOOD');

INSERT INTO Ers_Reimbursement_Type(Ers_Type_Id, Ers_Type)
VALUES(4, 'OTHER');

INSERT INTO Ers_Reimbursement_Status(Ers_Status_Id, Ers_Status)
VALUES(1, 'PENDING');

INSERT INTO Ers_Reimbursement_Status(Ers_Status_Id, Ers_Status)
VALUES(2, 'APPROVED');

INSERT INTO Ers_Reimbursement_Status(Ers_Status_Id, Ers_Status)
VALUES(3, 'DENIED');

SELECT * FROM Ers_User_Roles;
SELECT * FROM Ers_Reimbursement_Type;
SELECT * FROM Ers_Reimbursement_Status;

/*******************************************************************************
   Test Entries
********************************************************************************/
INSERT INTO ERS_USERS(Ers_User_Id, Ers_Username, Ers_Pwd_Hash, Ers_Pwd_Salt, User_First_Name, User_Last_name, User_Email, User_Role_Id)
VALUES(1, 'gin', 'a', 'a', 'gin', 'ly', 'gin@ly.com', 2);

INSERT INTO ERS_USERS(Ers_User_Id, Ers_Username, Ers_Pwd_Hash, Ers_Pwd_Salt, User_First_Name, User_Last_name, User_Email, User_Role_Id)
VALUES(5, 'isa', 'b', 'b', 'isa', 'svg', 'isa@svg.com', 1);

INSERT INTO ERS_USERS(Ers_User_Id, Ers_Username, Ers_Pwd_Hash, Ers_Pwd_Salt, User_First_Name, User_Last_name, User_Email, User_Role_Id)
VALUES(5, 'avie', 'c', 'c', 'avery', 'marillier', 'avie@marillier.com', 1);

INSERT INTO Ers_Reimbursements(Reimb_Id, Reimb_Amount, Reimb_Submitted, Reimb_Author, Reimb_Status_Id, Reimb_Type_Id)
VALUES(1111, 24.50, CURRENT_TIMESTAMP, 7, 1, 1);

INSERT INTO Ers_Reimbursements(Reimb_Id, Reimb_Amount, Reimb_Submitted, Reimb_Author, Reimb_Status_Id, Reimb_Type_Id)
VALUES(1111, 77.50, CURRENT_TIMESTAMP, 7, 2, 3);

INSERT INTO Ers_Reimbursements(Reimb_Id, Reimb_Amount, Reimb_Submitted, Reimb_Author, Reimb_Status_Id, Reimb_Type_Id)
VALUES(1111, 12.00, CURRENT_TIMESTAMP, 7, 3, 1);

INSERT INTO Ers_Reimbursements(Reimb_Id, Reimb_Amount, Reimb_Submitted, Reimb_Author, Reimb_Status_Id, Reimb_Type_Id)
VALUES(1111, 99.99, CURRENT_TIMESTAMP, 6, 1, 2);

INSERT INTO Ers_Reimbursements(Reimb_Id, Reimb_Amount, Reimb_Submitted, Reimb_Author, Reimb_Status_Id, Reimb_Type_Id)
VALUES(1111, 399.99, CURRENT_TIMESTAMP, 6, 1, 1);

select * from ers_users;
select * from ers_reimbursements WHERE Reimb_Type_Id = 1;

SELECT u.User_First_Name, u.User_Last_name, r.User_Role
FROM Ers_Users u
JOIN Ers_User_roles r ON u.User_Role_Id = r.Ers_User_Role_Id;

DECLARE
  reimbs SYS_REFCURSOR;
  id NUMBER;
  amount NUMBER;
  submitted TIMESTAMP;
  resolved TIMESTAMP;
  description VARCHAR2(200);
  receipt BLOB;
  author NUMBER;
  resolver NUMBER;
  status NUMBER;
  type_id NUMBER;
BEGIN
  Find_Reimbs_By_Username('isa', reimbs);
  LOOP
  FETCH reimbs INTO id, amount, submitted, resolved, description, receipt, author, resolver, status, type_id;
  EXIT WHEN reimbs%NOTFOUND;
  DBMS_OUTPUT.put_line(id || ' ' || amount || ' ' || submitted || ' ' || author || ' ' || status || ' ' || type_id);
  END LOOP;
  CLOSE reimbs;
END;
/

commit;

alter table ers_reimbursements drop constraint SYS_C007314;

DROP TABLE Ers_Users;

DELETE FROM Ers_Users WHERE Ers_User_Id = 45;

select * from Ers_Users;
select * from Ers_Reimbursements;


commit;

