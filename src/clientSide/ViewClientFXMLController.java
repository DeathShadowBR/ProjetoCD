/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientSide;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


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
    private Button btnOpen;

    @FXML
    private ImageView imageView;

    private File file;
    private Integer[][] matriz;
    
    @FXML
    void onClicked(ActionEvent event){
        String message="";
        Client client = new Client();
        

        try {
            client.createSocket(9000);
            Integer[][] matrizNegativo = client.enviarMensagem(matriz);
            imageView.setImage(convertMatrizToPNG(matrizNegativo));
        } catch (ClassNotFoundException | IOException ex) {
            Logger.getLogger(ViewClientFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    

        
        label.setText(message);
    }
    
    @FXML
    void onClickedBtnOpen(ActionEvent event) throws IOException {
        
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
  
        fileChooser.setTitle("Abrir Arquivo");
    
        file =  fileChooser.showOpenDialog(stage);
        System.out.println(file.toURI().toString());
        
        this.matriz = ConvertImageMatriz.lerArq(file);
        
        imageView.setImage(convertMatrizToPNG(this.matriz));
    }
    
    public Image convertMatrizToPNG(Integer[][] matriz) throws IOException{
        int largura = matriz[0].length;
        int altura = matriz.length;
        
        BufferedImage image = new BufferedImage(altura, largura, BufferedImage.TYPE_INT_RGB);
        for(int y=0; y<largura; y++){
            for(int x=0; x<altura; x++){
                 int u = matriz[x][y];
                 Color color = new Color(u,u,u);
                 image.setRGB(x,y,color.getRGB());
            }
        }

          File output = new File("image.png");
          ImageIO.write(image, "png", output);
          Image img = SwingFXUtils.toFXImage(ImageIO.read(output), null);
          
          return img;
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
