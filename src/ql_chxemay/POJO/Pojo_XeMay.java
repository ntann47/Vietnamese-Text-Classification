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
public class Pojo_XeMay {
    private String maxe,tenxe,phienban,mauxe,maloaixe,mansx,mancc,tinhtrang;
    private double giaban;
    private int sonambh,tonkho;
    public Pojo_XeMay(String maxe, String tenxe, String phienban, String mauxe, String maloaixe, String mansx, String mancc, double giaban, int sonambh, int tonkho) {
        this.maxe = maxe;
        this.tenxe = tenxe;
        this.phienban = phienban;
        this.mauxe = mauxe;
        this.maloaixe = maloaixe;
        this.mansx = mansx;
        this.mancc = mancc;
        this.giaban = giaban;
        this.sonambh = sonambh;
        this.tonkho = tonkho;
    }
    public Pojo_XeMay(String maxe,double giaban,int tonkho)
    {
        this.maxe=maxe;
        this.giaban=giaban;
        this.tonkho=tonkho;
    }

    public String getMaxe() {
        return maxe;
    }

    public void setMaxe(String maxe) {
        this.maxe = maxe;
    }

    public String getTenxe() {
        return tenxe;
    }

    public void setTenxe(String tenxe) {
        this.tenxe = tenxe;
    }

    public String getPhienban() {
        return phienban;
    }

    public void setPhienban(String phienban) {
        this.phienban = phienban;
    }

    public String getMauxe() {
        return mauxe;
    }

    public void setMauxe(String mauxe) {
        this.mauxe = mauxe;
    }

    public String getMaloaixe() {
        return maloaixe;
    }

    public void setMaloaixe(String maloaixe) {
        this.maloaixe = maloaixe;
    }

    public String getMansx() {
        return mansx;
    }

    public void setMansx(String mansx) {
        this.mansx = mansx;
    }

    public String getMancc() {
        return mancc;
    }

    public void setMancc(String mancc) {
        this.mancc = mancc;
    }

    public double getGiaban() {
        return giaban;
    }

    public void setGiaban(double giaban) {
        this.giaban = giaban;
    }

    public int getTonkho() {
        return tonkho;
    }

    public void setTonkho(int tonkho) {
        this.tonkho = tonkho;
    }

    public int getSonambh() {
        return sonambh;
    }

    public void setSonambh(int sonambh) {
        this.sonambh = sonambh;
    }

    public String getTinhtrang() {
        return tinhtrang;
    }

    public void setTinhtrang(String tinhtrang) {
        this.tinhtrang = tinhtrang;
    }
    
    
}
