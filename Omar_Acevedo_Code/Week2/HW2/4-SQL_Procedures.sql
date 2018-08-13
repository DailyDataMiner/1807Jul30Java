/* ============================================================================================== */
--  4.0 Stored Procedures
--  In this section you will be creating and executing stored procedures. 
--  You will be creating various types of stored procedures that take input and output parameters.
/* ============================================================================================== */
--  4.1 Basic Stored Procedure
--  Task – Create a stored procedure that selects the first and last names of all the employees.
create or replace procedure doEmployeeFNLN as
    l_emp_fn employee.firstname%type;
    l_emp_ln employee.lastname%type;
    l_emp_cursor sys_refcursor;
begin
    open l_emp_cursor for select firstname, lastname from employee;
    loop
        fetch l_emp_cursor
        into l_emp_fn, l_emp_ln;
        dbms_output.put_line('First Name: ' || l_emp_fn);
        dbms_output.put_line('Last Name:  ' || l_emp_ln );
        dbms_output.put_line('---------------------------------');
        exit when l_emp_cursor%notfound;
    end loop;
    close l_emp_cursor;
end;
/

exec doEmployeeFNLN;

/* ============================================================================================== */
--  4.2 Stored Procedure Input Parameters
--  Task – Create a stored procedure that updates the personal information of an employee.
create or replace procedure updateEmp_PersonalInfo( p_empid in employee.employeeid%type,
                                                                             p_empfn in employee.firstname%type,
                                                                             p_empln in employee.lastname%type,
                                                                             p_empbirthdate in employee.birthdate%type,
                                                                             p_empphone in employee.phone%type,
                                                                             p_empemail in employee.email%type) as
    l_id employee.employeeid%type;
    l_fn employee.firstname%type;
    l_ln employee.lastname%type;
begin
    
    select employeeid, firstname, lastname 
    into l_id, l_fn, l_ln 
    from employee where employeeid = p_empid;
    
    dbms_output.put_line( ' Will update personal information of employee ( ' || l_id || ' ): ');
    dbms_output.put_line( '     First name  ' || l_fn  );
    dbms_output.put_line( '     Last name  ' || l_ln  );
    
    update employee set   firstname = p_empfn,
                                    lastname = p_empln,
                                    birthdate = p_empbirthdate,
                                    phone = p_empphone,
                                    email = p_empemail
                             where employeeid = p_empid;     

    dbms_output.put_line( ' Personal information of employee ( ' || l_id || ' ) was updated. ');
    
    select employeeid, firstname, lastname 
    into l_id, l_fn, l_ln 
    from employee where employeeid = l_id;
    
    dbms_output.put_line( '     First name  ' || l_fn  );
    dbms_output.put_line( '     Last name  ' || l_ln  );
    
    commit;
    
end;
/

select * from employee where employeeid = 10;
exec updateEmp_PersonalInfo( 9, 'Mdddaro', 'Vedoafffce', '01/01/00', '(787) 000-000', 'ouimar@mail.com');

--  Task – Create a stored procedure that returns the managers of an employee.
create or replace procedure employeeManagers(p_employee in number, pc_managers out sys_refcursor) as
begin
    
    open pc_managers for
        select emp.employeeid, 
                  emp.firstname || ' ' || emp.lastname as "Emp. Name", 
                  emp.title, 
                  emp.reportsto,
                  ( select e.firstname || ' ' || e.lastname as "Reports To." from employee e where e.employeeid = emp.reportsto ) as "Reports To."
        from employee emp;
        
end;
/

declare
    lc_empManager sys_refcursor;
    --lrt_employee employee%recordtype;
    
    l_empid employee.employeeid%type;
    l_empname employee.firstname%type;
    l_emptitle employee.title%type;
    l_empreportsto employee.reportsto%type;
    l_empreportsto2 employee.reportsto%type;
    
   --l_empreportsto2 employee."Reports To."%type;
    
    --( select e.firstname || ' ' || e.lastname from employee e where e.employeeid = emp.reportsto ) as "Reports To."
    
begin
    employeeManagers(1, lc_empManager);
    loop
        --fetch lc_empManager into lrt_employee;
        fetch lc_empManager into l_empid,
                                              l_empname,
                                              l_emptitle,
                                              l_empreportsto,
                                              l_empreportsto2;
                  --( select e.firstname || ' ' || e.lastname from employee e where e.employeeid = emp.reportsto ) as "Reports To."
        exit when lc_empManager%notfound;
        --dbms_output.put_line( lrt_employee.title );
        dbms_output.put_line( l_empid );
        dbms_output.put_line( l_empname );
        dbms_output.put_line( l_emptitle );
        dbms_output.put_line( l_empreportsto );
        dbms_output.put_line( l_empreportsto2 );
    end loop;
    close lc_empManager;
end;
/

select emp.employeeid, emp.firstname || ' ' || emp.lastname as "Emp. Name", emp.title, emp.reportsto,
          ( select e.firstname || ' ' || e.lastname from employee e where e.employeeid = emp.reportsto ) as "Reports To."
from employee emp
where emp.employeeid = 8;


/* ============================================================================================== */
--  4.3 Stored Procedure Output Parameters
--  Task – Create a stored procedure that returns the name and company of a customer.
create or replace procedure findCustomerNameComp(p_custid in number, p_custname out varchar2, p_custcompany out varchar2) as
begin
    select firstname || ' ' || lastname as "Customer Name", nvl(company, 'NO-COMPANY')
    into p_custname, p_custcompany
    from customer where customerid = p_custid;
end;
/


declare
    l_custid number := 1;
    l_custname customer.firstname%type;
    l_custcompany customer.company%type;
begin
    -- [ example ]: Let's find customer with id 4
    findCustomerNameComp(l_custid, l_custname, l_custcompany);
    dbms_output.put_line(' Customer ( ' || l_custid || ' ) ');
    dbms_output.put_line(' Name: ' || l_custname);
    dbms_output.put_line(' Company: ' || l_custcompany);
end;
/

