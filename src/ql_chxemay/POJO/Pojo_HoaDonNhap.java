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
public class Pojo_HoaDonNhap {
    
    private String manv,ngaynhap,mancc,trangthai,ghichu;
    private int mahdn,tongsoxenhap;
    private double tongtien;

    public Pojo_HoaDonNhap(int mahdn, String manv, String ngaynhap, String mancc, String ghichu,String trangthai, int tongsoxenhap, double tongtien) {
        this.mahdn = mahdn;
        this.manv = manv;
        this.ngaynhap = ngaynhap;
        this.mancc = mancc;
        this.trangthai=trangthai;
        this.ghichu = ghichu;
        this.tongsoxenhap = tongsoxenhap;
        this.tongtien = tongtien;
    }
    public Pojo_HoaDonNhap(int mahdn, String manv, String mancc) {
        this.mahdn = mahdn;
        this.manv = manv; 
        this.mancc = mancc;  
    }

    public int getMahdn() {
        return mahdn;
    }

    public void setMahdn(int mahdn) {
        this.mahdn = mahdn;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public String getNgaynhap() {
        return ngaynhap;
    }

    public void setNgaynhap(String ngaynhap) {
        this.ngaynhap = ngaynhap;
    }

    public String getMancc() {
        return mancc;
    }

    public void setMancc(String mancc) {
        this.mancc = mancc;
    }

    public int getTongsoxenhap() {
        return tongsoxenhap;
    }

    public void setTongsoxenhap(int tongsoxenhap) {
        this.tongsoxenhap = tongsoxenhap;
    }

    public double getTongtien() {
        return tongtien;
    }

    public void setTongtien(double tongtien) {
        this.tongtien = tongtien;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }


    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }
    
}
