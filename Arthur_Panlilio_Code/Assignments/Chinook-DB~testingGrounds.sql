/* System-defined functions
Scalar Functions - Functions that operate on single values
Aggregate Functions - Functions that operate on multiple rows of data - max
*/
SELECT * FROM artist WHERE lower(name) like 'A%M%';
SELECT * FROM artist WHERE length(name) < 16;

SELECT count(name) FROM artist;
SELECT max(milliseconds) FROM track;
SELECT avg(total) FROM invoice;

/*
NESTED QUERIES
queries inside of quieries also called subqueries
used for various types of dynamic quieries
--IN
*/
SELECT * FROM artist;
SELECT * FROM album WHERE artistid = 84;
SELECT artistid FROM artist WHERE name = 'Foo Fighters';
--Find all albums of all artist that name starts with f
SELECT * FROM album WHERE artistid IN (
  SELECT artistID FROM artist WHERE name like 'F%');
  
--Select number of people per company in customer table and alphabetize
SELECT count(customerid),company 
FROM customer 
GROUP BY company
ORDER BY company ASC;

/*
SET OPERATIONS - used to combine result seta and see overlap of data
  must have the same # and type of columns
UNION - results are all unique rows from both queries A+B =AB
UNION ALL - results fromm both queries A + B
INTERSECT - Meets both criteria AB
MINUS - Removes row that meets second criteria A - B
*/

SELECT * FROM customer;
SELECT * FROM customer WHERE firstname like 'L%';
SELECT * FROM CUSTOMER WHERE country = 'Brazil';

SELECT * FROM customer WHERE firstname like 'L%'
UNION
SELECT * FROM CUSTOMER WHERE country = 'Brazil';

SELECT * FROM customer WHERE firstname like 'L%'
UNION ALL
SELECT * FROM CUSTOMER WHERE country = 'Brazil';

SELECT * FROM customer WHERE firstname like 'L%'
INTERSECT
SELECT * FROM CUSTOMER WHERE country = 'Brazil';

SELECT * FROM customer WHERE firstname like 'L%'
MINUS
SELECT * FROM CUSTOMER WHERE country = 'Brazil';

/* JOINS
*/

SELECT t.name as "Track Name", al.title
FROM track t
JOIN album al
ON t.ALBUMID = al.ALBUMID;

SELECT *
FROM album
JOIN artist
ON album.albumid = artist.artistid;

SELECT * FROM employee;

SELECT e1.lastname as MANAGER, e2.lastname as EMPLOYEE
FROM employee e1
FULL JOIN employee e2
on e1.employeeid = e2.reportsto
WHERE e2.employeeid is null;

--Cross Join - cartesian prodcut of two tables
SELECT e1.lastname as MANAGER, e2.lastname as EMPLOYEE
FROM employee e1, employee e2;


--Natural Join - where ORacle attemps to match columns based on names
SELECT album.title, artist.name
FROM album
INNER JOIN artist
on album.artistid = artist.artistid;

SELECT * FROM artist NATURAL JOIN album;

SELECT * FROM genre;
SELECT * FROM track;

SELECT genreid, count(trackid) from track group by genreid;

create view GENRE_MAX_SONG_TIME_VIEW as
SELECT genre.name as "Genre",  max(track.milliseconds)/1000 as "Longest Song is Seconds"
FROM track
JOIN genre
ON track.genreid = genre.genreid
GROUP BY genre.name
ORDER BY genre.name ASC;

SELECT * FROM GENRE_MAX_SONG_TIME_VIEW;

SELECT max(artistid) FROM artist;

INSERT INTO artist (artistid, name)
VALUES(277,'Outkast');

UPDATE artist
set name = 'BEYONCE'
WHERE artistid = 277;

--TCL [brief] intro;
commit;
-- always commit upon successful db transactions
---meaning, insert update delete


DELETE FROM artist;
DELETE FROM artist WHERE artistid BETWEEN 1 AND 10;

-- JOIN ALL 11 Tables in CHINOOK DB
--- Select 1 col from each table
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
