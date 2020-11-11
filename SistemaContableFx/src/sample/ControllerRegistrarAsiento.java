package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.Calendar;

public class ControllerRegistrarAsiento {

    @FXML
    private Button atrasButton;
    @FXML
    private TextArea descripcionArea;
    @FXML
    private Pane cuentaPane1;
    @FXML
    private ChoiceBox<Integer> cuenta1;
    @FXML
    private TextField montoField1;

    @FXML
    private Pane cuentaPane2;
    @FXML
    private ChoiceBox cuenta2;
    @FXML
    private TextField montoField2;

    @FXML
    private Pane cuentaPane3;
    @FXML
    private ChoiceBox cuenta3;
    @FXML
    private TextField montoField3;

    @FXML
    private Pane cuentaPane4;
    @FXML
    private ChoiceBox cuenta4;
    @FXML
    private TextField montoField4;

    @FXML
    private Pane cuentaPane5;
    @FXML
    private ChoiceBox cuenta5;
    @FXML
    private TextField montoField5;


    @FXML
    private Pane cuentaPane6;
    @FXML
    private ChoiceBox cuenta6;
    @FXML
    private TextField montoField6;

    @FXML
    private Pane cuentaPane7;
    @FXML
    private ChoiceBox cuenta7;
    @FXML
    private TextField montoField7;

    @FXML
    private Label mensajeLabel;

    @FXML
    private Label numeroasientoLabel;
    @FXML
    private Label diaLabel;

    @FXML
    private Button agregarButton;
    @FXML
    private Button validarButton1;
    @FXML
    private Button validarButton2;
    @FXML
    private Button validarButton3;
    @FXML
    private Button validarButton4;
    @FXML
    private Button validarButton5;
    @FXML
    private Button validarButton6;
    @FXML
    private Button validarButton7;

    @FXML
    private Button planButton;

    @FXML
    private ImageView agregartercera;
    @FXML
    private ImageView agregarcuarta;
    @FXML
    private ImageView agregarquinta;
    @FXML
    private ImageView agregarsexta;
    @FXML
    private ImageView agregarseptima;

    @FXML
    private ImageView sacartercera;
    @FXML
    private ImageView sacarcuarta;
    @FXML
    private ImageView sacarquinta;
    @FXML
    private ImageView sacarsexta;
    @FXML
    private ImageView sacarseptima;



    private int idUsuario;

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    //La usaremos para validar que estan iguales
    private float debeGeneral = 0;
    private float haberGeneral = 0;

    private float debeCuenta1;
    private float haberCuenta1;
    private float saldoCuenta1;

    private float debeCuenta2;
    private float haberCuenta2;
    private float saldoCuenta2;

    private float debeCuenta3;
    private float haberCuenta3;
    private float saldoCuenta3;

    private float debeCuenta4;
    private float haberCuenta4;
    private float saldoCuenta4;

    private float debeCuenta5;
    private float haberCuenta5;
    private float saldoCuenta5;

    private float debeCuenta6;
    private float haberCuenta6;
    private float saldoCuenta6;

    private float debeCuenta7;
    private float haberCuenta7;
    private float saldoCuenta7;

    @FXML
    private Label nombreCuenta1;
    @FXML
    private Label nombreCuenta2;
    @FXML
    private Label nombreCuenta3;
    @FXML
    private Label nombreCuenta4;
    @FXML
    private Label nombreCuenta5;

    @FXML
    private Label nombreCuenta6;
    @FXML
    private Label nombreCuenta7;


    /// GETER AND SETTER DE LOS DEBE PARA DESPUES INGRESARLOS EN LA BASE DE DATOS
    public ControllerRegistrarAsiento() throws SQLException {
    }

    public float getDebeGeneral() {
        return debeGeneral;
    }

    public void setDebeGeneral(float debeGeneral) {
        this.debeGeneral = debeGeneral;
    }

    public float getHaberGeneral() {
        return haberGeneral;
    }

    public void setHaberGeneral(float haberGeneral) {
        this.haberGeneral = haberGeneral;
    }

    public float getDebeCuenta1() {
        return debeCuenta1;
    }

    public void setDebeCuenta1(float debeCuenta1) {
        this.debeCuenta1 = debeCuenta1;
    }

    public float getHaberCuenta1() {
        return haberCuenta1;
    }

    public void setHaberCuenta1(float haberCuenta1) {
        this.haberCuenta1 = haberCuenta1;
    }

    public float getSaldoCuenta1() {
        return saldoCuenta1;
    }

    public void setSaldoCuenta1(float saldoCuenta1) {
        this.saldoCuenta1 = saldoCuenta1;
    }

    public float getDebeCuenta2() {
        return debeCuenta2;
    }

    public void setDebeCuenta2(float debeCuenta2) {
        this.debeCuenta2 = debeCuenta2;
    }

    public float getHaberCuenta2() {
        return haberCuenta2;
    }

    public void setHaberCuenta2(float haberCuenta2) {
        this.haberCuenta2 = haberCuenta2;
    }

    public float getSaldoCuenta2() {
        return saldoCuenta2;
    }

    public void setSaldoCuenta2(float saldoCuenta2) {
        this.saldoCuenta2 = saldoCuenta2;
    }

    public float getDebeCuenta3() {
        return debeCuenta3;
    }

    public void setDebeCuenta3(float debeCuenta3) {
        this.debeCuenta3 = debeCuenta3;
    }

    public float getHaberCuenta3() {
        return haberCuenta3;
    }

    public void setHaberCuenta3(float haberCuenta3) {
        this.haberCuenta3 = haberCuenta3;
    }

    public float getSaldoCuenta3() {
        return saldoCuenta3;
    }

    public void setSaldoCuenta3(float saldoCuenta3) {
        this.saldoCuenta3 = saldoCuenta3;
    }

    public float getDebeCuenta4() {
        return debeCuenta4;
    }

    public void setDebeCuenta4(float debeCuenta4) {
        this.debeCuenta4 = debeCuenta4;
    }

    public float getHaberCuenta4() {
        return haberCuenta4;
    }

    public void setHaberCuenta4(float haberCuenta4) {
        this.haberCuenta4 = haberCuenta4;
    }

    public float getSaldoCuenta4() {
        return saldoCuenta4;
    }

    public void setSaldoCuenta4(float saldoCuenta4) {
        this.saldoCuenta4 = saldoCuenta4;
    }

    public float getDebeCuenta5() {
        return debeCuenta5;
    }

    public void setDebeCuenta5(float debeCuenta5) {
        this.debeCuenta5 = debeCuenta5;
    }

    public float getHaberCuenta5() {
        return haberCuenta5;
    }

    public void setHaberCuenta5(float haberCuenta5) {
        this.haberCuenta5 = haberCuenta5;
    }

    public float getSaldoCuenta5() {
        return saldoCuenta5;
    }

    public void setSaldoCuenta5(float saldoCuenta5) {
        this.saldoCuenta5 = saldoCuenta5;
    }
    public float getDebeCuenta6() {
        return debeCuenta6;
    }
    public void setDebeCuenta6(float debeCuenta6) {
        this.debeCuenta6 = debeCuenta6;
    }
    public float getHaberCuenta6() {
        return haberCuenta6;
    }
    public void setHaberCuenta6(float haberCuenta6) {
        this.haberCuenta6 = haberCuenta6;
    }

    public float getSaldoCuenta6() {
        return saldoCuenta6; }public void setSaldoCuenta6(float saldoCuenta6) {
        this.saldoCuenta6 = saldoCuenta6;
    }
    public float getDebeCuenta7() {
        return debeCuenta7;
    }
    public void setDebeCuenta7(float debeCuenta7) {
        this.debeCuenta7 = debeCuenta7;
    }
    public float getHaberCuenta7() {
        return haberCuenta7;
    }
    public void setHaberCuenta7(float haberCuenta7) {
        this.haberCuenta7 = haberCuenta7;
    }
    public float getSaldoCuenta7() { return saldoCuenta7; }
    public void setSaldoCuenta7(float saldoCuenta7) {
        this.saldoCuenta7 = saldoCuenta7;
    }


