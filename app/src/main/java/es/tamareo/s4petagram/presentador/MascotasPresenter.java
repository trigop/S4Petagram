package es.tamareo.s4petagram.presentador;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;

import es.tamareo.s4petagram.fragment.IRecyclerViewFragment;
import es.tamareo.s4petagram.pojo.Mascota;
import es.tamareo.s4petagram.restApi.EndpointsApi;
import es.tamareo.s4petagram.restApi.adapter.RestApiAdapter;
import es.tamareo.s4petagram.restApi.model.MascotaResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by paco on 28/4/17.
 */

public class MascotasPresenter implements IMascotasPresenter {


    private IRecyclerViewFragment iRecyclerViewFragment;
    private Context context;
    private ArrayList<Mascota> mascotas;

    public MascotasPresenter(IRecyclerViewFragment iRecyclerViewFragment, Context context) {
        this.iRecyclerViewFragment = iRecyclerViewFragment;
        this.context = context;
        obtenerMediosRecientes();
    }

    @Override
    public void obtenerMediosRecientes() {

        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson gsonMediaRecent = restApiAdapter.construyeGsonDeserializadorMediaRecent();

        EndpointsApi endpointsApi = restApiAdapter.establecerConexionRestApiInstagram(gsonMediaRecent);
        Call<MascotaResponse> mascotaResponseCall = endpointsApi.getRecentMedia();

        mascotaResponseCall.enqueue(new Callback<MascotaResponse>() {
            @Override
            public void onResponse(Call<MascotaResponse> call, Response<MascotaResponse> response) {
                MascotaResponse mascotaResponse = response.body();
                mascotas = mascotaResponse.getMascotas();
                mostrarContactosRV();
            }

            @Override
            public void onFailure(Call<MascotaResponse> call, Throwable t) {

                Toast.makeText(context, "Algo pasa", Toast.LENGTH_SHORT).show();
                Log.e("Fallo en la conexion", t.toString());
            }
        });



    }

    @Override
    public void mostrarContactosRV() {
        iRecyclerViewFragment.inicializarAdaptadorRV(iRecyclerViewFragment.crearAdaptador(mascotas));
        iRecyclerViewFragment.generarLinearLayoutVertical();

    }
}
