/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverSide;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Gustavo
 */
public class Server {
    
    private ServerSocket serverSocket;
    private Socket connectionSocket;

    public String createSocket(int port){
        String message = "";
        try {
            
            serverSocket = new ServerSocket(port);
            while(true){
                System.out.println("[SERVER]: Esperando Conexão");
                connectionSocket = serverSocket.accept();
                System.out.println("[SERVER]: Conexão aceita");
                Thread clientServer = new ClientServer(connectionSocket);
                System.out.println("[SERVER]: Thread Cliente criada");
                clientServer.start();
            }

        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        return(message);
    }
}
