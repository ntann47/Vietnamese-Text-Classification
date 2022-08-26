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
public class Pojo_HoaDon {
    
private int mahd,id;
    private String manv,makh,ngaytao,trangthai,ghichu;
    private double tlgiamgia,tongtien;

    public Pojo_HoaDon(int mahd, String manv,String makh, String ngaytao, double tlgiamgia, double tongtien,String tinhtrang, String ghichu) {
        this.mahd = mahd;
        this.manv = manv;
        this.makh=makh;
        this.ngaytao = ngaytao;
        this.trangthai=tinhtrang;
        this.ghichu = ghichu;
        this.tlgiamgia = tlgiamgia;
        this.tongtien = tongtien;
    }
    public Pojo_HoaDon(int mahd, String manv,String makh) {
        this.mahd = mahd;
        this.manv = manv;
        this.makh = makh;
    }

    public int getMahd() {
        return mahd;
    }

    public void setMahd(int mahd) {
        this.mahd = mahd;
    }

  

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public void setMakh(String makh) {
        this.makh = makh;
    }

    public String getMakh() {
        return makh;
    }

    public String getNgaytao() {
        return ngaytao;
    }

    public void setNgaytao(String ngaytao) {
        this.ngaytao = ngaytao;
    }

    public double getTlgiamgia() {
        return tlgiamgia;
    }

    public void setTlgiamgia(double tlgiamgia) {
        this.tlgiamgia = tlgiamgia;
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
