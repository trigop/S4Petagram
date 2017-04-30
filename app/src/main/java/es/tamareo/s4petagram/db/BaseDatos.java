package es.tamareo.s4petagram.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import es.tamareo.s4petagram.pojo.Mascota;

/**
 * Created by paco on 14/4/17.
 */

public class BaseDatos extends SQLiteOpenHelper {

    private Context context;

    public BaseDatos(Context context) {
        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);
        this.context = context;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCrearTablaMascotas = "CREATE TABLE " + ConstantesBaseDatos.TABLE_MASCOTAS + "(" +
                ConstantesBaseDatos.TABLE_MASCOTAS_ID       + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatos.TABLE_MASCOTAS_NAME     + " TEXT, " +
                ConstantesBaseDatos.TABLE_MASCOTAS_IMG      + " INTEGER" +
                ")";

        db.execSQL(queryCrearTablaMascotas);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLE_MASCOTAS);

        onCreate(db);
    }

    public void insertarMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_MASCOTAS, null, contentValues);

        db.close();

    }

    public void borrarBBDD(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLE_MASCOTAS);

        onCreate(db);

    }

    public ArrayList<Mascota> obtenerMascotasFavoritas(){

        ArrayList<Mascota> mascotas = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_MASCOTAS;
        SQLiteDatabase db = getWritableDatabase();

        Cursor registros = db.rawQuery(query, null);

        while (registros.moveToNext()){

            Mascota mascotaActual = new Mascota();
            //mascotaActual.setId(registros.getInt(0));
            mascotaActual.setName(registros.getString(1));
            //mascotaActual.setImg(registros.getInt(2));
            //mascotaActual.setCounter(0);

            mascotas.add(mascotaActual);

        }

        db.close();
        return mascotas;

    }

}
