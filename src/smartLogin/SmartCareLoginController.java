/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartLogin;

import com.gn.GNAvatarView;
import smartCareDataBase.DatabaseHandler;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

/**
 * FXML Controller class
 *
 * @author -USER
 */

public class SmartCareLoginController implements Initializable {
 DatabaseHandler data = null;
    @FXML
    private GNAvatarView avatar;
    @FXML
    private HBox box_username;
    @FXML
    private TextField username;
    @FXML
    private HBox box_password;
    @FXML
    private PasswordField password;
    @FXML
    private Button login;
    @FXML
    private Label lbl_error;
    @FXML
    private Label lbl_username;
    @FXML
    private Label lbl_password;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        data = new DatabaseHandler();
        // TODO
    }    

    @FXML
    private void loginAction(ActionEvent event) {
    }
    
}
