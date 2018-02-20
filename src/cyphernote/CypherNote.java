

package cyphernote;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author USER
 */
public class CypherNote extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
       
        Pane root = FXMLLoader.load(getClass().getResource("cypherlayout.fxml"));
        
        Scene scene = new Scene(root);
        stage.setTitle("CypherNote");
        stage.setWidth(700);
        stage.setHeight(500);
        stage.setScene(scene);
        
        cypherlayoutController.stage = stage;
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}