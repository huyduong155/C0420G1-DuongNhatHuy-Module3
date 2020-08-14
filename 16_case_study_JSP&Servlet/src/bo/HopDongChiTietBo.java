package bo;

import dao.HopDongChiTietDao;
import dao.IHopDongChiTietDao;
import model.Dich_vu_di_kem;
import model.Hop_dong;
import model.Hop_dong_chi_tiet;

import java.util.List;

public class HopDongChiTietBo implements IHopDongChiTietBo {
    HopDongChiTietDao hopDongChiTietDao = new HopDongChiTietDao();
    @Override
    public List<Hop_dong> selectHopDong() {
        return hopDongChiTietDao.selectHopDong();
    }

    @Override
    public List<Dich_vu_di_kem> selectDichVuDiKem() {
        return hopDongChiTietDao.selectDichVuDiKem();
    }

    @Override
    public void insertHopDongChiTiet(Hop_dong_chi_tiet hopDongChiTiet) {
        hopDongChiTietDao.insertHopDongChiTiet(hopDongChiTiet);
    }
}
