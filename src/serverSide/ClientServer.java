/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverSide;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gustavo
 */
public class ClientServer extends Thread {
   Socket socket;
   private DataInputStream input;
   private DataOutputStream output ;
   
   public ClientServer(Socket socket,DataInputStream in, DataOutputStream out){
       this.socket = socket;
       this.input = in;
       this.output = out;
   }   
   
   @Override
   public void run(){
       try {
           while(true){
               String message = input.readUTF();
           System.out.println(message);  
           output.writeUTF(message);
          System.out.println("opa");
           }
           
            
       } catch (IOException ex) {
           Logger.getLogger(ClientServer.class.getName()).log(Level.SEVERE, null, ex);
       }
         
   }
}
