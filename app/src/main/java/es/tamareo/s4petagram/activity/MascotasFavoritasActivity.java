package es.tamareo.s4petagram.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ImageButton;

import java.util.ArrayList;

import es.tamareo.s4petagram.R;
import es.tamareo.s4petagram.adapter.MascotaAdapter;
import es.tamareo.s4petagram.pojo.Mascota;
import es.tamareo.s4petagram.presentador.IMascotasFavoritasPresenter;
import es.tamareo.s4petagram.presentador.MascotasFavoritasPresenter;

public class MascotasFavoritasActivity extends AppCompatActivity implements IMascotasFavoritasView{

    ArrayList<Mascota> mascotas;
    private RecyclerView recyclerView;
    private ImageButton imageButton;
    private Toolbar toolbar;
    private IMascotasFavoritasPresenter presenter;
    //private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotas_favoritas);

        toolbar = (Toolbar) findViewById(R.id.toolBarNoFragment);

        if (toolbar != null){

            toolbar.setLogo(R.drawable.logo);
            toolbar.setTitle(getResources().getString(R.string.mascotasFavLabel));
            toolbar.setTitleMargin(200,20,20,20);

            setSupportActionBar(toolbar);

            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        recyclerView = (RecyclerView) findViewById(R.id.rvFavList);
        //TODO: REVISAR
        presenter = new MascotasFavoritasPresenter(this, getApplicationContext());



        //Generamos el Layout como lo necesitamos. En este caso como Linear
        //LinearLayoutManager llm = new LinearLayoutManager(this);
        //llm.setOrientation(LinearLayoutManager.VERTICAL);

        //Añaidmos al recyclerView el Layout definido
        //recyclerView.setLayoutManager(llm);

        //initMascotas();
        //initAdaptador();

    }


    //Iniciamos el adaptador y añadimos al recyclerView el adaptador creado
    private void initAdaptador() {
        MascotaAdapter mascotaAdapter = new MascotaAdapter(mascotas, this, getApplicationContext());
        recyclerView.setAdapter(mascotaAdapter);
    }


    //Inicializamos el contenido. Creamos un array con las mascotas
    public void initMascotas(){

        /*mascotas = new ArrayList<>();
        mascotas.add(new Mascota("Mascota 6", R.drawable.mascota6, 0));
        mascotas.add(new Mascota("Mascota 5", R.drawable.mascota5, 0));
        mascotas.add(new Mascota("Mascota 4", R.drawable.mascota4, 0));
        mascotas.add(new Mascota("Mascota 3", R.drawable.mascota3, 0));
        mascotas.add(new Mascota("Mascota 2", R.drawable.mascota2, 0));
        mascotas.add(new Mascota("Mascota 1", R.drawable.mascota1, 0));*/

    }

    @Override
    public void generarLinearLayoutVertical() {
        Log.i("LOG", "LOG");
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        Log.i("LOG", "LOG");
        recyclerView.setLayoutManager(llm);
    }

    @Override
    public MascotaAdapter crearAdaptador(ArrayList<Mascota> mascotas) {
        Log.i("LOG", "LOG");
        MascotaAdapter adapter = new MascotaAdapter(mascotas, this, getApplicationContext());
        return adapter;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdapter adapter) {
        recyclerView.setAdapter(adapter);
    }
}
