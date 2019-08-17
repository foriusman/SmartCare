/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administrator;

import com.digitalpersona.onetouch.DPFPDataPurpose;
import com.digitalpersona.onetouch.DPFPFeatureSet;
import com.digitalpersona.onetouch.DPFPGlobal;
import com.digitalpersona.onetouch.DPFPSample;
import com.digitalpersona.onetouch.DPFPTemplate;
import com.digitalpersona.onetouch.DPFPTemplateFactory;
import com.digitalpersona.onetouch.capture.DPFPCapture;
import com.digitalpersona.onetouch.capture.event.DPFPDataAdapter;
import com.digitalpersona.onetouch.capture.event.DPFPDataEvent;
import com.digitalpersona.onetouch.capture.event.DPFPReaderStatusAdapter;
import com.digitalpersona.onetouch.capture.event.DPFPReaderStatusEvent;
import com.digitalpersona.onetouch.processing.DPFPEnrollment;
import com.digitalpersona.onetouch.processing.DPFPFeatureExtraction;
import com.digitalpersona.onetouch.processing.DPFPImageQualityException;
import com.digitalpersona.onetouch.processing.DPFPTemplateStatus;
import com.digitalpersona.onetouch.verification.DPFPVerification;
import com.gn.GNAvatarView;
import com.jfoenix.controls.JFXTextField;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.SVGPath;
import javafx.scene.text.Text;
import smartCareDataBase.DatabaseHandler;

/**
 * FXML Controller class
 *
 * @author -USER
 */
public class AttendenceUIController implements Initializable {
      ObservableMap<Integer, Image> templates = FXCollections.observableHashMap();
      //File file = new File("");
    DPFPEnrollment enrollement = DPFPGlobal.getEnrollmentFactory().createEnrollment();
    byte[] fingerPrint = null;
    DPFPCapture capture = DPFPGlobal.getCaptureFactory().createCapture();
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
    private ImageView fingerViewerEn;
    @FXML
    private JFXTextField genCode;
    @FXML
    private JFXTextField signOutID;
    @FXML
    private JFXTextField userNameDisplay;
    @FXML
    private ImageView signoutScanViewer;
    @FXML
    private JFXTextField signInstaffID;
    @FXML
    private JFXTextField signInNameDisplay;
    @FXML
    private ImageView signinFingerViewer;
    @FXML
    private TableView<StaffAttendence> StaffAttDisplay;
    @FXML
    private TableColumn<StaffAttendence, String> staffNameCA;
    @FXML
    private TableColumn<StaffAttendence, String> staffIDCA;
    @FXML
    private TableColumn<StaffAttendence, String> departC;
    @FXML
    private TableColumn<StaffAttendence, String> arrivalC;
    @FXML
    private TableColumn<StaffAttendence, String> departureC;
        DatabaseHandler data = null;
      DatabaseHandler staffdata = null;
      DatabaseHandler staffAttData = null;
      DatabaseHandler staffAttData2 = null;
      DatabaseHandler staffInsert = null;
    @FXML
    private Text readerStatus;
  ObservableList<StaffAttendence> oStaffAttData =FXCollections.observableArrayList();
    ObservableList<Staff> oStaffdata =FXCollections.observableArrayList();
     ObservableList<StaffAttendence> oStaffAttData2 =FXCollections.observableArrayList();
         public String[] inlist = new String[4];
    public String lo = new String();
    public String lo2 = new String();
     public String lo3 = new String();
     public String vUserStatus = "";
    public final DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    @FXML
    private TableView<Staff> stafflistDisplayTable;
    @FXML
    private TableColumn<Staff, String> slNameC;
    @FXML
    private TableColumn<Staff, String> slIDc;
    @FXML
    private TableColumn<Staff, String> slDepartmentC;
    @FXML
    private TableColumn<Staff, String> slDateC;
     /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         
          data = new DatabaseHandler();
          staffdata = DatabaseHandler.getInstance();
          staffAttData  = DatabaseHandler.getInstance();
          staffInsert  = DatabaseHandler.getInstance();

