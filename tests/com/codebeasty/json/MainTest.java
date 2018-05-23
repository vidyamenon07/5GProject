package com.codebeasty.json;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MainTest {

    @Test(expected = IllegalArgumentException.class)
    public void main() throws Exception{
        Main test=new Main();
        Double result = test.readHTML("GOOG");


    }
    @Test(timeout=2)
    public void checktime() throws Exception{
        Main test=new Main();
        Double result = test.readHTML("GOOG");


    }
}