package es.tamareo.s4petagram.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import es.tamareo.s4petagram.R;
import es.tamareo.s4petagram.db.BaseDatos;
import es.tamareo.s4petagram.db.ConstructorMascotas;
import es.tamareo.s4petagram.pojo.Mascota;

/**
 * Created by paco on 3/4/17.
 */

public class MascotaAdapter extends RecyclerView.Adapter<MascotaAdapter.MascotaViewHolder> {

    ArrayList<Mascota> mascotas;
    Activity activity;
    ConstructorMascotas constructorMascotas;
    Context context;

    public MascotaAdapter(ArrayList<Mascota> mascotas, Activity activity, Context context) {
        this.mascotas = mascotas;
        this.activity = activity;
        this.context = context;
    }


    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);
        return new MascotaViewHolder(v);


    }

    @Override
    public void onBindViewHolder(final MascotaViewHolder mascotaViewHolder, int position) {
        final Mascota mascota = mascotas.get(position);
        //mascotaViewHolder.petName.setText(mascota.getName());
        //mascotaViewHolder.petImg.setImageResource(mascota.getImg());
        Picasso.with(activity)
                .load(mascota.getUrlImg())
                .placeholder(R.drawable.ic_home)
                .into(mascotaViewHolder.petImg);

        mascotaViewHolder.petLike.setText(Integer.toString(mascota.getLikes()) + " likes");


        //TODO: HACER ALCO CUANDO PULSAMOS EN LA ACTIVIDAD



    }

    @Override
    public int getItemCount() {return mascotas.size();}


    public static class MascotaViewHolder extends RecyclerView.ViewHolder {

        private ImageView petImg;
        private TextView petLike;

        public MascotaViewHolder(View itemView) {
            super(itemView);

            petImg = (ImageView) itemView.findViewById(R.id.petImg);
            petLike = (TextView) itemView.findViewById(R.id.petLikeCount);
        }
    }



}
