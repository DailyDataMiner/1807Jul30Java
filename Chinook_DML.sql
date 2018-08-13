create or replace function get_num_artists
return number
is
total number;
begin
select count(*) into total from artist;
end;
/

select get_num_artists() from dual;

/*An index is a prformance tuning method of allowing faster retreival of recors. An index creates an entry for each value that appears
In the indexed columns
*/

create index art_name_index
on artist(name);

drop function get_num_artists;