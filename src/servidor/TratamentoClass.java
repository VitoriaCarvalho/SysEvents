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
                
            }
            cliente.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
