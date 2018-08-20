---------------------------------------------------------------
-----------------------Client
----------------------------------------------------------------

create table Client
(
  UserId NUMBER NOT NULL PRIMARY KEY,
  FirstName VARCHAR2(50) NOT NULL,
  LastName VARCHAR2(50) NOT NULL,
  Username VARCHAR (100) NOT NULL,
  Password VARCHAR (100) NOT NULL
);

CREATE sequence client_seq;
/
CREATE OR REPLACE TRIGGER CLIENT_TRIG
   BEFORE INSERT ON Client
   FOR EACH ROW
   BEGIN
           SELECT CLIENT_SEQ.NEXTVAL INTO :NEW.CUSTOMERID FROM DUAL;
 
   END;
  /
ALTER TRIGGER CLIENT_TRIG ENABLE;

---------------------------------------------------------------
-----------------------Account
----------------------------------------------------------------

create table Account
(
  UserId NUMbER NOT NULL, 
  AccName VARCHAR(40) NOT NULL,
  AccType VARCHAR(10) NOT NULL,
  Balance NUMBER (32,2) DEFAULT 0.00,  
  FOREIGN KEY (UserId) REFERENCES Client(UserId)
  on Delete Cascade
);

CREATE sequence account_seq;

drop trigger account_trig;
/
CREATE OR REPLACE TRIGGER Account_TRIG
   BEFORE INSERT ON Account
   FOR EACH ROW
   BEGIN
       IF :NEW.userID IS NULL THEN
           SELECT account_SEQ.NEXTVAL INTO :NEW.userID FROM DUAL;
       END IF;
       
   END;
   /
ALTER TRIGGER account_TRIG ENABLE;

select account_seq.nextval from dual;


drop trigger client_trig;
drop sequence client_seq;
drop trigger account_trig;
drop sequence account_seq;

select * from account;
select * from client where username = 'Mike' and password = 'Bomberman';
--drop table account;
commit;

insert into client values(2, 'michael', 'liu', 'gimp', 'dip');
select username, password from Client where username = 'gimp' and password = 'dip';
select * from client order by username asc;

select username, password from client where username = 'gimp' and password = 'dip';
select * from Client where username = 'gimp' and password = 'dip';


Insert into account (UserId, AccName, AccType) values (1, 'fuck', 'checking');
select * from account;

--delete from client;
select * from client;
select * from account;


update account
set Balance = 3
where userid = 3 and accname = 'ls';

drop sequence client_seq;


commit;