create database customers;

use customers;

create table contacts (
contact_id int(11) not null auto_increment,
last_name varchar(30) not null,
first_name varchar(25),
birthday date,
constraint contacts_pk primary key(contact_id)  
);
use customers;
create table suppliers (
supplier_id int(11) not null auto_increment,
supplier_name varchar(50) not null,
account_rep varchar(30) not null default 'TDB',
constraint suppliers_pk primary key (supplier_id)
); 

alter table contacts
add last_name varchar(40) not null
after contact_id,
add first_name varchar(35) null
after contact_id;

alter table contacts
modify last_name varchar(50) null;

alter table contacts
drop column birthday;

alter table contacts
change column first_name first_n
varchar(20) not null;

alter table contacts
rename to people;

drop table people,suppliers;
drop database customers;