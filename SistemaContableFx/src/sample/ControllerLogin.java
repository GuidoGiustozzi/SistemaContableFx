package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;


public class ControllerLogin implements Initializable  {

    //VARIABLES DE LOS BOTONES E IMAGENES
    @FXML
    private Button cancelarBoton;
    @FXML
    private Button ingresarBoton;
    @FXML
    private Label incorrectoLabel;
    @FXML
    private ImageView rmgImageView;
    @FXML
    private ImageView marrogiusImageView;
    @FXML
    private TextField userNameFiel;
    @FXML
    private PasswordField contraseñaFiel;

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

    //Hace aparecer las imagenes al ejecutar la aplicacion

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File marrogiusFile = new File("algo.PNG");
        Image marrogiusImage = new Image(marrogiusFile.toURI().toString());
        marrogiusImageView.setImage(marrogiusImage);

        File rmgFile = new File("circle-cropped.png");
        Image rmgImage = new Image(rmgFile.toURI().toString());
        rmgImageView.setImage(rmgImage);
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





    //Accion al pulsar el boton cancelar





    public void cancelarBotonOnAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) cancelarBoton.getScene().getWindow();
        stage.close();

    }

    public void ingresarBotonOnAction(ActionEvent event) throws SQLException, IOException {
        if(userNameFiel.getText().isEmpty() == false  && contraseñaFiel.getText().isEmpty() == false) {
            if (validarLoginContador() == true){
                Registro();
                Stage stage = (Stage) ingresarBoton.getScene().getWindow();
                stage.close();


            }
            if (validarLoginAdministrador() == true){
                Registro();
                Stage stage = (Stage) ingresarBoton.getScene().getWindow();
                stage.close();


            }
            else {
                incorrectoLabel.setText("Incorrecto");
            }
        }
        else incorrectoLabel.setText("Ingrese una contaseña y un usuario");
    }

    public boolean  validarLoginAdministrador( ) throws SQLException {
        DataBase connectDB= new DataBase();
        connectDB.getConnection();
        PreparedStatement verifyLogin= connectDB.getConnection().prepareStatement("SELECT count(*)FROM usuarios WHERE nombre='"+ userNameFiel.getText() + "' AND contraseña='" +contraseñaFiel.getText()+ "' AND rol='administrador'");
        try {
            Statement statement= connectDB.getConnection().createStatement();
            ResultSet queryResult= verifyLogin.executeQuery();
            String query1 = "INSERT INTO usuario_actual (nombre, rol) VALUES ('"+userNameFiel.getText()+"','administrador')";
            while (queryResult.next()){
                if(queryResult.getInt(1)==1){
                    executeQuery(query1);



                    return  true;
                }else{
                    return  false;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
        return  false;
    }

    public boolean  validarLoginContador( ) throws SQLException {
        DataBase connectDB= new DataBase();
        connectDB.getConnection();
        PreparedStatement verifyLogin= connectDB.getConnection().prepareStatement("SELECT count(*) FROM usuarios WHERE nombre='"+ userNameFiel.getText() + "' AND contraseña='" +contraseñaFiel.getText()+ "' AND rol='contador'");
        try {
            Statement statement= connectDB.getConnection().createStatement();
            ResultSet queryResult= verifyLogin.executeQuery();
            String query1 = "INSERT INTO usuario_actual (nombre, rol) VALUES ('"+userNameFiel.getText()+"','contador')";
            while (queryResult.next()){
                if(queryResult.getInt(1)==1){
                    executeQuery(query1);
                    return  true;
                }else{
                    return  false;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
        return  false;
    }



    public  void Registro() throws IOException {

        Parent root1 = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        Stage stage2 = new Stage();
        stage2.initModality(Modality.APPLICATION_MODAL);
        stage2.setTitle("Menu");
        stage2.setScene(new Scene(root1));
        stage2.show();
        File rmgFile = new File("circle-cropped.png");
        javafx.scene.image.Image rmgImage = new javafx.scene.image.Image(rmgFile.toURI().toString());
        stage2.getIcons().add(rmgImage);



    }



}


