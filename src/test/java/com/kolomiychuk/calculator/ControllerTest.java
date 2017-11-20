package com.kolomiychuk.calculator;

import org.junit.Assert;
import org.junit.Test;

import javax.ws.rs.core.Response;


public class ControllerTest {
    private Controller controller = new Controller();
    private static String a = "1";
    private static String b = "2";
    private static String c = "3";

    @Test
    public void addOperation_Success() throws Exception {
        Response actualResponse = controller.addOperation(a, b, c);
        Assert.assertEquals(Response.Status.OK.getStatusCode(), actualResponse.getStatus());
    }

    @Test
    public void subtractOperation_Success() throws Exception {
        Response actualResponse = controller.subtractOperation(a, b, c);
        Assert.assertEquals(Response.Status.OK.getStatusCode(), actualResponse.getStatus());
    }

    @Test
    public void multiplyOperation_Success() throws Exception {
        Response actualResponse = controller.multiplyOperation(a, b, c);
        Assert.assertEquals(Response.Status.OK.getStatusCode(), actualResponse.getStatus());
    }

    @Test
    public void divideOperation_Success() throws Exception {
        Response actualResponse = controller.divideOperation(a, b);
        Assert.assertEquals(Response.Status.OK.getStatusCode(), actualResponse.getStatus());
    }

    @Test
    public void addOperation_Failure() throws Exception {
        String b = "xyz";
        Response actualResponse = controller.addOperation(a, b, c);
        Assert.assertEquals(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), actualResponse.getStatus());
    }

    @Test
    public void subtractOperation_Failure() throws Exception {
        String b = "xyz";
        Response actualResponse = controller.subtractOperation(a, b, c);
        Assert.assertEquals(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), actualResponse.getStatus());
    }

    @Test
    public void multiplyOperation_Failure() throws Exception {
        String b = "xyz";
        Response actualResponse = controller.multiplyOperation(a, b, c);
        Assert.assertEquals(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), actualResponse.getStatus());
    }

    @Test
    public void divideOperation_Failure() throws Exception {
        String b = "xyz";
        Response actualResponse = controller.divideOperation(a, b);
        Assert.assertEquals(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), actualResponse.getStatus());
    }

}