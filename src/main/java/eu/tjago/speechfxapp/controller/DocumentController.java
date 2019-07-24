/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.tjago.speechfxapp.controller;

import java.net.URL;
import java.util.ResourceBundle;

import eu.tjago.speechfxapp.App;
import eu.tjago.speechfxapp.util.ResourceSingleton;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

/**
 *
 * @author Tomasz
 */
@SuppressWarnings({"static-access"})
public class DocumentController implements Initializable {
    
    @FXML
    Button btnReadAction;
    
    @FXML
    TextArea textArea;
    
    @FXML
    public void initialize(URL url, ResourceBundle rb) {
        textChangedAction();
        
        textArea.textProperty().addListener(new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> ov, String t, String t1) {
                textChangedAction();
            }
        });
    }    
    
    @FXML
    public void openDialogBox(ActionEvent event) throws Exception {
        System.out.println("clicked Read button.");
        
//        Stage stage = new Stage();
//        Parent root = FXMLLoader.load(
//            JavaFXApplication.class.getResource("/views/FXMLModalDialog.fxml"));
//        stage.setScene(new Scene(root));
//        stage.setTitle("Modal window");
//        stage.initModality(Modality.WINDOW_MODAL);
//        stage.initOwner(
//            ((Node)event.getSource()).getScene().getWindow() );
//        stage.show();
        App.setRoot("secondary");
    }
    
    public void textChangedAction() {
        String newText = textArea.getText();
        
//        System.out.println("text changed to: " + newText);
        ResourceSingleton.getInstance().setText( newText );
    }
    
}
