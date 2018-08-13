/*
  Ryan Posey Week 2 Assignment
*/

------------------------------------------------------------ 2.0 SQL Queries

---------------------2.1 Select
--Task - Select all records from the Employee Table
SELECT * FROM Employee;

--Task - Select all records from the Employee table where last name is King.
SELECT * FROM Employee WHERE lastname = 'King';

--Task - Select all records from the Employee table where first name is Andrew and REPORTSTO is null
SELECT * FROM Employee WHERE firstname = 'Andrew' and REPORTSTO IS NULL;

---------------------2.2 Order By
--Task - Select all albums in albums table and sort result set in descending order by title
SELECT * FROM Album ORDER BY title DESC;

--Task - Select first name from Customer and sort result set in ascending order by city
SELECT firstname FROM Customer ORDER BY city ASC;

---------------------2.3 Insert Into
--Task - Insert two new records into Genre table
INSERT INTO genre VALUES (26, 'Chiptune');
INSERT INTO genre VALUES (27, 'Dubstep');

-- Task – Insert two new records into Employee table
INSERT INTO employee 
VALUES (9, 'Andrews', 'Matthew', 'Sales Support Agent', 2, '08-AUG-74',
        '16-SEP-04', '624 6 Ave SW', 'Calgary', 'AB', 'Canada', 'T2P 5N7',
        '+1 (403) 262-3445', '+1 (403) 262-3355', 'matthew@chinookcorp.com');
        
INSERT INTO employee 
VALUES (10, 'Richards', 'John', 'IT Staff', 6, '08-SEP-76',
        '16-SEP-04', '625 6 Ave SW', 'Calgary', 'AB', 'Canada', 'T2P 5N7',
        '+1 (403) 262-3447', '+1 (403) 262-3366', 'john@chinookcorp.com');

-- Task – Insert two new records into Customer table
select * from customer;
Insert into customer 
values (60, 'Jack', 'Thompson', null, '235 Gerald Street', 'London', null,
'United Kingdom', 'FL87 9PF', '+44 020 7871 5866', null, 'jack.thompson@gmail.com', 3);

Insert into customer 
values (61, 'Jill', 'Thompson', null, '235 Gerald Street', 'London', null,
'United Kingdom', 'FL87 9PF', '+44 020 7871 5866', null, 'jill.thompson@gmail.com', 5);

--------------------------2.4 Update
-- Task – Update Aaron Mitchell in Customer table to Robert Walter
select * from customer where firstname = 'Robert';
update customer 
set firstname = 'Robert', lastname = 'Walter'
where firstname = 'Aaron' and lastname = 'Mitchell';

-- Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
select * from artist where name = 'CCR';
update artist
set name = 'CCR'
where name = 'Creedence Clearwater Revival';

--------------------------------2.5 Like

-- Task – Select all invoices with a billing address like “T%”
select * from invoice where BILLINGADDRESS like 'T%';

--------------------------------2.6 Between

-- Task – Select all invoices that have a total between 15 and 50
select * from invoice;
select * from invoice where total between 15 and 30;

-- Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
select * from employee where hiredate between '01-JUN-03' and '01-MAR-04';

--------------------------------2.7 Delete
--Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints
--that rely on this, find out how to resolve them).
select * from customer where firstname = 'Robert' and lastname = 'Walter';
select * from invoice where customerid = 32;

/*
delete from invoiceline where INVOICEID = 342;
delete from invoiceline where INVOICEID = 50;
delete from invoiceline where INVOICEID = 61;
delete from invoiceline where INVOICEID = 116;
delete from invoiceline where INVOICEID = 245;
delete from invoiceline where INVOICEID = 268;
delete from invoiceline where INVOICEID = 290;
*/

alter table invoice disable constraint fk_invoicecustomerid;
alter table invoiceline disable constraint fk_invoicelineinvoiceid;

delete from customer where firstname = 'Robert' and lastname = 'Walter';

---------------------------------------------------------------- 3.0 SQL Functions

--------------------------------3.1 System defined functions
--Task - Create a function that returns the current time

create or replace function getTime
return timestamp with time zone as curTime timestamp with time zone;
begin
  select current_timestamp into curTime from dual;
  return curTime;
