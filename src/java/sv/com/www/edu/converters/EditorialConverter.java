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
import sv.com.www.edu.entities.EditorialesEntity;
import sv.com.www.edu.model.EditorialEJB;

/**
 *
 * @author DTO
 */

@FacesConverter(forClass = EditorialesEntity.class)
public class EditorialConverter implements Converter{

    EditorialEJB editorialEJB = lookupEditorialEJBBean();

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value==null|| value.isEmpty()) {
            return null;
        }
        return editorialEJB.obtenerEditorial(Integer.valueOf(value));
        
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
       if (value==null) {
            return "";
        }
        if (value instanceof  EditorialesEntity) {
            return String.valueOf(((EditorialesEntity) value).getCodigoEditorial());
        }
       return "";
    }

    private EditorialEJB lookupEditorialEJBBean() {
        try {
            Context c = new InitialContext();
            return (EditorialEJB) c.lookup("java:global/InventarioLibro_JSF/EditorialEJB!sv.com.www.edu.model.EditorialEJB");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
}
