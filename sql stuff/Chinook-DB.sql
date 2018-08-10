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


select EMPLOYEE.LASTNAME, CUSTOMER.LASTNAME, invoice.total, invoiceline.unitprice, track.name, ALBUM.TITLE, ARTIST.NAME, playlist.name, playlisttrack.playlistid

from employee

full outer join customer 
on employee.employeeid = customer.SUPPORTREPID 

full outer join invoice
on customer.customerid = invoice.CUSTOMERID

full outer join invoiceline
on invoice.INVOICEID = invoiceline.INVOICEID 

full outer join track
on invoiceline.TRACKID = track.TRACKID 

full outer join genre
on track.genreid = genre.GENREID

full outer join mediatype
on track.MEDIATYPEID = mediatype.GENREID

full outer join album
on track.ALBUMID = album.ALBUMID 

full outer join artist
on album.ARTISTID = artist.ARTISTID

full outer join PLAYLISTTRACK 
on track.TRACKID = PLAYLISTTRACK.TRACKID

full outer join playlist 
on playlist.PLAYLISTID = playlisttrack.PLAYLISTID;

select playlist.name, playlisttrack.playlistid

from playlist

full outer join playlisttrack on playlist.PLAYLISTID = playlisttrack.PLAYLISTID;

select name 
from genre;

select name 
from MEDIATYPE;














