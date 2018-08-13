-- Joshua Hall Week 2 Assignment


-- 2.1 SELECT
-- Task – Select all records from the Employee table.
select * from employee;
-- Task – Select all records from the Employee table where last name is King.
select * from employee where lastname = 'King';
-- Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
select * from employee where firstname = 'Andrew' and reportsto is null;


-- 2.2 ORDER BY
-- Task – Select all albums in Album table and sort result set in descending order by title.
select * from album order by title desc;
-- Task – Select first name from Customer and sort result set in ascending order by city
select firstname from customer order by city asc;

-- 2.3 INSERT INTO
-- Task – Insert two new records into Genre table
insert into genre values (26, 'Dungeon Synth');
insert into genre values(27, 'White Noise');
-- Task – Insert two new records into Employee table
insert into employee values(9, 'Doe', 'John', 'IT Staff', 6, '01-JAN-24', null, null, null, null, 'USA', null, null, null, null);
insert into employee values(10, 'Degroot', 'Tavish',null, null, null, null, null, null, null, 'USA', null, null, null, null);
-- Task – Insert two new records into Customer table
insert into customer values(60, 'John', 'Doe', null, null, null, null, null, null, null, null, 'johndoe@mail.com', null);
insert into customer values(61, 'Saxton', 'Hale',null, null, null, null, null, null, null, null, 'noreply@mann.co', null);


-- 2.4 UPDATE
-- Task – Update Aaron Mitchell in Customer table to Robert Walter
update customer set firstname = 'Robert', lastname = 'Walter' 
where firstname = 'Aaron' and lastname = 'Mitchell';
-- Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
update artist set name = 'CCR' where name = 'Creedence Clearwater Revival';

-- 2.5 LIKE
-- Task – Select all invoices with a billing address like “T%”
select * from invoice where billingaddress like 'T%';

-- 2.6 BETWEEN
-- Task – Select all invoices that have a total between 15 and 50
select * from invoice where total >= 15 and total <= 50;
-- Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
select * from employee where hiredate > '1-JUN-03' and hiredate < '1-MAR-04';

-- 2.7 DELETE
-- Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
alter table invoiceline drop constraint FK_INVOICELINEINVOICEID;
alter table invoiceline add  constraint FK_INVOICELINEINVOICEID  
foreign key (invoiceid) references invoice(invoiceid) on delete cascade;
/
alter table invoice drop constraint FK_INVOICECUSTOMERID;
alter table invoice add  constraint FK_INVOICECUSTOMERID  
foreign key (customerid) references customer(customerid) on delete cascade;
/
delete from customer where firstname = 'Robert' and lastname = 'Walter';


-- 3.0 SQL Functions
-- In this section you will be using the Oracle system functions, as well as your own functions, to perform various actions against the database

-- 3.1 System Defined Functions
-- Task – Create a function that returns the current time.
select localtimestamp from dual;
-- Task – create a function that returns the length of a mediatype from the mediatype table
create or replace function get_length(mtid number) 
return number is len number(10);
begin
  select length(name) into len from mediatype where mediatypeid = mtid;
  return len;
end;
/
-- 3.2 System Defined Aggregate Functions
-- Task – Create a function that returns the average total of all invoices
select avg(total) from invoice;
-- Task – Create a function that returns the most expensive track
select * from track where unitprice = (select max(unitprice) from track);


-- 3.3 User Defined Functions
-- Task – Create a function that returns the average price of invoiceline items in the invoiceline table
create or replace function avg_price(iid number) 
return number is price number(10,2);
begin
  select avg(unitprice) into price from invoiceline where invoiceid = iid;
  return price;
end;
/
-- 3.4 User Defined Table Valued Functions
-- Task – Create a function that returns all employees who are born after 1968.
select * from employee where birthdate > '31 DEC 1968';


-- 4.0 Stored Procedures
-- In this section you will be creating and executing stored procedures. You will be 
-- creating various types of stored procedures that take input and output parameters.

-- 4.1 Basic Stored Procedure
-- Task – Create a stored procedure that selects the first and last names of all the employees.
create or replace procedure get_empl_names as begin
  select firstname, lastname from employee;
