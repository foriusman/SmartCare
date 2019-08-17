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
public class PatientRecordUIController implements Initializable {

    @FXML
    private TableView<Patient> patientTableview;
    @FXML
    private TableColumn<Patient, String> snC;
    @FXML
    private TableColumn<Patient, String> patientidC;
    @FXML
    private TableColumn<Patient, String> pnameC;
    @FXML
    private TableColumn<Patient, String> pdepartC;
    @FXML
    private TableColumn<Patient, String> mobileC;
    @FXML
    private TableColumn<Patient, String> statusC;
    @FXML
    private TableColumn<Patient, String> genderC;
    @FXML
    private TableColumn<Patient, String> DisbilityC;
    @FXML
    private TableColumn<Patient, String> AllegyC;
    @FXML
    private TableColumn<Patient, String> RelationshipC;
    @FXML
    private TableColumn<Patient, String> PKnameC;
    @FXML
    private TableColumn<Patient, String> kMobileC;
    @FXML
    private TableColumn<Patient, String> kEmailC;
    @FXML
    private TableColumn<Patient, String> GenotypeC;
    @FXML
    private TableColumn<Patient, String> SchoolAddressC;
    @FXML
    private TableColumn<Patient, String> CityofRC;
    @FXML
    private TableColumn<Patient, String> LGAC;
    @FXML
    private TableColumn<Patient, String> soC;
    @FXML
    private TableColumn<Patient, String> TownC;
    @FXML
    private TableColumn<Patient, String> genderPC;
    @FXML
    private TableColumn<Patient, String> genderKPC;
    @FXML
    private TableColumn<Patient, String> VillageC;
    @FXML
    private TableColumn<Patient, String> paitentPOBC;
    @FXML
    private TableColumn<Patient, String> rankPC;
    @FXML
    private TableColumn<Patient, String> addressCPC;
    @FXML
    private TableColumn<Patient, String> PDOBC;
    @FXML
    private TableColumn<Patient, String> emailPC;
    @FXML
    private JFXTextField searchBar;
    DatabaseHandler data = null;
    ObservableList<Patient> data1 =FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        data = DatabaseHandler.getInstance();
        viewPatientTable();
        initPatientCol();
        
    }    
    public  void viewPatientTable(){
                 
            String sql ="select * from patient";
            ResultSet rp = data.executeQuery(sql);
                    
   try{
              while(rp.next()){
                       String  ssn = rp.getString("ssn");
                       String   paitentID = rp.getString("paitentID");
                        String  Pname = rp.getString("Pname");
                         String mobileP = rp.getString("mobileP");
                         String emailp = rp.getString("emailp");
                        String  dobP = rp.getString("dobP");
                        String  addressCP = rp.getString("addressCP");
                        String  paitentDpt = rp.getString("paitentDpt");
                       String   rankP = rp.getString("rankP");
                       String   paitentPOB = rp.getString("paitentPOB");
                       String   genderP = rp.getString("genderP");
                      String    genderKP = rp.getString("genderKP");
                        String  paitentTown = rp.getString("paitentTown");
                        String  paitentSO = rp.getString("paitentSO");
                        String  paitentLGA = rp.getString("paitentLGA");
                        String  paitentCityofR = rp.getString("paitentCityofR");
                        String  paitentSchoolAddress = rp.getString("paitentSchoolAddress");
                        String  paitentGenotype = rp.getString("paitentGenotype");
                        String  PKname = rp.getString("PKname");
                       String   paitentkMobile = rp.getString("paitentkMobile");
                        String  paitentkEmail = rp.getString("paitentkEmail");
                        String  paitentkRelationship = rp.getString("paitentkRelationship");
                        String  paitentAllegy = rp.getString("paitentAllegy");
                        String  paitentDisbility = rp.getString("paitentDisbility");
                         String status =rp.getString("status");
                         String  paitentBloodgrp =rp.getString("paitentBloodgrp"); 
                     // String   pFullName = rp.getString("Pname");
                        String paitentVillage = rp.getString("paitentVillage");
               
                  if(!paitentID.equals("")){
                      
                data1.add(new Patient(ssn,paitentID,Pname,mobileP,emailp,dobP,addressCP,paitentDpt,rankP,
                        paitentPOB,paitentVillage,genderP,genderKP,paitentTown,paitentSO,paitentLGA,
                        paitentCityofR,paitentSchoolAddress,paitentGenotype,PKname,paitentkMobile,
                        paitentkEmail,paitentkRelationship,paitentAllegy,paitentDisbility,status,paitentBloodgrp));               
          
                }
              }
        }catch(Exception e){
             patientTableview.setItems(data1);
        } patientTableview.setItems(data1);
    

            
 }
   
    public void initPatientCol(){
               
                snC.setCellValueFactory(new PropertyValueFactory<>("ssn"));
                patientidC.setCellValueFactory(new PropertyValueFactory<>("paitentID"));
                pnameC.setCellValueFactory(new PropertyValueFactory<>("Pname"));
                pdepartC.setCellValueFactory(new PropertyValueFactory<>("paitentDpt"));
                mobileC.setCellValueFactory(new PropertyValueFactory<>("mobileP"));
                statusC.setCellValueFactory(new PropertyValueFactory<>("status"));
                genderC.setCellValueFactory(new PropertyValueFactory<>("genderP"));
                DisbilityC.setCellValueFactory(new PropertyValueFactory<>("paitentDisbility"));
                AllegyC.setCellValueFactory(new PropertyValueFactory<>("paitentAllegy"));
                RelationshipC.setCellValueFactory(new PropertyValueFactory<>("paitentkRelationship"));
                PKnameC.setCellValueFactory(new PropertyValueFactory<>("PKname"));
                kMobileC.setCellValueFactory(new PropertyValueFactory<>("paitentkMobile"));
                kEmailC.setCellValueFactory(new PropertyValueFactory<>("paitentkEmail"));
                GenotypeC.setCellValueFactory(new PropertyValueFactory<>("paitentGenotype"));
                SchoolAddressC.setCellValueFactory(new PropertyValueFactory<>("paitentSchoolAddress"));
                CityofRC.setCellValueFactory(new PropertyValueFactory<>("paitentCityofR"));
                LGAC.setCellValueFactory(new PropertyValueFactory<>("paitentLGA"));
                soC.setCellValueFactory(new PropertyValueFactory<>("paitentSO"));
                TownC.setCellValueFactory(new PropertyValueFactory<>("paitentTown"));
                genderPC.setCellValueFactory(new PropertyValueFactory<>("genderP"));
                genderKPC.setCellValueFactory(new PropertyValueFactory<>("genderKP"));
                VillageC.setCellValueFactory(new PropertyValueFactory<>("paitentVillage"));
                paitentPOBC.setCellValueFactory(new PropertyValueFactory<>("paitentPOB"));
                rankPC.setCellValueFactory(new PropertyValueFactory<>("rankP"));
                addressCPC.setCellValueFactory(new PropertyValueFactory<>("addressCP"));
                PDOBC.setCellValueFactory(new PropertyValueFactory<>("dobP"));
                emailPC.setCellValueFactory(new PropertyValueFactory<>("emailp"));
                System.out.println(data1);
    
    }
    @FXML
    private void getSearchResult(ActionEvent event) {
        String searchKey = searchBar.getText();
                    String ssn ="";
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
        
         String sql ="select * from patient where paitentID='"+searchKey+"'";
            ResultSet rp2 = data.executeQuery(sql);
         
       
            try{
              while(rp2.next()){
                        ssn = rp2.getString("ssn");
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
                 
            if(!paitentID.equals("")){
                 Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("Patient Found");
            alert.showAndWait();
	    data1.clear(); //ssn,
            data1.add(new Patient(ssn,paitentID,Pname,mobileP,emailp
	,dobP,addressCP,paitentDpt,rankP,paitentPOB,paitentVillage
	,genderP,genderKP,paitentTown,paitentSO,paitentLGA
	,paitentCityofR,paitentSchoolAddress,paitentGenotype,
	PKname,paitentkMobile,paitentkEmail,paitentkRelationship,
       paitentAllegy,paitentDisbility,status,paitentBloodgrp));
             initPatientCol();
             //System.out.print("done with search: "+ ssn);
        }else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText(null);
            alert.setContentText("Patient Not Found");
            alert.showAndWait();
            patientTableview.setItems(data1);
        }               
            }patientTableview.setItems(data1);
        }catch(Exception e){
            patientTableview.setItems(data1);   
        }
       patientTableview.setItems(data1);
    }

    @FXML
    private void getRefreshed(ActionEvent event) {
        searchBar.clear();
        viewPatientTable();
        initPatientCol();
    }
   public static class Patient {
       
       private final SimpleStringProperty ssn,paitentID,Pname,mobileP,emailp
	,dobP,addressCP,paitentDpt,rankP,paitentPOB,paitentVillage
	,genderP,genderKP,paitentTown,paitentSO,paitentLGA
	,paitentCityofR,paitentSchoolAddress,paitentGenotype,
	PKname,paitentkMobile,paitentkEmail,paitentkRelationship,
       paitentAllegy,paitentDisbility,status,paitentBloodgrp;
       
       @FXML
        public String getSsn() {
            return ssn.get();
        }
       @FXML
        public String getPaitentID() {
            return paitentID.get();
        }
         @FXML
        public String getPname() {
            return Pname.get();
        }
          @FXML
        public String getMobileP() {
            return mobileP.get();
        }
            @FXML
        public String getEmailp() {
            return emailp.get();
        }
             @FXML
        public String getDobP() {
            return dobP.get();
        }
              @FXML
        public String getAddressCP(){
            return addressCP.get();
        }
               @FXML
        public String getPaitentDpt(){
            return paitentDpt.get();
        }
         @FXML
        public String getRankP(){
            return rankP.get();
        }
         @FXML
        public String getPaitentPOB(){
            return paitentPOB.get();
        }
         @FXML
        public String getPaitentVillage(){
            return paitentVillage.get();
        }
         @FXML
        public String getGenderP(){
            return genderP.get();
        }
         @FXML
        public String getGenderKP(){
            return genderKP.get();
        }
          @FXML
        public String getPaitentTown(){
            return paitentTown.get();
        }
          @FXML
        public String getPaitentSO(){
            return paitentSO.get();
        }
         @FXML
        public String getPaitentLGA(){
            return paitentLGA.get();
        }
          @FXML
        public String getPaitentCityofR(){
            return paitentCityofR.get();
        }
           @FXML
        public String getPaitentSchoolAddress(){
            return paitentSchoolAddress.get();
        }
               @FXML
        public String getPaitentGenotype(){
            return paitentGenotype.get();
        }
               @FXML
        public String getPKname(){
            return PKname.get();
        }
                   @FXML
        public String getPaitentkMobile(){
            return paitentkMobile.get();
        }
           @FXML
        public String getPaitentkEmail(){
            return paitentkEmail.get();
        }
           @FXML
        public String getPaitentkRelationship(){
            return paitentkRelationship.get();
        }
             @FXML
        public String getPaitentAllegy(){
            return paitentAllegy.get();
        }
             @FXML
        public String getPaitentDisbility(){
            return paitentDisbility.get();
        }
            @FXML
        public String getStatus(){
            return status.get();
        }
            @FXML
         public String getPaitentBloodgrp(){
            return paitentBloodgrp.get();
        }
         
         
   public Patient(String ssn,String paitentID,String Pname,String mobileP,String emailp
	,String dobP,String addressCP,String paitentDpt,String rankP,String paitentPOB,String paitentVillage
	,String genderP,String genderKP,String paitentTown,String paitentSO,String paitentLGA
	,String paitentCityofR,String paitentSchoolAddress,String paitentGenotype,
	String PKname,String paitentkMobile,String paitentkEmail,String paitentkRelationship,
       String paitentAllegy,String paitentDisbility,String status,String paitentBloodgrp) {
       this.ssn = new SimpleStringProperty(ssn);
       this.paitentID = new SimpleStringProperty(paitentID);
       this.Pname = new SimpleStringProperty(Pname);
       this.mobileP = new SimpleStringProperty(mobileP);
       this.emailp = new SimpleStringProperty(emailp);
       this.dobP = new SimpleStringProperty(dobP);
       this.addressCP = new SimpleStringProperty(addressCP);
       this.paitentDpt = new SimpleStringProperty(paitentDpt);
        this.rankP = new SimpleStringProperty(rankP);
        this.paitentPOB = new SimpleStringProperty(paitentPOB);
        this.paitentVillage = new SimpleStringProperty(paitentVillage);
        this.genderP = new SimpleStringProperty(genderP);
        this.paitentTown = new SimpleStringProperty(paitentTown);
        this.paitentSO = new SimpleStringProperty(paitentSO);
        this.paitentLGA = new SimpleStringProperty(paitentLGA);
        this.paitentCityofR = new SimpleStringProperty( paitentCityofR);
        this.paitentSchoolAddress = new SimpleStringProperty(paitentSchoolAddress);
        this.paitentGenotype = new SimpleStringProperty(paitentGenotype);
        this.PKname = new SimpleStringProperty(PKname);
        this.paitentkMobile = new SimpleStringProperty(paitentkMobile);
        this.paitentkEmail = new SimpleStringProperty(paitentkEmail);
        this.paitentkRelationship = new SimpleStringProperty(paitentkRelationship);
        this.paitentAllegy = new SimpleStringProperty(paitentAllegy);
         this.paitentDisbility = new SimpleStringProperty(paitentDisbility);
         this.status = new SimpleStringProperty(status);
         this.paitentBloodgrp = new SimpleStringProperty(paitentBloodgrp);
         this.genderKP = new SimpleStringProperty(genderKP);
   }
   } 
}
