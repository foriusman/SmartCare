/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Receptionist;

import com.gn.GNAvatarView;
import com.jfoenix.controls.JFXTextField;
import java.io.InputStream;
import java.net.URL;
import java.sql.Blob;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.SVGPath;
import javafx.scene.text.Text;
import smartCareDataBase.DatabaseHandler;

/**
 * FXML Controller class
 *
 * @author -USER
 */
public class PatientProfileUIController implements Initializable {
     DatabaseHandler data = null;
    @FXML
    private HBox searchBox;
    @FXML
    private TextField Search;
    @FXML
    private SVGPath searchIcon;
    @FXML
    private GNAvatarView imgDisplay;
    @FXML
    private Text patientNameD;
    @FXML
    private Text patientRank;
    @FXML
    private Text patientIDD;
    @FXML
    private Text patDepartment;
    @FXML
    private GNAvatarView patientPassport;
    @FXML
    private JFXTextField pMobile;
    @FXML
    private JFXTextField pEmail;
    @FXML
    private TextArea pAddress;
    @FXML
    private JFXTextField pID;
    @FXML
    private JFXTextField pDepartment;
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
    private TextArea pSchoolAddress;
    @FXML
    private JFXTextField pkFname;
    @FXML
    private JFXTextField pkMobile;
    @FXML
    private JFXTextField pkEmail;
    @FXML
    private JFXTextField pkRelationship;
    @FXML
    private JFXTextField pDOB;
    @FXML
    private JFXTextField mStatus;
    @FXML
    private JFXTextField pGender;
    @FXML
    private JFXTextField rank;
    @FXML
    private JFXTextField stateO;
    @FXML
    private JFXTextField BLOODgrp;
    @FXML
    private JFXTextField genotype;
    @FXML
    private JFXTextField pkinGender;
    @FXML
    private Text patFullName;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        data = DatabaseHandler.getInstance();
    }    

    @FXML
    private void clearText(MouseEvent event) {
    }

    @FXML
    private void getPatientProInfo(ActionEvent event) {
        String searchKey = Search.getText();
String sql ="select * from patient where paitentID='"+searchKey+"'";
ResultSet rp2 = data.executeQuery(sql);
		 String name = "";
                 String rank = "";
                 String  id= "";
                 String  department = "";
                 Blob img;
   try{
              while(rp2.next()){
                 id = rp2.getString("paitentID");
                name = rp2.getString("Pname");
                  rank = rp2.getString("rankP");
                  department = rp2.getString("paitentDpt");
                  img= rp2.getBlob("pimg");
                 // InputStream binaryStream = img.getBinaryStream(0, img.length());
                
              }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

 if(!id.equals("")){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("Patent Found");
            alert.showAndWait();
            patientNameD.setText(name);
            patientRank.setText(rank);
            patientIDD.setText(id);
            patDepartment.setText(department);
           // imgDisplay.setImagePattern(imagePattern);
        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText(null);
            alert.setContentText("Patient Not Found");
            alert.showAndWait();
        } 
    }

    @FXML
    private void getPatientInfoDisplay(ActionEvent event) {
        String searchedP = patientIDD.getText();
        String paitentID ="";
                    String Pname="";
                    String mobileP ="";
                    String emailp ="";
                    String dobP ="";
                    String addressCP ="";
                    String paitentDpt ="";
                    String rankP ="";
                    String paitentPOB ="";
                    String paitentVillage ="";
                    String genderP ="";
                    String genderKP ="";
                    String paitentTown ="";
                    String paitentSO ="";
                    String paitentLGA ="";
                    String paitentCityofR ="";
                    String paitentSchoolAddress ="";
                    String paitentGenotype ="";
                    String PKname ="";
                    String paitentkMobile ="";
                    String paitentkEmail ="";
                    String paitentkRelationship ="";
                    String paitentAllegy ="";
                    String paitentDisbility ="";
                    String status ="";
                    String paitentBloodgrp="";
                    String pFullName ="";
        if(!searchedP.equals(" ")){
            String sql ="select * from patient where paitentID='"+searchedP+"'";
            ResultSet rp2 = data.executeQuery(sql);
                    
   try{
              while(rp2.next()){
                        paitentID = rp2.getString("paitentID");
                        Pname = rp2.getString("Pname");
                        mobileP = rp2.getString("mobileP");
                        emailp = rp2.getString("emailp");
                        dobP = rp2.getString("dobP");
                        addressCP = rp2.getString("addressCP");
                        paitentDpt = rp2.getString("paitentDpt");
                        rankP = rp2.getString("rankP");
                        paitentPOB = rp2.getString("paitentPOB");
                        genderP = rp2.getString("genderP");
                        genderKP = rp2.getString("genderKP");
                        paitentTown = rp2.getString("paitentTown");
                        paitentSO = rp2.getString("paitentSO");
                        paitentLGA = rp2.getString("paitentLGA");
                        paitentCityofR = rp2.getString("paitentCityofR");
                        paitentSchoolAddress = rp2.getString("paitentSchoolAddress");
                        paitentGenotype = rp2.getString("paitentGenotype");
                        PKname = rp2.getString("PKname");
                        paitentkMobile = rp2.getString("paitentkMobile");
                        paitentkEmail = rp2.getString("paitentkEmail");
                        paitentkRelationship = rp2.getString("paitentkRelationship");
                        paitentAllegy = rp2.getString("paitentAllegy");
                        paitentDisbility = rp2.getString("paitentDisbility");
                        status =rp2.getString("status");
                        paitentBloodgrp =rp2.getString("paitentBloodgrp"); 
                       pFullName = rp2.getString("Pname");
                       paitentVillage = rp2.getString("paitentVillage");
              }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

 if(!paitentID.equals("")){
                   
                    pMobile.setText(mobileP);
                    pEmail.setText(emailp);
                    pAddress.setText(addressCP);
                    pID.setText(paitentID);
                    pDepartment.setText(paitentDpt);
                    pPlaceofBrith.setText(paitentPOB);
                    pVillage.setText(paitentVillage);
                    pTown.setText(paitentTown);
                    pLGA.setText(paitentLGA);
                    PCityofR.setText(paitentCityofR);
                    pAllegy.setText(paitentAllegy);
                    pDisbility.setText(paitentDisbility);
                    pkFname.setText(PKname);
                    pkMobile.setText(paitentkMobile);
                    pkEmail.setText(paitentkEmail);
                    pkRelationship.setText(paitentkRelationship);
                    pDOB.setText(dobP);
                    mStatus.setText(status);
                    pGender.setText(genderP);
                    rank.setText(rankP);
                    stateO.setText(paitentSO);
                    BLOODgrp.setText(paitentBloodgrp);
                    genotype.setText(paitentGenotype);
                    pkinGender.setText(genderKP); 
                    patFullName.setText(pFullName);
                    pSchoolAddress.setText(paitentSchoolAddress);
          
           
        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText(null);
            alert.setContentText("Patient Not Found");
            alert.showAndWait();    
            }     
        } else{
        Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText(null);
            alert.setContentText("Check Patient ID");
            alert.showAndWait();
        }
    }

    @FXML
    private void getClearField(ActionEvent event) {   
                pMobile.clear();
                pEmail.clear();
                pAddress.clear();
                pID.clear();
                pDepartment.clear();
                pPlaceofBrith.clear();
                pVillage.clear();
                pTown.clear();
                pLGA.clear();
                PCityofR.clear();
                pDisbility.clear();
                pkFname.clear();
                pkMobile.clear();
                pkEmail.clear();
                pkRelationship.clear();
                pDOB.clear();
                mStatus.clear();
                pGender.clear();
                rank.clear();
                stateO.clear();
                BLOODgrp.clear();
                genotype.clear();
                pkinGender.clear();
    }
  public void myImageGetter(){}  
}
