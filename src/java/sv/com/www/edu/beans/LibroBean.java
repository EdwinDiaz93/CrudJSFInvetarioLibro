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
import sv.com.www.edu.entities.AutoresEntity;
import sv.com.www.edu.entities.EditorialesEntity;
import sv.com.www.edu.entities.GenerosEntity;
import sv.com.www.edu.entities.LibrosEntity;
import sv.com.www.edu.model.AutorEJB;
import sv.com.www.edu.model.EditorialEJB;
import sv.com.www.edu.model.GeneroEJB;
import sv.com.www.edu.model.LibroEJB;

/**
 *
 * @author DTO
 */
@Named(value = "libroBean")
@RequestScoped
public class LibroBean {

    @EJB
    private GeneroEJB generoEJB;

    @EJB
    private EditorialEJB editorialEJB;

    @EJB
    private AutorEJB autorEJB;

    @EJB
    private LibroEJB libroEJB;

    private List<LibrosEntity> listaLibros;
    
    private LibrosEntity libro=new LibrosEntity();
    
    
    public LibroBean() {
    }

    
    public String nuevoLibro(){
        libro=new LibrosEntity();
        return "/libros/insertarLibro.xhtml?faces-redirect=true";
    }
    
    public String insertarLibro(){
        if (libroEJB.insertarLibro(libro)==0) {
            return null;
        }
        return "/libros/listarLibros.xhtml?faces-redirect=true";
    }
    
    
    
    public List<LibrosEntity> getListaLibros() {
        listaLibros=libroEJB.listarLibros();
        return listaLibros;
    }
    
    public List<AutoresEntity> getListaAutores() {        
        return autorEJB.listarAutores();
    }
    
    public List<GenerosEntity> getListaGeneros() {        
        return generoEJB.listarGeneros();
    }
    
    public List<EditorialesEntity> getListaEditoriales() {        
        return editorialEJB.listarEditoriales();
    }
    
    
    
    public LibrosEntity getLibro() {
        return libro;
    }

    public void setLibro(LibrosEntity libro) {
        this.libro = libro;
    }
    
    
}
