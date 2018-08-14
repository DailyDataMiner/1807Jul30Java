/*
Vien Ly Week 2 Assignment
*/

-- 2.1 SELECT
SELECT *
FROM EMPLOYEE;

SELECT *
FROM EMPLOYEE
WHERE LASTNAME = 'King';

SELECT *
FROM EMPLOYEE
WHERE FIRSTNAME = 'Andrew' AND REPORTSTO IS NULL;

-- 2.2 ORDER BY
-- Task – Select all albums in Album table and sort result set in descending order by title.
SELECT *
FROM ALBUM
ORDER BY TITLE;

-- Task – Select first name from Customer and sort result set in ascending order by city
SELECT CITY, FIRSTNAME
FROM CUSTOMER
ORDER BY CITY ASC;

-- 2.3 INSERT INTO
-- Task – Insert two new records into Genre table
INSERT INTO GENRE (GENREID, NAME)
VALUES (26, 'Space Funk');
  
INSERT INTO GENRE (GENREID, NAME) 
VALUES (27, 'Underground Cartoon Bubble Pop');

SELECT * FROM GENRE ORDER BY GENREID;

-- Task – Insert two new records into Employee table
INSERT INTO EMPLOYEE (EMPLOYEEID, LASTNAME, FIRSTNAME, TITLE, REPORTSTO, BIRTHDATE, HIREDATE, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL)
VALUES (9, 'Brown', 'Black', 'IT Staff', 7, '02-MAY-92', '02-AUG-15', '1231 Dummy St', 'London', 'MD', 'Thailand', 1221, '+100 (299) 231-7777', '+100 (299) 231-7777', 'dummydude@hotmail.com');

INSERT INTO EMPLOYEE (EMPLOYEEID, LASTNAME, FIRSTNAME, TITLE, REPORTSTO, BIRTHDATE, HIREDATE, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL)
VALUES (10, 'Red', 'Green', 'Sales Manager', 7, '02-SEP-91', '21-MAY-18', '1231 Madeup Ave', 'Leicester', 'CA', 'Iceland', 12, '+12 (211) 231-2227', '+12 (211) 231-2227', 'REDGUY@GMAIL.com');

SELECT * FROM EMPLOYEE;

-- Task – Insert two new records into Customer table
INSERT INTO CUSTOMER (CUSTOMERID, FIRSTNAME, LASTNAME, EMAIL)
VALUES (60, 'IM', 'LAZY', 'whatever@gmail.com');

INSERT INTO CUSTOMER (CUSTOMERID, FIRSTNAME, LASTNAME, CITY, EMAIL)
VALUES (61, 'HELLO', 'WORLD', 'SEATTLE', 'hellohello@aol.com');

SELECT * FROM CUSTOMER;

-- 2.4 UPDATE
-- Task – Update Aaron Mitchell in Customer table to Robert Walter
SELECT * FROM CUSTOMER WHERE FIRSTNAME = 'Aaron';

UPDATE CUSTOMER
SET FIRSTNAME = 'Robert', LASTNAME = 'Walter'
WHERE CUSTOMERID = 32;

SELECT * FROM CUSTOMER WHERE CUSTOMERID = 32;

-- Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
UPDATE ARTIST
SET NAME = 'CCR'
WHERE NAME = 'Creedence Clearwater Revival';

SELECT * FROM ARTIST WHERE NAME = 'CCR';

-- 2.5 LIKE
-- Task – Select all invoices with a billing address like “T%”
SELECT *
FROM INVOICE
WHERE BILLINGADDRESS LIKE 'T%';

-- 2.6 BETWEEN
-- Task – Select all invoices that have a total between 15 and 50
SELECT *
FROM INVOICE
WHERE TOTAL BETWEEN 15 AND 50;

-- Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT *
FROM EMPLOYEE
WHERE HIREDATE BETWEEN '01-JUN-03' AND '01-MAR-04';

-- 2.7 DELETE
-- Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
ALTER TABLE INVOICE
DROP CONSTRAINT FK_INVOICECUSTOMERID;

