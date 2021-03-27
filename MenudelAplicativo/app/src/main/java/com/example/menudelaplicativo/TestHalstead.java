package com.example.menudelaplicativo;

import java.util.ArrayList;

public class TestHalstead {
    public void testHalstead(){
        CalcularMetricas i = new CalcularMetricas();
        String dire = i.getDoc();
        ArrayList<String> codePython = CalcularMetricas.initCodePython(dire);
        //assertEquals(new Halstead(9,12,6,14).getValues(),CalcularMetricas.getHalstead(codePython).getValues());
    }
}
