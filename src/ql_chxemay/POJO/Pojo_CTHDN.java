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
public class Pojo_CTHDN {
    private String maxe;
    private int mahdn,id,soluongnhap;
    private double dongianhap, thanhtien;

    public Pojo_CTHDN(int mahdn,int id, String maxe, int soluongnhap, double dongianhap, double thanhtien) {
        this.mahdn = mahdn;
        this.id=id;
        this.maxe = maxe;
        this.soluongnhap = soluongnhap;
        this.dongianhap = dongianhap;
        this.thanhtien = thanhtien;
    }
     public Pojo_CTHDN(int mahdn,int id, String maxe, int soluongnhap, double dongianhap) {
        this.mahdn = mahdn;
        this.id=id;
        this.maxe = maxe;
        this.soluongnhap = soluongnhap;
        this.dongianhap = dongianhap;
    }

    public int getMahdn() {
        return mahdn;
    }

    public void setMahdn(int mahdn) {
        this.mahdn = mahdn;
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

    public int getSoluongnhap() {
        return soluongnhap;
    }

    public void setSoluongnhap(int soluongnhap) {
        this.soluongnhap = soluongnhap;
    }

    public double getDongianhap() {
        return dongianhap;
    }

    public void setDongianhap(double dongianhap) {
        this.dongianhap = dongianhap;
    }

    public double getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(double thanhtien) {
        this.thanhtien = thanhtien;
    }
    
    
}
