Create or replace procedure helloWorld
  as -- can also be is
  begin
    dbms_output.put_line('HELLO DATABASE WORLD');
  end;
/

execute helloWorld;

-- Function
-- Get total number of artists
create or replace function get_num_artists
  return number -- functions must return something. declare return type here
is
  total number;
begin
  select count(*) into total from artist;
  return total;
end;
/

select get_num_artists() from dual;

/*
  An index is a performance-tuning method of allowing
  faster retrieval of methods. An index creates an entry
  for each value that appears in the indexed column(s).
*/
create index art_name_index
on artist(name);

select count(*) from artist;