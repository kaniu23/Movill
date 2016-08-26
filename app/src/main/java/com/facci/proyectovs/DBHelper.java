package com.facci.proyectovs;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Windows 7 on 26/08/2016.
 */
public class DBHelper extends SQLiteOpenHelper {
    public static final String DB_NOMBRE="CNE_DAP";
    public static final String TABLA_NOMBRE="VONTANTES_DAP";

    public static final String COL_1 = "ID";
    public static final String COL_2 = "NOMBRE";
    public static final String COL_3 = "APELLIDO";
    public static final String COL_4 = "RECINTO ELECTORAL";
    public static final String COL_5 = "AÑO NACIMIENTO";



    public DBHelper(Context context) {
        super(context, DB_NOMBRE, null, 1);
        SQLiteDatabase db= this.getWritableDatabase();

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
            db.execSQL(String.format("create table %s (ID INTEGER PRIMARY KEY AUTOINCREMENT,%s TEXT, %s TEXT,%s INTEGER)",TABLA_NOMBRE,COL_2,COL_3,COL_4,COL_5));
        }



    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(String.format("DROP TABLE IF EXISTS %s",TABLA_NOMBRE));
        onCreate(db);

    }
    public boolean INGRESAR (String nombre, String apellido,String recintoElectoral,int anoNacimiento){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,nombre);
        contentValues.put(COL_3,apellido);
        contentValues.put(COL_4,recintoElectoral);
        contentValues.put(COL_5,anoNacimiento);

        long resultado = db.insert(TABLA_NOMBRE,null,contentValues);

        if(resultado == -1)
            return false;
        else
            return true;

    }
    public boolean MODIFICAR(String id,String nombre,String apellido,String recintoElectoral,int anoNacimineto ){

        SQLiteDatabase db = this.getWritableDatabase();


        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,id);
        contentValues.put(COL_2,nombre);
        contentValues.put(COL_3,apellido);
        contentValues.put(COL_4, recintoElectoral);
        contentValues.put(COL_5,anoNacimineto);


        db.update(TABLA_NOMBRE,contentValues,"id = ?",new String[]{id});
        return true;
    }
    public Integer ELIMINAR (String id){

        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLA_NOMBRE,"id = ?",new String[]{id});

    }

}
