package id.ac.budiluhur.hotelzon.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import id.ac.budiluhur.hotelzon.R;
import id.ac.budiluhur.hotelzon.RoomAdapter;
import id.ac.budiluhur.hotelzon.RoomData;

public class HasilActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil);

        RecyclerView recyclerView = findViewById(R.id.recycler);
        List<RoomData> data = new ArrayList<>();
        data.add(new RoomData("Hotel Sleman, Yogyakarta", "Rp. 185.000,00"));
        data.add(new RoomData("Hotel Malioboro", "Rp. 175.000,00"));
        data.add(new RoomData("Hotel Walisongo", "Rp. 215.000,00"));

        RoomAdapter adapter = new RoomAdapter(data, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}
