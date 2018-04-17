package com.example.usuari.sqllite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by usuari on 20/03/2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Libreria";
    private static final int DATABASE_VERSION=1;
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        createTables(sqLiteDatabase);
    }

    private void createTables(SQLiteDatabase db) {
        db.execSQL("create table libros (_id integer primary key autoincrement,titulo text not null, autor text not null, precio float not null)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    deleteTables(sqLiteDatabase);
    createTables(sqLiteDatabase);
    }

    private void deleteTables(SQLiteDatabase db) {
        db.execSQL("drop table if exists libros");
    }
}
