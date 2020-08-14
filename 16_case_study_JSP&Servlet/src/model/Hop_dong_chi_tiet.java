package model;

public class Hop_dong_chi_tiet {
    private int id_hop_dong_chi_tiet;
    private int so_luong;
    private int id_hop_dong;
    private int id_dich_vu_di_kem;

    public Hop_dong_chi_tiet() {
    }

    public Hop_dong_chi_tiet(int id_hop_dong_chi_tiet, int so_luong, int id_hop_dong, int id_dich_vu_di_kem) {
        this.id_hop_dong_chi_tiet = id_hop_dong_chi_tiet;
        this.so_luong = so_luong;
        this.id_hop_dong = id_hop_dong;
        this.id_dich_vu_di_kem = id_dich_vu_di_kem;
    }

    public Hop_dong_chi_tiet(int so_luong, int id_hop_dong, int id_dich_vu_di_kem) {
        this.so_luong = so_luong;
        this.id_hop_dong = id_hop_dong;
        this.id_dich_vu_di_kem = id_dich_vu_di_kem;
    }

    public int getId_hop_dong_chi_tiet() {
        return id_hop_dong_chi_tiet;
    }

    public void setId_hop_dong_chi_tiet(int id_hop_dong_chi_tiet) {
        this.id_hop_dong_chi_tiet = id_hop_dong_chi_tiet;
    }

    public int getSo_luong() {
        return so_luong;
    }

    public void setSo_luong(int so_luong) {
        this.so_luong = so_luong;
    }

    public int getId_hop_dong() {
        return id_hop_dong;
    }

    public void setId_hop_dong(int id_hop_dong) {
        this.id_hop_dong = id_hop_dong;
    }

    public int getId_dich_vu_di_kem() {
        return id_dich_vu_di_kem;
    }

    public void setId_dich_vu_di_kem(int id_dich_vu_di_kem) {
        this.id_dich_vu_di_kem = id_dich_vu_di_kem;
    }
}
