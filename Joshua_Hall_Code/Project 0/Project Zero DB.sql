create table account_type(
  account_type_id number(10) primary key,
  name varchar2(16) not null unique
);

create table users(
  user_id number(10) primary key,
  first_name varchar2(32) not null,
  last_name varchar2(32) not null,
  username varchar2(32) not null unique,
  password varchar2(32) not null
);

create table accounts(
  account_id number(10) primary key,
  user_id number(10) not null,
  account_type_id number(10) not null,
  account_name varchar2(16) default 'New Account',
  balance number(10,2) default 0.00,
  foreign key (user_id) references users(user_id),
  foreign key (account_type_id) references account_type(account_type_id)
);

create or replace function get_acc_type(id number)
return varchar2 is letter varchar2(1);
begin
  select substr(name, 1, 1) into letter from account_type where ACCOUNT_TYPE_ID = id;
  return letter;
end;

insert into account_type values(1, 'Checking');
insert into account_type values(2, 'Savings');

create sequence id_gen;

insert into users values(id_gen.nextval, 'Alpha', 'One', 'usrA1', 'pwdA1');
insert into users values(id_gen.nextval, 'Beta', 'Two', 'usrB2', 'pwdB2');
insert into accounts values(id_gen.nextval, 1, 1, 'C_ACC_A1', 3.14);
insert into accounts values(id_gen.nextval, 1, 2, 'S_ACC_A1', 0.00);
insert into accounts values(id_gen.nextval, 2, 1, 'C_ACC_B2', 0.00);
insert into accounts values(id_gen.nextval, 2, 2, 'S_ACC_B2', 0.00);
