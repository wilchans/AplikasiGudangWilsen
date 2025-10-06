
package id.univ.wilsen.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MenuController {
    @FXML private Button barangBtn;
    @FXML private Button supplierBtn;
    @FXML private Button customerBtn;
    @FXML private Button logoutBtn;

    @FXML
    private void openBarang(ActionEvent ev) throws Exception {
        Stage stage = (Stage) barangBtn.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/manajemen_barang.fxml"));
        Scene scene = new Scene(loader.load());
        stage.setTitle("Aplikasi Gudang - Manajemen Barang");
        stage.setScene(scene);
        stage.setResizable(false);
    }

    @FXML
    private void openSupplier(ActionEvent ev) throws Exception {
        // Placeholder - minimal implement
        System.out.println("Manajemen Supplier (not implemented in this project build).");
    }

    @FXML
    private void openCustomer(ActionEvent ev) throws Exception {
        // Placeholder - minimal implement
        System.out.println("Manajemen Customer (not implemented in this project build).");
    }

    @FXML
    private void logout(ActionEvent ev) throws Exception {
        Stage stage = (Stage) logoutBtn.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/login.fxml"));
        Scene scene = new Scene(loader.load());
        stage.setTitle("Aplikasi Gudang - Login");
        stage.setScene(scene);
        stage.setResizable(false);
    }
}
