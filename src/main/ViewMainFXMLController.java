/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;


import clientSide.ClientView;
import java.net.URL;
import java.util.Observable;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import rmiSide.RmiView;
import serverSide.ServerView;

/**
 * FXML Controller class
 *
 * @author Gustavo
 */
public class ViewMainFXMLController implements Initializable {

    
    
    @FXML
    private Button btnClient;

    @FXML
    private Button btnServer;

    @FXML
    private Button btnRMI;

    
    String[] args;
    

    @FXML
    void onClickClient(ActionEvent event) throws Exception {
        new ClientView().start(new Stage());
    }

    @FXML
    void onClickRMI(ActionEvent event) throws Exception {
        new RmiView().start(new Stage());
    }

    @FXML
    void onClickServer(ActionEvent event) throws Exception {
        new ServerView().start(new Stage());
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
