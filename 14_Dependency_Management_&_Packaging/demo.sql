CREATE DATABASE demo;
USE demo;

create table users (
 id  int(3) NOT NULL AUTO_INCREMENT,
 `name` varchar(120) NOT NULL,
 email varchar(220) NOT NULL,
 country varchar(120),
 PRIMARY KEY (id) 
);

create table permision (
id int(11) auto_increment,
name varchar(50),
primary key (id)
);

create table users_permision (
permision_id int(11),
user_id int(11),
foreign key (permision_id) references permision (id) on delete cascade,
foreign key (user_id) references users (id) on delete cascade
);


insert into Permision(name) values('add');
insert into Permision(name) values('edit');
insert into Permision(name) values('delete');
insert into Permision(name) values('view');

insert into users(`name`, email, country) values('Minh','minh@codegym.vn','Viet Nam');
insert into users(`name`, email, country) values('Kante','kante@che.uk','Kenia');
insert into users(`name`, email, country) values('yoshida','yoshida@che.uk','Nhat Ban');
insert into users(`name`, email, country) values('ronaldo','ronaldo@che.uk','Bo Dao Nha');

DELIMITER //
create procedure search_by_country(v_country varchar(50))
begin
select id, `name`, email, country
from users
where country like concat('%', v_country, '%');
end
//DELIMITER ;

DELIMITER $$
CREATE PROCEDURE get_user_by_id(IN user_id INT)
BEGIN
    SELECT users.`name`, users.email, users.country
    FROM users
    where users.id = user_id;
    END$$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE insert_user(
IN user_name varchar(50),
IN user_email varchar(50),
IN user_country varchar(50)
)
BEGIN
    INSERT INTO users(`name`, email, country) VALUES(user_name, user_email, user_country);
    END$$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE insert_user1(
IN user_name varchar(50),
IN user_email varchar(50),
IN user_country varchar(50),
in permisionId int,
in userId int
)
BEGIN
    INSERT INTO users(`name`, email, country) VALUES(user_name, user_email, user_country);
    insert into users_permision (permision_id,user_id) value(permisionId,userId);
    END$$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE get_all_user()
BEGIN
    SELECT *
    FROM users;
    END$$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE update_user(
IN user_name varchar(50),
IN user_email varchar(50),
IN user_country varchar(50),
IN user_id INT
)
BEGIN
    update users 
set users.`name`= user_name, users.email = user_email, users.country = user_country
where users.id = user_id;
    END$$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE delete_user(IN user_id INT)
BEGIN
    delete 
    FROM users
    where users.id = user_id;
    END$$
DELIMITER ;
