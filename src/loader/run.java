/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loader;

import com.jfoenix.controls.JFXProgressBar;
import java.io.IOException;
import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/**
 *
 * @author -USER
 */
public class run extends Application {
    private JFXProgressBar progressBar;
    private Parent view;
    private Stage stage;


    @Override
    public void init(){
        try {
            view = FXMLLoader.load(getClass().getResource("smartCareLoader.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void start(Stage primary){
        stage = primary;
        primary.initStyle(StageStyle.TRANSPARENT);
        Scene scene = new Scene(view);
        scene.setFill(Color.TRANSPARENT);
        scene.getStylesheets().add(getClass().getResource("/theme/css/fonts.css").toExternalForm());
        primary.setScene(scene);

        primary.show();
        System.out.println("start entered");
        
        PauseTransition pauseTransition =new PauseTransition();
            pauseTransition.setDuration(Duration.seconds(8));
        pauseTransition.setOnFinished(ev ->{
           primary.close();
                 
            grim();
        });
        pauseTransition.play();
    
}
    public void grim(){
                 try    {   Image image = new Image("logo.png");
                            Parent root = FXMLLoader.load(getClass().getResource("/smartLogin/smartCareLogin.fxml"));
                               Scene scene1 = new Scene(root);
                                Stage stage = new Stage(StageStyle.DECORATED);
                                    stage.setScene(scene1);
                                    stage.getIcons().add(image);
                                    stage.setTitle("Smart Care Software");
                                    stage.show();
                                 
                        }
                            catch(Exception e){
                                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                   alert.setHeaderText(null);
                                   alert.setContentText(e.getMessage());
                                   alert.showAndWait();

                               }

              
    }
     public static void main(String[] args){
        launch(args);
 }
}
