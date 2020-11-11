package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;


public class Main extends Application  {


    public void start(Stage primaryStage) throws Exception{


        Parent root1 = FXMLLoader.load(getClass().getResource("Fondo.fxml"));
        Stage primaryStage1 = new Stage();
        primaryStage1.initModality(Modality.APPLICATION_MODAL);
        primaryStage1.initStyle(StageStyle.DECORATED);
        primaryStage1.setTitle("SistemaContable");
        primaryStage1.setScene(new Scene(root1));
        primaryStage1.show();

        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        //pone el icono de la imagen
        File rmgFile = new File("circle-cropped.png");
        javafx.scene.image.Image rmgImage = new javafx.scene.image.Image(rmgFile.toURI().toString());
        primaryStage1.getIcons().add(rmgImage);
        primaryStage.getIcons().add(rmgImage);

        primaryStage.initStyle(StageStyle.DECORATED);
        primaryStage.setTitle("Login");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();


    }


    public static void main(String[] args) {
        launch(args);
    }
}


