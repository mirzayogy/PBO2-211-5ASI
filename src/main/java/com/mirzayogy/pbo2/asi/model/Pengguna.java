package com.mirzayogy.pbo2.asi.model;

import com.mirzayogy.pbo2.asi.db.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Pengguna {
    private int id;
    private String username;
    private String password;
    private String namaLengkap;
    private boolean isAdmin;
    
    private Database database;
    private Connection connection;
    
    public boolean login(){
        String loginSQL = "SELECT * FROM `pengguna` WHERE username = ? AND password = MD5(?)";
        
        this.database = new Database();
        this.connection = database.getConnection();
        
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(loginSQL);
            preparedStatement.setString(1, this.username);
            preparedStatement.setString(2, this.password);
            ResultSet resultSet =  preparedStatement.executeQuery();
            
            while(resultSet.next()){
                this.setId(resultSet.getInt("id"));
                this.setUsername(resultSet.getString("username"));
                this.setNamaLengkap(resultSet.getString("namalengkap"));
                this.setIsAdmin(resultSet.getBoolean("isadmin"));
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Pengguna.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        return false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNamaLengkap() {
        return namaLengkap;
    }

    public void setNamaLengkap(String namaLengkap) {
        this.namaLengkap = namaLengkap;
    }

    public boolean isIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public Database getDatabase() {
        return database;
    }

    public void setDatabase(Database database) {
        this.database = database;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
    
    
}
