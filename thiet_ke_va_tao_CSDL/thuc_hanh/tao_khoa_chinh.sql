create database test;
use test;

create table users (
user_id int auto_increment primary key,
username varchar(40),
password varchar(255),
email varchar(255)
);

create table roles(
role_id int auto_increment,
role_name varchar(50) not null,
primary key (role_id)
);

create table usersrolles(
role_id int not null,
user_id int not null,
primary key(role_id,user_id),
foreign key(role_id) references roles(role_id),
foreign key(user_id) references users(user_id)
);