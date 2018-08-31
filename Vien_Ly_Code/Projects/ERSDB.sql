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

CREATE OR REPLACE PROCEDURE get_reimbursement_details(target_id IN NUMBER, cp OUT SYS_REFCURSOR)
AS
BEGIN
  OPEN cp FOR
    SELECT 
      ri.reimb_id as id,
      ri.reimb_amount as amount,
      ri.reimb_submitted as submittedTime,
      ri.reimb_resolved as resolvedTime,
      ri.reimb_description as description,
      ri.reimb_receipt as receipt,
      author.ers_username as authorUsername,
      author.User_first_name as authorFirstName,
      author.user_last_name as authorLastName,
      resolver.ers_username as resolverUsername,
      resolver.user_first_name as resolverFirstName,
      resolver.user_last_name as resolverLastName,
      rs.Ers_Status as status,
      rt.Ers_Type as typee
    FROM ers_reimbursements ri
    INNER JOIN Ers_Reimbursement_Status rs ON ri.reimb_status_id = rs.Ers_Status_Id 
    INNER JOIN Ers_Reimbursement_Type rt ON ri.reimb_type_id = rt.Ers_Type_Id 
    INNER JOIN Ers_Users author on ri.reimb_author = author.ers_user_id 
    LEFT JOIN Ers_Users resolver on ri.reimb_resolver = resolver.ers_user_id
    WHERE reimb_id = target_id;
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


select * from Ers_Users;
select * from Ers_Reimbursements;

select * from ers_users;
select * from ers_reimbursements WHERE Reimb_Type_Id = 1;

SELECT * FROM Ers_User_Roles;
SELECT * FROM Ers_Reimbursement_Type;
SELECT * FROM Ers_Reimbursement_Status;

SELECT u.User_First_Name, u.User_Last_name, r.User_Role
FROM Ers_Users u
JOIN Ers_User_roles r ON u.User_Role_Id = r.Ers_User_Role_Id;


commit;

