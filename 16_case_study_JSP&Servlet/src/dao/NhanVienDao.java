package dao;

import model.DTO_khach_hang;
import model.Khach_hang;
import model.Nhan_vien;

import java.util.List;

public class NhanVienDao implements INhanVienDao{
    @Override
    public List<DTO_khach_hang> selectAllNhanVien() {
        return null;
    }

    @Override
    public Khach_hang selectNhanVien(int id) {
        return null;
    }

    @Override
    public void insertNhanVien(Nhan_vien nhanVien) {

    }

    @Override
    public boolean deleteNhanVien(int id) {
        return false;
    }

    @Override
    public boolean editNhanVien(Nhan_vien nhanVien) {
        return false;
    }
}
