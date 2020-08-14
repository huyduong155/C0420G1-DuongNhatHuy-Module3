package dao;

import model.DTO_khach_hang;
import model.DTO_khach_hang_dich_vu;
import model.Khach_hang;
import model.Loai_khach;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class KhachHangDao implements IKhachHangDao{
    BaseDAO baseDAO = new BaseDAO();
    private static final String SELECT_ALL_KH ="select kh.id_khach_hang, kh.ho_ten,kh.ngay_sinh, kh.so_CMND,kh.SDT, " +
            "kh.email, kh.dia_chi,lk.ten_loai_khach " + "from khach_hang kh " +
            "join loai_khach lk on kh.id_loai_khach = lk.id_loai_khach;";
    private static final String SELECT_ALL_LK ="select * from loai_khach";
    private static final String INSERT_KH_SQL ="insert into khach_hang (ho_ten,ngay_sinh,so_CMND,SDT,email,dia_chi,id_loai_khach) " +
            " values (?,?,?,?,?,?,?)";
    private static final String SELECT_KH_BY_ID ="select * from khach_hang where id_khach_hang = ?";
    private static final String UPDATE_KH_SQL = "update khach_hang set ho_ten = ?,ngay_sinh= ?, so_CMND = ?,SDT = ?," +
            "email = ?,dia_chi = ?,id_loai_khach = ? where id_khach_hang = ?;";
    private static final String DELETE_KH_SQL = "delete from khach_hang where id_khach_hang = ?";
    private static final String SELECT_ALL_KH_DV ="{call khachHang_dichVu()}";
    @Override
    public List<DTO_khach_hang> selectAllKhachHang() {
        List<DTO_khach_hang> dtoKhachHangList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(SELECT_ALL_KH);
            ResultSet rs = preparedStatement.executeQuery();
            DTO_khach_hang DTOKH;
            while (rs.next()){
                DTOKH = new DTO_khach_hang();
                DTOKH.setId_khach_hang(rs.getInt("id_khach_hang"));
                DTOKH.setHo_ten(rs.getString("ho_ten"));
                DTOKH.setNgay_sinh(rs.getString("ngay_sinh"));
                DTOKH.setCMND(rs.getString("so_CMND"));
                DTOKH.setSDT(rs.getString("SDT"));
                DTOKH.setEmail(rs.getString("email"));
                DTOKH.setDia_chi(rs.getString("dia_chi"));
                DTOKH.setTen_loai_khach(rs.getString("ten_loai_khach"));
                dtoKhachHangList.add(DTOKH);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return dtoKhachHangList;
    }

    @Override
    public List<Loai_khach> selectAllLoaiKhach() {
        List<Loai_khach> loaiKhachList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(SELECT_ALL_LK);
            ResultSet rs = preparedStatement.executeQuery();
            Loai_khach loaiKhach;
            while (rs.next()){
                loaiKhach = new Loai_khach();
                loaiKhach.setId_loai_khach(rs.getInt("id_loai_khach"));
                loaiKhach.setTen_loai_khach(rs.getString("ten_loai_khach"));
                loaiKhachList.add(loaiKhach);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return loaiKhachList;
    }

    @Override
    public Khach_hang selectKhachHang(int id) {
        Khach_hang khachHang = null;
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(SELECT_KH_BY_ID);
            preparedStatement.setInt(1,id);
            ResultSet rs= preparedStatement.executeQuery();
            while (rs.next()){
                String ho_ten = rs.getString("ho_ten");
                String ngay_sinh = rs.getString("ngay_sinh");
                String so_CMND = rs.getString("so_CMND");
                String SDT = rs.getString("SDT");
                String email = rs.getString("email");
                String dia_chi = rs.getString("dia_chi");
                int id_loai_khach = rs.getInt("id_loai_khach");
                khachHang = new Khach_hang(id,ho_ten,ngay_sinh,so_CMND,SDT,email,dia_chi,id_loai_khach);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return khachHang;
    }

    @Override
    public void insertKhachHang(Khach_hang khachHang) {
        String ngay_sinh = khachHang.getNgay_sinh();
        DateFormat from = new SimpleDateFormat("dd-MM-yyyy"); // current format
        DateFormat to   = new SimpleDateFormat("yyyy-MM-dd"); // wanted format
        String result = null;
        try {
            result = to.format(from.parse(ngay_sinh));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(INSERT_KH_SQL);
            preparedStatement.setString(1,khachHang.getHo_ten());
            preparedStatement.setString(2,result);
            preparedStatement.setString(3,khachHang.getCMND());
            preparedStatement.setString(4,khachHang.getSDT());
            preparedStatement.setString(5,khachHang.getEmail());
            preparedStatement.setString(6,khachHang.getDia_chi());
            preparedStatement.setInt(7,khachHang.getId_loai_khach());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public boolean deleteKhachHang(int id) {
        boolean deleteCus = false;
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(DELETE_KH_SQL);
            preparedStatement.setInt(1,id);
            deleteCus = preparedStatement.executeUpdate() >0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return deleteCus;
    }

    @Override
    public boolean editKhachHang(Khach_hang khachHang) {
        boolean editCus = false;
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(UPDATE_KH_SQL);
            preparedStatement.setString(1,khachHang.getHo_ten());
            preparedStatement.setString(2,khachHang.getNgay_sinh());
            preparedStatement.setString(3,khachHang.getCMND());
            preparedStatement.setString(4,khachHang.getSDT());
            preparedStatement.setString(5,khachHang.getEmail());
            preparedStatement.setString(6,khachHang.getDia_chi());
            preparedStatement.setInt(7,khachHang.getId_loai_khach());
            preparedStatement.setInt(8,khachHang.getId_khach_hang());
            editCus = preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return editCus;
    }

    @Override
    public List<DTO_khach_hang_dich_vu> selectAllKhachHangDichVu() {
        List<DTO_khach_hang_dich_vu> dtoKhachHangDichVuList = new ArrayList<>();
        try {
            CallableStatement callableStatement = this.baseDAO.getConnection().prepareCall(SELECT_ALL_KH_DV);
            ResultSet rs = callableStatement.executeQuery();
            DTO_khach_hang_dich_vu dtoKhachHangDichVu;
            while (rs.next()){
                dtoKhachHangDichVu = new DTO_khach_hang_dich_vu();
                dtoKhachHangDichVu.setId_khach_hang(rs.getInt("id_khach_hang"));
                dtoKhachHangDichVu.setTen_khach_hang(rs.getString("ho_ten"));
                dtoKhachHangDichVu.setTen_dich_vu(rs.getString("ten_dich_vu"));
                dtoKhachHangDichVu.setTen_dich_vu_di_kem(rs.getString("ten_dich_vu_di_kem"));
                dtoKhachHangDichVuList.add(dtoKhachHangDichVu);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return dtoKhachHangDichVuList;
    }
}
