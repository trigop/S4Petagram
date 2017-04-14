package es.tamareo.s4petagram.db;

import android.content.ContentValues;
import android.content.Context;

import java.util.ArrayList;

import es.tamareo.s4petagram.R;
import es.tamareo.s4petagram.pojo.Mascota;

/**
 * Created by paco on 14/4/17.
 */

public class ConstructorMascotas {

    private Context context;

    public ConstructorMascotas(Context context) {
        this.context = context;
    }


    public ArrayList<Mascota> obetenerDatos(){

        BaseDatos db = new BaseDatos(context);
        return db.obtenerMascotasFavoritas();

    }


    public static void insertarMascota(BaseDatos db, Mascota mascota){

        ContentValues contentValues = new ContentValues();

        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NAME, mascota.getName());
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_IMG, mascota.getImg());

        db.insertarMascota(contentValues);
    }
}
