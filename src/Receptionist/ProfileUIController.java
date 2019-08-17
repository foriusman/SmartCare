/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Receptionist;

import Administrator.*;
import com.jfoenix.controls.JFXTextArea;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.shape.SVGPath;
import javafx.scene.text.Text;
import org.controlsfx.control.Rating;

/**
 * FXML Controller class
 *
 * @author -USER
 */
public class ProfileUIController implements Initializable {

    @FXML
    private Label note;
    @FXML
    private Rating rating;
    @FXML
    private Text userName;
    @FXML
    private Text userPost;
    @FXML
    private Text userID;
    @FXML
    private Text userDepartment;
    @FXML
    private Text userSepcialization;
    @FXML
    private Label userMobile;
    @FXML
    private JFXTextArea userAddress;
    @FXML
    private Label userEmail;
    @FXML
    private Label userGender;
    @FXML
    private Label userStaffing;
    @FXML
    private Label userEY;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    
}
