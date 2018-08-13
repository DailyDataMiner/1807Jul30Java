--  6.0 Triggers
--  In this section you will create various kinds of triggers that work when certain DML statements are executed on a table.
--  6.1 AFTER/FOR
--  Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
create or replace trigger ai_employee_trig
  after insert on employee
  begin
      --if :new.employeeid is not null then
        --dbms_output.put_line(' A new record has been inserted -> ' || :new.employeeid);
        dbms_output.put_line(' A new record has been inserted ' );
      --end if;
  end;
/
insert into employee (
    --employeeid,
    LASTNAME,
    FIRSTNAME
) values (
  --100,
  'Roma',
  'Amor'
);

--  Task – Create an after update trigger on the album table that fires after a row is inserted in the table
--create or replace trigger au_album_trig
--    after update on album
--    for 

--  Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.


