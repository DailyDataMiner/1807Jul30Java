create table player_stats(
                          pid number(10),
                          name varchar2(200),
                          attempts number(10),
                          made number(10),
                          shooting_percentage number(10));
                          
insert into player_stats values(0, 'Mean Mike', 1000, 300, 30);
insert into player_stats values(34, 'Steph Curry', 10000, 9000, 90);
insert into player_stats values(19, 'Dunking Adams', 100, 99, 99);
insert into player_stats values(20, 'Wild Will', 7102, 4021, 99);

select * from player_stats;

create or replace function calc_shoot_avg(att number, made number)
return number is percentage number(10);
begin
percentage := made/att*100;
return percentage;
end;
/

update player_stats set shooting_percentage = calc_shoot_avg(7102, 4021)
where pid = 20;

create sequence pid_generator
minvalue 0
start with 100
increment by 1;

create or replace procedure insert_player(name varchar2, attempts number, made number)
is
begin
insert into player_stats values (pid_generator.nextval, name, attempts, made, calc_shoot_avg(attempts, made));
end;
/

exec insert_player('Kobe', 9999, 4000);
exec insert_player('Mikey Jordie', 1000, 999);

create table retired_player
(
  pid number(10),
  name varchar2(200),
  attempts number(10),
  made number(10),
  shooting_percentage number(10)
);

create or replace trigger retiring_player
before delete on player_stats
for each row
begin
insert into retired_player
values
(
  :old.pid,
  :old.name,
  :old.attempts,
  :old.made,
  :old.shooting_percentage
);
end;
/

select * from player_stats;
select * from retired_player;

delete from player_stats where pid=101;