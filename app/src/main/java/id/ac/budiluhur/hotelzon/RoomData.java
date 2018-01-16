package id.ac.budiluhur.hotelzon;

/**
 * Created by LENOVO on 03/11/2017.
 */

public class RoomData {
    private Integer id;
    private String nama;
    private String harga;

    public RoomData(Integer id, String nama, String harga) {
        this.id = id;
        this.nama = nama;
        this.harga = harga;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
