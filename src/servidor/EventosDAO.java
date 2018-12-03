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
public class EventosDAO {
    
    private Connection connection;

    public EventosDAO() throws SQLException {
        this.connection = ConnectionFactory.getConnection();
    }
    
    public String geraCodEvento() throws SQLException {
        // Prepared statement para seleção
        String sql = "select codEvento from eventos";
        PreparedStatement stmt = connection.prepareStatement(sql);
        
        // Executa a Query
        ResultSet rs = stmt.executeQuery();
        
        Random gerador = new Random();
        int codigo = gerador.nextInt(10000);
        
        while(rs.next()) {
            //criando o obejto contato
            if(rs.getString("codEvento").equals(codigo+"")) {
                return geraCodEvento();
            }
        }
        MinicursosDAO.codUltimoEventoInserido = codigo+""; //Para adicionar minicursos referenciando o evento certo.
        return codigo+"";
    }
    
    public void adicionarEvento(String dados) throws SQLException {
        // Prepared statement para inserção
        String sql = "insert into eventos (codEvento, titulo, dataEvento, valorInscricao, descricao) values (?,?,?,?,?)";
        PreparedStatement stmt = connection.prepareStatement(sql);
        System.out.println("Preparei a query");

        String[] infoProduto = dados.split(",");

        // Seta os valores
        stmt.setString(1, geraCodEvento());
        stmt.setString(2, infoProduto[0]);
        stmt.setString(3, infoProduto[1]);
        stmt.setString(4, infoProduto[2]);
        stmt.setString(5, infoProduto[3]);

        // Executa
        stmt.execute();
        stmt.close();
    }
    
    public String buscarEventos() throws SQLException {
        // Prepared statement para seleção
        String sql = "select * from eventos";
        PreparedStatement stmt = connection.prepareStatement(sql);
        
        // Executa a Query
        ResultSet rs = stmt.executeQuery();
        String result = "";
        
        while(rs.next()) {
            result += (rs.getString("codEvento")+",");
            result += (rs.getString("titulo")+",");
            result += (rs.getString("dataEvento")+",");
            result += (rs.getString("valorInscricao")+",");
            result += (rs.getString("descricao")+"%");
        }
        
        return result;
    }
    
    public String excluirMinicursos(String codEvento) throws SQLException {
        // Prepared statement para a exclusão
        String sql = "delete from minicursos where codEvento = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        
        stmt.setString(1, codEvento);
        
        // Executa a Query
        int executeUpdate = stmt.executeUpdate();
        
        if (executeUpdate == 0) return "false";
        else return "true";
    }
    
    public String excluirEvento(String codEvento) throws SQLException {
        if(excluirMinicursos(codEvento).equals("true")) {
            // Prepared statement para a exclusão
            String sql = "delete from eventos where codEvento = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, codEvento);

            // Executa a Query
            int executeUpdate = stmt.executeUpdate();

            if (executeUpdate == 0) return "false";
            else return "true";
        } else {
            return null;
        }
    }
    
    public String editarEvento(String texto) throws SQLException {
        //texto = codEvento,titulo,dataEvento,valorInscricao,descricao
        String[] dados = texto.split(",");
        System.out.println("TEXTO: " + texto);
        
        // Prepared statement para a exclusão
        //UPDATE `members` SET `full_names` = 'Janet Smith Jones', `physical_address` = 'Melrose 123' WHERE `membership_number` = 2;
        String sql = "update eventos set titulo = ?, dataEvento = ?, valorInscricao = ?, descricao = ? where codEvento = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);

        stmt.setString(1, dados[1]);
        stmt.setString(2, dados[2]);
        stmt.setString(3, dados[3]);
        stmt.setString(4, dados[4]);
        stmt.setString(5, dados[0]);

        // Executa a Query
        int executeUpdate = stmt.executeUpdate();

        if (executeUpdate == 0) return "false";
        else return "true";
    }
}
