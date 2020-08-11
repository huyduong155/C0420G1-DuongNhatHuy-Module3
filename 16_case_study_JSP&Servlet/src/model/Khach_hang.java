package model;

public class Khach_hang {
   private int id_khach_hang;
   private String ho_ten;
   private String ngay_sinh;
   private String CMND;
   private String SDT;
   private String email;
   private String dia_chi;
   private int id_loai_khach;

    public Khach_hang(int id_khach_hang, String ho_ten, String ngay_sinh, String CMND, String SDT, String email,
                      String dia_chi, int id_loai_khach) {
        this.id_khach_hang = id_khach_hang;
        this.ho_ten = ho_ten;
        this.ngay_sinh = ngay_sinh;
        this.CMND = CMND;
        this.SDT = SDT;
        this.email = email;
        this.dia_chi = dia_chi;
        this.id_loai_khach = id_loai_khach;
    }

    public Khach_hang(String ho_ten, String ngay_sinh, String CMND, String SDT, String email, String dia_chi, int id_loai_khach) {
        this.ho_ten = ho_ten;
        this.ngay_sinh = ngay_sinh;
        this.CMND = CMND;
        this.SDT = SDT;
        this.email = email;
        this.dia_chi = dia_chi;
        this.id_loai_khach = id_loai_khach;
    }

    public Khach_hang() {
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

    public int getId_loai_khach() {
        return id_loai_khach;
    }

    public void setId_loai_khach(int id_loai_khach) {
        this.id_loai_khach = id_loai_khach;
    }
}
