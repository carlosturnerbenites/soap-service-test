/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.services;

import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author kohaku
 */
@WebService(serviceName = "SeriesService")
public class SeriesService {
    SerieHelper helper;

    public SeriesService() {
        helper = new SerieHelper();
    }

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "all")
    public List<Series> all() {
        return helper.all();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "create")
    public Series create(@WebParam(name = "name") String name, @WebParam(name = "year") int year, @WebParam(name = "rate") double rate) {
        //TODO write your implementation code here:
        return helper.create(name, year, rate);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "update")
    public Series update(@WebParam(name = "name") String name, @WebParam(name = "year") int year, @WebParam(name = "rate") double rate) {
        //TODO write your implementation code here:
        return null;
    }
}
