package es.tamareo.s4petagram.restApi.model;

import java.util.ArrayList;

import es.tamareo.s4petagram.pojo.Mascota;

/**
 * Created by paco on 24/4/17.
 */

public class MascotaResponse {

    ArrayList<Mascota> mascotas;

    public ArrayList<Mascota> getMascotas() {
        return mascotas;
    }

    public void setMascotas(ArrayList<Mascota> mascotas) {
        this.mascotas = mascotas;
    }

}
