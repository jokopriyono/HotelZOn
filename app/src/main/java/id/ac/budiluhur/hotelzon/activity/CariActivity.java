package id.ac.budiluhur.hotelzon.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;

import java.util.HashMap;

import id.ac.budiluhur.hotelzon.R;
import mehdi.sakout.fancybuttons.FancyButton;

public class CariActivity extends AppCompatActivity {

    private String[] kota = {"Jakarta", "Jogjakarta", "Bandung", "Aceh"};
    private String[] jumlah = {"1", "2", "3", "4"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cari);

        FancyButton btnCari = findViewById(R.id.btn_cari);
        btnCari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CariActivity.this, HasilActivity.class));
            }
        });

        Spinner spinPilihKota = findViewById(R.id.spin_pilih_kota);
        Spinner spinJumlahKamar = findViewById(R.id.spin_kamar);
        Spinner spinJumlahOrang = findViewById(R.id.spin_orang);

        ArrayAdapter<String> langAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, kota);
        langAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinPilihKota.setAdapter(langAdapter);
        ArrayAdapter<String> jumlahAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, jumlah);
        jumlahAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinJumlahKamar.setAdapter(jumlahAdapter);
        spinJumlahOrang.setAdapter(jumlahAdapter);


        SliderLayout slider = findViewById(R.id.slider_home_screen);
        HashMap<String,Integer> img_maps = new HashMap<>();
        img_maps.put("Promo Hotel",R.drawable.promo1);
        img_maps.put("Diskon Gila!",R.drawable.promo2);

        for(String name : img_maps.keySet()){
            TextSliderView textSliderView = new TextSliderView(getApplicationContext());
            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(img_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.CenterCrop);

            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra",name);

            slider.addSlider(textSliderView);
        }
        slider.setPresetTransformer(SliderLayout.Transformer.FlipPage);
        slider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        slider.setCustomAnimation(new DescriptionAnimation());
        slider.setDuration(4000);
        slider.addOnPageChangeListener(new ViewPagerEx.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
