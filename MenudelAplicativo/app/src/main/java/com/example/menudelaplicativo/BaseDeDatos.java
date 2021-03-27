package com.example.menudelaplicativo;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class BaseDeDatos extends AppCompatActivity {

    ArrayList<Usuario> ListaUsuario = new ArrayList<>();
    TableLayout tLTabla;

    TableRow fila;
    TextView id,n1,n2,N1,N2,N,n,v,d,l,t,e,b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_de_datos);
        tLTabla = findViewById(R.id.tlTabla);

        //ListaUsuario.add(new Usuario("(57)","(95)","(15)","(35)","(64.2)","(34)","(64)","(31)","(2)","(56)","(79)","(47)","(2)"));

        TableRow.LayoutParams layouFila = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,TableRow.LayoutParams.WRAP_CONTENT);
        TableRow.LayoutParams layouid = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,TableRow.LayoutParams.WRAP_CONTENT);
        TableRow.LayoutParams layoun1 = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,TableRow.LayoutParams.WRAP_CONTENT);
        TableRow.LayoutParams layoun2 = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,TableRow.LayoutParams.WRAP_CONTENT);
        TableRow.LayoutParams layouN = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,TableRow.LayoutParams.WRAP_CONTENT);
        TableRow.LayoutParams layoun = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,TableRow.LayoutParams.WRAP_CONTENT);
        TableRow.LayoutParams layouN1 = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,TableRow.LayoutParams.WRAP_CONTENT);
        TableRow.LayoutParams layouN2 = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,TableRow.LayoutParams.WRAP_CONTENT);
        TableRow.LayoutParams layouv = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,TableRow.LayoutParams.WRAP_CONTENT);
        TableRow.LayoutParams layoud = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,TableRow.LayoutParams.WRAP_CONTENT);
        TableRow.LayoutParams layoul = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,TableRow.LayoutParams.WRAP_CONTENT);
        TableRow.LayoutParams layout = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,TableRow.LayoutParams.WRAP_CONTENT);
        TableRow.LayoutParams layoue = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,TableRow.LayoutParams.WRAP_CONTENT);
        TableRow.LayoutParams layoub = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,TableRow.LayoutParams.WRAP_CONTENT);

        //Generando tabla

        fila = new TableRow(this);
        fila.setLayoutParams(layouFila);

        id = agregaFila("ID");
        id.setLayoutParams(layouid);
        fila.addView(id);

        n1 = agregaFila("n1");
        n1.setLayoutParams(layoun1);
        fila.addView(n1);

        n2 = agregaFila("n2");
        n2.setLayoutParams(layoun2);
        fila.addView(n2);


        N1 = agregaFila("N1");
        N1.setLayoutParams(layouN1);
        fila.addView(N1);

        N2 = agregaFila("N2");
        N2.setLayoutParams(layouN2);
        fila.addView(N2);


        n = agregaFila("n");
        n.setLayoutParams(layoun);
        fila.addView(n);

        N = agregaFila("N");
        N.setLayoutParams(layouN);
        fila.addView(N);

        d = agregaFila("D");
        d.setLayoutParams(layoud);
        fila.addView(d);

        v = agregaFila("V");
        v.setLayoutParams(layouv);
        fila.addView(v);

        l = agregaFila("L");
        l.setLayoutParams(layoul);
        fila.addView(l);

        t = agregaFila("T");
        t.setLayoutParams(layout);
        fila.addView(t);

        e = agregaFila("E");
        e.setLayoutParams(layoue);
        fila.addView(e);

        b = agregaFila("B");
        b.setLayoutParams(layoub);
        fila.addView(b);


        tLTabla.addView(fila);

        //Fin del encabezado, agregar los registros de la consulta de la BD

        String consulta ="SELECT * FROM datos";
        AdmiSQLiteOpenHelper admin = new AdmiSQLiteOpenHelper(this,"Administracion",null,1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();
        Cursor registro = BaseDeDatos.rawQuery(consulta,null);

        if(!registro.moveToNext()){
            //BD vacia
            Toast.makeText(this,"No hay registros guardados",Toast.LENGTH_SHORT).show();
        }else{
            //Tabla con datos
            do{
                ListaUsuario.add(new Usuario(registro.getString(0),registro.getString(1),
                        registro.getString(2), registro.getString(3),
                        registro.getString(4),registro.getString(5),
                        registro.getString(6),registro.getString(7),
                        registro.getString(8),registro.getString(9),
                        registro.getString(10),registro.getString(11),registro.getString(12)));
            }while(registro.moveToNext());
        }

        BaseDeDatos.close();

        //Agregamos elementos a las filas
        for(int i = 0;i<ListaUsuario.size();i++){
            fila = new TableRow(this);
            fila.setLayoutParams(layouFila);

            id = agregaFila2(ListaUsuario.get(i).getId());
            id.setLayoutParams(layouid);
            fila.addView(id);

            n1 = agregaFila2(ListaUsuario.get(i).getN1());
            n1.setLayoutParams(layoun1);
            fila.addView(n1);

            n2 = agregaFila2(ListaUsuario.get(i).getN2());
            n2.setLayoutParams(layoun2);
            fila.addView(n2);


            N1 = agregaFila2(ListaUsuario.get(i).getPn1());
            N1.setLayoutParams(layouN1);
            fila.addView(N1);

            N2 = agregaFila2(ListaUsuario.get(i).getPn2());
            N2.setLayoutParams(layouN2);
            fila.addView(N2);


            n = agregaFila2(ListaUsuario.get(i).getN());
            n.setLayoutParams(layoun);
            fila.addView(n);

            N = agregaFila2(ListaUsuario.get(i).getPn());
            N.setLayoutParams(layouN);
            fila.addView(N);

            d = agregaFila2(ListaUsuario.get(i).getD());
            d.setLayoutParams(layoud);
            fila.addView(d);

            v = agregaFila2(ListaUsuario.get(i).getV());
            v.setLayoutParams(layouv);
            fila.addView(v);

            l = agregaFila2(ListaUsuario.get(i).getL());
            l.setLayoutParams(layoul);
            fila.addView(l);

            t = agregaFila2(ListaUsuario.get(i).getT());
            t.setLayoutParams(layout);
            fila.addView(t);

            e = agregaFila2(ListaUsuario.get(i).getE());
            e.setLayoutParams(layoue);
            fila.addView(e);

            b = agregaFila2(ListaUsuario.get(i).getB());
            b.setLayoutParams(layoub);
            fila.addView(b);

            tLTabla.addView(fila);

        }


    }

    private TextView agregaFila(String contenido){
        TextView b = new TextView(this);
        b.setText(contenido);
        b.setGravity(Gravity.CENTER);
        b.setBackgroundColor(Color.BLACK);
        b.setTextColor(Color.WHITE);
        b.setPadding(8, 4,8,4);
        return b;
    }

    private TextView agregaFila2(String contenido){
        TextView b = new TextView(this);
        b.setText(contenido);
        b.setGravity(Gravity.CENTER);
        b.setBackgroundColor(Color.WHITE);
        b.setTextColor(Color.BLACK);
        b.setPadding(8, 4,8,4);
        return b;
    }

}