/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 *
 * @author vitoria
 */
public class TratamentoClass implements Runnable {
 
    private Socket cliente;

    public TratamentoClass(Socket cliente) {
        this.cliente = cliente;
    }
    
    @Override
    public void run() {
        Gerenciamento g = new Gerenciamento();
        try {
            InputStream is = cliente.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String dados = br.readLine();
            String returnMessage = "";
            
            if(dados.split(">")[0].equals("LOGIN")) {
                System.out.println("Buscando pelo login!");
                returnMessage = g.FazerLogin(dados.split(">")[1]);
                System.out.println("Passou daqui");
                OutputStream os = cliente.getOutputStream();
                OutputStreamWriter osw = new OutputStreamWriter(os);
                BufferedWriter bw = new BufferedWriter(osw);
                bw.write(returnMessage);
                System.out.println(returnMessage);
                bw.flush();
                
            } else if(dados.split(">")[0].equals("CadUser")) {
                g.CadastrarUsuario(dados.split(">")[1]);
                System.out.println("Cadastrando um novo usuário...");
            
            } else if(dados.split(">")[0].equals("VerificarConta")) {
                returnMessage = g.VerificarConta(dados.split(">")[1]);
                OutputStream os = cliente.getOutputStream();
                OutputStreamWriter osw = new OutputStreamWriter(os);
                BufferedWriter bw = new BufferedWriter(osw);
                bw.write(returnMessage);
                System.out.println("Conta verificada!");
                bw.flush();
            
            } else if(dados.split(">")[0].equals("CadEvento")) {
                g.CadastrarEvento(dados.split(">")[1]);
                System.out.println("Cadastrando um novo evento...");
            
            } else if(dados.split(">")[0].equals("CadMinicurso")) {
                g.CadastrarMinicurso(dados.split(">")[1]);
                System.out.println("Cadastrando um novo minicurso...");
            
            } else if(dados.equals("BuscarEventos")) {
                returnMessage = g.BuscarEventos();
                System.out.println("Buscando os eventos disponíveis...");
                OutputStream os = cliente.getOutputStream();
                OutputStreamWriter osw = new OutputStreamWriter(os);
                BufferedWriter bw = new BufferedWriter(osw);
                bw.write(returnMessage);
                System.out.println(returnMessage);
                bw.flush();
            
            } else if(dados.split(">")[0].equals("BuscarInscritos")) {
                returnMessage = g.BuscarInscritos(dados.split(">")[1]);
                System.out.println("Buscando inscritos do evento " + dados.split(">")[1] + "...");
                OutputStream os = cliente.getOutputStream();
                OutputStreamWriter osw = new OutputStreamWriter(os);
                BufferedWriter bw = new BufferedWriter(osw);
                bw.write(returnMessage);
                System.out.println(returnMessage);
                bw.flush();
                
            } else if(dados.split(">")[0].equals("ExcluirEvento")) {
                returnMessage = g.ExcluirEvento(dados.split(">")[1]);
                System.out.println("Excluindo evento " + dados.split(">")[1] + "...");
                OutputStream os = cliente.getOutputStream();
                OutputStreamWriter osw = new OutputStreamWriter(os);
                BufferedWriter bw = new BufferedWriter(osw);
                bw.write(returnMessage);
                System.out.println(returnMessage);
                bw.flush();
                
            } else if(dados.split(">")[0].equals("EditarEvento")) {
                returnMessage = g.EditarEvento(dados.split(">")[1]);
                System.out.println("Editando evento " + dados.split(">")[1] + "...");
                OutputStream os = cliente.getOutputStream();
                OutputStreamWriter osw = new OutputStreamWriter(os);
                BufferedWriter bw = new BufferedWriter(osw);
                bw.write(returnMessage);
                System.out.println(returnMessage);
                bw.flush();
                
            } else if(dados.split(">")[0].equals("BuscarUmEvento")) {
                returnMessage = g.BuscarUmEvento(dados.split(">")[1]);
                System.out.println("Buscando evento " + dados.split(">")[1] + "...");
                OutputStream os = cliente.getOutputStream();
                OutputStreamWriter osw = new OutputStreamWriter(os);
                BufferedWriter bw = new BufferedWriter(osw);
                bw.write(returnMessage);
                System.out.println(returnMessage);
                bw.flush();
            
            } else if(dados.split(">")[0].equals("BuscarDadosEventoUsuario")) {
                returnMessage = g.BuscarDadosEventoUsuario(dados.split(">")[1]);
                System.out.println("Buscando dados para inscrição no evento " + dados.split(">")[1] + "...");
                OutputStream os = cliente.getOutputStream();
                OutputStreamWriter osw = new OutputStreamWriter(os);
                BufferedWriter bw = new BufferedWriter(osw);
                bw.write(returnMessage);
                System.out.println("ReturnMessage:: " + returnMessage);
                bw.flush();
            
            } else if(dados.split(">")[0].equals("BuscarMinicursoDeEvento")) {
                returnMessage = g.BuscarMinicursoDeEvento(dados.split(">")[1]);
                System.out.println("Buscando minicursos do evento " + dados.split(">")[1] + "...");
                OutputStream os = cliente.getOutputStream();
                OutputStreamWriter osw = new OutputStreamWriter(os);
                BufferedWriter bw = new BufferedWriter(osw);
                bw.write(returnMessage);
                System.out.println("ReturnMessage:: " + returnMessage);
                bw.flush();
            
            } else if(dados.split(">")[0].equals("AdicionarMinicurso")) {
                returnMessage = g.adicionarMinicurso(dados.split(">")[1]);
                System.out.println("Adicionando minicurso... " + dados.split(">")[1]);
                OutputStream os = cliente.getOutputStream();
                OutputStreamWriter osw = new OutputStreamWriter(os);
                BufferedWriter bw = new BufferedWriter(osw);
                bw.write(returnMessage);
                System.out.println("ReturnMessage:: " + returnMessage);
                bw.flush();
            
            } else if(dados.split(">")[0].equals("AdicionarInscricao")) {
                System.out.println(dados.split(">")[1]);
                g.AdicionarInscricao(dados.split(">")[1]);
                System.out.println("Cadastrando uma inscricao...");
            
            } else if(dados.split(">")[0].equals("BuscarMinhasInscricoes")) {
                returnMessage = g.BuscarMinhasInscricoes(dados.split(">")[1]);
                System.out.println("Buscando minhas inscrições...");
                OutputStream os = cliente.getOutputStream();
                OutputStreamWriter osw = new OutputStreamWriter(os);
                BufferedWriter bw = new BufferedWriter(osw);
                bw.write(returnMessage);
                System.out.println("ReturnMessage:: " + returnMessage);
                bw.flush();
            
            } else if(dados.split(">")[0].equals("BuscarDadosMinhaInscricao")) {
                returnMessage = g.BuscarDadosMinhaInscricao(dados.split(">")[1]);
                System.out.println("Buscando minhas inscrições...");
                OutputStream os = cliente.getOutputStream();
                OutputStreamWriter osw = new OutputStreamWriter(os);
                BufferedWriter bw = new BufferedWriter(osw);
                bw.write(returnMessage);
                System.out.println("ReturnMessage:: " + returnMessage);
                bw.flush();
            
            } else if(dados.split(">")[0].equals("BuscarDescMinicursos")) {
                returnMessage = g.BuscarDescMinicursos(dados.split(">")[1]);
                System.out.println("Buscando minicursos...");
                OutputStream os = cliente.getOutputStream();
                OutputStreamWriter osw = new OutputStreamWriter(os);
                BufferedWriter bw = new BufferedWriter(osw);
                bw.write(returnMessage);
                System.out.println("ReturnMessage:: " + returnMessage);
                bw.flush();
            
            } else if(dados.split(">")[0].equals("BuscarMeuPerfil")) {
                returnMessage = g.BuscarMeuPerfil(dados.split(">")[1]);
                System.out.println("Buscando meu perfil...");
                OutputStream os = cliente.getOutputStream();
                OutputStreamWriter osw = new OutputStreamWriter(os);
                BufferedWriter bw = new BufferedWriter(osw);
                bw.write(returnMessage);
                System.out.println("ReturnMessage:: " + returnMessage);
                bw.flush();
            
            } else if(dados.split(">")[0].equals("ExcluirUsuario")) {
                returnMessage = g.ExcluirUsuario(dados.split(">")[1]);
                System.out.println("Excluindo conta do cpf " + dados.split(">")[1] + "...");
                OutputStream os = cliente.getOutputStream();
                OutputStreamWriter osw = new OutputStreamWriter(os);
                BufferedWriter bw = new BufferedWriter(osw);
                bw.write(returnMessage);
                System.out.println(returnMessage);
                bw.flush();
                
            } else if(dados.split(">")[0].equals("EditarPerfil")) {
                returnMessage = g.EditarPerfil(dados.split(">")[1]);
                //dados[1]: cpf,nome,email,dataNasc,endereco
                System.out.println("Editando perfil...");
                OutputStream os = cliente.getOutputStream();
                OutputStreamWriter osw = new OutputStreamWriter(os);
                BufferedWriter bw = new BufferedWriter(osw);
                bw.write(returnMessage);
                bw.flush();
   
            } else if(dados.split(">")[0].equals("VerificarSeJaSeInscreveu")) {
                returnMessage = g.VerificarSeJaSeInscreveu(dados.split(">")[1]);
                //dados[1]: codEvento,email
                System.out.println("Verificando se já se inscreveu no evento...");
                OutputStream os = cliente.getOutputStream();
                OutputStreamWriter osw = new OutputStreamWriter(os);
                BufferedWriter bw = new BufferedWriter(osw);
                System.out.println("ReturnMessage:: " + returnMessage);
                bw.write(returnMessage);
                bw.flush();
                
            }
            cliente.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
