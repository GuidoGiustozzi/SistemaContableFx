package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;




public class ControllerFondo implements Initializable {
    @FXML
    private ImageView fotoView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        File foto = new File("fondo.png");
        Image foto1 = new Image(foto.toURI().toString());
        fotoView.setImage(foto1);

    }
}
