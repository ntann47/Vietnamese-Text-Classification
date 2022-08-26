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
import ql_chxemay.POJO.Pojo_NhanVien;
import ql_chxemay.POJO.Pojo_XeMay;

/**
 *
 * @author Administrator
 */
public class DAO_NhanVien {
    ConnectionSQLServer c;

    public DAO_NhanVien() {
        c=new ConnectionSQLServer();
    }
    public void loadData(Vector vdata)
    {
        try {
            vdata.removeAllElements();
            String sqlStm="SELECT*FROM NHANVIEN";
            c.OpenConnection();
            Statement stm=c.getCon().createStatement();
            ResultSet rs=stm.executeQuery(sqlStm);
            while(rs.next())
            {
                Vector<String> v=new Vector<String>();
                String manv=rs.getString("MANV");
                String hoten=rs.getString("HOTEN");
                String gioitinh=rs.getString("GIOITINH");
                String ngaysinh=rs.getString("NGAYSINH");
                String dienthoai=rs.getString("DIENTHOAI");
                String diachi=rs.getString("DIACHI");
                
                String ngayvaolam=rs.getString("NGAYVAOLAM");
                String machucvu=rs.getString("MACHUCVU");

               
                v.add(manv.trim());
                v.add(hoten.trim());
                v.add(gioitinh.trim());
                v.add(ngaysinh.trim());
                v.add(dienthoai.trim());
                v.add(diachi.trim());
                
                v.add(ngayvaolam.trim());
                v.add(machucvu.trim());
                vdata.add(v);
            }
            c.CloseConnection();
        } catch (SQLException ex) {
            Logger.getLogger(DAO_NhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void loadDataBanHang(Vector vdata)
    {
        try {
            vdata.removeAllElements();
            String sqlStm="SELECT*FROM NHANVIEN WHERE MACHUCVU='BH'";
            c.OpenConnection();
            Statement stm=c.getCon().createStatement();
            ResultSet rs=stm.executeQuery(sqlStm);
            while(rs.next())
            {
                Vector<String> v=new Vector<String>();
                String manv=rs.getString("MANV");
                String hoten=rs.getString("HOTEN");
                String gioitinh=rs.getString("GIOITINH");
                String ngaysinh=rs.getString("NGAYSINH");
                String dienthoai=rs.getString("DIENTHOAI");
                String diachi=rs.getString("DIACHI");
                
                String ngayvaolam=rs.getString("NGAYVAOLAM");
                String machucvu=rs.getString("MACHUCVU");
               
                v.add(manv.trim());
                v.add(hoten.trim());
                v.add(gioitinh.trim());
                v.add(ngaysinh.trim());
                v.add(dienthoai.trim());
                v.add(diachi.trim());
                
                v.add(ngayvaolam.trim());
                v.add(machucvu.trim());  
                vdata.add(v);
                
            }
            c.CloseConnection();
        } catch (SQLException ex) {
            Logger.getLogger(DAO_NhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void loadDataKiemKho(Vector vdata)
    {
        try {
            vdata.removeAllElements();
            String sqlStm="SELECT*FROM NHANVIEN WHERE MACHUCVU='KK'";
            c.OpenConnection();
            Statement stm=c.getCon().createStatement();
            ResultSet rs=stm.executeQuery(sqlStm);
            while(rs.next())
            {
                Vector<String> v=new Vector<String>();
                String manv=rs.getString("MANV");
                String hoten=rs.getString("HOTEN");
                String gioitinh=rs.getString("GIOITINH");
                String ngaysinh=rs.getString("NGAYSINH");
                  String dienthoai=rs.getString("DIENTHOAI");
                String diachi=rs.getString("DIACHI");
              
                String ngayvaolam=rs.getString("NGAYVAOLAM");
                String machucvu=rs.getString("MACHUCVU");
                v.add(manv);
                v.add(hoten);
                v.add(gioitinh);
                v.add(ngaysinh);
                 v.add(dienthoai);
                v.add(diachi);
               
                v.add(ngayvaolam);
                v.add(machucvu);

                vdata.add(v);
            }
            c.CloseConnection();
        } catch (SQLException ex) {
            Logger.getLogger(DAO_NhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public int add(Pojo_NhanVien x)
   {
        try {
            String sqlStm="SET DATEFORMAT DMY INSERT INTO NHANVIEN VALUES(?,?,?,?,?,?,?,?)";
            c.OpenConnection();
            PreparedStatement ps=c.getCon().prepareStatement(sqlStm);
            ps.setString(1,x.getManv());
            ps.setString(2,x.getHoten() );
            ps.setString(3,x.getGioitinh());
            ps.setString(4,x.getNgaysinh());
            ps.setString(5,x.getDienthoai());
            ps.setString(6,x.getDiachi());
            ps.setString(7,x.getNgayvaolam());
            ps.setString(8,x.getMachucvu());

            int numbeRowsAffected=ps.executeUpdate();
            c.CloseConnection();
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(DAO_NhanVien.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
   }
    public int update(Pojo_NhanVien x)
   {
        try {
            String sqlStm="UPDATE NHANVIEN SET HOTEN=?,GIOITINH=?,NGAYSINH=?,DIENTHOAI=?,DIACHI=?,NGAYVAOLAM=?,MACHUCVU=? WHERE MANV=?";
            c.OpenConnection();
            PreparedStatement ps=c.getCon().prepareStatement(sqlStm);
            ps.setString(1,x.getHoten());
            ps.setString(2,x.getGioitinh());
            ps.setString(3,x.getNgaysinh());
            ps.setString(4,x.getDienthoai());
            ps.setString(5,x.getDiachi());
            ps.setString(6,x.getNgayvaolam());
            ps.setString(7,x.getMachucvu());
            ps.setString(8,x.getManv());
            int numbeRowsAffected=ps.executeUpdate();
            c.CloseConnection();
            return 1;
            
        } catch (SQLException ex) {
            Logger.getLogger(DAO_NhanVien.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
   }
     public int delete(String ma)
   {
        try {
            String sqlStm="DELETE FROM NHANVIEN WHERE MANV=?";
            c.OpenConnection();
            PreparedStatement ps=c.getCon().prepareStatement(sqlStm);
           ps.setString(1, ma);
            int numbeRowsAffected=ps.executeUpdate();
            c.CloseConnection();
            return 1;
            
        } catch (SQLException ex) {
            Logger.getLogger(DAO_NhanVien.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
                  
        }
   }
      public int kTraTonTai(String ma)
   {
        try {
            String sqlStm="SELECT* FROM NHANVIEN WHERE MANV=?";
            c.OpenConnection();
            PreparedStatement ps=c.getCon().prepareStatement(sqlStm);
            ps.setString(1, ma);
            ResultSet rs=ps.executeQuery();
            if(!rs.next())
            {
                c.CloseConnection();
                return 0;
            }
            else
            {   c.CloseConnection();
                return 1;
            }
     
        } catch (SQLException ex) {
            Logger.getLogger(DAO_NhanVien.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
                  
        }
   }
    
}
