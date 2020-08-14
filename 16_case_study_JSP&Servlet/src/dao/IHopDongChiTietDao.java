package dao;

import model.*;

import java.util.List;

public interface IHopDongChiTietDao {
    public List<Hop_dong> selectHopDong();
    public List<Dich_vu_di_kem> selectDichVuDiKem();
    public void insertHopDongChiTiet(Hop_dong_chi_tiet hopDongChiTiet);
}
