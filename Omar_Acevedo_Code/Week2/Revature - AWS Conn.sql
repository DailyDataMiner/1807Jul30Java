create or replace procedure recreateConstraints(p_tablename varchar2) as
    l_sqlStatement varchar2(230);
begin

    /* Redo or recreate Constraints */
    
    if p_tablename = 'invoiceline' then
        
        dbms_output.put_line('Altering INVOICELINE table');
        dbms_output.put_line('Dropping constraint: FK_INVOICELINEINVOICEID.');
        
        -- Delete constraint FK_INVOICELINEINVOICEID from table omaracedb.invoiceline
        --l_sqlStatement := 'alter table invoiceline drop constraint FK_INVOICELINEINVOICEID';
        --execute immediate l_sqlStatement;
        
        dbms_output.put_line('Altering INVOICELINE table');
        dbms_output.put_line('Adding constraint: FK_INVOICELINEINVOICEID with ON DELETE CASCADE.');
        mvn -v
        l_sqlStatement := 'alter table invoiceline ';
        l_sqlStatement := l_sqlStatement || 'add constraint FK_INVOICELINEINVOICEID ';
        l_sqlStatement := l_sqlStatement || 'foreign key (invoiceid) ';
        l_sqlStatement := l_sqlStatement || 'references invoice (invoiceid) enable ';
        l_sqlStatement := l_sqlStatement || 'on delete cascade ';

        execute immediate l_sqlStatement;   
        
        dbms_output.put_line('Constraint FK_INVOICELINEINVOICEID added succesfully.');
    
    end if;
    
    if p_tablename = 'invoice' then
    
        dbms_output.put_line('Altering INVOICE table');
        dbms_output.put_line('Dropping constraint: FK_INVOICECUSTOMERID.');
        
        -- Delete constraint FK_INVOICECUSTOMERID from table omaracedb.invoices
        --l_sqlStatement := 'alter table invoice drop constraint FK_INVOICECUSTOMERID';
        --execute immediate l_sqlStatement;
        
        dbms_output.put_line('Altering INVOICE table');
        dbms_output.put_line('Adding constraint: FK_INVOICECUSTOMERID with ON DELETE CASCADE.');
    
        l_sqlStatement := 'alter table invoice ';
        l_sqlStatement := l_sqlStatement || 'add constraint FK_INVOICECUSTOMERID ';
        l_sqlStatement := l_sqlStatement || 'foreign key (customerid) ';
        l_sqlStatement := l_sqlStatement || 'references customer (customerid) enable ';
        l_sqlStatement := l_sqlStatement || 'on delete cascade';
                            
        execute immediate l_sqlStatement;
        
        dbms_output.put_line('Constraint FK_INVOICECUSTOMERID added succesfully.');
        
    end if;
    
    exception 
        when others then
            dbms_output.put_line(SQLERRM);
            raise_application_error(-20001, 'An error was encountered - '||SQLCODE||' -ERROR- '||SQLERRM);
    
    commit;
    
end;
