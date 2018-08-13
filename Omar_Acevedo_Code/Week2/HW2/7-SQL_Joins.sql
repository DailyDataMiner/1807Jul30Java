--  7.0 JOINS
--  In this section you will be working with combing various tables through the use of joins. You will work with outer, inner, right, left, cross, and self joins.

/* ============================================================================================== */
--  7.1 INNER
--  Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
--  v1
        select 
                cust.firstname || ' ' || cust.lastname as "Customer Name",
                inv.invoiceid
        from
                customer cust
        inner join  
                invoice inv
        on cust.customerid = inv.customerid
        order by cust.customerid desc;
        
--  v2
        select    inv.invoiceid, inv.customerid, 
                    ( select c.firstname || ' ' || c.lastname from customer c where c.customerid = inv.customerid ) as "Customer Name",
                    inv.invoicedate, inv.billingaddress, inv.billingcity, inv.billingstate, inv.billingcountry, inv.billingpostalcode, inv.total 
        from 
                invoice inv 
        order by inv.customerid desc;

--  v3
        select ( select c.firstname || ' ' || c.lastname from customer c where c.customerid = orders.customerid ) as "Customer Name",
                  orders.invoiceid
        from 
                customer cust
        inner join 
            (select inv.invoiceid, inv.customerid, inv.invoicedate, inv.billingaddress, inv.billingcity, inv.billingstate, inv.billingcountry, inv.billingpostalcode, inv.total
            from invoice inv
            inner join invoiceline invline
            on inv.invoiceid = invline.invoiceid) orders
        on orders.customerid = cust.customerid
        order by orders.customerid desc;


/* ============================================================================================== */
--  7.2 OUTER
--  Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
        select 
                cust.customerid,
                cust.firstname || ' ' || cust.lastname as "Customer Name",
                inv.invoiceid,
                inv.total
        from
                customer cust   
        full outer join  
                invoice inv
        on cust.customerid = inv.customerid
        order by cust.customerid desc;

/* ============================================================================================== */
--  7.3 RIGHT
--  Task – Create a right join that joins album and artist specifying artist name and title.
select * from album;
select * from artist;

select
      artist.name "Artist Name", nvl(album.title, 'NO Album') "Album Title"
from 
        album
right join
        artist
on    album.artistid = artist.artistid
order by album.title desc;

/* ============================================================================================== */
--  7.4 CROSS
--  Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
select count(1) from album;   -->  272
select count(1) from artist;    -->  206
select 272 * 206 from dual;     -->  56032

select count(1) from album    -->  56032
cross join artist order by artist.name; -- ascending order is implicit (by default)

select artist.artistid, artist.name "Artist Name", album.title "Album Title", album.albumid
from
        album
cross join
        artist
order by artist.name; -- ascending order is implicit (by default)


/* ============================================================================================== */
--  7.5 SELF
--  Task – Perform a self-join on the employee table, joining on the reportsto column.
--  v1
        select
                    emp.employeeid, 
                    emp.firstname || ' ' || emp.lastname as "Emp. Name", 
                    emp.title, 
                    empMgr.firstname || ' ' || empMgr.lastname as "Reports To.",
                    emp.reportsto as "Manager ID",
                    empMgr.reportsto as "...",
                    emp.firstname || ' ' || emp.lastname || ' (' || emp.title || ') => ' || empMgr.firstname || ' ' || empMgr.lastname as "Employee (T) => Reports To."
        from  employee  emp, 
                employee  empMgr
        where 
                emp.employeeid <> empMgr.employeeid
           and 
                emp.reportsto = empMgr.employeeid;
                
--  v2
        select emp.employeeid, 
                  emp.firstname || ' ' || emp.lastname as "Emp. Name", 
                  emp.title, 
                  emp.reportsto,
                  nvl(( select e.firstname || ' ' || e.lastname as "Reports To." from employee e where e.employeeid = emp.reportsto ), ' - no one - ') as "Reports To."
        from employee emp;


/* ============================================================================================== */
--  7.6 Complicated Join assignment
--  Create an inner join between all tables in the chinook database.
/*
    album
    artist
    customer
    employee
    genre
    invoice
    invoiceline
    mediatype
    playlist
    playlisttrack
    track
*/

