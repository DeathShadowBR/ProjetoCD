/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientSide;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;


/**
 * FXML Controller class
 *
 * @author Gustavo
 */
public class ViewClientFXMLController implements Initializable {

  
    public static ViewClientFXMLController instancia;
    
    
  
    
    @FXML
    private BorderPane borderpane;

    @FXML
    private Button btn1;

    
    @FXML
    private Button btn2;

    @FXML
    private Button btn3;
     
  
    @FXML
    private TextArea textArea;

    @FXML
    private void btnClickService1(ActionEvent event) {
        
        loadUI("ViewService1FXML");
    }
    
    @FXML
    private void btnClickService2(ActionEvent event) {
        loadUI("ViewService2FXML");
    }
    
     @FXML
    private void btnClickService3(ActionEvent event) {
        loadUI("ViewService3FXML");
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
    
    private void loadUI(String ui){
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/screens/"+ui+".fxml"));
        } catch (IOException ex) {
            Logger.getLogger(ViewClientFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        borderpane.setCenter(root);
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
           try {
               
               instancia = this;
               textArea.setEditable(false);
            
           } catch (Exception ex) {
               Logger.getLogger(ViewClientFXMLController.class.getName()).log(Level.SEVERE, null, ex);
           }
    }    

 
}
