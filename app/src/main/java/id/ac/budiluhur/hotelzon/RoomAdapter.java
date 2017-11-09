package id.ac.budiluhur.hotelzon;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import id.ac.budiluhur.hotelzon.activity.DetailActivity;

public class RoomAdapter extends RecyclerView.Adapter<RoomAdapter.RoomViewHolder>{
    private List<RoomData> isiData;
    private Activity activity;

    public RoomAdapter(List<RoomData> isiData, Activity activity) {
        this.isiData = isiData;
        this.activity = activity;
    }

    @Override
    public RoomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_room, parent, false);
        return new RoomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RoomAdapter.RoomViewHolder holder, int position) {
        holder.txtJudul.setText(isiData.get(position).getNama());
        holder.txtHarga.setText(isiData.get(position).getHarga());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(activity, DetailActivity.class);
                i.putExtra("judul", holder.txtJudul.getText().toString());
                i.putExtra("harga", holder.txtHarga.getText().toString());
                activity.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return isiData.size();
    }

    class RoomViewHolder extends RecyclerView.ViewHolder{
        TextView txtJudul, txtHarga;
        CardView cardView;

        public RoomViewHolder(View itemView) {
            super(itemView);

            cardView = itemView.findViewById(R.id.cardview);
            txtJudul = itemView.findViewById(R.id.txt_judul);
            txtHarga = itemView.findViewById(R.id.txt_harga);
        }
    }
}
