/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auliayf.app.lks;

import auliayf.app.lks.core.DB;
import auliayf.app.lks.core.DB_Query;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author RPL-03 student
 */
public class Main {

    public static void main(String[] args) {
        try {
            Connection conn = DB.getInstance();
            Statement state = conn.createStatement();
            ResultSet rs = state.executeQuery(new DB_Query("x").toString());
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }
    }
}
