package com.kolomiychuk.calculator;

import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;


@Component
@Path("/calculate")
public class Controller {

    private static final String PARAM_A = "a";
    private static final String PARAM_B = "b";
    private static final String PARAM_C = "c";
    private static final String APPLICATION_JSON = "application/json";
    private final Service service = new Service();

    /**
     * Method that calculates sum of 3 parameters
     *
     * @return HTTP response
     */
    @GET
    @Produces(APPLICATION_JSON)
    @Path("/add/{a}/{b}/{c}")
    public Response addOperation(@PathParam(PARAM_A) String a, @PathParam(PARAM_B) String b, @PathParam(PARAM_C) String c) {
        CacheControl cc = new CacheControl();
        cc.setMaxAge(86400);
        cc.setPrivate(true);
        try {
            ResponseBuilder builder = Response.ok(service.addOperation(a, b, c));
            builder.cacheControl(cc);
            return builder.build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    /**
     * Method that calculates subtraction of 3 parameters
     *
     * @return HTTP response
     */
    @GET
    @Produces(APPLICATION_JSON)
    @Path("/subtract/{a}/{b}/{c}")
    public Response subtractOperation(@PathParam(PARAM_A) String a, @PathParam(PARAM_B) String b, @PathParam(PARAM_C) String c) {
        CacheControl cc = new CacheControl();
        cc.setMaxAge(86400);
        cc.setPrivate(true);
        try {
            ResponseBuilder builder = Response.ok(service.subtractOperation(a, b, c));
            builder.cacheControl(cc);
            return builder.build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    /**
     * Method that calculates multiplication of 3 parameters
     *
     * @return HTTP response
     */
    @GET
    @Produces(APPLICATION_JSON)
    @Path("/multiply/{a}/{b}/{c}")
    public Response multiplyOperation(@PathParam(PARAM_A) String a, @PathParam(PARAM_B) String b, @PathParam(PARAM_C) String c) {
        CacheControl cc = new CacheControl();
        cc.setMaxAge(86400);
        cc.setPrivate(true);
        try {
            ResponseBuilder builder = Response.ok(service.multiplyOperation(a, b, c));
            builder.cacheControl(cc);
            return builder.build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    /**
     * Method that calculates division of 2 parameters
     *
     * @return HTTP response
     */
    @GET
    @Produces(APPLICATION_JSON)
    @Path("/divide/{a}/{b}")
    public Response divideOperation(@PathParam(PARAM_A) String a, @PathParam(PARAM_B) String b) {
        CacheControl cc = new CacheControl();
        cc.setMaxAge(86400);
        try {
            ResponseBuilder builder = Response.ok(service.divideOperation(a, b));
            builder.cacheControl(cc);
            return builder.build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }
}