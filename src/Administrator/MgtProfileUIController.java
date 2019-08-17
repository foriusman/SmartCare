/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administrator;

import com.gn.GNAvatarView;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import smartCareDataBase.DatabaseHandler;

/**
 * FXML Controller class
 *
 * @author -USER
 */
public class MgtProfileUIController implements Initializable {
    DatabaseHandler data = null;
    @FXML
    private JFXTextField fullUpdateUserName;
    @FXML
    private JFXTextField postText;
    @FXML
    private JFXComboBox<String> sectionSelector;
    @FXML
    private GNAvatarView imgDisplay;
    private String imageFile;
ObservableList posts =FXCollections.observableArrayList("1","2","3","4","5","6");
    @FXML
    private ImageView holder1img;
    @FXML
    private Label holder1Name;
    @FXML
    private Text holder1post;
    @FXML
    private ImageView holder2img;
    @FXML
    private Label holder2Name;
    @FXML
    private Text holder2post;
    @FXML
    private ImageView holder4img;
    @FXML
    private ImageView holder3img;
    @FXML
    private Label holder3Name;
    @FXML
    private Text holder3post;
    @FXML
    private ImageView holder5img;
    @FXML
    private Text holder4post;
    @FXML
    private ImageView holder6img;
    @FXML
    private Label holder5name;
    @FXML
    private Label holder6name;
    @FXML
    private Label holder4Name;
    @FXML
    private Text holder5post;
    @FXML
    private Text holder6post;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        data = DatabaseHandler.getInstance();
        sectionSelector.setItems(posts);
        
