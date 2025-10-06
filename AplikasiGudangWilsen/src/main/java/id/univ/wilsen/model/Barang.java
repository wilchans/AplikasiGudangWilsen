
package id.univ.wilsen.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Barang {
    private SimpleStringProperty nama;
    private SimpleIntegerProperty jumlah;

    public Barang(String nama, int jumlah) {
        this.nama = new SimpleStringProperty(nama);
        this.jumlah = new SimpleIntegerProperty(jumlah);
    }

    public String getNama() { return nama.get(); }
    public void setNama(String nama) { this.nama.set(nama); }

    public int getJumlah() { return jumlah.get(); }
    public void setJumlah(int jumlah) { this.jumlah.set(jumlah); }
}
