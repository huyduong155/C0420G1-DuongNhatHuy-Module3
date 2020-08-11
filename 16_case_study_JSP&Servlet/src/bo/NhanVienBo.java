package bo;

import dao.NhanVienDao;
import model.DTO_khach_hang;
import model.Khach_hang;
import model.Nhan_vien;

import java.util.List;

public class NhanVienBo implements INhanVienBo{
    NhanVienDao nhanVienDao = new NhanVienDao();
    @Override
    public List<DTO_khach_hang> selectAllNhanVien() {
        return nhanVienDao.selectAllNhanVien();
    }

    @Override
    public Khach_hang selectNhanVien(int id) {
        return nhanVienDao.selectNhanVien(id);
    }

    @Override
    public void insertNhanVien(Nhan_vien nhanVien) {
        nhanVienDao.insertNhanVien(nhanVien);
    }

    @Override
    public boolean deleteNhanVien(int id) {
        return nhanVienDao.deleteNhanVien(id);
    }

    @Override
    public boolean editNhanVien(Nhan_vien nhanVien) {
        return nhanVienDao.editNhanVien(nhanVien);
    }
}
