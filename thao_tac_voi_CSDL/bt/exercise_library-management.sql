create database library_management;
use library_management;

create table readers(
	id int primary key,
    student_name varchar(30) not null,
    address varchar(500),
    email varchar(50),
    image varchar(255)
    );
    

create table categories(
	id int primary key,
    category_name varchar(200),
	book_id int
    );
    
create table authors(
	id int primary key auto_increment,
    author_name varchar(200)
    );
    
create table books(
	id int primary key,
    book_name varchar(200),
    `description` text not null,
    category_id int,
    author_id varchar(20),
    foreign key (category_id) references categories(id)
    );
    
create table author_book(
	book_id int,
    author_id int,
    primary key(book_id,author_id),
    foreign key (book_id) references books(id),
    foreign key (author_id) references authors(id)
    );
    
create table borrow_book(
	book_id int,
    reader_id int,
    primary key (book_id, reader_id),
    foreign key (book_id) references books(id),
    foreign key (reader_id) references readers(id)
    )
    
    drop database library_management;
    
