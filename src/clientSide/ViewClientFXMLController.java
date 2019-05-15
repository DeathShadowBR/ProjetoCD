/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientSide;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


/**
 * FXML Controller class
 *
 * @author Gustavo
 */
public class ViewClientFXMLController implements Initializable {

    @FXML
    private Button btn;
    @FXML
    private Label label;
    
    @FXML
    void onClicked(ActionEvent event){
        String message;
        Client client = new Client();
        message = client.createSocket(9000);
        label.setText(message);
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
