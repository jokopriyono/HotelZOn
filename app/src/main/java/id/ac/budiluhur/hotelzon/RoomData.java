package id.ac.budiluhur.hotelzon;

/**
 * Created by LENOVO on 03/11/2017.
 */

public class RoomData {
    private String nama;
    private String harga;

    public RoomData(String nama, String harga) {
        this.nama = nama;
        this.harga = harga;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }
}
