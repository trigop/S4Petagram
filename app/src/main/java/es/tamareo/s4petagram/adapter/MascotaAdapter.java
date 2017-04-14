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
        mascotaViewHolder.petName.setText(mascota.getName());
        mascotaViewHolder.petImg.setImageResource(mascota.getImg());
        mascotaViewHolder.petLikeCount.setText(Integer.toString(mascota.getCounter()));

        //TODO: HACER ALCO CUANDO PULSAMOS EN LA ACTIVIDAD

        mascotaViewHolder.petBtnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mascota.setCounter(1);
                mascotaViewHolder.petLikeCount.setText(Integer.toString(mascota.getCounter()));
                Toast.makeText(activity, "Like mascota: "+ mascota.getName(), Toast.LENGTH_SHORT).show();

                BaseDatos db = new BaseDatos(context);

                ConstructorMascotas.insertarMascota(db, mascota);

            }
        });

    }

    @Override
    public int getItemCount() {return mascotas.size();}


    public static class MascotaViewHolder extends RecyclerView.ViewHolder {

        private ImageView petImg;
        private TextView petName;
        private ImageButton petBtnLike;
        private TextView petLikeCount;

        public MascotaViewHolder(View itemView) {
            super(itemView);

            petImg = (ImageView) itemView.findViewById(R.id.petImg);
            petName = (TextView) itemView.findViewById(R.id.petName);
            petBtnLike = (ImageButton) itemView.findViewById(R.id.btnPetLike);
            petLikeCount = (TextView) itemView.findViewById(R.id.petLikeCount);
        }
    }



}
