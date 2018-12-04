/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author vitoria
 */
public class UsuariosDAO {
    
    // Conexão com DB
    private Connection connection;

    public UsuariosDAO() throws SQLException {
        this.connection = ConnectionFactory.getConnection();
    }
    
    public String fazerLogin (String credenciais) throws SQLException {
        // Prepared statement para seleção
        String sql = "select * from usuarios where email = ? and senha = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        
        String email = credenciais.split(",")[0];
        String senha = credenciais.split(",")[1];
        
        // Seta o valor da busca
        stmt.setString(1, email);
        stmt.setString(2, senha);
        
        // Executa a Query
        ResultSet rs = stmt.executeQuery();
        
        // Extração dos dados resultantes da Query
        boolean first = rs.first();
        
        if (first) {
            // Retorna o resultado da extração de dados da query
            //nome          | cpf         | dataNasc   | email           | senha | endereco
            String result = rs.getString("nome") + "," + rs.getString("cpf") + "," + rs.getString("dataNasc") + "," + rs.getString("email") + "," + rs.getString("senha") + "," + rs.getString("endereco");
            System.out.println(result);
            if(email.equals("admin@gmail.com") && senha.equals("123")) {
                return "admin";
            } else {
                return "user";
            }
        } else {
            return null;
        }
    }
    
    public String verificarSeEmailJaExiste(String email) throws SQLException{
        // Prepared statement para seleção
        String sql = "select * from usuarios where email = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        
        // Seta o valor da busca
        stmt.setString(1, email);
        
        // Executa a Query
        ResultSet rs = stmt.executeQuery();
        
        // Extração dos dados resultantes da Query
        boolean first = rs.first();
        
        if (first) {
            return "true";
        } else {
            return "false";
        }
    }
    
    public void adicionarUsuario(String dados) throws SQLException {
        // Prepared statement para inserção
        //dados = nome,cpf,dataNasc,email,senha,enedereco
        String sql = "insert into usuarios (nome, cpf, dataNasc, email, senha, endereco) values (?,?,?,?,?,?)";
        PreparedStatement stmt = connection.prepareStatement(sql);
        System.out.println("Preparei a query");

        String[] infoProduto = dados.split(",");

        // Seta os valores
        stmt.setString(1, infoProduto[0]);
        stmt.setString(2, infoProduto[1]);
        stmt.setString(3, infoProduto[2]);
        stmt.setString(4, infoProduto[3]);
        stmt.setString(5, infoProduto[4]);
        stmt.setString(6, infoProduto[5]);

        // Executa
        stmt.execute();
        stmt.close();
    }
    
    public String buscarDadosParaInscricao(String email) throws SQLException {
        // Prepared statement para seleção
        String sql = "select * from usuarios where email = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        
        // Seta o valor da busca
        stmt.setString(1, email);
        
        // Executa a Query
        ResultSet rs = stmt.executeQuery();
        
        // Extração dos dados resultantes da Query
        boolean first = rs.first();
        System.out.println("Chegou em UsuariosDAO");
        
        if (first) {
            // Retorna o resultado da extração de dados da query
            //nome,cpf,email,dataNasc
            String result = rs.getString("nome") + "," + rs.getString("cpf") + "," + rs.getString("email") + "," + rs.getString("dataNasc");
            return result;
        } else {
            return null;
        }
    }
}
