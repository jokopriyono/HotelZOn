package id.ac.budiluhur.hotelzon.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import id.ac.budiluhur.hotelzon.R;

public class PaymentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        Toolbar toolbar = findViewById(R.id.toolbar_payment);
        setSupportActionBar(toolbar);
        setTitle("Pembayaran");

        toolbar.setTitleTextColor(getResources().getColor(R.color.colorAccent));
        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.v_back));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        TextView txtJudul = findViewById(R.id.txt_judul);
        TextView txtHarga = findViewById(R.id.txt_harga);

        txtJudul.setText(getIntent().getStringExtra("judul"));
        txtHarga.setText(getIntent().getStringExtra("harga"));

        Spinner spinBank = findViewById(R.id.spin_bank);
        String[] languages = {"Pilih Bank"};
        ArrayAdapter<String> langAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, languages);
        langAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinBank.setAdapter(langAdapter);
    }
}
