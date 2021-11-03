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
import sv.com.www.edu.entities.EditorialesEntity;


/**
 *
 * @author DTO
 */
@Stateless
public class EditorialEJB {

    @PersistenceContext(unitName = "InventarioLibro_JSFPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    
    public List<EditorialesEntity> listarEditoriales(){
        Query query=em.createNamedQuery("EditorialesEntity.findAll");
        return query.getResultList();
    }
    
    public EditorialesEntity obtenerEditorial(Integer codigo){
        EditorialesEntity editorial=em.find(EditorialesEntity.class, codigo);
        return editorial;
    }
    
    public int insertarEditorial(EditorialesEntity editorial){
        try {
            em.persist(editorial);
            em.flush();
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }
    
    public int modificarEditorial(EditorialesEntity editorial){
        try {
            em.merge(editorial);
            em.flush();
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }
    
    public int eliminarEditorial(Integer codigo){
        try {
            EditorialesEntity editorial=em.find(EditorialesEntity.class, codigo);
            em.remove(editorial);
            em.flush();
            return 1;
        } catch (Exception e) {
            return 0;
        }
        
    }
    
    
    
   
}
