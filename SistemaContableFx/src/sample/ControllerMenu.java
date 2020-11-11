package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class ControllerMenu implements Initializable {

    @FXML
    private Button mayorButton;
    @FXML
    private Button diarioButton;
    @FXML
    private Button asientosButton;
    @FXML
    private Button cuentasButton;
    @FXML
    private Button usuariosButton;
    @FXML
    private Button salirButton;
    @FXML
    private Button infoEmpButton;

    @FXML
    private ImageView rmgImageView;
    @FXML
    private ImageView fotoView;
    @FXML
    private Label usuarioLabel;

    private  String nombreUsuario;
    private  String rolUsuario;

    public String getNombreUsuario() {
        return nombreUsuario;
    }
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
    public String getRolUsuario() {
        return rolUsuario;
    }
    public void setRolUsuario(String rolUsuario) {
        this.rolUsuario = rolUsuario;
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


    public void initialize(URL url, ResourceBundle resourceBundle) {

        File rmgFile = new File("circle-cropped.png");
        Image rmgImage = new Image(rmgFile.toURI().toString());
        rmgImageView.setImage(rmgImage);

        File foto = new File("ok_48px.png");
        Image foto1 = new Image(foto.toURI().toString());
        fotoView.setImage(foto1);

        datosUsuarioActual();
        usuarioLabel.setText("Bienvenidx " +getNombreUsuario());
        if (getRolUsuario().equals("contador")){
            usuariosButton.setVisible(false);
        }

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
                setNombreUsuario(rs.getString("nombre"));
                setRolUsuario(rs.getString("rol"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void irAsientosOnAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) asientosButton.getScene().getWindow();
        Parent root1 = FXMLLoader.load(getClass().getResource("Asientos.fxml"));
        Stage stage2 = new Stage();
        stage2.initModality(Modality.APPLICATION_MODAL);
        stage2.setTitle("Asientos");
        stage2.setScene(new Scene(root1));
        stage2.show();
        File rmgFile = new File("circle-cropped.png");
        javafx.scene.image.Image rmgImage = new javafx.scene.image.Image(rmgFile.toURI().toString());
        stage2.getIcons().add(rmgImage);
    }

    public void irCuentasOnAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) cuentasButton.getScene().getWindow();
        Parent root1 = FXMLLoader.load(getClass().getResource("Cuenta.fxml"));
        Stage stage2 = new Stage();
        stage2.initModality(Modality.APPLICATION_MODAL);
        stage2.setTitle("Cuentas");
        stage2.setScene(new Scene(root1));
        stage2.show();
        File rmgFile = new File("circle-cropped.png");
        javafx.scene.image.Image rmgImage = new javafx.scene.image.Image(rmgFile.toURI().toString());
        stage2.getIcons().add(rmgImage);
    }
    public void irMayorOnAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) mayorButton.getScene().getWindow();
        Parent root1 = FXMLLoader.load(getClass().getResource("LibroMayor.fxml"));
        Stage stage2 = new Stage();
        stage2.initModality(Modality.APPLICATION_MODAL);
        stage2.setTitle("LibroMayor");
        stage2.setScene(new Scene(root1));
        stage2.show();
        File rmgFile = new File("circle-cropped.png");
        javafx.scene.image.Image rmgImage = new javafx.scene.image.Image(rmgFile.toURI().toString());
        stage2.getIcons().add(rmgImage);
    }
    public void irDiarioOnAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) diarioButton.getScene().getWindow();
        Parent root1 = FXMLLoader.load(getClass().getResource("LibroDiario.fxml"));
        Stage stage2 = new Stage();
        stage2.initModality(Modality.APPLICATION_MODAL);
        stage2.setTitle("LibroDiario");
        stage2.setScene(new Scene(root1));
        stage2.show();
        File rmgFile = new File("circle-cropped.png");
        javafx.scene.image.Image rmgImage = new javafx.scene.image.Image(rmgFile.toURI().toString());
        stage2.getIcons().add(rmgImage);
    }

    public void irUsuariosOnAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) usuariosButton.getScene().getWindow();
        Parent root1 = FXMLLoader.load(getClass().getResource("Usuarios.fxml"));
        Stage stage2 = new Stage();
        stage2.initModality(Modality.APPLICATION_MODAL);
        stage2.setTitle("Usuarios");
        stage2.setScene(new Scene(root1));
        stage2.show();
        File rmgFile = new File("circle-cropped.png");
        javafx.scene.image.Image rmgImage = new javafx.scene.image.Image(rmgFile.toURI().toString());
        stage2.getIcons().add(rmgImage);
    }

    @FXML
    private void salirButton(ActionEvent event)  {
        Stage stage = (Stage) salirButton.getScene().getWindow();
        stage.close();
    }

    public void irInfoEmpOnAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("InfoEmp.fxml"));
        File rmgFile = new File("circle-cropped.png");
        Stage stage = new Stage();
        javafx.scene.image.Image rmgImage = new javafx.scene.image.Image(rmgFile.toURI().toString());
        stage.initStyle(StageStyle.DECORATED);
        stage.setTitle("Informacion de la empresa");
        stage.setScene(new Scene(root));
        stage.show();
        stage.getIcons().add(rmgImage);
    }

}