end;
/

select getTime() from dual;

-- Task – create a function that returns the length of a mediatype from the mediatype table
select * from mediatype;

create or replace function mediatype_length(item varchar2)
return number as type_length number(10);
begin
  type_length := length(item);
  return type_length;
end;
/

select mediatype_length(name) from mediatype;

------------------------------------------------- 3.2 System Defined Aggregate Functions

---- Task – Create a function that returns the average total of all invoices
select total from invoice;

create or replace function average_total
return number as avg_total number(8,2);
begin
  select avg(total) into avg_total from invoice;
  return avg_total;
end;
/

select average_total from dual;

---- Task – Create a function that returns the most expensive track
select name, unitprice from track;
select max(unitprice) from track;

create or replace function most_exp_track
return number as trackprice number(8,2);
begin
  select max(unitprice) into trackprice from track;
  return trackprice;
end;
/
select name, unitprice from track where unitprice = most_exp_track order by unitprice desc;

----------------------------------3.3 User Defined Functions

---- Task – Create a function that returns the average price of invoiceline items in the invoiceline table
select * from invoiceline;

create or replace function average_invoice_price
return number as average number(8,2);
begin
  select avg(unitprice) into average from invoiceline;
  return average;
end;
/

select average_invoice_price from dual;

--------------------------------------------------- 3.4 User Defined Table Valued Functions

---- Task – Create a function that returns all employees who are born after 1968.
select lastname, firstname, birthdate from employee;

create or replace function younguns(cursorParam OUT sys_refcursor)
return cursorParam;
begin
  open cursorParam for select firstname, lastname, birthdate from employee where birthdate > '30-DEC-68';
  return cursorParam;
end;
/

----------------------------------------------------------------------------- 4.0 Stored Procedures

----------------------------------------------- 4.1 Basic Stored Procedure

--Task – Create a stored procedure that selects the first and last names of all the employees.
select firstname, lastname from employee;

create or replace procedure emp_name(cursorParam out SYS_REFCURSOR)
is
begin
  open cursorParam for select firstname, lastname from employee;
end;
/

variable rc refcursor;
exec emp_name(:rc);
print rc;

----------------------------------------------- 4.2 Stored Procedure Input Parameters

---- Task – Create a stored procedure that updates the personal information of an employee.
select * from employee;

create or replace procedure update_employee(emp_id number, l_name varchar2, f_name varchar2, b_date date,
    ad varchar2, cit varchar2, st varchar2, cou varchar2, post varchar2, ph varchar2, fx varchar2, ema varchar2)
is
begin
  update employee
  set lastname = l_name,
        firstname = f_name,
        birthdate = b_date,
        address = ad,
        city = cit,
        county = cou,
        postalcode = post,
        phone = ph,
        fax = fx,
        email = ema
    where employeeid = emp_id;
end;
/

---- Task – Create a stored procedure that returns the managers of an employee.
create or replace procedure emps_manager(empid number)
is
begin
  select firstname, lastname from employee where employee_id = empid;
end;
/

----------------------------------------------- 4.3 Stored Procedure Output Parameters

---- Task – Create a stored procedure that returns the name and company of a customer.
select * from customer;
create or replace procedure customer_info (cursorParam out sys_refcursor)
is
begin
  open cursorParam for select firstname, lastname, company from customer;
end;
/

------------------------------------------------------------------------ 5.0 Transactions

---- Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that
-------- rely on this, find out how to resolve them).
select * from invoice;

create or replace procedure delete_invoice(i_ID in number)
is
begin
    set transaction isolation level read committed;
    savepoint noChangesYet;
    alter table invoice disable constraint fk_invoicecustomerid;
    alter table invoiceline disable constraint fk_invoicelineinvoiceid;
    savepoint constraintsAltered;
    DBMS_OUTPUT.PUT_LINE('set savepoint constraintsAltered');
    delete from invoice where invoiceid = i_ID;
    exception
            when invalid_number then
                    DBMS_OUTPUT.PUT_LINE('invalid_number occured');
                    rollback to constraintsAltered;
    commit;
