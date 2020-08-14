package dao;

import model.*;

import java.util.List;

public interface IHopDongDao {
    public List<Khach_hang> selectKhachHang();
    public List<Nhan_vien> selectNhanVien();
    public List<Dich_vu> selectDichVu();
    public void insertHopDong(Hop_dong hopDong);
}
