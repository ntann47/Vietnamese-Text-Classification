/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ql_chxemay;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ngo Truong An
 */
public class ConnectionSQLServer {
    Connection con;
    String ConnectionURL;

    public Connection getCon() {
        return con;
    }
    
    public ConnectionSQLServer(String SqlInstanceName,String DatabaseName,String Username,String Password)
    {
        try {
            String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectionSQLServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.con=null;
        this.ConnectionURL="jdbc:sqlserver://"+SqlInstanceName+":1433;databaseName="+DatabaseName+";user="+Username+";password="+Password;
        
    }
    public ConnectionSQLServer()
    {
        try {
            String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectionSQLServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        /*---------------------------------------------------------*/
        /*----------------------------------------------------------*/
        this.ConnectionURL="jdbc:sqlserver://DESKTOP-V8JV470\\SQLEXPRESS:1433;databaseName=db_QLCHXEMAY;user=sa;password=123";
         try {
             this.con=DriverManager.getConnection(ConnectionURL);
         } catch (SQLException ex) {
             Logger.getLogger(ConnectionSQLServer.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    public Connection OpenConnection()
    {
        try {
            if(con!=null&&con.isClosed()==false)
            {
                return con;
            }
            con=DriverManager.getConnection(ConnectionURL);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionSQLServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
    public void CloseConnection()
    {
        if(con!=null)
            try {
                con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionSQLServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
public static void main(String[] args) {
         
        ConnectionSQLServer c=new ConnectionSQLServer(/*"ADMIN\\SQLEXPRESS","db_QLCHXEMAY","sa","123"*/);
        System.out.println(c.OpenConnection());
    }
    
}
