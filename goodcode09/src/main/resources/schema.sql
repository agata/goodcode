create table account (id identity, name varchar, primary key (id));
create table todo (id identity, account_id integer, content varchar, primary key (id));
