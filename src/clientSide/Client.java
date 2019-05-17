/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientSide;


import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import javax.imageio.ImageIO;


/**
 *
 * @author Gustavo
 */
public class Client{
    
    private Socket clientSocket;
    private ObjectInputStream input;
    private ObjectOutputStream output;
    
    
    public void createSocket(int port) throws ClassNotFoundException{
     
        try {
            
            clientSocket = new Socket("localhost",port); 
            output = new ObjectOutputStream(clientSocket.getOutputStream());
            input = new ObjectInputStream(clientSocket.getInputStream());
            System.out.println("[Client]: Estabelecendo Conexão");
   
        } catch (IOException ex) {
            System.out.println("[Client]: Erro Criação Socket do Cliente");
        }
      
    }
    
    public void enviarMensagem(Integer[][] matriz) throws IOException, ClassNotFoundException{
        
          
        System.out.println("[Client]: Enviando Imagem");
        output.writeObject(matriz);
        
        String message = (String) input.readObject();
        System.out.println(message);
           
    }
  
}
