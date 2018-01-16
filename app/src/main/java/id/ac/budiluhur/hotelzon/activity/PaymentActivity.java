package id.ac.budiluhur.hotelzon.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import id.ac.budiluhur.hotelzon.R;

public class PaymentActivity extends AppCompatActivity implements View.OnClickListener {

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

        ImageView imgVisa = findViewById(R.id.img_visa);
        ImageView imgMasterCard = findViewById(R.id.img_mastercard);
        ImageView imgHotel = findViewById(R.id.img_hotel);
        Integer idHotel = getIntent().getIntExtra("id", 1);
        if (idHotel == 1){
            int id = getResources().getIdentifier("hotel1", "drawable", getPackageName());
            imgHotel.setImageResource(id);
        } else if (idHotel == 2){
            int id = getResources().getIdentifier("hotel2", "drawable", getPackageName());
            imgHotel.setImageResource(id);
        } else {
            int id = getResources().getIdentifier("hotel3", "drawable", getPackageName());
            imgHotel.setImageResource(id);
        }

        Spinner spinBank = findViewById(R.id.spin_bank);
        String[] languages = {"Pilih Bank", "Mandiri", "BCA", "BNI", "CIMB"};
        ArrayAdapter<String> langAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, languages);
        langAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinBank.setAdapter(langAdapter);

        /*Button btnBayar = findViewById(R.id.btn_bayar);
        btnBayar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PaymentActivity.this, CariActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                PaymentActivity.this.finish();
            }
        });*/
        imgVisa.setOnClickListener(this);
        imgMasterCard.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(PaymentActivity.this, KartuKreditActivity.class);
        startActivity(intent);
    }
}
