package model;

public class Dich_vu {
    private int id_dich_vu;
    private String ten_dich_vu;
    private int dien_tich;
    private int so_tang;
    private String so_nguoi;
    private String chi_phi_thue;
    private String trang_thai;
    private int id_kieu_thue;
    private int id_loai_dich_vu;

    public Dich_vu() {
    }

    public Dich_vu(int id_dich_vu, String ten_dich_vu, int dien_tich, int so_tang, String so_nguoi, String chi_phi_thue,
                   String trang_thai, int id_kieu_thue, int id_loai_dich_vu) {
        this.id_dich_vu = id_dich_vu;
        this.ten_dich_vu = ten_dich_vu;
        this.dien_tich = dien_tich;
        this.so_tang = so_tang;
        this.so_nguoi = so_nguoi;
        this.chi_phi_thue = chi_phi_thue;
        this.trang_thai = trang_thai;
        this.id_kieu_thue = id_kieu_thue;
        this.id_loai_dich_vu = id_loai_dich_vu;
    }

    public Dich_vu(String ten_dich_vu, int dien_tich, int so_tang, String so_nguoi, String chi_phi_thue,
                   String trang_thai, int id_kieu_thue, int id_loai_dich_vu) {
        this.ten_dich_vu = ten_dich_vu;
        this.dien_tich = dien_tich;
        this.so_tang = so_tang;
        this.so_nguoi = so_nguoi;
        this.chi_phi_thue = chi_phi_thue;
        this.trang_thai = trang_thai;
        this.id_kieu_thue = id_kieu_thue;
        this.id_loai_dich_vu = id_loai_dich_vu;
    }

    public int getId_dich_vu() {
        return id_dich_vu;
    }

    public void setId_dich_vu(int id_dich_vu) {
        this.id_dich_vu = id_dich_vu;
    }

    public String getTen_dich_vu() {
        return ten_dich_vu;
    }

    public void setTen_dich_vu(String ten_dich_vu) {
        this.ten_dich_vu = ten_dich_vu;
    }

    public int getDien_tich() {
        return dien_tich;
    }

    public void setDien_tich(int dien_tich) {
        this.dien_tich = dien_tich;
    }

    public int getSo_tang() {
        return so_tang;
    }

    public void setSo_tang(int so_tang) {
        this.so_tang = so_tang;
    }

    public String getSo_nguoi() {
        return so_nguoi;
    }

    public void setSo_nguoi(String so_nguoi) {
        this.so_nguoi = so_nguoi;
    }

    public String getChi_phi_thue() {
        return chi_phi_thue;
    }

    public void setChi_phi_thue(String chi_phi_thue) {
        this.chi_phi_thue = chi_phi_thue;
    }

    public String getTrang_thai() {
        return trang_thai;
    }

    public void setTrang_thai(String trang_thai) {
        this.trang_thai = trang_thai;
    }

    public int getId_kieu_thue() {
        return id_kieu_thue;
    }

    public void setId_kieu_thue(int id_kieu_thue) {
        this.id_kieu_thue = id_kieu_thue;
    }

    public int getId_loai_dich_vu() {
        return id_loai_dich_vu;
    }

    public void setId_loai_dich_vu(int id_loai_dich_vu) {
        this.id_loai_dich_vu = id_loai_dich_vu;
    }
}
