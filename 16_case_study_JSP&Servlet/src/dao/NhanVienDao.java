package dao;

import model.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NhanVienDao implements INhanVienDao{
    BaseDAO baseDAO = new BaseDAO();
    private static final String SELECT_ALL_NV ="select nv.id_nhan_vien,nv.ho_ten,nv.ngay_sinh,nv.so_CMND,nv.luong,nv.SDT,nv.email,nv.dia_chi,vt.ten_vi_tri,td.trinh_do,bp.ten_bo_phan " +
            "from nhan_vien nv " +
            "join vi_tri vt on nv.id_vi_tri = vt.id_vi_tri " +
            "join trinh_do td on nv.id_trinh_do = td.id_trinh_do " +
            "join bo_phan bp on nv.id_bo_phan = bp.id_bo_phan;";
    private static final String SELECT_ALL_VT ="select * from vi_tri";
    private static final String SELECT_ALL_TD ="select * from trinh_do";
    private static final String SELECT_ALL_BP ="select * from bo_phan";
    private static final String INSERT_NV_SQL ="insert into nhan_vien (ho_ten,ngay_sinh,so_CMND,luong,SDT,email,dia_chi,id_vi_tri,id_trinh_do,id_bo_phan) " +
            " values (?,?,?,?,?,?,?,?,?,?)";
    private static final String SELECT_NV_BY_ID ="select * from nhan_vien where id_nhan_vien = ?";
    private static final String UPDATE_NV_SQL = "update nhan_vien set ho_ten = ?,ngay_sinh= ?, so_CMND = ?,luong = ?,SDT = ?," +
            "email = ?,dia_chi = ?,id_vi_tri = ?,id_trinh_do = ?,id_bo_phan = ? where id_nhan_vien = ?;";
    private static final String DELETE_NV_SQL = "delete from nhan_vien where id_nhan_vien = ?";
    @Override
    public List<DTO_nhan_vien> selectAllNhanVien() {
        List<DTO_nhan_vien> dtoNhanVienList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(SELECT_ALL_NV);
            ResultSet rs = preparedStatement.executeQuery();
            DTO_nhan_vien dtoNhanVien;
            while (rs.next()){
                dtoNhanVien = new DTO_nhan_vien();
                dtoNhanVien.setId_nhan_vien(rs.getInt("id_nhan_vien"));
                dtoNhanVien.setHo_ten(rs.getString("ho_ten"));
                dtoNhanVien.setNgay_sinh(rs.getString("ngay_sinh"));
                dtoNhanVien.setCMND(rs.getString("so_CMND"));
                dtoNhanVien.setLuong(rs.getString("luong"));
                dtoNhanVien.setSDT(rs.getString("SDT"));
                dtoNhanVien.setEmail(rs.getString("email"));
                dtoNhanVien.setDia_chi(rs.getString("dia_chi"));
                dtoNhanVien.setTen_vi_tri(rs.getString("ten_vi_tri"));
                dtoNhanVien.setTrinh_do(rs.getString("trinh_do"));
                dtoNhanVien.setTen_bo_phan(rs.getString("ten_bo_phan"));
                dtoNhanVienList.add(dtoNhanVien);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return dtoNhanVienList;
    }

    @Override
    public List<Vi_tri> selectAllViTri() {
        List<Vi_tri> viTriList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(SELECT_ALL_VT);
            ResultSet rs = preparedStatement.executeQuery();
            Vi_tri vi_tri;
            while (rs.next()){
                vi_tri = new Vi_tri();
                vi_tri.setId_vi_tri(rs.getInt("id_vi_tri"));
                vi_tri.setTen_vi_tri(rs.getString("ten_vi_tri"));
                viTriList.add(vi_tri);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return viTriList;
    }

    @Override
    public List<Trinh_do> selectAllTrinhDo() {
        List<Trinh_do> trinhDoList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(SELECT_ALL_TD);
            ResultSet rs = preparedStatement.executeQuery();
            Trinh_do trinhDo;
            while (rs.next()){
                trinhDo = new Trinh_do();
                trinhDo.setId_trinh_do(rs.getInt("id_trinh_do"));
                trinhDo.setTrinh_do(rs.getString("trinh_do"));
                trinhDoList.add(trinhDo);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return trinhDoList;
    }

    @Override
    public List<Bo_phan> selectAllBoPhan() {
        List<Bo_phan> boPhanList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(SELECT_ALL_BP);
            ResultSet rs = preparedStatement.executeQuery();
            Bo_phan boPhan;
            while (rs.next()){
                boPhan = new Bo_phan();
                boPhan.setId_bo_phan(rs.getInt("id_bo_phan"));
                boPhan.setTen_bo_phan(rs.getString("ten_bo_phan"));
                boPhanList.add(boPhan);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return boPhanList;
    }

    @Override
    public Nhan_vien selectNhanVien(int id) {
        Nhan_vien nhanVien = null;
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(SELECT_NV_BY_ID);
            preparedStatement.setInt(1,id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                String ho_ten = rs.getString("ho_ten");
                String ngay_sinh = rs.getString("ngay_sinh");
                String so_CMND = rs.getString("so_CMND");
                String luong = rs.getString("luong");
                String SDT = rs.getString("SDT");
                String email = rs.getString("email");
                String dia_chi = rs.getString("dia_chi");
                int id_vi_tri = rs.getInt("id_vi_tri");
                int id_trinh_do = rs.getInt("id_trinh_do");
                int id_bo_phan = rs.getInt("id_bo_phan");
                nhanVien = new Nhan_vien(id,ho_ten,ngay_sinh,so_CMND,luong,SDT,email,dia_chi,id_trinh_do,id_vi_tri,id_bo_phan);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return nhanVien;
    }

    @Override
    public void insertNhanVien(Nhan_vien nhanVien) {
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(INSERT_NV_SQL);
            preparedStatement.setString(1,nhanVien.getHo_ten());
            preparedStatement.setString(2,nhanVien.getNgay_sinh());
            preparedStatement.setString(3,nhanVien.getCMND());
            preparedStatement.setString(4,nhanVien.getLuong());
            preparedStatement.setString(5,nhanVien.getSDT());
            preparedStatement.setString(6,nhanVien.getEmail());
            preparedStatement.setString(7,nhanVien.getDia_chi());
            preparedStatement.setInt(8,nhanVien.getId_vi_tri());
            preparedStatement.setInt(9,nhanVien.getId_trinh_do());
            preparedStatement.setInt(10,nhanVien.getId_bo_phan());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public boolean deleteNhanVien(int id) {
        boolean deleteEmp = false;
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(DELETE_NV_SQL);
            preparedStatement.setInt(1,id);
            deleteEmp = preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return deleteEmp;
    }

    @Override
    public boolean editNhanVien(Nhan_vien nhanVien) {
        boolean editEmp = false;
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(UPDATE_NV_SQL);
            preparedStatement.setString(1,nhanVien.getHo_ten());
            preparedStatement.setString(2,nhanVien.getNgay_sinh());
            preparedStatement.setString(3,nhanVien.getCMND());
            preparedStatement.setString(4,nhanVien.getLuong());
            preparedStatement.setString(5,nhanVien.getSDT());
            preparedStatement.setString(6,nhanVien.getEmail());
            preparedStatement.setString(7,nhanVien.getDia_chi());
            preparedStatement.setInt(8,nhanVien.getId_vi_tri());
            preparedStatement.setInt(9,nhanVien.getId_trinh_do());
            preparedStatement.setInt(10,nhanVien.getId_bo_phan());
            preparedStatement.setInt(11,nhanVien.getId_nhan_vien());
            editEmp = preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return editEmp;
    }
}
