package com.example.usuari.sqllite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by usuari on 20/03/2018.
 */

public class DBLibros {
    private SQLiteDatabase db=null;
    private DatabaseHelper dbhelper=null;
    Context context;
    public DBLibros(Context ctx){
        this.context = ctx;
        dbhelper = new DatabaseHelper(context);
        db = dbhelper.getWritableDatabase();
    }
    public void close(){
        dbhelper.close();
    }
    public  long altaLibro(String titulo, String autor, double precio){
        ContentValues initialValues = new ContentValues();
        initialValues.put("titulo",titulo);
        initialValues.put("autor",autor);
        initialValues.put("precio",precio);
        return db.insert("libros",null,initialValues);
    }
    public Cursor recuperarLibros(){
        return db.query("libros", new String[]{"_id","titulo","precio","autor"},null,null,null,null,null);
    }
}
