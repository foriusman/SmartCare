/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package careUser;

import com.gn.GNAvatarView;
import smartCareDataBase.DatabaseHandler;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

/**
 * FXML Controller class
 *
 * @author -USER
 */
public class CreateUserController implements Initializable {
    DatabaseHandler data = null;
    @FXML
    private GNAvatarView avatar;
    @FXML
    private HBox userFullname;
    @FXML
    private TextField fullname;
    @FXML
    private HBox box_username;
    @FXML
    private TextField userID;
    @FXML
    private HBox box_email;
    @FXML
    private TextField userPassword;
    @FXML
    private HBox box_email1;
    @FXML
    private TextField userportfolio;
    @FXML
    private Label lbl_error;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          data = new DatabaseHandler();
        // TODO
    }    


    @FXML
    private void createUser(ActionEvent event) throws SQLException {
        String fulnam = fullname.getText();
        String usid = userID.getText();
        String userpass = userPassword.getText();
        String usport = userportfolio.getText();
        
      if(fulnam.isEmpty() || usid.isEmpty() || userpass.isEmpty() || usport.isEmpty()){
          Alert alert = new Alert(Alert.AlertType.ERROR);
          alert.setHeaderText(null);
          alert.setContentText("Text field cannot be empty");
          alert.showAndWait();
          fullname.clear();
          userID.clear();
          userPassword.clear();
          userportfolio.clear();; 
      }else if(!fulnam.isEmpty() || !usid.isEmpty() || !userpass.isEmpty() || !usport.isEmpty()){
          String sql = "insert into userTable( userId, username, password,userportfolio)"
                  + "values( ?,?,?,?)";
          
          System.out.println(fulnam+" "+usid+" "+userpass+" "+usport);
          
          
          PreparedStatement pstatment = data.createPreparedStatements(sql);
          
          pstatment.setString(1,usid);
          pstatment.setString(2,fulnam);
          pstatment.setString(3,userpass);
          pstatment.setString(4,usport);
          
          if (data.executeAction(pstatment)) {
              Alert alert = new Alert(Alert.AlertType.INFORMATION);
              alert.setHeaderText(null);
              alert.setContentText("User Creation Successful");
              alert.showAndWait();
              
              fullname.clear();
              userID.clear();
              userPassword.clear();
              userportfolio.clear();
              
          } else {
              Alert alert = new Alert(Alert.AlertType.ERROR);
              alert.setHeaderText(null);
              alert.setContentText("User Creation Not Sucessful");
              alert.showAndWait();
              fullname.clear();
              userID.clear();
              userPassword.clear();
              userportfolio.clear();;
              
          }
      } else System.out.println("not valid");
 }
    
}
