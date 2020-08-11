package model;

public class Bo_phan {
    private int id_bo_phan;
    private String ten_bo_phan;

    public Bo_phan() {
    }

    public Bo_phan(int id_bo_phan, String ten_bo_phan) {
        this.id_bo_phan = id_bo_phan;
        this.ten_bo_phan = ten_bo_phan;
    }

    public int getId_bo_phan() {
        return id_bo_phan;
    }

    public void setId_bo_phan(int id_bo_phan) {
        this.id_bo_phan = id_bo_phan;
    }

    public String getTen_bo_phan() {
        return ten_bo_phan;
    }

    public void setTen_bo_phan(String ten_bo_phan) {
        this.ten_bo_phan = ten_bo_phan;
    }
}
