/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.www.edu.model;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import sv.com.www.edu.entities.GenerosEntity;


/**
 *
 * @author DTO
 */
@Stateless
public class GeneroEJB {

    @PersistenceContext(unitName = "InventarioLibro_JSFPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    
    public List<GenerosEntity> listarGeneros(){
        Query query=em.createNamedQuery("GenerosEntity.findAll");
        return query.getResultList();
    }
    
    public GenerosEntity obtenerGenero(Integer codigo){
        GenerosEntity genero=em.find(GenerosEntity.class, codigo);
        return genero;
    }
    
    public int insertarGenero(GenerosEntity genero){
        try {
            em.persist(genero);
            em.flush();
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }
    
    public int modificarGenero(GenerosEntity genero){
        try {
            em.merge(genero);
            em.flush();
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }
    
    public int eliminarGenero(Integer codigo){
        try {
            GenerosEntity genero=em.find(GenerosEntity.class, codigo);
            em.remove(genero);
            em.flush();
            return 1;
        } catch (Exception e) {
            return 0;
        }
        
    }
    
    
    
   
}
