/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.tjago.speechfxapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Tomasz
 */
public class JavaFXApplication extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        System.out.println(getClass().getPackage().getName());
        Parent root = FXMLLoader.load(getClass().getResource("/views/FXMLMainAppWindow.fxml"));
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("FreeTTS sample app");
        stage.show();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