DELETE
FROM CUSTOMER
WHERE FIRSTNAME = 'Robert'
AND LASTNAME = 'Walter';

SELECT *
FROM CUSTOMER
WHERE CUSTOMERID = 32;

-- 3.0 SQL FUNCTIONS
-- 3.1 SYSTEM DEFINED FUNCTIONS
-- Task – Create a function that returns the current time.
CREATE OR REPLACE FUNCTION current_time
RETURN VARCHAR2
AS t VARCHAR2(100);
BEGIN
  SELECT TO_CHAR(SYSDATE, 'HH24:MM:SS') INTO t FROM dual;
  RETURN t;
END current_time;
/

SELECT current_time() FROM dual;
  
-- Task – create a function that returns the length of a mediatype from the mediatype table
CREATE OR REPLACE FUNCTION media_type_length(id NUMBER)
RETURN NUMBER
AS l NUMBER;
BEGIN
  SELECT LENGTH(name) INTO l FROM mediatype WHERE mediatypeid = id;
  RETURN l;
END media_type_length;
/

SELECT media_type_length(4) FROM dual;

-- 3.2 SYSTEM DEFINED AGGREGATE FUNCTIONS
-- Task – Create a function that returns the average total of all invoices
CREATE OR REPLACE FUNCTION avg_invoice
RETURN NUMBER
AS t NUMBER;
BEGIN
  SELECT round(avg(total), 3) INTO t FROM invoice;
  RETURN t;
END avg_invoice;
/

SELECT avg_invoice FROM dual;
-- Task – Create a function that returns the most expensive track
CREATE OR REPLACE FUNCTION most_expensive
RETURN SYS_REFCURSOR
AS mp SYS_REFCURSOR;
BEGIN
  OPEN mp FOR
    SELECT name, unitprice
    FROM track
    WHERE unitprice = (
      SELECT max(unitprice) FROM track
    );
  RETURN mp;
END most_expensive;
/

DECLARE
  my_cursor SYS_REFCURSOR;
  name VARCHAR2(100);
  unitprice NUMBER;
BEGIN
  my_cursor := most_expensive();
  LOOP
    FETCH my_cursor INTO name, unitprice;
    EXIT WHEN my_cursor%NOTFOUND;
    DBMS_OUTPUT.put_line(name || ' ' || unitprice);
  END LOOP;
  CLOSE my_cursor;
END;
/

-- 3.3 USER DEFINED FUNCTIONS
-- Task – Create a function that returns the average price of invoiceline items in the invoiceline table
CREATE OR REPLACE FUNCTION avg_price_invoiceline
RETURN NUMBER
AS
  avg_price NUMBER(6,2);
BEGIN
  SELECT AVG(UNITPRICE) into avg_price FROM INVOICELINE;
  RETURN avg_price;
END;
/

select avg_price_invoiceline() from dual;
--3.4 USER DEFINED TABLE VALUED FUNCTIONS
--Task - Create a function that returns all employees who are born after 1968.
CREATE OR REPLACE FUNCTION young_employees
RETURN SYS_REFCURSOR
AS
   c1 SYS_REFCURSOR;
BEGIN
  OPEN c1 FOR
    SELECT employeeid, firstname, lastname, birthdate
    FROM employee WHERE birthdate > '31-DEC-68';
  RETURN c1;
END young_employees;
/

DECLARE
  my_cursor SYS_REFCURSOR;
  employeeid NUMBER;
  firstname VARCHAR2(20);
  lastname VARCHAR2(20);
  birthdate DATE;
BEGIN
  my_cursor := young_employees();
  LOOP
    FETCH my_cursor INTO employeeid, firstname, lastname, birthdate;
    EXIT WHEN my_cursor%NOTFOUND;
    DBMS_OUTPUT.put_line(employeeid || ' ' || firstname || ' ' || lastname || ' ' || birthdate);
  END LOOP;
  CLOSE my_cursor;
END;
/

