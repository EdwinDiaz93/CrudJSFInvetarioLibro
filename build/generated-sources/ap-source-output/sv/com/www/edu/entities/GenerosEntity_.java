package sv.com.www.edu.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sv.com.www.edu.entities.LibrosEntity;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2021-11-03T08:06:05")
@StaticMetamodel(GenerosEntity.class)
public class GenerosEntity_ { 

    public static volatile ListAttribute<GenerosEntity, LibrosEntity> librosEntityList;
    public static volatile SingularAttribute<GenerosEntity, String> nombreGenero;
    public static volatile SingularAttribute<GenerosEntity, String> descripcionGenero;
    public static volatile SingularAttribute<GenerosEntity, Integer> codigoGenero;

}