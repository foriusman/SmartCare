/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartLogin;

import java.io.IOException;
import smartCareDataBase.DatabaseHandler;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.image.Image;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import com.gn.GNAvatarView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
    private Label lbl_error;
    @FXML
    private Label lbl_username;
    @FXML
    private Label lbl_password;
    private StackPane loginpane;
    @FXML
    private FlowPane errorDisplay;
    @FXML
    private Button login;
    @FXML
    private StackPane mainloginStack;
     Administrator.AdministratorUIController p = new Administrator.AdministratorUIController();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        data = new DatabaseHandler();
      
        
        // TODO
    } 
    

        void Exit() throws IOException {
            Stage stage = (Stage) mainloginStack.getScene().getWindow();
            stage.close();
    }

    @FXML
    private void loginAction(ActionEvent event) {
        String userID ="Admin";
        String userPs ="local";
        String userID2 ="Rep";
        String userPs2 ="local";
        String loginID = username.getText();
        String loginPs = password.getText();
                if (loginID.equals(userID) && loginPs.equals(userPs)){
                  try    {  // Image image = new Image("logo.png");
                            Parent root = FXMLLoader.load(getClass().getResource("/Administrator/AdministratorUI.fxml"));
                               Scene scene1 = new Scene(root);
                                Stage stage = new Stage(StageStyle.DECORATED);
                                    stage.setScene(scene1);
                                    //stage.getIcons().add(image);
                                    Image image = new Image("file:logo.png");
                                        stage.getIcons().add(image);
                                    stage.setTitle("Smart Care Software");
                                    stage.show();
                                    //p.setUser(userPs, userID);
                                    //p.setUser(userID,userPs);
                                   username.clear();
                                    password.clear();
                                    //loginpane.getScene().getWindow().hide();
                                    mainloginStack.getScene().getWindow().hide();
                                    Exit();
                                    
                                 
                        }
                            catch(Exception e){
                                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                   alert.setHeaderText(null);
                                   alert.setContentText(e.getMessage());
                                   System.out.print("Erorr in Closing");
                                   alert.showAndWait();

                               }
        
                } else  if (loginID.equals(userID2) && loginPs.equals(userPs2)){
                  try    {  // Image image = new Image("logo.png");
                            Parent root = FXMLLoader.load(getClass().getResource("/Receptionist/ReceptionistUI.fxml"));
                               Scene scene1 = new Scene(root);
                                Stage stage = new Stage(StageStyle.DECORATED);
                                    stage.setScene(scene1);
                                    //stage.getIcons().add(image);
                                    Image image = new Image("file:logo.png");
                                        stage.getIcons().add(image);
                                    stage.setTitle("Smart Care Software");
                                    stage.show();
                                    //p.setUser(userID,userPs);
                                   username.clear();
                                    password.clear();
                                    //loginpane.getScene().getWindow().hide();
                                    mainloginStack.getScene().getWindow().hide();
                                    Exit();
                                    
                                 
                        }
                            catch(Exception e){
                                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                   alert.setHeaderText(null);
                                   alert.setContentText(e.getMessage());
                                   System.out.print("Erorr in Closing");
                                   alert.showAndWait();

                               }
        
                }else {
//                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
//                        alert.setHeaderText(null);
//                        alert.setContentText("Invalid password or Username");
//                        alert.showAndWait();
                        lbl_error.setVisible(true);
        }
    }
    
}
