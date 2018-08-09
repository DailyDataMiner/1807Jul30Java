-- RUNNING ON CHINOOK

create or replace procedure helloWorld
as -- aka IS
begin
  dbms_output.put_line('hello database world');
end;
/

execute helloWorld;

-- function
-- total number of artists
create or replace function get_num_artists
return number
is
total number;
begin
select count(*) into total from artist;
return total;
end;
/

select get_num_artists() from dual;

select count(*) from artist;

commit;

/* index is a performance tuning methd of allowing
faster retrieval of records. An index creates an extry for
each value that appears in the indexed column(s)
*/

create index art_name_index
on artist(name);

select * from genre;

/*
running on bookstore
*/

/*
oracle creates a context area with all information necessary for processing with an SQL statement
 - a CURSOR is a pointer to the context area
 - the "active set" is the row returned by a statement and is held by the cursor
 - 2 types: implicit and explicit
  - implicit: created by Oracle whenever we exe a DML statement and no explicit cursor exists on the set
  - explicit: programmer defined, as seen below, is used for obtaining more control over context area
    - Declare cursor to initialize memory
    - Open cursor to allocate memory
    - Fetch cursor to retrieve data
    - Close cursor to release memory
*/

-- stored procedure
-- cursorparams = parameter name
-- sys_refcursor is type
create or replace procedure get_all_book(cursorParam OUT SYS_REFCURSOR)
IS
BEGIN
  open cursorParam FOR select * from book;
END;
/

commit;