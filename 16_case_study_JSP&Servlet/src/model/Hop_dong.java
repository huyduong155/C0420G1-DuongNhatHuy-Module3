package model;

public class Hop_dong {
    private int id_hop_dong;
    private String ngay_lam_hop_dong;
    private String ngay_ket_thuc;
    private int tien_dat_coc;
    private int tong_tien;
    private int id_nhan_vien;
    private int id_khach_hang;
    private int id_dich_vu;

    public Hop_dong() {
    }

    public Hop_dong(int id_hop_dong) {
        this.id_hop_dong = id_hop_dong;
    }

    public Hop_dong(int id_hop_dong, String ngay_lam_hop_dong, String ngay_ket_thuc, int tien_dat_coc, int tong_tien,
                    int id_nhan_vien, int id_khach_hang, int id_dich_vu) {
        this.id_hop_dong = id_hop_dong;
        this.ngay_lam_hop_dong = ngay_lam_hop_dong;
        this.ngay_ket_thuc = ngay_ket_thuc;
        this.tien_dat_coc = tien_dat_coc;
        this.tong_tien = tong_tien;
        this.id_nhan_vien = id_nhan_vien;
        this.id_khach_hang = id_khach_hang;
        this.id_dich_vu = id_dich_vu;
    }

    public Hop_dong(String ngay_lam_hop_dong, String ngay_ket_thuc, int tien_dat_coc, int tong_tien, int id_nhan_vien,
                    int id_khach_hang, int id_dich_vu) {
        this.ngay_lam_hop_dong = ngay_lam_hop_dong;
        this.ngay_ket_thuc = ngay_ket_thuc;
        this.tien_dat_coc = tien_dat_coc;
        this.tong_tien = tong_tien;
        this.id_nhan_vien = id_nhan_vien;
        this.id_khach_hang = id_khach_hang;
        this.id_dich_vu = id_dich_vu;
    }

    public int getId_hop_dong() {
        return id_hop_dong;
    }

    public void setId_hop_dong(int id_hop_dong) {
        this.id_hop_dong = id_hop_dong;
    }

    public String getNgay_lam_hop_dong() {
        return ngay_lam_hop_dong;
    }

    public void setNgay_lam_hop_dong(String ngay_lam_hop_dong) {
        this.ngay_lam_hop_dong = ngay_lam_hop_dong;
    }

    public String getNgay_ket_thuc() {
        return ngay_ket_thuc;
    }

    public void setNgay_ket_thuc(String ngay_ket_thuc) {
        this.ngay_ket_thuc = ngay_ket_thuc;
    }

    public int getTien_dat_coc() {
        return tien_dat_coc;
    }

    public void setTien_dat_coc(int tien_dat_coc) {
        this.tien_dat_coc = tien_dat_coc;
    }

    public int getTong_tien() {
        return tong_tien;
    }

    public void setTong_tien(int tong_tien) {
        this.tong_tien = tong_tien;
    }

    public int getId_nhan_vien() {
        return id_nhan_vien;
    }

    public void setId_nhan_vien(int id_nhan_vien) {
        this.id_nhan_vien = id_nhan_vien;
    }

    public int getId_khach_hang() {
        return id_khach_hang;
    }

    public void setId_khach_hang(int id_khach_hang) {
        this.id_khach_hang = id_khach_hang;
    }

    public int getId_dich_vu() {
        return id_dich_vu;
    }

    public void setId_dich_vu(int id_dich_vu) {
        this.id_dich_vu = id_dich_vu;
    }
}

