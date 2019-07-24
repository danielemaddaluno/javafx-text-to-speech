/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.tjago.speechfxapp.util;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

/**
 *
 * @author Tomasz
 */
public class VoiceReaderService {
    
    private String voice;
    private String text;
    
    public void setVoice(String voice) {
        this.voice = voice;
    }
    
    public void setText(String textToRead) {
        this.text = textToRead;
    }
    
    public void read() {
        if (voice == null || text == null) {
            throw new NullPointerException();
        }
        VoiceManager manager = VoiceManager.getInstance();
        Voice kevin = manager.getVoice( voice );
        kevin.allocate();
        kevin.speak( text );
        kevin.deallocate();
    }
}
