/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */


import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author user
 */
public class AdminController implements Initializable {

   
    @FXML
    private Button btnAdd;

    @FXML
    private Label lbltext;

    @FXML
    private PasswordField tfEPass;

    @FXML
    private TextField tfEUser;

    @FXML
    private TextField tfRole;
    	   static final String DB_URL = "jdbc:mysql://localhost/jdbcclass";
	    static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
	    static final String DB_USER = "root";
	    static final String DB_PASS = "";
    public void addEmployee(ActionEvent event){
        String username=tfEUser.getText();
        String password=tfEPass.getText();
        String role=tfRole.getText();
         if (!username.isEmpty() && !password.isEmpty() && role != null){
        try{
          String query = "INSERT INTO userss (UserName, Password, Role) VALUES (?, ?, ?)";
          Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS); 
         PreparedStatement statement = connection.prepareStatement(query); 
         statement.setString(1, username);
          statement.setString(2, password);
           statement.setString(3,role);
           statement.executeUpdate();
            lbltext.setText(" employee succssfully added");
        }
    catch(SQLException e) {
    e.printStackTrace();
}}
         else{
            lbltext.setText("please enter all fields");
         }   
    
    
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
