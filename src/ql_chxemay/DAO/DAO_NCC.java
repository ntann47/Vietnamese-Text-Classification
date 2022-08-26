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
import ql_chxemay.POJO.Pojo_NhaCungCap;

/**
 *
 * @author Ngo Truong An
 */
public class DAO_NCC {
     ConnectionSQLServer c;

    public DAO_NCC() {
        c=new ConnectionSQLServer();
    }
    public void loadData(Vector vdata)
    {
        try {
            vdata.removeAllElements();
            String sqlStm="SELECT*FROM NHACUNGCAP";
            c.OpenConnection();
            Statement stm=c.getCon().createStatement();
            ResultSet rs=stm.executeQuery(sqlStm);
            while(rs.next())
            {
                Vector<String> v=new Vector<String>();
                String ma=rs.getString("MANCC");
                String ten=rs.getString("TENNCC");
                String dienthoai=rs.getString("DIENTHOAI");
                String diachi=rs.getString("DIACHI");
               
                v.add(ma.trim());
                v.add(ten.trim());
        
                v.add(dienthoai.trim()); 
                v.add(diachi.trim());
                vdata.add(v);
            }
            c.CloseConnection();
        } catch (SQLException ex) {
            Logger.getLogger(DAO_NCC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      public int add(Pojo_NhaCungCap x)
   {
        try {
            String sqlStm="INSERT INTO NHACUNGCAP VALUES(?,?,?,?)";
            c.OpenConnection();
            PreparedStatement ps=c.getCon().prepareStatement(sqlStm);
            ps.setString(1,x.getMancc());
            ps.setString(2,x.getTenncc());
            ps.setString(3,x.getDienthoai());
            ps.setString(4,x.getDiachi());
            int numbeRowsAffected=ps.executeUpdate();
            c.CloseConnection();
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(DAO_NCC.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
   }
      public int update(Pojo_NhaCungCap x)
   {
        try {
            String sqlStm="UPDATE NHACUNGCAP SET TENNCC=?,DIENTHOAI=?,DIACHI=? WHERE MANCC=?";
            c.OpenConnection();
            PreparedStatement ps=c.getCon().prepareStatement(sqlStm);
            ps.setString(4,x.getMancc());
            ps.setString(1,x.getTenncc());
            ps.setString(2,x.getDienthoai());
            ps.setString(3,x.getDiachi());
            int numbeRowsAffected=ps.executeUpdate();
            c.CloseConnection();
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(DAO_NCC.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
   }
    public int delete(String ma)
   {
        try {
            String sqlStm="delete from NHACUNGCAP WHERE MANCC=?";
            c.OpenConnection();
            PreparedStatement ps=c.getCon().prepareStatement(sqlStm);
            ps.setString(1, ma);
            int numbeRowsAffected=ps.executeUpdate();
            c.CloseConnection();
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(DAO_NCC.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
   }
     public int kTraTonTai(String ma)
   {
        try {
            String sqlStm="SELECT* FROM NHACUNGCAP WHERE MANCC=?";
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
            Logger.getLogger(DAO_NCC.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
                  
        }
   }
}
