-- Status
insert into p1_reimbursement_status (REIMBURSEMENT_STATUS_NAME) values ('PENDING');
insert into p1_reimbursement_status (REIMBURSEMENT_STATUS_NAME) values ('APPROVED');
insert into p1_reimbursement_status (REIMBURSEMENT_STATUS_NAME) values ('DENIED');

commit;

select * from p1_reimbursement_status;

-- Types
insert into p1_reimbursement_types (REIMBURSEMENT_TYPE_NAME) values ('');
