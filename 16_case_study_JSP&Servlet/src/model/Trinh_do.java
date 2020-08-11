package model;

public class Trinh_do {
    private int id_trinh_do;
    private String trinh_do;

    public Trinh_do() {
    }

    public Trinh_do(int id_trinh_do, String trinh_do) {
        this.id_trinh_do = id_trinh_do;
        this.trinh_do = trinh_do;
    }

    public int getId_trinh_do() {
        return id_trinh_do;
    }

    public void setId_trinh_do(int id_trinh_do) {
        this.id_trinh_do = id_trinh_do;
    }

    public String getTrinh_do() {
        return trinh_do;
    }

    public void setTrinh_do(String trinh_do) {
        this.trinh_do = trinh_do;
    }
}
