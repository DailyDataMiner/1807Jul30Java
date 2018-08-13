/*
* Arthur Panlilio Week 2 Assignment
*/

-------------------------------2.1 SELECT
--TASK - Select all records from the Employee table.
SELECT * FROM employee;

--Task - Select all records from the Employee table where last name is King
SELECT * FROM employee where lastname = 'King';

--Seelct all records from Employee table where first name is Andrew and Reportsto is null
SELECT * FROM employee where firstname = 'Andrew' AND reportsto IS NULL;



----------------------------------2.2 ORDER BY
--Task – Select all albums in Album table and sort result set in descending order by title.
SELECT * FROM album ORDER BY title DESC;

--Task – Select first name from Customer and sort result set in ascending order by city
SELECT firstname FROM customer ORDER BY city ASC;



----------------------------------2.3 INSERT INTO
--Task – Insert two new records into Genre table
INSERT INTO genre VALUES (26, 'Folk');
INSERT INTO genre VALUES (27, 'Cowboy Russian Uncle');

--Task – Insert two new records into Employee table
INSERT INTO employee VALUES (9,'Bunga', 'Bill', 'Heirophant', null, '01-JAN-00','15-JUL-69','271 Dog Ave','Bumbleton','ZQ','Purgatory','abc 123','123 421','2193 @$2','at@at.at');
INSERT INTO employee VALUES (10,'The Wise', 'Grimbrodil', 'Human Resources', 8, '15-OCT-53','30-JAN-79','123d ahahhh e','Reston','WV','Canada','2424 142','123 213 32','2193 @$2','email@hihi.com');

--Task – Insert two new records into Customer table
INSERT INTO customer VALUES (60,'Fink','Winkleson','Dog corporated','123 lane','Big City', 'BS','Big Country','123 post','253-123','1234','bob@bob.com',10);
INSERT INTO customer VALUES (61,'Von Branschbank AlbrechtsBerger', 'Constanze Amelie', null, '321 lane', 'Dussledorf', null, 'Germany', '4123 post', '123-213', '4131', 'Bob@Bobbo.com', 9);



--------------------------------2.4 UPDATE
--Task – Update Aaron Mitchell in Customer table to Robert Walter
UPDATE customer SET lastname = 'Walter', firstname = 'Robert' Where firstname = 'Aaron' AND lastname = 'Mitchell';
--Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
UPDATE artist SET name = 'CCR' WHERE name = 'Creedence Clearwater Revival';


----------------------------------2.5 LIKE
--Task – Select all invoices with a billing address like “T%”
SELECT * FROM invoice WHERE billingaddress like 'T%';


------------------------------------2.6 BETWEEN
--Task – Select all invoices that have a total between 15 and 50
SELECT * FROM invoice WHERE total BETWEEN 15 AND 50;


--Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT * FROM employee WHERE hiredate BETWEEN '01-JUN-03' AND '01-MAR-04';


--------------------------------------2.7 DELETE
--Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
DELETE FROM customer WHERE firstname = 'Robert' AND lastname = 'Walter';

ALTER TABLE invoice
ADD CONSTRAINT fk_customer
FOREIGN KEY (customerid)
references customer (customerid)
ON DELETE CASCADE;


ALTER TABLE invoiceline
ADD CONSTRAINT fk_invoice
FOREIGN KEY (invoiceid)
references invoice (invoiceid)
ON DELETE CASCADE;

ALTER TABLE invoiceline
DROP CONSTRAINT fk_invoicelineinvoiceid;




-------------------------------------3.1 System Defined Functions 
--Task – Create a function that returns the current time.
CREATE OR REPLACE FUNCTION cur_time
RETURN date is theDate date;

BEGIN

--Code
SELECT sysdate
  into theDate
  from dual;

return theDate;
END;

/
--Task – create a function that returns the length of a mediatype from the mediatype table 
CREATE OR REPLACE FUNCTION get_length(v varchar2)
RETURN number IS len number(10);

BEGIN

len := LENGTH(v);
return len;

END;
/

------------------3.2 System Defined Aggregate Functions 
--Task – Create a function that returns the average total of all invoices 
CREATE OR REPLACE FUNCTION get_avg_total
RETURN number IS av number(10,2);
BEGIN
 SELECT AVG(total) INTO av FROM invoice;
return av;
END;
/

SELECT get_avg_total FROM dual;


--Task – Create a function that returns the most expensive track
CREATE OR REPLACE FUNCTION get_expensive
RETURN number IS ret number(10,2);
BEGIN
  SELECT MAX(unitprice) INTO ret FROM track;
  return ret;
END;
/

SELECT get_expensive FROM dual;

--------------------------3.3 User Defined Functions
--Task – Create a function that returns the average price of invoiceline items in the invoiceline table 
CREATE OR REPLACE FUNCTION  get_invoiceline_price
RETURN number is ret number(10,2);
BEGIN 
  SELECT AVG(track.unitprice) INTO ret
  FROM invoiceline JOIN
  track ON
  track.trackid = invoiceline.trackid;
  return ret;
END;
/

SELECT get_invoiceline_price FROM dual;

--------------------------3.4 User Defined Table Valued Functions 
--Task – Create a function that returns all employees who are born after 1968. 

CREATE OR REPLACE FUNCTION get_born2
  RETURN SYS_REFCURSOR
IS
  l_rc SYS_REFCURSOR;
BEGIN
  OPEN l_rc
   FOR SELECT *
         FROM employee
        WHERE birthdate > '31-DEC-68' ;
  RETURN l_rc;
END;
/

Select get_born2 from dual;

