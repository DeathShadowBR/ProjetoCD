/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverSide;


import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author Gustavo
 */
public class ViewServerFXMLController implements Initializable {

     public static ViewServerFXMLController instancia;
       
    @FXML
    private Button btn;
    @FXML
    private Label label;
    
    
    @FXML
    private TextArea textArea;

    
    @FXML
    void onClick(ActionEvent event){
        Server server = new Server();
        Thread th = new Thread(){
            @Override
            public void run(){
                server.createSocket(9000);
            }
        };
        th.setDaemon(true);
        th.start();
        
    }
    
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
