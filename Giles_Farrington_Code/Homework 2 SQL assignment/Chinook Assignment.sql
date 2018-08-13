/*
  Giles Farrington Week 2 Assignment
*/

-----------2.1 SELECT
--Task - Select all records from the Employee table.
SELECT * from Employee;

--Task - Select all records from the Employee table where last name is King.
SELECT * from employee where lastname = 'King';

--Task - Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT * from employee where firstname = 'Andrew' and reportsto is null;

--Task - Select all albums in Album table and sort result set in descending order by title.
SELECT * from album order by title desc;

--Task - Select first name from Customer and sort result set in ascending order by city
SELECT firstname from customer order by city;

--Task - Insert two new records into Genre table.
INSERT all
into genre(genreid, name)
values(26, 'country')
into genre(genreid, name)
values(27, 'EDM')
select * from dual;

--Task - Insert two new records ino Employee table
INSERT all 
into employee(employeeid, firstname, lastname)
values(9, 'James', 'Dingham')
into employee(employeeid, firstname, lastname, birthdate)
values(10, 'Chris', 'McConnell', '19-MAY-92')
select * from dual;

--Task - Insert two new records into Customer table
INSERT all
into customer(customerid, firstname, lastname, company, email)
values(60, 'Jimmy', 'Conham', 'McDonalds', 'jimmy@yahoo.com')
into customer(customerid, firstname, lastname, address, email)
values(61, 'April', 'Smith', '212 Dunnham st', 'april@gmail.com')
select * from dual;

--Task - Update Aaron Mitchell in Customer table to Robert Walter

update customer
set firstname = 'Robert', lastname = 'Walter'
where firstname = 'Aaron' and lastname = 'Mitchell';

--Task - Update name of artist in the Artist table "Creedence Clearwater Revival" to "CCR"
update artist
set name = 'CCR'
where name = 'Creedence Clearwater Revival';

--Task - Select all invoices with a billing address like 'T%'
SELECT * from invoice where BILLINGADDRESS like 'T%';

--Task - Select all invoices that have a total between 15 and 50
SELECT * from invoice where total > 15 and total < 50;

--Task - Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT * from employee where hiredate between '01-JUN-03' and '01-MAR-04';

--Task - Delete a record in Customer table where the name is Robert Walter(There may be
--constraints that rely on this, find out how to resolve them).
alter table invoice disable constraint fk_invoicecustomerid;
DELETE customer where firstname = 'Robert' and lastname = 'Walter';

--Task - Create a function that returns the current time
create or replace function getTime
return timestamp is l_systime timestamp;
begin
  select localtimestamp into l_systime from dual;
  return l_systime;
end;
select getTime() from dual;

--Task - Create a function that returns the length of a mediatype from the mediatype table
create or replace function getLength_mt(name varchar2)
return number is mt_length number(20);
begin
  mt_length := length(name);
  return mt_length;
end;
select getLength_mt(name) from mediatype;

--Task - Create a function that returns the average total of all invoices
create or replace function avg_total(total_sum number)
return number is average number(20);
begin 
  average := (total_sum/412);
  return average;
end;

select avg_total(sum(total)) from invoice;

--Task - Create a function that returns the most expensive track
create or replace function max_price
  return number
is
  price_max number;
BEGIN
  select MAX(unitprice) into price_max from track;
  return price_max;
END;
/
select name from track where unitprice = max_price;

--Task - Create a function that returns the average price of invoiceline items in the invoiceline table
create or replace function avg_price
  return number
is
  price_avg number;
BEGIN
  select AVG(unitprice) into price_avg from invoiceline;
  return price_avg;
END;
/
select avg_price from dual;

--TASK - Create a function that returns all employees who are born after 1968
select * from employee where EXTRACT(year from to_date(birthdate)) > 1968;

--TASK - Create a stored procedure that selects the first and last names of all the employees.
CREATE TABLE Names
(
  firstname varchar2(20),
  lastname varchar2(20)
);
create or replace procedure select_names
AS
BEGIN
  insert into Names(select firstname,lastname from employee);
END;
/
execute select_names;
select * from names;

-- Task - Create a stored procedure that updates the personal information of an employee
select * from employee;

create or replace procedure change_personal_info(e_id varchar2)
AS
BEGIN
  update employee
  set address = '345 elm st',
  city = 'Bridgemond',
  state = 'MA',
  country = 'United States of America',
  email = 'new@gmail.com'
  where employeeID = e_id;