--------------------------------4.1 Basic Stored Procedure 
--Task – Create a stored procedure that selects the first and last names of all the employees. 
CREATE OR REPLACE PROCEDURE getnames
(c1 OUT SYS_REFCURSOR)
AS 
BEGIN
  open c1 for
  SELECT lastname,firstname FROM employee;
END;
/

variable c1 refcursor;
EXECUTE getnames(:c1);
print c1;

---------------------------------4.2 Stored Procedure Input Parameters 
--Task – Create a stored procedure that updates the personal information of an employee. 

CREATE OR REPLACE PROCEDURE updateE(s varchar2, intt number)
is
BEGIN
UPDATE employee SET title = s WHERE employeeid = intt;
END;
/

execute updateE('CEO', 1);

--Task – Create a stored procedure that returns the managers of an employee. 
CREATE OR REPLACE PROCEDURE returnManagers
(c1 OUT SYS_REFCURSOR)
AS 
BEGIN
  open c1 for
  SELECT DISTINCT e2.firstname, e2.lastname FROM employee e1, employee e2 WHERE
  e1.REPORTSTO = e2.employeeid;
END;
/
variable c1 refcursor;
EXECUTE returnManagers(:c1);
print c1;


------------------------------4.3 Stored Procedure Output Parameters 
--Task – Create a stored procedure that returns the name and company of a customer.
CREATE OR REPLACE PROCEDURE returnCompany
(c1 OUT SYS_REFCURSOR)
AS 
BEGIN
  open c1 for
  SELECT firstname, lastname, company FROM customer;
END;
/

variable c1 refcursor;
EXEC returnCompany(:c1);
print c1;




------------------------------------------5.0 Transactions In this section you will be working with transactions. Transactions are usually nested within a stored procedure. 
--Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).   
CREATE OR REPLACE PROCEDURE delInvoiceId(id number)
is 
BEGIN
DELETE FROM invoice WHERE invoiceId = id;
END;
/

EXEC delInvoiceId(405);
--Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table 


CREATE SEQUENCE customer_seq
minvalue 1
start with 62
increment by 1;

CREATE OR REPLACE TRIGGER c_seq_trig --declare and name trigger
BEFORE INSERT ON  customer --When we will execute
FOR EACH ROW --necessary to change value of table
BEGIN
  -- What to do when trigger is fired
  SELECT customer_seq.nextVAl INTO :new.customerId FROM dual;
END;
/


CREATE OR REPLACE PROCEDURE insertRec(fname varchar2, lname varchar2, emailt varchar2)
is
BEGIN
  INSERT INTO customer (firstname, lastname, email) VALUES (fname, lname, emailt);
END;
/

EXEC insertRec('Bob', 'Bobsley', 'BO@bo.com');


-----------------------------6.1 AFTER/FOR Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table. 
--Task – Create an after update trigger on the album table that fires after a row is inserted in the table 
CREATE OR REPLACE TRIGGER insertToAlbum
AFTER INSERT on album
FOR EACH ROW
BEGIN
 dbms_output.put_line('After Insert');
END;
/



--Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table

CREATE OR REPLACE TRIGGER deleteFromCustomer
BEFORE DELETE on customer
FOR EACH ROW
BEGIN
 dbms_output.put_line('Before delete');
END;
/



----------------------------------7.1 INNER 
--Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId. 
SELECT customer.firstname, invoice.invoiceid FROM customer 
INNER JOIN invoice
ON customer.customerid = invoice.customerid;


---------------------------------7.2 OUTER 
--Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
SELECT customer.customerid, customer.firstname, customer.lastname, invoice.invoiceid, invoice.total FROM customer
OUTER LEFT JOIN invoice
ON customer.customerid = invoice.customerid
Order by customer.customerid;

----------------------------------7.3 RIGHT 
--Task – Create a right join that joins album and artist specifying artist name and title. 
SELECT artist.name, album.title FROM artist
RIGHT JOIN album
on album.artistid = artist.artistid;


-------------------------------------7.4 CROSS 
--Task – Create a cross join that joins album and artist and sorts by artist name in ascending order. 
SELECT * FROM album 
CROSS JOIN artist
ORDER BY artist.name ASC;



--------------------------------------7.5 SELF 
--Task – Perform a self-join on the employee table, joining on the reportsto column
SELECT e1.lastname as lackey, e2.lastname as manager FROM employee e1, employee e2 
WHERE e1.REPORTSTO = e2.employeeid;





-------------------------------------7.6 Complicated Join assignment
--Create an inner join between all tables in the chinook database
SELECT album.title as "Album Title", artist.name as "Artist Name", track.name as "Track Name", genre.name as "Genre Name",
mediatype.name as "Media Type", playlisttrack.playlistid as "Playlist ID", playlist.name as "Playlist name", 
invoiceline.invoiceid as "Invoice ID", invoice.total as "Invoice total", customer.firstname as "Customer Name", employee.firstname as "Employee Name" FROM album
JOIN artist
ON artist.artistid = album.artistid
JOIN track 
ON album.albumid = track.albumid
JOIN genre
ON track.genreid = genre.genreid
JOIN mediatype
ON track.mediatypeid = mediatype.mediatypeid
JOIN playlisttrack
ON playlisttrack.trackid = track.trackid
JOIN playlist
ON playlist.playlistid = playlisttrack.playlistid
JOIN invoiceline
ON invoiceline.trackid = track.trackid
JOIN invoice
ON invoiceline.invoiceid = invoice.invoiceid
JOIN customer
ON customer.customerid = invoice.customerid
JOIN employee
ON customer.supportrepid = employee.employeeid;

------------------9.0 Administration In this section you will be creating backup files of your database. After you create the backup file you will also restore the database. 
--Task – Create a .bak file for the Chinook database  
