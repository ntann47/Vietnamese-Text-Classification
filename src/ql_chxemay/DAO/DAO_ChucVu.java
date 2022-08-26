/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ql_chxemay.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import ql_chxemay.ConnectionSQLServer;

/**
 *
 * @author Administrator
 */
public class DAO_ChucVu {
    ConnectionSQLServer c;

    public DAO_ChucVu() {
        c=new ConnectionSQLServer();
    }
    public void loadData(Vector vdata)
    {
        try {
            vdata.removeAllElements();
            String sqlStm="SELECT*FROM CHUCVU";
            c.OpenConnection();
            Statement stm=c.getCon().createStatement();
            ResultSet rs=stm.executeQuery(sqlStm);
            while(rs.next())
            {
                Vector<String> v=new Vector<String>();
                
      
             
                String macv=rs.getString("MACHUCVU");
                String tencv=rs.getString("TENCHUCVU");
                String nhomquyen=rs.getString("NHOMQUYEN");
   
                v.add(macv.trim());
                v.add(tencv.trim());
                v.add(nhomquyen.trim());
                vdata.add(v);
            }
            c.CloseConnection();
        } catch (SQLException ex) {
            Logger.getLogger(DAO_ChucVu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
}
