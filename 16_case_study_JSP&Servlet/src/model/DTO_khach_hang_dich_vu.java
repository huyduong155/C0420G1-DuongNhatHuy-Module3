package model;

public class DTO_khach_hang_dich_vu {
    private int id_khach_hang;
    private String ten_khach_hang;
    private String ten_dich_vu;
    private String ten_dich_vu_di_kem;

    public DTO_khach_hang_dich_vu() {
    }

    public DTO_khach_hang_dich_vu(int id_khach_hang, String ten_khach_hang, String ten_dich_vu, String ten_dich_vu_di_kem) {
        this.id_khach_hang = id_khach_hang;
        this.ten_khach_hang = ten_khach_hang;
        this.ten_dich_vu = ten_dich_vu;
        this.ten_dich_vu_di_kem = ten_dich_vu_di_kem;
    }

    public int getId_khach_hang() {
        return id_khach_hang;
    }

    public void setId_khach_hang(int id_khach_hang) {
        this.id_khach_hang = id_khach_hang;
    }

    public String getTen_khach_hang() {
        return ten_khach_hang;
    }

    public void setTen_khach_hang(String ten_khach_hang) {
        this.ten_khach_hang = ten_khach_hang;
    }

    public String getTen_dich_vu() {
        return ten_dich_vu;
    }

    public void setTen_dich_vu(String ten_dich_vu) {
        this.ten_dich_vu = ten_dich_vu;
    }

    public String getTen_dich_vu_di_kem() {
        return ten_dich_vu_di_kem;
    }

    public void setTen_dich_vu_di_kem(String ten_dich_vu_di_kem) {
        this.ten_dich_vu_di_kem = ten_dich_vu_di_kem;
    }
}
