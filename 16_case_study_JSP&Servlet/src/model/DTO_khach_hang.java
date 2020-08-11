package model;

public class DTO_khach_hang {
    int id_khach_hang;
    String ho_ten;
    String ngay_sinh;
    String CMND;
    String SDT;
    String email;
    String dia_chi;
    String ten_loai_khach;

    public DTO_khach_hang() {
    }

    public DTO_khach_hang(int id_khach_hang, String ho_ten, String ngay_sinh, String CMND, String SDT, String email,
                          String dia_chi, String ten_loai_khach) {
        this.id_khach_hang = id_khach_hang;
        this.ho_ten = ho_ten;
        this.ngay_sinh = ngay_sinh;
        this.CMND = CMND;
        this.SDT = SDT;
        this.email = email;
        this.dia_chi = dia_chi;
        this.ten_loai_khach = ten_loai_khach;
    }

    public int getId_khach_hang() {
        return id_khach_hang;
    }

    public void setId_khach_hang(int id_khach_hang) {
        this.id_khach_hang = id_khach_hang;
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

    public String getTen_loai_khach() {
        return ten_loai_khach;
    }

    public void setTen_loai_khach(String ten_loai_khach) {
        this.ten_loai_khach = ten_loai_khach;
    }
}