-- 4.0 STORED PROCEDURES
-- 4.1 Basic Stored Procedure
-- Task – Create a stored procedure that selects the first and last names of all the employees.
CREATE OR REPLACE PROCEDURE names(names OUT SYS_REFCURSOR)
AS
BEGIN
  OPEN names FOR
    SELECT firstname, lastname FROM employee;
END;
/

DECLARE
  employee_names SYS_REFCURSOR;
  first VARCHAR(20);
  last VARCHAR(20);
BEGIN
  names(employee_names);
  LOOP
    FETCH employee_names INTO first, last;
    EXIT WHEN employee_names%NOTFOUND;
    DBMS_OUTPUT.put_line(first || ' ' || last);
  END LOOP;
  CLOSE employee_names;
END;
/

-- 4.2 Stored Procedure Input Parameters
-- Task – Create a stored procedure that updates the personal information of an employee
CREATE OR REPLACE PROCEDURE update_employee(e_id IN NUMBER, first in VARCHAR2, last IN VARCHAR2, TITLE IN VARCHAR2)
AS
BEGIN
  UPDATE employee SET firstname = first, lastname = last WHERE employeeid = e_id;
END;
/

CALL update_employee(1, 'Updated', 'Employee', 'Test Title');

SELECT * FROM employee WHERE employeeid = 1;

-- Task – Create a stored procedure that returns the managers of an employee.
CREATE OR REPLACE PROCEDURE get_manager(e_id IN NUMBER, manager OUT SYS_REFCURSOR)
AS
BEGIN
  OPEN manager FOR
    SELECT employeeid, firstname, lastname
    FROM employee
    WHERE employeeid = (
      SELECT reportsto
      FROM employee
      WHERE employeeid = e_id
    );
END;
/

DECLARE
  manager_info SYS_REFCURSOR;
  id NUMBER;
  first VARCHAR2(20);
  last VARCHAR2(20);
BEGIN
  get_manager(3, manager_info);
  FETCH manager_info INTO id, first, last;
  DBMS_OUTPUT.put_line(id || ' ' || first || ' ' || last);
  CLOSE manager_info;
END;
/

-- 4.3 Stored Procedure Output Parameters
-- Task – Create a stored procedure that returns the name and company of a customer.
CREATE OR REPLACE PROCEDURE get_customer_info(id IN NUMBER, c OUT SYS_REFCURSOR)
AS
BEGIN
  OPEN c FOR
    SELECT firstname, lastname, company
    FROM customer
    WHERE customerid = id;
END;
/

DECLARE
  c SYS_REFCURSOR;
  first VARCHAR2(20);
  last VARCHAR2(20);
  company VARCHAR2(20);
BEGIN
  get_customer_info(16, c);
  FETCH c INTO first, last, company;
  DBMS_OUTPUT.put_line(first || ' ' || last || ' ' || company);
  CLOSE c;
END;
/

-- 5.0 Transactions
-- In this section you will be working with transactions. Transactions are usually nested within a stored procedure.
-- Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).
-- Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table

-- 6.0 Triggers
-- In this section you will create various kinds of triggers that work when certain DML statements are executed on a table.
-- 6.1 AFTER/FOR
-- Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
CREATE OR REPLACE TRIGGER trigger_employee_insert
AFTER INSERT ON employee
FOR EACH ROW
BEGIN
  DBMS_OUTPUT.put_line('New record inserted into the employee table ' || :new.employeeid || ' ' || :new.firstname || ' ' || :new.lastname);
END;
/

INSERT INTO EMPLOYEE (EMPLOYEEID, LASTNAME, FIRSTNAME, TITLE, REPORTSTO, BIRTHDATE, HIREDATE, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL)
VALUES (80, 'test', 'test', 'IT Staff', 7, '02-SEP-97', '02-AUG-17', '1st St', 'over', 'rainbow', 'somewhere', 1221, '+100 (299) 231-1232', '+100 (299) 231-7777', 'testest@test.com');

-- Task – Create an after update trigger on the album table that fires after a row is inserted in the table
CREATE OR REPLACE TRIGGER trigger_album_update
AFTER UPDATE ON album
FOR EACH ROW
BEGIN
  DBMS_OUTPUT.put_line('A record was updated in the album table ' || :new.albumid || ' ' || :new.title);
