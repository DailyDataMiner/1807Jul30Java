--This database will contain user login information and withdraw and deposit info

CREATE TABLE Client
(
    CustomerId NUMBER NOT NULL PRIMARY KEY,
    FirstName VARCHAR2(40) NOT NULL,
    LastName VARCHAR2(40) NOT NULL,
    StreetAddress VARCHAR2(70),
    City VARCHAR2(40),
    State VARCHAR2(2),
    Country VARCHAR2(40),
    Zip VARCHAR2(10),
    Phone VARCHAR2(24),
    Email VARCHAR2(60) not null
);

CREATE TABLE UserClient
(
  CustomerId NUMBER NOT NULL PRIMARY KEY,
  Username VARCHAR2(100) UNIQUE NOT NULL,
  Password VARCHAR(100) NOT NULL,
  FOREIGN KEY (CustomerId) REFERENCES Client(CustomerId)
);

--alter table userclient
--add constraint username_unique unique (username);

CREATE TABLE Money_Account
(
  AccountId NUMBER NOT NULL PRIMARY KEY,
  SavingsBalance DECIMAL (20, 2) DEFAULT 0.00,
  CheckingBalance DECIMAL (20, 2) DEFAULT '0.00'
);

--join table
CREATE TABLE Customer_Account_ref
(
  CustomerId NUMBER NOT NULL,
  AccountId NUMBER NOT NULL,
  FOREIGN KEY (CustomerId) REFERENCES Client(CustomerId),
  FOREIGN KEY (AccountId) REFERENCES Money_Account(AccountId)
);

CREATE TABLE Transactions
(
  txId NUMBER NOT NULL PRIMARY KEY,
  AccountId NUMBER NOT NULL,
  time_stamp  TIMESTAMP,
  Amount DECIMAL (20, 2) NOT NULL,
  Description VARCHAR(40),
  FOREIGN KEY (AccountId) REFERENCES Money_Account(AccountId)
);


--drop table money_account;
--drop table transactions;
--drop table customer_account_ref;
--drop table client;
--drop table userclient;

commit;

--checks if username already exists in database
create or replace function doesExist (username_in IN varchar2)
return number is res number := -1;
Begin
  for c1 in (select 1 from UserClient where username = username_in and rownum = 1) loop
  res := 1;
  exit;
  end loop;
  return(res);
End;
/

drop sequence userclient_seq;

CREATE SEQUENCE userCLIENT_SEQ
start with 1
MINVALUE	1
MAXVALUE	9999999999999999999999999999
CACHE	20;

select client_seq.nextval from dual;

 CREATE OR REPLACE TRIGGER CLIENT_TRIG
   BEFORE INSERT ON CLIENT
   FOR EACH ROW
   BEGIN
       IF :NEW.CUSTOMERID IS NULL THEN
           SELECT CLIENT_SEQ.NEXTVAL INTO :NEW.CUSTOMERID FROM DUAL;
       END IF;
   END;

/
ALTER TRIGGER CLIENT_TRIG ENABLE;

CREATE SEQUENCE USERCLIENT_SEQ;

 CREATE OR REPLACE TRIGGER USERCLIENT_TRIG
   BEFORE INSERT ON USERCLIENT
   FOR EACH ROW
   BEGIN
       IF :NEW.CUSTOMERID IS NULL THEN
           SELECT USERCLIENT_SEQ.NEXTVAL INTO :NEW.CUSTOMERID FROM DUAL;
       END IF;
   END;

/
ALTER TRIGGER USERCLIENT_TRIG ENABLE;

CREATE SEQUENCE money_account_SEQ;

 CREATE OR REPLACE TRIGGER money_TRIG
   BEFORE INSERT ON money_account
   FOR EACH ROW
   BEGIN
       IF :NEW.CUSTOMERID IS NULL THEN
           SELECT money_SEQ.NEXTVAL INTO :NEW.CUSTOMERID FROM DUAL;
       END IF;
   END;
/
ALTER TRIGGER Money_TRIG ENABLE;

create or replace procedure get_max_custid (ou out number)
as
begin
  Select max(customerid) into ou
  from client;
  
end;
/
declare
 l_myId number;
begin
 get_max_custid(l_myId);
 dbms_output.put_line(l_myId);
end;
/

select count(*) from userclient where username = 'bob';

create or replace trigger add_ref
  after insert on client
  for each row
  begin
    select 
  end;
  /

truncate table userclient;
truncate table client;

Insert into Client (CustomerId, firstname, lastname, streetaddress, city, state, country, email) 
            values (1, 'Michael', 'Liu', '3206 Polo Rd', 'Winston Salem', 'NC', 'USA', 'knispo6781@gmail.com'); 
            
Insert into Client (CustomerId, firstname, lastname, streetaddress, city, state, country, email) 
            values (2, 'nichael', 'Liu', '5206 Polo Rd', 'Miami', 'FL', 'USA', 'gnispo6781@gmail.com'); 
            
Insert into UserClient values (1, 'fick', 'blip');

drop table transactions;

alter table Userclient
drop constraint Username_unique;

commit;  
            
select * from userclient;
select * from client;

select password from userclient where username = 'mike';






