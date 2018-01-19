package com.example.root.limaicojose;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 12/19/17.
 */

public class DatabaseHandler extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION =1;
    //Nombre de la base de datos
    private static final String DATABASE_NAME = "TareasManager";
    //Nombre de la tabla de tareas
    private static final String TABLE_TAREA = "Tarea";
    //Nombres de las columnas de la tabla
    private static final String KEY_ID = "id";
    private static final String KEY_TAREA = "tarea";
    private static final String KEY_FECHA_LIMITE = "fecha_limite";
    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_TAREA_TABLE = "CREATE TABLE " + TABLE_TAREA +
                "(" + KEY_ID + " INTEGER PRIMARY KEY," +
                KEY_TAREA + " TEXT," +
                KEY_FECHA_LIMITE + " TEXT" +")";

        sqLiteDatabase.execSQL(CREATE_TAREA_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


    public void addTarea(Tarea tarea){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_TAREA, tarea.getTarea());
        values.put(KEY_FECHA_LIMITE,tarea.getFechaLimite());
        db.insert(TABLE_TAREA,null,values);
        db.close();
    }

    public Tarea getTarea(String t){

        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor = db.query(TABLE_TAREA, new
                String[]{KEY_ID,KEY_TAREA,KEY_FECHA_LIMITE}, KEY_TAREA+"=?", new
                String[]{t},null,null,null,null);
        if (cursor != null){
            cursor.moveToFirst();
        }

        Tarea  tarea = new Tarea(Integer.parseInt(cursor.getString(0)),cursor.getString(1),cursor.getString(2));
        return tarea;
    }

    public String getNumeroTareas(){

        SQLiteDatabase db=this.getWritableDatabase();
        String sql_select = "SELECT count(*) FROM " + TABLE_TAREA;
        Cursor cursor = db.rawQuery(sql_select,null);
        if (cursor != null){
            cursor.moveToFirst();
        }


        return cursor.getString(0);
    }


}