END;
/

UPDATE album SET TITLE = 'UPDATED ALBUM' WHERE albumid = 1;

-- Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.
CREATE OR REPLACE TRIGGER trigger_customer_delete
AFTER INSERT ON customer
FOR EACH ROW
BEGIN
  DBMS_OUTPUT.put_line('A record was deleted from the customer table ' || :old.customerid || ' ' || :old.firstname || ' ' || :old.lastname);
END;
/

-- DELETE FROM customer WHERE customerid = 1;

-- 7.0 JOINS
-- 7.1 INNER JOIN
-- Task - Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
SELECT C.FIRSTNAME, C.LASTNAME, I.INVOICEID
FROM CUSTOMER C
JOIN INVOICE I
ON C.CUSTOMERID = I.CUSTOMERID;

-- 7.2 OUTER - Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total
SELECT C.CUSTOMERID AS CUSTOMERID,
        C.FIRSTNAME AS FIRSTNAME,
        C.LASTNAME AS LASTNAME,
        I.INVOICEID AS INVOICEID,
        I.TOTAL AS TOTAL
FROM CUSTOMER C
FULL OUTER JOIN INVOICE I
ON C.CUSTOMERID = I.CUSTOMERID
ORDER BY C.CUSTOMERID;

-- 7.3 RIGHT - Create a right join that joins album and artist specifying artist name and title
SELECT AR.NAME AS ARTIST, AL.TITLE AS ALBUM
FROM ALBUM AL
RIGHT JOIN ARTIST AR
ON AL.ARTISTID = AR.ARTISTID
ORDER BY AR.NAME;
        
-- 7.4 CROSS - Create a cross join that joins album and artist and sorts by artist name in ascending order
SELECT AR.NAME AS ARTIST, AL.TITLE AS ALBUM
FROM ALBUM AL
CROSS JOIN ARTIST AR
ORDER BY AR.NAME;

-- 7.5 SELF - Perform a self-join on the employee table, joining on the reportsto column
SELECT E1.LASTNAME, E2.LASTNAME
FROM EMPLOYEE E1
JOIN EMPLOYEE E2
ON E1.EMPLOYEEID = E2.REPORTSTO;

-- 7.6 COMPLICATED JOIN
SELECT ARTIST.NAME AS ARTISTNAME, 
        ALBUM.TITLE AS ALBUMTITLE, 
        TRACK.NAME AS TRACKNAME,
        GENRE.NAME AS GENRE,
        PLAYLIST.NAME AS PLAYLIST,
        INVOICELINE.UNITPRICE AS PRICE,
        INVOICE.TOTAL AS TOTAL,
        CUSTOMER.COUNTRY AS COUNTRY,
        EMPLOYEE.STATE AS STATE,
        MEDIATYPE.NAME AS MEDIA
FROM TRACK
JOIN MEDIATYPE ON TRACK.MEDIATYPEid = MEDIATYPE.MEDIATYPEID
JOIN INVOICELINE ON TRACK.TRACKID = INVOICELINE.TRACKID
JOIN INVOICE ON INVOICELINE.INVOICEID = INVOICE.INVOICEID
JOIN CUSTOMER ON INVOICE.BILLINGCOUNTRY = CUSTOMER.COUNTRY
JOIN EMPLOYEE ON CUSTOMER.STATE = EMPLOYEE.STATE
JOIN GENRE ON TRACK.GENREID = GENRE.GENREID
JOIN PLAYLISTTRACK ON TRACK.TRACKID = PLAYLISTTRACK.TRACKID
JOIN PLAYLIST ON PLAYLISTTRACK.PLAYLISTID = PLAYLIST.PLAYLISTID
JOIN ALBUM ON TRACK.ALBUMID = ALBUM.ALBUMID
JOIN ARTIST ON ALBUM.ARTISTID = ARTIST.ARTISTID
ORDER BY ARTIST.ARTISTID;