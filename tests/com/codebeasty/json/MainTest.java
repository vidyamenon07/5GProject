package com.codebeasty.json;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.BufferedReader;

import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class MainTest {
    static Main test;
    static BufferedReader in = null;
    @BeforeClass
    public static void beforeclass()
    {
        test=new Main();
    }
    @AfterClass
    public static void afterclass(){
        test = null;
    }
    @Test(expected = IllegalArgumentException.class)
    public void main() throws Exception{

        Double result = test.readHTML("GOOG");


    }
    @Test(timeout=2)
    public void checktime() throws Exception{
        Double result = test.readHTML("GOOG");

    }
    @Test
    public void checktoken()
    {
        String teststring = "INFY - 100,GOOG - 50";
        String[] actual=test.readFirstline(teststring);
        String[] expected = {"INFY - 100","GOOG - 50"};
        assertArrayEquals(expected,actual);

    }
    @Test
    public void checkemptytoken()
    {
        String teststring = "";
        String[] actual=test.readFirstline(teststring);
        String[] expected = {};
        assertArrayEquals(expected,actual);

    }
    @Test
    public void checksecondtoken()
    {
        String teststring = "GOOG-50";
        String[] actual=test.breakLines(teststring);
        String[] expected = {"GOOG","50"};
        assertArrayEquals(expected,actual);

    }
    @Test
    public void calculate()
    {
        Double actual=test.gettotal(10.00, String.valueOf(10));
        Double expected = 100.00;
        assertEquals(expected,actual);

    }
    @Test
    public void sortTest()
    {
        Double[] vals = {560.00,7000.00,800.00};
        String[] data = {"Test1","Test2","Test3"};
        String[] actual=test.sort(vals,data);
        String[] expected = {"Test2","Test3","Test1"};
        assertArrayEquals(expected,actual);

    }


}
