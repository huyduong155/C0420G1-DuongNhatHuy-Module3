package dao;

import model.*;

import java.util.List;

public interface IDichVuDao {
    public List<Kieu_thue> selectAllKieuThue();
    public List<Loai_dich_vu> selectAllLoaiDichVu();
    public void insertDichVu(Dich_vu dichVu);
}