        initStaffCol();
        viewPdata();
        initStaffAttCol();
        viewAttdata();
    }   
     public ObservableList<Staff> getList(){
            return oStaffdata; 
     }

    public ObservableList<StaffAttendence> getList2(){
            return oStaffAttData; 
     }
     
    

    @FXML
    private void getStaffFromList(KeyEvent event) {
    }

      
    @FXML
    private void getFingerscanner(ActionEvent event) {
           //1. Start Biometric Device
           //readerStatus.setText("Reader Status: Waiting Scan!!!");
        capture.addReaderStatusListener(new DPFPReaderStatusAdapter() {
            @Override
            public void readerConnected(DPFPReaderStatusEvent dpfprs) {
                super.readerConnected(dpfprs);
                System.out.println("Reader Connected!!!");
                readerStatus.setText("Reader Status: Connected!!!");

            }

            @Override
            public void readerDisconnected(DPFPReaderStatusEvent dpfprs) {
                super.readerDisconnected(dpfprs);
                System.out.println("Reader Disconnected!!!");
                 readerStatus.setText("Reader Status: Disconnected!!!");
            }

        });
       
        
        capture.addDataListener(new DPFPDataAdapter() {
            @Override
            public void dataAcquired(DPFPDataEvent evt) {
                super.dataAcquired(evt);

                DPFPFeatureExtraction featureExt = DPFPGlobal.getFeatureExtractionFactory().createFeatureExtraction();
                DPFPSample sample = evt.getSample();
                java.awt.Image fingerPrintImage = DPFPGlobal.getSampleConversionFactory().createImage(sample);

                DPFPFeatureSet fSet;

                try {
                    fSet = featureExt.createFeatureSet(sample, DPFPDataPurpose.DATA_PURPOSE_ENROLLMENT);
                    enrollement.addFeatures(fSet);
                    while (enrollement.getTemplateStatus() == DPFPTemplateStatus.TEMPLATE_STATUS_READY) {
                        //capture complete
                        //get the template from the enrollment object
                        System.out.println("Capture Completed");
                        fingerPrint = enrollement.getTemplate().serialize();
                        System.out.println("Sample Gotten");
                        System.out.println(fingerPrint);
                        genCode.setText(fingerPrint.toString());
                        enrollement.clear();

                        //converting to javafx imagev]idrrr 
                        fingerViewerEn.setImage(convertToFxImage(fingerPrintImage));
                    }
                } catch (DPFPImageQualityException ex) {
                    Logger.getLogger(AttendenceUIController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });

        if (!capture.isStarted()) {
            capture.startCapture();
        }
        
    }

    //method to covert sample to image
    private Image convertToFxImage(java.awt.Image image) {

        BufferedImage bImg = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_RGB);
        Graphics2D bGr = bImg.createGraphics();
        bGr.drawImage(image, 0, 0, null);
        bGr.dispose();
        return SwingFXUtils.toFXImage(bImg, null);
    }
     //method to save to the databas
    @FXML
    private void getStaffEnrolement(ActionEvent event)  throws SQLException  {
        
        readerStatus.setText("Enrolement Status: Processing!!!");
        //Timestamp tamp = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());
        String code = genCode.getText();
        
        byte[] testBytes  = fingerPrint;
              String searchKey = userID.getText();
        String sql ="select * from staffTable where userId='"+searchKey+"'";
         ResultSet rp2 = data.executeQuery(sql);
		 String userId = "";
                 String  name = "";
                 String  department = "";
         
        try{
              while(rp2.next()){
                 userId = rp2.getString("userId");
                 name = rp2.getString("name");
                 department = rp2.getString("department");
         }
        }catch(Exception e){
            System.out.println("User not Found");
        }  
         if(!userId.equals("")){

        String sql2 = "insert into staff( staff_id, name, department,gencode,finimg)"
                + "values( ?,?,?,?,?)";
        
        //System.out.println(id+" "+fulln+" "+dn+" "+code);
      

        PreparedStatement pstatment = data.createPreparedStatements(sql2);
        
        pstatment.setString(1,userId);
        pstatment.setString(2,name);
        pstatment.setString(3,department);
      
        //pstatment.setBlob(4, new ByteArrayInputStream(imageBytes));
        pstatment.setString(4,code);
        pstatment.setBinaryStream(5,new ByteArrayInputStream(testBytes),testBytes.length);
        //pstatment.setTimestamp(6, tamp);

        if (data.executeAction(pstatment)) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText(" Staff Enrolement Successful");
            readerStatus.setText("Staff Enrolement Successful");
            alert.showAndWait();
            fingerPrint = null;
            genCode.clear();
            fingerViewerEn.setImage(null);
            viewPdata();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Staff Enrolement Not Sucessful");
            alert.showAndWait();
            fingerPrint = null;
            genCode.clear();
            fingerViewerEn.setImage(null);
            viewPdata();

        }
    }
 } 
    
    @FXML
    private void getAttStaff(ActionEvent event) {
    }

    @FXML
    private void getSignoutVerification(ActionEvent event) throws SQLException, ParseException {
         String oid2= signOutID.getText();
        String sql3 = "SELECT * FROM attendence WHERE staff_id=? ORDER BY serail ASC ;";

            PreparedStatement pstatment = data.createPreparedStatements(sql3);
            
            pstatment.setString(1, oid2);
            ResultSet rs=pstatment.executeQuery();

           while(rs.next()){
                 lo3=rs.getString("arrival");
                 lo2=rs.getString("departure");
              }
           //checkuser();
           if(!lo2.equals("")){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("You have already Signed Out on: "+lo2);
            alert.showAndWait();
            readerStatus.setText("You have already Signed Out!!!");
            fingerPrint = null;
            signOutID.clear();
            userNameDisplay.clear();
            signoutScanViewer.setImage(null);
           } else {validate2();}
          
       
    }
    
    
    
    public void validateSignout(){
          String oid= signOutID.getText();
        
        String sql = "UPDATE  attendence SET departure=current_timestamp WHERE staff_id='"+oid+"' ";
         

        if(data.executeAction2(sql)){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText(" Sign Out Successful !!!");
            alert.showAndWait();
            readerStatus.setText("Sign Out Successful !!!");
            fingerPrint = null;
            signOutID.clear();
            userNameDisplay.clear();
            signoutScanViewer.setImage(null);
            
           
            
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Sign Out Not Sucessful");
            alert.showAndWait();
            readerStatus.setText("Sign Out Not Successful try again!!!");

        }
         signoutScanViewer.setImage(null);
       viewAttdata();
}

    @FXML
    private void getSignoutScanner(ActionEvent event) {
        System.out.println("Button clicked");

        capture.addReaderStatusListener(new DPFPReaderStatusAdapter() {
            @Override
            public void readerConnected(DPFPReaderStatusEvent dpfprs) {
                super.readerConnected(dpfprs);
                System.out.println("Reader Connected!!!");
                 readerStatus.setText("Reader Status: Connected!!!");

            }

            @Override
            public void readerDisconnected(DPFPReaderStatusEvent dpfprs) {
                super.readerDisconnected(dpfprs);
                System.out.println("Reader Disconnected!!!");
                 readerStatus.setText("Reader Status: Disconnected!!!");
            }

        });

        capture.addDataListener(new DPFPDataAdapter() {
            @Override
            public void dataAcquired(DPFPDataEvent evt) {
                super.dataAcquired(evt);

                DPFPFeatureExtraction featureExt = DPFPGlobal.getFeatureExtractionFactory().createFeatureExtraction();
                DPFPSample sample = evt.getSample();
                java.awt.Image fingerPrintImage = DPFPGlobal.getSampleConversionFactory().createImage(sample);
                System.out.println("inside data acquied");
                //  byte[] sampleByte = null;
                System.out.println("1");
                // evt.getSample().deserialize(sampleByte);
                System.out.println("2");
                isFingerPrintRegistered2(evt.getSample());
                
                String vet= readerStatus.getText();
                
                if(vet.equals("Verified User")){
                  signoutScanViewer.setImage(convertToFxImage(fingerPrintImage));
                }
                 
                System.out.println("Sample in bytes");
            }

        });
        if (!capture.isStarted()) {
            capture.startCapture();
        }
    }

    @FXML
    private void getSignOutUser(ActionEvent event) {
         String sOutid = signOutID.getText();
        
        String sql ="select * from staff where staff_id = '"+sOutid+"' ";
        ResultSet r = data.executeQuery(sql);
        String idd = "";
        String na = "";
      
        try{
            while(r.next()){
                  idd = r.getString("staff_id");
                  na = r.getString("name");
                  
                }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
       
        if(!idd.equals("")){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("Staff Found");
            alert.showAndWait();
            userNameDisplay.setText(na);
        }
        else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText(null);
            alert.setContentText("You have not signed today or incorrect ID!!!");
            alert.showAndWait();
        }
        
    }

    //Inserting user to attendence list
    @FXML
    private void getSigninVerification(ActionEvent event) {
        // vUserStatus.get
        System.out.println(vUserStatus);
        if(vUserStatus=="Verified"){
        String sInid = signInstaffID.getText();
        String id2 =null;
        String mainID2 = null;
        
       String sql ="select * from staff where staff_id = '"+sInid+"' ";
       ResultSet rp = staffdata.executeQuery(sql);
        
         try{
              
             while(rp.next()){
                  String name = rp.getString("name");
                 String staff_id = rp.getString("staff_id");
                 String  department = rp.getString("department");
                 
                 System.out.println(name+" "+staff_id+" "+department);
                   inlist[0]=name;   
                   inlist[1]=staff_id; 
                   inlist[2]=department;
                   //insertingUser();
              
                }
             
           

            
             String sql3 = "SELECT arrival FROM attendence WHERE staff_id=? ORDER BY serail ASC ;";

            PreparedStatement pstatment = data.createPreparedStatements(sql3);
            String mainId = inlist[1].toString();
            pstatment.setString(1, mainId);
            ResultSet rs=pstatment.executeQuery();

           while(rs.next()){

                 lo=rs.getString("arrival");
              }
           checkuser();
           // vUserStatus = null; //change i made regarding sign config  
             

    
             
        }catch(Exception e){
            System.out.println(e.getMessage());
             Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Erorr in inserting User");
            alert.showAndWait();
        }
        
        }else {
             Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Finger Print Does Not Match!!!");
            alert.showAndWait();
        }
        
                  
                        
    }
   
    //Validating first time user
    public void checkuser() throws SQLException{
          String sql = "SELECT staff_id FROM attendence WHERE staff_id=? ;";

      PreparedStatement pstatment = data.createPreparedStatements(sql);
          String cid = inlist[1].toString();
          pstatment.setString(1, cid);
          ResultSet rs=pstatment.executeQuery();
     int  cn=0;

           while(rs.next()){
                   String staff_id2 = rs.getString("staff_id");
            
           cn++;

              }
           if(cn>0){
                validate();
                // System.out.println("kkkk");
      lo=null;
           }
           else
           {
           System.out.println("u re now added");
            validatedUser();
           }
       }
      
   
    
   //validate if user already signed in
    public void validatedUser(){
            String sql2 = "insert into attendence(staff_id, name,department)"
                    + "values( '"+inlist[1].toString()+"','"+inlist[0].toString()+"','"+inlist[2].toString()+"')";
        
        System.out.println(sql2);
        
        if(data.executeAction2(sql2)){
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("SignIn Successful");
            readerStatus.setText("Staff Signed In Successful");
            alert.showAndWait();
            fingerPrint = null;
            signInstaffID.clear();
            signInNameDisplay.clear();
            signinFingerViewer.setImage(null);
            viewAttdata();
            
            lo = null;
            //inlist =null;
        }
        else{
           Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Staff SignIn Not Sucessful");
            alert.showAndWait();
            viewAttdata();
        }
          }

    
    //Pormpting Bio-metric Scanner
    @FXML
    private void getSigninScanner(ActionEvent event) {
        System.out.println(" sign in Button clicked");

        capture.addReaderStatusListener(new DPFPReaderStatusAdapter() {
            @Override
            public void readerConnected(DPFPReaderStatusEvent dpfprs) {
                super.readerConnected(dpfprs);
                System.out.println("Reader Connected!!!");
                 readerStatus.setText("Reader Status: Connected!!!");

            }

            @Override
            public void readerDisconnected(DPFPReaderStatusEvent dpfprs) {
                super.readerDisconnected(dpfprs);
                System.out.println("Reader Disconnected!!!");
                 readerStatus.setText("Reader Status: Disconnected!!!");
            }

        });

        capture.addDataListener(new DPFPDataAdapter() {
            @Override
            public void dataAcquired(DPFPDataEvent evt) {
                super.dataAcquired(evt);

                DPFPFeatureExtraction featureExt = DPFPGlobal.getFeatureExtractionFactory().createFeatureExtraction();
                DPFPSample sample = evt.getSample();
                java.awt.Image fingerPrintImage = DPFPGlobal.getSampleConversionFactory().createImage(sample);
                System.out.println("inside data acquied");
                //  byte[] sampleByte = null;
                System.out.println("1");
                // evt.getSample().deserialize(sampleByte);
                System.out.println("2");
                isFingerPrintRegistered(evt.getSample());
                
                String vet= readerStatus.getText();
                
                if(vet.equals("Verified User")){
                  readerStatus.setText("Verified");
                  signinFingerViewer.setImage(convertToFxImage(fingerPrintImage));
                  vUserStatus ="Verified";
                }
               System.out.println("Sample in bytes");
            }

        });
        if (!capture.isStarted()) {
            capture.startCapture();
        }
        readerStatus.setText("Verified");
      // vUserStatus ="Verified";
    }

    
    
    //Verifiaction from Staff database
    public boolean isFingerPrintRegistered(DPFPSample fingerPrintSampleBytes) {
        System.out.println("fingerprint sample");
        int fingerPrintFound = 0;
        DPFPSample fingerPrintSample = fingerPrintSampleBytes;//DPFPGlobal.getSampleFactory().createSample(fingerPrintSampleBytes);
        DPFPFeatureSet fingerPrintSet = null;
        try {
            fingerPrintSet = DPFPGlobal.getFeatureExtractionFactory().createFeatureExtraction().createFeatureSet(fingerPrintSample, DPFPDataPurpose.DATA_PURPOSE_VERIFICATION);
        } catch (Exception e) {
            e.printStackTrace();
        }

        DPFPFeatureSet fingerPrintSetToUse = fingerPrintSet;

        DPFPTemplateFactory tf1 = DPFPGlobal.getTemplateFactory();
        DPFPVerification verifier = DPFPGlobal.getVerificationFactory().createVerification();

        //1. Get all Fingerprint Templates(in bytes) from DB
        //select all finger print database.
        System.out.println("selected from DB");
        String sInid = signInstaffID.getText();
        String sql = "select * from staff where staff_id = '"+sInid+"' ";
        ResultSet r = data.executeQuery(sql);

        try {
            //For loop that goes through all the finger prints from the database.
            while (r.next()) {
                
                byte[] fingerprint = r.getBytes("finimg");
                System.out.println(fingerprint);

                byte[] fingerPrintDataFromDB = fingerprint;
                DPFPTemplate fingerPrintTemplate = tf1.createTemplate(fingerPrintDataFromDB);
                boolean isVerified = verifier.verify(fingerPrintSetToUse, fingerPrintTemplate).isVerified();
                if (isVerified) {
                    System.out.println(sInid);

                    System.out.println("Sample Found");
                    readerStatus.setText("Verified User");
                    //signinFingerViewer.setImage(convertToFxImage(fingerPrintImage));
                    //We found a match, do something
                    fingerPrintFound++;
                    vUserStatus = new String("Verified");
                } else {
                       Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Finger Print Do Match try again...");
            alert.showAndWait();
                    System.out.println("Sample NOT Found");
                    readerStatus.setText("Finger Print Do Match try again...");
                    signInNameDisplay.clear();
                    signInstaffID.clear();
                  
                }

            }
        } catch (SQLException ex) {
            Logger.getLogger(AttendenceUIController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return fingerPrintFound >= 1;
    }
    
    //End of verification
    
    
      //Verifiaction of signout user from Staff database
    public boolean isFingerPrintRegistered2(DPFPSample fingerPrintSampleBytes) {
        System.out.println("fingerprint sample");
        int fingerPrintFound = 0;
        DPFPSample fingerPrintSample = fingerPrintSampleBytes;//DPFPGlobal.getSampleFactory().createSample(fingerPrintSampleBytes);
        DPFPFeatureSet fingerPrintSet = null;
        try {
            fingerPrintSet = DPFPGlobal.getFeatureExtractionFactory().createFeatureExtraction().createFeatureSet(fingerPrintSample, DPFPDataPurpose.DATA_PURPOSE_VERIFICATION);
        } catch (Exception e) {
            e.printStackTrace();
        }

        DPFPFeatureSet fingerPrintSetToUse = fingerPrintSet;

        DPFPTemplateFactory tf1 = DPFPGlobal.getTemplateFactory();
        DPFPVerification verifier = DPFPGlobal.getVerificationFactory().createVerification();

        //1. Get all Fingerprint Templates(in bytes) from DB
        //select all finger print database.
        System.out.println("selected from DB");
        String sInid = signOutID.getText();
        String sql = "select * from staff where staff_id = '"+sInid+"' ";
        ResultSet r = data.executeQuery(sql);

        try {
            //For loop that goes through all the finger prints from the database.
            while (r.next()) {
                
                byte[] fingerprint = r.getBytes("finimg");
                System.out.println(fingerprint);

                byte[] fingerPrintDataFromDB = fingerprint;
                DPFPTemplate fingerPrintTemplate = tf1.createTemplate(fingerPrintDataFromDB);
                boolean isVerified = verifier.verify(fingerPrintSetToUse, fingerPrintTemplate).isVerified();
                if (isVerified) {
                    System.out.println(sInid);

                    System.out.println("Sample Found");
                    readerStatus.setText("Verified User");
                  
                    //We found a match, do something
                    fingerPrintFound++;
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Finger Print Do Match try again...");
            alert.showAndWait();
                    System.out.println("Sample NOT Found");
                    readerStatus.setText("Finger Print Do Match try again...");
                    userNameDisplay.clear();
                    signOutID.clear();
                }

            }
        } catch (SQLException ex) {
            Logger.getLogger(AttendenceUIController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return fingerPrintFound >= 1;
    }
    
    //End of verification
    
    
    
    //Getting Staff for Attendance
    @FXML
    private void getSigninUserID(ActionEvent event) {
                String sInid = signInstaffID.getText();
        
        String sql ="select * from staff where staff_id = '"+sInid+"' ";
        ResultSet r = data.executeQuery(sql);
        String idd = "";
        String na = "";
      
        try{
            while(r.next()){
                  idd = r.getString("staff_id");
                  na = r.getString("name");
                  
                }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
       
        if(!idd.equals("")){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("Staff Found");
            alert.showAndWait();
            signInNameDisplay.setText(na);
        }
        else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText(null);
            alert.setContentText("Staff Not Found");
            alert.showAndWait();
        }
        
    }

    
   //Staff List Display Column
    public void viewPdata(){
        oStaffdata.clear();
        readerStatus.setText("Reader Status:");
         String sql ="select * from staff";
         ResultSet rp = staffdata.executeQuery(sql);
        
        try{
              while(rp.next()){
                 String name = rp.getString("name");
                 String staff_id = rp.getString("staff_id");
                 String  department = rp.getString("department");
                 String  date = rp.getString("date");
                                         
                
            if(!staff_id.equals("")){
             oStaffdata.add(new Staff(name+" ",staff_id,department,date));
        }     
            }
        }catch(Exception e){
            stafflistDisplayTable.setItems(oStaffdata);
        }

     stafflistDisplayTable.setItems(oStaffdata);    //getItems().setAll(data1);//  
    
    }
    
   //Staff List Display Column
    public void initStaffCol(){
          
            slNameC.setCellValueFactory(new PropertyValueFactory<>("name"));
            slIDc.setCellValueFactory(new PropertyValueFactory<>("staff_id"));
            slDepartmentC.setCellValueFactory(new PropertyValueFactory<>("department"));
            slDateC.setCellValueFactory(new PropertyValueFactory<>("date"));
            
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
            userSepcialization.setText(sp);
         
            //imgDisplay.setImage((Image) img);
        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText(null);
            alert.setContentText("Staff Not Found");
            alert.showAndWait();
        }       
            }
    

//    @FXML
//    private void pdfs(ActionEvent event) {
//        
//        
//    }
//Staff List Display Column
    public static class Staff{
        private SimpleStringProperty name;
        private SimpleStringProperty staff_id;
        private SimpleStringProperty department;
        private SimpleStringProperty date;
       
         public String getName() {
            return name.get();
             }
         public String getStaff_id() {
            return staff_id.get();
        }
         public String getDepartment() {
            return department.get();
        }
         public String getDate() {
            return date.get();
        }
        
        
public Staff(String name, String staff_id, String department, String date){
    this.name = new SimpleStringProperty(name);
    this.staff_id= new SimpleStringProperty(staff_id);
    this.department= new SimpleStringProperty(department);
    this.date = new SimpleStringProperty(date);
    
}
       
}
    
//Attendence Table List Display Column
    public void viewAttdata(){
        oStaffAttData.clear();
        readerStatus.setText("Reader Status:");
         String sql ="select * from attendence";
         ResultSet rp = staffAttData.executeQuery(sql);
        
        try{
              while(rp.next()){
                 String name = rp.getString("name");
                 String staff_id = rp.getString("staff_id");
                 String  department = rp.getString("department");
                 String  arrival = rp.getString("arrival");
                 String  departure = rp.getString("departure");
                                         
             //  System.out.println(name+staff_id+department+arrival+departure);
            if(!staff_id.equals("")){
             oStaffAttData.add(new StaffAttendence(name+" ",staff_id,department,arrival,departure));
             System.out.println(name+staff_id+department+arrival+" "+departure);
        }     System.out.println("Empty Table");
            }
        }catch(Exception e){
            StaffAttDisplay.setItems(oStaffAttData);
        }

     StaffAttDisplay.setItems(oStaffAttData);      
    
    }
    
   //Attendence Table List Display Column 
    public void initStaffAttCol(){
          
            staffNameCA.setCellValueFactory(new PropertyValueFactory<>("name"));
            staffIDCA.setCellValueFactory(new PropertyValueFactory<>("staff_id"));
            departC.setCellValueFactory(new PropertyValueFactory<>("department"));
            arrivalC.setCellValueFactory(new PropertyValueFactory<>("arrival"));
            departureC.setCellValueFactory(new PropertyValueFactory<>("departure"));
            
            
     }
    
      public static class StaffAttendence{
        private SimpleStringProperty name;
        private SimpleStringProperty staff_id;
        private SimpleStringProperty department;
        private SimpleStringProperty arrival;
         private SimpleStringProperty departure;
        
         
         
         public String getName() {
            return name.get();
             }
         public String getStaff_id() {
            return staff_id.get();
        }
         public String getDepartment() {
            return department.get();
        }
         public String getArrival() {
            return arrival.get();
         }
        public String getDeparture() {
            return departure.get();
        }        
  //Attendence Table List Display Column      
public StaffAttendence(String name, String staff_id, String department, String arrival,String departure){
    this.name = new SimpleStringProperty(name);
    this.staff_id= new SimpleStringProperty(staff_id);
    this.department= new SimpleStringProperty(department);
    this.arrival= new SimpleStringProperty(arrival);
    this.departure = new SimpleStringProperty(departure);
    
}
    
}
      
      
 //Signin vilidation
 public void validate(){
   System.out.println(" departed "+lo);
         // Timestamp time=new Timestamp(System.currentTimeMillis());
LocalDateTime now=LocalDateTime.now();

 String last_arrival_year=lo.substring(0, 4);
String last_arrival_month=lo.substring(5,7);
String last_arrival_day=lo.substring(8,10);
 System.out.println("last_arrival_year : "+last_arrival_year+" last_arrival_month : "+last_arrival_month+" last_arrival_day : "+last_arrival_day);

       String current_year=dtf.format(now).substring(0, 4);
       String current_month=dtf.format(now).substring(5,7);
        String current_day=dtf.format(now).substring(8,10);
System.out.println("current_year : "+current_year+" current_month : "+current_month+" current_day : "+current_day);
if (last_arrival_year.equals(current_year)&&last_arrival_month.equals(current_month)&&last_arrival_day.equals(current_day)){
   System.out.println("You have already sign");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("You have already sign");
            readerStatus.setText("You have already sign");
            alert.showAndWait();
            fingerPrint = null;
            signInstaffID.clear();
            signInNameDisplay.clear();
            signinFingerViewer.setImage(null);
}
else{
System.out.println("you can now sign in ");
validatedUser();

} 
   }

 //SignOUT vilidation 
 public void validate2(){
   System.out.println(" departed "+lo3);
         // Timestamp time=new Timestamp(System.currentTimeMillis());
LocalDateTime now=LocalDateTime.now();

 String last_arrival_year=lo3.substring(0, 4);
String last_arrival_month=lo3.substring(5,7);
String last_arrival_day=lo3.substring(8,10);
 System.out.println("last_arrival_year : "+last_arrival_year+" last_arrival_month : "+last_arrival_month+" last_arrival_day : "+last_arrival_day);

       String current_year=dtf.format(now).substring(0, 4);
       String current_month=dtf.format(now).substring(5,7);
        String current_day=dtf.format(now).substring(8,10);
System.out.println("current_year : "+current_year+" current_month : "+current_month+" current_day : "+current_day);
if (last_arrival_year.equals(current_year)&&last_arrival_month.equals(current_month)&&last_arrival_day.equals(current_day)){
   System.out.println("You have already sign");
            validateSignout();
            
}
else{
System.out.println("you can now sign in ");
 Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("You can sign out for"+lo3+" on "+dtf.format(now));
            readerStatus.setText("You have not sign in today");
            alert.showAndWait();
            fingerPrint = null;
            signOutID.clear();
            userNameDisplay.clear();
            signoutScanViewer.setImage(null);
} 
   }
 
 
}