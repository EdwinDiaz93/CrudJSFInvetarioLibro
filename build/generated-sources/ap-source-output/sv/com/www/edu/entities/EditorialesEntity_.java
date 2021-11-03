package sv.com.www.edu.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sv.com.www.edu.entities.LibrosEntity;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2021-11-03T16:38:02")
@StaticMetamodel(EditorialesEntity.class)
public class EditorialesEntity_ { 

    public static volatile SingularAttribute<EditorialesEntity, String> contacto;
    public static volatile ListAttribute<EditorialesEntity, LibrosEntity> librosEntityList;
    public static volatile SingularAttribute<EditorialesEntity, String> nombreEditorial;
    public static volatile SingularAttribute<EditorialesEntity, Integer> codigoEditorial;
    public static volatile SingularAttribute<EditorialesEntity, String> telefono;

}