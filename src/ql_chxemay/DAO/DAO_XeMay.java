/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ql_chxemay.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import ql_chxemay.ConnectionSQLServer;
import ql_chxemay.POJO.Pojo_XeMay;

/**
 *
 * @author Administrator
 */
public class DAO_XeMay {
    ConnectionSQLServer c;

    public DAO_XeMay() {
        c=new ConnectionSQLServer();
    }
    public void loadData(Vector vdata)
    {
        try {
            vdata.removeAllElements();
            String sqlStm="SELECT*FROM XEMAY";
            c.OpenConnection();
            Statement stm=c.getCon().createStatement();
            ResultSet rs=stm.executeQuery(sqlStm);
            while(rs.next())
            {
                Vector<String> v=new Vector<String>();
                String ma=rs.getString("MAXE");
                String ten=rs.getString("TENXE");
                String phienban=rs.getString("PHIENBAN");
                String mausac=rs.getString("MAUXE");
                String maloai=rs.getString("MALOAIXE");
                String mansx=rs.getString("MANSX");
                String mancc=rs.getString("MANCC");
                double gia=rs.getDouble("GIABAN");
                int sonam=rs.getInt("SONAMBH");
                int ton=rs.getInt("SOLUONG");
                String tinhtrang=rs.getString("TINHTRANG");
                v.add(ma);
                v.add(ten);
                v.add(phienban);
                v.add(mausac);
                v.add(maloai);
                v.add(mansx);
                v.add(mancc);
                v.add(String.format("%f",gia));
                v.add(String.format("%d",sonam)); 
                v.add(String.format("%d",ton));
                v.add(tinhtrang);
                vdata.add(v);
            }
            c.CloseConnection();
        } catch (SQLException ex) {
            Logger.getLogger(DAO_XeMay.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void loadTenXe(Vector vdata)
    {
        try {
            vdata.removeAllElements();
            String sqlStm="SELECT DISTINCT TENXE FROM XEMAY";
            c.OpenConnection();
            Statement stm=c.getCon().createStatement();
            ResultSet rs=stm.executeQuery(sqlStm);
            while(rs.next())
            {
                Vector<String> v=new Vector<String>();
                String ten=rs.getString("TENXE"); 
                v.add(ten);
                vdata.add(v);
            }
            c.CloseConnection();
        } catch (SQLException ex) {
            Logger.getLogger(DAO_XeMay.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void timTheoTen(String ten,Vector vdata)
    {
        try {
            vdata.removeAllElements();
            String sqlStm="SELECT*FROM XEMAY WHERE TENXE=?";
            c.OpenConnection();
             PreparedStatement ps=c.getCon().prepareStatement(sqlStm);
             ps.setString(1,ten);
             ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                Vector<String> v=new Vector<String>();
                String maxe=rs.getString("MAXE");
                String tenxe=rs.getString("TENXE");
                String phienban=rs.getString("PHIENBAN");
                String mausac=rs.getString("MAUXE");
                String maloai=rs.getString("MALOAIXE");
                String mansx=rs.getString("MANSX");
                String mancc=rs.getString("MANCC");
                double gia=rs.getDouble("GIABAN");
                int sonam=rs.getInt("SONAMBH");
                int ton=rs.getInt("SOLUONG");
                String tinhtrang=rs.getString("TINHTRANG");     
                v.add(maxe);
                v.add(tenxe);
                v.add(phienban);
                v.add(mausac);
                v.add(maloai);
                v.add(mansx);
                v.add(mancc);
                v.add(String.format("%f",gia));
                v.add(String.format("%d",sonam)); 
                v.add(String.format("%d",ton));
                v.add(tinhtrang);
                vdata.add(v);
            }
            c.CloseConnection();
        } catch (SQLException ex) {
            Logger.getLogger(DAO_XeMay.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void danhSachTheoHang(String tenhang,Vector vdata)
    {
        try {
            vdata.removeAllElements();
            String sqlStm="SELECT*FROM dbo.DS_XETHEOTENNSX(?)";
            c.OpenConnection();
             PreparedStatement ps=c.getCon().prepareStatement(sqlStm);
             ps.setString(1,tenhang);
             ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                Vector<String> v=new Vector<String>();
                String maxe=rs.getString("MAXE");
                String tenxe=rs.getString("TENXE");
                String phienban=rs.getString("PHIENBAN");
                String mausac=rs.getString("MAUXE");
                String maloai=rs.getString("MALOAIXE");
                String mansx=rs.getString("MANSX");
                String mancc=rs.getString("MANCC");
                double gia=rs.getDouble("GIABAN");
                int sonam=rs.getInt("SONAMBH");
                int ton=rs.getInt("SOLUONG");
                String tinhtrang=rs.getString("TINHTRANG");     
                v.add(maxe);
                v.add(tenxe);
                v.add(phienban);
                v.add(mausac);
                v.add(maloai);
                v.add(mansx);
                v.add(mancc);
                v.add(String.format("%f",gia));
                v.add(String.format("%d",sonam)); 
                v.add(String.format("%d",ton));
                v.add(tinhtrang);
                vdata.add(v);
            }
            c.CloseConnection();
        } catch (SQLException ex) {
            Logger.getLogger(DAO_XeMay.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   public void update(Pojo_XeMay x)
   {
        try {
            String sqlStm="UPDATE XEMAY SET TENXE=?,PHIENBAN=?,MAUXE=?,MALOAIXE=?,MANSX=?,MANCC=?,GIABAN=?,SONAMBH=?,SOLUONG=? WHERE MAXE=?";
            c.OpenConnection();
            PreparedStatement ps=c.getCon().prepareStatement(sqlStm);
            ps.setString(1,x.getTenxe() );
            ps.setString(2,x.getPhienban());
            ps.setString(3,x.getMauxe());
            ps.setString(4,x.getMaloaixe());
            ps.setString(5,x.getMansx());
            ps.setString(6,x.getMancc());
            ps.setDouble(7,x.getGiaban());
            ps.setInt(8,x.getSonambh());
            ps.setInt(9,x.getTonkho());
            ps.setString(10,x.getMaxe());
            int numbeRowsAffected=ps.executeUpdate();
            c.CloseConnection();
        } catch (SQLException ex) {
            Logger.getLogger(DAO_XeMay.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
   public int add(Pojo_XeMay x)
   {
        try {
            String sqlStm="INSERT INTO XEMAY(MAXE) VALUES(?,?,?,?,?,?,?,?,?,?)";
            c.OpenConnection();
            PreparedStatement ps=c.getCon().prepareStatement(sqlStm);
            ps.setString(1,x.getMaxe());
            ps.setString(2,x.getTenxe() );
            ps.setString(3,x.getPhienban());
            ps.setString(4,x.getMauxe());
            ps.setString(5,x.getMaloaixe());
            ps.setString(6,x.getMansx());
            ps.setString(7,x.getMancc());
            ps.setDouble(8,x.getGiaban());
            ps.setInt(9,x.getSonambh());
            ps.setInt(10,x.getTonkho());
            
            int numbeRowsAffected=ps.executeUpdate();
            c.CloseConnection();
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(DAO_XeMay.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
   }
   public int themMaXe(String ma)
   {
        try {
            String sqlStm="INSERT INTO XEMAY(MAXE) VALUES(?)";
            c.OpenConnection();
            PreparedStatement ps=c.getCon().prepareStatement(sqlStm);
            ps.setString(1,ma);  
            int numbeRowsAffected=ps.executeUpdate();
            c.CloseConnection();
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(DAO_XeMay.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
   }
   public int xoaXe(String ma)
   {
        try {
            String sqlStm="DELETE FROM XEMAY WHERE MAXE=?";
            c.OpenConnection();
            PreparedStatement ps=c.getCon().prepareStatement(sqlStm);
            ps.setString(1,ma);  
            int numbeRowsAffected=ps.executeUpdate();
            c.CloseConnection();
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(DAO_XeMay.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
   }
    public void timTheoMa(String ma,Vector vdata)
    {
        try {
            vdata.removeAllElements();
            String sqlStm="SELECT*FROM XEMAY WHERE MAXE=?";
            c.OpenConnection();
             PreparedStatement ps=c.getCon().prepareStatement(sqlStm);
             ps.setString(1,ma);
             ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                vdata.removeAllElements();
                Vector<String> v=new Vector<String>();
                String maxe=rs.getString("MAXE");
                String tenxe=rs.getString("TENXE");
                String phienban=rs.getString("PHIENBAN");
                String mausac=rs.getString("MAUXE");
                String maloai=rs.getString("MALOAIXE");
                String mansx=rs.getString("MANSX");
                String mancc=rs.getString("MANCC");
                double gia=rs.getDouble("GIABAN");
                int sonam=rs.getInt("SONAMBH");
                int ton=rs.getInt("SOLUONG");
                String tinhtrang=rs.getString("TINHTRANG");        
                v.add(maxe);
                v.add(tenxe);
                v.add(phienban);
                v.add(mausac);
                v.add(maloai);
                v.add(mansx);
                v.add(mancc);
                v.add(String.format("%f",gia));
                v.add(String.format("%d",sonam)); 
                v.add(String.format("%d",ton));
                v.add(tinhtrang);
                vdata.add(v);
            }
            c.CloseConnection();
        } catch (SQLException ex) {
            Logger.getLogger(DAO_XeMay.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Pojo_XeMay search(String ma)
    {
        try {
            String sqlStm="SELECT*FROM XEMAY WHERE MAXE=?";
            c.OpenConnection();
             PreparedStatement ps=c.getCon().prepareStatement(sqlStm);
             ps.setString(1,ma);
             ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                Pojo_XeMay x;
                String maxe=rs.getString("MAXE");
                String tenxe=rs.getString("TENXE");
                String phienban=rs.getString("PHIENBAN");
                String mausac=rs.getString("MAUXE");
                String maloai=rs.getString("MALOAIXE");
                String mansx=rs.getString("MANSX");
                String mancc=rs.getString("MANCC");
                double gia=rs.getDouble("GIABAN");
                int sonam=rs.getInt("SONAMBH");
                int ton=rs.getInt("SOLUONG");
                String tinhtrang=rs.getString("TINHTRANG");        
                x=new Pojo_XeMay(maxe, tenxe, phienban, maxe, maloai, mansx, mancc, gia, sonam, ton);
                c.CloseConnection();
                return x;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DAO_XeMay.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return null;
    }
    public int kTraMaXe(String ma)
    {
        try {
            String sqlStm="SELECT*FROM XEMAY WHERE MAXE=?";
            c.OpenConnection();
            PreparedStatement ps=c.getCon().prepareStatement(sqlStm);
            ps.setString(1,ma);
            ResultSet rs=ps.executeQuery();
            if(rs.next())
            {
                c.CloseConnection();
                return 1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_XeMay.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
           
        }
        return 0;
    }

}
