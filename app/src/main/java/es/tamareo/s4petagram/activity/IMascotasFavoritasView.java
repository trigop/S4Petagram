package es.tamareo.s4petagram.activity;

import java.util.ArrayList;

import es.tamareo.s4petagram.adapter.MascotaAdapter;
import es.tamareo.s4petagram.pojo.Mascota;

/**
 * Created by paco on 14/4/17.
 */

public interface IMascotasFavoritasView {

    public void generarLinearLayoutVertical();
    public MascotaAdapter crearAdaptador(ArrayList<Mascota> mascotas);
    public void inicializarAdaptadorRV(MascotaAdapter adapter);

}
