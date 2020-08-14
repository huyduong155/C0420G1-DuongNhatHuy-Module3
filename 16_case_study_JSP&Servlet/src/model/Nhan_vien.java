package model;

public class Nhan_vien {
    private int id_nhan_vien;
    private String ho_ten;
    private String ngay_sinh;
    private String CMND;
    private String luong;
    private String SDT;
    private String email;
    private String dia_chi;
    private int id_trinh_do;
    private int id_vi_tri;
    private int id_bo_phan;

    public Nhan_vien() {
    }

    public Nhan_vien(int id_nhan_vien, String ho_ten) {
        this.id_nhan_vien = id_nhan_vien;
        this.ho_ten = ho_ten;
    }

    public Nhan_vien(int id_nhan_vien, String ho_ten, String ngay_sinh, String CMND, String luong, String SDT,
                     String email, String dia_chi, int id_trinh_do, int id_vi_tri, int id_bo_phan) {
        this.id_nhan_vien = id_nhan_vien;
        this.ho_ten = ho_ten;
        this.ngay_sinh = ngay_sinh;
        this.CMND = CMND;
        this.luong = luong;
        this.SDT = SDT;
        this.email = email;
        this.dia_chi = dia_chi;
        this.id_trinh_do = id_trinh_do;
        this.id_vi_tri = id_vi_tri;
        this.id_bo_phan = id_bo_phan;
    }

    public Nhan_vien(String ho_ten, String ngay_sinh, String CMND, String luong, String SDT, String email,
                     String dia_chi, int id_trinh_do, int id_vi_tri, int id_bo_phan) {
        this.ho_ten = ho_ten;
        this.ngay_sinh = ngay_sinh;
        this.CMND = CMND;
        this.luong = luong;
        this.SDT = SDT;
        this.email = email;
        this.dia_chi = dia_chi;
        this.id_trinh_do = id_trinh_do;
        this.id_vi_tri = id_vi_tri;
        this.id_bo_phan = id_bo_phan;
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

    public int getId_trinh_do() {
        return id_trinh_do;
    }

    public void setId_trinh_do(int id_trinh_do) {
        this.id_trinh_do = id_trinh_do;
    }

    public int getId_vi_tri() {
        return id_vi_tri;
    }

    public void setId_vi_tri(int id_vi_tri) {
        this.id_vi_tri = id_vi_tri;
    }

    public int getId_bo_phan() {
        return id_bo_phan;
    }

    public void setId_bo_phan(int id_bo_phan) {
        this.id_bo_phan = id_bo_phan;
    }
}
