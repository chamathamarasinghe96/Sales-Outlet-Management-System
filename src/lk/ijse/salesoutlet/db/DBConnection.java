/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.salesoutlet.db;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class DBConnection {

    private static DBConnection dbConnection;
    private Connection conn;

    private DBConnection() {
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            Properties properties = new Properties();
            File dbFile = new File("settings/dbproperty.properties");
            FileReader dbReader = new FileReader(dbFile);
            properties.load(dbReader);

            String ip = properties.getProperty("ip");
            String port = properties.getProperty("port");
            String database = properties.getProperty("database");
            String username = properties.getProperty("username");
            String password = properties.getProperty("password");
            
            String url = "jdbc:mysql://" + ip + ":" + port + "/" + database + "";
            conn = DriverManager.getConnection(url, username, password);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static DBConnection getInstance() {
        if (dbConnection == null) {
            dbConnection = new DBConnection();
        }
        return dbConnection;
    }

    public Connection getConnection() {
        return conn;
    }
}
