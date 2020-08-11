package bo;

import model.DTO_khach_hang;
import model.Khach_hang;
import model.Nhan_vien;

import java.util.List;

public interface INhanVienBo {
    public List<DTO_khach_hang> selectAllNhanVien();
    //    public List<Loai_khach> selectAllLoaiKhach();
    public Khach_hang selectNhanVien(int id);
    public void insertNhanVien(Nhan_vien nhanVien);
    public boolean deleteNhanVien(int id);
    public boolean editNhanVien(Nhan_vien nhanVien);
}
