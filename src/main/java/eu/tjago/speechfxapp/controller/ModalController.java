/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.tjago.speechfxapp.controller;

import eu.tjago.speechfxapp.util.ResourceSingleton;
import eu.tjago.speechfxapp.util.VoiceReaderService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

/**
 *
 * @author Tomasz
 */
@SuppressWarnings({"rawtypes", "unchecked", "static-access"})
public class ModalController implements Initializable {
    
	@FXML
    ComboBox comboVoice;
    
    @FXML
    Button btnStop;
    
    @FXML
    Button btnSpeak;
    
    private Thread voiceReadingThread;
    
	@FXML
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("adding items to Combobox");//Fill voices comboBox
        
//        showVoicesList(manager);
//        ObservableList<String> itemsList;
//        itemsList = FXCollections.observableArrayList("kevin", "kevin16");
//        comboVoice.setItems(itemsList);
        comboVoice.getItems().addAll("alan", "kevin", "kevin16");
        comboVoice.getSelectionModel().select("kevin16");
    }
    
    @FXML
    public void actionCloseModal(ActionEvent event) {
        ((Stage)comboVoice.getScene().getWindow()).close();
    }
    
	@FXML
    public void actionReadText(ActionEvent event) {
        
        final String selectedVoice = comboVoice.getSelectionModel().getSelectedItem().toString();
        final String inputText = ResourceSingleton.getInstance().getText();
        System.out.println("selected voice: " + selectedVoice);
        System.out.println("input text: " + inputText);
        
        
        voiceReadingThread = new Thread () {
            public void run() {
                VoiceReaderService voiceService = new VoiceReaderService();
                voiceService.setVoice( selectedVoice );
                voiceService.setText( inputText );
                voiceService.read();
            }
        };
        voiceReadingThread.start();
        btnStop.setDisable(false);
        btnSpeak.setDisable(true);
        
    }
    
    @FXML
    public void stopReading(ActionEvent event) {
//        voiceReadingThread.stop();
        voiceReadingThread.interrupt();
        System.out.println("Stopping thread.");
        
        btnStop.setDisable(true);
        btnSpeak.setDisable(false);
    }
}
