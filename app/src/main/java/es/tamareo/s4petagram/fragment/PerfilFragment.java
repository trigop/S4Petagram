package es.tamareo.s4petagram.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import es.tamareo.s4petagram.R;
import es.tamareo.s4petagram.adapter.MascotaAdapter;
import es.tamareo.s4petagram.adapter.MascotaAdapterTeaser;
import es.tamareo.s4petagram.pojo.Mascota;

/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilFragment extends Fragment {

    TextView textView;
    ImageView imageView;
    RecyclerView recyclerView;

    ArrayList<Mascota> mascotas;

    public PerfilFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_perfil, container, false);


        textView = (TextView) v.findViewById(R.id.perfilName);
        textView.setText(R.string.pet_name_dummy);

        imageView = (ImageView) v.findViewById(R.id.perfilImg);
        imageView.setImageResource(R.drawable.mascota3);

        recyclerView = (RecyclerView) v.findViewById(R.id.rvMiMascotas);

        GridLayoutManager glm = new GridLayoutManager(getActivity(), 3);
        recyclerView.setLayoutManager(glm);


        initMascotas();
        initAdaptador();


        return v;

    }


    //Iniciamos el adaptador y añadimos al recyclerView el adaptador creado
    private void initAdaptador() {
        MascotaAdapterTeaser mascotaAdapterTeaser = new MascotaAdapterTeaser(mascotas, getActivity());
        recyclerView.setAdapter(mascotaAdapterTeaser);
    }


    //Inicializamos el contenido. Creamos un array con las mascotas
    public void initMascotas(){

        mascotas = new ArrayList<>();
        mascotas.add(new Mascota("Mascota 6", R.drawable.mascota6, 10));
        mascotas.add(new Mascota("Mascota 5", R.drawable.mascota5, 8));
        mascotas.add(new Mascota("Mascota 4", R.drawable.mascota4, 3));
        mascotas.add(new Mascota("Mascota 3", R.drawable.mascota3, 0));
        mascotas.add(new Mascota("Mascota 2", R.drawable.mascota2, 2));
        mascotas.add(new Mascota("Mascota 1", R.drawable.mascota1, 1));
        mascotas.add(new Mascota("Mascota 7", R.drawable.mascota3, 0));
        mascotas.add(new Mascota("Mascota 8", R.drawable.mascota2, 2));
        mascotas.add(new Mascota("Mascota 9", R.drawable.mascota1, 1));
        mascotas.add(new Mascota("Mascota 10", R.drawable.mascota6, 0));
        mascotas.add(new Mascota("Mascota 11", R.drawable.mascota4, 2));

    }


}
