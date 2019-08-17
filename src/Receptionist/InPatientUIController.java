/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Receptionist;

import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author -USER
 */
public class InPatientUIController implements Initializable {

    @FXML
    private TableView<?> inpatientTableview;
    @FXML
    private TableColumn<?, ?> snC;
    @FXML
    private TableColumn<?, ?> patientidC;
    @FXML
    private TableColumn<?, ?> pnameC;
    @FXML
    private TableColumn<?, ?> genderC;
    @FXML
    private TableColumn<?, ?> wardC;
    @FXML
    private TableColumn<?, ?> roomNoC;
    @FXML
    private TableColumn<?, ?> statusC;
    @FXML
    private TableColumn<?, ?> addDC;
    @FXML
    private TableColumn<?, ?> disCharegeC;
    @FXML
    private JFXTextField searchBar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void getSearchResult(ActionEvent event) {
    }

    @FXML
    private void getRefreshed(ActionEvent event) {
    }
    
}
