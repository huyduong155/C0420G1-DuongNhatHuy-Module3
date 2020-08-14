package bo;

import dao.HopDongDao;
import model.Dich_vu;
import model.Hop_dong;
import model.Khach_hang;
import model.Nhan_vien;

import java.util.List;

public class HopDongBo implements IHopDongBo {
    HopDongDao hopDongDao = new HopDongDao();
    @Override
    public List<Khach_hang> selectKhachHang() {
        return hopDongDao.selectKhachHang();
    }

    @Override
    public List<Nhan_vien> selectNhanVien() {
        return hopDongDao.selectNhanVien();
    }

    @Override
    public List<Dich_vu> selectDichVu() {
        return hopDongDao.selectDichVu();
    }

    @Override
    public void insertHopDong(Hop_dong hopDong) {
        hopDongDao.insertHopDong(hopDong);
    }
}
