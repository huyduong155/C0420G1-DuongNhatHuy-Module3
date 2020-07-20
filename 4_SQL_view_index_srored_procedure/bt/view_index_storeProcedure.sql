create database Product_manager;
use Product_manager;
CREATE TABLE Product (
    id INT PRIMARY KEY AUTO_INCREMENT,
    product_code VARCHAR(50),
    product_name VARCHAR(50),
    product_price INT,
    product_amount INT,
    product_description VARCHAR(50),
    product_status VARCHAR(50)
);
INSERT INTO `Product_manager`.`product` (`product_code`, `product_name`, `product_price`, `product_amount`, `product_description`, `product_status`) 
VALUES 
('giay', 'trang tri', '40000', '3', 'abc', 'On'),
('dep', 'trang tri', '70000', '8', 'bcd', 'On'),
('ao', 'may mac', '20000', '2', 'abc', 'On'),
('quan', 'may mac', '20000', '2', 'bcd', 'On'),
('cap xach', 'may mac', '20000', '2', 'bcd', 'On');

CREATE UNIQUE INDEX idx_product_code
ON Product (product_code);

CREATE INDEX idx_composite
ON  Product (product_name, product_price);

explain select * from Product
where product_code="giay";

explain select * from Product
where product_name="may mac";

CREATE VIEW product_view AS
    SELECT 
        product_code, product_name, product_price, product_status
    FROM
        product;

SELECT 
    *
FROM
    product_view;

UPDATE product_view 
SET 
    product_name = 'dep lao'
WHERE
    product_code = 'dep';

SELECT 
    *
FROM
    product_view;

drop view product_view;
​
delimiter //
create procedure showAll ()
begin
	select *
    from Product;
END; //
delimiter ;

call showAll();
​
delimiter //
create procedure insertAll (v_code varchar(50),v_name varchar(50), v_price varchar(50),v_amount varchar(50),v_des varchar(50),v_status varchar(50))
begin
	insert into Product(product_code,product_name,product_price,product_amount,product_description,product_status)
    values
    (v_code,v_name,v_price,v_amount,v_des,v_status);
END; //
delimiter ;

call insertAll("tu","do dung",200000,6,"abc","Off");
​
delimiter //
create procedure updateAll (v_code varchar(50),fied_name varchar(50),valuee varchar(50))
begin
	update Product
    set fied_name=valuee
	where product_code=v_code;
END; //
delimiter ;

drop procedure updateAll;

call updateAll("tu",product_name,"tu do");
​
delimiter //
create procedure deleteAll (v_id int)
begin
	delete from Product
	where id=v_id;
END; //
delimiter ;
call deleteAll(1);
