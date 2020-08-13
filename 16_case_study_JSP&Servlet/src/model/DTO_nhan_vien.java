package model;

public class DTO_nhan_vien {
    private int id_nhan_vien;
    private String ho_ten;
    private String ngay_sinh;
    private String CMND;
    private String luong;
    private String SDT;
    private String email;
    private String dia_chi;
    private String ten_vi_tri;
    private String trinh_do;
    private String ten_bo_phan;

    public DTO_nhan_vien() {
    }

    public DTO_nhan_vien(int id_nhan_vien, String ho_ten, String ngay_sinh, String CMND, String luong, String SDT,
                         String email, String dia_chi, String ten_vi_tri, String trinh_do, String ten_bo_phan) {
        this.id_nhan_vien = id_nhan_vien;
        this.ho_ten = ho_ten;
        this.ngay_sinh = ngay_sinh;
        this.CMND = CMND;
        this.luong = luong;
        this.SDT = SDT;
        this.email = email;
        this.dia_chi = dia_chi;
        this.ten_vi_tri = ten_vi_tri;
        this.trinh_do = trinh_do;
        this.ten_bo_phan = ten_bo_phan;
    }

    public int getId_nhan_vien() {
        return id_nhan_vien;
    }

    public void setId_nhan_vien(int id_nhan_vien) {
        this.id_nhan_vien = id_nhan_vien;
    }

    public String getHo_ten() {
        return ho_ten;
    }

    public void setHo_ten(String ho_ten) {
        this.ho_ten = ho_ten;
    }

    public String getNgay_sinh() {
        return ngay_sinh;
    }

    public void setNgay_sinh(String ngay_sinh) {
        this.ngay_sinh = ngay_sinh;
    }

    public String getCMND() {
        return CMND;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }

    public String getLuong() {
        return luong;
    }

    public void setLuong(String luong) {
        this.luong = luong;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDia_chi() {
        return dia_chi;
    }

    public void setDia_chi(String dia_chi) {
        this.dia_chi = dia_chi;
    }

    public String getTen_vi_tri() {
        return ten_vi_tri;
    }

    public void setTen_vi_tri(String ten_vi_tri) {
        this.ten_vi_tri = ten_vi_tri;
    }

    public String getTrinh_do() {
        return trinh_do;
    }

    public void setTrinh_do(String trinh_do) {
        this.trinh_do = trinh_do;
    }

    public String getTen_bo_phan() {
        return ten_bo_phan;
    }

    public void setTen_bo_phan(String ten_bo_phan) {
        this.ten_bo_phan = ten_bo_phan;
    }
}
