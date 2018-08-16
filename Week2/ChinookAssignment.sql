/*
*   Paulo Webba Week 2 Assignment
*/

--2.1 Select
--Task - Select all records from the Employee table
select * from Employee; 
--Task - Select all records from the Employee table where last name equals king
select * from Employee where lastname = 'King';
--Task - Select all records from Employee table where first name is Andrew and REPORTSTO is Null
select * from employee where firstname = 'Andrew' and reportsto is null;
--2.2 Order by
--Task Select all albums in album table and sort result set in descending order by tittle
select * from album order by title desc;
--Task select first name from customer and sort result set in ascending order by city
select firstname from customer order by city asc;
--2.3 INSERT INTO
--Task Insert two new records into genre table
insert into genre(genreid, name) values (26, 'Kizomba');
insert into genre(genreid, name) values (27, 'Kuduro');
--Task Insert two new records into employee table
insert into employee(employeeid,lastname,firstname,title,reportsto,birthdate,hiredate,
address,city,state,country,postalcode,phone,fax,email)
values(9,'Silva','Sophia','Cloud Engineer',6,'04-SEP-75','03-APR-04','1301 Wakanda', 'Cape Town','SA','Canada','T1L 6M3','+1 (403)347-2938',
'+1 (403)347-2939','srose@chinookcorp.com');

insert into employee(employeeid,lastname,firstname,title,reportsto,birthdate,hiredate,
address,city,state,country,postalcode,phone,fax,email)
values(10,'Fontes','Sandrina','Intern',7,'02-JUL-72','06-JUN-05','235 Ingombotas','Kinaxixi','LDA','Canada','T4B 9G4','+1 (403)949-5918',
'+1 (403)943-5929','sandypereira@chinookcorp.com');
--Task Insert two new records into Customer table
insert into customer(customerid, firstname,lastname,company,address,city,state,country,postalcode,phone,fax,email,supportrepid)
values(60,'Pau','Gasol','NBA', '123 main street','San Antonio', 'TX','USA','72302','+1(862)354-6888)',
'+1(863)355-6878)','pgasol@prontonmail.com',null);
insert into customer(customerid, firstname,lastname,company,address,city,state,country,postalcode,phone,fax,email,supportrepid)
values(61,'Tony','Danza','Northeast High School', '452 Castor avenue','Philadelphia', 'PA','USA','19152','+1(267)357-6418)',
'+1(267)335-1823)','tdanza@vikings.com',5);
--2.4 UPDATE
--Task update aaron mitchell in customer table to robert walker
update customer set firstname = 'Robert', lastname = 'Walker'
where firstname = 'Aaron' and lastname= 'Mitchell';
--Task update name of artist in Artist table "Creedence Clearwater Revival" to "CCR"
update artist set name ='CCR' 
where name = 'Creedence Clearwater Revival';
--2.5 LIKE
--Task select all invoices with a billing address like "T%"
select * from invoice where billingaddress like 'T%';
--2.6 BETWEEN
-- Task select all invoices that have a total between 15 and 50 
select * from invoice where total between 15 and 50;
--Task select all employees hired between 1st of June 2003 and 1st of March 2004
select * from employee where hiredate between '01-JUN-03' and '01-MAR-04';
--2.7 DELETE
--Task - Delete a record in Customer table where name is Robert Walker 
--(there might be constraints that rely on this, need to find out how to resolve them) 
--select * from customer where firstname ='Robert' and lastname ='Walker';
alter table invoice disable constraint FK_INVOICECUSTOMERID; 
delete from customer where firstname='Robert' and lastname ='Walker';
--------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------
-------------------------------------------------------------------------------------------------------------
-- 3.0 SQL Functions
-- 3.1 System Defined Functions
-- Task - Create a function that returns the current time. 
select CURRENT_TIMESTAMP from dual;
-- Task - Create a function that returns the length of a mediatype from mediatype table
create or replace function len(nam varchar2)
return number is 
lengt number:=0;
begin
lengt := LENGTH(nam); 
return lengt;
end;
--select * from mediatype;
select distinct len('MPEG audio file') from mediatype;
----3.2 System Defined Aggregate Functions
--Task - Create a function that returns the average total of all invoices
select avg(total) from invoice;
select max(unitprice) from track; 
--Task Create a function that returns the most expensive track
-----3.3 User Defined Functions
-- Task - Create a function that returns the average \
create or replace function average_total
return number is
avgg number :=0;
begin
declare
asum number;
acount number;
  asum := select sum(unitprice) from invoiceline into asum;
  acount := select count(quantity) from invoiceline into acount;
  avgg := asum/acount;
 RETURN avgg;
end;
/
execute average_total;
-- price of invoiceline items in the invoiceline items in the invoiline table
-----3.4 User Defined Table Valued Functions
-- Task - Create a function that returns all employees who are born after 1968
create or replace function born_after
return number is
sixtyeight number := 0;
begin
  sixtyeight := select employeeid from employee into sixtyeight;
 RETURN sixtyeight;
end;
/
-----4.0 Stored Procedures
-----4.1
create or replace procedure names(idd number)
return resultado varchar2
is
begin
   select firstname, lastname from employee where employeeid = idd into resultado;
   return resultado;
end;
/
-----
-----4.2
create or replace procedure updates(idd number, words number)
return resultado varchar2
is
begin
  update employee set firstname = words where employeeid = idd into resultado;
  return resultado;
end;
/
-----
-----4.3
create or replace procedure managers(idd number, words number)
return resultado varchar2
is
begin
  select reportsto from employee where employeeid = idd into resultado;
  return resultado;
end;
/

create or replace procedure company(idd number, words number)
return resultado varchar2
is
begin
  select company from customer where costumerid = idd into resultado;
  return resultado;
end;
/
-----5.0
set transaction [];
-----6.0

---- 7.0 
--- 7.1 
select c.customerid, i.invoiceid from customer c inner join invoice i on i.custumerid = c.customerid; 
-- 7.2 
select c.customerid, c.firstname, c.lastname, i.invoiceid, i.total from customer c outer join invoice i on i.custumerid = c.customerid; 
-- 7.3 right
select an.title from album an right join select o.name from artist o on an.artistid = o.artistid;
---7.4 cross
select o.name, an.title from artist o, album an where o.artisticid = an.artisticid order by o.name;
-- 7.5 self

-- 7.6 complicated join assignment
---9.0 administration 












