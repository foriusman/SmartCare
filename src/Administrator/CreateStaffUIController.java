/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administrator;

import com.gn.GNAvatarView;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import smartCareDataBase.DatabaseHandler;

/**
 * FXML Controller class
 *
 * @author -USER
 */
public class CreateStaffUIController implements Initializable {
    DatabaseHandler data = null;
    @FXML
    private StackPane createStaffPane;
    @FXML
    private GNAvatarView userPassport;
    @FXML
    private JFXTextField staffFname;
    @FXML
    private JFXTextField staffLname;
    @FXML
    private JFXTextField staffMname;
    @FXML
    private JFXTextField staffMobile;
    @FXML
    private JFXTextField staffEmail;
    @FXML
    private JFXDatePicker staffDOB;
    @FXML
    private RadioButton singleStaff;
    @FXML
    private ToggleGroup marritalStatus;
    @FXML
    private RadioButton marriedStaff;
    @FXML
    private TextArea staffAddress;
    @FXML
    private RadioButton maleStaff;
    @FXML
    private ToggleGroup gender;
    @FXML
    private RadioButton femaleStaff;
    @FXML
    private JFXTextField staffDepartment;
    @FXML
    private JFXTextField staffQualification;
    @FXML
    private JFXTextField staffSepciallization;
    @FXML
    private ComboBox<String> staffPost;
    @FXML
    private JFXDatePicker empolymentDate;
    @FXML
    private RadioButton fullTimeStaff;
    @FXML
    private ToggleGroup stafftype;
    @FXML
    private RadioButton partTimeStaff;
    @FXML
    private JFXTextField userID;
    @FXML
    private JFXTextField userPassword;
    private String imageFile;
    @FXML
    private RadioButton divoredStaff;
    ObservableList posts =FXCollections.observableArrayList("Administrator","Doctor","Lab Attendant","Nurse","Receptionist","Record Officer","Pharmacist");
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        data = DatabaseHandler.getInstance();
        // TODO
        staffPost.setItems(posts);
    }    

    @FXML
    private void getClearFields(ActionEvent event) {
        clearmyField();
    }
    void clearmyField(){
   staffFname.clear();
   staffLname.clear();
   staffMname.clear();
   staffMobile.clear();
   staffEmail.clear();
   staffAddress.clear();
   staffDepartment.clear();
   staffQualification.clear();
   staffSepciallization.clear();
   userID.clear();
   userPassword.clear();
    }

    @FXML
    private void getCreateStaff(ActionEvent event) throws SQLException {
   String Fname =  staffFname.getText();
   String Lname = staffLname.getText();
   String Mname = staffMname.getText();
   String name = Fname+" "+Mname+" "+Lname;
   String mobile = staffMobile.getText();
   String email = staffEmail.getText();
   String address =staffAddress.getText();
   String department = staffDepartment.getText();
   String qualification = staffQualification.getText();
   String sepcialization = staffSepciallization.getText();
   String userid = userID.getText();
    String password = userPassword.getText();
    String status = "Offline";
    String gender = "";
    String mstatus = "";
        if(maleStaff.isSelected())
            gender = maleStaff.getText();
        else
            gender = femaleStaff.getText();
    if(singleStaff.isSelected()){
            mstatus = singleStaff.getText();
        } else if(marriedStaff.isSelected()){
            mstatus = marriedStaff.getText();
        } else mstatus = divoredStaff.getText();
     String doe =empolymentDate.getValue().toString();
     String dob =staffDOB.getValue().toString();
      String stafftype = "";
       if(fullTimeStaff.isSelected())
            stafftype = fullTimeStaff.getText();
        else
            stafftype = partTimeStaff.getText();
        Image img  = userPassport.getImage();
        String post = staffPost.getValue().toString();
        
                    String sql = "insert into staffTable(userId,name,password,phone,email,dob,mstatus,gender,address,department,qualification,sepcialization,doe,post,stafftype,status)"
                            +"values( '"+userid+"','"+name+"','"+password+"','"+mobile+"','"+email+"','"+dob+"','"+mstatus+"','"+gender+"','"+address+"','"+department+"','"+qualification+"','"+sepcialization+"','"+doe+"','"+post+"','"+stafftype+"','"+status+"')";
                    
           System.out.println(sql);
        if(data.executeAction(sql)){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("Staff Created ");
            alert.showAndWait();
        }
        else{
             Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Error in creating Staff");
            alert.showAndWait();
        }

        try{
         //byte[] staffimg = ImageConverter.convertToByteArrauy(img);
         byte[] imageBytes = ImageConverter.convertToByteArrauy(img);

                String sql2 = "UPDATE staffTable"+"SET staffimg=?"+"WHERE userId=?";
                
                PreparedStatement pstatment1 = data.createPreparedStatements(sql2);

                 pstatment1.setBlob(1, new ByteArrayInputStream(imageBytes));
                 pstatment1.setString(2,userid);

                if (data.executeAction(pstatment1)) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setContentText("Profile Pic updated Successfully");
                    alert.showAndWait();
                     clearmyField();

                }else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setContentText("Not Sucessful");
                    alert.showAndWait();
                }
        }catch(SQLException ex){
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setContentText("Profile Pic updated failed");
                    alert.showAndWait();
        }
        
    //String doe = empolymentDate.getText();
        
    } 

    @FXML
    private void getUserImage(ActionEvent event) throws MalformedURLException {
          FileChooser filechoose = new FileChooser();
        filechoose.setTitle("Select Image");
        filechoose.getExtensionFilters().addAll(
            new FileChooser.ExtensionFilter("Image File", "*.gif", "*.png", "*.jpg"));
        File selectedFile = filechoose.showOpenDialog(userPassport.getScene().getWindow());
        if(selectedFile !=null){
            
            imageFile = selectedFile.toURI().toURL().toString();
            Image image = new Image(imageFile);
            userPassport.setImage(image);
        }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("Image Selection Cancelled");
            alert.showAndWait(); 
        }
    }
    
}
