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
import ql_chxemay.POJO.Pojo_TaiKhoan;

/**
 *
 * @author Administrator
 */
public class DAO_TaiKhoan {
    ConnectionSQLServer c;

    public DAO_TaiKhoan() {
        c=new ConnectionSQLServer();
    }
    public void loadData(Vector vdata)
    {
        try {
            vdata.removeAllElements();
            String sqlStm="SELECT*FROM TAIKHOAN";
            c.OpenConnection();
            Statement stm=c.getCon().createStatement();
            ResultSet rs=stm.executeQuery(sqlStm);
            while(rs.next())
            {
                Vector<String> v=new Vector<String>();
                String tendn=rs.getString("TENDANGNHAP");
                String matkhau=rs.getString("MATKHAU");
                String tenngdung=rs.getString("TENNGUOIDUNG");
                String macv=rs.getString("MACHUCVU");
                String nhomquyen=rs.getString("NHOMQUYEN");
                v.add(tendn.trim());
                v.add(matkhau.trim());
                v.add(tenngdung.trim());
                v.add(macv.trim());
                v.add(nhomquyen.trim());
                vdata.add(v);
            }
            c.CloseConnection();
        } catch (SQLException ex) {
            Logger.getLogger(DAO_TaiKhoan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public int taoTaiKhoan(Pojo_TaiKhoan x)
    {
       
            try {
            c.OpenConnection();
            String stm="{call TAO_TAIKHOAN(?,?,?,?,?)}";
            CallableStatement cs=c.getCon().prepareCall(stm);
            cs.setString(1,x.getTendn());
            cs.setString(2, x.getMatkhau());
            cs.setString(3,x.getTennguoidung());
            cs.setString(4,x.getMachucvu());
            cs.setString(5, x.getNhomquyen());
            int numberRowsAffected = cs.executeUpdate();
            c.CloseConnection();
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(DAO_HoaDon.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }  
    }
    public int capQuyen(Pojo_TaiKhoan x)
    {
         try {
            c.OpenConnection();
            String stm="{call CAPQUYEN(?,?,?,?,?)}";
            CallableStatement cs=c.getCon().prepareCall(stm);
            cs.setString(1,x.getTendn());
            cs.setString(2, x.getMatkhau());
            cs.setString(3,x.getTennguoidung());
            cs.setString(4,x.getMachucvu());
            cs.setString(5, x.getNhomquyen());
            int numberRowsAffected = cs.executeUpdate();
            c.CloseConnection();
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(DAO_HoaDon.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }  
    }
     public int thuHoiQuyen(Pojo_TaiKhoan x)
    {
         try {
            c.OpenConnection();
            String stm="{call THUHOIQUYEN(?,?,?,?,?)}";
            CallableStatement cs=c.getCon().prepareCall(stm);
            cs.setString(1,x.getTendn());
            cs.setString(2, x.getMatkhau());
            cs.setString(3,x.getTennguoidung());
            cs.setString(4,x.getMachucvu());
            cs.setString(5, x.getNhomquyen());
            int numberRowsAffected = cs.executeUpdate();
            c.CloseConnection();
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(DAO_HoaDon.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }  
    }
      public int xoaTaiKhoan(Pojo_TaiKhoan x)
    {
         try {
            c.OpenConnection();
            String stm="{call XOA_TAIKHOAN(?,?,?,?,?)}";
            CallableStatement cs=c.getCon().prepareCall(stm);
            cs.setString(1,x.getTendn());
            cs.setString(2, x.getMatkhau());
            cs.setString(3,x.getTennguoidung());
            cs.setString(4,x.getMachucvu());
            cs.setString(5, x.getNhomquyen());
            int numberRowsAffected = cs.executeUpdate();
            c.CloseConnection();
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(DAO_HoaDon.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }  
    }
      public int capNhatTaiKhoan(Pojo_TaiKhoan x)
    {
         try {
            c.OpenConnection();
            String stm="{call CAPNHAT_TAIKHOAN(?,?,?,?,?)}";
            CallableStatement cs=c.getCon().prepareCall(stm);
            cs.setString(1,x.getTendn());
            cs.setString(2, x.getMatkhau());
            cs.setString(3,x.getTennguoidung());
            cs.setString(4,x.getMachucvu());
            cs.setString(5, x.getNhomquyen());
            int numberRowsAffected = cs.executeUpdate();
            c.CloseConnection();
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(DAO_HoaDon.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }  
        
    }
    public int kTraTonTai(Pojo_TaiKhoan x)
    {
        try{
            String sqlSearch="select*from TAIKHOAN where TENDANGNHAP=?";
            c.OpenConnection();
            PreparedStatement ps=c.getCon().prepareStatement(sqlSearch);
            ps.setString(1, x.getTendn());
            ResultSet rs=ps.executeQuery();
            if(!rs.next())
            {
                c.CloseConnection();
                return 0;
            } 
            else
                return 1;
        } catch (SQLException ex) {
            Logger.getLogger(DAO_HoaDon.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }
}
