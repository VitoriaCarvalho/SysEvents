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
import java.util.Random;
import static servidor.MinicursosDAO.codUltimoEventoInserido;

/**
 *
 * @author vitoria
 */
public class InscricaoMinicParticipDAO {
 
    private Connection connection;
    public static String codUltimoEventoInserido; //para inserir minicursos referenciando este evento

    public InscricaoMinicParticipDAO() throws SQLException {
        this.connection = ConnectionFactory.getConnection();
    }
    
    public String buscarUmMinicurso(String codMinicurso) throws SQLException {
        // Prepared statement para seleção
        String sql = "select * from minicursos where codMinicurso = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        
        stmt.setString(1, codMinicurso);
        
        // Executa a Query
        ResultSet rs = stmt.executeQuery();
        
        // Extração dos dados resultantes da Query
        boolean first = rs.first();
        
        if (first) {
            // Retorna o resultado da extração de dados da query
            return rs.getString("valorMinicurso");
        } else {
            return "erro";
        }
    }
    
    public boolean verificaSeJaExiste(String dados) throws SQLException {
        // Prepared statement para seleção
        String sql = "select * from inscricao_minic_particip where codEvento = ? and codMinicurso = ? and cpfParticipante = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        
        String[] atributos = dados.split(",");
        
        stmt.setString(1, atributos[0]);
        stmt.setString(2, atributos[1]);
        stmt.setString(3, atributos[2]);
        System.out.println("ATRIBUTOS (verifica):: " + atributos[0] + "," + atributos[1] + "," + atributos[2]);
        
        // Executa a Query
        ResultSet rs = stmt.executeQuery();
        
        // Extração dos dados resultantes da Query
        boolean first = rs.first();
        
        if (first) {
            // Retorna o resultado da extração de dados da query
            return true;
        } else {
            return false;
        }
    }
    
    public String adicionar(String dados) throws SQLException {
        String flag = buscarUmMinicurso(dados.split(",")[1]);
        if(!(flag.equals("erro")) && (!(verificaSeJaExiste(dados)))) {
            // Prepared statement para inserção
            // Dados: codEvento,codMinicurso,cpfParticipante;
            String sql = "insert into inscricao_minic_particip (codEvento, codMinicurso, cpfParticipante) values (?,?,?)";
            PreparedStatement stmt = connection.prepareStatement(sql);

            String[] atributos = dados.split(",");
            System.out.println("ATRIBUTOS (adiciona):: " + atributos[0] + "," + atributos[1] + "," + atributos[2]);

            // Seta os valores
            stmt.setString(1, atributos[0]);
            stmt.setString(2, atributos[1]);
            stmt.setString(3, atributos[2]);

            // Executa
            stmt.execute();
            stmt.close();

            return flag;
        } else {
            return "erro";
        }
    }
}
