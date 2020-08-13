package bo;

import model.Dich_vu;
import model.Kieu_thue;
import model.Loai_dich_vu;

import java.util.List;

public interface IDichVuBo {
    public List<Kieu_thue> selectAllKieuThue();
    public List<Loai_dich_vu> selectAllLoaiDichVu();
    public void insertDichVu(Dich_vu dichVu);
}
