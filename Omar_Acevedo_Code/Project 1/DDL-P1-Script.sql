/*
    Project 1 DDL script
        - This will create tables, and respective sequence and triggers for each created table in db.
*/

/*  
    Create User Roles table         */
    
CREATE TABLE P1_USER_ROLES (	

    USER_ROLE_ID  NUMBER NOT NULL ENABLE, 
    ROLENAME     VARCHAR2(40 BYTE) NOT NULL ENABLE UNIQUE, 

    CONSTRAINT P1_PK_USER_ROLE_ID PRIMARY KEY (USER_ROLE_ID)
    
);

-- Create User Roles table sequence
CREATE SEQUENCE P1_USER_ROLES_SEQ;

-- Create User Roles table trigger (BI)
CREATE OR REPLACE TRIGGER P1_BI_USER_ROLES_TRIG
    BEFORE INSERT ON P1_USER_ROLES
    FOR EACH ROW
    BEGIN
        IF :NEW.USER_ROLE_ID IS NULL THEN
            SELECT P1_USER_ROLES_SEQ.NEXTVAL INTO :NEW.USER_ROLE_ID FROM DUAL;
        END IF;
    END;
/

/*  
    Create Users table         */
CREATE TABLE P1_USERS (
    USER_ID          NUMBER NOT NULL ENABLE, 
    USERNAME     VARCHAR2(40 BYTE) NOT NULL ENABLE UNIQUE,
    PASSWORD    VARCHAR2(20 BYTE) NOT NULL ENABLE, 
    FIRSTNAME    VARCHAR2(60 BYTE) NOT NULL ENABLE,
    LASTNAME     VARCHAR2(60 BYTE) NOT NULL ENABLE,
    EMAIL           VARCHAR2(60 BYTE) NOT NULL ENABLE UNIQUE, 
    USER_ROLE_ID NUMBER,
    
    CONSTRAINT P1_PK_USERS PRIMARY KEY (USER_ID),
    CONSTRAINT P1_FK_USER_ROLES FOREIGN KEY (USER_ROLE_ID)
    REFERENCES P1_USER_ROLES (USER_ROLE_ID)
);
  
  -- Create Users table sequence
CREATE SEQUENCE P1_USERS_SEQ;

-- Create Users table trigger (BI)
CREATE OR REPLACE TRIGGER P1_BI_USERS_TRIG
    BEFORE INSERT ON P1_USERS
    FOR EACH ROW
    BEGIN
        IF :NEW.USER_ID IS NULL THEN
            SELECT P1_USERS_SEQ.NEXTVAL INTO :NEW.USER_ID FROM DUAL;
        END IF;
    END;
/

/*  
    Create Reimbursement Status table         */
CREATE TABLE P1_REIMBURSEMENT_STATUS (
    REIMBURSEMENT_STATUS_ID          NUMBER NOT NULL ENABLE, 
    REIMBURSEMENT_STATUS_NAME     VARCHAR2(40 BYTE) NOT NULL ENABLE UNIQUE,
    
    CONSTRAINT P1_PK_REIMBURSEMENT_STATUS PRIMARY KEY (REIMBURSEMENT_STATUS_ID)
);

-- Create Reimbursement Status table sequence
CREATE SEQUENCE P1_REIMBURSEMENT_STATUS_SEQ;

-- Create Reimbursement Status table trigger (BI)
CREATE OR REPLACE TRIGGER P1_BI_REIMB_STATUS_TRIG
    BEFORE INSERT ON P1_REIMBURSEMENT_STATUS
    FOR EACH ROW
    BEGIN
        IF :NEW.REIMBURSEMENT_STATUS_ID IS NULL THEN
            SELECT P1_REIMBURSEMENT_STATUS_SEQ.NEXTVAL INTO :NEW.REIMBURSEMENT_STATUS_ID FROM DUAL;
        END IF;
    END;
/

/*  
    Create Reimbursement Types table         */
CREATE TABLE P1_REIMBURSEMENT_TYPES (
    REIMBURSEMENT_TYPE_ID          NUMBER NOT NULL ENABLE, 
    REIMBURSEMENT_TYPE_NAME     VARCHAR2(40 BYTE) NOT NULL ENABLE UNIQUE,
    
    CONSTRAINT P1_PK_REIMBURSEMENT_TYPES PRIMARY KEY (REIMBURSEMENT_TYPE_ID)
);

-- Create Reimbursement Types  table sequence
CREATE SEQUENCE P1_REIMBURSEMENT_TYPES_SEQ;

-- Create Reimbursement Types  table trigger (BI)
CREATE OR REPLACE TRIGGER P1_BI_REIMB_TYPES_TRIG
    BEFORE INSERT ON P1_REIMBURSEMENT_TYPES
    FOR EACH ROW
    BEGIN
        IF :NEW.REIMBURSEMENT_TYPE_ID IS NULL THEN
            SELECT P1_REIMBURSEMENT_TYPES_SEQ.NEXTVAL INTO :NEW.REIMBURSEMENT_TYPE_ID FROM DUAL;
        END IF;
    END;
