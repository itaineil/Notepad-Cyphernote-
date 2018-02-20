/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cyphernote;

import javafx.scene.control.TextArea;

/**
 *
 * @author USER
 */
public class TextColors {
    
     static void setBrownText(TextArea textArea) {
        
        textArea.setStyle("-fx-text-fill:brown;-fx-border-color:brown");
        
    }
    
    static void setGreenText(TextArea textArea){
        
        textArea.setStyle("-fx-text-fill:green;-fx-border-color:green;-fx-border-width:2px");
        
    
    }

    static void setRedText(TextArea textArea) {
       
          textArea.setStyle("-fx-text-fill:red;-fx-border-color:red;-fx-border-width:2px");
        
    }

    static void setBlueText(TextArea textArea) {
       
         textArea.setStyle("-fx-text-fill:blue;-fx-border-color:blue;-fx-border-width:2px");
    }

    static void setBlackText(TextArea textArea) {
       
        textArea.setStyle("-fx-text-fill:black;-fx-border-color:black;-fx-border-width:2px");
    }
    
}
