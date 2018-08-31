DROP USER C##PZERO CASCADE;

CREATE USER C##PZERO
IDENTIFIED BY p4ssw0rd
DEFAULT TABLESPACE users
TEMPORARY TABLESPACE temp
QUOTA 10M ON users;

GRANT connect to C##PZERO;
GRANT resource to C##PZERO;
GRANT create session TO C##PZERO;
GRANT create table TO C##PZERO;
GRANT create view TO C##PZERO;



conn C##PZERO/p4ssw0rd

COMMIT;
EXIT;