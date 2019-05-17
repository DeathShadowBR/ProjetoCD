/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverSide;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;


/**
 *
 * @author Gustavo
 */
public class ClientServer extends Thread {
   Socket socket;
   private ObjectInputStream input;
   private ObjectOutputStream output ;
   
   public ClientServer(Socket socket){
       this.socket = socket;
   }   
   
   @Override
   public void run(){
       try {
          
           output = new ObjectOutputStream(socket.getOutputStream());
           input = new ObjectInputStream(socket.getInputStream());

           while(true){
             Integer[][] matriz = (Integer[][]) input.readObject();
             System.out.println("[SERVER]: Imagem Recebida");  
             String message = "[SERVER]: Imagem Recebida";
             output.writeObject(message);
             output.flush();
           }
           
            
       } catch (IOException | ClassNotFoundException ex) {
           Logger.getLogger(ClientServer.class.getName()).log(Level.SEVERE, null, ex);
       }
         
   }
}
