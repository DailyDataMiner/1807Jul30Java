select * from v$instance;
alter pluggable database pdborcl open read write;
alter session set container=pdborcl;

CREATE USER chinook
IDENTIFIED BY p4ssw0rd
DEFAULT TABLESPACE users
TEMPORARY TABLESPACE temp
QUOTA 10M ON users;

GRANT connect to chinook;
GRANT resource to chinook;
GRANT create session TO chinook;
GRANT create table TO chinook;
GRANT create view TO chinook;