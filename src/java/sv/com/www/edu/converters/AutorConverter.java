/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.www.edu.converters;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import sv.com.www.edu.entities.AutoresEntity;
import sv.com.www.edu.model.AutorEJB;

/**
 *
 * @author DTO
 */
@FacesConverter(forClass = AutoresEntity.class)
public class AutorConverter implements Converter{

    AutorEJB autorEJB = lookupAutorEJBBean();

    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value==null||value.isEmpty()){
            return "";
        }
        return autorEJB.obtenerAutor(Integer.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value==null){
            return "";
        }
        if (value instanceof AutoresEntity) {
            return String.valueOf(((AutoresEntity) value).getCodigoAutor());
        }
        return "";
    }

    private AutorEJB lookupAutorEJBBean() {
        try {
            Context c = new InitialContext();
            return (AutorEJB) c.lookup("java:global/InventarioLibro_JSF/AutorEJB!sv.com.www.edu.model.AutorEJB");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
}
