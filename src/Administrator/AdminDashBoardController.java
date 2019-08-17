/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administrator;

import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import smartCareDataBase.DatabaseHandler;

/**
 * FXML Controller class
 *
 * @author -USER
 */
public class AdminDashBoardController implements Initializable {
    DatabaseHandler data = null;
    @FXML
    private Label noInPStatus;
    @FXML
    private Label noPatStatus;
    @FXML
    private Label nuReceptionist;
    @FXML
    private Label noDoctor;
    @FXML
    private Label noLabAttendant;
    @FXML
    private Label noPharmacist;
    @FXML
    private Label noNurse;
    @FXML
    private Label noRecOfficer;
    @FXML
    private Pane RegPaitents;
    @FXML
    private Label RegStaff;
    @FXML
    private Pane RegNHIS;
    @FXML
    private Label Reg;
    public int repCount=0;
     int regStaffCount=0;
        int adminCount=0;
        int docCount=0;
        int labCount=0;
        int pharmCount=0;
        int nurseCount=0;
        int recCount=0;
        int onlineStaff=0;
    ObservableList repO =FXCollections.observableArrayList();
    @FXML
    private Label onStaff;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        data = DatabaseHandler.getInstance();
        // TODO
        mainCount();
        setCounter();
    }  
    void mainCount(){
       
        String post="";
        String status="";
        String sql ="select * from staffTable";
        ResultSet r = data.executeQuery(sql);
                try{
            while(r.next()){
                   post = r.getString("post");
                   status = r.getString("status");
                   regStaffCount++;
          if(status.equals("Availaible")) onlineStaff++;
         if(post.equals("Administrator")){
    		adminCount++; 
        }else if(post.equals("Doctor")){
                    docCount++;
	}else if(post.equals("Lab Attendant")){
                    labCount++;
	}else if(post.equals("Nurse")){
                        nurseCount++;
	}else if(post.equals("Receptionist")){
                    repCount++;
	}else if(post.equals("Record Officer")){
                        recCount++;
	}else if(post.equals("Pharmacist")){
                    pharmCount++;
	}
        else{
         System.out.println("No Staff Registered");
        }
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
       
        
        
    }
    
    void setCounter(){
       int max = regStaffCount;
               //repCount+docCount+labCount+pharmCount+nurseCount+recCount+adminCount;
        nuReceptionist.setText(""+repCount);
        noDoctor.setText(""+docCount);
         noLabAttendant.setText(""+labCount);
         noPharmacist.setText(""+pharmCount);
         noNurse.setText(""+nurseCount);
         noRecOfficer.setText(""+recCount);
         RegStaff.setText(""+max);
         onStaff.setText(""+onlineStaff);
    }
}

