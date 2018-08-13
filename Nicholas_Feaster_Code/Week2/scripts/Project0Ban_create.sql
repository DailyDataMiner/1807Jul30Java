-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2018-08-13 18:10:32.62

-- tables
-- Table: accounts
CREATE TABLE accounts (
    account_id integer  NOT NULL,
    balance integer  NOT NULL,
    name varchar2(255)  NOT NULL,
    CONSTRAINT accounts_pk PRIMARY KEY (account_id)
) ;

-- Table: users
CREATE TABLE userAcc (
    user_id integer  NOT NULL,
    username varchar2(255)  NOT NULL,
    password varchar2(255)  NOT NULL,
    firstname varchar2(255)  NOT NULL,
    lastname varchar2(255)  NOT NULL,
    email varchar2(255)  NOT NULL,
    CONSTRAINT user_pk PRIMARY KEY (user_id)
) ;

-- Table: user2account
CREATE TABLE user2account (
    user_id integer  NOT NULL,
    account_id integer  NOT NULL,
    CONSTRAINT user2account_pk PRIMARY KEY (user_id,account_id)
) ;

ALTER TABLE user2account
	ADD CONSTRAINT FK_ePluribusUsers
	FOREIGN KEY (user_id) REFERENCES userAcc(user_id);

ALTER TABLE user2account
	ADD CONSTRAINT FK_ePluribusAccounts
	FOREIGN KEY (user2account.account_id) REFERENCES accounts(account_id);

/*
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
	
-- End of file.

