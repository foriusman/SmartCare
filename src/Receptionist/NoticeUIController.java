/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Receptionist;

import Administrator.AdminNoticeUIController;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import smartCareDataBase.DatabaseHandler;

/**
 * FXML Controller class
 *
 * @author -USER
 */
public class NoticeUIController implements Initializable {
    DatabaseHandler data = null;
    @FXML
    private AnchorPane noticeBoardUIpane;
    @FXML
    private TableView<notice> Tnoticetable;
    @FXML
    private TableColumn<notice, String> noticeSNc;
    @FXML
    private TableColumn<notice, String> noticeTitlec;
    @FXML
    private TableColumn<notice, String> noticeDatec;
    @FXML
    private TextArea noticeContentview;
     ObservableList<String> oids =FXCollections.observableArrayList();
      ObservableList<notice> oNoticedata =FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         data = DatabaseHandler.getInstance();
         initNoticeCol();
         viewNoticedata();
    }    
     public void viewNoticedata(){
        oNoticedata.clear();
     
         String sql ="select * from notice";
         ResultSet rp = data.executeQuery(sql);
        
        try{
              while(rp.next()){
		String se = rp.getString("serail");
                String noticeI = rp.getString("notice_id");
		String title= rp.getString("title");
		String date= rp.getString("time");
 		               
                 if(!se.equals("")){
             oNoticedata.add(new notice(noticeI,title,date));
             
        }     
            }
        }catch(Exception e){
           Tnoticetable.setItems(oNoticedata);
            
        } Tnoticetable.setItems(oNoticedata);
    }  
    public void initNoticeCol(){
          
	noticeSNc.setCellValueFactory(new PropertyValueFactory<>("notice_id"));
	noticeTitlec.setCellValueFactory(new PropertyValueFactory<>("title"));
	noticeDatec.setCellValueFactory(new PropertyValueFactory<>("time"));
}

    @FXML
    private void ViewNotice(ActionEvent event) {
         notice p = Tnoticetable.getSelectionModel().getSelectedItem();
        String id = p.getNotice_id();
            try{
        ResultSet s =data.executeQuery("select * from notice where notice_id= '"+id+"'");
        while(s.next()){
           String conten= s.getString("content");
           
           if(!conten.equals("")){
               noticeContentview.setText(conten);
           } else{ System.out.println("Not Added viewed");}
  }
    }catch(Exception e){
            }
    }

    @FXML
    private void DeleteNotice(ActionEvent event) {
    }
    
       public static class notice{
        private SimpleStringProperty notice_id;
	private SimpleStringProperty title;
	private SimpleStringProperty time;
        
         public String getNotice_id() {
            return notice_id.get();
        }
 public String getTitle() {
            return title.get();
        }
 public String getTime() {
            return time.get();
        }
	            
public notice(String notice_id,String title,String time){
    	this.notice_id = new SimpleStringProperty(notice_id);
  	this.title = new SimpleStringProperty(title);
	this.time = new SimpleStringProperty(time);
    
}
       
}  
}
