/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverSide;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.MalformedURLException;
import java.net.Socket;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import rmiSide.ServiceImage;


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
             String messageService = (String) input.readObject();  
             switch(messageService) {
                 case "ServiceImage":
                    serviceImage(); 
                 break;
             } 
             
           }
           
            
       } catch (IOException | ClassNotFoundException ex) {
           Logger.getLogger(ClientServer.class.getName()).log(Level.SEVERE, null, ex);
       }
         
   }
   
   public void serviceImage(){
       
       try {
           Integer[][] matriz = (Integer[][]) input.readObject();
           System.out.println("[SERVER]: Imagem Recebida");  
           String message = "[SERVER]: Imagem Recebida";
           output.writeObject(message);
           output.flush();
           
           ServiceImage serviceImage = (ServiceImage) Naming.lookup("rmi://localhost:1099/ServiceImage");
           System.out.println("[SERVER]: Requisitando o serviço da Imagem");  
           Integer[][] matrizNegativo = serviceImage.negativo(matriz);
           
           System.out.println("[SERVER]: Imagem Negativa Criada");  
           
           output.writeObject(matrizNegativo);
           output.flush();
           
       } catch (IOException | ClassNotFoundException | NotBoundException ex ) {
           Logger.getLogger(ClientServer.class.getName()).log(Level.SEVERE, null, ex);
       }
       
   }
}
