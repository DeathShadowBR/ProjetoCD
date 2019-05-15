/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientSide;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;

import java.net.Socket;


/**
 *
 * @author Gustavo
 */
public class Client{
    
    private Socket clientSocket;
    private DataInputStream input;
   private DataOutputStream output ;
    
    
    public String createSocket(int port){
        String message = "";
        try {
            clientSocket = new Socket("localhost",port);
             
             input = new DataInputStream(clientSocket.getInputStream());
             output = new DataOutputStream(clientSocket.getOutputStream());
             
             output.writeUTF("Hello World");
             System.out.println("Mensagem enviada");
             message = input.readUTF();
             System.out.println("Mensagem recebida");
           
        } catch (IOException ex) {
            System.out.println("Erro Criação Socket do Cliente");
        }
        return message;
    }
  
}
