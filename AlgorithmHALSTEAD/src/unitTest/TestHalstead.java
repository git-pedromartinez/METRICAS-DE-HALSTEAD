package unitTest;

import junit.framework.TestCase;
import main.Main;
import objs.Halstead;

import java.util.ArrayList;

public class TestHalstead extends TestCase {
    public void testHalstead(){
        ArrayList<String> codePython = Main.initCodePython();
        assertEquals(new Halstead(9,12,6,14).getValues(),Main.getHalstead(codePython).getValues());
    }
}
