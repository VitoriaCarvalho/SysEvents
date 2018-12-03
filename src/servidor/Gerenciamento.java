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
    
}
