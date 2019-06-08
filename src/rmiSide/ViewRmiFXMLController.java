/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiSide;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.WindowEvent;

/**
 * FXML Controller class
 *
 * @author Gustavo
 */
public class ViewRmiFXMLController implements Initializable {

    
     public static ViewRmiFXMLController instancia;
    
     @FXML
    private Button btn;

    @FXML
    void onClick(ActionEvent event) {
        RmiServer rs = new RmiServer();
    }
    
    
    @FXML
    private TextArea textArea;

   
    
    public void setConsole(String message){
        Date dNow = new Date( );
        SimpleDateFormat ft = new SimpleDateFormat ("hh:mm:ss:SS");
        Platform.runLater(new Runnable() {
            @Override public void run() {
                textArea.appendText( ft.format(dNow) + "->" + message);
            }
        });
        
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        instancia = this;
        textArea.setEditable(false);
    }    
    
}
