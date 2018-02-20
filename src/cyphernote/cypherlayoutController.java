/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cyphernote;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author USER
 */
public class cypherlayoutController implements Initializable {
    
   @FXML
    public  TextArea textArea;
    public Label label;
    
    
   
    @FXML
    //file menu items
    public MenuItem openFile,newFile,saveFile,saveAsFile,closeWindow;
    //edit menu items
    @FXML
    public MenuItem copy,cut,paste,selectAll,deletePrevious,deleteNext;
    //textColor menu items
    @FXML
    public MenuItem fontBrown,fontGreen,fontRed,fontBlue,fontVerdana,fontBold,fontDefault;
    
    @FXML
    public MenuItem aboutCypherNote;
    
    public FileChooser chooser = new FileChooser();
    String textPaneContent;
    public static Stage stage;
    private File file;
    
    @FXML
    public void aboutCypher(ActionEvent event){
        
     Stage lstage = new Stage();
     lstage.setTitle("About CypherNote");
     lstage.setWidth(400);
     
     lstage.setHeight(400);
     VBox box = new VBox();
     box.getChildren().addAll(new Label("Simple Text Editor"),new Label("By Itai Chiriseri"));
     Scene scene = new Scene(box);
     lstage.setScene(scene);
     lstage.setResizable(false);
     lstage.show();
     
     
     
     
     
    }
    
     @FXML
    public void openFile(ActionEvent e){
        
        textArea.clear();
        
        this.file = chooser.showOpenDialog(null);
        
        if(this.file!=null){
            
            
            stage.setTitle(this.file.getName() + "*CypherNote");
            
            BufferedReader bufferedReader = null;
            
            try{
            
                String line;
                
                FileInputStream fis = new FileInputStream(file);
                BufferedReader inputReader = new BufferedReader(new InputStreamReader(fis));
                
               
                
                //bufferedReader = new BufferedReader(new FileReader(this.file));
                
                while((line = inputReader.readLine())!=null)
                    
                    textArea.appendText(line + "\n");
                    
                    
                
                
            }catch(Exception ex){
                
                ex.printStackTrace();
                
            }
            
            
            
            
            
        }
    
    }
     
      @FXML
    
    
    
    
    public void createNew(ActionEvent event){
        
        
       createNewFile("Untitled *CypherText",textArea);
        
        
      
    }
    
    public void fontBold(ActionEvent event){
        
        textArea.setStyle("-fx-font:bold");
        
        
        
    }
     private void createNewFile(String message, TextArea textArea) {
       
        textArea.clear();
        stage.setTitle(message);
        
    }
    
    public void saveFile(ActionEvent event) throws IOException{
        
        
      
        
    }
    
    public void saveAsFile(ActionEvent event) throws IOException{
     
        
        this.file = this.chooser.showSaveDialog(null);
		
		String content = this.textArea.getText();
	
                
                    if(this.file!=null){
                    
                    Stage myStage = (Stage) this.textArea.getScene().getWindow();
                    stage.setTitle(this.file.getName() + " - CypherNote");
                    
                    try{
                        
                        FileOutputStream stream = new FileOutputStream(file);
                        byte [] gotContent = content.getBytes();
                        stream.write(gotContent);
                        stream.close();
                        
                    }catch(Exception ex){
                        
                        ex.printStackTrace();
                    }
		}
	}
    
    


    public void onCut(ActionEvent event){
        
        cutText(textArea);
    }
    
    public void deletePreviousChar(ActionEvent event){
        
        deletePreviousCharacter(textArea);
    }
    
    public void onCopy(ActionEvent event){
        
        copyText(textArea);
        
        
    }

    public void onPaste(ActionEvent event){
        
        pasteText(textArea);
    }
    
    public void onSelectAll(ActionEvent event){
        
        selectAll(textArea);
    
    
    }
    
    public void deleteNextChar(ActionEvent event){
        
        textArea.deleteNextChar();
    }
    
     
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        mapKeysToControls();
        
    }   
    
     private void mapKeysToControls() {
       
     KeyCombination deleteP = new KeyCodeCombination(KeyCode.D,KeyCombination.ALT_DOWN);
     deletePrevious.setAccelerator(deleteP);
     KeyCombination deleteN = new KeyCodeCombination(KeyCode.J,KeyCombination.ALT_DOWN);
     deleteNext.setAccelerator(deleteN);
     KeyCombination createFile = new KeyCodeCombination(KeyCode.N,KeyCombination.CONTROL_DOWN);
     newFile.setAccelerator(createFile);
     KeyCombination openingFile = new KeyCodeCombination(KeyCode.O,KeyCombination.CONTROL_DOWN);
     openFile.setAccelerator(openingFile);
     KeyCombination savefile = new KeyCodeCombination(KeyCode.S,KeyCombination.CONTROL_DOWN);
     saveFile.setAccelerator(savefile);
     KeyCombination copY = new KeyCodeCombination(KeyCode.C,KeyCombination.CONTROL_DOWN);
     copy.setAccelerator(copY);
     KeyCombination pastE = new KeyCodeCombination(KeyCode.V,KeyCombination.CONTROL_DOWN);
     paste.setAccelerator(pastE);
     KeyCombination cuT = new KeyCodeCombination(KeyCode.X,KeyCombination.CONTROL_DOWN);
     cut.setAccelerator(cuT);
     KeyCombination selectALL = new KeyCodeCombination(KeyCode.A,KeyCombination.CONTROL_DOWN);
     selectAll.setAccelerator(selectALL);
     KeyCombination brownText = new KeyCodeCombination(KeyCode.Q,KeyCombination.ALT_DOWN);
     fontBrown.setAccelerator(brownText);
     KeyCombination greenText = new KeyCodeCombination(KeyCode.G,KeyCombination.ALT_DOWN);
     fontGreen.setAccelerator(greenText);
     KeyCombination redText = new KeyCodeCombination(KeyCode.R,KeyCombination.ALT_DOWN);
     fontRed.setAccelerator(redText);
     KeyCombination blueText = new KeyCodeCombination(KeyCode.B,KeyCombination.ALT_DOWN);
     fontBlue.setAccelerator(blueText);
    
     }
     
     private void copyText(TextArea textArea) {
       
        textArea.copy();
        
    }

    private void pasteText(TextArea textArea) {
        textArea.paste();
        
       }

    private void selectAll(TextArea textArea) {
       
        textArea.selectAll();
        
        
        
    }

    private void cutText(TextArea textArea) {
       
        textArea.cut();
        
        
    }
    
   
   
    public void fontBrown(ActionEvent event){
        
        TextColors.setBrownText(textArea);
    }
    
    public void fontGreen(ActionEvent event){
        
        TextColors.setGreenText(textArea);
        
    }
    
    public void fontRed(ActionEvent event){
        
        TextColors.setRedText(textArea);
    }

    public void fontBlue(ActionEvent event){
        
        TextColors.setBlueText(textArea);
        
    }
    
    public void fontDefault(ActionEvent event){
        
        TextColors.setBlackText(textArea);
    }
    
    public void close(){
        
        stage.close();
    }

    private void deletePreviousCharacter(TextArea textArea) {
        
        textArea.deletePreviousChar();
    }
    
   
    }
    



