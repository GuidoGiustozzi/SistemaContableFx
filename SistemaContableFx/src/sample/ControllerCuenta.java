package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class ControllerCuenta implements Initializable {

    @FXML
    private javafx.scene.control.TableView<Cuentas> TableView;
    @FXML
    private TableColumn<Cuentas, String>  nombreColumn;
    @FXML
    private TableColumn<Cuentas, String> codigoColumn;
    @FXML
    private TableColumn<Cuentas, String> tipoColumn;
    @FXML
    private TableColumn<Cuentas, String> recibesaldoColumn;

    @FXML
    private Button atrasButton;
    @FXML
    private Button agregarButton;
    @FXML
    private Button habilitarButton;
    @FXML
    private Button deshabiliarButton;

    private  String rolUsuario;
    @FXML
    private ImageView marrogiusImageView;

    public String getRolUsuario() {
        return rolUsuario;
    }
    public void setRolUsuario(String rolUsuario) {
        this.rolUsuario = rolUsuario;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        File marrogiusFile = new File("algo.PNG");
        Image marrogiusImage = new Image(marrogiusFile.toURI().toString());
        marrogiusImageView.setImage(marrogiusImage);

        showAsientos();
        datosUsuarioActual();
        if (getRolUsuario().equals("contador")){
            agregarButton.setVisible(false);
            deshabiliarButton.setVisible(false);
            habilitarButton.setVisible(false);
        }

    }

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


    public ObservableList<Cuentas> getCuentaList() {
        ObservableList<Cuentas> cuentasList = FXCollections.observableArrayList();
        Connection connection = getConnection();
        String query = "SELECT * FROM cuentas WHERE habilitada='Si'";
        Statement st;
        ResultSet rs;
        try {
            st = connection.createStatement();
            rs = st.executeQuery(query);
            Cuentas cuenta;
            while (rs.next()) {

                cuenta = new Cuentas(rs.getInt("codigo"), rs.getString("nombre"),  rs.getString("tipo"), rs.getString("recibe_saldo"));
                cuentasList.add(cuenta);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cuentasList;
    }

    public void showAsientos() {
            ObservableList<Cuentas> list = getCuentaList();
            codigoColumn.setCellValueFactory(new PropertyValueFactory<Cuentas,String>("codigo"));
            nombreColumn.setCellValueFactory(new PropertyValueFactory<Cuentas,String>("nombre"));
            tipoColumn.setCellValueFactory(new PropertyValueFactory<Cuentas,String>("tipo"));
            recibesaldoColumn.setCellValueFactory(new PropertyValueFactory<Cuentas,String>("recibe_saldo"));
            TableView.setItems(list);
        }

    public void agregarOnAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) agregarButton.getScene().getWindow();
        stage.close();
        Parent root1 = FXMLLoader.load(getClass().getResource("AgregarCuentas.fxml"));
        Stage stage2 = new Stage();
        stage2.initModality(Modality.APPLICATION_MODAL);
        stage2.setTitle("Cuentas");
        stage2.setScene(new Scene(root1));
        stage2.show();
        File rmgFile = new File("circle-cropped.png");
        javafx.scene.image.Image rmgImage = new javafx.scene.image.Image(rmgFile.toURI().toString());
        stage2.getIcons().add(rmgImage);
    }
    public void deshabilitarOnAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) deshabiliarButton.getScene().getWindow();
        stage.close();
        Parent root1 = FXMLLoader.load(getClass().getResource("DeshabilitarCuenta.fxml"));
        Stage stage2 = new Stage();
        stage2.initModality(Modality.APPLICATION_MODAL);
        stage2.setTitle("Deshabilitar Cuentas");
        stage2.setScene(new Scene(root1));
        stage2.show();
        File rmgFile = new File("circle-cropped.png");
        javafx.scene.image.Image rmgImage = new javafx.scene.image.Image(rmgFile.toURI().toString());
        stage2.getIcons().add(rmgImage);
    }


    public void habilitarOnAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) habilitarButton.getScene().getWindow();
        stage.close();
        Parent root1 = FXMLLoader.load(getClass().getResource("HabilitarCuenta.fxml"));
        Stage stage2 = new Stage();
        stage2.initModality(Modality.APPLICATION_MODAL);
        stage2.setTitle("Habilitar Cuentas");
        stage2.setScene(new Scene(root1));
        stage2.show();
        File rmgFile = new File("circle-cropped.png");
        javafx.scene.image.Image rmgImage = new javafx.scene.image.Image(rmgFile.toURI().toString());
        stage2.getIcons().add(rmgImage);
    }




    @FXML
    private void salirButton(ActionEvent event)  {
        Stage stage = (Stage) atrasButton.getScene().getWindow();
        stage.close();
    }

    public void datosUsuarioActual() {

        Connection connection = getConnection();
        String query = "select nombre,rol from usuario_actual where actual=(select  MAX(actual) from usuario_actual);";
        Statement st;
        ResultSet rs;
        try {
            st = connection.createStatement();
            rs = st.executeQuery(query);
            AsientoCuenta asientoCuenta;
            while (rs.next()){
                setRolUsuario(rs.getString("rol"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}



