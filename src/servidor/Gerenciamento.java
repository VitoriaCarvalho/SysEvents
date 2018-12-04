/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author vitoria
 */
public class Gerenciamento {
    
    public String text;

    public Gerenciamento() {
        super();
    }
    
    public String FazerLogin(String texto) throws IOException, SQLException {
        //texto = "email,senha\n"
        System.out.println(texto);
        UsuariosDAO ud = new UsuariosDAO();
        System.out.println(texto);
        String result = ud.fazerLogin(texto);
        if(result != null) {
            return result + "\n";
        } else {
            return "@\n";
        }
    }
    
    public String VerificarConta(String email) throws IOException, SQLException {
        UsuariosDAO ud = new UsuariosDAO();
        String result = ud.verificarSeEmailJaExiste(email);
        if(result != null) {
            return result + "\n";
        } else {
            return "@\n";
        }
    }
    
    public void CadastrarUsuario(String texto) throws IOException, SQLException {
        //texto = Vitória,05173598395,29/11/1998,vitoriiacb@gmail.com,123,Campo Grande
        UsuariosDAO usuariosDAO = new UsuariosDAO();
        usuariosDAO.adicionarUsuario(texto);
    }
    
    public void CadastrarEvento(String texto) throws IOException, SQLException {
        //texto = Vitória,05173598395,29/11/1998,vitoriiacb@gmail.com,123,Campo Grande
        EventosDAO eventosDAO = new EventosDAO();
        eventosDAO.adicionarEvento(texto);
    }
    
    public void CadastrarMinicurso(String texto) throws IOException, SQLException {
        //texto = Vitória,05173598395,29/11/1998,vitoriiacb@gmail.com,123,Campo Grande
        MinicursosDAO minicursoDAO = new MinicursosDAO();
        minicursoDAO.adicionarMinicurso(texto);
    }
    
    public String BuscarEventos() throws IOException, SQLException {
        EventosDAO ed = new EventosDAO();
        String result = ed.buscarEventos();
        System.out.println(result);
        if(result != null) {
            return result + "\n";
        } else {
            return "@\n";
        }
    }
    
    public String BuscarInscritos(String codEvento) throws IOException, SQLException {
        InscricoesDAO id = new InscricoesDAO();
        String result = id.buscarInscritos(codEvento);
        System.out.println("Chegou no gerenciamento: " + result);
        if(result != null) {
            return result + "\n";
        } else {
            return "@\n";
        }
    }
    
    public String ExcluirEvento(String codEvento) throws IOException, SQLException {
        EventosDAO ed = new EventosDAO();
        String result = ed.excluirEvento(codEvento);
        if(result != null) {
            return result + "\n";
        } else {
            return "@\n";
        }
    }
    
    public String EditarEvento(String dados) throws IOException, SQLException {
        EventosDAO ed = new EventosDAO();
        String result = ed.editarEvento(dados);
        if(result != null) {
            return result + "\n";
        } else {
            return "@\n";
        }
    }
    
    public String BuscarUmEvento(String codEvento) throws IOException, SQLException {
        EventosDAO ed = new EventosDAO();
        String result = ed.buscarUmEvento(codEvento);
        if(result != null) {
            return result + "\n";
        } else {
            return "@\n";
        }
    }
    
    public String BuscarDadosEventoUsuario(String dados) throws IOException, SQLException {
        EventosDAO ed = new EventosDAO();
        String result = ed.buscarDadosEventoUsuario(dados);
        if(result != null) {
            return result + "\n";
        } else {
            return "@\n";
        }
    }
    
    public String BuscarMinicursoDeEvento(String codEvento) throws IOException, SQLException {
        MinicursosDAO md = new MinicursosDAO();
        String result = md.buscarMinicursoDeEvento(codEvento);
        System.out.println("Result gerenciamento:: " + result);
        if(result != null) {
            return result + "\n";
        } else {
            return "@\n";
        }
    }
    
    public String adicionarMinicurso(String dados) throws IOException, SQLException {
        InscricaoMinicParticipDAO mpd = new InscricaoMinicParticipDAO();
        String result = mpd.adicionar(dados);
        if(result != null) {
            return result + "\n";
        } else {
            return "@\n";
        }
    }
    
    public void AdicionarInscricao(String texto) throws IOException, SQLException {
        //texto = codEvento,cpfParticipante
        InscricoesDAO id = new InscricoesDAO();
        id.adicionarInscricao(texto);
    }
    
    public String BuscarMinhasInscricoes(String email) throws IOException, SQLException {
        InscricoesDAO id = new InscricoesDAO();
        String result = id.buscarMinhasInscricoes(email);
        if(result != null) {
            return result + "\n";
        } else {
            return "@\n";
        }
    }
    
    public String BuscarDadosMinhaInscricao(String dados) throws IOException, SQLException {
        //dados: codEvento,email
        InscricoesDAO id = new InscricoesDAO();
        String codEvento = dados.split(",")[0];
        String email = dados.split(",")[1];
        String result = id.dadosMinhaInscricao(codEvento, email);
        if(result != null) {
            return result + "\n";
        } else {
            return "@\n";
        }
    }
    
    public String BuscarDescMinicursos(String dados) throws IOException, SQLException {
    
        //dados: codInscricao,cpfParticipante
        MinicursosDAO md = new MinicursosDAO();
        String codEvento = dados.split(",")[0];
        String cpfParticipante = dados.split(",")[1];
        String result = md.buscarMinicursosEscolhidos(codEvento, cpfParticipante);
        if(result != null) {
            return result + "\n";
        } else {
            return "@\n";
        }
    }
    
    public String BuscarMeuPerfil(String email) throws IOException, SQLException {
        UsuariosDAO ud = new UsuariosDAO();
        String result = ud.buscarMeuPerfil(email);
        if(result != null) {
            return result + "\n";
        } else {
            return "@\n";
        }
    }
    
    public String ExcluirUsuario(String cpf) throws IOException, SQLException {
        UsuariosDAO ud = new UsuariosDAO();
        String result = ud.excluirUsuario(cpf);
        if(result != null) {
            return result + "\n";
        } else {
            return "@\n";
        }
    }
    
    public String EditarPerfil(String dados) throws IOException, SQLException {
        //dados: cpf,nome,email,dataNasc,endereco
        UsuariosDAO ud = new UsuariosDAO();
        String result = ud.editarPerfil(dados);
        if(result != null) {
            return result + "\n";
        } else {
            return "@\n";
        }
    }
    
    public String VerificarSeJaSeInscreveu(String dados) throws IOException, SQLException {
        //dados: codEvento,email
        InscricoesDAO id = new InscricoesDAO();
        String result = id.verificarSeJaSeInscreveu(dados);
        if(result != null) {
            return result + "\n";
        } else {
            return "@\n";
        }
    }
    
}
