package dao;

import model.Dich_vu;
import model.Hop_dong;
import model.Khach_hang;
import model.Nhan_vien;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HopDongDao implements IHopDongDao {
    BaseDAO baseDAO = new BaseDAO();
    private static final String SELECT_ALL_KH ="select id_khach_hang,ho_ten from khach_hang";
    private static final String SELECT_ALL_NV ="select id_nhan_vien,ho_ten from nhan_vien";
    private static final String SELECT_ALL_DV ="select id_dich_vu,ten_dich_vu from dich_vu";
    private static final String INSERT_HD_SQL ="insert into hop_dong (ngay_lam_hop_dong,ngay_ket_thuc,tien_dat_coc,tong_tien," +
            "id_nhan_vien,id_khach_hang,id_dich_vu) " + " values (?,?,?,?,?,?,?)";
    @Override
    public List<Khach_hang> selectKhachHang() {
        List<Khach_hang> khachHangList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(SELECT_ALL_KH);
            ResultSet rs = preparedStatement.executeQuery();
            Khach_hang khachHang;
            while (rs.next()){
                khachHang = new Khach_hang();
                khachHang.setId_khach_hang(rs.getInt("id_khach_hang"));
                khachHang.setHo_ten(rs.getString("ho_ten"));
                khachHangList.add(khachHang);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return khachHangList;
    }

    @Override
    public List<Nhan_vien> selectNhanVien() {
        List<Nhan_vien> nhanVienList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(SELECT_ALL_NV);
            ResultSet rs = preparedStatement.executeQuery();
            Nhan_vien nhanVien;
            while (rs.next()){
                nhanVien = new Nhan_vien();
                nhanVien.setId_nhan_vien(rs.getInt("id_nhan_vien"));
                nhanVien.setHo_ten(rs.getString("ho_ten"));
                nhanVienList.add(nhanVien);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return nhanVienList;
    }

    @Override
    public List<Dich_vu> selectDichVu() {
        List<Dich_vu> dichVuList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(SELECT_ALL_DV);
            ResultSet rs = preparedStatement.executeQuery();
            Dich_vu dichVu;
            while (rs.next()){
                dichVu = new Dich_vu();
                dichVu.setId_dich_vu(rs.getInt("id_dich_vu"));
                dichVu.setTen_dich_vu(rs.getString("ten_dich_vu"));
                dichVuList.add(dichVu);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return dichVuList;
    }

    @Override
    public void insertHopDong(Hop_dong hopDong) {
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(INSERT_HD_SQL);
            preparedStatement.setString(1,hopDong.getNgay_lam_hop_dong());
            preparedStatement.setString(2,hopDong.getNgay_ket_thuc());
            preparedStatement.setInt(3,hopDong.getTien_dat_coc());
            preparedStatement.setInt(4,hopDong.getTong_tien());
            preparedStatement.setInt(5,hopDong.getId_nhan_vien());
            preparedStatement.setInt(6,hopDong.getId_khach_hang());
            preparedStatement.setInt(7,hopDong.getId_dich_vu());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
