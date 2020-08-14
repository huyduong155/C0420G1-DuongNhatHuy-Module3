package dao;

import model.Dich_vu_di_kem;
import model.Hop_dong;
import model.Hop_dong_chi_tiet;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HopDongChiTietDao implements IHopDongChiTietDao {
    BaseDAO baseDAO = new BaseDAO();
    private static final String SELECT_ID_HOP_DONG ="select id_hop_dong from hop_dong";
    private static final String SELECT_DVDK ="select id_dich_vu_di_kem,ten_dich_vu_di_kem from dich_vu_di_kem";
    private static final String INSERT_HDCT_SQL ="insert into hop_dong_chi_tiet (so_luong,id_hop_dong,id_dich_vu_di_kem) values (?,?,?)";
    @Override
    public List<Hop_dong> selectHopDong() {
        List<Hop_dong> hopDongList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(SELECT_ID_HOP_DONG);
            ResultSet rs = preparedStatement.executeQuery();
            Hop_dong hop_dong;
            while (rs.next()){
                hop_dong = new Hop_dong();
                hop_dong.setId_hop_dong(rs.getInt("id_hop_dong"));
                hopDongList.add(hop_dong);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return hopDongList;
    }

    @Override
    public List<Dich_vu_di_kem> selectDichVuDiKem() {
        List<Dich_vu_di_kem> dichVuDiKemList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(SELECT_DVDK);
            ResultSet rs = preparedStatement.executeQuery();
            Dich_vu_di_kem dichVuDiKem;
            while (rs.next()){
                dichVuDiKem = new Dich_vu_di_kem();
                dichVuDiKem.setId_dich_vu_di_kem(rs.getInt("id_dich_vu_di_kem"));
                dichVuDiKem.setTen_dich_vu_di_kem(rs.getString("ten_dich_vu_di_kem"));
                dichVuDiKemList.add(dichVuDiKem);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return dichVuDiKemList;
    }

    @Override
    public void insertHopDongChiTiet(Hop_dong_chi_tiet hopDongChiTiet) {
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(INSERT_HDCT_SQL);
            preparedStatement.setInt(1,hopDongChiTiet.getSo_luong());
            preparedStatement.setInt(2,hopDongChiTiet.getId_hop_dong());
            preparedStatement.setInt(3,hopDongChiTiet.getId_dich_vu_di_kem());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
