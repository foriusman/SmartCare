/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administrator;

import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import smartCareDataBase.DatabaseHandler;

/**
 * FXML Controller class
 *
 * @author -USER
 */
public class StaffRecordUIController implements Initializable {
     DatabaseHandler data = null;
    @FXML
    private TableColumn<StaffTable, String> snC;
    @FXML
    private TableColumn<StaffTable, String> staffidC;
    @FXML
    private TableColumn<StaffTable, String> postC;
    @FXML
    private TableView<StaffTable> staffTableview;
    @FXML
    private TableColumn<StaffTable, String> nameC;
    @FXML
    private TableColumn<StaffTable, String> departC;
    @FXML
    private TableColumn<StaffTable, String> statusC;
    @FXML
    private TableColumn<StaffTable, String> genderC;
    @FXML
    private TableColumn<StaffTable, String> phoneC;
    @FXML
    private TableColumn<StaffTable, String> passC;
    ObservableList<StaffTable> data1 =FXCollections.observableArrayList();
    //ObservableList<StaffTable> skey =FXCollections.observableArrayList();
    @FXML
    private JFXTextField searchBar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        data = DatabaseHandler.getInstance();
        viewStaffTable();
        initStaffCol();
    }    

    public void viewStaffTable(){
    String sql ="select * from staffTable";
         ResultSet rp2 = data.executeQuery(sql);
         
        try{
              while(rp2.next()){
                 String ssn = rp2.getString("ssn");
                 String userId = rp2.getString("userId");
                 String  name = rp2.getString("name");
                 String  department = rp2.getString("department");
                 String  post = rp2.getString("post");
                 String  status = rp2.getString("status");
                 String  gender = rp2.getString("gender");
                 String  phone = rp2.getString("phone");
                 String  password = rp2.getString("password");
                 
                System.out.println(ssn+" "+userId);
            if(!ssn.equals("")){
            data1.add(new StaffTable(ssn,userId,name,department,post,status,gender,phone,password));
        }   staffTableview.setItems(data1);    
            }
        }catch(Exception e){
            staffTableview.setItems(data1); 
        }
        
    }
//Staff List Display Column
 public void initStaffCol(){
           snC.setCellValueFactory(new PropertyValueFactory<>("ssn"));
            staffidC.setCellValueFactory(new PropertyValueFactory<>("userId"));
             nameC.setCellValueFactory(new PropertyValueFactory<>("name"));
           departC.setCellValueFactory(new PropertyValueFactory<>("department"));
          postC.setCellValueFactory(new PropertyValueFactory<>("post"));
            statusC.setCellValueFactory(new PropertyValueFactory<>("status"));
             genderC.setCellValueFactory(new PropertyValueFactory<>("gender"));
           phoneC.setCellValueFactory(new PropertyValueFactory<>("phone"));
 	passC.setCellValueFactory(new PropertyValueFactory<>("password"));
     }

    private void getSearchResult(KeyEvent event) {
       
    }

    @FXML
    private void getSearchResult(ActionEvent event) {
         String searchKey = searchBar.getText();
        String sql ="select * from staffTable where userId='"+searchKey+"'";
         ResultSet rp2 = data.executeQuery(sql);
         
        try{
              while(rp2.next()){
                 String ssn = rp2.getString("ssn");
                 String userId = rp2.getString("userId");
                 String  name = rp2.getString("name");
                 String  department = rp2.getString("department");
                 String  post = rp2.getString("post");
                 String  status = rp2.getString("status");
                 String  gender = rp2.getString("gender");
                 String  phone = rp2.getString("phone");
                 String  password = rp2.getString("password");
                 
                System.out.println(ssn+" "+userId);
            if(!ssn.equals("")){
	    data1.clear();
            data1.add(new StaffTable(ssn,userId,name,department,post,status,gender,phone,password));
	    initStaffCol();
        }   staffTableview.setItems(data1);    
            }
        }catch(Exception e){
            staffTableview.setItems(data1); 
        }
       
    }

    @FXML
    private void getRefreshed(ActionEvent event) {
        data1.clear(); searchBar.clear();
        viewStaffTable();
        initStaffCol();
    }
 
    public static class StaffTable{
        private SimpleStringProperty ssn;
        private SimpleStringProperty userId;
        private SimpleStringProperty name;
	private SimpleStringProperty department;
        private SimpleStringProperty post;
        private SimpleStringProperty status;       
	private SimpleStringProperty gender;
	private SimpleStringProperty phone;
        private SimpleStringProperty password;

         public String getSsn() {
            return ssn.get();
             }
      
          public String getUserId() {
            return userId.get();
        }
	   public String getName() {
            return name.get();
        }
	   public String getDepartment() {
            return department.get();
        }
	
	   public String getPost() {
            return post.get();
        }
	
	   public String getStatus() {
            return status.get();
        }
	
	   public String getGender() {
            return gender.get();
        }
              public String getPhone() {
            return phone.get();
        }
	   public String getPassword() {
            return password.get();
        }
            
public StaffTable(String ssn, String userId, String name, String department, String post, String status, String gender, String phone, String password){
    this.ssn= new SimpleStringProperty(ssn);
    this.userId= new SimpleStringProperty(userId);
    this.name = new SimpleStringProperty(name);
    this.department = new SimpleStringProperty(department);
    this.post= new SimpleStringProperty(post);
    this.status = new SimpleStringProperty(status);
    this.gender = new SimpleStringProperty(gender);
    this.phone = new SimpleStringProperty(phone);
    this.password = new SimpleStringProperty(password);
    
}

}
}
