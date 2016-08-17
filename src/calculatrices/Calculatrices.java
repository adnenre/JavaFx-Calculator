/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculatrices;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author versus
 */
public class Calculatrices extends Application {
    
    /**
     *
     * @param stage
     * @throws Exception
     */
    //input from keybord
    //point
    //designe
      //when mouse button is pressed, save the initial position of screen
          private double initX;
          private double initY;   
    @Override
    public void start(final Stage stage) throws Exception {
        stage.initStyle(StageStyle.UNDECORATED);
      
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
       
         root.setOnMousePressed(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent me) {
                        initX = me.getScreenX() - stage.getX();
                        initY = me.getScreenY() - stage.getY();
                    }
                });

                //when screen is dragged, translate it accordingly
                root.setOnMouseDragged(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent me) {
                        stage.setX(me.getScreenX() - initX);
                        stage.setY(me.getScreenY() - initY);
                    }
                });
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
