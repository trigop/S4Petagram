package es.tamareo.s4petagram.presentador;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;

import es.tamareo.s4petagram.activity.IMascotasFavoritasView;
import es.tamareo.s4petagram.db.ConstructorMascotas;
import es.tamareo.s4petagram.pojo.Mascota;

/**
 * Created by paco on 14/4/17.
 */

public class MascotasFavoritasPresenter implements IMascotasFavoritasPresenter{


    private IMascotasFavoritasView iMascotasFavoritasView;
    private Context context;
    private ArrayList<Mascota> mascotas;
    private ConstructorMascotas constructorMascotas;

    public MascotasFavoritasPresenter(IMascotasFavoritasView iMascotasFavoritasView, Context context){
        this.iMascotasFavoritasView = iMascotasFavoritasView;
        this.context = context;
        obetenerMascotasBaseDatos();

    }


    @Override
    public void obetenerMascotasBaseDatos() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obetenerDatos();
        mostrarMascotasFavoritasRV();
        Log.i("dd", "dd");

    }

    @Override
    public void mostrarMascotasFavoritasRV() {
        iMascotasFavoritasView.inicializarAdaptadorRV(iMascotasFavoritasView.crearAdaptador(mascotas));
        iMascotasFavoritasView.generarLinearLayoutVertical();

    }
}
