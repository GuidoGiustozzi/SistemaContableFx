package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class ControllerDeshabilitarCuenta implements Initializable {

    @FXML
    private Button atrasButton;
    @FXML
    private Button deshabilitarButton;
    @FXML
    private ChoiceBox<String> choiceBox;
    @FXML
    private ImageView correctoView;
    @FXML
    private ImageView marrogiusImageView;

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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public ObservableList<String> getCuentasList(){
        ObservableList<String> list = FXCollections.observableArrayList();
        Connection connection = getConnection();
        String query = "SELECT nombre FROM cuentas WHERE recibe_saldo='Si' AND habilitada='Si';";
        Statement st;
        ResultSet rs;
        try {
            st = connection.createStatement();
            rs = st.executeQuery(query);
            String nombre;
            while(rs.next()) {
                nombre = (rs.getString("nombre"));
                list.add(nombre);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }


    @FXML
    public void atras(ActionEvent event)  {
        Stage stage = (Stage) atrasButton.getScene().getWindow();
        stage.close();
    }

    public void deshabilitar(ActionEvent event)  {
        String querry= "update cuentas set habilitada='No' where nombre='"+ choiceBox.getValue()+"'";
        executeQuery(querry);
        correctoView.setVisible(true);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        choiceBox.setItems(getCuentasList());
        File correctoFile = new File("ok_48px.png");
        Image correctoImagen = new Image(correctoFile.toURI().toString());
        correctoView.setImage(correctoImagen);

        File marrogiusFile = new File("algo.PNG");
        Image marrogiusImage = new Image(marrogiusFile.toURI().toString());
        marrogiusImageView.setImage(marrogiusImage);


    }
}