

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Natnael
 */
public class MainUserInfo extends Application {
    
    @Override
    public void start(Stage primaryStage)  {
        FXMLLoader load=new FXMLLoader();
        Parent root;
        try {
                root = load.load(getClass().getResource("UserInforFXML.fxml"));
                Scene scene = new Scene(root);
                scene.getStylesheets().add(getClass().getResource("UserInfoCss.css").toExternalForm());
                primaryStage.setTitle("Login Page");
                primaryStage.setScene(scene);
                primaryStage.show();
                
        } catch (IOException ex) {
            System.out.println(ex);
        }
        
      
        }
        
     
     
           
    public static void main(String[] args) {
        launch(args);
    }
    
    }

  
  

