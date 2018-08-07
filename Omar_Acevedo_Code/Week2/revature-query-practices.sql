select ARTISTID, NAME from artist;

select ALBUMID, TITLE, ARTISTID from album;

-- v1
select 
        alb.ALBUMID || ' ->  ' || alb.TITLE "ID -> Album Title",
        art.ARTISTID || ' ->  ' || art.NAME "ID -> Artist Name",
        t.trackid || ' -> ' || t.name "ID -> Track Name", 
        t.unitprice, 
        inv.total, sum(inv.total) 
from 
      invoice inv
  
  join invoiceline invline
  on inv.INVOICEID = invline.INVOICEID

  join track t
  on invline.TRACKID = t.TRACKID
  
  join album alb
  on alb.ALBUMID = t.ALBUMID
  
  join artist art
  on art.ARTISTID = alb.ARTISTID

group by alb.ALBUMID, alb.TITLE,
        art.ARTISTID, art.NAME, t.trackid, t.name, t.albumid, t.unitprice, inv.total

order by alb.title;

select * from customer where firstname like 'L%'
--union 
--union all
intersect
select * from customer where country = 'Brazil';

-- v2
select 
        t.trackid, t.name, t.albumid, t.unitprice, 
        sum(inv.total) 
from invoice inv, invoiceline invline, track t
where inv.INVOICEID = invline.INVOICEID
and invline.TRACKID = t.TRACKID
group by 
        t.trackid, t.name, t.albumid, t.unitprice, inv.total;
        
/* ------------------------------------------------------------------------- */
/* ------------------------------------------------------------------------- */
/* ------------------------------------------------------------------------- */
/* ------------------------------------------------------------------------- */

select trackid, name, genreid 
from track;
select genreid, name 
from genre;


select genreid, count(trackid)
from track 
group by genreid;

-- v1
select count(g.trackid)
from track t
join genre g
on t.genreid = g.genreid;

-- v1
select 
        (select name from genre where genreid = track.genreid) "Genre Name",
        count(trackid) "Genre QTY"
from track
group by genreid;

-- v2
select g.name as Genre,
      count(t.trackid) "Track Count"
from 
      track t,
      genre g
where 
      g.genreid = t.genreid
group by g.name
order by g.name;

-- v3
select g.name as Genre,
      count(t.trackid) "Track Count"
from 
      track t
      inner join genre g
on 
      g.genreid = t.genreid
group by g.name
order by g.name;
