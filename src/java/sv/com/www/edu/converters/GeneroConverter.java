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
import sv.com.www.edu.entities.GenerosEntity;
import sv.com.www.edu.model.GeneroEJB;

/**
 *
 * @author DTO
 */
@FacesConverter(forClass = GenerosEntity.class)
public class GeneroConverter  implements Converter{

    GeneroEJB generoEJB = lookupGeneroEJBBean();

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value==null|| value.isEmpty()) {
            return "";
        }
        return generoEJB.obtenerGenero(Integer.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value==null){
            return "";
        }
        if(value instanceof GenerosEntity){
            return String.valueOf(((GenerosEntity) value).getCodigoGenero());
        }
        return "";
    }

    private GeneroEJB lookupGeneroEJBBean() {
        try {
            Context c = new InitialContext();
            return (GeneroEJB) c.lookup("java:global/InventarioLibro_JSF/GeneroEJB!sv.com.www.edu.model.GeneroEJB");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
}
