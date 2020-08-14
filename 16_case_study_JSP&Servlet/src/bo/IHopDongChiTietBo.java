package bo;

import model.Dich_vu_di_kem;
import model.Hop_dong;
import model.Hop_dong_chi_tiet;

import java.util.List;

public interface IHopDongChiTietBo {
    public List<Hop_dong> selectHopDong();
    public List<Dich_vu_di_kem> selectDichVuDiKem();
    public void insertHopDongChiTiet(Hop_dong_chi_tiet hopDongChiTiet);
}
