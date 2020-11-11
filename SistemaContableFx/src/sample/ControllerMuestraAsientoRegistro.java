package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.ResourceBundle;

public class ControllerMuestraAsientoRegistro implements Initializable {

    @FXML
    private Button atrasButton;

    @FXML
    private javafx.scene.control.TableView<AsientoCuenta> TableView;
    @FXML
    private TableColumn<AsientoCuenta, String> nombreColumn;
    @FXML
    private TableColumn<AsientoCuenta, Date> fechaColumn;
    @FXML
    private TableColumn<AsientoCuenta, String> descripcionColumn;
    @FXML
    private TableColumn<AsientoCuenta, Float> debeColumn;
    @FXML
    private TableColumn<AsientoCuenta, Float> haberColumn;
    @FXML
    private TableColumn<AsientoCuenta, Float> saldoColumn;

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


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        File marrogiusFile = new File("algo.PNG");
        Image marrogiusImage = new Image(marrogiusFile.toURI().toString());
        marrogiusImageView.setImage(marrogiusImage);

        showAsientos();
    }

    @FXML
    public void atras(ActionEvent event)  {
        Stage stage = (Stage) atrasButton.getScene().getWindow();
        stage.close();
    }
    //Realiza la consulta para mostrarla
    public ObservableList<AsientoCuenta> getAsientoCuentaList(){
        ObservableList<AsientoCuenta> asientosList = FXCollections.observableArrayList();
        Connection connection = getConnection();
        String query = "SELECT nombre,fecha,descripcion,idcuenta,debe,haber,saldo FROM asientos a INNER JOIN cuenta_asiento ca on(a.id=ca.idasiento) INNER JOIN cuentas c on (ca.idcuenta=c.codigo) WHERE a.id=(select max(id) FROM asientos) ORDER BY fecha,idasiento;";
        Statement st;
        ResultSet rs;
        try {
            st = connection.createStatement();
            rs = st.executeQuery(query);
            AsientoCuenta asientoCuenta;
            while(rs.next()) {
                asientoCuenta = new AsientoCuenta(rs.getString("nombre"),rs.getDate("fecha"),rs.getString("descripcion"),rs.getFloat("debe"),rs.getFloat("haber"),rs.getFloat("saldo"));
                asientosList.add(asientoCuenta);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return asientosList;
    }

    public void showAsientos() {
        ObservableList<AsientoCuenta> list = getAsientoCuentaList();
        nombreColumn.setCellValueFactory(new PropertyValueFactory<AsientoCuenta, String>("nombre"));
        fechaColumn.setCellValueFactory(new PropertyValueFactory<AsientoCuenta, Date>("fecha"));
        descripcionColumn.setCellValueFactory(new PropertyValueFactory<AsientoCuenta,String>("descripcion"));
        debeColumn.setCellValueFactory(new PropertyValueFactory<AsientoCuenta,Float>("debe"));
        haberColumn.setCellValueFactory(new PropertyValueFactory<AsientoCuenta,Float>("haber"));
        saldoColumn.setCellValueFactory(new PropertyValueFactory<AsientoCuenta,Float>("saldo"));
        TableView.setItems(list);
    }


}
