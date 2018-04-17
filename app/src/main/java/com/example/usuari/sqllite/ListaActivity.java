package com.example.usuari.sqllite;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class ListaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
        DBLibros adp=new DBLibros(this);
        Cursor c = adp.recuperarLibros();
        String[] columnas = new String[]{"titulo","autor","precio"};
        int[] vistas = new int[]{R.id.tvTitulo,R.id.tvAutor,R.id.tvPrecio};
        SimpleCursorAdapter sc = new SimpleCursorAdapter(
                this,
                R.layout.list_controls,
                c,
                columnas,
                vistas,
                CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER
        );
        ListView listas=(ListView) findViewById(R.id.lista);
        listas.setAdapter(sc);
        adp.close();
    }
    public void salir(View v){
        this.finish();
    }
}
