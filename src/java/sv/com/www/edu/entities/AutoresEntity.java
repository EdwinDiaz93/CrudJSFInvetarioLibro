/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.www.edu.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author DTO
 */
@Entity
@Table(name = "AUTORES", catalog = "", schema = "DC13018")
@NamedQueries({
    @NamedQuery(name = "AutoresEntity.findAll", query = "SELECT a FROM AutoresEntity a")
    , @NamedQuery(name = "AutoresEntity.findByCodigoAutor", query = "SELECT a FROM AutoresEntity a WHERE a.codigoAutor = :codigoAutor")
    , @NamedQuery(name = "AutoresEntity.findByNombreAutor", query = "SELECT a FROM AutoresEntity a WHERE a.nombreAutor = :nombreAutor")
    , @NamedQuery(name = "AutoresEntity.findByNacionalidad", query = "SELECT a FROM AutoresEntity a WHERE a.nacionalidad = :nacionalidad")})
public class AutoresEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(generator="AUT_SEQ")
    @SequenceGenerator(name="AUT_SEQ",sequenceName="AUT_SEQ", allocationSize=1)
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_AUTOR", nullable = false, precision = 38, scale = 0)
    private Integer codigoAutor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "NOMBRE_AUTOR", nullable = false, length = 150)
    private String nombreAutor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(nullable = false, length = 50)
    private String nacionalidad;
    @OneToMany(mappedBy = "codigoAutor")
    private List<LibrosEntity> librosEntityList;

    public AutoresEntity() {
    }

    public AutoresEntity(Integer codigoAutor) {
        this.codigoAutor = codigoAutor;
    }

    public AutoresEntity(Integer codigoAutor, String nombreAutor, String nacionalidad) {
        this.codigoAutor = codigoAutor;
        this.nombreAutor = nombreAutor;
        this.nacionalidad = nacionalidad;
    }

    public Integer getCodigoAutor() {
        return codigoAutor;
    }

    public void setCodigoAutor(Integer codigoAutor) {
        this.codigoAutor = codigoAutor;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public List<LibrosEntity> getLibrosEntityList() {
        return librosEntityList;
    }

    public void setLibrosEntityList(List<LibrosEntity> librosEntityList) {
        this.librosEntityList = librosEntityList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoAutor != null ? codigoAutor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AutoresEntity)) {
            return false;
        }
        AutoresEntity other = (AutoresEntity) object;
        if ((this.codigoAutor == null && other.codigoAutor != null) || (this.codigoAutor != null && !this.codigoAutor.equals(other.codigoAutor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.www.edu.entities.AutoresEntity[ codigoAutor=" + codigoAutor + " ]";
    }
    
}
