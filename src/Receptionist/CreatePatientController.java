/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Receptionist;

import com.gn.GNAvatarView;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import smartCareDataBase.DatabaseHandler;

/**
 * FXML Controller class
 *
 * @author -USER
 */
public class CreatePatientController implements Initializable {
    DatabaseHandler data = null;
    @FXML
    private RadioButton maleP;
    @FXML
    private RadioButton femaleP;
    @FXML
    private JFXDatePicker pDOB;
    @FXML
    private GNAvatarView patientPassport;
    @FXML
    private JFXTextField pFname;
    @FXML
    private JFXTextField pMname;
    @FXML
    private JFXTextField pLname;
    @FXML
    private JFXTextField pMobile;
    @FXML
    private JFXTextField pEmail;
    @FXML
    private RadioButton singleP;
    @FXML
    private RadioButton marriedP;
    @FXML
    private TextArea pAddress;
    @FXML
    private ToggleGroup pgender;
    @FXML
    private RadioButton divoredP;
    @FXML
    private JFXTextField pID;
    @FXML
    private JFXTextField pDepartment;
    @FXML
    private JFXComboBox<String> pRank;
    @FXML
    private JFXTextField pPlaceofBrith;
    @FXML
    private JFXTextField pVillage;
    @FXML
    private JFXTextField pTown;
    @FXML
    private JFXTextField pLGA;
    @FXML
    private JFXTextField PCityofR;
    @FXML
    private JFXTextField pAllegy;
    @FXML
    private JFXTextField pDisbility;
    @FXML
    private JFXComboBox<String> pBloodgroup;
    @FXML
    private TextArea pSchoolAddress;
    @FXML
    private JFXComboBox<String> pGenotype;
    @FXML
    private JFXTextField pkFname;
    @FXML
    private JFXTextField pkMname;
    @FXML
    private JFXTextField pkLname;
    @FXML
    private JFXTextField pkMobile;
    @FXML
    private JFXTextField pkEmail;
    @FXML
    private JFXTextField pkRelationship;
    @FXML
    private JFXRadioButton pkMale;
    @FXML
    private ToggleGroup pkGender;
    @FXML
    private JFXRadioButton pkFemale;
    @FXML
    private JFXTextField epatientFN;
    @FXML
    private JFXTextField epatientMobile;
    @FXML
    private JFXTextField EPkinFN;
    @FXML
    private JFXRadioButton maleEP;
    @FXML
    private ToggleGroup EPgender;
    @FXML
    private JFXRadioButton EPmaleKin;
    @FXML
    private ToggleGroup EPkgender;
    @FXML
    private JFXTextField EPkinMobile;
    @FXML
    private JFXTextField epatientMN;
    @FXML
    private JFXTextField epatientLN;
    @FXML
    private JFXTextField epatientAddress;
    @FXML
    private JFXRadioButton femaleEP;
    @FXML
    private JFXRadioButton singleEP;
    @FXML
    private ToggleGroup EPstatus;
    @FXML
    private JFXRadioButton marriedEP;
    @FXML
    private JFXRadioButton divoredEP;
    @FXML
    private JFXTextField EPkinLN;
    @FXML
    private JFXTextField EPkinRelationship;
    @FXML
    private JFXTextField EPkinEmail;
    @FXML
    private JFXTextField EPkinAddress;
    @FXML
    private JFXRadioButton EPfemaleKin;
    @FXML
    private JFXDatePicker epDOB;
    ObservableList rank =FXCollections.observableArrayList("Student","Staff","NHIS");
    ObservableList patientBg =FXCollections.observableArrayList("O","O+","O-","B","B+","A","AB");
    @FXML
    private JFXComboBox<String> pStateofOrign;
    ObservableList stateOgn =FXCollections.observableArrayList("Abia",
  "Adamawa","Anambra","Akwa Ibom","Bauchi","Bayelsa","Benue","Borno","Cross River","Delta","Ebonyi","Enugu","Edo","Ekiti",
  "FCT - Abuja","Gombe","Imo","Jigawa","Kaduna","Kano","Katsina","Kebbi","Kogi","Kwara","Lagos","Nasarawa","Niger","Ogun",
  "Ondo","Osun","Oyo","Plateau","Rivers","Sokoto","Taraba","Yobe","Zamfara");
    ObservableList gt =FXCollections.observableArrayList("AA","AS","SS","AB");
    private String imageFile;
    @FXML
    private ToggleGroup mStatus;
    @FXML
    private JFXTextField epatientIDcard1;
    private ActionEvent ActionEvent;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        data = DatabaseHandler.getInstance();
        pRank.setItems(rank);
        pBloodgroup.setItems(patientBg);
        pStateofOrign.setItems(stateOgn);
        pGenotype.setItems(gt);
    }    


    @FXML
    private void getClearFields() {
                    pFname.clear();
                    pLname.clear();
                    pMname.clear();
                    pMobile.clear();
                    pEmail.clear();
                    pAddress.clear();
                    pID.clear();
                    pDepartment.clear();
                    pVillage.clear();
                    pTown.clear();
                    PCityofR.clear();
                    pSchoolAddress.clear();
                    pkFname.clear();
                    pkMname.clear();
                    pkLname.clear();
                    pkMobile.clear();
                    pkRelationship.clear();
                    pAllegy.clear();
                    pLGA.clear();
                    pDisbility.clear();


    }

    @FXML
    private void getCreatePatient(ActionEvent event) {
        String genderP = "";
String genderKP = "";

  if(maleP.isSelected())
            genderP = maleP.getText();
        else
            genderP = femaleP.getText();   
 if(pkMale.isSelected())
            genderKP = pkMale.getText();
        else
            genderKP = pkFemale.getText();     
 String status = "";
if(singleP.isSelected()){
            status = singleP.getText();
        } else if(marriedP.isSelected()){
            status = marriedP.getText();
        } else status = divoredP.getText();
        String Fname =  pFname.getText();
        String Lname = pLname.getText();
        String Mname = pMname.getText();
        String Pname = Fname+" "+Mname+" "+Lname;
        String mobileP = pMobile.getText();
        String emailp = pEmail.getText();
        String dobP =pDOB.getValue().toString();
        String addressCP =pAddress.getText();
        String paitentID=pID.getText();
        String paitentDpt=pDepartment.getText();
        String rankP = pRank.getValue().toString();
        String paitentPOB=pPlaceofBrith.getText();
        String paitentVillage=pVillage.getText();
        String paitentTown=pTown.getText();
        String paitentSO = pStateofOrign.getValue().toString();
        String paitentLGA =pLGA.getText();
        String paitentCityofR =PCityofR.getText();
        String paitentSchoolAddress =pSchoolAddress.getText();
        String paitentGenotype = pGenotype.getValue().toString();
        String paitentkFname =pkFname.getText();
        String paitentkMname =pkMname.getText();
        String paitentkLname =pkLname.getText();
        String PKname = paitentkFname+" "+paitentkMname+" "+paitentkLname;
        String paitentkMobile =pkMobile.getText();
        String paitentkEmail =pkEmail.getText();
        String paitentkRelationship =pkRelationship.getText();
        Image pimg  = patientPassport.getImage();
        String paitentAllegy =pAllegy.getText();
        String paitentDisbility =pDisbility.getText();
        String paitentBloodgrp =  pBloodgroup.getValue().toString();
        String paitentType = "Out-Patient";
        String sql = "insert into patient(paitentID,Pname,mobileP,emailp,dobP,addressCP,paitentDpt,rankP,paitentPOB,paitentVillage,genderP,genderKP,paitentTown,paitentSO,paitentLGA,paitentCityofR,paitentSchoolAddress,paitentGenotype,PKname,paitentkMobile,paitentkEmail,paitentkRelationship,pimg,paitentAllegy,paitentDisbility,status,paitentBloodgrp,paitentType)"+
                                   "values( '"+paitentID+"','"+Pname+"','"+mobileP+"','"+emailp+"','"+dobP+"','"+addressCP+"','"+paitentDpt+"','"+rankP+"','"+paitentPOB+"','"+paitentVillage+"','"+genderP+"','"+genderKP+"','"+paitentTown+"','"+paitentSO+"','"+paitentLGA+"','"+paitentCityofR+"','"+paitentSchoolAddress+"','"+paitentGenotype+"','"+PKname+"','"+paitentkMobile+"','"+paitentkEmail+"','"+paitentkRelationship+"','"+pimg+"','"+paitentAllegy+"','"+paitentDisbility+"','"+status+"','"+paitentBloodgrp+"','"+paitentType+"')";
           System.out.println(sql);
        if(data.executeAction(sql)){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("New Pateint Created ");
            alert.showAndWait();
            getClearFields();
            
        }
        else{
             Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Pateint Craeation failed");
            alert.showAndWait();
        }    

    }


    @FXML
    private void createRPatient(MouseEvent event) {
    }

    @FXML
    private void getPatientImage(ActionEvent event) throws MalformedURLException {
        FileChooser filechoose = new FileChooser();
        filechoose.setTitle("Select Image");
        filechoose.getExtensionFilters().addAll(
            new FileChooser.ExtensionFilter("Image File", "*.gif", "*.png", "*.jpg"));
        File selectedFile = filechoose.showOpenDialog(patientPassport.getScene().getWindow());
        if(selectedFile !=null){
            
            imageFile = selectedFile.toURI().toURL().toString();
            Image image = new Image(imageFile);
            patientPassport.setImage(image);
        }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("Image Selection Cancelled");
            alert.showAndWait(); 
        }
    }

    @FXML
    private void getClearEPField() {
                        epatientFN.clear();
                        epatientLN.clear();
                        epatientMN.clear();
                        epatientMobile.clear();
                        epatientAddress.clear();
                        epatientIDcard1.clear();
                        EPkinFN.clear();
                        EPkinLN.clear();
                        EPkinMobile.clear();
                        EPkinEmail.clear();
                        EPkinRelationship.clear();
                        EPkinAddress.clear();
    }

    @FXML
    private void getCreateEP(ActionEvent event) {
        
  String epgender = "";

  if(maleEP.isSelected())
            epgender = maleEP.getText();
        else
            epgender = femaleEP.getText(); 
  
String epstatus = "";
if(singleEP.isSelected()){
            epstatus = singleEP.getText();
        } else if(marriedEP.isSelected()){
            epstatus = marriedEP.getText();
        } else epstatus = divoredEP.getText();

 	String epFname =  epatientFN.getText();
        String epLname = epatientLN.getText();
        String epMname = epatientMN.getText();
        String epname = epFname+" "+epMname+" "+epLname;
	String epmobile = epatientMobile.getText();
	String epaddress = epatientAddress.getText();
	String epatientIDcard = epatientIDcard1.getText();
	String epdob =epDOB.getValue().toString();
	String epkFname =  EPkinFN.getText();
        String epkLname = EPkinLN.getText();
        String epkinname = epkFname+" "+epkLname;
	String epkmobile =EPkinMobile.getText();
	String epkemail= EPkinEmail.getText();
	String epkgender = "";

  if(EPmaleKin.isSelected())
            epkgender = EPmaleKin.getText();
        else
            epkgender = EPfemaleKin.getText(); 
	String epkrelationship = EPkinRelationship.getText();
	String epkaddress = EPkinAddress.getText();
        String sql = "insert into emergencyPatient(epatientIDcard,epname,epgender,epmobile,epaddress,epstatus,epdob,epkinname,epkmobile,epkemail,epkgender,epkrelationship,epkaddress)"+
                                   "values('"+epatientIDcard+"','"+epname+"','"+epgender+"','"+epmobile+"','"+epaddress+"','"+epstatus+"','"+epdob+"','"+epkinname+"','"+epkmobile+"','"+epkemail+"','"+epkgender+"','"+epkrelationship+"','"+epkaddress+"')";
           System.out.println(sql);
        if(data.executeAction(sql)){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("New Emergency Pateint Created ");
            alert.showAndWait();
            getClearEPField(); 
            
        }
        else{
             Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Emergency Pateint Creation failed");
            alert.showAndWait();
        }    
    }
    
}