end;
/
execute get_empl_names;
-- 4.2 Stored Procedure Input Parameters
-- Task – Create a stored procedure that updates the personal information of an employee.
create or replace procedure update_empl(emplid number , phone number) as begin
  update employee e set e.phone = phone where e.employeeid = emplid;
end;

-- Task – Create a stored procedure that returns the managers of an employee.
create or replace procedure get_manager(emplid in number, manid out number) as begin
  select reportsto into manid from employee e where e.employeeid = emplid;
end;

-- 4.3 Stored Procedure Output Parameters
-- Task – Create a stored procedure that returns the name and company of a customer.
create or replace procedure get_cust_info(cid in number, firstname out varchar2, lastname out varchar2, company out varchar2)
as begin
  select firstname, lastname, company into firstname, lastname, company 
  from customer where customerid = cid;
end;

-- 5.0 Transactions
-- In this section you will be working with transactions. Transactions are usually nested within a stored procedure.
-- Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).
create or replace procedure delete_invoice(iid in number) as begin
  delete from invoice where invoiceid = iid;
end;
-- Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table
create or replace procedure insert_customer(cid in number, fn in varchar2, ln in varchar2, comp in varchar2, 
addr in varchar2, city in varchar2, st in varchar2, country in varchar2, zip in number, 
phone in number, fax in number, email in varchar2, sid in number) as begin
  insert into customer values(cid, fn, ln, comp, addr, city, st, country, zip, phone, fax, email, sid);
end;

-- 6.0 Triggers
-- In this section you will create various kinds of triggers that work when certain DML statements are executed on a table.
-- 6.1 AFTER/FOR
create sequence sqn;
create table counter(
counter number(10)
);
-- Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
create or replace trigger ai_empl_trig after insert on employee 
for each row begin
  insert into counter values(sqn.nextval);
end;

-- Task – Create an after update trigger on the album table that fires after a row is inserted in the table
create or replace trigger au_album_trig after update on album
for each row begin
  insert into counter values(sqn.nextval);
end;

-- Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.
create or replace trigger ad_cust_trig after delete on customer 
for each row begin
  insert into counter values(sqn.nextval);
end;

-- 7.0 JOINS
-- In this section you will be working with combing various tables through the use of joins. You will work with outer, inner, right, left, cross, and self joins.
-- 7.1 INNER
-- Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
select c.firstname, c.lastname, i.invoiceid from customer c 
inner join invoice i on c.customerid = i.customerid;

-- 7.2 OUTER
-- Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
select c.customerid, c.firstname, c.lastname, i.invoiceid, i.total from customer c 
full outer join invoice i on c.customerid = i.customerid;

-- 7.3 RIGHT
-- Task – Create a right join that joins album and artist specifying artist name and title.
select ar.name, al.title from album al 
right join artist ar on al.artistid = ar.artistid;


-- 7.4 CROSS
-- Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
select ar.name, al.title from album al 
cross join artist ar where al.artistid = ar.artistid order by ar.name asc;

-- 7.5 SELF
-- Task – Perform a self-join on the employee table, joining on the reportsto column.
select e1.firstname, e1.lastname, e2.firstname, e2.lastname from employee e1 
left join employee e2 on e1.reportsto = e2.employeeid;

-- 7.6 Complicated Join assignment
-- Create an inner join between all tables in the chinook database.
select pl.NAME, plt.PLAYLISTID, t.NAME, al.TITLE, ar.NAME, m.NAME, g.NAME, 
il.QUANTITY, i.TOTAL, c.LASTNAME, e.LASTNAME from playlist pl
inner join playlisttrack plt on plt.PLAYLISTID = pl.PLAYLISTID
inner join track t on plt.TRACKID = t.TRACKID
inner join album al on t.ALBUMID = al.ALBUMID
inner join artist ar on al.ARTISTID = ar.ARTISTID
inner join mediatype m on t.MEDIATYPEID = m.MEDIATYPEID
inner join genre g on t.GENREID = g.GENREID
inner join invoiceline il on t.TRACKID = il.TRACKID
inner join invoice i on il.INVOICEID = i.INVOICEID
inner join customer c on i.CUSTOMERID = c.CUSTOMERID
inner join employee e on c.SUPPORTREPID = e.EMPLOYEEID;

-- 9.0 Administration
-- In this section you will be creating backup files of your database. After you create the backup file you will also restore the database.
-- Task – Create a .bak file for the Chinook database 