--  v1
select
            artist.name as "Artist Name", album.title as "Album Title",
            track.name as "Track Name", to_char(track.unitprice, '$9,999.99') as "Unit Price",
            genre.name as "Genre Name", playlist.name as "Playlist",
            mediatype.name as "Media Type",
            invoice.invoiceid || ' - ' || invoice.invoicedate || ' [ $' || invoice.total || ' ] ' as "Invoice# - Date - [ $Total ]",
            customer.firstname || ' ' || customer.lastname as "Customer",
            nvl(( select e.firstname || ' ' || e.lastname || ' (' || e.title || ') => ' || empMgr.firstname || ' ' || empMgr.lastname || ' (' || empMgr.title || ')'
                    from employee e where e.employeeid = empMgr.reportsto ), ' - no one - ') as "Employee(T) => ReportsTo.(T)"
from
                artist
-- Artist has many albums
inner join  album
on  artist.artistid = album.artistid

-- Album has many tracks
inner join  track
on  album.albumid = track.albumid

-- Track belongs to mediatype
    inner join  mediatype
    on  track.mediatypeid = mediatype.mediatypeid
    
-- Track belongs to genre(s)
    inner join genre
    on  track.genreid = genre.genreid

-- Track has many (is in) playlists ( through cross join table )
inner join  playlisttrack
on  track.trackid = playlisttrack.trackid

--  Playlist has many tracks ( through cross join table )
inner join  playlist
on  playlisttrack.playlistid = playlist.playlistid

--  InvoiceLine contains (belongs to)* many tracks*
inner join  invoiceline
on  track.trackid = invoiceline.trackid

--  InvoiceLine belongs to invoice
--  Invoice has many InvoiceLines
inner join  invoice
on  invoiceline.invoiceid = invoice.invoiceid

--  Invoice belongs to customer
--  Customer has many invoices
inner join customer
on  invoice.customerid = customer.customerid

--  Customer belongs to employee
--  Employee has many customers
inner join  employee emp
on  customer.supportrepid = emp.employeeid

-- Employee reports to self.employee [manager]
inner join  employee empMgr
on  emp.employeeid = empMgr.employeeid;
/*where 
            emp.employeeid <> empMgr.employeeid
and 
            emp.reportsto = empMgr.employeeid;*/

--  v2
create or replace view v_chinookdb ( "ArtistName", "AlbumTitle", "TrackName", "UnitPrice", "GenreName", "Playlist", "MediaType", "InvoiceDateTotal",
                                                    "Customer", "EmployeeReportsTo") as
select
            artist.name as "ArtistName", album.title as "AlbumTitle",
            track.name as "TrackName", to_char(track.unitprice, '$9,999.99') as "UnitPrice",
            genre.name as "GenreName", playlist.name as "Playlist",
            mediatype.name as "MediaType",
            invoice.invoiceid || ' - ' || invoice.invoicedate || ' [ $' || invoice.total || ' ] ' as "InvoiceDateTotal",
            customer.firstname || ' ' || customer.lastname as "Customer",
            nvl(( select e.firstname || ' ' || e.lastname || ' (' || e.title || ') => ' || empMgr.firstname || ' ' || empMgr.lastname || ' (' || empMgr.title || ')'
                    from employee e where e.employeeid = empMgr.reportsto ), ' - N/A - ') as "EmployeeReportsTo"
from
                artist
-- Artist has many albums
inner join  album
on  artist.artistid = album.artistid

-- Album has many tracks
inner join  track
on  album.albumid = track.albumid

-- Track belongs to mediatype
    inner join  mediatype
    on  track.mediatypeid = mediatype.mediatypeid
    
-- Track belongs to genre(s)
    inner join genre
    on  track.genreid = genre.genreid

-- Track has many (is in) playlists ( through cross join table )
inner join  playlisttrack
on  track.trackid = playlisttrack.trackid

--  Playlist has many tracks ( through cross join table )
inner join  playlist
on  playlisttrack.playlistid = playlist.playlistid

--  InvoiceLine contains (belongs to)* many tracks*
inner join  invoiceline
on  track.trackid = invoiceline.trackid

--  InvoiceLine belongs to invoice
--  Invoice has many InvoiceLines
inner join  invoice
on  invoiceline.invoiceid = invoice.invoiceid

--  Invoice belongs to customer
--  Customer has many invoices
inner join customer
on  invoice.customerid = customer.customerid

--  Customer belongs to employee
--  Employee has many customers
inner join  employee emp
on  customer.supportrepid = emp.employeeid

-- Employee reports to self.employee [manager]
inner join  employee empMgr
on  emp.employeeid = empMgr.employeeid;
            
select * from v_chinookdb;
    
