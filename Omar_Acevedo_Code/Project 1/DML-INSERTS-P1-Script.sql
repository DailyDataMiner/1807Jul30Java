-- User Roles
insert into p1_user_roles (ROLENAME) values ('Finance Manager');
insert into p1_user_roles (ROLENAME) values ('Secretary');
insert into p1_user_roles (ROLENAME) values ('Accountant');
insert into p1_user_roles (ROLENAME) values ('Software Engineer');
insert into p1_user_roles (ROLENAME) values ('Junior Technical Author');
insert into p1_user_roles (ROLENAME) values ('Sales Assistant');
insert into p1_user_roles (ROLENAME) values ('Office Manager');
insert into p1_user_roles (ROLENAME) values ('Systems Administrator');
insert into p1_user_roles (ROLENAME) values ('Regional Director');
insert into p1_user_roles (ROLENAME) values ('Regular Employee');

commit;

select * from p1_user_roles;

--Users
insert into p1_users (USERNAME, PASSWORD, FIRSTNAME, LASTNAME, EMAIL, USER_ROLE_ID, REPORTS_TO)
values 
('omarace', 'qwerty12345', 'Omar', 'Acevedo', 'omaace@gmail.com', 1, null);

insert into p1_users (USERNAME, PASSWORD, FIRSTNAME, LASTNAME, EMAIL, USER_ROLE_ID, REPORTS_TO)
values 
('ramo', '12345qwerty', 'Ramo', 'Odeveca', 'ramo@mail.com', 10, 1);

commit;

select * from p1_users;


-- Status
insert into p1_reimbursement_status (REIMBURSEMENT_STATUS_NAME) values ('PENDING');
insert into p1_reimbursement_status (REIMBURSEMENT_STATUS_NAME) values ('APPROVED');
insert into p1_reimbursement_status (REIMBURSEMENT_STATUS_NAME) values ('DENIED');

commit;

select * from p1_reimbursement_status;


-- Types
insert into p1_reimbursement_types (REIMBURSEMENT_TYPE_NAME) values ('FOOD');
insert into p1_reimbursement_types (REIMBURSEMENT_TYPE_NAME) values ('LODGING');
insert into p1_reimbursement_types (REIMBURSEMENT_TYPE_NAME) values ('TRAVEL');
insert into p1_reimbursement_types (REIMBURSEMENT_TYPE_NAME) values ('SUPPLIES');
insert into p1_reimbursement_types (REIMBURSEMENT_TYPE_NAME) values ('OFFICE SUPPLIES');
insert into p1_reimbursement_types (REIMBURSEMENT_TYPE_NAME) values ('ENTERTAINMENT');
insert into p1_reimbursement_types (REIMBURSEMENT_TYPE_NAME) values ('TRANSPORTATION');
insert into p1_reimbursement_types (REIMBURSEMENT_TYPE_NAME) values ('GAS');
insert into p1_reimbursement_types (REIMBURSEMENT_TYPE_NAME) values ('ACCOMODATION');

commit;

select * from p1_reimbursement_types;

-- Tickets added first
-- Reimbursements added second
--  *sequentially
-- Create a procedure that would insert in both tables; first, tickets, then reimbursements
insert into p1_tickets (CREATED_BY, REIMBURSEMENT_ID) values (2, 1);
insert into p1_reimbursements (
    NAME, DESCRIPTION, AMOUNT, CREATED_BY, 
    REIMBURSEMENT_TYPE_ID, REIMBURSEMENT_STATUS_ID, RECEIPT, TICKET_ID)
values (
    'Meal expense request reimbursement', 'Food was bought and eaten, now I want my money back!', 
    120.53, 2, 1, 1, null, 1
);

insert into p1_tickets (CREATED_BY, REIMBURSEMENT_ID) values (1, 1);
insert into p1_tickets (CREATED_BY, REIMBURSEMENT_ID) values (2, 2);
insert into p1_tickets (CREATED_BY, REIMBURSEMENT_ID) values (1, 1);
insert into p1_tickets (CREATED_BY, REIMBURSEMENT_ID) values (4, 4);

select * from p1_tickets;
select * from p1_reimbursements;
desc p1_reimbursement_types;
desc p1_reimbursement_status;

select  tickets.ticket_id, tickets.type, tickets.status, tickets.created_on, tickets.created_by,
          reimbs.name, reimbs.description, reimbs.amount, approved_denied_by, reimbs.approved_denied_on, 
          (select rtype.REIMBURSEMENT_TYPE_NAME from p1_reimbursement_types rtype where rtype.REIMBURSEMENT_TYPE_ID = reimbs.REIMBURSEMENT_TYPE_ID) as "Rmb Type",
          (select rstatus.REIMBURSEMENT_STATUS_NAME from p1_reimbursement_status rstatus where rstatus.REIMBURSEMENT_STATUS_ID = reimbs.REIMBURSEMENT_STATUS_ID) as "Rmb Status",
          reimbs.receipt
from p1_tickets tickets
inner join p1_reimbursements reimbs
on tickets.ticket_id = reimbs.ticket_id;

create or replace view v_tickets_reimbursements as
    select  tickets.ticket_id, tickets.type, tickets.status, tickets.created_on, tickets.created_by,
              reimbs.name, reimbs.description, reimbs.amount, approved_denied_by, reimbs.approved_denied_on, 
              (select rtype.REIMBURSEMENT_TYPE_NAME from p1_reimbursement_types rtype where rtype.REIMBURSEMENT_TYPE_ID = reimbs.REIMBURSEMENT_TYPE_ID) as "Rmb Type",
              (select rstatus.REIMBURSEMENT_STATUS_NAME from p1_reimbursement_status rstatus where rstatus.REIMBURSEMENT_STATUS_ID = reimbs.REIMBURSEMENT_STATUS_ID) as "Rmb Status",
              reimbs.receipt
    from p1_tickets tickets
    inner join p1_reimbursements reimbs
    on tickets.ticket_id = reimbs.ticket_id;

select * from v_tickets_reimbursements;