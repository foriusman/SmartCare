 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administrator;

import com.gn.GNAvatarView;
import com.jfoenix.controls.JFXBadge;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author -USER
 */
public class AdministratorUIController implements Initializable {

    @FXML
    private BorderPane main;
    @FXML
    private VBox drawer;
    @FXML
    private Label unDisplay;
    @FXML
    private ToggleGroup statusGroup;
    @FXML
    private ScrollPane scroll;
    @FXML
    private VBox views;
    @FXML
    private TitledPane staff;
    @FXML
    private TitledPane record;
    @FXML
    private TitledPane controls;
    @FXML
    private TitledPane charts;
    @FXML
    private Text title;
    @FXML
    private JFXBadge notifications;
    @FXML
    private JFXBadge messages;
    @FXML
    private StackPane stackDisplay;
    @FXML
    private MenuButton userLogDis;
    @FXML
    private GNAvatarView userImageLog;
    @FXML
    private StackPane rootPane;
    public String userIDstored=" ";

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @FXML
    private void getDashboardUI(ActionEvent event) throws IOException {
               StackPane box = FXMLLoader.load(getClass().getResource("AdminDashBoard.fxml"));
                stackDisplay.getChildren().setAll(box);
                title.setText("Admin Dashboard");
    }

    @FXML
    private void getCreateStaff(ActionEvent event) throws IOException {
         StackPane box2 = FXMLLoader.load(getClass().getResource("CreateStaffUI.fxml"));
                stackDisplay.getChildren().setAll(box2);
                title.setText("Create New Staff");
    }

    @FXML
    private void getProfileUI(ActionEvent event) throws IOException {
           StackPane box8 = FXMLLoader.load(getClass().getResource("userProfileUI.fxml"));
                stackDisplay.getChildren().setAll(box8);
                title.setText("Profile");
    }

    @FXML
    private void animateButtons(MouseEvent event) {
    }

    @FXML
    private void getRequestUI(ActionEvent event) throws IOException {
        StackPane box3 = FXMLLoader.load(getClass().getResource("AdminRequestUI.fxml"));
                stackDisplay.getChildren().setAll(box3);
                title.setText("User Request Table View ");
    }

    @FXML
    private void alerts(MouseEvent event) {
    }

    @FXML
    private void getInventUI(ActionEvent event) throws IOException {
        StackPane box4 = FXMLLoader.load(getClass().getResource("AdminInventRecUI.fxml"));
                stackDisplay.getChildren().setAll(box4);
                title.setText("Inventory Table View ");
    }

    @FXML
    private void banners(MouseEvent event) {
    }

    @FXML
    private void getStaffRecUI(ActionEvent event) throws IOException {
        StackPane box5 = FXMLLoader.load(getClass().getResource("staffRecordUI.fxml"));
                stackDisplay.getChildren().setAll(box5);
                title.setText("Staff Record Table View ");
        
    }

    @FXML
    private void getStaffAttRecUI(ActionEvent event) throws IOException {
        StackPane box9 = FXMLLoader.load(getClass().getResource("attendenceUI.fxml"));
                stackDisplay.getChildren().setAll(box9);
                title.setText("Staff Attendence");
    }

    @FXML
    private void buttons(MouseEvent event) {
    }

    @FXML
    private void getNoticeUI(ActionEvent event) throws IOException {
        StackPane box6 = FXMLLoader.load(getClass().getResource("AdminNoticeUI.fxml"));
                stackDisplay.getChildren().setAll(box6);
                title.setText("Notice ");
       
    }

    @FXML
    private void checkBox(MouseEvent event) {
    }

    @FXML
    private void getMprofile(ActionEvent event) throws IOException {
            StackPane box8 = FXMLLoader.load(getClass().getResource("mgtProfileUI.fxml"));
                stackDisplay.getChildren().setAll(box8);
                title.setText("Management");
    
    }

    @FXML
    private void choiceBox(MouseEvent event) {
    }

    @FXML
    private void getStaffScheduleUI(ActionEvent event) throws IOException {
        StackPane box12 = FXMLLoader.load(getClass().getResource("scheduleUI.fxml"));
                stackDisplay.getChildren().setAll(box12);
                title.setText("Schedule");
    }

    @FXML
    private void areaChart(MouseEvent event) {
    }

    @FXML
    private void getDatabaseTable(ActionEvent event) {
    }

    @FXML
    private void getMyProfileUI(ActionEvent event) throws IOException {
            StackPane box7 = FXMLLoader.load(getClass().getResource("profileUI.fxml"));
                stackDisplay.getChildren().setAll(box7);
                title.setText("Profile");
    }

    @FXML
    private void openNotification(MouseEvent event) {
    }
  public void setUser(String u, String i){
          unDisplay.setText(u);
          userIDstored=i;

}
  public Label returnerID(){
   return unDisplay;
  }
    @FXML
    private void openMessages(MouseEvent event) {
    }
    void Exit() throws IOException {
            Stage stage = (Stage) rootPane.getScene().getWindow();
            stage.close();
    }

    @FXML
    private void getLoginUI(ActionEvent event) {
         try    {   
                            Parent root = FXMLLoader.load(getClass().getResource("/smartLogin/smartCareLogin.fxml"));
                               Scene scene = new Scene(root);
                                Stage stage = new Stage(StageStyle.DECORATED);
                                    stage.setScene(scene);
                                        stage.setResizable(false);
                                            stage.show();
                                            rootPane.getScene().getWindow().hide();
                                             Exit();
                        }
                            catch(Exception e){
                                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                   alert.setHeaderText(null);
                                   alert.setContentText(e.getMessage());
                                   alert.showAndWait();

                               }
    }

    @FXML
    private void getDatabaseQueryUI(ActionEvent event) {
    }
public class  userSetup{

    }
}