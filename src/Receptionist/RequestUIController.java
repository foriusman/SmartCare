/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Receptionist;

import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author -USER
 */
public class RequestUIController implements Initializable {

    @FXML
    private JFXTextField requestTitleF;
    @FXML
    private JFXTextArea requestContentF;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void getClearField(ActionEvent event) {
        requestTitleF.clear();
        requestContentF.clear();
    }

    @FXML
    private void getSendRequest(ActionEvent event) {
    }
    
}
