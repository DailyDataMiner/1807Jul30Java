select * from p0_transactions 
order by transactionid desc;

select * from p0_account_accounttype 
where ACCOUNT_ACCOUNTTYPEID = 2;

select * from p0_accounts 
where accountid = 2;

select * from p0_users 
where userid = ;

select  usr.username || ' ( ' || usr.email || ') ',
          accounts.account_number, accounts.status,
          (select accounttypes.name from p0_accounttypes accounttypes where accounttypes.accounttypesid = ) as 'Account Type'
from          p0_transactions             transactions
inner join   p0_account_accounttype juntionAccounts
on             transactions.account_accounttypeid  = juntionAccounts.account_accounttypeid
inner join   p0_accounts                   accounts 
on             accounts.accountid                          = juntionAccounts.accountid
inner join   p0_users                       usr
on             usr.userid                                       = accounts.userid
where        accounts.status = 'OPEN';





select * from p0_accounts
select * from p0_account_accounttype




create table myTable as select * from p0_accounts;

declare
   myVar number;
begin
  dbms_output.put_line('Enter a value -> ');
  myVar := :something;
  dbms_output.put_line('this is your value -> ' || myVar);
end;
/

  CREATE OR REPLACE TRIGGER MYTRIG
    BEFORE INSERT ON myTable
    FOR EACH ROW
    BEGIN
        IF :NEW.accountid IS NULL THEN
            SELECT P0_PERSONS_SEQ.NEXTVAL INTO :NEW.accountid FROM DUAL;
        END IF;
    END;
    
    select * from myTable;