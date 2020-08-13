package bo;

import dao.NhanVienDao;
import model.*;

import java.util.List;

public class NhanVienBo implements INhanVienBo{
    NhanVienDao nhanVienDao = new NhanVienDao();
    @Override
    public List<DTO_nhan_vien> selectAllNhanVien() {
        return nhanVienDao.selectAllNhanVien();
    }

    @Override
    public List<Vi_tri> selectAllViTri() {
        return nhanVienDao.selectAllViTri();
    }

    @Override
    public List<Trinh_do> selectAllTrinhDo() {
        return nhanVienDao.selectAllTrinhDo();
    }

    @Override
    public List<Bo_phan> selectAllBoPhan() {
        return nhanVienDao.selectAllBoPhan();
    }

    @Override
    public Nhan_vien selectNhanVien(int id) {
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
