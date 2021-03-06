/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datlp.ws.service;

import datlp.ws.TblProduct;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author DAT
 */

@Path("products")
public class TblProductFacadeREST extends AbstractFacade<TblProduct> {

//    @PersistenceContext(unitName = "WebServiceShoppingCartPU")
//    private EntityManager em;
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("WebServiceShoppingCartPU");
    private EntityManager em = emf.createEntityManager();

    public TblProductFacadeREST() {
        super(TblProduct.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(TblProduct entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, TblProduct entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public TblProduct find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<TblProduct> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<TblProduct> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }
    
    @GET
    @Path("name/{search}")
    @Produces(MediaType.APPLICATION_XML)
    public List<TblProduct> searchByLikeName(@PathParam("search") String search) {
        return super.searchProductByLikeName(search);
    }
    
    @GET
    @Path("price/{from}/{to}")
    @Produces(MediaType.APPLICATION_XML)
    public List<TblProduct> searchByPrice(@PathParam("from") float from, @PathParam("to") float to) {
        return super.searchProductByPriceInRange(from, to);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
