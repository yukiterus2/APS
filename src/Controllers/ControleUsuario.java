/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Database.database;
import Models.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author TheLoli
 */
public class ControleUsuario extends Usuario{
    
    database db;
    Connection con;
    PreparedStatement pst;
    
    public ControleUsuario(){
        super();
        db = new database();
        con = db.getConnection();
    }
    
    public int cadastro(Usuario u){
      int res = 0;
      String sql= "";
      
      try{
          sql = "INSERT INTO Usuario ('id','nome','email','senha') VALUES(NULL,?,?,?)";
          pst = con.prepareStatement(sql);
          
          pst.setString(1, u.getNome());
          pst.setString(2, u.getEmail());
          pst.setString(3, u.getSenha());
          
          res = pst.executeUpdate();
          
      } catch(SQLException e){
          System.out.println(e.getMessage());
      }
      
      return res;
    }
    
    public boolean checarLogin(Usuario u){
        
       String sql = "" ;
       ResultSet rs = null;
       
       try{
           sql = "SELECT *FROM Usuario WHERE email = ? and senha =?"; 
           pst = con.prepareStatement(sql);
           
           pst.setString(1, u.getEmail());
           pst.setString(2, u.getSenha());
           
           rs = pst.executeQuery();
           
           if (rs.next()){
               return true;
           }else{
               return false;
           }
           
       }catch (SQLException e){
           System.out.println(e.getMessage());
       }
        
       
        
       return false;
    }
}
