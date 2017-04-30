package es.tamareo.s4petagram.restApi;

import es.tamareo.s4petagram.restApi.model.MascotaResponse;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by paco on 24/4/17.
 */

public interface EndpointsApi {


    @GET(ConstantesRestApi.URL_GET_RECENT_MEDIA_USER)
    Call<MascotaResponse> getRecentMedia();

}
