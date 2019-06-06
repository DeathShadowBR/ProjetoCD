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
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;


/**
 * FXML Controller class
 *
 * @author Gustavo
 */
public class ViewClientFXMLController implements Initializable {

  
       @FXML
    private BorderPane borderpane;

    @FXML
    private Button btn1;

    
    @FXML
    private Button btn2;

    @FXML
    private Button btn3;
     

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
    
    
    private void loadUI(String ui){
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/screens/"+ui+".fxml"));
        } catch (IOException ex) {
            Logger.getLogger(ViewClientFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        borderpane.setCenter(root);
    }
    private static void printLines(String name, InputStream ins) throws Exception {
        String line = null;
        BufferedReader in = new BufferedReader(
            new InputStreamReader(ins));
        while ((line = in.readLine()) != null) {
            System.out.println(name + " " + line);
        }
    }
    private static void runProcess(String command) throws Exception {
    Process pro = Runtime.getRuntime().exec(command);
    printLines(command + " stdout:", pro.getInputStream());
    printLines(command + " stderr:", pro.getErrorStream());
    pro.waitFor();
    System.out.println(command + " exitValue() " + pro.exitValue());
  }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
           try {
               // TODO
                //runProcess("javac -cp src src/serverSide/ServerView.java");
                //runProcess("java -cp src serverSide/ServerView");
            
           } catch (Exception ex) {
               Logger.getLogger(ViewClientFXMLController.class.getName()).log(Level.SEVERE, null, ex);
           }
    }    

 
}
