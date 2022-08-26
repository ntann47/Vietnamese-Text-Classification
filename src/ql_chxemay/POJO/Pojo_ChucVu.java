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
public class Pojo_ChucVu {
    private String machucvu,tenchucvu,nhomquyen;

    public Pojo_ChucVu(String machucvu, String tenchucvu,String nhomquyen) {
        this.machucvu = machucvu;
        this.tenchucvu = tenchucvu;
        this.nhomquyen=nhomquyen;
    }

    public String getMachucvu() {
        return machucvu;
    }

    public void setMachucvu(String machucvu) {
        this.machucvu = machucvu;
    }

    public String getTenchucvu() {
        return tenchucvu;
    }

    public void setTenchucvu(String tenchucvu) {
        this.tenchucvu = tenchucvu;
    }

    public String getNhomquyen() {
        return nhomquyen;
    }

    public void setNhomquyen(String nhomquyen) {
        this.nhomquyen = nhomquyen;
    }
    
    
}
