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
public class Pojo_TaiKhoan {
    String tendn,matkhau,tennguoidung,machucvu,nhomquyen;

    public Pojo_TaiKhoan(String tendn, String matkhau, String tennguoidung, String machucvu,String nhomquyen) {
        this.tendn = tendn;
        this.matkhau = matkhau;
        this.tennguoidung = tennguoidung;
        this.machucvu = machucvu;
        this.nhomquyen=nhomquyen;
    }

    public String getTendn() {
        return tendn;
    }

    public void setTendn(String tendn) {
        this.tendn = tendn;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public String getTennguoidung() {
        return tennguoidung;
    }

    public void setTennguoidung(String tennguoidung) {
        this.tennguoidung = tennguoidung;
    }

    public String getMachucvu() {
        return machucvu;
    }

    public void setMachucvu(String machucvu) {
        this.machucvu = machucvu;
    }

    public String getNhomquyen() {
        return nhomquyen;
    }

    public void setNhomquyen(String nhomquyen) {
        this.nhomquyen = nhomquyen;
    }
    
    
}
