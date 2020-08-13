package dao;

import model.Dich_vu;
import model.Kieu_thue;
import model.Loai_dich_vu;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DichVuDao implements IDichVuDao {
    BaseDAO baseDAO = new BaseDAO();
    private static final String SELECT_ALL_KT ="select * from kieu_thue";
    private static final String SELECT_ALL_LDV ="select * from loai_dich_vu";
    private static final String INSERT_DV_SQL ="insert into dich_vu (ten_dich_vu,dien_tich,so_tang,so_nguoi_toi_da," +
            "chi_phi_thue,trang_thai,id_kieu_thue,id_loai_dich_vu) " + " values (?,?,?,?,?,?,?,?)";
    @Override
    public List<Kieu_thue> selectAllKieuThue() {
        List<Kieu_thue> kieuThueList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(SELECT_ALL_KT);
            ResultSet rs = preparedStatement.executeQuery();
            Kieu_thue kieuThue;
            while (rs.next()){
                kieuThue = new Kieu_thue();
                kieuThue.setId_kieu_thue(rs.getInt("id_kieu_thue"));
                kieuThue.setTen_kieu_thue(rs.getString("ten_kieu_thue"));
                kieuThue.setGia(rs.getInt("gia"));
                kieuThueList.add(kieuThue);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return kieuThueList;
    }

    @Override
    public List<Loai_dich_vu> selectAllLoaiDichVu() {
        List<Loai_dich_vu> loaiDichVuList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(SELECT_ALL_LDV);
            ResultSet rs = preparedStatement.executeQuery();
            Loai_dich_vu loaiDichVu;
            while (rs.next()){
                loaiDichVu = new Loai_dich_vu();
                loaiDichVu.setId_loai_dich_vu(rs.getInt("id_loai_dich_vu"));
                loaiDichVu.setTen_loai_dich_vu(rs.getString("ten_loai_dich_vu"));
                loaiDichVuList.add(loaiDichVu);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return loaiDichVuList;
    }

    @Override
    public void insertDichVu(Dich_vu dichVu) {
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(INSERT_DV_SQL);
            preparedStatement.setString(1,dichVu.getTen_dich_vu());
            preparedStatement.setInt(2,dichVu.getDien_tich());
            preparedStatement.setInt(3,dichVu.getSo_tang());
            preparedStatement.setString(4,dichVu.getSo_nguoi());
            preparedStatement.setString(5,dichVu.getChi_phi_thue());
            preparedStatement.setString(6,dichVu.getTrang_thai());
            preparedStatement.setInt(7,dichVu.getId_kieu_thue());
            preparedStatement.setInt(8,dichVu.getId_loai_dich_vu());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
