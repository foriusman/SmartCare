/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Receptionist;

//import com.gn.GNAvatarView;
//import com.jfoenix.controls.JFXBadge;
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
public class ReceptionistUIController implements Initializable {

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

    private StackPane stackDisplay;
    @FXML
    private StackPane ReprootPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void getDashboardUI(ActionEvent event) throws IOException {
         StackPane box = FXMLLoader.load(getClass().getResource("/Administrator/AdminDashBoard.fxml"));
                stackDisplay.getChildren().setAll(box);
                title.setText("Admin Dashboard");
    }

    @FXML
    private void getCreatePatient(ActionEvent event) throws IOException {
         StackPane box2 = FXMLLoader.load(getClass().getResource("createPatient.fxml"));
                stackDisplay.getChildren().setAll(box2);
                title.setText("Notice");
    }

    @FXML
    private void getPatientProfileUI(ActionEvent event) throws IOException {
         StackPane box3 = FXMLLoader.load(getClass().getResource("patientProfileUI.fxml"));
                stackDisplay.getChildren().setAll(box3);
                title.setText("Patient Profile");
        
    }

    @FXML
    private void animateButtons(MouseEvent event) {
    }

    @FXML
    private void getPatientTUI(ActionEvent event) throws IOException {
          StackPane box11 = FXMLLoader.load(getClass().getResource("patientRecordUI.fxml"));
                stackDisplay.getChildren().setAll(box11);
                title.setText("Patient Record");
    }

    @FXML
    private void banners(MouseEvent event) {
    }

    @FXML
    private void getInPatientTUI(ActionEvent event) throws IOException {
          StackPane box12 = FXMLLoader.load(getClass().getResource("inPatientUI.fxml"));
                stackDisplay.getChildren().setAll(box12);
                title.setText("In Patient");
        
    }

    @FXML
    private void getStaffAttRecUI(ActionEvent event) throws IOException {
         StackPane box17 = FXMLLoader.load(getClass().getResource("outPatient.fxml"));
                stackDisplay.getChildren().setAll(box17);
                title.setText("Out Patient");
      
    }

    @FXML
    private void buttons(MouseEvent event) {
    }

    @FXML
    private void getNoticeUI(ActionEvent event) throws IOException {
         StackPane box4 = FXMLLoader.load(getClass().getResource("NoticeUI.fxml"));
                stackDisplay.getChildren().setAll(box4);
                title.setText("Notice");
    }

    @FXML
    private void checkBox(MouseEvent event) {
    }

    @FXML
    private void getMprofile(ActionEvent event) throws IOException {
        StackPane box8 = FXMLLoader.load(getClass().getResource("mangermentUI.fxml"));
                stackDisplay.getChildren().setAll(box8);
                title.setText("Management");
    }

    @FXML
    private void choiceBox(MouseEvent event) {
    }

    @FXML
    private void getMyScheduleUI(ActionEvent event) throws IOException {
             StackPane box13 = FXMLLoader.load(getClass().getResource("mySchedule.fxml"));
                stackDisplay.getChildren().setAll(box13);
                title.setText("Schedule");
    }

    @FXML
    private void getSendRequestUI(ActionEvent event) throws IOException {
        StackPane box15 = FXMLLoader.load(getClass().getResource("requestUI.fxml"));
                stackDisplay.getChildren().setAll(box15);
                title.setText("Send Request");
        
    }

    @FXML
    private void areaChart(MouseEvent event) {
    }

    @FXML
    private void getPatientQUI(ActionEvent event) throws IOException {
        StackPane box16 = FXMLLoader.load(getClass().getResource("queueUI.fxml"));
                stackDisplay.getChildren().setAll(box16);
                title.setText("Patient Queue");
    }

    @FXML
    private void getEmergencyQUI(ActionEvent event) throws IOException {
        StackPane box18 = FXMLLoader.load(getClass().getResource("emergencyUI.fxml"));
                stackDisplay.getChildren().setAll(box18);
                title.setText("Emergency Patient Queue");
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

    @FXML
    private void openMessages(MouseEvent event) {
    }
  void Exit() throws IOException {
            Stage stage = (Stage) ReprootPane.getScene().getWindow();
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
                                            ReprootPane.getScene().getWindow().hide();
                                             Exit();
                        }
                            catch(Exception e){
                                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                   alert.setHeaderText(null);
                                   alert.setContentText(e.getMessage());
                                   alert.showAndWait();

                               }
    }
    
}
