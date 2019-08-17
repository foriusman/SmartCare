/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administrator;

import com.jfoenix.controls.JFXComboBox;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.KeyEvent;

/**
 * FXML Controller class
 *
 * @author -USER
 */
public class AdminRequestUIController implements Initializable {

    @FXML
    private TableColumn<?, ?> snC;
    @FXML
    private TableColumn<?, ?> timeC;
    @FXML
    private TableView<?> requestTableView;
    @FXML
    private TableColumn<?, ?> staffidC;
    @FXML
    private TableColumn<?, ?> titleC;
    @FXML
    private TableColumn<?, ?> postC;
    @FXML
    private TableColumn<?, ?> titleC1;
    @FXML
    private TableColumn<?, ?> timeC1;
    @FXML
    private TableColumn<?, ?> postC1;
    @FXML
    private TableColumn<?, ?> postC11;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void getSearchResult(KeyEvent event) {
    }
    
}