    @FXML
    private void initialize() throws SQLException {
        datosUsuarioActual();
        cuenta1.setItems(getCuentasList());
        cuenta2.setItems(getCuentasList());
        cuenta3.setItems(getCuentasList());
        cuenta4.setItems(getCuentasList());
        cuenta5.setItems(getCuentasList());
        cuenta6.setItems(getCuentasList());
        cuenta7.setItems(getCuentasList());
        //Dice cual es el numero del asiento, basandose de asiento mas grande ingresado en la base de datos
        String asientoactual = Integer.toString(valorIDAsiento());
        numeroasientoLabel.setText(asientoactual);
        diaLabel.setText(diaActual());

        //AGREGAR FOTITO PA poner
        File agregar3File = new File("agregar.PNG");
        Image agregar3 = new Image(agregar3File.toURI().toString());
        agregartercera.setImage(agregar3);

        File agregar4File = new File("agregar.PNG");
        Image agregar4 = new Image(agregar4File.toURI().toString());
        agregarcuarta.setImage(agregar4);

        File agregar5File = new File("agregar.PNG");
        Image agregar5 = new Image(agregar5File.toURI().toString());
        agregarquinta.setImage(agregar5);


        File agregar6File = new File("agregar.PNG");
        Image agregar6 = new Image(agregar6File.toURI().toString());
        agregarsexta.setImage(agregar6);

        File agregar7File = new File("agregar.PNG");
        Image agregar7 = new Image(agregar7File.toURI().toString());
        agregarseptima.setImage(agregar7);

        //BOTON DE SACAR
        File quitar3File = new File("cancelar.PNG");
        Image quitar3 = new Image(quitar3File.toURI().toString());
        sacartercera.setImage(quitar3);

        File quitar4File = new File("cancelar.PNG");
        Image quitar4 = new Image(quitar4File.toURI().toString());
        sacarcuarta.setImage(quitar4);

        File quitar5File = new File("cancelar.PNG");
        Image quitar5 = new Image(quitar5File.toURI().toString());
        sacarquinta.setImage(quitar5);

        File quitar6File = new File("cancelar.PNG");
        Image quitar6 = new Image(quitar6File.toURI().toString());
        sacarsexta.setImage(quitar6);

        File quitar7File = new File("cancelar.PNG");
        Image quitar7 = new Image(quitar7File.toURI().toString());
        sacarseptima.setImage(quitar7);



    }

    public void irCuentasOnAction(ActionEvent event) throws IOException {
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


    public String diaActual(){
        Calendar c1 = Calendar.getInstance();
        String dia, mes,annio;
        dia = Integer.toString(c1.get(Calendar.DATE));
        mes = Integer.toString(c1.get(Calendar.MONTH));
        annio = Integer.toString(c1.get(Calendar.YEAR));
        return (annio+"/"+ mes +"/"+ dia);
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
        } catch (Exception e ) {
            e.printStackTrace();

        }
    }

