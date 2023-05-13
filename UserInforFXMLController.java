
 
import java.sql.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
public class UserInforFXMLController implements Initializable {

    
    //Database info
    static final String DB_URL="jdbc:mysql://localhost/userinfo";
    static final String DB_DRIVER= "com.mysql.cj.jdbc.Driver";
    static final String DB_USER="root";
    static final String DB_PASS="";

//
//    @FXML
//    private Button login;
//

//
//    @FXML
//    private Label signup;
//
   @FXML
   private TextField username;  
      @FXML
   private Label errorname;

    @FXML
    private Label errorpassword;
    @FXML
    private TextField password;
      Connection connection ;
        ResultSet result;
          PreparedStatement ps;
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
  
         
         
    }  
    
      @FXML
    void log(ActionEvent event) {
           if (username.getText().trim().isEmpty())
                 errorname.setText("Name can not be empty");
            if(password.getText().trim().isEmpty())
                 errorpassword.setText("password can not be empty");
           
          
          
            
            
            
         String inputName=username.getText();
        String inputPassword=password.getText();
        
        
        try {
             connection = DriverManager.getConnection(DB_URL,DB_USER,DB_PASS);
            String query="select * from user where username=? AND passsword=?";
            ps=connection.prepareStatement(query);
            ps.setString(1,inputName );
            ps.setString(2,inputPassword);
           result=ps.executeQuery();
              if(!result.next())
                  errorname.setText("Please check your User name or password");
              else{
                                                Parent root;
                           try {
                                root = FXMLLoader.load(getClass().getResource("Registration.fxml"));
                                Scene scene=new Scene(root);
                                scene.getStylesheets().add(getClass().getResource("registeration.css").toExternalForm());
                                Stage stage=  (Stage)((Node)event.getSource()).getScene().getWindow();
                                stage.setScene(scene);
                                stage.setTitle("Registration Page");
                                stage.show();
                           } catch (IOException ex) {
                                System.out.println(ex);
                   
       }
              }
            
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        finally{
            
            
            try {
                connection.close();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
            try {
                result.close();
            } catch (SQLException ex) {
                  System.out.println(ex);
            }
            try {
                ps.close();
            } catch (SQLException ex) {
             System.out.println(ex);
            }
            
            
        }
        
     
        
        
        //Get in to the system
          

    }
    
   
    
    @FXML
    void gotoregister(MouseEvent event) {
         Parent root;
       try {
            root = FXMLLoader.load(getClass().getResource("Registration.fxml"));
            Scene scene=new Scene(root);
             scene.getStylesheets().add(getClass().getResource("registeration.css").toExternalForm());
            Stage stage=  (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
       } catch (IOException ex) {
            System.out.println(ex);
                   
       }
        

         
    }
    
    
    
}
