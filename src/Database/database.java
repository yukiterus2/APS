/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.Connection;
import java.sql.DriverManager;


/**
 *
 * @author TheLoli
 */
public class database {
    
    private Connection con;
    private String url;
    private String usuario;
    private String senha;
    
    public database(){
        url = "jdbc:mysql://localhost:3306/login";
        usuario = "root";
        senha = "";
    }
    
    public Connection getConnection(){
        try{
            Class.forName("com.mysql.jdbc");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        try {
            con = DriverManager.getConnection(url, usuario, senha);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return con;
    }
    
    
}
