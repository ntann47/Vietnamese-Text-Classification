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
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import ql_chxemay.ConnectionSQLServer;
import ql_chxemay.POJO.Pojo_HoaDonNhap;

/**
 *
 * @author Administrator
 */
public class DAO_HoaDonNhap {
    ConnectionSQLServer c;

    public DAO_HoaDonNhap() {
        c=new ConnectionSQLServer();
    }
    public void loadData(Vector vdata)
    {
        try {
            vdata.removeAllElements();
            String sqlStm="SELECT*FROM HOADONNHAP";
            c.OpenConnection();
            Statement stm=c.getCon().createStatement();
            ResultSet rs=stm.executeQuery(sqlStm);
            while(rs.next())
            {
                Vector<String> v=new Vector<String>();
                int ma=rs.getInt("MAHDN");
                String manv=rs.getString("MANV");
                String ngaynhap=rs.getString("NGAYNHAP");
                String mancc=rs.getString("MANCC");
                int tongsoxe=rs.getInt("TONGSOXENHAP");
                double tongtien=rs.getFloat("TONGTIEN");
                String tinhtrang=rs.getString("TRANGTHAI");
                String ghichu=rs.getString("GHICHU");
               
                v.add(String.format("%d", ma));
                v.add(manv.trim());
                v.add(ngaynhap.trim());
                v.add(mancc.trim());
                v.add(String.format("%d",tongsoxe));
                v.add(String.format("%f",tongtien));
                v.add(tinhtrang.trim());
                v.add(ghichu.trim());
                vdata.add(v);
            }
            c.CloseConnection();
        } catch (SQLException ex) {
            Logger.getLogger(DAO_HoaDonNhap.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void add(Pojo_HoaDonNhap x)
    {
       
            try {
            c.OpenConnection();
            String stm="{call THEM_HOADONNHAP(?,?,?)}";
            CallableStatement cs=c.getCon().prepareCall(stm);
            cs.setInt(1,x.getMahdn());
            cs.setString(3,x.getMancc());
            cs.setString(2,x.getManv());
            int numberRowsAffected = cs.executeUpdate();
            c.CloseConnection();
        } catch (SQLException ex) {
            Logger.getLogger(DAO_HoaDonNhap.class.getName()).log(Level.SEVERE, null, ex);
        }        
        
    }
  /*  public int delete(int ma)
    {
       
            try {
            c.OpenConnection();
            String stm="{call HUY_HOADONNHAP(?)}";
            CallableStatement cs=c.getCon().prepareCall(stm);
            cs.setInt(1,ma);
            int numberRowsAffected = cs.executeUpdate();
            c.CloseConnection();
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(DAO_HoaDonNhap.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }        
        
    }*/
    public Pojo_HoaDonNhap search(int ma)
    {
        try {
            
            String sqlSearch="select*from HOADONNHAP where MAHDN=?";
            c.OpenConnection();
            PreparedStatement ps=c.getCon().prepareStatement(sqlSearch);
            ps.setInt(1, ma);
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
               
                int mahd=rs.getInt("MAHDN");
                String manv=rs.getString("MANV");
                String ngay=rs.getString("NGAYNHAP");
                String mancc=rs.getString("MANCC");
                int tongnhap=rs.getInt("TONGSOXENHAP");
                double tt=rs.getDouble("TONGTIEN");
                String trangthai=rs.getString("TRANGTHAI");
                String ghichu=rs.getString("GHICHU");
                Pojo_HoaDonNhap x=new Pojo_HoaDonNhap(mahd, manv, ngay, mancc, ghichu, trangthai, tongnhap, tt);
                return x;
            }
            c.CloseConnection();
        } catch (SQLException ex) {
            Logger.getLogger(DAO_HoaDon.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return null;
    }
    public int getLast()
    {
        try {
            // TODO add your handling code here:
            c.OpenConnection();
            String stm="{call TRUYCAP_MAHDNCUOICUNG(?)}";
            CallableStatement cs=c.getCon().prepareCall(stm);
            cs.registerOutParameter(1, java.sql.Types.INTEGER);
            cs.execute();
            int last =cs.getInt(1);
            return last;
        } catch (SQLException ex) {
            Logger.getLogger(DAO_HoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    public int delete(int x)
    {
        
        try {
            c.OpenConnection();
            String sqlDeleteHD="delete from HOADONNHAP where MAHDN=?";
            PreparedStatement ps=c.getCon().prepareStatement(sqlDeleteHD);
            ps.setInt(1, x);
            int numberRowsAffected=ps.executeUpdate();  
            c.CloseConnection();
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(DAO_HoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
      public int thanhToan(int ma)
    {
        try {
            
            String sqlStm="UPDATE HOADONNHAP SET TRANGTHAI=N'ĐÃ THANH TOÁN' where MAHDN=?";
            c.OpenConnection();
            PreparedStatement ps=c.getCon().prepareStatement(sqlStm);
            ps.setInt(1, ma);
            int numberRowsAffected = ps.executeUpdate();
            c.CloseConnection();
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(DAO_CTHDN.class.getName()).log(Level.SEVERE, null, ex);     
        }
        return -1;
    }
      public int kiemTraNam(int nam)
    {
        try {
            
            String sqlSearch="select*from HOADONNHAP where YEAR(NGAYNHAP)=?";
            c.OpenConnection();
            PreparedStatement ps=c.getCon().prepareStatement(sqlSearch);
            ps.setInt(1, nam);
            ResultSet rs=ps.executeQuery();
            if(rs.next())
            {
                 c.CloseConnection();
                  return 1;
            }     
            else
            {
                c.CloseConnection();
                  return 0;
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(DAO_HoaDonNhap.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }
     public int kiemTraChiTietHoaDonNhap(int ma)
    {
        try {
            String sqlSearch="select*from CHITIETHOADONNHAP where MAHDN=?";
            c.OpenConnection();
            PreparedStatement ps=c.getCon().prepareStatement(sqlSearch);
            ps.setInt(1, ma);
            ResultSet rs=ps.executeQuery();
            if(!rs.next())
            {
                c.CloseConnection();
                return 0;
            }
            } catch(SQLException ex) {
            Logger.getLogger(DAO_HoaDonNhap.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
        return 1;
    }
}
