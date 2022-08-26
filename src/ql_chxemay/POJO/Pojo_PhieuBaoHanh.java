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
public class Pojo_PhieuBaoHanh {
    private String tenkh,dienthoai,tenxe,ngaymua,thoihanbh;
    private int mapbh,sonambh;

    public Pojo_PhieuBaoHanh(int sopbh,String tenkh, String dienthoai, String tenxe, String ngaymua, String thoihanbh, int mapbh, int sonambh) {
        this.tenkh = tenkh;
        this.dienthoai = dienthoai;
        this.tenxe = tenxe;
        this.ngaymua = ngaymua;
        this.thoihanbh = thoihanbh;
        this.mapbh = mapbh;
        this.sonambh = sonambh;
    }
    
    public Pojo_PhieuBaoHanh(String tenkh, String dienthoai, String tenxe, String ngaymua, String thoihanbh, int mapbh, int sonambh) {
        this.tenkh = tenkh;
        this.dienthoai = dienthoai;
        this.tenxe = tenxe;
        this.ngaymua = ngaymua;
        this.thoihanbh = thoihanbh;
        this.mapbh = mapbh;
        this.sonambh = sonambh;
    }

    public int getMapbh() {
        return mapbh;
    }

    public void setMapbh(int mapbh) {
        this.mapbh = mapbh;
    }

    public String getTenkh() {
        return tenkh;
    }

    public void setTenkh(String tenkh) {
        this.tenkh = tenkh;
    }

    public String getDienthoai() {
        return dienthoai;
    }

    public void setDienthoai(String dienthoai) {
        this.dienthoai = dienthoai;
    }

    public String getTenxe() {
        return tenxe;
    }

    public void setTenxe(String tenxe) {
        this.tenxe = tenxe;
    }

    public String getNgaymua() {
        return ngaymua;
    }

    public void setNgaymua(String ngaymua) {
        this.ngaymua = ngaymua;
    }

    public int getSonambh() {
        return sonambh;
    }

    public void setSonambh(int sonambh) {
        this.sonambh = sonambh;
    }

    public String getThoihanbh() {
        return thoihanbh;
    }

    public void setThoihanbh(String thoihanbh) {
        this.thoihanbh = thoihanbh;
    }
    
    
}
