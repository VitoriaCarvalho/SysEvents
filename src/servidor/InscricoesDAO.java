/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author vitoria
 */
public class InscricoesDAO {
    
    private Connection connection;

    public InscricoesDAO() throws SQLException {
        this.connection = ConnectionFactory.getConnection();
    }
    
    public String buscarInscritos(String codEvento) throws SQLException {
        // Prepared statement para seleção
        //SELECT * FROM table1 INNER JOIN table2 ON table1.id = table2.id;
        //cpf,nome,endereco, email
        String sql = "select cpf, nome, endereco, email from usuarios inner join inscricoes on usuarios.cpf = inscricoes.cpfParticipante";
        PreparedStatement stmt = connection.prepareStatement(sql);
        
        // Executa a Query
        ResultSet rs = stmt.executeQuery();
        String result = "";
        
        while(rs.next()) {
            result += (rs.getString("cpf")+",");
            result += (rs.getString("nome")+",");
            result += (rs.getString("endereco")+",");
            result += (rs.getString("email")+"%");
        }
        
        return result;
    }
}
