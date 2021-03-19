package com.example.menudelaplicativo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.session.MediaSession;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;


public class CalcularMetricas extends AppCompatActivity {

    private static Token operatorsList=new Token();
    public static Token operandsList = new Token();
    public String doc;
    Button btnBuscar;
    TextView txtUbicacion;
    TextView txtTexto;
    TextView txtTexto1;
    String ubicacion="";


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
               Intent i = new Intent(CalcularMetricas.this,Explorador.class);
               startActivity(i);
             }
         });

         try {
            Intent i = getIntent();
            ubicacion = i.getExtras().getString("ubicacion");
            doc = ubicacion;
            //Ubicacion del archivo
            ArrayList<String> codePython = initCodePython(doc);
             System.out.println("Los resultados son: "+getHalstead(codePython));
             //System.out.println("Los resultados 2 son: "+operandsList);
             String auxw=getHalstead(codePython).toString();
             txtTexto1.setText(limpiarCodigo(auxw));
         }catch (Exception e){
           System.out.println("Error al encontrar la direccion del archivo");
         }

         if(ubicacion!=""){
             abrirArchivo();
         }
    }

//Abre el archivo para poder leer sus datos que tiene
    private void abrirArchivo(){
     try {
         txtUbicacion.setText(ubicacion);
         System.out.println(ubicacion);
         File f = new File(ubicacion);
         if(f==null)
             txtTexto.setText("Archivo No soportado");
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
        operators.add("def");
        operators.add(":");
        operators.add("=");
        operators.add(">");
        operators.add("+");
        operators.add("-");
        operators.add("while");
        operators.add(">");
        operators.add(",");
        operators.add("(");
        return operators;
    }

    private static ArrayList<String> getArrayNoOperators() {
        ArrayList<String> operators = new ArrayList<String>();
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
}