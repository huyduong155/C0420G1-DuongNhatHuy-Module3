package bo;

import dao.DichVuDao;
import model.Dich_vu;
import model.Kieu_thue;
import model.Loai_dich_vu;

import java.util.List;

public class DichVuBo implements IDichVuBo {
    DichVuDao dichVuDao = new DichVuDao();
    @Override
    public List<Kieu_thue> selectAllKieuThue() {
        return dichVuDao.selectAllKieuThue();
    }

    @Override
    public List<Loai_dich_vu> selectAllLoaiDichVu() {
        return dichVuDao.selectAllLoaiDichVu();
    }

    @Override
    public void insertDichVu(Dich_vu dichVu) {
        dichVuDao.insertDichVu(dichVu);
    }
}
