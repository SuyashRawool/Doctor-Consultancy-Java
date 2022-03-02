/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class ConnectionProvider {
    
    public static void main(String[] args) {
        LoadDB db = new LoadDB();
        db.update("insert into patient values(5,'vivek',9876543267,15,'M','B+ve','asdasda','severe cough')");
        
        ResultSet rs = db.getData("SELECT * from patient");
        try {
            while(rs.next()){
                String name = rs.getString("name");
                System.out.println("Name :"+name);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionProvider.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
