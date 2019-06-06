/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientSide;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Gustavo
 */
public class ViewService2FXMLController implements Initializable {

    @FXML
    private TextField textInputValor;

    @FXML
    private Button btnEnviar;

    @FXML
    private Label labelResult;

    @FXML
    void onClickSend(ActionEvent event) throws IOException {
        try {
            Client client = new Client(9000);
            String result = client.enviarMensagemService2(Integer.parseInt(textInputValor.getText()));
            System.out.println(Integer.parseInt(textInputValor.getText()));
            labelResult.setText(result);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ViewService2FXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
 
    }
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
