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

import sv.com.www.edu.entities.AutoresEntity;

/**
 *
 * @author DTO
 */
@Stateless
public class AutorEJB {

    @PersistenceContext(unitName = "InventarioLibro_JSFPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    
    public List<AutoresEntity> listarAutores(){
        Query query=em.createNamedQuery("AutoresEntity.findAll");
        return query.getResultList();
    }
    
    public AutoresEntity obtenerAutor(Integer codigo){
        AutoresEntity autor=em.find(AutoresEntity.class, codigo);
        return autor;
    }
    
    public int insertarAutor(AutoresEntity autor){
        try {
            em.persist(autor);
            em.flush();
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }
    
    public int modificarAutor(AutoresEntity autor){
        try {
            em.merge(autor);
            em.flush();
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }
    
    public int eliminarAutor(Integer codigo){
        try {
            AutoresEntity autor=em.find(AutoresEntity.class, codigo);
            em.remove(autor);
            em.flush();
            return 1;
        } catch (Exception e) {
            return 0;
        }
        
    }
    
    
    
   
}
