package sample;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.ResourceBundle;

public class ControllerLibroDiario implements Initializable {

    @FXML
    private Button atrasButton;
    @FXML
    private Button buscarButton;
    @FXML
    private DatePicker fechaInicial;
    @FXML
    private DatePicker fechaFinal;
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
    private ImageView pdfImagen;



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

    public void buscar(){
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
        String query = "SELECT nombre,fecha,descripcion,debe,haber,saldo FROM asientos a INNER JOIN cuenta_asiento ca on(a.id=ca.idasiento) INNER JOIN cuentas c on (ca.idcuenta=c.codigo) WHERE fecha>= '"+fechaInicial.getValue()+"' and fecha<= '"+fechaFinal.getValue()+"' ORDER BY fecha,idasiento;";
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
        TableView.setItems(list);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        showAsientosInicial();

        File marrogiusFile = new File("pngwing.PNG");
        javafx.scene.image.Image marrogiusImage = new javafx.scene.image.Image(marrogiusFile.toURI().toString());
        pdfImagen.setImage(marrogiusImage);
    }

    public void showAsientosInicial() {
        ObservableList<AsientoCuenta> list = getAsientoCuentaListInicial();
        nombreColumn.setCellValueFactory(new PropertyValueFactory<AsientoCuenta, String>("nombre"));
        fechaColumn.setCellValueFactory(new PropertyValueFactory<AsientoCuenta, Date>("fecha"));
        descripcionColumn.setCellValueFactory(new PropertyValueFactory<AsientoCuenta,String>("descripcion"));
        debeColumn.setCellValueFactory(new PropertyValueFactory<AsientoCuenta,Float>("debe"));
        haberColumn.setCellValueFactory(new PropertyValueFactory<AsientoCuenta,Float>("haber"));
        TableView.setItems(list);
    }

    public ObservableList<AsientoCuenta> getAsientoCuentaListInicial(){
        ObservableList<AsientoCuenta> asientosList = FXCollections.observableArrayList();
        Connection connection = getConnection();
        String query = "SELECT nombre,fecha,descripcion,debe,haber,saldo FROM asientos a INNER JOIN cuenta_asiento ca on(a.id=ca.idasiento) INNER JOIN cuentas c on (ca.idcuenta=c.codigo) ORDER BY fecha,idasiento;";
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


    public void pdfs()
            throws Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/prueba?useTimezone=true&serverTimezone=UTC", "root", "sanlorenzo");
            Statement stmt = con.createStatement();
            /* Define the SQL query */
            /* Step-2: Initialize PDF documents - logical objects */
            Document my_pdf_report = new Document();
            PdfWriter.getInstance(my_pdf_report, new FileOutputStream("C:\\Users\\Usuario\\Desktop\\LibroDiario Pdf.pdf"));

            my_pdf_report.open();

            String query = "SELECT nombre,fecha,descripcion,debe,haber,saldo FROM asientos a INNER JOIN cuenta_asiento ca on(a.id=ca.idasiento) INNER JOIN cuentas c on (ca.idcuenta=c.codigo) WHERE fecha>= '"+fechaInicial.getValue()+"' and fecha<= '"+fechaFinal.getValue()+"' ORDER BY fecha,idasiento;";
            Statement st;
            ResultSet rs;
            st = con.createStatement();
            rs = st.executeQuery(query);

            //we have four columns in our table
            PdfPTable my_report_table = new PdfPTable(5);
            my_report_table.addCell("Nombre");
            my_report_table.addCell("Fecha");
            my_report_table.addCell("Descripcion");
            my_report_table.addCell("Debe");
            my_report_table.addCell("Haber");
            //create a cell object
            PdfPCell table_cell;


            while (rs.next()) {
                String dept_id = rs.getString("nombre");
                table_cell = new PdfPCell(new Phrase(dept_id));
                my_report_table.addCell(table_cell);
                String dept_name = rs.getString("fecha");
                table_cell = new PdfPCell(new Phrase(dept_name));
                my_report_table.addCell(table_cell);
                String manager_id = rs.getString("descripcion");
                table_cell = new PdfPCell(new Phrase(manager_id));
                my_report_table.addCell(table_cell);
                String manager_id1 = rs.getString("debe");
                table_cell = new PdfPCell(new Phrase(manager_id1));
                my_report_table.addCell(table_cell);
                String manager_id2 = rs.getString("haber");
                table_cell = new PdfPCell(new Phrase(manager_id2));
                my_report_table.addCell(table_cell);

            }
            /* Attach report table to PDF */

            Paragraph fecha = new Paragraph("29/10/2020");
            fecha.setAlignment(Element.ALIGN_RIGHT);

            Paragraph titulo =new Paragraph("                              Mathcop   \n",
                    FontFactory.getFont("Century",
                            23,
                            java.awt.Font.BOLD,
                            BaseColor.BLACK)
            );



            Paragraph cuerpo = new Paragraph("                              Direccion: Monteagudo 2772,Pergamino,Buenos Aires\n" +
                    "                              Contacto: 02477-421797 / empresa@mathcop.com\n" +
                    "                              CUIT 03-123452-6\n \n\n" +
                    "______________________________________________________________________________\n\n",
                    FontFactory.getFont("Century",
                            12,
                            java.awt.Font.ITALIC));


            Paragraph nombre =new Paragraph("Libro Diario\n \n",
                    FontFactory.getFont("Century",
                            20,
                            java.awt.Font.BOLD,
                            BaseColor.BLACK));

            Paragraph finalito= new Paragraph("Desde: "+fechaInicial.getValue()+" hasta:"+ fechaFinal.getValue()+"\n",
                    FontFactory.getFont("Century",
                            13));

            com.itextpdf.text.Image imagen = com.itextpdf.text.Image.getInstance("pdf.png");
            imagen.setAbsolutePosition(5f, 660f);


            my_pdf_report.add(titulo);
            my_pdf_report.add(fecha);
            my_pdf_report.add(cuerpo);
            my_pdf_report.add(nombre);
            my_pdf_report.add(finalito);
            my_pdf_report.add(imagen);


            my_pdf_report.add(my_report_table);
            my_pdf_report.close();

            /* Close all DB related objects */
            rs.close();
            stmt.close();
            con.close();


        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (DocumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }



}
