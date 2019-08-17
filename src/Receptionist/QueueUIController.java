/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Receptionist;

import com.gn.GNAvatarView;
import java.net.URL;
import java.sql.Blob;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.shape.SVGPath;
import javafx.scene.text.Text;
import smartCareDataBase.DatabaseHandler;

/**
 * FXML Controller class
 *
 * @author -USER
 */
public class QueueUIController implements Initializable {
     DatabaseHandler data = null;
    @FXML
    private HBox searchBox;
    @FXML
    private TextField Search;
    @FXML
    private SVGPath searchIcon;
    @FXML
    private GNAvatarView imgDisplay;
    @FXML
    private Text patientNameD;
    @FXML
    private Text patientRank;
    @FXML
    private Text patientIDD;
    @FXML
    private Text patDepartment;
    @FXML
    private TableView<?> queueTableView;
    @FXML
    private TableColumn<?, ?> snC;
    @FXML
    private TableColumn<?, ?> PatientIDC;
    @FXML
    private TableColumn<?, ?> PatientNameC;
    @FXML
    private TableColumn<?, ?> timeC;
    @FXML
    private TableColumn<?, ?> statusC;
    @FXML
    private TableColumn<?, ?> dateC;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        data = DatabaseHandler.getInstance();
    }    

    @FXML
    private void clearText(MouseEvent event) {
    }

    @FXML
    private void getPatientProInfo(ActionEvent event) {
        String searchKey = Search.getText();
String sql ="select * from patient where paitentID='"+searchKey+"'";
ResultSet rp2 = data.executeQuery(sql);
		 String name = "";
                 String rank = "";
                 String  id= "";
                 String  department = "";
                 Blob img;
   try{
              while(rp2.next()){
                 id = rp2.getString("paitentID");
                name = rp2.getString("Pname");
                  rank = rp2.getString("rankP");
                  department = rp2.getString("paitentDpt");
                  img= rp2.getBlob("pimg");
                 // InputStream binaryStream = img.getBinaryStream(0, img.length());
                
              }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

 if(!id.equals("")){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("Patent Found");
            alert.showAndWait();
            patientNameD.setText(name);
            patientRank.setText(rank);
            patientIDD.setText(id);
            patDepartment.setText(department);
           // imgDisplay.setImagePattern(imagePattern);
        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText(null);
            alert.setContentText("Patient Not Found");
            alert.showAndWait();
        } 
    }

    @FXML
    private void getAddPatienttoQ(ActionEvent event) {
    }
    
}
