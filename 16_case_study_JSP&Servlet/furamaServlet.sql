create database furamaServlet;
use furamaServlet;


CREATE TABLE vi_tri (
    id_vi_tri INT auto_increment,
    ten_vi_tri VARCHAR(45),
    PRIMARY KEY (id_vi_tri)
);

CREATE TABLE trinh_do (
    id_trinh_do INT auto_increment,
    trinh_do VARCHAR(45),
    PRIMARY KEY (id_trinh_do)
);

CREATE TABLE bo_phan (
    id_bo_phan INT auto_increment,
    ten_bo_phan VARCHAR(45),
    PRIMARY KEY (id_bo_phan)
);

CREATE TABLE nhan_vien (
    id_nhan_vien INT auto_increment,
    ho_ten VARCHAR(50),
    ngay_sinh DATE,
    so_CMND VARCHAR(45),
    luong VARCHAR(45),
    SDT VARCHAR(45),
    email VARCHAR(45),
    dia_chi VARCHAR(45),
    id_vi_tri INT,
    id_trinh_do INT,
    id_bo_phan INT,
    PRIMARY KEY (id_nhan_vien),
    FOREIGN KEY (id_vi_tri)
        REFERENCES vi_tri (id_vi_tri),
    FOREIGN KEY (id_trinh_do)
        REFERENCES trinh_do (id_trinh_do),
    FOREIGN KEY (id_bo_phan)
        REFERENCES bo_phan (id_bo_phan)
);

CREATE TABLE loai_khach (
    id_loai_khach INT auto_increment,
    ten_loai_khach VARCHAR(45),
    PRIMARY KEY (id_loai_khach)
);

CREATE TABLE khach_hang (
    id_khach_hang INT auto_increment,
    ho_ten VARCHAR(45),
    ngay_sinh DATE,
    so_CMND VARCHAR(45),
    SDT VARCHAR(45),
    email VARCHAR(45),
    dia_chi VARCHAR(45),
    id_loai_khach INT,
    PRIMARY KEY (id_khach_hang),
    FOREIGN KEY (id_loai_khach)
        REFERENCES loai_khach (id_loai_khach)
);

CREATE TABLE kieu_thue (
    id_kieu_thue INT auto_increment,
    ten_kieu_thue VARCHAR(45),
    gia INT,
    PRIMARY KEY (id_kieu_thue)
);

CREATE TABLE loai_dich_vu (
    id_loai_dich_vu INT auto_increment,
    ten_loai_dich_vu VARCHAR(45),
    PRIMARY KEY (id_loai_dich_vu)
);

CREATE TABLE dich_vu (
    id_dich_vu INT auto_increment,
    ten_dich_vu VARCHAR(45),
    dien_tich INT,
    so_tang INT,
    so_nguoi_toi_da VARCHAR(45),
    chi_phi_thue VARCHAR(45),
    trang_thai VARCHAR(45),
    id_kieu_thue INT,
    id_loai_dich_vu INT,
    PRIMARY KEY (id_dich_vu),
    FOREIGN KEY (id_kieu_thue)
        REFERENCES kieu_thue (id_kieu_thue),
    FOREIGN KEY (id_loai_dich_vu)
        REFERENCES loai_dich_vu (id_loai_dich_vu)
);

CREATE TABLE hop_dong (
    id_hop_dong INT auto_increment,
    ngay_lam_hop_dong DATE,
    ngay_ket_thuc DATE,
    tien_dat_coc INT,
    tong_tien INT,
    id_nhan_vien INT,
    id_khach_hang INT,
    id_dich_vu INT,
    PRIMARY KEY (id_hop_dong),
    FOREIGN KEY (id_nhan_vien)
        REFERENCES nhan_vien (id_nhan_vien),
    FOREIGN KEY (id_khach_hang)
        REFERENCES khach_hang (id_khach_hang),
    FOREIGN KEY (id_dich_vu)
        REFERENCES dich_vu (id_dich_vu)	
);

CREATE TABLE dich_vu_di_kem (
    id_dich_vu_di_kem INT auto_increment,
    ten_dich_vu_di_kem VARCHAR(45),
    gia INT,
    don_vi INT,
    trang_thai_kha_dung VARCHAR(45),
    PRIMARY KEY (id_dich_vu_di_kem)
);

CREATE TABLE hop_dong_chi_tiet (
    id_hop_dong_chi_tiet INT auto_increment,
    so_luong INT,
    id_hop_dong INT,
    id_dich_vu_di_kem INT,
    PRIMARY KEY (id_hop_dong_chi_tiet),
    FOREIGN KEY (id_hop_dong)
        REFERENCES hop_dong (id_hop_dong),
    FOREIGN KEY (id_dich_vu_di_kem)
        REFERENCES dich_vu_di_kem (id_dich_vu_di_kem)
);
create table user(
username varchar(255) primary key,
password varchar(255)
);
create table role(
id int primary key auto_increment,
role_name varchar(255)
);
create table user_role(
user_role_id int primary key auto_increment,
role_id int,
username varchar(255),
foreign key (role_id) references role(id),
foreign key (username) references user(username)
);
INSERT INTO `furamaServlet`.`bo_phan` (`ten_bo_phan`)
 VALUES
 ('sale_maketing'),
 ('hanh chinh'),
 ('phuc vu'),
 ('quan ly');
 
 INSERT INTO `furamaServlet`.`trinh_do` (`trinh_do`)
 VALUES 
 ('trung cap'),
 ('cao dang'),
 ('dai hoc'),
 ('sau dai hoc');
 
