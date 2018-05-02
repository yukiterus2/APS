/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class conexaobd {
    
    private static final String url_mysql = "jdbc:mysql://localhost/login";
    private static final String driver_mysql = "com.mysql.jdbc.Driver";
    private static final String user_mysql = "root";
    private static final String senha_mysql = "123";  
    
    //criando metodo de conexão
    
    public static Connection getConnection(){
        System.out.println("Contado ao banco de dado.");
        try {
            Class.forName(driver_mysql);
            return DriverManager.getConnection(url_mysql ,user_mysql ,senha_mysql);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }catch(SQLException ex){
            throw new RuntimeException(ex);
        }
        return null;
        
    }
    
    public static void close(Connection conn, PreparedStatement pstm, ResultSet rs){
        System.out.println("Desconectando da base de dados");
        try {
            if (conn != null){
                conn.close();
            }
            
            if (pstm !=null) {
                pstm.close();                
            }
            
            if (rs != null){
                rs.close();
            }
            
        } catch (SQLException e) {
        e.printStackTrace();
        }

    }
    public static void main(String args []){
        
        getConnection();
        //close(conn, pstm, conn);
    }
}
