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
