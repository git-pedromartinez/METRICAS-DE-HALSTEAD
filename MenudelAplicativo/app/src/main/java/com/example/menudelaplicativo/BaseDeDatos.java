package com.example.menudelaplicativo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

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

        ListaUsuario.add(new Usuario("(57)","(95)","(15)","(35)","(64.2)","(34)","(64)","(31)","(2)","(56)","(79)","(47)","(2)"));

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


        for(int i = -1 ; i < ListaUsuario.size() ; i++){
            fila = new TableRow(this);
            fila.setLayoutParams(layouFila);

            if(i == -1){
                id = new TextView(this);
                id.setText("ID");
                id.setGravity(Gravity.CENTER);
                id.setBackgroundColor(Color.BLACK);
                id.setTextColor(Color.WHITE);
                id.setPadding(4, 4,4,4);
                id.setLayoutParams(layouid);
                fila.addView(id);

                n1 = new TextView(this);
                n1.setText("n1");
                n1.setGravity(Gravity.CENTER);
                n1.setBackgroundColor(Color.BLACK);
                n1.setTextColor(Color.WHITE);
                n1.setPadding(4, 4,4,4);
                n1.setLayoutParams(layoun1);
                fila.addView(n1);

                n2 = new TextView(this);
                n2.setText("n2");
                n2.setGravity(Gravity.CENTER);
                n2.setBackgroundColor(Color.BLACK);
                n2.setTextColor(Color.WHITE);
                n2.setPadding(4, 4,4,4);
                n2.setLayoutParams(layoun2);
                fila.addView(n2);


                N1 = new TextView(this);
                N1.setText("N1");
                N1.setGravity(Gravity.CENTER);
                N1.setBackgroundColor(Color.BLACK);
                N1.setTextColor(Color.WHITE);
                N1.setPadding(4, 4,4,4);
                N1.setLayoutParams(layouN1);
                fila.addView(N1);

                N2 = new TextView(this);
                N2.setText("N2");
                N2.setGravity(Gravity.CENTER);
                N2.setBackgroundColor(Color.BLACK);
                N2.setTextColor(Color.WHITE);
                N2.setPadding(4, 4,4,4);
                N2.setLayoutParams(layouN2);
                fila.addView(N2);


                n = new TextView(this);
                n.setText("n");
                n.setGravity(Gravity.CENTER);
                n.setBackgroundColor(Color.BLACK);
                n.setTextColor(Color.WHITE);
                n.setPadding(4, 4,4,4);
                n.setLayoutParams(layoun);
                fila.addView(n);

                N = new TextView(this);
                N.setText("N");
                N.setGravity(Gravity.CENTER);
                N.setBackgroundColor(Color.BLACK);
                N.setTextColor(Color.WHITE);
                N.setPadding(4, 4,4,4);
                N.setLayoutParams(layouN);
                fila.addView(N);

                d = new TextView(this);
                d.setText("D");
                d.setGravity(Gravity.CENTER);
                d.setBackgroundColor(Color.BLACK);
                d.setTextColor(Color.WHITE);
                d.setPadding(4, 4,4,4);
                d.setLayoutParams(layoud);
                fila.addView(d);

                v = new TextView(this);
                v.setText("V");
                v.setGravity(Gravity.CENTER);
                v.setBackgroundColor(Color.BLACK);
                v.setTextColor(Color.WHITE);
                v.setPadding(4, 4,4,4);
                v.setLayoutParams(layouv);
                fila.addView(v);

                l = new TextView(this);
                l.setText("L");
                l.setGravity(Gravity.CENTER);
                l.setBackgroundColor(Color.BLACK);
                l.setTextColor(Color.WHITE);
                l.setPadding(4, 4,4,4);
                l.setLayoutParams(layoul);
                fila.addView(l);

                t = new TextView(this);
                t.setText("T");
                t.setGravity(Gravity.CENTER);
                t.setBackgroundColor(Color.BLACK);
                t.setTextColor(Color.WHITE);
                t.setPadding(4, 4,4,4);
                t.setLayoutParams(layout);
                fila.addView(t);

                e = new TextView(this);
                e.setText("E");
                e.setGravity(Gravity.CENTER);
                e.setBackgroundColor(Color.BLACK);
                e.setTextColor(Color.WHITE);
                e.setPadding(4, 4,4,4);
                e.setLayoutParams(layoue);
                fila.addView(e);

                b = new TextView(this);
                b.setText("B");
                b.setGravity(Gravity.CENTER);
                b.setBackgroundColor(Color.BLACK);
                b.setTextColor(Color.WHITE);
                b.setPadding(4, 4,4,4);
                b.setLayoutParams(layoub);
                fila.addView(b);

                tLTabla.addView(fila);
            }else{

                id = new TextView(this);
                id.setText(ListaUsuario.get(i).getId());
                id.setPadding(4, 4,4,4);
                id.setLayoutParams(layouid);
                fila.addView(id);

                n1 = new TextView(this);
                n1.setText(ListaUsuario.get(i).getPn1());
                n1.setPadding(4, 4,4,4);
                n1.setLayoutParams(layoun1);
                fila.addView(n1);

                n2 = new TextView(this);
                n2.setText(ListaUsuario.get(i).getPn2());
                n2.setPadding(4, 4,4,4);
                n2.setLayoutParams(layoun2);
                fila.addView(n2);


                N1 = new TextView(this);
                N1.setText(ListaUsuario.get(i).getN1());
                N1.setPadding(4, 4,4,4);
                N1.setLayoutParams(layouN1);
                fila.addView(N1);

                N2 = new TextView(this);
                N2.setText(ListaUsuario.get(i).getN2());
                N2.setPadding(4, 4,4,4);
                N2.setLayoutParams(layoun2);
                fila.addView(N2);


                n = new TextView(this);
                n.setText(ListaUsuario.get(i).getPn());
                n.setPadding(4, 4,4,4);
                n.setLayoutParams(layoun);
                fila.addView(n);

                N = new TextView(this);
                N.setText(ListaUsuario.get(i).getN());
                N.setPadding(4, 4,4,4);
                N.setLayoutParams(layouN);
                fila.addView(N);

                d = new TextView(this);
                d.setText(ListaUsuario.get(i).getD());
                d.setPadding(4, 4,4,4);
                d.setLayoutParams(layoud);
                fila.addView(d);

                v = new TextView(this);
                v.setText(ListaUsuario.get(i).getV());
                v.setPadding(4, 4,4,4);
                v.setLayoutParams(layouv);
                fila.addView(v);

                l = new TextView(this);
                l.setText(ListaUsuario.get(i).getL());
                l.setPadding(4, 4,4,4);
                l.setLayoutParams(layoul);
                fila.addView(l);

                t = new TextView(this);
                t.setText(ListaUsuario.get(i).getT());
                t.setPadding(4, 4,4,4);
                t.setLayoutParams(layout);
                fila.addView(t);

                e = new TextView(this);
                e.setText(ListaUsuario.get(i).getE());
                e.setPadding(4, 4,4,4);
                e.setLayoutParams(layouid);
                fila.addView(e);

                b = new TextView(this);
                b.setText(ListaUsuario.get(i).getB());
                b.setPadding(4, 4,4,4);
                b.setLayoutParams(layoub);
                fila.addView(b);

                tLTabla.addView(fila);
            }
        }
    }
}