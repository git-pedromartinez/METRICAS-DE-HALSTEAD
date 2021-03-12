package main;

import objs.Halstead;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> codePython = new ArrayList<String>();
        codePython=initCodePython();
        System.out.println(getHalstead(codePython));
    }
    private static ArrayList<String> initCodePython(){
        ArrayList<String> codePython = new ArrayList<String>();
        codePython.add("def mul(x,y):");
        codePython.add("z = 0");
        codePython.add("while x > 0:");
        codePython.add("z = z + y");
        codePython.add("x = x - 1");
        codePython.add("return z");
        return codePython;
    }
    private static String  getHalstead(ArrayList<String> code){
//        for (String string : initCodePython()) {
//            System.out.println(string);
//        }
        Halstead h=new Halstead(9,12,6,14);
        return h.getValues();
    }
    private static ArrayList<String> getArrayOperators(){
        ArrayList<String> operators=new ArrayList<String>();
        operators.add("def");
        operators.add(":");
        operators.add("=");
        operators.add("while");
        operators.add(">");
        operators.add(":");
        operators.add(":");
        operators.add(":");
        return operators;
    }
//    private static ArrayList<String> getArrayOperands(){
//        ArrayList<String> operands=new ArrayList<String>();
//        return operands;
//    }
}
