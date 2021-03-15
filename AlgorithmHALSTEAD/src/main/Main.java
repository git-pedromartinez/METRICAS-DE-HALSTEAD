package main;

import models.HalsteadDTO;
import objs.Halstead;
import objs.Token;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Main {

    private static Token operatorsList = new Token();
    private static Token operandsList = new Token();
    ;

    public static void main(String[] args) {
        ArrayList<String> codePython = initCodePython("C:/dev/py/mul.py");
        System.out.println(getHalstead(codePython));
        System.out.println(operandsList);
    }

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
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
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
}
