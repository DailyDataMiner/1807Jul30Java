/*
  Omar Acevedo Week 2 Assignment
    HW src -> https://github.com/genesisb17/1807Jul30Java/blob/master/Week2/Assignment_SQL_WorkBook_Latest.pdf
    - TASKS -
*/

-- 2.1 SELECT
select * from employee;
select * from employee where lastname = 'King';
select * from employee 
where firstname = 'Andrew' and reportsto is null;

-- 2.2 ORDER BY
select * from album order by title desc;
select firstname from customer order by city; --implicit asc

-- 2.3 INSERT INTO
insert into genre (genreid, name) values (26, 'Salsa');
insert into genre (genreid, name) values (27, 'Power Metal');
insert into employee 
(
EMPLOYEEID
,LASTNAME  
,FIRSTNAME 
,TITLE     
,REPORTSTO 
,BIRTHDATE 
,HIREDATE  
,ADDRESS   
,CITY      
,STATE     
,COUNTRY   
,POSTALCODE
,PHONE     
,FAX       
,EMAIL     
) values 
(
9,
'Acevedo', 
'Omar',
'FS Developer',
6,
'01/05/90',
'02/11/18',
'RR17 BOX 11362',
'San Juan',	
'PR',
'Puerto Rico',
'00926',
'+1 (787) 505-4781',
'+1 (000) 000-0000',
'omaace@gmail.com'
);

insert into employee 
(
EMPLOYEEID
,LASTNAME  
,FIRSTNAME 
,TITLE     
,REPORTSTO 
,BIRTHDATE 
,HIREDATE  
,ADDRESS   
,CITY      
,STATE     
,COUNTRY   
,POSTALCODE
,PHONE     
,FAX       
,EMAIL     
) values 
(
10,
'Odeveca', 
'Ramo',
'Barista',
1,
'01/05/90',
'02/11/18',
'RR17 BOX 11362',
'San Juan',	
'PR',
'Puerto Rico',
'00926',
'+1 (787) 505-4781',
'+1 (000) 000-0000',
'omaace@gmail.com'
);

insert into customer 
(
CUSTOMERID   
,FIRSTNAME    
,LASTNAME     
,COMPANY      
,ADDRESS      
,CITY         
,STATE        
,COUNTRY      
,POSTALCODE   
,PHONE        
,FAX          
,EMAIL        
,SUPPORTREPID
)
values
(
60,
'Katarot',
'Acevedo^2',
null,
'Carr. 176 Camino Cuatro Calles, Cupey Alto',
'San Juan',
'PR',
'Puerto Rico',
'00926',
'+1 787 5054781',
null,
'omar@mail.com',
3
);

insert into customer 
(
CUSTOMERID   
,FIRSTNAME    
,LASTNAME     
,COMPANY      
,ADDRESS      
,CITY         
,STATE        
,COUNTRY      
,POSTALCODE   
,PHONE        
,FAX          
,EMAIL        
,SUPPORTREPID
)
values
(
61,
'omariux',
'Ace2',
null,
'Carr. 176 Camino Cuatro Calles, Cupey Alto',
'San Juan',
'PR',
'Puerto Rico',
'00926',
'+1 787 5054781',
null,
'omar@mail.com',
5
);

--  2.4 UPDATE
-- V1
--  Check customer id to update next.
        select customerid from customer 
        where firstname = 'Aaron' and lastname = 'Mitchell';
--  Update customer based on id found.
        update customer 
        set firstname = 'Robert', lastname = 'Walter' 
        where customerid = 32;

-- V2
declare
    l_custid customer.customerid%type;
begin
    select customerid into l_custid
    from customer 
    where firstname = 'Aaron' and lastname = 'Mitchell';
    
    update customer 
    set firstname = 'Robert', lastname = 'Walter' 
    where customerid = l_custid;
    
    commit;
end;
/

-- Verify changes
select * from customer where customerid = 32;
select * from artist where name = 'Creedence Clearwater Revival';

update artist 
set name = 'CCR' 
where artistid = 76;

-- Verify changes
select * from artist where artistid = 76;
commit;

-- 2.5 LIKE
select * from invoice where billingaddress like 'T%';

-- 2.6. BETWEEN
select * from invoice where total between 15 and 50;
-- v1
select * from employee 
where hiredate between '01/06/03' and '01/03/04';
-- v2
select * from employee 
where hiredate between to_date('01/JUN/2003', 'DD/MON/YYYY') 
and to_date('01/MAR/2004', 'DD/MON/YYYY');

-- 2.7 DELETE
-- Delete a record in Customer table where the name is Robert Walter
-- ( There may be constraints that rely on this, find out how to resolve them. )
-- There may be two ways of doing this;

-- 1) Find the fk constraint of the table customer, 
delete from customer 
where firstname = 'Robert'
and lastname = 'Walter';   
--> ORA-02292: integrity constraint (OMARACEDB.FK_INVOICECUSTOMERID) violated - child record found

select * from invoice;

/* Constraint defined in INVOICE table sql .
        CONSTRAINT "FK_INVOICECUSTOMERID" FOREIGN KEY ("CUSTOMERID")
        REFERENCES "OMARACEDB"."CUSTOMER" ("CUSTOMERID") ENABLE     */

-- View data relation (1:N) between customer and invoice
select * from invoice
where customerid = (select customerid from customer 
                    where firstname = 'Robert'
                    and lastname = 'Walter');

-- Get invoice.customerid from query before, => 32
-- and delete -> 
delete from invoice where customerid = 32;
--> ORA-02292: integrity constraint (OMARACEDB.FK_INVOICELINEINVOICEID) violated - child record found

-- Get all invoices from customer 32 ( Robert Walter ) that are on invoice line table.
select * from invoiceline 
where invoiceid in (select invoiceid 
                    from invoice 
                    where customerid = 32);

delete from invoiceline 
where invoiceid in (select invoiceid 
                    from invoice 
                    where customerid = 32);
--> 29 rows deleted.
    
delete from invoice
where customerid = (select customerid from customer 
                    where firstname = 'Robert'
                    and lastname = 'Walter');
--> 7 rows deleted.

delete from customer 
where firstname = 'Robert'
and lastname = 'Walter';

--> 1 row deleted.

rollback;

-- 2) Do stuff with table constraints.
begin
    recreateConstraints('invoiceline');
    recreateConstraints('invoice');
end;
/
