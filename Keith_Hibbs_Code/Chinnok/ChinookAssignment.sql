--Select all records from the Employee table
select * from employee;
--Select all records from the Employee table where last name is King.
select * from employee
where lastname like 'King';
-- – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL. 
select * from employee
where firstname like 'Andrew'
and reportsto is null;
--Select all albums in Album table and sort result set in descending order by title. 
select * from album order by title desc;
--Select first name from Customer and sort result set in ascending order by city 
select * from customer order by city;
-- Insert two new records into Genre table 
insert all
into genre values (26, 'K-Pop')
into genre values (27, 'Chiptune')
select * from dual;
--Insert two new records into Employee table
INSERT all
INTO employee VALUES (9, 'Preist', 'Beverley', 'Janitor', 1, '02-FEB-90', '16-OCT-16', 'Canmore', '8008 30th St.','AB', 'Canada', 'T4C 123', '+1 (574)400-9117',NULL, 'beanp@chinookcorp.com') 
INTO employee VALUES (10,'Morgan', 'Scott', 'Receiving', 1, '04-APR-93', '20-JAN-18', '1632 1st St.', 'Canmore', 'AB', 'Canada', 'T6A 015', '1 (403)867-53049',NULL, 'scottm@chinookcorp.com')
Select * from dual;
--Insert two new records into Customer table 
insert all
INTO CUSTOMER Values (60, 'Rob', 'Thompson',NULL,'13 Knobb Ln', 'South Bend', 'In', 'USA', 46613, '1 (146) 245-6423', NULL, 'bob.thom@yahoo.com',1)
INTO CUSTOMER Values (61, 'Susan', 'Peterson',NULL,'654 Elm St','Chicago', 'Il', 'USA', 43262, '1 (256) 235-1689', NULL, 'supeters@gmail.com',2)
Select * from dual;
--Update Aaron Mitchell in Customer table to Robert Walter 
update customer 
set firstname = 'Robert', lastname = 'Walter'
where customerid = 32;
--Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR” 
update artist
set name = 'CCR'
where artistid = 163;
--Select all invoices with a billing address like “T%
select * from invoice where
billingaddress like 'T%';
--Select all invoices that have a total between 15 and 50 
select * from invoice where
total between 15 and 50;
--Select all employees hired between 1st of June 2003 and 1st of March 2004
select * from employee where
hiredate between '01-JUN-03' and '01-MAR-04';
--Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
delete from customer where
firstname = 'Robert' and lastname = 'Walter';
--Create a function that returns the current time.
select current_timestamp from dual;
--create a function that returns the length of a mediatype from the mediatype table
Select Length ('mediatype') from dual;
--Create a function that returns the average total of all invoices
Select avg(total) from invoice;
--Create a function that returns the most expensive track
select max(unitprice) from track;
--Create a function that returns the average price of invoiceline items in the invoiceline table 
select avg(unitprice) from invoiceline;
--Create a function that returns all employees who are born after 1968
select * from employee where 
birthdate > '31-Dec-68';
--Create a stored procedure that selects the first and last names of all the employees
create or replace procedure Concat  
as begin
select concat(firstname, lastname) from employee;
end;
/
execute Concat;
--Create a stored procedure that updates the personal information of an employee
create or replace procedure personal (firstname_input in varchar2, employeeid_input in int)
as begin
update employee set firstname = firstname_input where employeeid = employeeid_input;
end;
--Create a stored procedure that returns the managers of an employee.
create or replace procedure managers
as begin
select e1.firstname, e1.lastname, e2.firstname, e2.lastname from employee e1
join employee e2
on e1.employeeid = e2.reportsto;
end;
--Create a stored procedure that returns the name and company of a customer.

--Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).
create or replace procedure Delete_Invoice (inv in int)
as begin
    delete from invoice where invoiceid = inv;
end;
--Create a transaction nested within a stored procedure that inserts a new record in the Customer table 
create or replace procedure Create_Customer (Cust_ID in number, fname in varchar2, lname in varchar2, comp in varchar2, address in varchar2, city in varchar2, state in varchar2, country varchar2, post in varchar2, phone in varchar2, fax in varchar2, email in varchar2, supportid in int)
as begin
    insert into customer values (Cus_ID, fname, lname, comp, address, city, state, country, post,  phone, fax, email, supportid);
end;
--Create an after insert trigger on the employee table fired after a new record is inserted into the table.
create sequence employee_seq;
create or replace trigger employee_trig
before insert on employee
for each row begin
select employee_seq.nextval into :new.employeeid from dual;
end;
--Create an after update trigger on the album table that fires after a row is inserted in the table 

--Create an after delete trigger on the customer table that fires after a row is deleted from the table.
CREATE OR REPLACE TRIGGER delete_trigger
before DELETE
ON ALBUM
FOR EACH ROW

DECLARE
    EMP_ID NUMBER;
BEGIN
    SELECT EMPLOYEEID INTO EMP_ID
    FROM DUAL; 
    
    INSERT INTO EMPLOYEE_AUDIT (EMPLOYEEID) VALUES (:new.EMPLOYEEID);
END;    
/
--Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
select c.firstname, c.lastname, i.invoiceid from customer c
join invoice i
on c.customerid = i.customerid;
--Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total
select c.customerid, c.firstname, c.lastname, i.invoiceid, i.total from customer c
full join invoice i
on c.customerid = i.customerid;
--Create a right join that joins album and artist specifying artist name and title.
select ar.name, al.title from artist ar
right join album al
on ar.artistid = al.artistid;
--Create a cross join that joins album and artist and sorts by artist name in ascending order. 
select * from album al
cross join artist ar;
--Perform a self-join on the employee table, joining on the reportsto column
select e1.firstname, e1.lastname, e2.firstname, e2.lastname from employee e1
join employee e2
on e1.employeeid = e2.reportsto;
/
-- Write a query that connects all 11 tables woth one table from each
Select al.albumid, ar.artistid, c.customerid, e.employeeid, g.genreid, i.invoiceid, il.invoicelineid, m.mediatypeid, p.playlistid, pt.trackid, t.bytes from album al
full join artist ar
on al.artistid = ar.artistid
full join track t
on al.albumid = t.albumid
 full join genre g
on t.genreid = g.genreid
full join invoiceline il
on t.trackid = il.trackid
full join invoice i
on i.invoiceid = il.invoiceid
full join customer c
on i.customerid = c.customerid
full join employee e
on e.employeeid = c.supportrepid
full join mediatype m
on m.mediatypeid = t.mediatypeid
full join playlisttrack pt
on pt.trackid = t.trackid
full join playlist p
on p.playlistid = pt.playlistid;
--bakup  1807Jul30Java - Chinook to disk = 'E;\Chinook.bak'
