package com.example.menudelaplicativo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.session.MediaSession;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;


public class CalcularMetricas extends AppCompatActivity {

    private static Token operatorsList=new Token();
    public static Token operandsList = new Token();
    public Button btnBuscar;
    public TextView txtUbicacion;
    public TextView txtTexto;
    public TextView txtTexto1;
    public String ubicacion="";
    public String doc=null;
    private int id=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcular_metricas);
        txtUbicacion = (TextView)findViewById(R.id.txtUbicacion);
        txtTexto = (TextView)findViewById(R.id.txtTexto);
        txtTexto1 = (TextView)findViewById(R.id.txtRes);
        btnBuscar = (Button)findViewById(R.id.btbus);
        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(CalcularMetricas.this,Explorador.class);
                startActivity(i);
            }
        });

        try {
            //doc="";
            Intent i = getIntent();
            ubicacion = i.getExtras().getString("ubicacion");
            doc = ubicacion;


            if(verificArchivo(doc)==true){
                //Ubicacion del archivo
                ArrayList<String> codePython = initCodePython(doc);
                String auxw=getHalstead(codePython).toString();
                //System.out.println("Los resultados son: "+limpiarCodigo(auxw));
                txtTexto1.setText(limpiarCodigo(auxw));

                if(ubicacion!=""){
                    abrirArchivo();
                }

            }else{

            }


        }catch (Exception e){
            System.out.println("Error al encontrar la direccion del archivo");
        }
    }