end;
/

---- Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer
-------- table
select * from customer;

create procedure create_customer(pk IN NUMBER, firstname IN VARCHAR, 
    lastname IN VARCHAR, email IN VARCHAR, phone_number IN VARCHAR, rep IN NUMBER)
    IS
BEGIN
    set transaction isolation level read committed;
    insert into customer(customerid, firstname, lastname, email)
        values(pk, firstname, lastname, email);
    SAVEPOINT new_customer;
    DBMS_OUTPUT.PUT_LINE('set savepoint new_customer');
    update customer set company = 'Revature' where customerid = pk;
    update customer set supportrepid = rep where customerid = pk;
    exception
        when INVALID_NUMBER then
            DBMS_OUTPUT.PUT_LINE('invalid_number occurred');
            ROLLBACK TO new_customer;
        when OTHERS then
            DBMS_OUTPUT.PUT_LINE('some other exception occurred');
    update customer set phone = phone_number where customerid = pk;
    COMMIT;
END;
/

------------------------------------------------------------------------ 6.0 Triggers

------------------------------------------------- 6.1 After/Or

-- Task - Create an after insert trigger on the employee table 
----fired after a new record is inserted into the
----table.

create or replace trigger emp_insert_trig
after insert on employee
for each row
begin
  select * from employee;
end;
/

-- Task – Create an after update trigger on the album table that fires after a row is inserted in the table
create or replace trigger al_insert_trig
after insert on album
for each row
begin
  select * from album;
end;
/

-- Task – Create an after delete trigger on the customer table that fires after 
  --a row is deleted from the
  --table.
  
create or replace trigger cust_delete_trigger
after delete on customer
for each row
begin
  select * from customer;
end;
/

------------------------------------------------------------------------------ 7.0 Joins

---------------------------------------- 7.1 Inner

-- Task – Create an inner join that joins customers and orders
----and specifies the name of the customer and
----the invoiceId.

select * from customer;
select * from invoice;

select c.firstname as firstname, c.lastname as lastname, i.invoiceid
from customer c
join invoice i
on c.customerid = i.customerid;

------------------------------------------------ 7.2 Outer

-- Task – Create an outer join that joins the customer and invoice table, 
----specifying the CustomerId,
----firstname, lastname, invoiceId, and total.
select * from customer;
select * from invoice;

select c.customerid, c.firstname, c.lastname, i.invoiceid, i.total
from customer c
full outer join invoice i
on c.customerid = i.customerid;

----------------------------------------------------- 7.3 Right
-- Task – Create a right join that joins album and artist 
---- specifying artist name and title.
select * from album;
select * from artist;

select art.name, al.title
from artist art
right join album al
on al.artistid = art.artistid;

-------------------------------------------------- 7.4 Cross
-- Task – Create a cross join that joins album and artist
---- and sorts by artist name in ascending order.

select * from album;
select * from artist;

select album.title, artist.NAME from album, artist order by artist.name;

----------------------------------------------------- 7.5 Self
-- Task – Perform a self-join on the employee table, joining on the reportsto column.
select emp1.lastname as manager, emp2.lastname as associate
from employee emp1
inner join employee emp2
on emp1.employeeid = emp2.reportsto;

------------------------------------------------------ 7.6 Complicated Join

---- Task - Create an inner join between all tables in the chinook database.
select genre.name as genre, 
artist.name as artistname, 
album.title as albumtitle, 
track.trackid as trackid, 
track.name as trackname,
playlist.name as playlistname,
playlisttrack.trackid as playlisttracknumber

from (((((track
inner join album on track.albumid = album.albumid)
inner join artist on album.artistid = artist.artistid)
inner join genre on track.genreid = genre.genreid)
inner join playlisttrack on track.trackid = playlisttrack.trackid)
inner join playlist on playlisttrack.playlistid = playlist.playlistid)

order by trackid;

-- 9.0 Administration
---- Task – Create a .bak file for the Chinook database 

Backup database Chinook-DB to disk='C:\Users\Ryan\my_git_repos\1807Jul30Java\Ryan_Posey_Code\Week2\scripts\Chinook-DB.bak';