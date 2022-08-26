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
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import ql_chxemay.ConnectionSQLServer;
import ql_chxemay.POJO.Pojo_CTHD;
import ql_chxemay.POJO.Pojo_HoaDon;
//import ql_chxemay.POJO.Pojo_HoaDonNhap;

/**
 *
 * @author Administrator
 */
public class DAO_CTHD {
    ConnectionSQLServer c;

    public DAO_CTHD() {
        c=new ConnectionSQLServer();
    }
     public void loadData(Vector vdata, int x)
    {
        try {
            vdata.removeAllElements();
            String sqlStm="select*from CHITIETHOADON where MAHD=?";
            c.OpenConnection();
            PreparedStatement ps=c.getCon().prepareStatement(sqlStm);
            ps.setInt(1, x);
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                Vector<String> v=new Vector<String>();
                int mahd=rs.getInt("MAHD");
                int id=rs.getInt("ID");
                String masp=rs.getString("MAXE");
                int sl=rs.getInt("SOLUONG");
                double dongia=rs.getDouble("DONGIA");
                double thanhtien=rs.getDouble("THANHTIEN");
                v.add(String.format("%d",mahd));
                v.add(String.format("%d",id));
                v.add(masp);
                v.add(String.format("%d",sl));
                v.add(String.format("%f",dongia));
                v.add(String.format("%f",thanhtien));
                vdata.add(v);
            }
            c.CloseConnection();
        } catch (SQLException ex) {
            Logger.getLogger(DAO_CTHD.class.getName()).log(Level.SEVERE, null, ex);      
        }
    }
    public void add(Pojo_CTHD x)
    {
       
            try {
            c.OpenConnection();
            String sqlUpdate="{call THEM_CTHD(?,?,?,?)}";
                CallableStatement cs=c.getCon().prepareCall(sqlUpdate);
                cs.setInt(1,x.getMahd());
                cs.setInt(2, x.getId());
                cs.setString(3,x.getMaxe());
                cs.setInt(4,x.getSoluong());
                int numberRowsAffected = cs.executeUpdate();
            c.CloseConnection();
        } catch (SQLException ex) {
           
        }  
    }
    public int xoaCTHD(Pojo_CTHD x)
    {
       
            try {
            c.OpenConnection();
             String sqlInsert="delete from CHITIETHOADON where MAHD=? and ID=?";
            PreparedStatement ps=c.getCon().prepareStatement(sqlInsert);
            ps.setInt(1, x.getMahd());
            ps.setInt(2, x.getId());
            int numberRowsAffected=ps.executeUpdate();
            c.CloseConnection();
            return 1;
        } catch (SQLException ex) {
            
        } 
            return -1;
    }
    public int getLast(Pojo_HoaDon x)
    {
        try {
            // TODO add your handling code here:
            c.OpenConnection();
            String stm="{call TRUYCAP_IDCTHDCUOICUNG(?,?)}";
            CallableStatement cs=c.getCon().prepareCall(stm);
            cs.setInt(1, x.getMahd());
            cs.registerOutParameter(2, java.sql.Types.INTEGER);
            cs.execute();
            int last =cs.getInt(2);
            return last;
        } catch (SQLException ex) {
            Logger.getLogger(DAO_CTHD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    public int huyHoaDon(int ma)
    {
        try {
            // TODO add your handling code here:
            c.OpenConnection();
            String stm="{call HUY_HOADON(?)}";
            CallableStatement cs=c.getCon().prepareCall(stm);
            cs.setInt(1, ma);
            int numberRowsAffected = cs.executeUpdate();
            c.CloseConnection();
            
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(DAO_CTHD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    public int kTraTonTai(int ma)
    {
        try {
            
            String sqlStm="select*from CHITIETHOADON where MAHD=?";
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
            Logger.getLogger(DAO_CTHDN.class.getName()).log(Level.SEVERE, null, ex);     
        }
        return -1;
    }
    
    
}
