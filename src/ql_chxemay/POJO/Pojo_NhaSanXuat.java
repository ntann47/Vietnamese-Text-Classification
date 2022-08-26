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
public class Pojo_NhaSanXuat {
    private String mansx,tennsx,dienthoai;

    public Pojo_NhaSanXuat(String mansx, String tennsx, String dienthoai) {
        this.mansx = mansx;
        this.tennsx = tennsx;
        this.dienthoai = dienthoai;
    }

    public String getMansx() {
        return mansx;
    }

    public void setMansx(String mansx) {
        this.mansx = mansx;
    }

    public String getTennsx() {
        return tennsx;
    }

    public void setTennsx(String tennsx) {
        this.tennsx = tennsx;
    }

    public String getDienthoai() {
        return dienthoai;
    }

    public void setDienthoai(String dienthoai) {
        this.dienthoai = dienthoai;
    }
    
    
}
