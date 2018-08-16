/*******************************************************************************
   Create database
********************************************************************************/
CREATE USER bank
IDENTIFIED BY bank;

GRANT connect to bank;
GRANT resource to bank;

select * from dba_profiles;
