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

/**
 *
 * @author vitoria
 */
public class MinicursosDAO {
    
    private Connection connection;
    public static String codUltimoEventoInserido; //para inserir minicursos referenciando este evento

    public MinicursosDAO() throws SQLException {
        this.connection = ConnectionFactory.getConnection();
    }
    
    public String geraCodMinicurso() throws SQLException {
        // Prepared statement para seleção
        String sql = "select codMinicurso from minicursos";
        PreparedStatement stmt = connection.prepareStatement(sql);
        
        // Executa a Query
        ResultSet rs = stmt.executeQuery();
        
        Random gerador = new Random();
        int codigo = gerador.nextInt(10000);
        
        while(rs.next()) {
            //criando o obejto contato
            if(rs.getString("codMinicurso").equals(codigo+"")) {
                return geraCodMinicurso();
            }
        }
        return codigo+"";
    }
    
    public void adicionarMinicurso(String dados) throws SQLException {
        // Prepared statement para inserção
        //Redes Neurais Artificiais,20/12/2018,14:00,25.90,Alguém
        String sql = "insert into minicursos (codMinicurso, codEvento, tituloMinicurso, dataMinicurso, horarioMinicurso, valorMinicurso, ministrante) values (?,?,?,?,?,?,?)";
        PreparedStatement stmt = connection.prepareStatement(sql);
        System.out.println("Preparei a query");

        String[] infoProduto = dados.split(",");
        System.out.println("Chega aqui");

        // Seta os valores
        stmt.setString(1, geraCodMinicurso());
        stmt.setString(2, codUltimoEventoInserido);
        stmt.setString(3, infoProduto[0]);
        stmt.setString(4, infoProduto[1]);
        stmt.setString(5, infoProduto[2]);
        stmt.setString(6, infoProduto[3]);
        stmt.setString(7, infoProduto[4]);

        // Executa
        stmt.execute();
        stmt.close();
        
        //codUltimoEventoInserido = "";
    }
}
