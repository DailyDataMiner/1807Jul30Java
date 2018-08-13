/* ============================================================================================== */
--  5.0 Transactions
--  In this section you will be working with transactions. Transactions are usually nested within a stored procedure.
--  Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).
create or replace procedure deleteInvoice(p_invid in number) is
    
begin
    dbms_output.put_line( ' Will now delete invoice id ' || p_invid );
    delete from invoice where invoiceid = 4;    -- the was a constraint here, ... but deleted it... -> I need to put it again, to deal with this the "normal"/"ok" way
    dbms_output.put_line( ' ... ' );
    --commit;
    dbms_output.put_line( ' Row data from table invoice ' || p_invid );
end;
/
select * from invoice where invoiceid = 4;

--  4	14	06/01/09	8210 111 ST NW	Edmonton	AB	Canada	T6G 2C7	8.91

--  Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table
create or replace procedure createNewCustomer( p_firstname in customer.firstname%type,
                                                                       p_lastname in customer.lastname%type,
                                                                       p_company in customer.company%type,
                                                                       p_address in customer.address%type,
                                                                       p_city in customer.city%type,
                                                                       p_state in customer.state%type,
                                                                       p_country in customer.country%type,
                                                                       p_postalcode in customer.postalcode%type,
                                                                       p_phone in customer.phone%type,
                                                                       p_fax in customer.fax%type,
                                                                       p_email in customer.email%type,
                                                                       p_supportrepid in customer.supportrepid%type) as
    l_custid customer.customerid%type;                                                                    
begin

    dbms_output.put_line( ' Transaction started. ' );
    dbms_output.put_line( ' Creating new customer... ' );
    
    insert into customer 
    ( FIRSTNAME, LASTNAME,COMPANY, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL, SUPPORTREPID )
    values
    (
        p_firstname,
        p_lastname,
        p_company,
        p_address,
        p_city,
        p_state,
        p_country,
        p_postalcode,
        p_phone,
        p_fax,
        p_email,
        p_supportrepid
    );

    commit;
    
    -- Get last customer inserted
    select max(customerid) into l_custid from customer;
    
    dbms_output.put_line( ' Customer ( id: ' || l_custid || ') ' );
    
    for c in (select * from customer where customerid = l_custid) loop
        dbms_output.put_line( 'Name: ' || c.firstname || ' ' || c.lastname );
        dbms_output.put_line( 'Email: ' || c.email );
        dbms_output.put_line( 'Company: ' || c.company );
    end loop;
    
    dbms_output.put_line( ' Transaction End ' );
    
    exception 
        when others then
            dbms_output.put_line(dbms_utility.format_error_backtrace);
            raise;
end;
/

-- Check last added customer before creating a new one.
select * from customer order by customerid desc;

-- Run the procedure to create (insert into table) a new customer.
begin
createNewCustomer(   p_firstname => 'Maro', 
                                        p_lastname => 'Vedo',
                                        p_company => 'My Company',
                                        p_address => 'my place',
                                        p_city => 'Aguadilla',
                                        p_state => 'N/A',
                                        p_country => 'PR',
                                        p_postalcode => '00926',
                                        p_phone => '34920222',
                                        p_fax => '32904329023',
                                        p_email => 'maro@mail.com',
                                        p_supportrepid => 5);
end;
/

-- Verify new customer added.
select * from customer order by customerid desc;


