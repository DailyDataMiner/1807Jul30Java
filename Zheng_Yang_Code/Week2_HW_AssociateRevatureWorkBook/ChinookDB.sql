/*
2.1 SELECT
Task – Select all records from the Employee table.
*/

SELECT * FROM EMPLOYEE;

/*
2.1 SELECT
Task – Select all records from the Employee table where last name is King..
*/

SELECT *
FROM employee
WHERE lastname = 'King';

/*
2.1 SELECT
Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
*/

SELECT *
FROM employee
WHERE firstname = 'Andrew'
AND REPORTSTO IS NULL;


/*
2.2 ORDER BY
Task – Select all albums in Album table and sort result set in descending order by title.
Task – Select first name from Customer and sort result set in ascending order by city
*/

SELECT ALBUMID
FROM Album
ORDER BY title ASC;

/*--------------------------*/
SELECT FIRSTNAME
FROM CUSTOMER 
ORDER BY CITY DESC;

/*
2.3 INSERT INTO
Task – Insert two new records into Genre table
Task – Insert two new records into Employee table
Task – Insert two new records into Customer table
*/
INSERT INTO GENRE(genreid,NAME) 
VALUES (202,'HAH2');

select *
from genre;

INSERT INTO Employee(employeeid,FirstNAME,lastname) 
VALUES (10,'z','y');

select *
from Employee;


INSERT INTO Customer(CustomerID, FIRSTNAME, LASTNAME,EMAIL)
VALUES (200, 'tab','on','a@a.com');

select *
from Customer;

/*
2.4 UPDATE
Task – Update Aaron Mitchell in Customer table to Robert Walter
Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR
*/

UPDATE Customer
SET FIRSTNAME = 'Robert', lastname = 'Walter'
WHERE  FIRSTNAME = 'Aaron' and lastname = 'Mitchell';

update Artist
set name = 'CCR'
where name = 'Creedence Clearwater Revival';

select *
from Artist;

/*
2.5 LIKE
Task – Select all invoices with a billing address like “T%”
*/
select * from INVOICE
where BILLINGADDRESS like 'T%';

/*2.6 BETWEEN
Task – Select all invoices that have a total between 15 and 50
Task – Select all employees hired between 1st of June 2003 and 1st of March 2004*/
select * from INVOICE
where TOTAL between 15 and 50 ;

SELECT * from EMPLOYEE
where HIREDATE BETWEEN '01-June-2003' and '01-March-2004';

/*2.7 DELETE
Task – Delete a record in Customer table where the name is Robert Walter
(There may be constraints
that rely on this, find out how to resolve them).*/

/*get a customerID*/
select CUSTOMERID FROM Customer
WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter';
/*delete C. ID from invoice first since it has reference with customer*/

select * FROM INVOICE
WHERE CUSTOMERID = 32;

select * FROM Customer
WHERE CUSTOMERID = 32;
SAVEPOINT beforeDeleteFK;

ALTER TABLE invoice
DROP CONSTRAINT FK_INVOICECUSTOMERID;

DELETE FROM CUSTOMER WHERE CUSTOMERID = 32;

select * 
from Customer;

select *
from INVOICE;
/*3.0 SQL Functions
In this section you will be using the Oracle system functions, 
as well as your own functions, to perform
various actions against the database*/


/*3.1 System Defined Functions
Task – Create a function that returns the current time.
Task – create a function that returns the length of a mediatype from the mediatype table*/

CREATE OR REPLACE FUNCTION length_of_med(mediatype_id number)
RETURN number
IS length_of_media number;
BEGIN
   SELECT length(name)
   INTO length_of_media
   FROM mediatype
   WHERE mediatypeid = mediatype_id;
   RETURN length_of_media;
END;
/
SELECT length_of_med(1) FROM DUAL;




