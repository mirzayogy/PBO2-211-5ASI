package com.mirzayogy.pbo2.asi.model;

import com.mirzayogy.pbo2.asi.db.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JenisBarang {
    private int id;
    private String namajenisbarang;
    
    private Database database;
    private Connection connection;
    
    
    public boolean create(){
        String insertSQL = "INSERT INTO jenisbarang VALUES (NULL, ?)";
        
        this.database = new Database();
        this.connection = this.database.getConnection();
        
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(insertSQL);
            preparedStatement.setString(1, this.namajenisbarang);
            
            preparedStatement.execute();
            
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(JenisBarang.class.getName()).log(Level.SEVERE, null, ex);
        }
       return false; 
    }
    
    public boolean update(){
        String updateSQL = "UPDATE jenisbarang SET namajenisbarang = ? WHERE id = ?";
        
        this.database = new Database();
        this.connection = this.database.getConnection();
        
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(updateSQL);
            preparedStatement.setString(1, this.namajenisbarang);
            preparedStatement.setInt(2, this.id);
            preparedStatement.execute();
            
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(JenisBarang.class.getName()).log(Level.SEVERE, null, ex);
        }
       return false; 
    }
    
    public boolean delete(){
        String deleteSQL = "DELETE FROM jenisbarang WHERE id = ?";
        
        this.database = new Database();
        this.connection = this.database.getConnection();
        
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(deleteSQL);
            preparedStatement.setInt(1, this.id);
            preparedStatement.execute();
            
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(JenisBarang.class.getName()).log(Level.SEVERE, null, ex);
        }
       return false; 
    }
    
    public ArrayList<JenisBarang> read(){
        String selectSQL = "SELECT * FROM jenisbarang";
        
        this.database = new Database();
        this.connection = this.database.getConnection();
        
        ArrayList<JenisBarang> list = new ArrayList<>();
        
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(selectSQL);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                JenisBarang jb = new JenisBarang();
                jb.setId(resultSet.getInt("id"));
                jb.setNamajenisbarang(resultSet.getString("namajenisbarang"));
                
                list.add(jb);
            }
            
            return list;
            
        } catch (SQLException ex) {
            Logger.getLogger(JenisBarang.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return null;
    }
    
    public boolean find(){
        
        String selectSQL = "SELECT * FROM jenisbarang WHERE id = ?";
        
        this.database = new Database();
        this.connection = this.database.getConnection();
        
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(selectSQL);
            preparedStatement.setInt(1, this.id);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                this.setId(resultSet.getInt("id"));
                this.setNamajenisbarang(resultSet.getString("namajenisbarang"));
                return true;

            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(JenisBarang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public ArrayList<JenisBarang> search(String keywords){
        String selectSQL = "SELECT * FROM jenisbarang WHERE namajenisbarang like ?";
        
        keywords = "%" + keywords + "%";
        
        this.database = new Database();
        this.connection = this.database.getConnection();
        
        ArrayList<JenisBarang> list = new ArrayList<>();
        
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(selectSQL);
            preparedStatement.setString(1, keywords);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                JenisBarang jb = new JenisBarang();
                jb.setId(resultSet.getInt("id"));
                jb.setNamajenisbarang(resultSet.getString("namajenisbarang"));
                
                list.add(jb);
            }
            
            return list;
            
        } catch (SQLException ex) {
            Logger.getLogger(JenisBarang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamajenisbarang() {
        return namajenisbarang;
    }

    public void setNamajenisbarang(String namajenisbarang) {
        this.namajenisbarang = namajenisbarang;
    }
    
    
}
