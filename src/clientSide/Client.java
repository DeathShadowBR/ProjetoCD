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
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextArea;



/**
 *
 * @author Gustavo
 */
public class Client{
    
    private Socket clientSocket;
    private ObjectInputStream input;
    private ObjectOutputStream output;
    
    public Client(int porta) throws ClassNotFoundException{
        createSocket(porta);
    }
    
    public void createSocket(int port) throws ClassNotFoundException{
     
        try {
            clientSocket = new Socket("localhost",port); 
            output = new ObjectOutputStream(clientSocket.getOutputStream());
            input = new ObjectInputStream(clientSocket.getInputStream());
            setConsole("Estabelecendo Conexão");
            System.out.println("[CLIENT]: Estabelecendo Conexão");
   
        } catch (IOException ex) {
            setConsole("Erro Criação Socket do Cliente\n");
            System.out.println("[CLIENT]: Erro Criação Socket do Cliente");
        }
      
    }
    
    public int[][] enviarMensagemService1(int[][] matriz) throws IOException, ClassNotFoundException{
        
        String message = "ServiceImage";
        setConsole("Serviço da Imagem Negativo Selecionado");
        output.writeObject(message);
        
        System.out.println("[CLIENT]: Enviando Imagem");
        setConsole("Enviando Imagem");
        
        output.writeObject(matriz);
        
        message = (String) input.readObject();
        System.out.println(message);
        setConsole( "Resposta: "+ message);
        
        int[][] matrizResult = (int[][]) input.readObject();

        clientSocket.close();
        return matrizResult;
    }
    
    public String enviarMensagemService2(int pos) throws IOException, ClassNotFoundException{
        
        String message = "ServicePerfectNumber";
        setConsole("Serviço do Número Perfeito Selecionado");
        output.writeObject(message);
        
        System.out.println("[CLIENT]: Enviando mensagem");
        setConsole("Enviando mensagem");
        output.writeObject(pos);
        
        message = (String) input.readObject();
        setConsole("Resposta " + message);
        System.out.println(message);
        
        String result = (String) input.readObject();
        System.out.println(result);
        setConsole("Resultado Recebido");
        clientSocket.close();
        
        
        return result;
    }
  
    private void setConsole(String message){
        ViewClientFXMLController.instancia.setConsole("[CLIENT: " + clientSocket.getLocalPort() + "]:  " + message + "\n");
    }
}
