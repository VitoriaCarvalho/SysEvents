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
            
            }
            
            /*if (dados.charAt(0) == 'C') {
                hello.Cadastrar(dados);
                System.out.println("Cadastrando");
            } else if (dados.charAt(0) == 'V') {
                System.out.println(dados);
                hello.Venda(dados);
                System.out.println("Registrando a venda");
            } else if (dados.charAt(0) == 'B') {
                System.out.println("Estou buscando!");
                returnMessage = hello.Busca(dados);
                OutputStream os = cliente.getOutputStream();
                OutputStreamWriter osw = new OutputStreamWriter(os);
                BufferedWriter bw = new BufferedWriter(osw);
                bw.write(returnMessage);
                System.out.println(returnMessage);
                bw.flush();
            } else if (dados.charAt(0) == 'R') {
                returnMessage = hello.Remover(dados);
                OutputStream os = cliente.getOutputStream();
                OutputStreamWriter osw = new OutputStreamWriter(os);
                BufferedWriter bw = new BufferedWriter(osw);
                bw.write(returnMessage);
                bw.flush();
            } else if (dados.charAt(0) == 'D') {
                String[] dado = dados.split("/")[1].split(":");
                System.out.println("Diminuindo do cod " + dado[0]);
                hello.diminuirNoEstoque(dado[0], Integer.parseInt(dado[1]));
                System.out.println("Diminuido do cod " + dado[0]);
            }*/
            cliente.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