/

/*  
    Create Tickets table         */
CREATE TABLE P1_TICKETS ( 
    TICKET_ID                   NUMBER NOT NULL ENABLE,
    TYPE                          VARCHAR2(20 BYTE) DEFAULT 'REIMBURSEMENT',
    STATUS                      VARCHAR2(10 BYTE) DEFAULT 'OPEN', -- OPEN / CLOSED
    CREATED_ON               DATE NOT NULL ENABLE,   -- SUBMITTED DATE
    CREATED_BY               NUMBER NOT NULL ENABLE, -- AUTHOR; USER_ID
    UPDATED_ON              DATE,
    UPDATED_BY              NUMBER,
    REIMBURSEMENT_ID     NUMBER,
    
    CONSTRAINT P1_PK_TICKETS PRIMARY KEY (TICKET_ID),
    
    CONSTRAINT P1_FK_TICKET_CREATEDBY_USER FOREIGN KEY (CREATED_BY)
        REFERENCES P1_USERS (USER_ID),
    
    CONSTRAINT P1_FK_TICKET_UPDATEDBY_USER FOREIGN KEY (UPDATED_BY)
        REFERENCES P1_USERS (USER_ID)
);

-- Create Tickets table sequence
CREATE SEQUENCE P1_TICKETS_SEQ;

-- Create Tickets table trigger (BI)
CREATE OR REPLACE TRIGGER P1_BI_TICKETS_TRIG
    BEFORE INSERT ON P1_TICKETS
    FOR EACH ROW
    BEGIN
        IF :NEW.TICKET_ID IS NULL THEN
            SELECT P1_TICKETS_SEQ.NEXTVAL INTO :NEW.TICKET_ID FROM DUAL;
        END IF;
        
        IF :NEW.CREATED_ON IS NULL THEN
            SELECT SYSDATE INTO :NEW.CREATED_ON FROM DUAL;
        END IF;
        
    END;
/

/*  
    Create Reimbursement table         */
CREATE TABLE P1_REIMBURSEMENTS (        -- This is (also) really a request for reimb. (but remember, this is v1)
    REIMBURSEMENT_ID          NUMBER NOT NULL ENABLE, 
    NAME                            VARCHAR2(40 BYTE),
    DESCRIPTION                  VARCHAR2(100 BYTE) NOT NULL,
    AMOUNT                        NUMBER(10, 2) NOT NULL ENABLE,
    CREATED_ON                  DATE NOT NULL ENABLE,   -- SUBMITTED
    UPDATED_ON                  DATE,
    CREATED_BY                  NUMBER NOT NULL ENABLE, -- AUTHOR; USER_ID
    APPROVED_DENIED_BY     NUMBER, -- RESOLVER; USER_ID 
    APPROVED_DENIED_ON     DATE,
    REIMBURSEMENT_TYPE_ID NUMBER NOT NULL ENABLE,
    REIMBURSEMENT_STATUS_ID NUMBER NOT NULL ENABLE,
    RECEIPT                        BLOB,    -- RECEIPT IMAGE
    TICKET_ID                      NUMBER NOT NULL ENABLE,
    
    CONSTRAINT P1_PK_REIMBURSEMENTS PRIMARY KEY (REIMBURSEMENT_ID),
    
    CONSTRAINT P1_FK_REIMBURSEMENT_USERS FOREIGN KEY (CREATED_BY)
        REFERENCES P1_USERS (USER_ID),
        
    CONSTRAINT P1_FK_REIMBURSEMENT_TYPES FOREIGN KEY (REIMBURSEMENT_TYPE_ID)
        REFERENCES P1_REIMBURSEMENT_TYPES (REIMBURSEMENT_TYPE_ID),
    
    CONSTRAINT P1_FK_REIMBURSEMENT_STATUS FOREIGN KEY (REIMBURSEMENT_STATUS_ID)
        REFERENCES P1_REIMBURSEMENT_STATUS (REIMBURSEMENT_STATUS_ID),
        
    CONSTRAINT P1_FK_REIMBURSEMENT_TICKETS FOREIGN KEY (TICKET_ID)
        REFERENCES P1_TICKETS (TICKET_ID)
        
);

-- Create Reimbursement table sequence
CREATE SEQUENCE P1_REIMBURSEMENTS_SEQ;

-- Create Reimbursement table trigger (BI)
CREATE OR REPLACE TRIGGER P1_BI_REIMBURSEMENTS_TRIG
    BEFORE INSERT ON P1_REIMBURSEMENTS
    FOR EACH ROW
    BEGIN
        IF :NEW.REIMBURSEMENT_ID IS NULL THEN
            SELECT P1_REIMBURSEMENTS_SEQ.NEXTVAL INTO :NEW.REIMBURSEMENT_ID FROM DUAL;
        END IF;
    END;
/