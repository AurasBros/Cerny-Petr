
package cernypetr;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * v. 3
 * @author jan1h
 */
public class CernyPetr extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        People people = new People();
        String Myfxml;
        
        if (people.connectivity()) {
            Myfxml = "login.fxml";
            stage.setFullScreen(true);
        } else {
            Myfxml = "ConnectionErr.fxml";
            stage.setFullScreen(false);
        }
        
        Parent root = FXMLLoader.load(getClass().getResource(Myfxml));
        root.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        
        
        Scene scene = new Scene(root);
        //scene.getStylesheets().add("styles.css");
        
        stage.setResizable(false);
        //stage.setMaximized(true);
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
