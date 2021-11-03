/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.www.edu.beans;

import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.context.FacesContext;
import sv.com.www.edu.entities.GenerosEntity;
import sv.com.www.edu.model.GeneroEJB;

/**
 *
 * @author DTO
 */
@Named(value = "generoBean")
@Dependent
public class GeneroBean {


    public GeneroBean() {
    }
    
    @EJB
    private GeneroEJB generoEJB;

    private List<GenerosEntity> listaGeneros;
 
    private static GenerosEntity genero=new  GenerosEntity();
    


    public List<GenerosEntity> getListaGeneros() {
        listaGeneros=generoEJB.listarGeneros();
        return listaGeneros;
    }

  
    public String nuevoGenero(){
        genero=new GenerosEntity();
        return "/generos/insertarGenero.xhtml?faces-redirect=true";
    }
    
    
    public String insertarGenero(){
        if(generoEJB.insertarGenero(genero)==0){
            return null;
        }
        return "/generos/listarGeneros.xhtml?faces-redirect=true";
    }
    
    
    public String  editarGenero(){
        String codigo=FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("codigo");
        GeneroBean.genero=generoEJB.obtenerGenero(Integer.valueOf(codigo));
        return "/generos/editarGenero.xhtml?faces-redirect=true";        
    }
    
    public String modificarGenero(){
        if(generoEJB.modificarGenero(genero)==0){
            return null;
        }
        return "/generos/listarGeneros.xhtml?faces-redirect=true";
    }
    
    
    public void eliminarGenero(){
        String codigo=FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("codigo");
        generoEJB.eliminarGenero(Integer.valueOf(codigo));
    }
    

    public GenerosEntity getGenero() {
        return genero;
    }

    public void setGenero(GenerosEntity genero) {
        this.genero = genero;
    }
    
    
}
