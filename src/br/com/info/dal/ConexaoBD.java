/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.info.dal;
import java.sql.*;

public class ConexaoBD {
    
    //Método que estabele conexão com o Banco de Dados
    
    public static Connection conector(){
        java.sql.Connection conexao=null;
        String driver="com.mysql.jdbc.Driver";
        String url="jdbc:mysql://localhost:3306/concessionaria";
        String user="root";
        String password="12345678";
        try{
            Class.forName(driver);
            conexao=DriverManager.getConnection(url,user,password);
            return conexao;
        }catch(Exception e)
        {
        
            System.out.println(e);
            return null;
        }
    }
            
            
}
