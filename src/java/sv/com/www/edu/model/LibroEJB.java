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
import sv.com.www.edu.entities.LibrosEntity;

/**
 *
 * @author DTO
 */
@Stateless
public class LibroEJB {

    @PersistenceContext(unitName = "InventarioLibro_JSFPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    public List<LibrosEntity> listarLibros(){
        Query query=em.createNamedQuery("LibrosEntity.findAll");        
        return query.getResultList();
    }
    
    public int insertarLibro(LibrosEntity libro){
        try {
            em.persist(libro);
            em.flush();
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }
      public int modificarLibro(LibrosEntity libro){
        try {
            em.merge(libro);
            em.flush();
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }
      
     public int eliminarLibro(Integer codigo){         
        try {
            LibrosEntity libro=em.find(LibrosEntity.class, codigo);
            em.remove(libro);
            em.flush();
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }
   
}
