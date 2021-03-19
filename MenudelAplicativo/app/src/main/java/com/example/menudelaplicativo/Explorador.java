package com.example.menudelaplicativo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.sql.RowSetListener;

public class Explorador extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private List<String> listaNombreArchivos;
    private List<String> listaRutasArchivos;
    private ArrayAdapter<String> adaptador;
    private  String directorioRaiz;
    private TextView carpetaActual;
    private ListView listas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explorador);
        carpetaActual = (TextView) findViewById(R.id.rutaActual);
        listas = (ListView) findViewById(R.id.listView_Lista);

        directorioRaiz = Environment.getExternalStorageDirectory().getPath();
        listas.setOnItemClickListener(this);
        verArchivoDirectorio(directorioRaiz);

    }

    private void verArchivoDirectorio(String rutaDirectorio){
        carpetaActual.setText("Estas en: "+rutaDirectorio);
       listaNombreArchivos = new ArrayList<String>();
        listaRutasArchivos = new ArrayList<String>();

        File directorioActual = new File(rutaDirectorio);
        File[] listaArchivos = directorioActual.listFiles();
        int x = 0;

        if(!rutaDirectorio.equals(directorioRaiz)){
            listaNombreArchivos.add(".. /");
            listaRutasArchivos.add(directorioActual.getParent());
            x=1;
        }

        for(File archivo : listaArchivos){
           listaRutasArchivos.add(archivo.getPath());
        }

        Collections.sort(listaRutasArchivos, String.CASE_INSENSITIVE_ORDER);

        for(int i=x; i < listaRutasArchivos.size(); i++){
            File archivo = new File(listaRutasArchivos.get(i));
              if(archivo.isFile()){
                  listaNombreArchivos.add(archivo.getName());
              }else{
                  listaNombreArchivos.add("/"+ archivo.getName());
              }
        }

        if(listaArchivos.length==0){
            listaNombreArchivos.add("No hay ningun archivo");
            listaRutasArchivos.add(rutaDirectorio);
        }

        adaptador = new ArrayAdapter<String>(this,
                R.layout.lista_archivo, listaNombreArchivos);
          listas.setAdapter(adaptador);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        File archivo = new File(listaRutasArchivos.get(position));
        if(archivo.isFile()){

            String ubicacion = archivo.getAbsolutePath();
            Intent i = new Intent(this,CalcularMetricas.class);
            i.putExtra("ubicacion",ubicacion);
            startActivity(i);

            Toast.makeText(this,
                    "Has seleccionado el archivo: "+ archivo.getName(),
                    Toast.LENGTH_LONG).show();
        }else{
            verArchivoDirectorio(listaRutasArchivos.get(position));
        }
    }

}