package bo;

import model.*;

import java.util.List;

public interface INhanVienBo {
    public List<DTO_nhan_vien> selectAllNhanVien();
    public List<Vi_tri> selectAllViTri();
    public List<Trinh_do> selectAllTrinhDo();
    public List<Bo_phan> selectAllBoPhan();
    public Nhan_vien selectNhanVien(int id);
    public void insertNhanVien(Nhan_vien nhanVien);
    public boolean deleteNhanVien(int id);
    public boolean editNhanVien(Nhan_vien nhanVien);
}
