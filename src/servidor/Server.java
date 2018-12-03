/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author vitoria
 */
public class Server {
    private static Socket cliente;

    public static void main(String[] args) throws IOException {
        Gerenciamento g = new Gerenciamento();
        try {
            ServerSocket servidor = new ServerSocket(12345);
            System.out.println("Porta 12345 aberta!");
            while (true) {
                cliente = servidor.accept();
                System.out.println("Nova conexão com o cliente " + cliente.getInetAddress().getHostAddress());
                TratamentoClass tratamentoClass = new TratamentoClass(cliente);
                Thread t = new Thread(tratamentoClass);
                t.start();
            }
            
        } catch (Exception e) {
            //TODO: handle exception
        } finally {
            cliente.close();
        }
        
        System.out.println("FEZ A CONEXAO");
    }
}
