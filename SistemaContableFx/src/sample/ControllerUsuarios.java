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
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class ControllerUsuarios implements Initializable  {


    @FXML
    private TableView<Usuario> TableView;

    @FXML
    private TableColumn<Usuario, Integer> idColumn;

    @FXML
    private TableColumn<Usuario, String> nombreColumn;

    @FXML
    private TableColumn<Usuario, String> rolColumn;

    @FXML
    private Button agregarButton;

    @FXML
    private Button salirButton;

    @FXML
    private ImageView imagaPdf;


    public ControllerUsuarios() {
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

    @FXML
    private void salirButton(ActionEvent event)  {
        Stage stage = (Stage) salirButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void agregarButton (ActionEvent event) throws IOException {
            Stage stage = (Stage) agregarButton.getScene().getWindow();
            Parent root1 = FXMLLoader.load(getClass().getResource("RegistrarUsuario.fxml"));
            Stage stage2 = new Stage();
            stage2.initModality(Modality.APPLICATION_MODAL);
            stage2.setTitle("Registrar Usuarios");
            stage2.setScene(new Scene(root1));
            stage2.show();
            stage.close();
            File rmgFile = new File("circle-cropped.png");
            Image rmgImage = new Image(rmgFile.toURI().toString());
            stage2.getIcons().add(rmgImage);
    }

    public ObservableList<Usuario> getUsuariosList(){
        ObservableList<Usuario> usuariosList = FXCollections.observableArrayList();
        Connection connection = getConnection();
        String query = "SELECT * FROM usuarios ";
        Statement st;
        ResultSet rs;
        try {
            st = connection.createStatement();
            rs = st.executeQuery(query);
            Usuario usuarios;
            while(rs.next()) {
                usuarios = new Usuario(rs.getInt("id"),rs.getString("nombre"),rs.getString("rol"));
                usuariosList.add(usuarios);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuariosList;
    }

    public void showUsuarios() {
        ObservableList<Usuario> list = getUsuariosList();
        idColumn.setCellValueFactory(new PropertyValueFactory<Usuario,Integer>("id"));
        nombreColumn.setCellValueFactory(new PropertyValueFactory<Usuario,String>("nombre"));
        rolColumn.setCellValueFactory(new PropertyValueFactory<Usuario,String>("rol"));
        TableView.setItems(list);
    }

    public void initialize(URL location, ResourceBundle resources) {

        showUsuarios();
    }

}



