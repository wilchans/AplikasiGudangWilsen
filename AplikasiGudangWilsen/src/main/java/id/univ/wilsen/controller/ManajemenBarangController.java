
package id.univ.wilsen.controller;

import id.univ.wilsen.model.Barang;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

public class ManajemenBarangController {
    @FXML private TextField namaField;
    @FXML private TextField jumlahField;
    @FXML private TableView<Barang> tabel;
    @FXML private TableColumn<Barang, String> colNama;
    @FXML private TableColumn<Barang, Integer> colJumlah;
    @FXML private Button tambahBtn;
    @FXML private Button editBtn;
    @FXML private Button hapusBtn;
    @FXML private Label messageLabel;

    private ObservableList<Barang> data = FXCollections.observableArrayList();
    private Barang selected = null;

    @FXML
    private void initialize() {
        colNama.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(cell.getValue().getNama()));
        colJumlah.setCellValueFactory(cell -> new javafx.beans.property.SimpleIntegerProperty(cell.getValue().getJumlah()).asObject());
        tabel.setItems(data);
        messageLabel.setText("");
    }

    @FXML
    private void onTambah(ActionEvent ev) {
        String nama = namaField.getText().trim();
        String jumlahText = jumlahField.getText().trim();
        if (nama.isEmpty() || jumlahText.isEmpty()) {
            messageLabel.setText("Mandatory field harus diisi");
            return;
        }
        int jumlah = 0;
        try {
            jumlah = Integer.parseInt(jumlahText);
            if (jumlah < 0) { messageLabel.setText("Jumlah tidak boleh negatif"); return; }
        } catch (NumberFormatException e) {
            messageLabel.setText("Jumlah harus angka");
            return;
        }

        if (selected != null) {
            // update
            selected.setNama(nama);
            selected.setJumlah(jumlah);
            tabel.refresh();
            selected = null;
            messageLabel.setText("Data berhasil diperbarui");
        } else {
            // add new
            data.add(new Barang(nama, jumlah));
            messageLabel.setText("Data berhasil ditambahkan");
        }
        namaField.clear();
        jumlahField.clear();
    }

    @FXML
    private void onEdit(ActionEvent ev) {
        Barang b = tabel.getSelectionModel().getSelectedItem();
        if (b == null) {
            messageLabel.setText("Pilih data terlebih dahulu");
            return;
        }
        selected = b;
        namaField.setText(b.getNama());
        jumlahField.setText(String.valueOf(b.getJumlah()));
        messageLabel.setText("Mode edit: ubah lalu tekan Tambah untuk menyimpan");
    }

    @FXML
    private void onHapus(ActionEvent ev) {
        Barang b = tabel.getSelectionModel().getSelectedItem();
        if (b == null) {
            messageLabel.setText("Pilih data terlebih dahulu");
            return;
        }
        Alert a = new Alert(Alert.AlertType.CONFIRMATION, "Hapus data terpilih?", ButtonType.YES, ButtonType.NO);
        a.setHeaderText(null);
        a.showAndWait().ifPresent(bt -> {
            if (bt == ButtonType.YES) {
                data.remove(b);
                messageLabel.setText("Data terhapus");
            }
        });
    }
}
