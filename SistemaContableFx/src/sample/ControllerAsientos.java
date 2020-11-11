package sample;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
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

import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.ResourceBundle;

public class ControllerAsientos implements Initializable  {

    @FXML
    private TableView<Asientos> TableView;

    @FXML
    private TableColumn<Asientos, Date> fechaColumn;

    @FXML
    private TableColumn<Asientos, Integer> nroAsientoColumn;

    @FXML
    private TableColumn<Asientos, String> descripcionColumn;

    @FXML
    private Button pdfButton;

    @FXML
    private Button agregarAsientoButton;

    @FXML
    private Button salirButton;

    @FXML
    private ImageView imagaPdf;

    @FXML
    private ImageView marrogiusImageView;

    @FXML
    private Button verendetalleButton;


    public ControllerAsientos() {
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
            Stage stage = (Stage) agregarAsientoButton.getScene().getWindow();
            Parent root1 = FXMLLoader.load(getClass().getResource("RegistrarAsiento.fxml"));
            Stage stage2 = new Stage();
            stage2.initModality(Modality.APPLICATION_MODAL);
            stage2.setTitle("Registrar Asientos");
            stage2.setScene(new Scene(root1));
            stage2.show();
            stage.close();
            File rmgFile = new File("circle-cropped.png");
            javafx.scene.image.Image rmgImage = new javafx.scene.image.Image(rmgFile.toURI().toString());
            stage2.getIcons().add(rmgImage);
    }

    public ObservableList<Asientos> getAsientosList(){
        ObservableList<Asientos> asientosList = FXCollections.observableArrayList();
        Connection connection = getConnection();
        String query = "SELECT * FROM asientos ";
        Statement st;
        ResultSet rs;
        try {
            st = connection.createStatement();
            rs = st.executeQuery(query);
            Asientos asientos;
            while(rs.next()) {
                asientos = new Asientos(rs.getInt("id"),rs.getDate("fecha"),rs.getString("descripcion"),rs.getInt("idusuario"));
                asientosList.add(asientos);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return asientosList;
    }

    public void showAsientos() {
        ObservableList<Asientos> list = getAsientosList();
        nroAsientoColumn.setCellValueFactory(new PropertyValueFactory<Asientos,Integer>("id"));
        fechaColumn.setCellValueFactory(new PropertyValueFactory<Asientos,Date>("fecha"));
        descripcionColumn.setCellValueFactory(new PropertyValueFactory<Asientos,String>("descripcion"));
        TableView.setItems(list);
    }

    public void initialize(URL location, ResourceBundle resources) {
        File pdfFile = new File("pngwing.png");
        Image pdfImage = new Image(pdfFile.toURI().toString());
        imagaPdf.setImage(pdfImage);

        File marrogiusFile = new File("algo.PNG");
        Image marrogiusImage = new Image(marrogiusFile.toURI().toString());
        marrogiusImageView.setImage(marrogiusImage);

        showAsientos();
    }

    @FXML
    private void verendetalleOnAction (ActionEvent event) throws IOException {
        Stage stage = (Stage) agregarAsientoButton.getScene().getWindow();
        Parent root1 = FXMLLoader.load(getClass().getResource("VerAsientoDetalle.fxml"));
        Stage stage2 = new Stage();
        stage2.initModality(Modality.APPLICATION_MODAL);
        stage2.setTitle("Detalle Asiento");
        stage2.setScene(new Scene(root1));
        stage2.show();
        stage.close();
        File rmgFile = new File("circle-cropped.png");
        javafx.scene.image.Image rmgImage = new javafx.scene.image.Image(rmgFile.toURI().toString());
        stage2.getIcons().add(rmgImage);
    }


    public void pdfs()
            throws Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/prueba?useTimezone=true&serverTimezone=UTC", "root", "sanlorenzo");
            Statement stmt = con.createStatement();
            /* Define the SQL query */
            ResultSet query_set = stmt.executeQuery("SELECT * From asientos");
            /* Step-2: Initialize PDF documents - logical objects */
            Document my_pdf_report = new Document();
            PdfWriter.getInstance(my_pdf_report, new FileOutputStream("C:\\Users\\Usuario\\Desktop\\Asientos Pdf.pdf"));



            my_pdf_report.open();

            //we have four columns in our table
            PdfPTable my_report_table = new PdfPTable(3);
            my_report_table.addCell("ID");
            my_report_table.addCell("Fecha");
            my_report_table.addCell("Descripcion");
            //create a cell object
            PdfPCell table_cell;


            while (query_set.next()) {
                String dept_id = query_set.getString("id");
                table_cell = new PdfPCell(new Phrase(dept_id));
                my_report_table.addCell(table_cell);
                String dept_name = query_set.getString("fecha");
                table_cell = new PdfPCell(new Phrase(dept_name));
                my_report_table.addCell(table_cell);
                String manager_id = query_set.getString("descripcion");
                table_cell = new PdfPCell(new Phrase(manager_id));
                my_report_table.addCell(table_cell);

            }
            /* Attach report table to PDF */

            Paragraph fecha = new Paragraph("29/10/2020");
            fecha.setAlignment(Element.ALIGN_RIGHT);

            Paragraph titulo =new Paragraph("                              Mathcop   \n",
                    FontFactory.getFont("Century",
                            23,
                            Font.BOLD,
                            BaseColor.BLACK)
            );



            Paragraph cuerpo = new Paragraph("                              Direccion: Monteagudo 2772,Pergamino,Buenos Aires\n" +
                    "                              Contacto: 02477-421797 / empresa@mathcop.com\n" +
                    "                              CUIT 03-123452-6\n \n\n" +
                    "______________________________________________________________________________\n\n",
                    FontFactory.getFont("Century",
                            12,
                            java.awt.Font.ITALIC));


            Paragraph nombre =new Paragraph("Asientos\n \n",
                    FontFactory.getFont("Century",
                            20,
                            Font.BOLD,
                            BaseColor.BLACK));


            com.itextpdf.text.Image imagen = com.itextpdf.text.Image.getInstance("pdf.png");
            imagen.setAbsolutePosition(5f, 660f);


            my_pdf_report.add(titulo);
            my_pdf_report.add(fecha);
            my_pdf_report.add(cuerpo);
            my_pdf_report.add(nombre);
            my_pdf_report.add(imagen);


            my_pdf_report.add(my_report_table);
            my_pdf_report.close();

            /* Close all DB related objects */
            query_set.close();
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



