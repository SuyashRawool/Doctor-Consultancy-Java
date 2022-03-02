package Project;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoadDB {
    private String url;
    private Connection conn=null;
    private Statement st;
    public LoadDB() {
        url="jdbc:postgresql://localhost/Consultancy";
        try {
            conn = DriverManager.getConnection(url,"postgres","Suyash23#");
            st = conn.createStatement();
            int m = st.executeUpdate("set search_path to \"consultancyS\"");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public ResultSet getData(String sql){
        ResultSet data=null;
        try {
            data = st.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(LoadDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return data;
    }
    
    public int update(String sql){
        try {
            return st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(LoadDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return -1;
    }
    
    public int getCounter() {
        ResultSet rs = this.getData("select pid from patient");
        int t, lastC = 0;
        try {
            while(rs.next()){
                t=rs.getInt("pid");
                if(t > lastC)
                    lastC = t;
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoadDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ++lastC;
    }
}
