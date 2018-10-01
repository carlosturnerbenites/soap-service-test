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
     * Web service operation
     */
    @WebMethod(operationName = "all")
    public List<Series> all(@WebParam(name = "fieldSort") String fieldSort, @WebParam(name = "dirSort") String dirSort) {
        return helper.all(fieldSort, dirSort);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "create")
    public Series create(@WebParam(name = "name") String name, @WebParam(name = "rate") int rate, @WebParam(name = "episodes") int episodes, @WebParam(name = "malLink") String malLink, @WebParam(name = "malImg") String malImg) {
        //TODO write your implementation code here:
        
        return helper.create(name, rate, episodes, malLink, malImg);
    }

    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "findById")
    public Series findById(@WebParam(name = "id") int id) {
        //TODO write your implementation code here:
        return helper.findById(id);
    }
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "update")
    public Series update(@WebParam(name = "id") int id, @WebParam(name = "name") String name, @WebParam(name = "rate") int rate, @WebParam(name = "episodes") int episodes, @WebParam(name = "malLink") String malLink, @WebParam(name = "malImg") String malImg) {
        return helper.updateById(id, name, rate, episodes, malLink, malImg);
    }
    
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "delete")
    public Series delete(@WebParam(name = "id") int id) {
        return helper.deleteById(id);
    }
}
