package id.ac.budiluhur.hotelzon.activity;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import id.ac.budiluhur.hotelzon.R;
import id.ac.budiluhur.hotelzon.fragment.FotoFragment;
import id.ac.budiluhur.hotelzon.fragment.LokasiFragment;
import id.ac.budiluhur.hotelzon.fragment.RincianFragment;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Toolbar toolbar = findViewById(R.id.toolbar_main_activity);
        setSupportActionBar(toolbar);
        setTitle(getIntent().getStringExtra("judul"));

        toolbar.setTitleTextColor(getResources().getColor(R.color.colorAccent));
        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.v_back));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ViewPager viewPager = findViewById(R.id.view_pager_cust);
        setupViewPager(viewPager);

        TabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);

        TextView txtHarga = findViewById(R.id.txt_harga);
        String harga = getIntent().getStringExtra("harga");
        txtHarga.setText(harga);

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

        Button btnPesan = findViewById(R.id.btn_pesan);
        btnPesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DetailActivity.this, PaymentActivity.class);
                i.putExtra("judul", getIntent().getStringExtra("judul"));
                i.putExtra("harga", getIntent().getStringExtra("harga"));
                startActivity(i);
            }
        });
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new RincianFragment(), "Rincian");
        adapter.addFrag(new LokasiFragment(), "Lokasi");
        adapter.addFrag(new FotoFragment(), "Foto");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
