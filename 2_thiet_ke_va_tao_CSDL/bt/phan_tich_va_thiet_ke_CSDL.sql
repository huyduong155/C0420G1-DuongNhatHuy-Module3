create database store;
use store;
create table customers(
customer_number int auto_increment not null,
customer_name varchar(50) not null,
contact_last_name varchar(50) not null, 
contact_first_name varchar(50) not null, 
phone varchar(50) not null, 
address_line1  varchar(50) not null, 
address_line2  varchar(50), 
city varchar(50) not null, 
state varchar(50) not null, 
postalCode varchar(15) not null, 
country varchar(50) not null, 
creditLimit float, 
primary key (customer_number)
);

create table orders(
order_number int auto_increment not null,
order_date  date not null,
required_date date not null,
shipped_date date,
`status` varchar(15) not null, 
comments text, 
quantity_ordered int not null,
price_each float not null,
primary key(order_number),
customer_id int,
foreign key(customer_id) references customers(customer_number)
);



create table product_lines (
product_line varchar(50) not null, 
text_description text,
image varchar(255),
primary key(product_line)
);

create table products (
product_code varchar(15) not null, 
product_name varchar(70) not null, 
product_scale varchar(10) not null, 
product_vendor varchar(50) not null, 
product_description text not null, 
quantity_inStock int not null, 
buy_price float not null, 
MSRP float not null, 
primary key(product_code),
product_line_id varchar(50),
foreign key (product_line_id) references product_lines(product_line)
);



create table employees (
employee_number int auto_increment not null,
last_name varchar(50) not null, 
first_name varchar(50) not null, 
email varchar(100) not null, 
job_title varchar(50) not null, 
primary key(employee_number),
report_to int,
foreign key(report_to) references employees(employee_number)
);

create table offices (
office_code varchar(10) not null, 
city varchar(50) not null, 
phone varchar(50) not null, 
address_line1 varchar(50) not null, 
address_line2 varchar(50) not null, 
state varchar(50) not null, 
country varchar(50) not null, 
postal_code varchar(15) not null, 
primary key(office_code)
);

create table order_details(
id int auto_increment not null,
order_id int,
product_id varchar(15),
primary key(id),
foreign key (order_id) references orders(order_number),
foreign key (product_id) references products(product_code)
); 

create table payments (
customer_number int auto_increment not null,
check_number varchar(50) not null, 
payment_date date not null,
amount float not null,
primary key (customer_number),
customer_id int,
sales_repemployee_number int, 
foreign key(customer_id) references customers(customer_number),
foreign key(sales_repemployee_number) references employees(employee_number)
);