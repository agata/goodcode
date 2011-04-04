create table account (id identity, name varchar, primary key (id));
create table todo (id identity, account_id integer, content varchar, primary key (id));

insert into account values (10000, 'user1');
insert into account values (10001, 'user2');
insert into account values (10002, 'user3');

insert into todo values (1, 10000, 'ToDo1');
insert into todo values (2, 10001, 'ToDo2');
insert into todo values (3, 10002, 'ToDo3');
