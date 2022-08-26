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
import ql_chxemay.POJO.Pojo_HoaDon;

/**
 *
 * @author Administrator
 */
public class DAO_HoaDon {
    ConnectionSQLServer c;

    public DAO_HoaDon() {
        c=new ConnectionSQLServer();
    }
        public void loadData(Vector vdata)
    {
        try {
            vdata.removeAllElements();
            String sqlStm="select*from HOADON";
            c.OpenConnection();
            Statement stm=c.getCon().createStatement();
            ResultSet rs=stm.executeQuery(sqlStm);
            while(rs.next())
            {
                Vector<String> v=new Vector<String>();
                int mahd=rs.getInt("MAHD");
                
                String manv=rs.getString("MANV");
                String makh=rs.getString("MAKH");
                String ngay=rs.getString("NGAYTAO");
                double tlgg=rs.getDouble("TLGIAMGIA");
                double tt=rs.getDouble("TONGTIEN");
                String trangthai=rs.getString("TRANGTHAI");
                String ghichu=rs.getString("GHICHU");
                v.add(String.format("%d",mahd));
                
                v.add(manv);
                v.add(makh);
                v.add(ngay);
                v.add(String.format("%f",tlgg));
                v.add(String.format("%f",tt));
                v.add(trangthai);
                v.add(ghichu);
                vdata.add(v);
            }
            c.CloseConnection();
        } catch (SQLException ex) {
            Logger.getLogger(DAO_HoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void add(Pojo_HoaDon x)
    {
       
            try {
            c.OpenConnection();
            String stm="{call THEM_HOADON(?,?,?)}";
            CallableStatement cs=c.getCon().prepareCall(stm);
            cs.setInt(1,x.getMahd());
           
            cs.setString(2,x.getManv());
            cs.setString(3,x.getMakh());
            int numberRowsAffected = cs.executeUpdate();
            c.CloseConnection();
        } catch (SQLException ex) {
            Logger.getLogger(DAO_HoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }        
        
    }
    public int delete(int ma)
    {
       
            try {
            c.OpenConnection();
            String stm="delete from HOADON where MAHD=?";
            CallableStatement cs=c.getCon().prepareCall(stm);
            cs.setInt(1,ma);
            int numberRowsAffected = cs.executeUpdate();
            c.CloseConnection();
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(DAO_HoaDon.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }        
        
    }
    
       /*
    public void update(Pojo_HoaDon x)
    {
        
        try {
            c.OpenConnection();
            String sqlUpdate="update HOADON set NGAYTAO=?,MANV=?,MAKH=?,MABAN=?,TONGTIEN=?,TRANGTHAI=? where MAHD=?";
            PreparedStatement ps=c.getCon().prepareStatement(sqlUpdate);
            ps.setString(1, x.getNgaytao());
            ps.setString(2, x.getManv());
            ps.setString(3, x.getMakh());
            ps.setString(4, x.getMaban());
            ps.setFloat(5, x.getTongtien());
            ps.setString(6, x.getTrangthai().trim());
            ps.setString(7, x.getMahd());
            int numberRowsAffected=ps.executeUpdate();
            c.CloseConnection();
        } catch (SQLException ex) {
            
        }
    }*/
     public int thanhToan(Pojo_HoaDon x)
    {
        
        try {
            c.OpenConnection();
          
            String sqlUpdate="update HOADON set TRANGTHAI=N'ĐÃ THANH TOÁN' where MAHD=?";
            PreparedStatement ps=c.getCon().prepareStatement(sqlUpdate);  
            ps.setInt(1, x.getMahd());
            int numberRowsAffected=ps.executeUpdate();
            c.CloseConnection();
            return 1;
        } catch (SQLException ex) {    
        }
        return -1;
    }
    public Pojo_HoaDon search(int ma)
    {
        try {
            
            String sqlSearch="select*from HOADON where MAHD=?";
            c.OpenConnection();
            PreparedStatement ps=c.getCon().prepareStatement(sqlSearch);
            ps.setInt(1, ma);
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
               
                int mahd=rs.getInt("MAHD");
                String manv=rs.getString("MANV");
                String makh=rs.getString("MAKH");
                String ngay=rs.getString("NGAYTAO");
                double tlgg=rs.getDouble("TLGIAMGIA");
                double tt=rs.getDouble("TONGTIEN");
                String trangthai=rs.getString("TRANGTHAI");
                String ghichu=rs.getString("GHICHU");
                Pojo_HoaDon x=new Pojo_HoaDon(mahd, manv, makh, ngay, tlgg, tt, trangthai, ghichu);
                return x;
            }
            c.CloseConnection();
        } catch (SQLException ex) {
            Logger.getLogger(DAO_HoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public int getLast()
    {
        try {
            // TODO add your handling code here:
            c.OpenConnection();
            String stm="{call TRUYCAP_MAHDCUOICUNG(?)}";
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
    public float tinhTongTien(String ma)
    {
       
        try {
            c.OpenConnection();
             String sqlInsert="SELECT SUM(C.THANHTIEN) AS N'TONGTIEN' FROM HOADON H, CHITIETHOADON C WHERE H.MAHD=C.MAHD AND H.MAHD=?";
            PreparedStatement ps=c.getCon().prepareStatement(sqlInsert);
           
            ps.setString(1, ma);
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                float tongtien=rs.getFloat("TONGTIEN");       
                return tongtien;
            }
         
            int numberRowsAffected=ps.executeUpdate();
            c.CloseConnection();
        } catch (SQLException ex) {
            Logger.getLogger(DAO_HoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }  
        return -1;
    }
     public int thanhToan(int ma)
    {
        try {
            
            String sqlStm="UPDATE HOADON SET TRANGTHAI=N'ĐÃ THANH TOÁN' where MAHD=?";
            c.OpenConnection();
            PreparedStatement ps=c.getCon().prepareStatement(sqlStm);
            ps.setInt(1, ma);
            int numberRowsAffected = ps.executeUpdate();
            c.CloseConnection();
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(DAO_HoaDon.class.getName()).log(Level.SEVERE, null, ex);     
        }
        return -1;
    }
       public int kiemTraNam(int nam)
    {
        try {
            
            String sqlSearch="select*from HOADON where YEAR(NGAYTAO)=?";
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
            Logger.getLogger(DAO_HoaDon.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }
      
    public int kiemTraChiTietHoaDon(int ma)
    {
        try {
            String sqlSearch="select*from CHITIETHOADON where MAHD=?";
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
