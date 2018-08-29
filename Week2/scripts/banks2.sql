CREATE USER bank2
IDENTIFIED BY bank2;

GRANT CONNECT to bank2;
GRANT RESOURCE to bank2;

CREATE SEQUENCE client_seq
minvalue 1
start with 1
increment by 1
cache 5;

CREATE SEQUENCE account_seq
minvalue 1
start with 1
increment by 1
cache 5;

CREATE OR REPLACE TRIGGER client_seq_trig 
before insert on client
for each row 
begin 
    select client_seq.nextVal into :new.client_id from dual;
end;
/

CREATE OR REPLACE TRIGGER account_seq_trig 
before insert on account
for each row 
begin 
    select account_seq.nextVal into :new.account_id from dual;
end;
/

INSERT INTO account_type (account_type_id, account_type)
VALUES (1, 'Checkings');
INSERT INTO account_type (account_type_id, account_type)
VALUES (2, 'Savings');

INSERT INTO account (account_id, balance, account_type_id)
VALUES (1, 0, 1);

INSERT INTO client (client_first_name, client_last_name, username, password)
VALUES ('John', 'Higgins', 'jhiggs', 'password');
INSERT INTO client (client_first_name, client_last_name, username, password)
VALUES ('Joe', 'Shmoe', 'jsmores', 'password');

select * from client;
delete from client where ACCOUNT_ID = 3;
commit;