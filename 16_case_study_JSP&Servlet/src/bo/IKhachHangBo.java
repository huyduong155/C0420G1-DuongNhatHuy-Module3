package bo;

import model.DTO_khach_hang;
import model.Khach_hang;
import model.Loai_khach;

import java.util.List;

public interface IKhachHangBo {
    public List<DTO_khach_hang> selectAllKhachHang();
    public List<Loai_khach> selectAllLoaiKhach();
    public void insertKhachHang(Khach_hang khachHang);
    public Khach_hang selectKhachHang(int id);
    public boolean editKhachHang(Khach_hang khachHang);
    public boolean deleteKhachHang(int id);
}
