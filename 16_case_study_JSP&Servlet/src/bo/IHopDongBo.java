package bo;

import model.Dich_vu;
import model.Hop_dong;
import model.Khach_hang;
import model.Nhan_vien;

import java.util.List;

public interface IHopDongBo {
    public List<Khach_hang> selectKhachHang();
    public List<Nhan_vien> selectNhanVien();
    public List<Dich_vu> selectDichVu();
    public void insertHopDong(Hop_dong hopDong);
}
