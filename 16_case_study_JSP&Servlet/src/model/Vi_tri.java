package model;

public class Vi_tri {
    private int id_vi_tri;
    private String ten_vi_tri;

    public Vi_tri() {
    }

    public Vi_tri(int id_vi_tri, String ten_vi_tri) {
        this.id_vi_tri = id_vi_tri;
        this.ten_vi_tri = ten_vi_tri;
    }

    public int getId_vi_tri() {
        return id_vi_tri;
    }

    public void setId_vi_tri(int id_vi_tri) {
        this.id_vi_tri = id_vi_tri;
    }

    public String getTen_vi_tri() {
        return ten_vi_tri;
    }

    public void setTen_vi_tri(String ten_vi_tri) {
        this.ten_vi_tri = ten_vi_tri;
    }
}
