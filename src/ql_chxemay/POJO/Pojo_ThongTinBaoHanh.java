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
public class Pojo_ThongTinBaoHanh {
    
    private String makh,maxe,sokhung,somay,ngaymua,thoihanbh;
    private int mapbh,mahd;

    public Pojo_ThongTinBaoHanh(int sopbh,String makh,int mahd,String maxe, String sokhung,String somay) {
        this.mapbh=sopbh;
        this.makh=makh;
        this.mahd=mahd;
        this.maxe=maxe;
        this.sokhung=sokhung;
        this.somay=somay;
    }
    public Pojo_ThongTinBaoHanh(int sopbh,String makh,int mahd,String maxe, String sokhung,String somay,String ngaymua,String hanbh) {
        this.mapbh=sopbh;
        this.makh=makh;
        this.mahd=mahd;
        this.maxe=maxe;
        this.sokhung=sokhung;
        this.somay=somay;
        this.ngaymua=ngaymua;
        this.thoihanbh=hanbh;
    }
    

   

    public int getMapbh() {
        return mapbh;
    }

    public void setMapbh(int mapbh) {
        this.mapbh = mapbh;
    }

    public String getMakh() {
        return makh;
    }

    public void setMakh(String makh) {
        this.makh = makh;
    }

    public int getMahd() {
        return mahd;
    }

    public void setMahd(int mahd) {
        this.mahd = mahd;
    }

    public void setSomay(String somay) {
        this.somay = somay;
    }

    public void setSokhung(String sokhung) {
        this.sokhung = sokhung;
    }

   

    public String getMaxe() {
        return maxe;
    }

    public void setMaxe(String maxe) {
        this.maxe = maxe;
    }


    public String getSokhung() {
        return sokhung;
    }

    public String getSomay() {
        return somay;
    }

    public String getNgaymua() {
        return ngaymua;
    }

    public void setNgaymua(String ngaymua) {
        this.ngaymua = ngaymua;
    }

    public String getThoihanbh() {
        return thoihanbh;
    }

    public void setThoihanbh(String thoihanbh) {
        this.thoihanbh = thoihanbh;
    }
    
 
    
}
