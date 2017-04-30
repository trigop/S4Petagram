package es.tamareo.s4petagram.restApi.adapter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import es.tamareo.s4petagram.restApi.ConstantesRestApi;
import es.tamareo.s4petagram.restApi.EndpointsApi;
import es.tamareo.s4petagram.restApi.deserializadores.MascotaDeserializador;
import es.tamareo.s4petagram.restApi.model.MascotaResponse;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by paco on 24/4/17.
 */

public class RestApiAdapter {

    public EndpointsApi establecerConexionRestApiInstagram(Gson gson){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantesRestApi.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(EndpointsApi.class);
    }

    public Gson construyeGsonDeserializadorMediaRecent(){

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(MascotaResponse.class, new MascotaDeserializador());

        return gsonBuilder.create();

    }

}
