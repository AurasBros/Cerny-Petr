
package cernypetr;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


/**
 *
 * @author jan1h
 */
public class Controller implements Initializable {
    People people = new People();

    
    
    @FXML private TextField inNameLogin, inNameRegister;
    @FXML private PasswordField inPswLogin, inPswRegister, inPswRegisterRepeat;
    String NameLogin, PswLogin, NameRegister, PswRegister, PswRegisterRepeat;
    @FXML private Label outMssg;
    @FXML private Button btnLogin, btnRegister;
    @FXML private VBox udaje, nadpis;
    @FXML private HBox panel;
    
    
    
    @FXML private void handleLoginAction(ActionEvent event) throws IOException {
        NameLogin = inNameLogin.getText();
        PswLogin = inPswLogin.getText();
        
        Login login = new Login(NameLogin, PswLogin);
        login.doLogin();
        outMssg.setText(login.getMssg());
        

        
        if (login.getMssg().equals("Prihlaseni probehlo uspesne.")) {
                //udaje.setManaged(false);
                //udaje.managedProperty().bind(udaje.visibleProperty());
                udaje.setVisible(false);
                nadpis.setVisible(false);
                
                
                HBox box = new HBox();
                
                TextField vyhledej = new TextField();
                box.getChildren().add(vyhledej);
                vyhledej.getStyleClass().add("text-ramecek");
                
                Button btnSearch = new Button("Vyhledej");
                box.getChildren().add(btnSearch);
                btnSearch.getStyleClass().add("tlacitko");
                
                panel.getChildren().add(box);
                
                btnSearch.setOnAction(new EventHandler<ActionEvent>() {
                    @Override public void handle(ActionEvent e) {
                        String playerName = "";
                        playerName = vyhledej.getText();
                        if (people.doesUserExist(playerName)) {
                            Label nameLabel = new Label(playerName);
                            nameLabel.getStyleClass().add("player-name");
                            box.getChildren().add(nameLabel);
                            
                            Button btnVyzvat = new Button("Vyzvat na souboj");
                            box.getChildren().add(btnVyzvat);
                            btnVyzvat.getStyleClass().add("tlacitko");                            
                        }
        
                        
                        
                    }
                });
        }
    }  
    
    @FXML
    private void handleRegisterAction(ActionEvent event) {
        NameRegister = inNameRegister.getText();
        PswRegister = inPswRegister.getText();
        PswRegisterRepeat = inPswRegisterRepeat.getText();
        
        Register register = new Register(NameRegister, PswRegister, PswRegisterRepeat);
        register.doRegister();
        outMssg.setText(register.getMssg());
        
        
    }
    



    
    

   
    
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     
    }    
    
}
//Label label2 = new Label("Search");