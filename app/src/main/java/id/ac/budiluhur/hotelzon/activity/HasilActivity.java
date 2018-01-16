package id.ac.budiluhur.hotelzon.activity;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import id.ac.budiluhur.hotelzon.R;
import id.ac.budiluhur.hotelzon.RoomAdapter;
import id.ac.budiluhur.hotelzon.RoomData;

public class HasilActivity extends AppCompatActivity {

    private String[] filter = {"Terbaru", "Terdekat", "Termurah", "Rating"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil);

        Toolbar toolbar = findViewById(R.id.toolbar_hasil);
        toolbar.setTitle("Hasil Pencarian");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            toolbar.setTitleTextColor(getColor(R.color.colorAccent));
        }
        toolbar.setNavigationIcon(R.drawable.v_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        RecyclerView recyclerView = findViewById(R.id.recycler);
        List<RoomData> data = new ArrayList<>();
        data.add(new RoomData(1, "Hotel Sleman, Yogyakarta", "Rp. 185.000,00"));
        data.add(new RoomData(2, "Hotel Malioboro", "Rp. 175.000,00"));
        data.add(new RoomData(3, "Hotel Walisongo", "Rp. 215.000,00"));

        RoomAdapter adapter = new RoomAdapter(data, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        Spinner spinFilter = findViewById(R.id.spin_filter);
        ArrayAdapter<String> langAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, filter);
        langAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinFilter.setAdapter(langAdapter);

    }
}
