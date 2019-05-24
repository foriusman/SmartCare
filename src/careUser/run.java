/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package careUser;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author -USER
 */
public class run extends Application {
     @Override
    
 public void start(Stage stage) throws Exception{
      Image image = new Image("logo.png");
     Parent root = FXMLLoader.load(getClass().getResource("createUser.fxml"));
     Scene scene = new Scene(root);
     stage.setScene(scene);
     stage.getIcons().add(image);
     stage.setTitle("Smart Care Software");
     stage.show();
 }
 
 
 public static void main(String[] args){
        launch(args);
 }
}
