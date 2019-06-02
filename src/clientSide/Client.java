/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientSide;



import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;



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
            System.out.println("[CLIENT]: Estabelecendo Conexão");
   
        } catch (IOException ex) {
            System.out.println("[CLIENT]: Erro Criação Socket do Cliente");
        }
      
    }
    
    public int[][] enviarMensagemService1(int[][] matriz,String tipo) throws IOException, ClassNotFoundException{
        
        String message = "ServiceImage";
        output.writeObject(message);
        
        System.out.println("[CLIENT]: Enviando Imagem");
        output.writeObject(matriz);
        
        message = (String) input.readObject();
        System.out.println(message);
        
        int[][] matrizResult = null;
        
        switch(tipo){
            case "negativo":
                 matrizResult = (int[][]) input.readObject();
            break;
        }
       
        return matrizResult;
    }
  
}
