/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ql_chxemay.DAO;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import ql_chxemay.ConnectionSQLServer;
import ql_chxemay.POJO.Pojo_KhachHang;

/**
 *
 * @author Ngo Truong An
 */
public class DAO_KhachHang {
     ConnectionSQLServer c;

    public DAO_KhachHang() {
        c=new ConnectionSQLServer();
    }
    public void loadData(Vector vdata)
    {
        try {
            vdata.removeAllElements();
            String sqlStm="SELECT*FROM KHACHHANG";
            c.OpenConnection();
            Statement stm=c.getCon().createStatement();
            ResultSet rs=stm.executeQuery(sqlStm);
            while(rs.next())
            {
                Vector<String> v=new Vector<String>();
                String makh=rs.getString("MAKH");
                String hoten=rs.getString("TENKH");
                String gioitinh=rs.getString("GIOITINH");
                String ngaysinh=rs.getString("NGAYSINH");
                String dienthoai=rs.getString("DIENTHOAI");
                String diachi=rs.getString("DIACHI");
               
                v.add(makh.trim());
                v.add(hoten.trim());
                v.add(gioitinh.trim());
                
                v.add(ngaysinh.trim());
                v.add(dienthoai.trim());
                v.add(diachi.trim());

             
                vdata.add(v);
            }
            c.CloseConnection();
        } catch (SQLException ex) {
            Logger.getLogger(DAO_KhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public Pojo_KhachHang search(String ma)
    {
        try {
            
            String sqlSearch="select*from KHACHHANG where MAKH=?";
            c.OpenConnection();
            PreparedStatement ps=c.getCon().prepareStatement(sqlSearch);
            ps.setString(1, ma);
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                String makh=rs.getString("MAKH");
                String hoten=rs.getString("TENKH");
                String gioitinh=rs.getString("GIOITINH");
                String ngaysinh=rs.getString("NGAYSINH");
                String dienthoai=rs.getString("DIENTHOAI");
                String diachi=rs.getString("DIACHI");
                Pojo_KhachHang x=new Pojo_KhachHang(makh, hoten, gioitinh,ngaysinh, dienthoai, diachi);
                return x;
            }
            c.CloseConnection();
        } catch (SQLException ex) {
            Logger.getLogger(DAO_KhachHang.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return null;
    }
     public int add(Pojo_KhachHang x)
    {
       
            try {
            c.OpenConnection();
            String sqlUpdate="SET DATEFORMAT DMY INSERT INTO KHACHHANG VALUES(?,?,?,?,?,?)";
            PreparedStatement ps=c.getCon().prepareStatement(sqlUpdate);
            ps.setString(1,x.getMakh());
            ps.setString(2, x.getTenkh());
            ps.setString(3,x.getGioitinh());
            ps.setString(4,x.getNgaysinh());
            ps.setString(5, x.getDienthoai());
            ps.setString(6, x.getDiachi());
             int numbeRowsAffected=ps.executeUpdate();
            c.CloseConnection();
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(DAO_KhachHang.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }  
             
    }
       public void update(Pojo_KhachHang x)
    {
       
            try {
            c.OpenConnection();
            String sqlUpdate="update KHACHHANG set TENKH=?,GIOITINH=?,NGAYSINH=?,DIENTHOAI=?,DIACHI=? WHERE MAKH=?";
            PreparedStatement ps=c.getCon().prepareStatement(sqlUpdate);
            ps.setString(6,x.getMakh());
            ps.setString(1, x.getTenkh());
            ps.setString(2,x.getGioitinh());
            ps.setString(3,x.getNgaysinh());
            ps.setString(4, x.getDienthoai());
            ps.setString(5, x.getDiachi());
            int numbeRowsAffected=ps.executeUpdate();
            c.CloseConnection();

        } catch (SQLException ex) {
            Logger.getLogger(DAO_KhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }  
             
    }
     
    public int kTraTonTai(Pojo_KhachHang x)
    {
        try{
            String sqlSearch="select*from KHACHHANG where MAKH=?";
            c.OpenConnection();
            PreparedStatement ps=c.getCon().prepareStatement(sqlSearch);
            ps.setString(1, x.getMakh());
            ResultSet rs=ps.executeQuery();
            if(rs.next())
            {
                c.CloseConnection();
                return 1;
            } 
        } catch (SQLException ex) {
            Logger.getLogger(DAO_KhachHang.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
        return 0;
    }
}
