package bo;

import dao.KhachHangDao;
import model.DTO_khach_hang;
import model.Khach_hang;
import model.Loai_khach;

import java.util.List;

public class KhachHangBo implements IKhachHangBo {
    KhachHangDao khachHangDao = new KhachHangDao();
    @Override
    public List<DTO_khach_hang> selectAllKhachHang() {
        return khachHangDao.selectAllKhachHang();
    }

    @Override
    public List<Loai_khach> selectAllLoaiKhach() {
        return khachHangDao.selectAllLoaiKhach();
    }

    @Override
    public void insertKhachHang(Khach_hang khachHang) {
        khachHangDao.insertKhachHang(khachHang);
    }

    @Override
    public Khach_hang selectKhachHang(int id) {
        return khachHangDao.selectKhachHang(id);
    }

    @Override
    public boolean editKhachHang(Khach_hang khachHang) {
        return khachHangDao.editKhachHang(khachHang);
    }

    @Override
    public boolean deleteKhachHang(int id) {
        return khachHangDao.deleteKhachHang(id);
    }
}
