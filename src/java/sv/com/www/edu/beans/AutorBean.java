/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.www.edu.beans;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import sv.com.www.edu.entities.AutoresEntity;
import sv.com.www.edu.model.AutorEJB;

/**
 *
 * @author DTO
 */
@Named(value = "autorBean")
@RequestScoped
public class AutorBean {

    @EJB
    private AutorEJB autorEJB;

    private List<AutoresEntity> listaAutores;
 
    private static AutoresEntity autor=new  AutoresEntity();
    
    public AutorBean() {
        
    }

    public List<AutoresEntity> getListaAutores() {
        listaAutores=autorEJB.listarAutores();
        return listaAutores;
    }

  
    public String nuevoAutor(){
        autor=new AutoresEntity();
        return "/autores/insertarAutor.xhtml?faces-redirect=true";
    }
    
    
    public String insertarAutor(){
        if(autorEJB.insertarAutor(autor)==0){
            return null;
        }
        return "/autores/listarAutores.xhtml?faces-redirect=true";
    }
    
    
    public String  editarAutor(){
        String codigo=FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("codigo");
        AutorBean.autor=autorEJB.obtenerAutor(Integer.valueOf(codigo));
        return "/autores/editarAutor.xhtml?faces-redirect=true";        
    }
    
    public String modificarAutor(){
        if(autorEJB.modificarAutor(autor)==0){
            return null;
        }
        return "/autores/listarAutores.xhtml?faces-redirect=true";
    }
    
    
    public void eliminarAutor(){
        String codigo=FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("codigo");
        autorEJB.eliminarAutor(Integer.valueOf(codigo));
    }
    

    public AutoresEntity getAutor() {
        return autor;
    }

    public void setAutor(AutoresEntity autor) {
        this.autor = autor;
    }
    
    
    
}
