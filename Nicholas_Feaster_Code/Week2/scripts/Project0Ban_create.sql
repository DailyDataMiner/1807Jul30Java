-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2018-08-13 18:10:32.62

-- tables
-- Table: accounts
CREATE TABLE accounts (
    account_id integer  NOT NULL,
    name varchar2(255)  NOT NULL,
    type varchar2(255) NOT NULL,
    balance NUMBER(14,2)  NOT NULL,
    user_id integer NOT NULL,
    CONSTRAINT accounts_pk PRIMARY KEY (account_id)
) ;

-- Table: users
CREATE TABLE userAcc (
    user_id integer  NOT NULL,
    username varchar2(255) UNIQUE  NOT NULL,
    password varchar2(255)  NOT NULL,
    firstname varchar2(255)  NOT NULL,
    lastname varchar2(255)  NOT NULL,
    email varchar2(255)  NOT NULL,
    CONSTRAINT user_pk PRIMARY KEY (user_id)
) ;

-- Table: user2account
/*CREATE TABLE user2account (
    user_id integer  NOT NULL,
    account_id integer  NOT NULL,
    CONSTRAINT user2account_pk PRIMARY KEY (user_id,account_id)
) ;

ALTER TABLE user2account
	ADD CONSTRAINT FK_ePluribusUsers
	FOREIGN KEY (user_id) REFERENCES userAcc(user_id);

ALTER TABLE user2account
	ADD CONSTRAINT FK_ePluribusAccounts
	FOREIGN KEY (account_id) REFERENCES accounts(account_id);


Should I cacacade on delete this time? 



ALTER TABLE user2account
	ADD CONSTRAINTS FK_ePluribusUsers
	FOREIGN KEY (user_id) REFERENCES (userAcc.user_id)
	ON DELETE CASCADE;

ALTER TABLE user2account
	ADD CONSTRAINTS FK_ePluribusAccounts
	FOREIGN KEY (account_id) REFERENCES (account.account_id)
	ON DELETE CASCADE;
	*/
	
CREATE OR REPLACE TRIGGER acc_seq_trig 
before insert on accounts
for each row 
begin 
    select accounts_seq.nextVal into :new.account_id from dual;
end;
/

CREATE OR REPLACE TRIGGER useracc_seq_trig 
before insert on accounts
for each row 
begin 
    select useracc_seq.nextVal into :new.user_id from dual;
end;
/

ALTER TABLE accounts
ADD (balanceAmount NUMBER(14,2));

UPDATE accounts SET balanceAmount = balance;

ALTER TABLE accounts
DROP COLUMN balance;

ALTER TABLE accounts
RENAME COLUMN balanceAmount to balance;
    
-- End of file.

