/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverSide;


import common.Service;
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



/**
 *
 * @author Gustavo
 */
public class ClientServer extends Thread {
   Socket socket;
   private ObjectInputStream input;
   private ObjectOutputStream output ;
   private Service service;
   
   public ClientServer(Socket socket){
       this.socket = socket;
       try {
         service= (Service) Naming.lookup("rmi://localhost:1099/Service");
       } catch (NotBoundException | MalformedURLException | RemoteException ex) {
           Logger.getLogger(ClientServer.class.getName()).log(Level.SEVERE, null, ex);
       }
   }   
   
   @Override
   public void run(){
       try {
          
           output = new ObjectOutputStream(socket.getOutputStream());
           input = new ObjectInputStream(socket.getInputStream());

           
             System.out.println("[SERVER]: Esperando Mensagem do Cliente");
             setConsole("Esperando Mensagem do Cliente");
             String messageService = (String) input.readObject();  
             switch(messageService) {
                 case "ServiceImage":
                    serviceImage();
                    setConsole("Serviço Imagem Negativa Requisitada" +  socket.getPort());
                    socket.close();
                 break;
                 case "ServicePerfectNumber":
                     setConsole("Serviço Número Perfeito Requisitado");
                     servicePerfectNumber();
                     socket.close();         
                 break;
                     
             } 
       } catch (IOException | ClassNotFoundException ex) {
           Logger.getLogger(ClientServer.class.getName()).log(Level.SEVERE, null, ex);
       }
         
   }
   
   public void serviceImage(){
       
       try {
            setConsole("Esperando Imagem");
           int[][] matriz = (int[][]) input.readObject();
           System.out.println("[SERVER]: Imagem Recebida"); 
           setConsole("Imagem Recebida");
           String message = "[SERVER]: Imagem Recebida";
           
           output.writeObject(message);
           setConsole("Confirmação do Recebimento da Imagem Enviado");
           output.flush();
           
           
           ServiceImage image = new ServiceImage(matriz);
           System.out.println("[SERVER]: Requisitando o serviço da Imagem"); 
           setConsole("Requisitando o serviço da Imagem para o RMISERVER");
           Object matrizNegativo = service.executeTask(image);
           
         
           
           System.out.println("[SERVER]: Imagem Negativa Criada");  
           setConsole("Imagem Negativa Criada");
           output.writeObject((int[][]) matrizNegativo);
           output.flush();

       } catch (IOException | ClassNotFoundException ex ) {
           Logger.getLogger(ClientServer.class.getName()).log(Level.SEVERE, null, ex);
       }
       
   }

    private void servicePerfectNumber(){
        
       try {
           setConsole("Esperando a Posição do Número Perfeito");
            int pos = (int) input.readObject();
            System.out.println("[SERVER]: Posição Recebida");
            setConsole("Posição Recebida");
            String message = "[SERVER]: Requisição Recebida";
            output.writeObject(message);
            setConsole("Confirmação do Recebimento Enviada");
            output.flush();


            ServicePerfectNumber pNumber = new ServicePerfectNumber(pos);
            System.out.println("[SERVER]: Requisitando o serviço do Numero Perfeito");  
            setConsole("Requisitando o serviço do Numero Perfeito para o RMISERVER");
            Object result = service.executeTask(pNumber);


            System.out.println("[SERVER]: Numero Perfeito Encontrado");  
            setConsole("Numero Perfeito Encontrado");
            output.writeObject((String) result);
            output.flush();
            
       } catch (IOException | ClassNotFoundException ex) {
           Logger.getLogger(ClientServer.class.getName()).log(Level.SEVERE, null, ex);
       }
        
       
    }
    
     private void setConsole(String message){
        ViewServerFXMLController.instancia.setConsole("[SERVER]: [CLIENTE: " + socket.getPort() + "]  " + message + "\n");
    }
}
