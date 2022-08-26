/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ql_chxemay.POJO;

/**
 *
 * @author Administrator
 */
public class Pojo_CTHD {
    private String maxe;
    private int mahd,id,soluong;
    private double dongia,thanhtien;

    public Pojo_CTHD(int mahd,int id, String maxe, int soluong, double dongia, double thanhtien) {
        this.mahd = mahd;
        this.id=id;
        this.maxe = maxe;
        this.soluong = soluong;
        this.dongia = dongia;
        this.thanhtien = thanhtien;
    }
     public Pojo_CTHD(int mahd,int id, String maxe, int soluong) {
        this.mahd = mahd;
        this.id=id;
        this.maxe = maxe;
        this.soluong = soluong;
    }

    public int getMahd() {
        return mahd;
    }

    public void setMahd(int mahd) {
        this.mahd = mahd;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getMaxe() {
        return maxe;
    }

    public void setMaxe(String maxe) {
        this.maxe = maxe;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public double getDongia() {
        return dongia;
    }

    public void setDongia(double dongia) {
        this.dongia = dongia;
    }

    public double getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(double thanhtien) {
        this.thanhtien = thanhtien;
    }

   
    
}