INSERT INTO `furamaServlet`.`vi_tri` (`ten_vi_tri`) 
VALUES 
('le tan'),
('phuc vu'),
('chuyen vien'),
('giám sát'),
('quan ly'),
('giam doc');

INSERT INTO `furamaServlet`.`loai_khach` (`ten_loai_khach`) 
VALUES 
('Diamond'),
('Platinium'),
('Gold'),
('Silver'),
('Member');


INSERT INTO `furamaServlet`.`khach_hang` (`ho_ten`, `ngay_sinh`, `so_CMND`, `SDT`, `email`, `dia_chi`, `id_loai_khach`) 
VALUES 
('thinh', '1993-12-10', '1234567', '1234567', 'abc@ab.abc', 'da nang', '1'),
('vu', '1993-12-10', '1234567', '1234567', 'abc@ab.abc', 'da nang', '2'),
('tuong', '1993-12-10', '1234567', '1234567', 'abc@ab.abc', 'quang nam', '1'),
('hoat', '1993-12-10', '1234567', '1234567', 'abc@ab.abc', 'quang tri', '4'),
('viet', '1993-12-10', '1234567', '1234567', 'abc@ab.abc', 'quang tri', '5');



 INSERT INTO `furamaServlet`.`nhan_vien` (`ho_ten`, `ngay_sinh`, `so_CMND`, `luong`, `SDT`, `email`, `dia_chi`, `id_vi_tri`, `id_trinh_do`, `id_bo_phan`) 
 VALUES 
 ('huong', '1992-06-10', '123456789', '5000', '12345677889', 'abc@abc.com', 'abc', '1', '1', '3'),
 ('phat', '1993-06-10', '123456789', '5000', '12345677889', 'abc@abc.com', 'abc', '2', '1', '4'),
 ('kien', '1994-06-10', '123456789', '5000', '12345677889', 'abc@abc.com', 'abc', '1', '2', '1'),
 ('thanh', '1982-06-10', '123456789', '5000', '12345677889', 'abc@abc.com', 'abc', '1', '1', '3'),
 ('vu', '1999-06-10', '123456789', '5000', '12345677889', 'abc@abc.com', 'abc', '1', '2', '1');
 
 INSERT INTO `furamaServlet`.`loai_dich_vu` (`ten_loai_dich_vu`) 
 VALUES 
 ('villa'),
 ('house'),
 ('room');
 
 INSERT INTO `furamaServlet`.`kieu_thue` (`ten_kieu_thue`, `gia`) 
VALUES 
('nam', '120'),
('thang', '10'),
('ngay', '3'),
('gio', '1');
 
 INSERT INTO `furamaServlet`.`dich_vu` (`ten_dich_vu`, `dien_tich`, `so_tang`, `so_nguoi_toi_da`, `chi_phi_thue`, `trang_thai`, `id_kieu_thue`, `id_loai_dich_vu`)
 VALUES 
 ('villa1', '30', '2', '10', '30', 'avairable', '1', '1'),
 ('villa2', '30', '1', '5', '15', 'avairable', '1', '1'),
 ('house1', '30', '2', '10', '20', 'avairable', '2', '2'),
 ('house2', '30', '1', '5', '10', 'avairable', '2', '2'),
 ('room1', '30', '2', '10', '15', 'avairable', '3', '3'),
 ('room2', '30', '1', '5', '8', 'avairable', '3', '3');

INSERT INTO `furamaServlet`.`hop_dong` (`ngay_lam_hop_dong`, `ngay_ket_thuc`, `tien_dat_coc`, `tong_tien`, `id_nhan_vien`, `id_khach_hang`, `id_dich_vu`) 
VALUES 
('2019-10-19', '2019-10-22', '123', '456', '1', '1', '1'),
('2019-01-19', '2019-10-19', '123', '456', '2', '1', '2'),
('2019-03-19', '2019-04-19', '123', '456', '3', '3', '3'),
('2019-04-19', '2020-04-19', '123', '456', '4', '4', '4');

INSERT INTO `furamaServlet`.`dich_vu_di_kem` (`ten_dich_vu_di_kem`, `gia`, `don_vi`, `trang_thai_kha_dung`) 
VALUES 
('massage', '15', '2', 'avairable'),
('karaoke', '15', '3', 'avairable'),
('thức an', '15', '4', 'avairable'),
('nước uống', '15', '4', 'avairable'),
('thuê xe', '15', '5', 'avairable');

INSERT INTO `furamaServlet`.`hop_dong_chi_tiet` (`so_luong`, `id_hop_dong`, `id_dich_vu_di_kem`) 
VALUES 
('2', '1', '1'),
('2', '2', '1'),
('2', '3', '2'),
('2', '1', '3');

select kh.id_khach_hang, kh.ho_ten,kh.ngay_sinh, kh.so_CMND,kh.SDT, kh.email, kh.dia_chi,lk.ten_loai_khach
from khach_hang kh
join loai_khach lk on kh.id_loai_khach = lk.id_loai_khach;