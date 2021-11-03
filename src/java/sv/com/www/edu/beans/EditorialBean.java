/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.www.edu.beans;

import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import sv.com.www.edu.entities.EditorialesEntity;
import sv.com.www.edu.model.EditorialEJB;

/**
 *
 * @author DTO
 */
@Named(value = "editorialBean")
@RequestScoped
public class EditorialBean {

    public EditorialBean() {
    }
    
     @EJB
    private EditorialEJB editorialEJB;

    private List<EditorialesEntity> listaEditoriales;
 
    private static EditorialesEntity editorial=new  EditorialesEntity();
    


    public List<EditorialesEntity> getListaEditoriales() {
        listaEditoriales=editorialEJB.listarEditoriales();
        return listaEditoriales;
    }

  
    public String nuevoEditorial(){
        editorial=new EditorialesEntity();
        return "/editoriales/insertarEditorial.xhtml?faces-redirect=true";
    }
    
    
    public String insertarEditorial(){
        if(editorialEJB.insertarEditorial(editorial)==0){
            return null;
        }
        return "/editoriales/listarEditoriales.xhtml?faces-redirect=true";
    }
    
    
    public String  editarEditorial(){
        String codigo=FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("codigo");
        EditorialBean.editorial=editorialEJB.obtenerEditorial(Integer.valueOf(codigo));
        return "/editoriales/editarEditorial.xhtml?faces-redirect=true";        
    }
    
    public String modificarEditorial(){
        if(editorialEJB.modificarEditorial(editorial)==0){
            return null;
        }
        return "/editoriales/listarEditoriales.xhtml?faces-redirect=true";
    }
    
    
    public void eliminarEditorial(){
        String codigo=FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("codigo");
        editorialEJB.eliminarEditorial(Integer.valueOf(codigo));
    }
    

    public EditorialesEntity getEditorial() {
        return editorial;
    }

    public void setEditorial(EditorialesEntity editorial) {
        this.editorial = editorial;
    }
    
    
    
}
