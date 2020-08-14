package model;

public class Dich_vu_di_kem {
    private int id_dich_vu_di_kem;
    private String ten_dich_vu_di_kem;
    private int gia;
    private int don_vi;
    private String trang_thai_kha_dung;

    public Dich_vu_di_kem() {
    }

    public Dich_vu_di_kem(int id_dich_vu_di_kem, String ten_dich_vu_di_kem) {
        this.id_dich_vu_di_kem = id_dich_vu_di_kem;
        this.ten_dich_vu_di_kem = ten_dich_vu_di_kem;
    }

    public int getId_dich_vu_di_kem() {
        return id_dich_vu_di_kem;
    }

    public void setId_dich_vu_di_kem(int id_dich_vu_di_kem) {
        this.id_dich_vu_di_kem = id_dich_vu_di_kem;
    }

    public String getTen_dich_vu_di_kem() {
        return ten_dich_vu_di_kem;
    }

    public void setTen_dich_vu_di_kem(String ten_dich_vu_di_kem) {
        this.ten_dich_vu_di_kem = ten_dich_vu_di_kem;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public int getDon_vi() {
        return don_vi;
    }

    public void setDon_vi(int don_vi) {
        this.don_vi = don_vi;
    }

    public String getTrang_thai_kha_dung() {
        return trang_thai_kha_dung;
    }

    public void setTrang_thai_kha_dung(String trang_thai_kha_dung) {
        this.trang_thai_kha_dung = trang_thai_kha_dung;
    }
}
