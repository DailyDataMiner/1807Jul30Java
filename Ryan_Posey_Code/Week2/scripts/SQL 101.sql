--
/* This is a multi-line comment*/

-- SELECT [columns] FROM [table] WHERE [condition]
SELECT * FROM ARTIST;

SELECT NAME FROM ARTIST;
SELECT * FROM ARTIST WHERE NAME LIKE 'A%e';

--functions
/* System-defined functions
Scalar functions - functions that operate on single values
  upper, lower, length
Aggregate Functions - functions that operate on mutliple rows of data
  max, count
*/

SELECT * FROM ARTIST WHERE upper(NAME) LIKE 'A%M%';
select * from artist where length(name) < 15;

select count(*) from artist;
select max(milliseconds) from track;
select avg(total) from invoice where invoiceid < 10;

/*
NESTED QUERIES
queries inside of queries, also called subqueries
used for various types of dynamic queries
-- IN
*/

select * from artist;

-- find Foo Fighters' albums
select * from album where artistid = (
select artistid from artist where name = 'Foo Fighters');

-- find albums of all artists who's name starts with F
select * from album where artistid IN (
select artistid from artist where name like 'F%');

-- select number of people per company in customer table and alphabetize
SELECT count(customerid), company 
FROM customer 
GROUP BY company
ORDER BY company asc;

/*
SET OPERATIONS - used to combine result sets and see overlap of data
--> must have the same # and type of columns
UNION - results are all unique rows from both queries -> A + B - AB
UNION ALL - all rows, including duplicates -> A + B
INTERSECT - rows from result set from both queries -> AB
MINUS - all rows from first subset MINUS all rows in both sets -> A - B 
*/

select * from customer;
select * from customer where firstname like 'L%';
select * from customer where country = 'Brazil';

select * from customer where firstname like 'L%' UNION
select * from customer where country = 'Brazil';

select * from customer where firstname like 'L%' UNION ALL
select * from customer where country = 'Brazil';

select * from customer where firstname like 'L%' INTERSECT
select * from customer where country = 'Brazil';

select * from customer where firstname like 'L%' MINUS
select * from customer where country = 'Brazil';

/*
JOINS
*/
-- inner join
select t.name as TRACK_NAME, al.title 
from track t
join album al
on t.albumid = al.albumid;

-- self join, with left and right and full outer
select * from employee;
select e1.lastname as MANAGER, e2.lastname as EMPLOYEE
from employee e1
full join employee e2
on e1.employeeid = e2.reportsto
where e1.employeeid is null;

-- cross join - cartesian protuct of two tables
select e1.lastname as MANAGER, e2.lastname as EMPLOYEE
from employee e1, employee e2;

-- natural join - where oracle attempts to match columns based on names
select album.title, artist.name
from album
inner join artist
on album.artistid = artist.artistid;

select * from artist natural join album;

select * from genre;

-- find # of tracks of each genre, alphabetize by genre
select g.name as genre, count(t.trackid) as tracks
from track t
inner join genre g
on g.genreid = t.genreid
group by g.name
order by g.name;