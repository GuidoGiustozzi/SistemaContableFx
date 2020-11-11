package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ResourceBundle;

public class ControllerRegistrarUsuario implements Initializable {

    ObservableList<String> rolStatus = FXCollections.observableArrayList("administrador","contador");

    @FXML
    private ImageView correctoView;
    @FXML
    private TextField idText;
    @FXML
    private TextField nombreText;
    @FXML
    private PasswordField contraseñaText;
    @FXML
    private ChoiceBox rolBox;
    @FXML
    private Button registrarButton;
    @FXML
    private Button salirButton;

    public Connection getConnection() {
        Connection conn;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/prueba?useTimezone=true&serverTimezone=UTC", "root", "sanlorenzo");
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public void executeQuery(String query) {
        Connection conn = getConnection();
        Statement st;
        try {
            st = conn.createStatement();
            st.executeUpdate(query);
            correctoView.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
            correctoView.setVisible(false);

        }
    }

    public void initialize(URL url, ResourceBundle resourceBundle) {
        rolBox.setItems(rolStatus);
        File correctoFile = new File("ok_48px.png");
        Image correctoImagen = new Image(correctoFile.toURI().toString());
        correctoView.setImage(correctoImagen);
    }

   @FXML
    private void RegistrarButton() {
        String query = "insert into usuarios(nombre,contraseña,rol) values('" + nombreText.getText() + "','" + contraseñaText.getText() + "','" + rolBox.getValue() + "')";
        executeQuery(query);

    }
    @FXML
    private void salirButton(ActionEvent event)  {
        Stage stage = (Stage) salirButton.getScene().getWindow();
        stage.close();
    }

}