//Abre el archivo para poder leer sus datos que tiene
    private void abrirArchivo(){
     try {
         txtUbicacion.setText(ubicacion);
         System.out.println(ubicacion);
         File f = new File(ubicacion);
         if(f==null){
             txtTexto.setText("Archivo No soportado");
         }else{
             FileReader fr = new FileReader(f);
             BufferedReader br = new BufferedReader(fr);
             String texto = br.readLine();
             String aux = "";
             while (texto!=null){
                 aux= aux+texto;
                 texto = br.readLine();
             }
             txtTexto.setText(aux);
             br.close();
         }
     }catch (Exception ex){
       System.out.println("Error al momento de abrir el archivo");
     }
    }

    //Proceso a realizar del prograna
    public static ArrayList<String> initCodePython(String path) {
        ArrayList<String> codePython = new ArrayList<String>();
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        try {
            archivo = new File(path);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null) {
                codePython.add(linea);
            }
        } catch (Exception e) {
            System.out.println("Error al abrir el archivo");
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                System.out.println("Error al cerrar el archivo");
            }
        }
        return codePython;
    }

    public static Halstead getHalstead(ArrayList<String> code) {
        int n1 = 0, N1 = 0, n2 = 0, N2 = 0;
        HalsteadDTO h = new HalsteadDTO(0, 0, 0, 0);
        for (String lineCode : code) {
            h = getCount(lineCode);
        }
        return new Halstead(h.n1, h.N1, h.n2, h.N2);
    }

    private static HalsteadDTO getCount(String lineCode) {
        ArrayList<String> operators = getArrayOperators();
        //for operators
        for (String operator : operators) {
            if (lineCode.length() <= 0) {
                break;
            } else {
                if (!(lineCode.indexOf(operator) == -1)) {
                    operatorsList.add(operator);
                    lineCode = lineCode.replace(operator, " ");
                }
            }
        }
        //for operands
        //clean operands, delete no operators
        for (String operator:getArrayNoOperators()){
            lineCode = lineCode.replace(operator, " ");
        }
        String operandsVec[] = lineCode.split(" ");
        for (String o : operandsVec) {
            if (o.length() >= 1) {
                operandsList.add(o);
            }
        }
        return new HalsteadDTO(operatorsList.getLength(), operatorsList.countTotal(), operandsList.getLength(), operandsList.countTotal());
    }

    private static ArrayList<String> getArrayOperators() {
        ArrayList<String> operators = new ArrayList<String>();
        //palabras reservadas del lenguaje
        operators.add("and");
        operators.add("del");
        operators.add("for");
        operators.add("is");
        operators.add("raise");
        operators.add("assert");
        operators.add("if");
        operators.add("else");
        operators.add("elif");
        operators.add("from");
        operators.add("lambda");
//        operators.add("return");
        operators.add("break");
        operators.add("global");
        operators.add("not");
        operators.add("try");
        operators.add("class");
        operators.add("except");
        operators.add("or");
        operators.add("while");
        operators.add("continue");
        operators.add("exec");
        operators.add("import");
        operators.add("yield");
        operators.add("def");
        operators.add("finally");
        operators.add("in");
        operators.add("print");
        //operadores del lenguaje
            //unarios
        operators.add(":");
            //binarios
        operators.add("+");
        operators.add("-");
        operators.add("=");
        operators.add(">");
        operators.add("<");
            //otros
        operators.add(",");
        operators.add(".");
        operators.add("[");
        operators.add("(");
        return operators;
    }

    private static ArrayList<String> getArrayNoOperators() {
        ArrayList<String> operators = new ArrayList<String>();
        //operadores de cierre
        operators.add("]");
        operators.add(")");
        operators.add("return");
        return operators;
    }

    public String getDoc() {
        return doc;
    }

    public void setDoc(String doc) {
        this.doc = doc;
    }

    public String limpiarCodigo(String cadena){
        String aux=" "; int b=0;
          for(int i=0;i<cadena.length();i++){
              if(cadena.charAt(i)=='}'){
                  b=0;
              }
              if(b==1){
                  aux = aux+cadena.charAt(i);
              }
              if(cadena.charAt(i)=='{'){
                 b=1;
              }
         }
      return aux;
    }
     public boolean verificArchivo(String ruta){
     boolean v=false;
          int i=0,b=0,tam=ruta.length();

          while((i<tam)&&(v==false)){

              if(b==1){
                  if(((ruta.charAt(i)=='p')||(ruta.charAt(i)=='P'))&&(i==tam-2)){
                      i++;
                      if(((ruta.charAt(i)=='y')||(ruta.charAt(i)=='Y'))&&(i==tam-1)){
                          v=true;
                      }
                  }
              }


              if(ruta.charAt(i)=='.'){
                  b=1;
              }
              i++;
          }
         return v;
     }

    public void Guardar(View view){
        if(doc!=null){
            int i=1;
            while(Buscarid(i)==false){
                i++;
            }

            if(Buscarid(i))  {
                AdmiSQLiteOpenHelper admin = new AdmiSQLiteOpenHelper(this,"Administracion",null,1);
                SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

                String codigo = String.valueOf(i);
                ArrayList<String> codePython = initCodePython(doc);
                ContentValues registro = new ContentValues();
                Halstead v =getHalstead(codePython);

                registro.put("codigo",codigo);
                registro.put("n",v.n);
                registro.put("n1",v.n1);
                registro.put("n2",v.n2);
                registro.put("xN",v.N);
                registro.put("xN1",v.N1);
                registro.put("xN2",v.N2);
                registro.put("V",v.V);
                registro.put("d",v.D);
                registro.put("l",v.L);
                registro.put("e",v.E);
                registro.put("t",v.T);
                registro.put("b",v.B);

                BaseDeDatos.insert("datos",null,registro);
                BaseDeDatos.close();
                Toast.makeText(this,"Registro exitoso",Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this,"Selecciona el codigo primero",Toast.LENGTH_SHORT).show();
        }

    }


    public boolean Buscarid(int i){
        boolean v=false;
        AdmiSQLiteOpenHelper admin = new AdmiSQLiteOpenHelper(this,"Administracion",null,1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();
        String codigo="1";

        codigo = String.valueOf(i);

            Cursor fila = BaseDeDatos.rawQuery("select  *  from  datos where codigo =" + codigo,null);

            if(!fila.moveToFirst()){
                v=true;
                BaseDeDatos.close();
            }else{
                v=false;
                BaseDeDatos.close();
                // Toast.makeText(this,"Este id ya esta registrado",Toast.LENGTH_SHORT).show();

            }
        return v;
    }


}