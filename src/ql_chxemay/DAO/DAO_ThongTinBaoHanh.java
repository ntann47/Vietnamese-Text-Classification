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
import ql_chxemay.POJO.Pojo_ThongTinBaoHanh;

/**
 *
 * @author Administrator
 */
public class DAO_ThongTinBaoHanh {
    ConnectionSQLServer c;
    public DAO_ThongTinBaoHanh() {
        c=new ConnectionSQLServer();
    }
    public void loadPBH(Vector vdata)
    {
        try {
            vdata.removeAllElements();
            String sqlStm="SELECT * FROM THONGTINBAOHANH";
            c.OpenConnection();
            Statement stm=c.getCon().createStatement();
            ResultSet rs=stm.executeQuery(sqlStm);
            while(rs.next())
            {
                Vector<String> v=new Vector<String>();
                String ma=rs.getString("MAPBH");
                String makh=rs.getString("MAKH");
                String mahd=rs.getString("MAHD");
                String maxe=rs.getString("MAXE");
                String sokhung=rs.getString("SOKHUNG");
                String somay=rs.getString("SOMAY");
                String ngaymua=rs.getString("NGAYMUA");
                String thoihanbh=rs.getString("THOIHANBH");
               
                v.add(ma);
                v.add(makh);
                v.add(mahd);
                v.add(maxe);
                v.add(sokhung);
                v.add(somay);
                v.add(ngaymua.trim()); 
                v.add(thoihanbh.trim());
                vdata.add(v);
            }
            c.CloseConnection();
        } catch (SQLException ex) {
            Logger.getLogger(DAO_ThongTinBaoHanh.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public int getLast()
    {
        try {
            // TODO add your handling code here:
            c.OpenConnection();
            String stm="{call TRUYCAP_MAPBHCUOICUNG(?)}";
            CallableStatement cs=c.getCon().prepareCall(stm);
            cs.registerOutParameter(1, java.sql.Types.INTEGER);
            cs.execute();
            int last =cs.getInt(1);
            return last;
        } catch (SQLException ex) {
            Logger.getLogger(DAO_ThongTinBaoHanh.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
      public void add(Pojo_ThongTinBaoHanh x)
    {
       
            try {
            c.OpenConnection();
            String sqlUpdate="{call THEM_THONGTINBAOHANH(?,?,?,?,?,?)}";
                CallableStatement cs=c.getCon().prepareCall(sqlUpdate);
                cs.setInt(1,x.getMapbh());
                cs.setString(2, x.getMakh());
                cs.setInt(3,x.getMahd());
                cs.setString(4,x.getMaxe());
                cs.setString(5, x.getSokhung());
                cs.setString(6,x.getSomay());
                int numberRowsAffected = cs.executeUpdate();
            c.CloseConnection();
        } catch (SQLException ex) {
           Logger.getLogger(DAO_ThongTinBaoHanh.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
         public int delete(int ma)
    {
       
            try {
            String sqlStm="DELETE FROM THONGTINBAOHANH WHERE MAPBH=?";
            c.OpenConnection();
            PreparedStatement ps=c.getCon().prepareStatement(sqlStm);
            ps.setInt(1, ma);
            int numberRowsAffected = ps.executeUpdate();
            c.CloseConnection();
            return 1;
        } catch (SQLException ex) {
           Logger.getLogger(DAO_ThongTinBaoHanh.class.getName()).log(Level.SEVERE, null, ex);
           return -1;
        }  
    }
      
      public Pojo_ThongTinBaoHanh search(int ma)
    {
        try {
            
            String sqlSearch="select*from THONGTINBAOHANH where MAPBH=?";
            c.OpenConnection();
            PreparedStatement ps=c.getCon().prepareStatement(sqlSearch);
            ps.setInt(1, ma);
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                int mapbh=rs.getInt("MAPBH");
                String makh=rs.getString("MAKH");
                int mahd=rs.getInt("MAHD");
                String maxe=rs.getString("MAXE");
                String sokhung=rs.getString("SOKHUNG");
                String somay=rs.getString("SOMAY");
                String ngaymua=rs.getString("NGAYMUA");
                String thoihanbh=rs.getString("THOIHANBH");
                Pojo_ThongTinBaoHanh x=new Pojo_ThongTinBaoHanh(mapbh, makh, mahd, maxe, sokhung, somay,ngaymua,thoihanbh);
                return x;
            }
            c.CloseConnection();
        } catch (SQLException ex) {
            Logger.getLogger(DAO_ThongTinBaoHanh.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
       public int kTraTonTai(int ma)
    {
        try {
            
            String sqlStm="select*from THONGTINBAOHANH where MAPBH=?";
            c.OpenConnection();
            PreparedStatement ps=c.getCon().prepareStatement(sqlStm);
            ps.setInt(1, ma);
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                c.CloseConnection();
                return 1;
            }
            c.CloseConnection();
        } catch (SQLException ex) {
            Logger.getLogger(DAO_ThongTinBaoHanh.class.getName()).log(Level.SEVERE, null, ex);     
        }
        return -1;
    }
    public void update(Pojo_ThongTinBaoHanh x)
    {
        
        try {
            c.OpenConnection();
            String sqlUpdate="UPDATE THONGTINBAOHANH SET MAKH=?,MAHD=?,MAXE=?,SOKHUNG=?,SOMAY=?,NGAYMUA=?,THOIHANBH=? WHERE MAPBH=?";
            PreparedStatement ps=c.getCon().prepareStatement(sqlUpdate);
            ps.setString(1,x.getMakh().trim());
            ps.setInt(2,x.getMahd());
            ps.setString(3,x.getMaxe().trim());
            ps.setString(4, x.getSokhung().trim());
            ps.setString(5,x.getSomay());
            ps.setString(6,x.getNgaymua());
            ps.setString(7,x.getThoihanbh());
            ps.setInt(8, x.getMapbh());
            int numberRowsAffected=ps.executeUpdate();
            c.CloseConnection();
        } catch (SQLException ex) {
            Logger.getLogger(DAO_ThongTinBaoHanh.class.getName()).log(Level.SEVERE, null, ex);     
        }
    }
}
