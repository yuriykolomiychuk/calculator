package com.kolomiychuk.calculator;

import org.junit.Assert;
import org.junit.Test;

import java.security.InvalidParameterException;


public class ServiceTest {
    public final Service service = new Service();
    private final String a = "1";
    private final String b = "2";
    private final String c = "3";


    @Test
    public void addOperation() throws Exception {
        Assert.assertEquals(6.0d, service.addOperation(a, b, c).getResult(), 0.0);
    }

    @Test
    public void subtractOperation() throws Exception {
        Assert.assertEquals(-4.0d, service.subtractOperation(a, b, c).getResult(), 0.0);
    }

    @Test
    public void multiplyOperation() throws Exception {
        Assert.assertEquals(6.0d, service.multiplyOperation(a, b, c).getResult(), 0.0);
    }

    @Test
    public void divideOperation() throws Exception {
        Assert.assertEquals(0.5d, service.divideOperation(a, b).getResult(), 0.0);
    }

    @Test(expected = InvalidParameterException.class)
    public void addOperation_UnexpectedCharacter() throws Exception {
        String b = "xyz";
        service.addOperation(a, b, c);
    }

    @Test(expected = InvalidParameterException.class)
    public void subtractOperation_UnexpectedCharacter() throws Exception {
        String b = "xyz";
        service.subtractOperation(a, b, c);
    }

    @Test(expected = InvalidParameterException.class)
    public void multiplyOperation_UnexpectedCharacter() throws Exception {
        String b = "xyz";
        service.multiplyOperation(a, b, c);
    }

    @Test(expected = InvalidParameterException.class)
    public void divideOperation_UnexpectedCharacter() throws Exception {
        String b = "xyz";
        service.divideOperation(a, b);
    }
}