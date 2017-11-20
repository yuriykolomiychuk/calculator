package com.kolomiychuk.calculator;

import org.springframework.stereotype.Component;

import java.security.InvalidParameterException;

/**
 * @author ykolomiychuk
 */
@Component
public class Service {

    private static final int PLACES = 3;
    private static final String INPUT_IS_INVALID = "Input %s is invalid";


    /**
     * Fills up response object to represent data
     *
     * @param result double result to be displayed
     * @return response
     */
    private Response generateFinalResult(double result) {

        Response response = new Response();
        response.setResult(round(result, PLACES));
        return response;
    }


    /**
     * Rounds devision result and formats the output with 2 signs after .
     *
     * @param value  that should be rounded
     * @param places number of digits after comma
     * @return rounded value
     */
    public static double round(double value, int places) {
        if (places < 0) {
            throw new IllegalArgumentException();
        }
        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

    /**
     * Validates input parameters to forbid characters
     *
     * @param a first argument
     * @param b second argument
     * @param c third argument
     */
    private void validateInputs(String a, String b, String c) {
        if (!tryParse(a)) {
            throw new InvalidParameterException(String.format(INPUT_IS_INVALID, "a"));
        }
        if (!tryParse(b)) {
            throw new InvalidParameterException(String.format(INPUT_IS_INVALID, "b"));
        }
        if (!tryParse(c)) {
            throw new InvalidParameterException(String.format(INPUT_IS_INVALID, "c"));
        }
    }

    /**
     * Helper method to validate inputs
     *
     * @param value that should be parseds
     * @return true in case if parse is successful and false in case if exception was caught
     */
    private boolean tryParse(String value) {
        try {
            Double.parseDouble(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Method that calculates result of add operation of 3 parameters
     *
     * @return response with result
     */
    public Response addOperation(String a, String b, String c) {

        validateInputs(a, b, c);
        double a1 = Double.parseDouble(a);
        double b1 = Double.parseDouble(b);
        double c1 = Double.parseDouble(c);
        double result = a1 + b1 + c1;
        return generateFinalResult(result);
    }

    /**
     * Method that calculates result of subtract operation of 3 parameters
     *
     * @param a 1st argument
     * @param b 2nd argument
     * @param c 3rd argument
     * @return response with result
     */
    public Response subtractOperation(String a, String b, String c) {

        validateInputs(a, b, c);
        double a1 = Double.parseDouble(a);
        double b1 = Double.parseDouble(b);
        double c1 = Double.parseDouble(c);
        double result = a1 - b1 - c1;
        return generateFinalResult(result);
    }

    /**
     * Method that calculates result of multiply operation of 3 parameters
     *
     * @return response with result
     */
    public Response multiplyOperation(String a, String b, String c) {

        validateInputs(a, b, c);
        double a1 = Double.parseDouble(a);
        double b1 = Double.parseDouble(b);
        double c1 = Double.parseDouble(c);
        double result = a1 * b1 * c1;
        return generateFinalResult(result);
    }

    /**
     * Method that calculates result of divide operation of 2 parameters
     *
     * @return response with result
     */
    public Response divideOperation(String a, String b) {

        if (!tryParse(a)) {
            throw new InvalidParameterException("Input a is invalid");
        }
        if (!tryParse(b)) {
            throw new InvalidParameterException("Input b is invalid");
        }
        double a1 = Double.parseDouble(a);
        double b1 = Double.parseDouble(b);
        double result = a1 / b1;
        return generateFinalResult(result);
    }
}
