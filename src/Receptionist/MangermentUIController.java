/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Receptionist;

import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import smartCareDataBase.DatabaseHandler;

/**
 * FXML Controller class
 *
 * @author -USER
 */
public class MangermentUIController implements Initializable {
    DatabaseHandler data = null;
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
    private Label holder4Name;
    @FXML
    private Text holder4post;
    @FXML
    private ImageView holder3img;
    @FXML
    private Label holder3Name;
    @FXML
    private Text holder3post;
    @FXML
    private ImageView holder6img;
    @FXML
    private Label holder6name;
    @FXML
    private Text holder6post;
    @FXML
    private ImageView holder5img;
    @FXML
    private Label holder5name;
    @FXML
    private Text holder5post;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         data = DatabaseHandler.getInstance();
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
    
    
}
