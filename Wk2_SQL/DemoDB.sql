CREATE TABLE Genre(
  /*colName datatype optional constraints*/
  Genre_id number(10) PRIMARY KEY,
  Name varchar2(256) unique not null
);

CREATE TABLE Book
(
  Book_Id number(10) PRIMARY key,
  ISBN VARCHAR2(10) unique not null,
  Title varchar2(256) not null,
  Price number(6,2) not null,
  Genre_Id number(10),
  /*creating foreign key relationship*/
  constraint fk_book_genre FOREIGN key (Genre_id)
    references genre(genre_id)
);

create table Author
(
  Author_Id number(10) PRIMARY KEY,
  First_Name varchar2(50) not null,
  Last_Name VARCHAR2(50),
  Bio VARCHAR2(1000)
);

create table Book_Author(
  Book_Id number(10),
  Author_Id number(10),
  PRIMARY key (Book_id, Author_Id),
  FOREIGN key(Book_id) references book(Book_id),
  foreign key(author_id) references author(author_id)
);