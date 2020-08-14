package dao;

import model.DTO_khach_hang;
import model.DTO_khach_hang_dich_vu;
import model.Khach_hang;
import model.Loai_khach;

import java.sql.SQLException;
import java.util.List;

public interface IKhachHangDao {
    public List<DTO_khach_hang> selectAllKhachHang();
    public List<Loai_khach> selectAllLoaiKhach();
    public Khach_hang selectKhachHang(int id);
    public void insertKhachHang(Khach_hang khachHang);
    public boolean deleteKhachHang(int id);
    public boolean editKhachHang(Khach_hang khachHang);
    public List<DTO_khach_hang_dich_vu> selectAllKhachHangDichVu();
}
