package model;

public class Kieu_thue {
    private int id_kieu_thue;
    private String ten_kieu_thue;
    private int gia;

    public Kieu_thue() {
    }

    public Kieu_thue(int id_kieu_thue, String ten_kieu_thue, int gia) {
        this.id_kieu_thue = id_kieu_thue;
        this.ten_kieu_thue = ten_kieu_thue;
        this.gia = gia;
    }

    public int getId_kieu_thue() {
        return id_kieu_thue;
    }

    public void setId_kieu_thue(int id_kieu_thue) {
        this.id_kieu_thue = id_kieu_thue;
    }

    public String getTen_kieu_thue() {
        return ten_kieu_thue;
    }

    public void setTen_kieu_thue(String ten_kieu_thue) {
        this.ten_kieu_thue = ten_kieu_thue;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }
}