    //Crea la lista de las cuentas.
    public ObservableList<Integer> getCuentasList() {
        ObservableList<Integer> list = FXCollections.observableArrayList();
        Connection connection = getConnection();
        String query = "SELECT codigo FROM cuentas WHERE recibe_saldo='Si' AND  habilitada='Si'";
        Statement st;
        ResultSet rs;
        try {
            st = connection.createStatement();
            rs = st.executeQuery(query);
            int numero;
            while (rs.next()) {
                numero = (rs.getInt("codigo"));
                list.add(numero);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public int valorIDAsiento() throws SQLException {
        Connection connection = getConnection();
        String query = "SELECT max(id) FROM asientos ";
        Statement st;
        ResultSet rs;
        st = connection.createStatement();
        rs = st.executeQuery(query);
        int numero = 0;
        while (rs.next()) {
            numero = (rs.getInt(1));
        }
        return numero + 1;
    }

    public String nombreCuenta(ChoiceBox c) throws SQLException {
        Connection connection = getConnection();
        String query = "SELECT nombre FROM cuentas where codigo="+c.getValue();
        Statement st;
        ResultSet rs;
        st = connection.createStatement();
        rs = st.executeQuery(query);
        String nombre ="";
        while (rs.next()) {
            nombre = (rs.getString(1));
        }
        return nombre ;
    }


    public void devolverNombreCuenta1() throws SQLException {
        if(cuenta1.getValue()!=null){
            nombreCuenta1.setText(nombreCuenta(cuenta1));}

    }
    public void devolverNombreCuenta2() throws SQLException {
        if(cuenta2.getValue()!=null){
            nombreCuenta2.setText(nombreCuenta(cuenta2));}

    }
    public void devolverNombreCuenta3() throws SQLException {
        if(cuenta3.getValue()!=null){
            nombreCuenta3.setText(nombreCuenta(cuenta3));}

    }
    public void devolverNombreCuenta4() throws SQLException {
        if(cuenta4.getValue()!=null){
            nombreCuenta4.setText(nombreCuenta(cuenta4));}

    }
    public void devolverNombreCuenta5() throws SQLException {
        if(cuenta5.getValue()!=null){
            nombreCuenta5.setText(nombreCuenta(cuenta5));}

    }
    public void devolverNombreCuenta6() throws SQLException {
        if(cuenta6.getValue()!=null){
            nombreCuenta6.setText(nombreCuenta(cuenta6));}

    }
    public void devolverNombreCuenta7() throws SQLException {
        if(cuenta7.getValue()!=null){
            nombreCuenta7.setText(nombreCuenta(cuenta7));}

    }



    public void noLetras1(){
        montoField1.setOnKeyTyped(event -> SoloNumerosEnteros1(event));
    }
    private void SoloNumerosEnteros1(KeyEvent event) {
        try{
            char key = event.getCharacter().charAt(0);
                if (Character.isLetter(key)) {
                event.consume();
                montoField1.setText("");
                mensajeLabel.setText("No se pueden agregar letras"); }

        } catch (Exception ex){ }
    }


    public void noLetras2(){
        montoField2.setOnKeyTyped(event -> SoloNumerosEnteros2(event));
    }
    private void SoloNumerosEnteros2(javafx.scene.input.KeyEvent event) {
        try{
            char key = event.getCharacter().charAt(0);
            if (Character.isLetter(key)) {
                event.consume();
                montoField2.setText("");
                mensajeLabel.setText("No se pueden agregar letras");
            }
        } catch (Exception ex){ }


    }
    public void noLetras3(){
        montoField3.setOnKeyTyped(event -> SoloNumerosEnteros3(event));
    }
    private void SoloNumerosEnteros3(javafx.scene.input.KeyEvent event) {
        try{
            char key = event.getCharacter().charAt(0);
            if (Character.isLetter(key)) {
                event.consume();
                montoField3.setText("");
                mensajeLabel.setText("No se pueden agregar letras");
            }
        } catch (Exception ex){ }


    }
    public void noLetras4(){
        montoField4.setOnKeyTyped(event -> SoloNumerosEnteros4(event));
    }
    private void SoloNumerosEnteros4(javafx.scene.input.KeyEvent event) {
        try{
            char key = event.getCharacter().charAt(0);
            if (Character.isLetter(key)) {
                event.consume();
                montoField4.setText("");mensajeLabel.setText("No se pueden agregar letras");

            }
        } catch (Exception ex){ }

    }
    public void noLetras5(){ montoField5.setOnKeyTyped(event -> SoloNumerosEnteros5(event));
    }
    private void SoloNumerosEnteros5(javafx.scene.input.KeyEvent event) {
        try{
            char key = event.getCharacter().charAt(0);
            if (Character.isLetter(key)) {
                event.consume();
                montoField5.setText("");
                mensajeLabel.setText("No se pueden agregar letras");
            }
        } catch (Exception ex){ }


    }


    public void noLetras6(){ montoField6.setOnKeyTyped(event -> SoloNumerosEnteros6(event));
    }
    private void SoloNumerosEnteros6(javafx.scene.input.KeyEvent event) {
        try{
            char key = event.getCharacter().charAt(0);
            if (Character.isLetter(key)) {
                event.consume();
                montoField6.setText("");
                mensajeLabel.setText("No se pueden agregar letras");
            }
        } catch (Exception ex){ }

    }

    public void noLetras7(){ montoField7.setOnKeyTyped(event -> SoloNumerosEnteros7(event));
    }
    private void SoloNumerosEnteros7(javafx.scene.input.KeyEvent event) {
        try{
            char key = event.getCharacter().charAt(0);
            if (Character.isLetter(key)) {
                event.consume();
                montoField7.setText("");
                mensajeLabel.setText("No se pueden agregar letras");
            }
        } catch (Exception ex){ }


    }




    //Accion de la validacion numero 1 hasta la linea
    public void validar1() throws SQLException {
        if (validarmonto1() != true) {
            System.out.println("hola");
        } else {
            cuentaPane2.setDisable(false);
            cuentaPane1.setDisable(true);
            mensajeLabel.setText("");
        }
    }

    public boolean validarmonto1() throws SQLException {
        float saldoDeLaCuenta = saldoDeLaCuenta();
        String tipoDeCuenta = tipoDeCuenta1();
        float monto = Float.parseFloat(montoField1.getText());
        switch (tipoDeCuenta) {
            case "Activo":
                if (monto > 0) {
                    setDebeCuenta1(monto);
                    setHaberCuenta1(0);
                } else {
                    setDebeCuenta1(0);
                    setHaberCuenta1(-monto);
                }
                break;
            case "Pasivo":
                if (monto > 0) {
                    setDebeCuenta1(0);
                    setHaberCuenta1(monto);
                } else {
                    setDebeCuenta1(-monto);
                    setHaberCuenta1(0);
                }
                break;
            case "Patrimonio":
                if (monto > 0) {
                    setDebeCuenta1(0);
                    setHaberCuenta1(monto);
                } else {
                    setDebeCuenta1(-monto);
                    setHaberCuenta1(0);
                }
                break;

            case "R+":
                if (monto >= 0) {
                    setDebeCuenta1(0);
                    setHaberCuenta1(monto);
                } else {
                    montoField1.setText("");
                    mensajeLabel.setText("R+ no va en negativo");
                    return false;
                }
                break;
            case "R-":
                if (monto >= 0) {
                    setDebeCuenta1(monto);
                    setHaberCuenta1(0);
                } else {
                    montoField1.setText("");
                    mensajeLabel.setText("R- no va en negativo");
                    return false;

                }
                break;
            default:
                break;
        }
        float auxiliar = getDebeGeneral();
        float auxiliar2 = getHaberGeneral();

        if (monto==0){
            mensajeLabel.setText("Monto igual a 0 no sirve");
            return false;
        }

        if (monto > 0) {
            setDebeGeneral(debeCuenta1 + auxiliar);
            setHaberGeneral(haberCuenta1 + auxiliar2);
            setSaldoCuenta1(saldoDeLaCuenta + monto);
            System.out.println("El valor del debe general  es " + debeGeneral);
            System.out.println("El valor del haber general es " + haberGeneral);
            System.out.println("El valor del debe de la cuenta 1 es: " + debeCuenta1);
            System.out.println("El valor del haber de la cuenta 1 es: " + haberCuenta1);
            return true;
        }
        if (monto < 0 && saldoDeLaCuenta >= -monto) {
            setDebeGeneral(debeCuenta1 + auxiliar);
            setHaberGeneral(haberCuenta1 + auxiliar2);
            setSaldoCuenta1(saldoDeLaCuenta + monto);
            System.out.println("El valor del debe general  es " + debeGeneral);
            System.out.println("El valor del haber general es " + haberGeneral);
            System.out.println("El valor del debe de la cuenta 1 es: " + debeCuenta1);
            System.out.println("El valor del haber de la cuenta 1 es: " + haberCuenta1);
            return true;
        }

        else {
            mensajeLabel.setText("La cuenta no posee saldo para realizar esta operacion");
            return false;}

    }

    public float saldoDeLaCuenta() throws SQLException {
        Connection connection = getConnection();
        String query = "SELECT saldo_actual FROM cuentas WHERE codigo=" + cuenta1.getValue();
        Statement st;
        ResultSet rs;
        st = connection.createStatement();
        rs = st.executeQuery(query);
        int numero = 0;
        while (rs.next()) {
            numero = (rs.getInt(1));
        }
        return numero;
    }

    public String tipoDeCuenta1() throws SQLException {
        Connection connection = getConnection();
        String query = "SELECT tipo FROM cuentas WHERE codigo=" + cuenta1.getValue();
        Statement st;
        ResultSet rs;
        st = connection.createStatement();
        rs = st.executeQuery(query);
        String nombrecuenta = "";
        while (rs.next()) {
            nombrecuenta = (rs.getString(1));
        }
        return nombrecuenta;

    }


    //ACCION VALIDACION CUENTA 2
    public void validar2() throws SQLException {
        if (validarmonto2() != true) {
            System.out.println("");
        } else {
            cuentaPane2.setDisable(true);
            mensajeLabel.setText("");
            agregartercera.setVisible(true);
            agregarButton.setDisable(false);



        }
    }
    public boolean validarmonto2() throws SQLException {
        float saldoDeLaCuenta2 = saldoDeLaCuenta2();
        String tipoDeCuenta2 = tipoDeCuenta2();
        float monto = Float.parseFloat(montoField2.getText());
        switch (tipoDeCuenta2) {
            case "Activo":
                if (monto > 0) {
                    setDebeCuenta2(monto);
                    setHaberCuenta2(0);
                } else {
                    setDebeCuenta2(0);
                    setHaberCuenta2(-monto);
                }
                break;

            case "Pasivo":
                if (monto > 0) {
                    setDebeCuenta2(0);
                    setHaberCuenta2(monto);
                } else {
                    setDebeCuenta2(-monto);
                    setHaberCuenta2(0);
                }
                break;

            case "Patrimonio":
                if (monto > 0) {
                    setDebeCuenta2(0);
                    setHaberCuenta2(monto);
                } else {
                    setDebeCuenta2(-monto);
                    setHaberCuenta2(0);
                }
                break;
            case "R+":
                if (monto >= 0) {
                    setDebeCuenta2(0);
                    setHaberCuenta2(monto);
                } else {
                    montoField2.setText("");
                    mensajeLabel.setText("R+ no va en negativo");
                    return false;
                }
                break;
            case "R-":
                if (monto >= 0) {
                    setDebeCuenta2(monto);
                    setHaberCuenta2(0);
                } else {
                    montoField2.setText("");
                    mensajeLabel.setText("R- no va en negativo");
                    return false;
                }
                break;
            default:
                break;
        }
        float auxiliar = getDebeGeneral();
        float auxiliar2 = getHaberGeneral();
        if (monto==0){
            mensajeLabel.setText("Monto igual a 0 no sirve");
            return false;
        }
        if (monto > 0) {
            setDebeGeneral(debeCuenta2 + auxiliar);
            setHaberGeneral(haberCuenta2 + auxiliar2);
            setSaldoCuenta2(saldoDeLaCuenta2 + monto);
            System.out.println("El valor del debe general  es " + debeGeneral);
            System.out.println("El valor del haber general es " + haberGeneral);
            System.out.println("El valor del debe de la cuenta 1 es: " + debeCuenta2);
            System.out.println("El valor del haber de la cuenta 1 es: " + haberCuenta2);
            return true;
        }
        if (monto < 0 && saldoDeLaCuenta2 >= -monto) {
            setDebeGeneral(debeCuenta2 + auxiliar);
            setHaberGeneral(haberCuenta2 + auxiliar2);
            setSaldoCuenta2(saldoDeLaCuenta2 + monto);
            System.out.println("El valor del debe general  es " + debeGeneral);
            System.out.println("El valor del haber general es " + haberGeneral);
            System.out.println("El valor del debe de la cuenta 2 es: " + debeCuenta2);
            System.out.println("El valor del haber de la cuenta 2 es: " + haberCuenta2);
            return true;
        }

        else {
            mensajeLabel.setText("La cuenta no posee saldo para realizar esta operacion");
            return false;}
    }
    public float saldoDeLaCuenta2() throws SQLException {
        Connection connection = getConnection();
        String query = "SELECT saldo_actual FROM cuentas WHERE codigo=" + cuenta2.getValue();
        Statement st;
        ResultSet rs;
        st = connection.createStatement();
        rs = st.executeQuery(query);
        int numero = 0;
        while (rs.next()) {
            numero = (rs.getInt(1));
        }
        return numero;
    }
    public String tipoDeCuenta2() throws SQLException {
        Connection connection = getConnection();
        String query = "SELECT tipo FROM cuentas WHERE codigo=" + cuenta2.getValue();
        Statement st;
        ResultSet rs;
        st = connection.createStatement();
        rs = st.executeQuery(query);
        String nombrecuenta = "";
        while (rs.next()) {
            nombrecuenta = (rs.getString(1));
        }
        return nombrecuenta;

    }

    public void permitirTercera(){
        cuentaPane3.setVisible(true);
        cuenta3.setDisable(false);
        montoField3.setVisible(true);
        montoField3.setDisable(false);
        agregarButton.setDisable(true);
        agregartercera.setVisible(false);
        sacartercera.setVisible(true);
    }

    public void noPermitirTercera(){
        cuentaPane3.setVisible(false);
        cuenta3.setValue(null);
        montoField3.setText("");
        nombreCuenta3.setText("");
        agregarButton.setDisable(false);
        sacartercera.setVisible(false);
        agregartercera.setVisible(true);

    }

    //ACCION VALICADCION CUENTA 3
    public void validar3() throws SQLException {
        if (validarmonto3() != true) {
            System.out.println("");
        } else {
            cuentaPane3.setDisable(true);
            mensajeLabel.setText("");
            agregarcuarta.setVisible(true);
            agregarButton.setDisable(true);
            agregarButton.setDisable(false);
            sacartercera.setVisible(false);

        }
    }

    public boolean validarmonto3() throws SQLException {
        float saldoDeLaCuenta3 = saldoDeLaCuenta3();
        String tipoDeCuenta3 = tipoDeCuenta3();
        float monto = Float.parseFloat(montoField3.getText());
        switch (tipoDeCuenta3) {
            case "Activo":
                if (monto > 0) {
                    setDebeCuenta3(monto);
                    setHaberCuenta3(0);
                } else {
                    setDebeCuenta3(0);
                    setHaberCuenta3(-monto);
                }
                break;
            case "Pasivo":
                if (monto > 0) {
                    setDebeCuenta3(0);
                    setHaberCuenta3(monto);
                } else {
                    setDebeCuenta3(-monto);
                    setHaberCuenta3(0);
                }
                break;
            case "Patrimonio":
                if (monto > 0) {
                    setDebeCuenta3(0);
                    setHaberCuenta3(monto);
                } else {
                    setDebeCuenta3(-monto);
                    setHaberCuenta3(0);
                }
                break;

            case "R+":
                if (monto >= 0) {
                    setDebeCuenta3(0);
                    setHaberCuenta3(monto);
                } else {
                    montoField3.setText("");
                    mensajeLabel.setText("R+ no va en negativo");
                    return false;
                }
                break;
            case "R-":
                if (monto >= 0) {
                    setDebeCuenta3(monto);
                    setHaberCuenta3(0);
                } else {
                    montoField1.setText("");
                    mensajeLabel.setText("R- no va en negativo");
                    return false;

                }
                break;
            default:
                break;
        }

        float auxiliar = getDebeGeneral();
        float auxiliar2 = getHaberGeneral();
        if (monto==0){
            mensajeLabel.setText("Monto igual a 0 no sirve");
            return false;
        }
        if (monto > 0) {
            setDebeGeneral(debeCuenta3 + auxiliar);
            setHaberGeneral(haberCuenta3 + auxiliar2);
            setSaldoCuenta3(saldoDeLaCuenta3 + monto);
            System.out.println("El valor del debe general  es " + debeGeneral);
            System.out.println("El valor del haber general es " + haberGeneral);
            System.out.println("El valor del debe de la cuenta 3 es: " + debeCuenta3);
            System.out.println("El valor del haber de la cuenta 3 es: " + haberCuenta3);
            return true;
        }
        if (monto < 0 && saldoDeLaCuenta3 >= -monto) {
            setDebeGeneral(debeCuenta3 + auxiliar);
            setHaberGeneral(haberCuenta3 + auxiliar2);
            setSaldoCuenta3(saldoDeLaCuenta3 + monto);
            System.out.println("El valor del debe general  es " + debeGeneral);
            System.out.println("El valor del haber general es " + haberGeneral);
            System.out.println("El valor del debe de la cuenta 3 es: " + debeCuenta3);
            System.out.println("El valor del haber de la cuenta 3 es: " + haberCuenta3);
            return true;
        } else {
            mensajeLabel.setText("La cuenta no posee saldo para realizar esta operacion");
            return false;}
    }

    public float saldoDeLaCuenta3() throws SQLException {
        Connection connection = getConnection();
        String query = "SELECT saldo_actual FROM cuentas WHERE codigo=" + cuenta3.getValue();
        Statement st;
        ResultSet rs;
        st = connection.createStatement();
        rs = st.executeQuery(query);
        int numero = 0;
        while (rs.next()) {
            numero = (rs.getInt(1));
        }
        return numero;
    }

    public String tipoDeCuenta3() throws SQLException {
        Connection connection = getConnection();
        String query = "SELECT tipo FROM cuentas WHERE codigo=" + cuenta3.getValue();
        Statement st;
        ResultSet rs;
        st = connection.createStatement();
        rs = st.executeQuery(query);
        String nombrecuenta = "";
        while (rs.next()) {
            nombrecuenta = (rs.getString(1));
        }
        return nombrecuenta;

    }


    public void permitirCuarta(){
        cuentaPane4.setVisible(true);
        cuentaPane4.setDisable(false);
        montoField4.setDisable(false);
        cuenta4.setDisable(false);
        montoField4.setVisible(true);
        agregarcuarta.setVisible(false);
        agregarButton.setDisable(true);
        sacarcuarta.setVisible(true);

    }

    public void noPermitirCuarta(){
        cuentaPane4.setVisible(false);
        cuenta4.setValue(null);
        montoField4.setText("");
        nombreCuenta4.setText("");
        agregarButton.setDisable(false);
        sacarcuarta.setVisible(false);
        agregarcuarta.setVisible(true);

    }

    //ACCION VALICADCION CUENTA  4
    public void validar4() throws SQLException {
        if (validarmonto4() != true) {
            mensajeLabel.setText("La cuenta no posee saldo para realizar esta operacion");
        } else {
            cuentaPane4.setDisable(true);
            mensajeLabel.setText("");
            agregarquinta.setVisible(true);
            agregarButton.setDisable(false);
            sacarcuarta.setVisible(false);

        }
    }

    public boolean validarmonto4() throws SQLException {
        float saldoDeLaCuenta4 = saldoDeLaCuenta4();
        String tipoDeCuenta4 = tipoDeCuenta4();
        float monto = Float.parseFloat(montoField4.getText());
        switch (tipoDeCuenta4) {
            case "Activo":
                if (monto > 0) {
                    setDebeCuenta4(monto);
                    setHaberCuenta4(0);
                } else {
                    setDebeCuenta4(0);
                    setHaberCuenta4(-monto);
                }
                break;
            case "Pasivo":
                if (monto > 0) {
                    setDebeCuenta4(0);
                    setHaberCuenta4(monto);
                } else {
                    setDebeCuenta4(-monto);
                    setHaberCuenta4(0);
                }
                break;
            case "Patrimonio":
                if (monto > 0) {
                    setDebeCuenta4(0);
                    setHaberCuenta4(monto);
                } else {
                    setDebeCuenta4(-monto);
                    setHaberCuenta4(0);
                }
                break;

            case "R+":
                if (monto >= 0) {
                    setDebeCuenta4(0);
                    setHaberCuenta4(monto);
                } else {
                    montoField4.setText("");
                    mensajeLabel.setText("R+ no va en negativo");
                    return false;
                }
                break;
            case "R-":
                if (monto >= 0) {
                    setDebeCuenta4(monto);
                    setHaberCuenta4(0);

                } else {
                    montoField4.setText("");
                    mensajeLabel.setText("R- no va en negativo");
                    return false;

                }
                break;
            default:
                break;
        }

        float auxiliar = getDebeGeneral();
        float auxiliar2 = getHaberGeneral();
        if (monto==0){
            mensajeLabel.setText("Monto igual a 0 no sirve");
            return false;
        }
        if (monto > 0) {
            setDebeGeneral(debeCuenta4 + auxiliar);
            setHaberGeneral(haberCuenta4 + auxiliar2);
            setSaldoCuenta4(saldoDeLaCuenta4 + monto);
            System.out.println("El valor del debe general  es " + debeGeneral);
            System.out.println("El valor del haber general es " + haberGeneral);
            System.out.println("El valor del debe de la cuenta 4 es: " + debeCuenta4);
            System.out.println("El valor del haber de la cuenta 4 es: " + haberCuenta4);
            return true;
        }
        if (monto < 0 && saldoDeLaCuenta4 >= -monto) {
            setDebeGeneral(debeCuenta4 + auxiliar);
            setHaberGeneral(haberCuenta4 + auxiliar2);
            setSaldoCuenta4(saldoDeLaCuenta4 + monto);
            System.out.println("El valor del debe general  es " + debeGeneral);
            System.out.println("El valor del haber general es " + haberGeneral);
            System.out.println("El valor del debe de la cuenta 4 es: " + debeCuenta4);
            System.out.println("El valor del haber de la cuenta 4 es: " + haberCuenta4);
            return true;
        } else {
            mensajeLabel.setText("La cuenta no posee saldo para realizar esta operacion");
            return false;}
    }

    public float saldoDeLaCuenta4() throws SQLException {
        Connection connection = getConnection();
        String query = "SELECT saldo_actual FROM cuentas WHERE codigo=" + cuenta4.getValue();
        Statement st;
        ResultSet rs;
        st = connection.createStatement();
        rs = st.executeQuery(query);
        int numero = 0;
        while (rs.next()) {
            numero = (rs.getInt(1));
        }
        return numero;
    }

    public String tipoDeCuenta4() throws SQLException {
        Connection connection = getConnection();
        String query = "SELECT tipo FROM cuentas WHERE codigo=" + cuenta4.getValue();
        Statement st;
        ResultSet rs;
        st = connection.createStatement();
        rs = st.executeQuery(query);
        String nombrecuenta = "";
        while (rs.next()) {
            nombrecuenta = (rs.getString(1));
        }
        return nombrecuenta;

    }

    public void permitirQuinta(){
        cuentaPane5.setVisible(true);
        cuentaPane5.setDisable(false);
        montoField5.setDisable(false);
        cuenta5.setDisable(false);
        montoField5.setVisible(true);
        agregarquinta.setVisible(false);
        agregarButton.setDisable(true);
        sacarquinta.setVisible(true);

    }
    public void noPermitirQuinta(){
        cuentaPane5.setVisible(false);
        cuenta5.setValue(null);
        montoField5.setText("");
        nombreCuenta5.setText("");
        agregarButton.setDisable(false);
        sacarquinta.setVisible(false);
        agregarquinta.setVisible(true);

    }

   /// VALIDAR 5

    public void validar5() throws SQLException {
        if (validarmonto5() != true) {
            System.out.println("");
        } else {
            cuentaPane5.setDisable(true);
            mensajeLabel.setText("");
            agregarButton.setDisable(false);
            sacarquinta.setVisible(false);
            agregarsexta.setVisible(true);
        }
    }

    public boolean validarmonto5() throws SQLException {
        float saldoDeLaCuenta5 = saldoDeLaCuenta5();
        String tipoDeCuenta5 = tipoDeCuenta5();
        float monto = Float.parseFloat(montoField5.getText());
        switch (tipoDeCuenta5()) {
            case "Activo":
                if (monto > 0) {
                    setDebeCuenta5(monto);
                    setHaberCuenta5(0);
                } else {
                    setDebeCuenta5(0);
                    setHaberCuenta5(-monto);
                }
                break;
            case "Pasivo":
                if (monto > 0) {
                    setDebeCuenta5(0);
                    setHaberCuenta5(monto);
                } else {
                    setDebeCuenta5(-monto);
                    setHaberCuenta5(0);
                }
                break;
            case "Patrimonio":
                if (monto > 0) {
                    setDebeCuenta5(0);
                    setHaberCuenta5(monto);
                } else {
                    setDebeCuenta5(-monto);
                    setHaberCuenta5(0);
                }
                break;

            case "R+":
                if (monto >= 0) {
                    setDebeCuenta5(0);
                    setHaberCuenta5(monto);
                } else {
                    montoField5.setText("");
                    mensajeLabel.setText("R+ no va en negativo");
                    return false;
                }
                break;
            case "R-":
                if (monto >= 0) {
                    setDebeCuenta5(monto);
                    setHaberCuenta5(0);

                } else {
                    montoField5.setText("");
                    mensajeLabel.setText("R- no va en negativo");
                    return false;

                }
                break;
            default:
                break;
        }

        float auxiliar = getDebeGeneral();
        float auxiliar2 = getHaberGeneral();
        if (monto==0){
            mensajeLabel.setText("Monto igual a 0 no sirve");
            return false;
        }
        if (monto > 0) {
            setDebeGeneral(debeCuenta5 + auxiliar);
            setHaberGeneral(haberCuenta5 + auxiliar2);
            setSaldoCuenta5(saldoDeLaCuenta5 + monto);
            System.out.println("El valor del debe general  es " + debeGeneral);
            System.out.println("El valor del haber general es " + haberGeneral);
            System.out.println("El valor del debe de la cuenta 5 es: " + debeCuenta5);
            System.out.println("El valor del haber de la cuenta 5 es: " + haberCuenta5);
            return true;
        }
        if (monto < 0 && saldoDeLaCuenta5 >= -monto) {
            setDebeGeneral(debeCuenta5 + auxiliar);
            setHaberGeneral(haberCuenta5 + auxiliar2);
            setSaldoCuenta5(saldoDeLaCuenta5 + monto);
            System.out.println("El valor del debe general  es " + debeGeneral);
            System.out.println("El valor del haber general es " + haberGeneral);
            System.out.println("El valor del debe de la cuenta 5 es: " + debeCuenta5);
            System.out.println("El valor del haber de la cuenta 5 es: " + haberCuenta5);
            return true;
        } else {
            mensajeLabel.setText("La cuenta no posee saldo para realizar esta operacion");
            return false;}
    }

    public float saldoDeLaCuenta5() throws SQLException {
        Connection connection = getConnection();
        String query = "SELECT saldo_actual FROM cuentas WHERE codigo=" + cuenta5.getValue();
        Statement st;
        ResultSet rs;
        st = connection.createStatement();
        rs = st.executeQuery(query);
        int numero = 0;
        while (rs.next()) {
            numero = (rs.getInt(1));
        }
        return numero;
    }

    public String tipoDeCuenta5() throws SQLException {
        Connection connection = getConnection();
        String query = "SELECT tipo FROM cuentas WHERE codigo=" + cuenta5.getValue();
        Statement st;
        ResultSet rs;
        st = connection.createStatement();
        rs = st.executeQuery(query);
        String nombrecuenta = "";
        while (rs.next()) {
            nombrecuenta = (rs.getString(1));
        }
        return nombrecuenta;

    }


    public void permitirSexta(){
        cuentaPane6.setVisible(true);
        cuentaPane6.setDisable(false);
        montoField6.setDisable(false);
        cuenta6.setDisable(false);
        montoField6.setVisible(true);
        agregarsexta.setVisible(false);
        agregarButton.setDisable(true);
        sacarsexta.setVisible(true);

    }
    public void noPermitirSexta(){
        cuentaPane6.setVisible(false);
        cuenta6.setValue(null);
        montoField6.setText("");
        nombreCuenta6.setText("");
        agregarButton.setDisable(false);
        sacarsexta.setVisible(false);
        agregarsexta.setVisible(true);

    }

    /// VALIDAR 6

    public void validar6() throws SQLException {
        if (validarmonto6() != true) {
            System.out.println("");
        } else {
            cuentaPane6.setDisable(true);
            mensajeLabel.setText("");
            agregarButton.setDisable(false);
            sacarsexta.setVisible(false);
            agregarseptima.setVisible(true);
        }
    }

    public boolean validarmonto6() throws SQLException {
        float saldoDeLaCuenta6 = saldoDeLaCuenta6();
        String tipoDeCuenta6 = tipoDeCuenta6();
        float monto = Float.parseFloat(montoField6.getText());
        switch (tipoDeCuenta6()) {
            case "Activo":
                if (monto > 0) {
                    setDebeCuenta6(monto);
                    setHaberCuenta6(0);
                } else {
                    setDebeCuenta6(0);
                    setHaberCuenta6(-monto);
                }
                break;
            case "Pasivo":
                if (monto > 0) {
                    setDebeCuenta6(0);
                    setHaberCuenta6(monto);
                } else {
                    setDebeCuenta6(-monto);
                    setHaberCuenta6(0);
                }
                break;
            case "Patrimonio":
                if (monto > 0) {
                    setDebeCuenta6(0);
                    setHaberCuenta6(monto);
                } else {
                    setDebeCuenta6(-monto);
                    setHaberCuenta6(0);
                }
                break;

            case "R+":
                if (monto >= 0) {
                    setDebeCuenta6(0);
                    setHaberCuenta6(monto);
                } else {
                    montoField6.setText("");
                    mensajeLabel.setText("R+ no va en negativo");
                    return false;
                }
                break;
            case "R-":
                if (monto >= 0) {
                    setDebeCuenta6(monto);
                    setHaberCuenta6(0);

                } else {
                    montoField6.setText("");
                    mensajeLabel.setText("R- no va en negativo");
                    return false;

                }
                break;
            default:
                break;
        }

        float auxiliar = getDebeGeneral();
        float auxiliar2 = getHaberGeneral();
        if (monto==0){
            mensajeLabel.setText("Monto igual a 0 no sirve");
            return false;
        }
        if (monto > 0) {
            setDebeGeneral(debeCuenta6 + auxiliar);
            setHaberGeneral(haberCuenta6 + auxiliar2);
            setSaldoCuenta6(saldoDeLaCuenta6 + monto);
            System.out.println("El valor del debe general  es " + debeGeneral);
            System.out.println("El valor del haber general es " + haberGeneral);
            System.out.println("El valor del debe de la cuenta 6 es: " + debeCuenta6);
            System.out.println("El valor del haber de la cuenta 6 es: " + haberCuenta6);
            return true;
        }
        if (monto < 0 && saldoDeLaCuenta6 >= -monto) {
            setDebeGeneral(debeCuenta6 + auxiliar);
            setHaberGeneral(haberCuenta6 + auxiliar2);
            setSaldoCuenta6(saldoDeLaCuenta6 + monto);
            System.out.println("El valor del debe general  es " + debeGeneral);
            System.out.println("El valor del haber general es " + haberGeneral);
            System.out.println("El valor del debe de la cuenta 6 es: " + debeCuenta6);
            System.out.println("El valor del haber de la cuenta 6 es: " + haberCuenta6);
            return true;
        } else {
            mensajeLabel.setText("La cuenta no posee saldo para realizar esta operacion");
            return false;}
    }

    public float saldoDeLaCuenta6() throws SQLException {
        Connection connection = getConnection();
        String query = "SELECT saldo_actual FROM cuentas WHERE codigo=" + cuenta6.getValue();
        Statement st;
        ResultSet rs;
        st = connection.createStatement();
        rs = st.executeQuery(query);
        int numero = 0;
        while (rs.next()) {
            numero = (rs.getInt(1));
        }
        return numero;
    }

    public String tipoDeCuenta6() throws SQLException {
        Connection connection = getConnection();
        String query = "SELECT tipo FROM cuentas WHERE codigo=" + cuenta6.getValue();
        Statement st;
        ResultSet rs;
        st = connection.createStatement();
        rs = st.executeQuery(query);
        String nombrecuenta = "";
        while (rs.next()) {
            nombrecuenta = (rs.getString(1));
        }
        return nombrecuenta;

    }



    public void permitirSeptima(){
        cuentaPane7.setVisible(true);
        cuentaPane7.setDisable(false);
        montoField7.setDisable(false);
        cuenta7.setDisable(false);
        montoField7.setVisible(true);
        agregarseptima.setVisible(false);
        agregarButton.setDisable(true);
        sacarseptima.setVisible(true);

    }
    public void noPermitirSeptima(){
        cuentaPane7.setVisible(false);
        cuenta7.setValue(null);
        montoField7.setText("");
        nombreCuenta7.setText("");
        agregarButton.setDisable(false);
        sacarseptima.setVisible(false);
        agregarseptima.setVisible(true);

    }

    /// VALIDAR 7

    public void validar7() throws SQLException {
        if (validarmonto7() != true) {
            System.out.println("");
        } else {
            cuentaPane7.setDisable(true);
            mensajeLabel.setText("");
            agregarButton.setDisable(false);
            sacarseptima.setVisible(false);
        }
    }

    public boolean validarmonto7() throws SQLException {
        float saldoDeLaCuenta7 = saldoDeLaCuenta7();
        String tipoDeCuenta7 = tipoDeCuenta7();
        float monto = Float.parseFloat(montoField7.getText());
        switch (tipoDeCuenta7()) {
            case "Activo":
                if (monto > 0) {
                    setDebeCuenta7(monto);
                    setHaberCuenta7(0);
                } else {
                    setDebeCuenta7(0);
                    setHaberCuenta7(-monto);
                }
                break;
            case "Pasivo":
                if (monto > 0) {
                    setDebeCuenta7(0);
                    setHaberCuenta7(monto);
                } else {
                    setDebeCuenta7(-monto);
                    setHaberCuenta7(0);
                }
                break;
            case "Patrimonio":
                if (monto > 0) {
                    setDebeCuenta7(0);
                    setHaberCuenta7(monto);
                } else {
                    setDebeCuenta7(-monto);
                    setHaberCuenta7(0);
                }
                break;

            case "R+":
                if (monto >= 0) {
                    setDebeCuenta7(0);
                    setHaberCuenta7(monto);
                } else {
                    montoField7.setText("");
                    mensajeLabel.setText("R+ no va en negativo");
                    return false;
                }
                break;
            case "R-":
                if (monto >= 0) {
                    setDebeCuenta7(monto);
                    setHaberCuenta7(0);

                } else {
                    montoField7.setText("");
                    mensajeLabel.setText("R- no va en negativo");
                    return false;

                }
                break;
            default:
                break;
        }

        float auxiliar = getDebeGeneral();
        float auxiliar2 = getHaberGeneral();
        if (monto==0){
            mensajeLabel.setText("Monto igual a 0 no sirve");
            return false;
        }
        if (monto > 0) {
            setDebeGeneral(debeCuenta7 + auxiliar);
            setHaberGeneral(haberCuenta7 + auxiliar2);
            setSaldoCuenta7(saldoDeLaCuenta7 + monto);
            System.out.println("El valor del debe general  es " + debeGeneral);
            System.out.println("El valor del haber general es " + haberGeneral);
            System.out.println("El valor del debe de la cuenta 7 es: " + debeCuenta7);
            System.out.println("El valor del haber de la cuenta 7 es: " + haberCuenta7);
            return true;
        }
        if (monto < 0 && saldoDeLaCuenta7 >= -monto) {
            setDebeGeneral(debeCuenta7 + auxiliar);
            setHaberGeneral(haberCuenta7 + auxiliar2);
            setSaldoCuenta7(saldoDeLaCuenta7 + monto);
            System.out.println("El valor del debe general  es " + debeGeneral);
            System.out.println("El valor del haber general es " + haberGeneral);
            System.out.println("El valor del debe de la cuenta 7 es: " + debeCuenta7);
            System.out.println("El valor del haber de la cuenta 7 es: " + haberCuenta7);
            return true;
        } else {
            mensajeLabel.setText("La cuenta no posee saldo para realizar esta operacion");
            return false;}
    }

    public float saldoDeLaCuenta7() throws SQLException {
        Connection connection = getConnection();
        String query = "SELECT saldo_actual FROM cuentas WHERE codigo=" + cuenta7.getValue();
        Statement st;
        ResultSet rs;
        st = connection.createStatement();
        rs = st.executeQuery(query);
        int numero = 0;
        while (rs.next()) {
            numero = (rs.getInt(1));
        }
        return numero;
    }

    public String tipoDeCuenta7() throws SQLException {
        Connection connection = getConnection();
        String query = "SELECT tipo FROM cuentas WHERE codigo=" + cuenta7.getValue();
        Statement st;
        ResultSet rs;
        st = connection.createStatement();
        rs = st.executeQuery(query);
        String nombrecuenta = "";
        while (rs.next()) {
            nombrecuenta = (rs.getString(1));
        }
        return nombrecuenta;

    }







    @FXML
    public void verSiDebeHaberIguales() throws SQLException, IOException {

        if( !cuenta1.getValue().equals(cuenta2.getValue())  && cuenta3.getValue()==null ) {
            registrarAsientos();
            System.out.println("Entre en la primera");

        }

        if ( !cuenta1.getValue().equals(cuenta2.getValue())  && !cuenta1.getValue().equals(cuenta3.getValue())  && !cuenta2.getValue().equals(cuenta3.getValue())
                && cuenta3.getValue()!=null && cuenta4.getValue()==null){
            registrarAsientos();
            System.out.println("Entre en la segunda");
        }
        if ( !cuenta1.getValue().equals(cuenta2.getValue()) && !cuenta1.getValue().equals(cuenta3.getValue()) &&!cuenta1.getValue().equals(cuenta4.getValue())
                && !cuenta2.getValue().equals(cuenta3.getValue()) && !cuenta2.getValue().equals(cuenta4.getValue())
                && !cuenta3.getValue().equals(cuenta4.getValue()) && cuenta4.getValue()!=null && cuenta5.getValue()==null)
        {
            registrarAsientos();
            System.out.println("Entre en la tercera");

        }
        if ( !cuenta1.getValue().equals(cuenta2.getValue()) && !cuenta1.getValue().equals(cuenta3.getValue()) &&!cuenta1.getValue().equals(cuenta4.getValue())
                &&!cuenta1.getValue().equals(cuenta5.getValue())
                && !cuenta2.getValue().equals(cuenta3.getValue()) && !cuenta2.getValue().equals(cuenta4.getValue())  && !cuenta2.getValue().equals(cuenta5.getValue())
                && !cuenta3.getValue().equals(cuenta4.getValue()) && !cuenta3.getValue().equals(cuenta5.getValue())
                && !cuenta5.getValue().equals(cuenta4.getValue()) && cuenta5.getValue()!=null && cuenta6.getValue()==null) {
            registrarAsientos();
            System.out.println("Entre en la cuarta");
        }
        if ( !cuenta1.getValue().equals(cuenta2.getValue()) && !cuenta1.getValue().equals(cuenta3.getValue()) &&!cuenta1.getValue().equals(cuenta4.getValue())
                &&!cuenta1.getValue().equals(cuenta5.getValue()) &&!cuenta1.getValue().equals(cuenta6.getValue())
                && !cuenta2.getValue().equals(cuenta3.getValue()) && !cuenta2.getValue().equals(cuenta4.getValue())  && !cuenta2.getValue().equals(cuenta5.getValue())
                && !cuenta2.getValue().equals(cuenta6.getValue())
                && !cuenta3.getValue().equals(cuenta4.getValue()) && !cuenta3.getValue().equals(cuenta5.getValue())
                && !cuenta3.getValue().equals(cuenta6.getValue())
                && !cuenta4.getValue().equals(cuenta6.getValue()) && !cuenta4.getValue().equals(cuenta5.getValue())
                && !cuenta5.getValue().equals(cuenta6.getValue())
                && cuenta6.getValue()!=null
                && cuenta7.getValue()==null) {
            registrarAsientos();
            System.out.println("Entre en la quinta");
        }

        if ( !cuenta1.getValue().equals(cuenta2.getValue()) && !cuenta1.getValue().equals(cuenta3.getValue()) &&!cuenta1.getValue().equals(cuenta4.getValue())
                &&!cuenta1.getValue().equals(cuenta5.getValue()) &&!cuenta1.getValue().equals(cuenta6.getValue()) &&!cuenta1.getValue().equals(cuenta7.getValue())
                && !cuenta2.getValue().equals(cuenta3.getValue()) && !cuenta2.getValue().equals(cuenta4.getValue())  && !cuenta2.getValue().equals(cuenta5.getValue())
                && !cuenta2.getValue().equals(cuenta6.getValue()) && !cuenta2.getValue().equals(cuenta7.getValue())
                && !cuenta3.getValue().equals(cuenta4.getValue()) && !cuenta3.getValue().equals(cuenta5.getValue())
                && !cuenta3.getValue().equals(cuenta6.getValue()) && !cuenta3.getValue().equals(cuenta7.getValue())
                && !cuenta4.getValue().equals(cuenta6.getValue()) && !cuenta4.getValue().equals(cuenta5.getValue()) && !cuenta4.getValue().equals(cuenta7.getValue())
                && !cuenta5.getValue().equals(cuenta6.getValue()) && !cuenta5.getValue().equals(cuenta7.getValue())
                && !cuenta6.getValue().equals(cuenta7.getValue())
                && cuenta7.getValue()!=null) {
            registrarAsientos();
            System.out.println("Entre en la sexta");
        }

        else {
            mensajeLabel.setText("Las cuentas de deben repetirse");
            noCumplePartidaDoble();
        }
    }

    public void registrarAsientos() throws SQLException, IOException {
            if ( debeGeneral == haberGeneral) {
            String querry1 = "insert into asientos(fecha,descripcion,idusuario ) values( now(),'" + descripcionArea.getText() + "'," + getIdUsuario() + ")";
            String querry2 = "insert into cuenta_asiento(idcuenta,idasiento,debe,haber,saldo) values(" + cuenta1.getValue() + "," + valorIDAsiento() + "," + debeCuenta1 + "," + haberCuenta1 + "," + getSaldoCuenta1() + ")";
            String querry3 = "insert into cuenta_asiento(idcuenta,idasiento,debe,haber,saldo) values(" + cuenta2.getValue() + "," + valorIDAsiento() + "," + debeCuenta2 + "," + haberCuenta2 + "," + getSaldoCuenta2() + ")";
            String querry4 = "UPDATE cuentas SET saldo_actual=" + getSaldoCuenta1() + " WHERE codigo=" + cuenta1.getValue();
            String querry5 = "UPDATE cuentas SET saldo_actual=" + getSaldoCuenta2() + " WHERE codigo=" + cuenta2.getValue();
            String querry6="";
            String querry7="";
            String querry8="";
            String querry9="";
            String querry10= "";
            String querry11="";
            String querry12="";
            String querry13= "";
            String querry14="";
            String querry15="";
            if(!montoField3.getText().isEmpty()){
                querry6 = "insert into cuenta_asiento(idcuenta,idasiento,debe,haber,saldo) values(" + cuenta3.getValue() + "," + valorIDAsiento() + "," + debeCuenta3 + "," + haberCuenta3 + "," + getSaldoCuenta3() + ")";
                querry7 = "UPDATE cuentas SET saldo_actual=" + getSaldoCuenta3() + " WHERE codigo=" + cuenta3.getValue();
            }
            if(!montoField4.getText().isEmpty()){
                querry8 = "insert into cuenta_asiento(idcuenta,idasiento,debe,haber,saldo) values(" + cuenta4.getValue() + "," + valorIDAsiento() + "," + debeCuenta4 + "," + haberCuenta4 + "," + getSaldoCuenta4() + ")";
                querry9 = "UPDATE cuentas SET saldo_actual=" + getSaldoCuenta4() + " WHERE codigo=" + cuenta4.getValue();
            }
            if(!montoField5.getText().isEmpty()){
                 querry10 = "insert into cuenta_asiento(idcuenta,idasiento,debe,haber,saldo) values(" + cuenta5.getValue() + "," + valorIDAsiento() + "," + debeCuenta5 + "," + haberCuenta5 + "," + getSaldoCuenta5() + ")";
                 querry11 = "UPDATE cuentas SET saldo_actual=" + getSaldoCuenta5() + " WHERE codigo=" + cuenta5.getValue();
            }
            if(!montoField6.getText().isEmpty()){
                    querry12 = "insert into cuenta_asiento(idcuenta,idasiento,debe,haber,saldo) values(" + cuenta6.getValue() + "," + valorIDAsiento() + "," + debeCuenta6 + "," + haberCuenta6 + "," + getSaldoCuenta6() + ")";
                    querry13 = "UPDATE cuentas SET saldo_actual=" + getSaldoCuenta6() + " WHERE codigo=" + cuenta6.getValue();
                }
            if(!montoField7.getText().isEmpty()){
                    querry14 = "insert into cuenta_asiento(idcuenta,idasiento,debe,haber,saldo) values(" + cuenta7.getValue() + "," + valorIDAsiento() + "," + debeCuenta7 + "," + haberCuenta7 + "," + getSaldoCuenta7() + ")";
                    querry15 = "UPDATE cuentas SET saldo_actual=" + getSaldoCuenta7() + " WHERE codigo=" + cuenta7.getValue();
                }

            executeQuery(querry1);
            executeQuery(querry2);
            executeQuery(querry3);
            executeQuery(querry4);
            executeQuery(querry5);
            executeQuery(querry6);
            executeQuery(querry7);
            executeQuery(querry8);
            executeQuery(querry9);
            executeQuery(querry10);
            executeQuery(querry11);
            executeQuery(querry12);
            executeQuery(querry13);
            executeQuery(querry14);
            executeQuery(querry15);
            mostrarAsientosRegistrados();

        }else {
                mensajeLabel.setText("El asiento no cumple con la partida doble");
                noCumplePartidaDoble();
            }


    }

    public void mostrarAsientosRegistrados() throws IOException {
        Stage stage = (Stage) agregarButton.getScene().getWindow();
        stage.close();
        Parent root1 = FXMLLoader.load(getClass().getResource("MuestraAsientoRegistrado.fxml"));
        Stage stage2 = new Stage();
        stage2.initModality(Modality.APPLICATION_MODAL);
        stage2.setTitle("Asientos");
        stage2.setScene(new Scene(root1));
        stage2.show();
        File rmgFile = new File("circle-cropped.png");
        Image rmgImage = new Image(rmgFile.toURI().toString());
        stage2.getIcons().add(rmgImage);
    }


    public void datosUsuarioActual() {

        Connection connection = getConnection();
        String query = "select u.id from usuario_actual ua INNER JOIN usuarios u on ua.nombre = u.nombre and ua.rol = u.rol where actual=(select max(actual) from usuario_actual);";
        Statement st;
        ResultSet rs;
        try {
            st = connection.createStatement();
            rs = st.executeQuery(query);
            AsientoCuenta asientoCuenta;
            while (rs.next()){
                setIdUsuario(rs.getInt("id"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public void noCumplePartidaDoble(){

        montoField1.setText("");
        montoField2.setText("");
        montoField3.setText("");
        montoField4.setText("");
        montoField5.setText("");
        montoField6.setText("");
        montoField7.setText("");
        cuentaPane1.setDisable(false);
        cuentaPane3.setVisible(false);
        cuentaPane3.setDisable(false);
        cuentaPane4.setDisable(false);
        cuentaPane4.setVisible(false);
        cuentaPane5.setVisible(false);
        cuentaPane5.setDisable(false);
        cuentaPane6.setVisible(false);
        cuentaPane6.setDisable(false);
        cuentaPane7.setVisible(false);
        cuentaPane7.setDisable(false);
        cuenta1.setValue(null);
        cuenta2.setValue(null);
        cuenta3.setValue(null);
        cuenta4.setValue(null);
        cuenta5.setValue(null);
        cuenta6.setValue(null);
        cuenta7.setValue(null);
        nombreCuenta1.setText("");
        nombreCuenta2.setText("");
        nombreCuenta3.setText("");
        nombreCuenta4.setText("");
        nombreCuenta5.setText("");
        nombreCuenta6.setText("");
        nombreCuenta7.setText("");
        setHaberGeneral(0);
        setDebeGeneral(0);
        setSaldoCuenta1(0);
        setSaldoCuenta2(0);
        setSaldoCuenta3(0);
        setSaldoCuenta4(0);
        setSaldoCuenta5(0);
        setSaldoCuenta6(0);
        setSaldoCuenta7(0);
        agregarButton.setDisable(true);
        agregartercera.setVisible(false);
        agregarcuarta.setVisible(false);
        agregarquinta.setVisible(false);
        agregarsexta.setVisible(false);
        agregarseptima.setVisible(false);
        sacartercera.setVisible(false);
        sacarcuarta.setVisible(false);
        sacarquinta.setVisible(false);
        sacarsexta.setVisible(false);
        sacarseptima.setVisible(false);
    }





}