END;
/

execute change_personal_info(2);

--Task - Create a stored procedure that returns the managers of an employee
create or replace procedure select_mngr(m_id varchar2)
IS
BEGIN
  for mngr in (select firstname, lastname from employee where employeeid = m_id)
  loop
    dbms_output.put_line('Manager is '|| mngr.firstname || ' ' || mngr.lastname);
  end loop;
END;
/
exec select_mngr(3);

--Task - Create a stored procedure that returns the name and company of a customer.
select * from customer;
create or replace procedure select_name_company(c_id number)
IS
fname varchar2(20); 
lname varchar2(20); 
comp varchar2(100);
BEGIN
  select firstname, lastname, company into fname, lname, comp from customer where customerid = c_id;
  dbms_output.put_line('First name: ' || fname || ' Last name: ' || lname ||
  ' Company: ' || comp);
END;
/
exec select_name_company(1);

--Task - Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them)

select * from invoice;
create or replace procedure delete_invoice(i_id number, table_name varchar2, fk varchar2)
is
begin
  execute immediate 'alter table ' || table_name || ' disable constraint ' || fk;
  delete invoice where invoiceId = i_id;
  commit;
end;
/
exec delete_invoice(4, 'invoiceline', 'fk_invoicelineinvoiceid');

--Task - Create a transaction nested within a stored procedure that inserts a new record in the Customer table
select * from customer;
create or replace procedure insert_customer(cust_id number, cust_fn varchar2, cust_ln varchar2, cust_email varchar2)
is 
begin
  insert into customer(customerid, firstname, lastname, email)
  values(cust_id, cust_fn, cust_ln, cust_email);
  commit;
end;
/
exec insert_customer(62, 'Albert', 'Costa', 'acosta@yahoo.com');

--Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table
select * from employee;
create or replace trigger after_employee_insert
  after insert on employee
begin
  dbms_output.put_line('After Insert Employee Trigger FIRED');
end;
/
insert into employee(employeeid, lastname, firstname) values(11, 'Jesabiah', 'Johaanson');

--Task - Create an after update trigger on the album table that fires after a row is inserted in the table
select * from album;
create or replace trigger after_update_album
  after update on album
begin
  dbms_output.put_line('After update album Trigger FIRED');
end;
/
update album set title = 'BestAlbumEver!!' where albumid = 1;

--Task - Create an after delete trigger on the customer table that fires after a row is deleted from the table.
select * from customer;
create or replace trigger after_delete_customer
  after delete on customer;
begin
  dbms_output.put_line('After customer deletion Trigger FIRED!');
end;
/

--Task - Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceid
select customer.firstname,customer.lastname, invoice.invoiceid
from customer
inner join invoice
on customer.customerid = invoice.invoiceid;

--Task - Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceid, and total
select customer.customerid, customer.firstname, customer.lastname, invoice.invoiceid, invoice.total
from customer
inner join invoice
on customer.customerid = invoice.invoiceid;

--Task - Create a right join that joins album and artist specifying artist name and title.
select artist.name, album.title
from album
right join artist
on album.albumid = artist.artistid;

--Task - Create a cross join that joins album and artist and sorts by artist name in ascending order.
select * from album cross join artist
order by artist.name asc;

--Task - Perform a self-join on the employee table, joining on the reportsto column.
select a.firstname, b.firstname
from employee a, employee b
where a.reportsto = b.reportsto;

--Task - Create an inner join between all tables in the chinook database.
select album.albumid, artist.name, customer.customerid, track.trackid, employee.employeeid, genre.genreid,
invoice.invoiceid, invoiceline.INVOICELINEID, mediatype.mediatypeid, playlist.playlistid, playlisttrack.trackid, track.name from album
join artist on artist.artistid = album.albumid
join customer on customer.customerid = album.albumid
join track on track.trackid = album.albumid
join employee on employee.employeeid = album.albumid
join genre on genre.genreid = album.albumid
join invoice on invoice.invoiceid = album.albumid
join invoiceline on invoiceline.invoicelineid = album.albumid
join mediatype on mediatype.mediatypeid = album.albumid
join playlist on playlist.playlistid = album.albumid
join playlisttrack on playlisttrack.TRACKID = album.albumid;







