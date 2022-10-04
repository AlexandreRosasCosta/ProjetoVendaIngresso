/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Alexandre
 */
public class ConexaoDb {
    private static String url, pass, user, driver;

    public ConexaoDb(){
        ConexaoDb.url = "jdbc:mysql://localhost:3306/Projeto_Poo";
        ConexaoDb.user = "root";
        ConexaoDb.pass = "Xxbbv3%$";
        ConexaoDb.driver = "com.mysql.jdbc.Driver";
    }
    
    public static Connection conectarBanco() throws ClassNotFoundException, SQLException{
        try {
            Class.forName(driver);
            return (Connection) DriverManager.getConnection(url,user,pass);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("Não foi possível conectar-se com o Banco de Dados: " + e);
        }
    }
    
    public static void desconectarBanco(Connection con) throws SQLException{
        try {
            if(con != null){
                con.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao desconectar com o Banco de Dados: " + e);
        }
    }
    public static void desconectarBanco(Connection con, PreparedStatement stmt) throws SQLException{
        desconectarBanco(con);
        try {
            if(stmt != null){
                stmt.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao desconectar com o Banco de Dados: " + e);
        }
    }
    
    public static void desconectarBanco(Connection con, PreparedStatement stmt, ResultSet res) throws SQLException{
        desconectarBanco(con, stmt);
        try {
            if(res!=null){
                res.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao desconectar com o Banco de Dados: " + e);
        }
    }
    
    public static String getUrl() {
        return url;
    }

    public static String getPass() {
        return pass;
    }

    public static String getUser() {
        return user;
    }

    public static String getDriver() {
        return driver;
    }
}
