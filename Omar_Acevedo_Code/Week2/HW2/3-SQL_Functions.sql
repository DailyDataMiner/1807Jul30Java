-- 3.0 SQL Functions
-- In this section you will be using the Oracle system functions, as well as your own functions, to perform various actions against the database
-- 3.1 System Defined Functions


--  Task – Create a function that returns the current time.
create or replace function getCurrTime return date is
begin
    return sysdate;
end;
/

select getCurrTime from dual;


--  Task – create a function that returns the length of a mediatype from the mediatype table
create or replace function getMediaTypeLen( p_mediatypeid number, p_outvar out number ) return number is
    l_medtiatypelen number;
begin
    select length(name) into l_medtiatypelen from mediatype where mediatypeid = p_mediatypeid;
    
    p_outvar := 900;
    --p_outvar := p_outvar + 100;
    
    return l_medtiatypelen;
end;
/
declare
    myVar number;
    myVar2 number;
begin
    
    myVar2 := 100;
    myVar := getMediaTypeLen(1, myVar2);
    
    dbms_output.put_line(' myVar -> ' || myVar);
    dbms_output.put_line(' myVar2 -> ' || myVar2);
    
    --select getMediaTypeLen(mediatypeid) as "Media Type Length" from mediatype;
    
end;
/


--  3.2 System Defined Aggregate Functions
--  Task – Create a function that returns the average total of all invoices
create or replace function getInvoicesAvg return number is
    l_avg invoice.total%type;
begin
    -- v2
    select avg(total) into l_avg from invoice;
    -- v1
    --select sum(total)/count(total) into l_avg from invoice;   -- This is just to confirm and show that avg fn works.
    return l_avg;
end;
/
select getInvoicesAvg from dual;

--  Task – Create a function that returns the most expensive track

create or replace function getMaxValue(p_name out varchar2) return number is
  l_maxvalue number;
begin
  select max(unitprice), name into l_maxvalue, p_name from track;
  return l_maxvalue;
end;
/


select name, unitprice from track where unitprice = ( select max(unitprice) from track );

from track group by unitprice, name order by unitprice desc;

declare
  l_name varchar2;
begin
  select getMaxValue(l_name) from dual;
  dbms_output.put_line(l_name);
end;
/

select * from track
order by unitprice desc;


/* ============================================================================================== */
--  3.3 User Defined Functions
--  Task – Create a function that returns the average price of invoiceline items in the invoiceline table
create or replace function getInvoiceLineAvgPrice return number is
    l_avg invoiceline.unitprice%type;
begin
    -- v2
    select avg(unitprice) into l_avg from invoiceline;
    -- v1
    --select sum(unitprice)/count(unitprice) into l_avg from invoiceline;   -- This is just to confirm and show that avg fn works.
    return l_avg;
end;
/

select getInvoiceLineAvgPrice from dual;


/* ============================================================================================== */
--  3.4 User Defined Table Valued Functions
--  Task – Create a function that returns all employees who are born after 1968.
create or replace function getAllEmpsAfter1968(p_date in date, pc_employee out sys_refcursor) return number is
begin
    open pc_employee for
        select employeeid, title, firstname from employee;
        -- where birthdate ... p_date ...
        --where to_date(birthdate, 'DD/MON/YYYY') > to_date('01/JAN/1968', 'DD/MON/YYYY');
        
        /*
            select to_char(birthdate, 'DD/MON/YYYY') from employee;
            
            select to_char(birthdate, 'DD/MON/YYYY'), to_date(to_char(birthdate, 'DD/MON/YYYY')) 
            from employee
            where 
            to_date(to_char(birthdate, 'DD/MON/YYYY')) = to_date(to_char('01/MAY/1990', 'DD/MON/YYYY'));
            
            select * from employee where to_date(birthdate, 'DD/MON/YYYY') > to_date('01/JAN/1968', 'DD/MON/YYYY');
        */
        
    return 1;
end;
/

declare
    l_aNumber number;
    l_aDate date;
    l_aCursor sys_refcursor;
    l_employeeid employee.employeeid%type;
    l_title employee.title%type;
    l_firstname employee.firstname%type;
    -- and/or use a employee%recordtype... ?
begin
    l_aNumber := getAllEmpsAfter1968(l_aDate, l_aCursor);
    loop
        fetch l_aCursor into l_employeeid, l_title, l_firstname;
        exit when l_aCursor%notfound;
        dbms_output.put_line( l_employeeid || ', '  || l_title || ', '  ||  l_firstname );
    end loop;
    close l_aCursor;
end;
/
