package model;

public class Loai_khach {
   private int id_loai_khach;
   private String ten_loai_khach;

    public Loai_khach() {
    }

    public Loai_khach(int id_loai_khach, String ten_loai_khach) {
        this.id_loai_khach = id_loai_khach;
        this.ten_loai_khach = ten_loai_khach;
    }

    public int getId_loai_khach() {
        return id_loai_khach;
    }

    public void setId_loai_khach(int id_loai_khach) {
        this.id_loai_khach = id_loai_khach;
    }

    public String getTen_loai_khach() {
        return ten_loai_khach;
    }

    public void setTen_loai_khach(String ten_loai_khach) {
        this.ten_loai_khach = ten_loai_khach;
    }
}
