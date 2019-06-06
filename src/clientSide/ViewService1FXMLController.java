/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientSide;

import java.awt.Color;
import java.awt.image.BufferedImage;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;

/**
 * FXML Controller class
 *
 * @author Gustavo
 */
public class ViewService1FXMLController implements Initializable {

 
    @FXML
    private ImageView imageView1;

    @FXML
    private ImageView imageView2;

    @FXML
    private Button btnOpen;

    @FXML
    private Button btnNegative;

    private File file;
    private int[][] matriz;
    
    
    @FXML
    void btnClickNegative(ActionEvent event){
        try {
            Client client = new Client(9000);
            int[][] matrizNegativo = client.enviarMensagemService1(matriz,"negativo");
            imageView2.setImage(convertMatrizToPNG(matrizNegativo));
        } catch (ClassNotFoundException | IOException ex) {
            Logger.getLogger(ViewClientFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    @FXML
    void btnClickOpen(ActionEvent event) throws IOException {
        
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
  
        fileChooser.setTitle("Abrir Arquivo");
    
        file =  fileChooser.showOpenDialog(stage);
        System.out.println(file.toURI().toString());
        
        this.matriz = ConvertImageMatriz.lerArq(file);
        
        imageView1.setImage(convertMatrizToPNG(this.matriz));
        
    }
    
    public Image convertMatrizToPNG(int[][] matriz) throws IOException{
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

   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    
}
