/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Receptionist;

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
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import smartCareDataBase.DatabaseHandler;

/**
 * FXML Controller class
 *
 * @author -USER
 */
public class MyScheduleController implements Initializable {

    @FXML
    private JFXTextField scheduleStaffSearch;
    @FXML
    private TableView<Schedule> scheduleTableView;;
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
    ObservableList<Schedule> data1 =FXCollections.observableArrayList();
DatabaseHandler data = null;
    @FXML
    private TableColumn<?, ?> maindateC;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        data = DatabaseHandler.getInstance();
        scheduletable();
        initiScheduleCol();
    }    

     public void mainRefresher(){
        data1.clear();
        scheduletable();
        initiScheduleCol();
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
