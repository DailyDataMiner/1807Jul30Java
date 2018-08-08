select * from artist;

--this is a comment
select name from artist;

SELECT * FROM artist where name like 'A_a%';

select genreid, count(trackid)
from track
group by genreid;

select g.name as genre, count(t.trackid) as tracks
from track t
inner join genre g
on t.genreid = g.genreid
group by g.name
order by g.name desc;

select g.name as genre, max(t.MILLISECONDS)/1000 as "longest songs"
from track t
inner join genre g
on t.genreid = g.genreid
group by g.name
order by g.name desc;

select g.name as genre, g.genreid, max(t.MILLISECONDS)/1000 as "longest songs", g.genreid
from track t
inner join genre g
on t.genreid = g.genreid
group by g.name, g.genreid
order by g.name desc;

select max(artistid) from artist;

insert into artist(artistid, name)
values(276, 'Beyonce');

commit;