        pixInt();
    } 
    
    private void pixInt(){
    holder1(); holder4();
    holder2(); holder5();
    holder3(); holder6();
    }
    private void holder1(){
        String holder1ID = "1";
        // String sql = "SELECT * mgtTable FROM attendence WHERE position='"+holder1ID+"' ORDER BY ssn ASC ;";
     String sql = "SELECT *  FROM mgtTable WHERE position='"+holder1ID+"' ORDER BY ssn ASC ;";
         
        ResultSet rp = data.executeQuery(sql);
        
        try{
              while(rp.next()){
		//Image img2= (Image) rp.getBlob("bioimg");  
               // Image img2 = new Image((InputStream) rp.getBlob("bioimg"));
                String name = rp.getString("name");
		String post = rp.getString("post");
              
                 if(!name.equals("")){
                        //holder1img.setImage(img2);
                        holder1Name.setText(name);
                        holder1post.setText(post);
             
        }  else System.out.println("no management found");   
            }
        }catch(Exception e){
          System.out.println("error in management");
            
        } 
    }
        private void holder2(){
        String holder1ID = "2";
        // String sql = "SELECT * mgtTable FROM attendence WHERE position='"+holder1ID+"' ORDER BY ssn ASC ;";
     String sql = "SELECT *  FROM mgtTable WHERE position='"+holder1ID+"' ORDER BY ssn ASC ;";
         
        ResultSet rp = data.executeQuery(sql);
        
        try{
              while(rp.next()){
		//Image img2= (Image) rp.getBlob("bioimg");  
               // Image img2 = new Image((InputStream) rp.getBlob("bioimg"));
                String name = rp.getString("name");
		String post = rp.getString("post");
              
                 if(!name.equals("")){
                       // holder2img.setImage(img2);
                        holder2Name.setText(name);
                        holder2post.setText(post);
             
        }  else System.out.println("no management found");   
            }
        }catch(Exception e){
          System.out.println("error in management");
            
        } 
    }
    private void holder3(){
        String holder1ID = "3";
        // String sql = "SELECT * mgtTable FROM attendence WHERE position='"+holder1ID+"' ORDER BY ssn ASC ;";
     String sql = "SELECT *  FROM mgtTable WHERE position='"+holder1ID+"' ORDER BY ssn ASC ;";
         
        ResultSet rp = data.executeQuery(sql);
        
        try{
              while(rp.next()){
		//Image img2= (Image) rp.getBlob("bioimg");  
                //Image img2 = new Image((InputStream) rp.getBlob("bioimg"));
                String name = rp.getString("name");
		String post = rp.getString("post");
              
                 if(!name.equals("")){
                       // holder3img.setImage(img2);
                        holder3Name.setText(name);
                        holder3post.setText(post);
             
        }  else System.out.println("no management found");   
            }
        }catch(Exception e){
          System.out.println("error in management");
            
        } 
    }
    private void holder4(){
        String holder1ID = "4";
        // String sql = "SELECT * mgtTable FROM attendence WHERE position='"+holder1ID+"' ORDER BY ssn ASC ;";
     String sql = "SELECT *  FROM mgtTable WHERE position='"+holder1ID+"' ORDER BY ssn ASC ;";
         
        ResultSet rp = data.executeQuery(sql);
        
        try{
              while(rp.next()){
		//Image img2= (Image) rp.getBlob("bioimg");  
                //Image img2 = new Image((InputStream) rp.getBlob("bioimg"));
                String name = rp.getString("name");
		String post = rp.getString("post");
              
                 if(!name.equals("")){
                       // holder4img.setImage(img2);
                         holder4Name.setText(name);
                        holder4post.setText(post);
             
        }  else System.out.println("no management found");   
            }
        }catch(Exception e){
          System.out.println("error in management");
            
        } 
    }
      private void holder5(){
        String holder1ID = "5";
        // String sql = "SELECT * mgtTable FROM attendence WHERE position='"+holder1ID+"' ORDER BY ssn ASC ;";
     String sql = "SELECT *  FROM mgtTable WHERE position='"+holder1ID+"' ORDER BY ssn ASC ;";
         
        ResultSet rp = data.executeQuery(sql);
        
        try{
              while(rp.next()){
		//Image img2= (Image) rp.getBlob("bioimg");  
                //Image img2 = new Image((InputStream) rp.getBlob("bioimg"));
                String name = rp.getString("name");
		String post = rp.getString("post");
              
                 if(!name.equals("")){
                        //holder2img.setImage(img2);
                        holder5name.setText(name);
                        holder5post.setText(post);
             
        }  else System.out.println("no management found");   
            }
        }catch(Exception e){
          System.out.println("error in management");
            
        } 
    }
    private void holder6(){
        String holder1ID = "6";
        // String sql = "SELECT * mgtTable FROM attendence WHERE position='"+holder1ID+"' ORDER BY ssn ASC ;";
     String sql = "SELECT *  FROM mgtTable WHERE position='"+holder1ID+"' ORDER BY ssn ASC ;";
         
        ResultSet rp = data.executeQuery(sql);
        
        try{
              while(rp.next()){
		//Image img2= (Image) rp.getBlob("bioimg");  
                //Image img2 = new Image((InputStream) rp.getBlob("bioimg"));
                String name = rp.getString("name");
		String post = rp.getString("post");
              
                 if(!name.equals("")){
                        //holder6img.setImage(img2);
                        holder6name.setText(name);
                        holder6post.setText(post);
             
        }  else System.out.println("no management found");   
            }
        }catch(Exception e){
          System.out.println("error in management");
            
        } 
    }
    @FXML
    private void UpdateMangement(ActionEvent event) {
        String position =  sectionSelector.getValue().toString();
           String uname = fullUpdateUserName.getText();
            String upost = postText.getText();
            Image img  = imgDisplay.getImage();
              String sql = "insert into mgtTable(name,post,position,bioimg)"+"values( '"+uname+"','"+upost+"','"+position+"','"+img+"')";
           System.out.println(sql);
        if(data.executeAction(sql)){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("Mangment Profile Updated Created ");
            alert.showAndWait();
             postText.clear();
             fullUpdateUserName.clear();
             pixInt();
        }
        else{
             Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("update failed");
            alert.showAndWait();
        }    

    } 
    


    @FXML
    private void getImageProfile(ActionEvent event) throws MalformedURLException {
        FileChooser filechoose = new FileChooser();
        filechoose.setTitle("Select Image");
        filechoose.getExtensionFilters().addAll(
            new FileChooser.ExtensionFilter("Image File", "*.gif", "*.png", "*.jpg"));
        File selectedFile = filechoose.showOpenDialog(imgDisplay.getScene().getWindow());
        if(selectedFile !=null){
            
            imageFile = selectedFile.toURI().toURL().toString();
            Image image = new Image(imageFile);
            imgDisplay.setImage(image);
        }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("Image Selection Cancelled");
            alert.showAndWait(); 
        }
    }
    
}

