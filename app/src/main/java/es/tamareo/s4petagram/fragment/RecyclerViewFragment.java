package es.tamareo.s4petagram.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import es.tamareo.s4petagram.R;
import es.tamareo.s4petagram.adapter.MascotaAdapter;
import es.tamareo.s4petagram.pojo.Mascota;
import es.tamareo.s4petagram.presentador.IMascotasFavoritasPresenter;
import es.tamareo.s4petagram.presentador.IMascotasPresenter;
import es.tamareo.s4petagram.presentador.MascotasFavoritasPresenter;
import es.tamareo.s4petagram.presentador.MascotasPresenter;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecyclerViewFragment extends Fragment implements IRecyclerViewFragment{


    private RecyclerView recyclerView;
    ArrayList<Mascota> mascotas;
    private IMascotasPresenter presenter;

    public RecyclerViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_recycler_view, container, false);

        recyclerView = (RecyclerView) v.findViewById(R.id.rvListHome);

        presenter = new MascotasPresenter(this, getContext());

        //Generamos el Layout como lo necesitamos. En este caso como Linear
        //LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        //llm.setOrientation(LinearLayoutManager.VERTICAL);

        //Añaidmos al recyclerView el Layout definido
        //recyclerView.setLayoutManager(llm);

        //initMascotas();
        //initAdaptador();

        return v;

    }



    //Iniciamos el adaptador y añadimos al recyclerView el adaptador creado
    private void initAdaptador() {
        MascotaAdapter mascotaAdapter = new MascotaAdapter(mascotas, getActivity(), getContext());
        recyclerView.setAdapter(mascotaAdapter);
    }


    //Inicializamos el contenido. Creamos un array con las mascotas
    public void initMascotas(){

        /*
        mascotas = new ArrayList<>();
        mascotas.add(new Mascota("Mascota 6", R.drawable.mascota6, 0));
        mascotas.add(new Mascota("Mascota 5", R.drawable.mascota5, 0));
        mascotas.add(new Mascota("Mascota 4", R.drawable.mascota4, 0));
        mascotas.add(new Mascota("Mascota 3", R.drawable.mascota3, 0));
        mascotas.add(new Mascota("Mascota 2", R.drawable.mascota2, 0));
        mascotas.add(new Mascota("Mascota 1", R.drawable.mascota1, 0));
        */
    }

    @Override
    public void generarLinearLayoutVertical() {
        //Declaramos
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        //GridLayoutManager llm = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(llm);
    }

    @Override
    public MascotaAdapter crearAdaptador(ArrayList<Mascota> mascotas) {
        MascotaAdapter adapter = new MascotaAdapter(mascotas, getActivity(), getContext());
        return adapter;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdapter adaptador) {

        recyclerView.setAdapter(adaptador);
    }

    @Override
    public void generarGridLayout() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(gridLayoutManager);
    }
}
