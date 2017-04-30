package es.tamareo.s4petagram.fragment;

import java.util.ArrayList;

import es.tamareo.s4petagram.adapter.MascotaAdapter;
import es.tamareo.s4petagram.pojo.Mascota;

/**
 * Created by paco on 25/4/17.
 */

public interface IRecyclerViewFragment {

    public void generarLinearLayoutVertical();
    public MascotaAdapter crearAdaptador(ArrayList<Mascota> mascotas);
    public void inicializarAdaptadorRV(MascotaAdapter adaptador);

    public void generarGridLayout();
}
