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

/**
 *
 * @author Ngo Truong An
 */
public class DAO_ThongKe {
     ConnectionSQLServer c;

    public DAO_ThongKe() {
        c=new ConnectionSQLServer();
    }
     public void thongKeNhapHangNam(int nam,Vector vdata)
    {
        try {
            vdata.removeAllElements();
            String sqlStm="SELECT*FROM TK_NHAPHANG(?)";
            c.OpenConnection();
           PreparedStatement ps=c.getCon().prepareStatement(sqlStm);  
            ps.setInt(1,nam);
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                Vector<String> v=new Vector<String>();
                int ma=rs.getInt("MAHDN");
                String ngaynhap=rs.getString("NGAYNHAP");
                String maxe=rs.getString("MAXE");
                String tenncc=rs.getString("TENNCC");
                int tongsoxe=rs.getInt("SOLUONGNHAP");

                v.add(String.format("%d", ma));
                v.add(ngaynhap.trim());
                v.add(maxe.trim());
                v.add(tenncc.trim());
                v.add(String.format("%d",tongsoxe));

                vdata.add(v);
            }
            c.CloseConnection();
        } catch (SQLException ex) {
            Logger.getLogger(DAO_ThongKe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     /*-----------------------*/
      public void thongKeNhapTheoNam(int nam,Vector vdata)
    {
        try {
            vdata.removeAllElements();
            String sqlStm="SELECT*FROM dbo.TK_NHAPTHEONAM(?)";
            c.OpenConnection();
           PreparedStatement ps=c.getCon().prepareStatement(sqlStm);  
            ps.setInt(1,nam);
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                Vector<String> v=new Vector<String>();
                int ma=rs.getInt("MAHDN");
                String ngaynhap=rs.getString("NGAYNHAP");
                String maxe=rs.getString("MAXE");
                String tenncc=rs.getString("TENNCC");
                int soluongnhap=rs.getInt("SOLUONGNHAP");
                v.add(String.format("%d",ma));
                v.add(ngaynhap.trim());
                v.add(maxe.trim());
                v.add(tenncc.trim());
                v.add(String.format("%d", soluongnhap));
                vdata.add(v);
            }
            c.CloseConnection();
        } catch (SQLException ex) {
            Logger.getLogger(DAO_ThongKe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       public int tinhTongNhapNam(int nam)
    {
        try {
            int tongnhap=0;
            String sqlStm="SELECT dbo.TINHTONGNHAPNAM(?) AS N'TONGSOXENHAP'";
            c.OpenConnection();
           PreparedStatement ps=c.getCon().prepareStatement(sqlStm);  
            ps.setInt(1,nam);
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                tongnhap=rs.getInt("TONGSOXENHAP");
                        
            }
            c.CloseConnection();
            return tongnhap;
        } catch (SQLException ex) {
            Logger.getLogger(DAO_ThongKe.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }
      public void thongKeNhapTheoThang(int nam, int thang,Vector vdata)
    {
        try {
            vdata.removeAllElements();
            String sqlStm="SELECT*FROM dbo.TK_NHAPTHEOTHANG(?,?)";
            c.OpenConnection();
           PreparedStatement ps=c.getCon().prepareStatement(sqlStm);  
            ps.setInt(1,nam);
            ps.setInt(2, thang);
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                Vector<String> v=new Vector<String>();
                int ma=rs.getInt("MAHDN");
                String ngaynhap=rs.getString("NGAYNHAP");
                String maxe=rs.getString("MAXE");
                String tenncc=rs.getString("TENNCC");
                int soluongnhap=rs.getInt("SOLUONGNHAP");
                v.add(String.format("%d",ma));
                v.add(ngaynhap.trim());
                v.add(maxe.trim());
                v.add(tenncc.trim());
                v.add(String.format("%d", soluongnhap));
                vdata.add(v);
            }
            c.CloseConnection();
        } catch (SQLException ex) {
            Logger.getLogger(DAO_ThongKe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       public int tinhTongNhapThang(int nam, int thang)
    {
        try {
            int tongnhap=0;
            String sqlStm="SELECT dbo.TINHTONGNHAPTHANG(?,?) AS N'TONGSOXENHAP'";
            c.OpenConnection();
           PreparedStatement ps=c.getCon().prepareStatement(sqlStm);  
            ps.setInt(1,nam);
            ps.setInt(2,thang);
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                tongnhap=rs.getInt("TONGSOXENHAP");
                        
            }
            c.CloseConnection();
            return tongnhap;
        } catch (SQLException ex) {
            Logger.getLogger(DAO_ThongKe.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }
     /*---------------------------*/
     
      public void thongKeBanTheoNam(int nam,Vector vdata)
    {
        try {
            vdata.removeAllElements();
            String sqlStm="SELECT*FROM dbo.TK_BANTHEONAM(?)";
            c.OpenConnection();
           PreparedStatement ps=c.getCon().prepareStatement(sqlStm);  
            ps.setInt(1,nam);
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                Vector<String> v=new Vector<String>();
                int ma=rs.getInt("MAHD");
                String ngaytao=rs.getString("NGAYTAO");
                String tenkh=rs.getString("TENKH");
                String maxe=rs.getString("MAXE");
                int soluong=rs.getInt("SOLUONG");
                double thanhtien=rs.getDouble("THANHTIEN");
                v.add(String.format("%d", ma));
                v.add(ngaytao);
                v.add(tenkh);
                v.add(maxe.trim());
                v.add(String.format("%d",soluong ));
                v.add(String.format("%f",thanhtien));
                vdata.add(v);
            }
            c.CloseConnection();
        } catch (SQLException ex) {
            Logger.getLogger(DAO_ThongKe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public void thongKeBanTheoThang(int nam, int thang,Vector vdata)
    {
        try {
            vdata.removeAllElements();
            String sqlStm="SELECT*FROM dbo.TK_BANTHEOTHANG(?,?)";
            c.OpenConnection();
           PreparedStatement ps=c.getCon().prepareStatement(sqlStm);  
            ps.setInt(1,nam);
            ps.setInt(2, thang);
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                Vector<String> v=new Vector<String>();
                int ma=rs.getInt("MAHD");
                String ngaytao=rs.getString("NGAYTAO");
                String tenkh=rs.getString("TENKH");
                String maxe=rs.getString("MAXE");
                int soluong=rs.getInt("SOLUONG");
                double thanhtien=rs.getDouble("THANHTIEN");
                v.add(String.format("%d", ma));
                v.add(ngaytao);
                v.add(tenkh);
                v.add(maxe.trim());
                v.add(String.format("%d",soluong ));
                v.add(String.format("%f",thanhtien));
                vdata.add(v);
            }
            c.CloseConnection();
        } catch (SQLException ex) {
            Logger.getLogger(DAO_ThongKe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /* SELECT dbo.TINHTONGDOANHTHU_NAM(2019) AS N'TONGDOANHTHU'*/
       public double tinhTongDoanhThuNam(int nam)
    {
        try {
            double doanhthu=0;
            String sqlStm="SELECT dbo.TONGDOANHTHUNAM(?) AS 'TONGDOANHTHU'";
            c.OpenConnection();
           PreparedStatement ps=c.getCon().prepareStatement(sqlStm);  
            ps.setInt(1,nam);
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                doanhthu=rs.getDouble("TONGDOANHTHU");
                        
            }
            c.CloseConnection();
            return doanhthu;
        } catch (SQLException ex) {
            Logger.getLogger(DAO_ThongKe.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }
      public double tinhTongDoanhThuThang(int nam, int thang)
    {
        try {
            double doanhthu=0;
            String sqlStm="SELECT dbo.TONGDOANHTHUTHANG(?,?) AS 'TONGDOANHTHU'";
            c.OpenConnection();
           PreparedStatement ps=c.getCon().prepareStatement(sqlStm);  
            ps.setInt(1,nam);
            ps.setInt(2,thang);
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                doanhthu=rs.getDouble("TONGDOANHTHU");
                        
            }
            c.CloseConnection();
            return doanhthu;
        } catch (SQLException ex) {
            Logger.getLogger(DAO_ThongKe.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }
      /*----------------------------------------*/
    /* SELECT dbo.TINHTONGDOANHTHU_NAM(2019) AS N'TONGDOANHTHU'*/
       public double tinhTBDoanhThuNam(int nam)
    {
        try {
            double doanhthu=0;
            String sqlStm="SELECT dbo.TBDOANHTHUNAM(?) AS 'TBDOANHTHU'";
            c.OpenConnection();
           PreparedStatement ps=c.getCon().prepareStatement(sqlStm);  
            ps.setInt(1,nam);
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                doanhthu=rs.getDouble("TBDOANHTHU");
                        
            }
            c.CloseConnection();
            return doanhthu;
        } catch (SQLException ex) {
            Logger.getLogger(DAO_ThongKe.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }
      public double tinhTBDoanhThuThang(int nam, int thang)
    {
        try {
            double doanhthu=0;
            String sqlStm="SELECT dbo.TBDOANHTHUTHANG(?,?) AS 'TBDOANHTHU'";
            c.OpenConnection();
           PreparedStatement ps=c.getCon().prepareStatement(sqlStm);  
            ps.setInt(1,nam);
            ps.setInt(2,thang);
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                doanhthu=rs.getDouble("TBDOANHTHU");
                        
            }
            c.CloseConnection();
            return doanhthu;
        } catch (SQLException ex) {
            Logger.getLogger(DAO_ThongKe.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }
      /*-----------------------------------------*/
         public void tongDoanhThuCacNam(Vector vdata)
    {
        try {
            vdata.removeAllElements();
            String sqlStm="SELECT*FROM VW_TONGDOANHTHU";
            c.OpenConnection();
            Statement stm=c.getCon().createStatement();
            ResultSet rs=stm.executeQuery(sqlStm);
            while(rs.next())
            {
                Vector<String> v=new Vector<String>();
                String nam=rs.getString("NAM");
                String tongdoanhthu=rs.getString("TONGDOANHTHU");    
               v.add(nam);
               v.add(tongdoanhthu);
                vdata.add(v);
            }
            c.CloseConnection();
        } catch (SQLException ex) {
            Logger.getLogger(DAO_ThongKe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
           public void TBDoanhThuCacNam(Vector vdata)
    {
        try {
            vdata.removeAllElements();
            String sqlStm="SELECT*FROM VW_TBDOANHTHU";
            c.OpenConnection();
            Statement stm=c.getCon().createStatement();
            ResultSet rs=stm.executeQuery(sqlStm);
            while(rs.next())
            {
                Vector<String> v=new Vector<String>();
                String nam=rs.getString("NAM");
                String tongdoanhthu=rs.getString("TBDOANHTHU");    
               v.add(nam);
               v.add(tongdoanhthu);
                vdata.add(v);
            }
            c.CloseConnection();
        } catch (SQLException ex) {
            Logger.getLogger(DAO_ThongKe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public void thongKeXeTheoHang(String ten,Vector vdata)
    {
        try {
            vdata.removeAllElements();
            String sqlStm="SELECT*FROM dbo.TK_XETHEOHANG(?)";
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
                String mauxe=rs.getString("MAUXE");
                int tonkho=rs.getInt("SOLUONG");
                v.add(maxe);
                v.add(tenxe);
                v.add(phienban);
                v.add(mauxe);
                v.add(String.format("%d",tonkho));
                vdata.add(v);
            }
            c.CloseConnection();
        } catch (SQLException ex) {
            Logger.getLogger(DAO_ThongKe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      public void thongKeXeTheoTinhTrang(String tinhtrang,Vector vdata)
    {
        try {
            vdata.removeAllElements();
            String sqlStm="SELECT*FROM dbo.TK_XETHEOTINHTRANG(?)";
            c.OpenConnection();
           PreparedStatement ps=c.getCon().prepareStatement(sqlStm);  
            ps.setString(1,tinhtrang);
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                Vector<String> v=new Vector<String>();
                String maxe=rs.getString("MAXE");
                String tenxe=rs.getString("TENXE");
                String phienban=rs.getString("PHIENBAN");
                String mauxe=rs.getString("MAUXE");
                int tonkho=rs.getInt("SOLUONG");
                v.add(maxe);
                v.add(tenxe);
                v.add(phienban);
                v.add(mauxe);
                v.add(String.format("%d",tonkho));
                vdata.add(v);
            }
            c.CloseConnection();
        } catch (SQLException ex) {
            Logger.getLogger(DAO_ThongKe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       public void thongKeXeTheoHangVaTinhTrang(String ten,String tinhtrang,Vector vdata)
    {
        try {
            vdata.removeAllElements();
            String sqlStm="SELECT*FROM dbo.TK_XETHEOHANGVATINHTRANG(?,?)";
            c.OpenConnection();
           PreparedStatement ps=c.getCon().prepareStatement(sqlStm);  
            ps.setString(1,ten);
            ps.setString(2, tinhtrang);
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                Vector<String> v=new Vector<String>();
                String maxe=rs.getString("MAXE");
                String tenxe=rs.getString("TENXE");
                String phienban=rs.getString("PHIENBAN");
                String mauxe=rs.getString("MAUXE");
                int tonkho=rs.getInt("SOLUONG");
                v.add(maxe);
                v.add(tenxe);
                v.add(phienban);
                v.add(mauxe);
                v.add(String.format("%d",tonkho));
                vdata.add(v);
            }
            c.CloseConnection();
        } catch (SQLException ex) {
            Logger.getLogger(DAO_ThongKe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
         public int tinhTongBanThang(int nam, int thang)
    {
        try {
            int tongnhap=0;
            String sqlStm="SELECT dbo.TINHTONGBANTHANG(?,?) AS N'TONGSOXEBAN'";
            c.OpenConnection();
           PreparedStatement ps=c.getCon().prepareStatement(sqlStm);  
            ps.setInt(1,nam);
            ps.setInt(2,thang);
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                tongnhap=rs.getInt("TONGSOXEBAN");
                        
            }
            c.CloseConnection();
            return tongnhap;
        } catch (SQLException ex) {
            Logger.getLogger(DAO_ThongKe.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }
             public int tinhTongBanNam(int nam)
    {
        try {
            int tongnhap=0;
            String sqlStm="SELECT dbo.TINHTONGBANNAM(?) AS N'TONGSOXEBAN'";
            c.OpenConnection();
           PreparedStatement ps=c.getCon().prepareStatement(sqlStm);  
            ps.setInt(1,nam);
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                tongnhap=rs.getInt("TONGSOXEBAN");
                        
            }
            c.CloseConnection();
            return tongnhap;
        } catch (SQLException ex) {
            Logger.getLogger(DAO_ThongKe.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }
}
