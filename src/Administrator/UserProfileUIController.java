/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administrator;

import com.gn.GNAvatarView;
import com.jfoenix.controls.JFXTextArea;
import java.net.URL;
import java.sql.Blob;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.shape.SVGPath;
import javafx.scene.text.Text;
import org.controlsfx.control.Rating;
import smartCareDataBase.DatabaseHandler;

/**
 * FXML Controller class
 *
 * @author -USER
 */
public class UserProfileUIController implements Initializable {
    DatabaseHandler data = null;
    @FXML
    private HBox searchBox;
    @FXML
    private SVGPath searchIcon;
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
    @FXML
    private Label note;
    @FXML
    private Rating rating;
    @FXML
    private TextField Search;
    @FXML
    private GNAvatarView imgDisplay;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         data = DatabaseHandler.getInstance();
    }    


    @FXML
    private void clearText(MouseEvent event) {
    }

    @FXML
    private void getUserProfile(ActionEvent event) {
        String searchKey = Search.getText();
        String sql ="select * from staffTable where userId='"+searchKey+"'";
         ResultSet rp2 = data.executeQuery(sql);
                 String ssn = "";
                 String userId = "";
                 String  name = "";
                 String  department = "";
                 String  post = "";
                 String  status = "";
                 String  gender = "";
                 String  phone = "";
                 String  password = "";
                 String sp  ="";
                 String address = "";
                 String email = "";
                 String empy = "";
         
        try{
              while(rp2.next()){
                 ssn = rp2.getString("ssn");
                userId = rp2.getString("userId");
                  name = rp2.getString("name");
                  department = rp2.getString("department");
                  post = rp2.getString("post");
                  status = rp2.getString("status");
                  gender = rp2.getString("gender");
                   phone = rp2.getString("phone");
                   password = rp2.getString("password");
                sp  =rp2.getString("sepcialization");
                 address = rp2.getString("address");
                 email = rp2.getString("email");
               empy = rp2.getString("doe");
                // Blob img = rp2.getBlob("staffimg");
                 
                System.out.println(ssn+" "+userId);
              }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
                    if(!ssn.equals("")){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("Staff Found");
            alert.showAndWait();
            userName.setText(name);
            userPost.setText(post);
            userID.setText(userId);
            userDepartment.setText(department);
            userMobile.setText(phone);
            userSepcialization.setText(sp);
            userAddress.setText(address);
            userGender.setText(gender);
            userEmail.setText(email);
            userEY.setText(empy);
            //imgDisplay.setImage((Image) img);
        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText(null);
            alert.setContentText("Staff Not Found");
            alert.showAndWait();
        }       
            }
    }
    
