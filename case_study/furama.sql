-- TAST 1 : thêm CSDL

create database furama;
use furama;


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

INSERT INTO `furama`.`bo_phan` (`ten_bo_phan`)
 VALUES
 ('sale_maketing'),
 ('hanh chinh'),
 ('phuc vu'),
 ('quan ly');
 
 INSERT INTO `furama`.`trinh_do` (`trinh_do`)
 VALUES 
 ('trung cap'),
 ('cao dang'),
 ('dai hoc'),
 ('sau dai hoc');
 
INSERT INTO `furama`.`vi_tri` (`ten_vi_tri`) 
VALUES 
('le tan'),
('phuc vu'),
('chuyen vien'),
('giám sát'),
('quan ly'),
('giam doc');

INSERT INTO `furama`.`loai_khach` (`ten_loai_khach`) 
VALUES 
('Diamond'),
('Platinium'),
('Gold'),
('Silver'),
('Member');


INSERT INTO `furama`.`khach_hang` (`ho_ten`, `ngay_sinh`, `so_CMND`, `SDT`, `email`, `dia_chi`, `id_loai_khach`) 
VALUES 
('thinh', '1993-12-10', '1234567', '1234567', 'abc@ab.abc', 'da nang', '1'),
('vu', '1993-12-10', '1234567', '1234567', 'abc@ab.abc', 'da nang', '2'),
('tuong', '1993-12-10', '1234567', '1234567', 'abc@ab.abc', 'quang nam', '3'),
('hoat', '1993-12-10', '1234567', '1234567', 'abc@ab.abc', 'quang tri', '4'),
('viet', '1993-12-10', '1234567', '1234567', 'abc@ab.abc', 'quang tri', '5');



 INSERT INTO `furama`.`nhan_vien` (`ho_ten`, `ngay_sinh`, `so_CMND`, `luong`, `SDT`, `email`, `dia_chi`, `id_vi_tri`, `id_trinh_do`, `id_bo_phan`) 
 VALUES 
 ('huong', '1992-06-10', '123456789', '5000', '12345677889', 'abc@abc.com', 'abc', '1', '1', '3'),
 ('phat', '1993-06-10', '123456789', '5000', '12345677889', 'abc@abc.com', 'abc', '2', '1', '4'),
 ('kien', '1994-06-10', '123456789', '5000', '12345677889', 'abc@abc.com', 'abc', '1', '2', '1'),
 ('thanh', '1982-06-10', '123456789', '5000', '12345677889', 'abc@abc.com', 'abc', '1', '1', '3'),
 ('vu', '1999-06-10', '123456789', '5000', '12345677889', 'abc@abc.com', 'abc', '1', '2', '1');
 
 -- TAST 2: Hiển thị thông tin nhân viên trong hệ thống có tên bắt đầu một trong các kí tự "H","T" hoặc "K"
 
 SELECT *
FROM nhan_vien
WHERE
    (ho_ten LIKE 'H%' OR ho_ten LIKE 'T%'
        OR ho_ten LIKE 'K%')
        AND LENGTH(ho_ten) < 15;
 
 -- TAST 3: Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18-50, và có địa chỉ ở đà nẵng hoặc quảng trị
 
 SELECT *, (YEAR(CURDATE()) - YEAR(ngay_sinh)) AS age
FROM khach_hang
HAVING age <= 50 AND age >= 18
    AND (dia_chi = 'da nang'
    OR dia_chi = 'quang tri');

-- TAST 4: Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần. Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng.
-- Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.



