/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.tjago.speechfxapp.util;

/**
 *
 * @author Tomasz
 */
public class ResourceSingleton {
    public static ResourceSingleton instance;
    private static String text;

    private ResourceSingleton() {
    }
    
    synchronized public static ResourceSingleton getInstance() { 
        if (instance == null) {
            instance = new ResourceSingleton();
            return instance;
        } else {
            return instance;
        }
    }

    synchronized public static String getText() {
        return text;
    }

    synchronized public static void setText(String text) {
        ResourceSingleton.text = text;
    }
    
    
}
