/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administrator;

import com.gn.GNAvatarView;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.shape.SVGPath;
import javafx.scene.text.Text;
import smartCareDataBase.DatabaseHandler;

/**
 * FXML Controller class
 *
 * @author -USER
 */
public class ScheduleUIController implements Initializable {

    @FXML
    private TableColumn<Schedule, String> snC;
    @FXML
    private TableColumn<Schedule, String> staffidC;
    @FXML
    private TableColumn<Schedule, String> nameC;
    @FXML
    private TableColumn<Schedule, String> dayC;
    @FXML
    private TableColumn<Schedule, String> dateC;
    @FXML
    private TableColumn<Schedule, String> stimeC;
    @FXML
    private TableColumn<Schedule, String> endTimeC;
    @FXML
    private TableColumn<Schedule, String> staffTypC;
    @FXML
    private HBox searchBox;
    @FXML
    private TextField Search;
    @FXML
    private SVGPath searchIcon;
    @FXML
    private GNAvatarView imgDisplay;
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
    private JFXTextField currentStaffName;
    @FXML
    private JFXTextField currentStaffID;
    @FXML
    private JFXComboBox<String> dayPicker;
    @FXML
    private JFXTimePicker sTimePicker;
    @FXML
    private JFXTimePicker eTimePicker;
    @FXML
    private JFXTextField currentStaffPostC;
     DatabaseHandler data = null;
    @FXML
    private JFXDatePicker udatePicker;
    ObservableList days =FXCollections.observableArrayList("Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday");
    @FXML
    private TableView<Schedule> scheduleTableView;
    @FXML
    private TableColumn<Schedule, String> maindateC;
    ObservableList<Schedule> data1 =FXCollections.observableArrayList();
    @FXML
    private JFXTextField scheduleStaffSearch;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        data = DatabaseHandler.getInstance();
        dayPicker.setItems(days);
        scheduletable();
        initiScheduleCol();
    }    
    public void mainRefresher(){
        data1.clear();
        scheduletable();
        initiScheduleCol();
    }
    @FXML
    private void clearText(MouseEvent event) {
    }
    public void scheduletable(){
            String sql ="select * from schedule";
            ResultSet rp = data.executeQuery(sql);
            try{
              while(rp.next()){
                       String  ssn = rp.getString("ssn");
                       String   userId = rp.getString("userId");
                        String  name = rp.getString("name");
                         String day = rp.getString("day");
                         String dutydate = rp.getString("dutydate");
                        String  startTime = rp.getString("startTime");
                        String  endTime = rp.getString("endTime");
                        String  post = rp.getString("post");
                       String   date = rp.getString("date");
                                               
                  if(!ssn.equals("")){
                      
                data1.add(new Schedule(ssn,userId,name,day,dutydate,startTime,endTime,post,date));               
          
                }
              }
        }catch(Exception e){
            scheduleTableView.setItems(data1);
        } scheduleTableView.setItems(data1);
    
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
                 String sp  ="";
        try{
              while(rp2.next()){
                 ssn = rp2.getString("ssn");
                userId = rp2.getString("userId");
                  name = rp2.getString("name");
                  department = rp2.getString("department");
                  post = rp2.getString("post");
                  sp  =rp2.getString("sepcialization");
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
            userSepcialization.setText(sp);
         
            //imgDisplay.setImage((Image) img);
        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText(null);
            alert.setContentText("Staff Not Found");
            alert.showAndWait();
        }       
            }

    @FXML
    private void getAddSchedule(ActionEvent event) {
        String userReady =userID.getText();
        String sql ="select * from staffTable where userId='"+userReady+"'";
         ResultSet rp2 = data.executeQuery(sql);
                 String ssn = "";
                 String userId = "";
                 String  name = "";
                 String  post = "";
                
        try{
              while(rp2.next()){
                 ssn = rp2.getString("ssn");
                userId = rp2.getString("userId");
                  name = rp2.getString("name");
                  post = rp2.getString("post");
                  
              }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
                    if(!ssn.equals("")){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("Staff Ready for Scheduling");
            alert.showAndWait();
            currentStaffName.setText(name);
            currentStaffPostC.setText(post);
            currentStaffID.setText(userId);
           
            
         
            //imgDisplay.setImage((Image) img);
        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText(null);
            alert.setContentText("Staff Not Found");
            alert.showAndWait();
        }       
    }

    @FXML
    private void getaddMySchedule(ActionEvent event) {
             String name=currentStaffName.getText();
            String post =currentStaffPostC.getText();
            String userId=currentStaffID.getText();
            String day =dayPicker.getValue().toString();
            String dutydate=udatePicker.getValue().toString();
            String startTime =sTimePicker.getAccessibleText();
            String endTime =eTimePicker.getAccessibleText();
            String newDutyDay="";
        
            String sql2 ="select dutydate from schedule where userId='"+userId+"'";
         ResultSet rp2 = data.executeQuery(sql2);
            
              try{
              while(rp2.next()){
                
                newDutyDay = rp2.getString("dutydate");
                  
              }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
            
        if(!dutydate.equals(newDutyDay)) {      
        
        String sql = "insert into schedule(userId,name,day,dutydate,startTime,endTime,post)"+
                                   "values('"+userId+"','"+name+"','"+day+"','"+dutydate+"','"+startTime+"','"+endTime+"','"+post+"')";
           System.out.println(sql);
        if(data.executeAction(sql)){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("New schedule Created ");
            alert.showAndWait();
            
            
        }
        else{
             Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Schedule Creation failed");
            alert.showAndWait();
        } 
    }else{
             Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Schedule Date Already Exist fro the Staff");
            alert.showAndWait();
        } 
    } 
    
    public void initiScheduleCol(){
                snC.setCellValueFactory(new PropertyValueFactory<>("ssn"));
                staffidC.setCellValueFactory(new PropertyValueFactory<>("userId"));
                nameC.setCellValueFactory(new PropertyValueFactory<>("name"));
                dayC.setCellValueFactory(new PropertyValueFactory<>("day"));
                dateC.setCellValueFactory(new PropertyValueFactory<>("dutydate"));
                stimeC.setCellValueFactory(new PropertyValueFactory<>("startTime"));
                endTimeC.setCellValueFactory(new PropertyValueFactory<>("endTime"));
                staffTypC.setCellValueFactory(new PropertyValueFactory<>("post"));
                 maindateC.setCellValueFactory(new PropertyValueFactory<>("date"));
               
    }

    @FXML
    private void getscheduleStaff(ActionEvent event) {
        String searchKey = scheduleStaffSearch.getText();
        String sql ="select * from schedule where userId='"+searchKey+"'";
            ResultSet rp = data.executeQuery(sql);
            try{
              while(rp.next()){
                       String  ssn = rp.getString("ssn");
                       String   userId = rp.getString("userId");
                        String  name = rp.getString("name");
                         String day = rp.getString("day");
                         String dutydate = rp.getString("dutydate");
                        String  startTime = rp.getString("startTime");
                        String  endTime = rp.getString("endTime");
                        String  post = rp.getString("post");
                       String   date = rp.getString("date");
                                               
                  if(!ssn.equals("")){
                          Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("Staff Found");
            alert.showAndWait();
                  data1.clear();
                data1.add(new Schedule(ssn,userId,name,day,dutydate,startTime,endTime,post,date));               
                initiScheduleCol();
                }else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText(null);
            alert.setContentText("Staff Not Found");
            alert.showAndWait();
           scheduleTableView.setItems(data1);;
        }  
              }
        }catch(Exception e){
            scheduleTableView.setItems(data1);
        } scheduleTableView.setItems(data1);
    
    }

    @FXML
    private void getRefreshedScheduleStaff(ActionEvent event) {   
        scheduleStaffSearch.clear();
        mainRefresher();
    }
 public static class Schedule {
        private final SimpleStringProperty ssn,userId,name,day,dutydate,
                startTime,endTime,post,date;
         @FXML
        public String getSsn() {
            return ssn.get();
        }
       @FXML
        public String getUserId(){
            return userId.get();
        }
         @FXML
        public String getName() {
            return name.get();
        }
          @FXML
        public String getDay() {
            return day.get();
        }
            @FXML
        public String getDutydate() {
            return dutydate.get();
        }
             @FXML
        public String getStartTime() {
            return startTime.get();
        }
              @FXML
        public String getEndTime(){
            return endTime.get();
        }
               @FXML
        public String getPost(){
            return post.get();
        }
         @FXML
        public String getDate(){
            return date.get();
        }
      
        
 public  Schedule(String ssn,String userId,String name,String day,
         String dutydate,String startTime,String endTime,String post,String date){
         
      this.ssn = new SimpleStringProperty(ssn);
       this.userId = new SimpleStringProperty(userId);
       this.name = new SimpleStringProperty(name);
       this.day = new SimpleStringProperty(day);
       this.dutydate = new SimpleStringProperty(dutydate);
       this.startTime = new SimpleStringProperty(startTime);
       this.endTime = new SimpleStringProperty(endTime);
       this.post = new SimpleStringProperty(post);
        this.date = new SimpleStringProperty(date);
 }
 }
}
