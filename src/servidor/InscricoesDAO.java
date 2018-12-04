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
    
    public String geraCodInscricao() throws SQLException {
        // Prepared statement para seleção
        String sql = "select codInscricao from inscricoes";
        PreparedStatement stmt = connection.prepareStatement(sql);
        
        // Executa a Query
        ResultSet rs = stmt.executeQuery();
        
        Random gerador = new Random();
        int codigo = gerador.nextInt(10000);
        
        while(rs.next()) {
            //criando o obejto contato
            if(rs.getString("codInscricao").equals(codigo+"")) {
                return geraCodInscricao();
            }
        }
        MinicursosDAO.codUltimoEventoInserido = codigo+""; //Para adicionar minicursos referenciando o evento certo.
        return codigo+"";
    }
    
    public void adicionarInscricao(String dados) throws SQLException {
        // Prepared statement para inserção
        //dados: codEvento, cpfParticipante
        String sql = "insert into inscricoes (codInscricao, codEvento, cpfParticipante) values (?,?,?)";
        PreparedStatement stmt = connection.prepareStatement(sql);

        String[] atributos = dados.split(",");

        // Seta os valores
        stmt.setString(1, geraCodInscricao());
        stmt.setString(2, atributos[0]);
        stmt.setString(3, atributos[1]);

        // Executa
        boolean flag = stmt.execute();
        stmt.close();
    }
    
    public String buscarMinhasInscricoes(String email) throws SQLException {
        // Prepared statement para seleção
        //SELECT * FROM table1 INNER JOIN table2 ON table1.id = table2.id;
        String sql = "select codInscricao, titulo, dataEvento, valorInscricao from eventos inner join (select codInscricao, codEvento from inscricoes inner join (select cpf from usuarios where email = ?) as u on u.cpf = inscricoes.cpfParticipante) as i on i.codEvento = eventos.codEvento";
        PreparedStatement stmt = connection.prepareStatement(sql);
        
        stmt.setString(1, email);
        //o retorno deve ser vários codInscricao,tituloEvento,dataEvento,valorInscricao...
        
        // Executa a Query
        ResultSet rs = stmt.executeQuery();
        String result = "";
        
        while(rs.next()) {
            result += (rs.getString("codInscricao")+",");
            result += (rs.getString("titulo")+",");
            result += (rs.getString("dataEvento")+",");
            result += (rs.getString("valorInscricao")+"%");
        }
        
        return result;
    }
    
    public String recuperarInfoEventoInscrito(String codInscricao) throws SQLException {
        
        String sql = "select eventos.codEvento, titulo, dataEvento, descricao from eventos inner join (select codEvento from inscricoes where codInscricao = ?) as i on i.codEvento = eventos.codEvento";
        PreparedStatement stmt = connection.prepareStatement(sql);
        
        stmt.setString(1, codInscricao);
        //o retorno deve ser: codEvento,titulo,dataEvento,descricao
        
        // Executa a Query
        ResultSet rs = stmt.executeQuery();
        String result = "";
        
        while(rs.next()) {
            result += (rs.getString("codEvento")+",");
            result += (rs.getString("titulo")+",");
            result += (rs.getString("dataEvento")+",");
            result += (rs.getString("descricao"));
        }
        
        return result;
    }
    
    public String dadosMinhaInscricao(String codInscricao, String email) throws SQLException {
        
        UsuariosDAO ud = new UsuariosDAO();
        String result = recuperarInfoEventoInscrito(codInscricao) + "," + ud.buscarDadosParaInscricao(email);
        return result;
    }
    
    public String verificarSeJaSeInscreveu(String texto) throws SQLException {
        //texto = codEvento,email
        // Consertar consulta
        String[] dados = texto.split(",");
        
        String sql = "select * from inscricoes inner join (select cpf from usuarios where email = ?) as u on inscricoes.cpfParticipante = u.cpf where codEvento = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);

        stmt.setString(1, dados[1]);
        stmt.setString(2, dados[0]);

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
}
