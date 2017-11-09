package id.ac.budiluhur.hotelzon.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import id.ac.budiluhur.hotelzon.R;

public class PaymentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        TextView txtJudul = findViewById(R.id.txt_judul);
        TextView txtHarga = findViewById(R.id.txt_harga);

        txtJudul.setText(getIntent().getStringExtra("judul"));
        txtHarga.setText(getIntent().getStringExtra("harga"));
    }
}
