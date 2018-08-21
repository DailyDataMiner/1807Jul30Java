/*create sequence accounts_seq;
create sequence useracc_seq;
CREATE OR REPLACE TRIGGER ba_seq_trig 
BEFORE DELETE ON accounts
FOR EACH ROW 
BEGIN 
    select accounts_seq.nextVal into :new.account_id from dual;
END;
/

CREATE OR REPLACE TRIGGER u_seq_trig 
before insert on USERACC
for each row 
begin 
    select useracc_seq.nextVal into :new.user_id from dual;
end;
/

drop table user2account;*/

ALTER TABLE ACCOUNTS
ADD CONSTRAINT FK_Owner
FOREIGN KEY (USER_ID) REFERENCES USERACC(USER_ID);

INSERT INTO UserAcc(USER_ID,USERNAME,PASSWORD, FIRSTNAME, LASTNAME, EMAIL) 
VALUES(0,'soulfulHannah','8675309','Hannah', 'Williams','Hannah.Williams@Winchester.ac.uk');
INSERT INTO UserAcc(USER_ID,USERNAME,PASSWORD, FIRSTNAME, LASTNAME, EMAIL) 
VALUES(1,'startAtTheBeginning','KatzThaMusicals','Malcolm', 'Catto','popcornBubblefish@discogs.com');
INSERT INTO UserAcc(USER_ID,USERNAME,PASSWORD, FIRSTNAME, LASTNAME, EMAIL) 
VALUES(2,'LateTwoParty','3lectric8oots','Admin', 'One','BitterBenny@znb.com');

INSERT INTO Accounts(ACCOUNT_ID, NAME, TYPE, BALANCE, USER_ID)
VALUES(0,'HannahOneSavings', 'Savings', 7550.14,0);
INSERT INTO Accounts(ACCOUNT_ID, NAME, TYPE, BALANCE, USER_ID)
VALUES(2,'DifferentHatz', 'Checking', 196650.03,1);
INSERT INTO Accounts(ACCOUNT_ID, NAME, TYPE, BALANCE, USER_ID)
VALUES(5,'LORDe', 'Checking', 811,2);
INSERT INTO Accounts(ACCOUNT_ID, NAME, TYPE, BALANCE, USER_ID)
VALUES(6,'MercyMe', 'Savings', 811.02,2);
INSERT INTO Accounts(ACCOUNT_ID, NAME, TYPE, BALANCE, USER_ID)
VALUES(6,'Test', 'Savings', 3000,2);
INSERT INTO Accounts( NAME, TYPE, BALANCE, USER_ID)
VALUES('Foreteen', 'Savings', 14000.36,2);
SELECT * FROM useracc;
SELECT * FROM accounts;

SELECT * FROM useracc WHERE username LIKE 'LateTwoParty' AND password LIKE '3lectric8oots';
SELECT * FROM useracc WHERE username LIKE 'LateTwoParty';

SELECT * FROM accounts WHERE user_id = 2;
SELECT * FROM accounts WHERE user_id = 2 AND name LIKE '%r%';
SELECT * FROM accounts WHERE user_id = 2 AND type LIKE 'Checking';

UPDATE accounts SET balance = 244466666.77 WHERE account_id = 3;
