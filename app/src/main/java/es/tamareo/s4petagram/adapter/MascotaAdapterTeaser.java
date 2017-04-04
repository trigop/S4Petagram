package es.tamareo.s4petagram.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import es.tamareo.s4petagram.R;
import es.tamareo.s4petagram.pojo.Mascota;

/**
 * Created by paco on 3/4/17.
 */

public class MascotaAdapterTeaser extends RecyclerView.Adapter<MascotaAdapterTeaser.MascotaViewHolder> {

    ArrayList<Mascota> mascotas;
    Activity activity;

    public MascotaAdapterTeaser(ArrayList<Mascota> mascotas, Activity activity) {
        this.mascotas = mascotas;
        this.activity = activity;
    }


    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota_teaser, parent, false);
        return new MascotaViewHolder(v);


    }

    @Override
    public void onBindViewHolder(final MascotaViewHolder mascotaViewHolder, int position) {
        final Mascota mascota = mascotas.get(position);
        mascotaViewHolder.petImg.setImageResource(mascota.getImg());
        mascotaViewHolder.petLikeCount.setText(Integer.toString(mascota.getCounter()));


    }

    @Override
    public int getItemCount() {return mascotas.size();}


    public static class MascotaViewHolder extends RecyclerView.ViewHolder {

        private ImageView petImg;
        private TextView petLikeCount;

        public MascotaViewHolder(View itemView) {
            super(itemView);

            petImg = (ImageView) itemView.findViewById(R.id.petImg);
            petLikeCount = (TextView) itemView.findViewById(R.id.petLikeCount);
        }
    }



}
