package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ResourceBundle;

public class ControllerAgregarCuentas implements Initializable {


    ObservableList<String> recibesaldoStatus = FXCollections.observableArrayList("Si","No");
    ObservableList<String> tipoStatus = FXCollections.observableArrayList("Activo","Pasivo","Patrimonio","R+","R-");


    @FXML
    private TextField cuentaField;
    @FXML
    private TextField codigoField;

    @FXML
    private Button agregarButton;
    @FXML
    private ImageView rmgImageView;
    @FXML
    private ChoiceBox recibesaldoBox;
    @FXML
    private ChoiceBox tipoBox;
    @FXML
    private Label incorrectoLabel;


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
            incorrectoLabel.setText("Ha creado la cuenta con exito");
        } catch (Exception e) {
            e.printStackTrace();
            incorrectoLabel.setText("Ingrese un codigo que este disponible");
        }
    }


    public void initialize(URL url, ResourceBundle resourceBundle) {
        File rmgFile = new File("circle-cropped.png");
        Image rmgImage = new Image(rmgFile.toURI().toString());
        rmgImageView.setImage(rmgImage);
        recibesaldoBox.setItems(recibesaldoStatus);
        tipoBox.setItems(tipoStatus);



    }
    @FXML
    private void agregarButton() {
        String query = "insert into cuentas(codigo,nombre,tipo,recibe_saldo,saldo_actual,habilitada) values("+ codigoField.getText() +",'"+ cuentaField.getText() + "','"  + tipoBox.getValue() + "','" + recibesaldoBox.getValue() + "',0,'Si')";
        executeQuery(query);

    }

    public void Numeros(){
        codigoField.setOnKeyTyped(event -> SoloNumeros(event));
    }
    private void SoloNumeros(KeyEvent event) {
        try{
            char key = event.getCharacter().charAt(0);
            if (!Character.isDigit(key)) {
                event.consume();
                codigoField.setText(""); }

        } catch (Exception ex){ }
    }


}

