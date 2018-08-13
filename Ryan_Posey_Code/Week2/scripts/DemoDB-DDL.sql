--BOOKSTORE DDL SCRIPT

CREATE TABLE Genre
(
      --  colName  dataType  Optional Constraints
          Genre_Id number(10) PRIMARY KEY,
          Name varchar2(256) unique not null
);

CREATE TABLE Book
(
        Book_Id number(10) PRIMARY KEY,
        ISBN varchar2(10) UNIQUE NOT NULL,
        Title varchar2(256) NOT NULL,
        Price number(6,2) NOT NULL,
        Genre_Id number(10),
        CONSTRAINT fk_book_genre FOREIGN KEY(Genre_id)
               REFERENCES genre(genre_id)
);

CREATE TABLE Author
( -- authorid, fn, lastname, biography
        Author_Id number(10) PRIMARY KEY,
        First_Name varchar2(50) NOT NULL,
        Last_Name varchar2(50),
        Bio varchar2(1000)
);
---JUNCTION TABLE. COLUMNS ARE BOTH PK AND FK
CREATE TABLE Book_Author
(
      Book_Id number(10),
      Author_Id number(10),
      Primary Key (Book_id, Author_Id),
      foreign key (Book_id) references book(Book_id),
      foreign key (author_id) references author(author_id)
);


select * from book_author;
-------------------------------- Sequences-----------------------
CREATE SEQUENCE book_seq;

-- This is what happens behind the scenes when a sequence is generated with all default params
   CREATE SEQUENCE  "DEMO1807JUL30JAVA"."BOOK_SEQ" 
   MINVALUE 1 
   MAXVALUE 9999999999999999999999999999 
   INCREMENT BY 1 
   START WITH 1 
   CACHE 20 NOORDER  NOCYCLE  NOPARTITION ;

DROP SEQUENCE a;

CREATE sequence genre_seq;

CREATE SEQUENCE author_seq
minvalue 1
start with 1
increment by 1
cache 20; -- how many values will be stored in memory for faster access

------------- TRIGGERS
CREATE OR REPLACE TRIGGER b_seq_trig -- declare and name trigger
before insert on book -- when will trigger execute
for each row -- necessary to change value of table
begin 
    -- what to do when trigger is fired
    select book_seq.nextVal into :new.book_id from dual;
end;
/

CREATE OR REPLACE TRIGGER a_seq_trig 
before insert on author
for each row 
begin 
    select author_seq.nextVal into :new.author_id from dual;
end;
/

CREATE OR REPLACE TRIGGER g_seq_trig 
before insert on genre
for each row 
begin 
    select genre_seq.nextVal into :new.genre_id from dual;
end;
/

-------- ABOUT DUAL
select * from DUAL;
select SYSDATE from DUAL;


--------------------------------------------- DML Stuff ...

select * from genre order by genre_id asc;
insert into genre (name) values('History');
insert into genre (name) values('Sci-Fi');
insert into genre (name) values('Romance');
insert into genre (name) values('Biography');
insert into genre (name) values('Horror');
insert into genre (name) values('Thriller');
insert into genre (name) values('Fiction');
insert into genre (name) values('Non-Fiction');
insert into genre (name) values('Fantasy');
insert into genre (name) values('Visual Novel');

select * from book;

select * from author;
insert into author(firstname, lastname, bio)
  values('George R.R.', 'Martin', 'A bio.');
  
  delete from author;

commit;

-----------------------PL/SQL -
-- create a proc to return all books
create or replace procedure get_all_books(
cursorParam OUT SYS_REFCURSOR)
is
begin
  open cursorParam for select * from book;
end;
/


/*
  - Oracle creates a context area with all information necessary
  for processing an SQL statement
  - A cursor is a pointer to the context area
  - the "active set" is the row(s) returned by a statement
  and is held by the cursor
  - there are two types: implicit and explicit
  ---> Implicit: created by Oracle when we execute a DML
  statement (and no explicit cursor on the set exists)
  ---> Explicit: Programmer defined, as seen below, and is used
  for obtaining more control over context area
  ---> DECLARE cursor to initialize memory
  ---> FETCH to retrieve data
  ---> CLOSE cursor to release memory
*/

--------------------------------------------------------------------------------

create table player_stats
(
  pid number(10),
  name varchar2(200),
  attempts number(10),
  made number(10),
  shooting_percentage number(10)
);

insert into player_stats values(0, 'Mean Mike', 1000, 300, 30);
insert into player_stats values(34, 'Steph Curry', 10000, 9000, 90);
insert into player_stats values(19, 'Dunking Adams', 100, 99, 99);
insert into player_stats values(10, 'Bugs Bunny', 8724, 5637, 99);

select * from player_stats;

-- function
create or replace function calc_shoot_avg(att number, made number)
  return number is percentage number(10);
  
  begin
    percentage := (made/att)*100;
    
    return percentage;
  end;
  
update player_stats
set shooting_percentage = calc_shoot_avg(8742, 5637)
where pid = 10;

-- sequence
create sequence pid_generator
minvalue 0
start with 100
increment by 1;

-- procedure
create or replace procedure insertPlayer(name varchar2, attempts number, made number)
is
begin
  insert into player_stats values(pid_generator.nextval,
  name,
  attempts,
  made, 
  calc_shoot_avg(attempts, made));
end;

exec insertPlayer('Kobe', 999, 400);
exec insertPlayer('Michael Jordan', 1120, 764);

select * from PLAYER_STATS;


create table retired_player
(
  pid number(10),
  name varchar2(200),
  attempts number(10),
  made number(10),
  shooting_percentage number(10)
);

-- Trigger
create or replace trigger retiring_player
before delete on player_stats
for each row

begin

insert into retired_player values (
  :old.pid,
  :old.name,
  :old.attempts,
  :old.made,
  :old.shooting_percentage
);

end; /

select * from player_stats;
select * from retired_player;

delete from player_stats where pid = 10;
