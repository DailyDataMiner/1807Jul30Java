/*
Michael Liu Week 2 Assignment
*/

-------------------------------------2.1 Select
--Task – Select all records from the Employee table.
Select * from Employee;

--Task – Select all records from the Employee table where last name is King
Select * from Employee where lastname like '%King%';

--Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
Select * from Employee where firstname like '%Andrew%' and reportsto is null;

--------------------------------------2.2 Order By
--Task – Select all albums in Album table and sort result set in descending order by title.
Select title from Album 
order by title desc;

--Task – Select first name from Customer and sort result set in ascending order by city.
Select firstname, city 
from Customer 
order by city asc;

-------------------------------------2.3 Insert Into
--Task – Insert two new records into Genre table
Insert into genre (genreid,name)
values (26,'rap');
Insert into genre (genreid,name)
values (27,'silence');

--Task – Insert two new records into Employee table
desc employee; --describe employee
--Select * from Employee;
Insert into Employee values
(
9,
'Liu',
'Michael',
'Web Developer',
2,
'9-SEP-95',
'22-MAY-02',
'3614 Winding Creek Way',
'Winston Salem',
'NC',
'USA',
27106,
'+1 (336) 382 9810',
'+1 (780) 468-3457',
'knispo6781@gmail.com'
);

--Task – Insert two new records into Customer table
select * from customer;
Insert into Customer values
(
60,
'Michael',
'Liu',
'Revature',
'3206 Polo Rd',
'Winston Salem',
'NC',
'USA',
27106,
'+1 336 382 9810',
null,
'knispo6781@gmail.com',
5
);

--------------------------------------2.4 Update
--Task – Update Aaron Mitchell in Customer table to Robert Walter
Update customer
set firstname = 'Robert' , lastname = 'Walter'
where firstname = 'Aaron' AND lastname = 'Mitchell';

--Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
Update artist
set name = 'CCR'
where name = 'Creedence Clearwater Revival';
--select name, artistid from artist where name = 'CCR';

--------------------------------------------------2.5 Like
--Task – Select all invoices with a billing address like “T%”
select * from invoice where billingaddress like 'T%';

-------------------------------------------------2.6 Between
--Task – Select all invoices that have a total between 15 and 50
select * from invoice where total between 15 AND 50;

--Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
select hiredate from employee;
select firstname from employee where hiredate between '01-Jun-03' AND 01-Mar-04;

--------------------------------------------------2.7 Delete
--Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
begin
  Delete from Invoiceline where invoiceid = ANY( --delete dependencies
  select invoiceid from invoice 
  where customerid = any(select customerid from customer 
  where firstname = 'Robert' and lastname = 'Walter')); 
  
  Delete from Invoice where customerid = ANY(
  select customerid from customer 
  where firstname = 'Robert' and lastname = 'Walter'); 
  
  Delete from Customer where firstname = 'Robert' and lastname = 'Walter';
end;
 /
 select * from customer where firstname = 'Robert' and lastname = 'Walter';

------------------------------------------------3. System Defined Functions
--Task – Create a function that returns the current time.
create or replace function get_time return varchar2 
is my_date varchar2(10);
begin
my_date := To_char (SysDate, 'HH:MI:SS');
return my_date;
end;
/
select get_time from dual;
  
--Task – create a function that returns the length of a mediatype from the mediatype table
create or replace function calc_length(name varchar2) 
return number is my_length number(10);
begin
my_length := length(name);
return my_length;
end;
/
select name, calc_length(name) from mediatype;

-------------------------------------3.2 System Defined Aggregate Functions
--Task – Create a function that returns the average total of all invoices
create or replace function avg_invoice
return number is 
my_avg invoice.total%type;
begin
select round(avg(total), 2) into my_avg from invoice;
return my_avg;
end;
/
select avg_invoice from dual; 
select avg(total) from invoice; --just for checking

--Task – Create a function that returns the most expensive track
create or replace function pricey(t_name in varchar2)
return sys_refcursor
is c sys_refcursor;
begin
  open c for
  select name, max(unitprice) from track
  where unitprice = max(unitprice);
return c;
end;
/
select pricey from track order by name;

-------------------------------3.3 User Defined Functions
--Task – Create a function that returns the average price of invoiceline items in the invoiceline table
create or replace function calc_avg_price
return number is calc invoiceline.unitprice%type;
begin
select avg(unitprice) into calc from invoiceline;
return calc;
end;
/ 
select calc_avg_price from dual;

---------------------------3.4 User Defined Table Valued Functions
--Task – Create a function that returns all employees who are born after 1968.

/*create replace functionfunction getYoung(@birthdate date);
returns table;
as 
begin
return
  Select firstname, lastname
  from employee
  where birthdate > '01-Jan-68';
end;*/

---------------------------4.0 Stored Procedures--------------

----------------------4.1 Basic Stored Procedure
--Task – Create a stored procedure that selects the first and last names of all the employees.
/*create or replace type narray as table of number;
Create or replace procedure names(
git out varchar2, git2 out varchar2,
block_count in number, names_array out narray)
As
Begin
  git := narray
  names_array.extend(block_count);
select firstname, lastname into git, git2 from employee;
end;
/*/

execute names;
/*declare
p1 varchar2(200);
p2 varchar2(200);
begin
names(p1, p2);
dbms_output.put_line(p1);
end;
/*/

create or replace procedure get_all_books(cursorParam OUT SYS_REFCURSOR)
is
Begin
  open cursorParam FOR select firstname, lastname from employee;
End;
/

exec get_all_books;

-----------------------------4.2 Stored Procedure Input Parameters
--Task – Create a stored procedure that updates the personal information of an employee
create or replace procedure update_employee(
  x_firstname in employee.firstname%type,
  x_lastname in employee.lastname%type,
  x_employeeid in employee.employeeid%type,
  x_title in employee.title%type,
  x_reportsto in employee.reportsto%type,
  x_birthdate in employee.birthdate%type,
  x_address in employee.address%type,
  x_city in employee.city%type,
  x_state in employee.state%type,
  x_country in employee.country%type,
  x_postalcode in employee.postalcode%type,
  x_phone in employee.phone%type,
  x_fax in employee.fax%type,
  x_email in employee.email%type)
is
  BEGIN
    update employee set firstname = x_firstname where lastname = x_lastname;
end;
/
exec update_employee;

--Task – Create a stored procedure that returns the managers of an employee.
set serveroutput on;
create or replace procedure return_managers(
  x_employeeid in employee.employeeid%type,
  x_reportsto out employee.reportsto%type
  ) 
is
  Begin
    Select reportsto
    Into x_reportsto
    From employee
    Where empoloyeeid = x_employeeid;
  End;
/
 
-------------------------------------4.3 Stored Procedure Output Parameters
--Task – Create a stored procedure that returns the name and company of a customer.



------------------------------------5.0 Transactions
--Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).
Begin
  Delete invoice set invoiceid = null where invoiceid = x_invoiceId
End;
/
--Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table


---------------------------------6.0 Triggers
--Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
Create or Replace Trigger fired
After Insert
  On fired
  for each row
Declare
  x_firstname varchar2(100);
  x_lastname varchar2(100);
Begin
  Select e
Insert into fired
(firstname
  
--Task – Create an after update trigger on the album table that fires after a row is inserted in the table

--Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table












