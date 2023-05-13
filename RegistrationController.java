
import java.io.IOException;
import java.sql.*;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegistrationController implements Initializable {

    @FXML
    private TextField remail;

    @FXML
    private TextField rpassword;

    @FXML
    private Button rsignup;

    @FXML
    private TextField rusername;
    @FXML
    private Label emptyerror;

    static final String DB_URL = "jdbc:mysql://localhost/userinfo";
    static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_USER = "root";
    static final String DB_PASS = "";

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

//         rsignup.setOnAction((EventHandler<ActionEvent>) this);
    }

    @FXML
    public void sendto(ActionEvent event) throws SQLException, ClassNotFoundException, IOException {
        Class.forName(DB_DRIVER);
        String username = rusername.getText();
        String password = rpassword.getText();
        String email = remail.getText();

        if (rusername.getText().trim().isEmpty() || rpassword.getText().trim().isEmpty() || remail.getText().trim().isEmpty()) {
            emptyerror.setText("All fields are required");
        }

        Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
        String query = "INSERT INTO user (username, passsword,email) VALUES (?, ?,?)";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);
            statement.setString(3, email);
            statement.executeUpdate();
            statement.close();
            //Directd to login page(Change the scene to login page)
            Parent root = FXMLLoader.load(getClass().getResource("UserInforFXML.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene.getStylesheets().add(getClass().getResource("UserInfoCss.css").toExternalForm());
            stage.setTitle("Login Page");
            stage.setScene(scene);
            stage.show();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

}
