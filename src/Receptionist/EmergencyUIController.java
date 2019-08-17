/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Receptionist;

import com.gn.GNAvatarView;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.shape.SVGPath;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author -USER
 */
public class EmergencyUIController implements Initializable {

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
    }    

    @FXML
    private void clearText(MouseEvent event) {
    }

    @FXML
    private void getPatientProInfo(ActionEvent event) {
    }

    @FXML
    private void getAddPatienttoQ(ActionEvent event) {
    }
    
}
