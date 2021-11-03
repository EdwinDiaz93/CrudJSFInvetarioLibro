package sv.com.www.edu.entities;

import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sv.com.www.edu.entities.AutoresEntity;
import sv.com.www.edu.entities.EditorialesEntity;
import sv.com.www.edu.entities.GenerosEntity;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2021-11-03T08:06:05")
@StaticMetamodel(LibrosEntity.class)
public class LibrosEntity_ { 

    public static volatile SingularAttribute<LibrosEntity, BigInteger> existencias;
    public static volatile SingularAttribute<LibrosEntity, Integer> codigoLibro;
    public static volatile SingularAttribute<LibrosEntity, Double> precio;
    public static volatile SingularAttribute<LibrosEntity, String> descripcionL;
    public static volatile SingularAttribute<LibrosEntity, String> nombreLibro;
    public static volatile SingularAttribute<LibrosEntity, EditorialesEntity> codigoEditorial;
    public static volatile SingularAttribute<LibrosEntity, AutoresEntity> codigoAutor;
    public static volatile SingularAttribute<LibrosEntity, GenerosEntity> codigoGenero;

}