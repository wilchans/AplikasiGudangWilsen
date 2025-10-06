
package id.univ.wilsen.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {
    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    @FXML private Label messageLabel;
    @FXML private Button loginButton;

    @FXML
    private void initialize() {
        messageLabel.setText("");
    }

    @FXML
    private void onLogin(ActionEvent ev) throws Exception {
        String u = usernameField.getText().trim();
        String p = passwordField.getText().trim();
        if (u.equals("admin") && p.equals("123")) {
            // open menu utama
            Stage stage = (Stage) loginButton.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/menu.fxml"));
            Scene scene = new Scene(loader.load());
            stage.setTitle("Aplikasi Gudang - Menu Utama");
            stage.setScene(scene);
            stage.setResizable(false);
        } else {
            messageLabel.setText("Login gagal!");
        }
    }
}
