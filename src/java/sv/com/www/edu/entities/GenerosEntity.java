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
@Table(name = "GENEROS", catalog = "", schema = "DC13018")
@NamedQueries({
    @NamedQuery(name = "GenerosEntity.findAll", query = "SELECT g FROM GenerosEntity g")
    , @NamedQuery(name = "GenerosEntity.findByCodigoGenero", query = "SELECT g FROM GenerosEntity g WHERE g.codigoGenero = :codigoGenero")
    , @NamedQuery(name = "GenerosEntity.findByNombreGenero", query = "SELECT g FROM GenerosEntity g WHERE g.nombreGenero = :nombreGenero")
    , @NamedQuery(name = "GenerosEntity.findByDescripcionGenero", query = "SELECT g FROM GenerosEntity g WHERE g.descripcionGenero = :descripcionGenero")})
public class GenerosEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(generator="GEN_SEQ")
    @SequenceGenerator(name="GEN_SEQ",sequenceName="GEN_SEQ", allocationSize=100)
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_GENERO", nullable = false, precision = 38, scale = 0)
    private Integer codigoGenero;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 75)
    @Column(name = "NOMBRE_GENERO", nullable = false, length = 75)
    private String nombreGenero;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "DESCRIPCION_GENERO", nullable = false, length = 100)
    private String descripcionGenero;
    @OneToMany(mappedBy = "codigoGenero")
    private List<LibrosEntity> librosEntityList;

    public GenerosEntity() {
    }

    public GenerosEntity(Integer codigoGenero) {
        this.codigoGenero = codigoGenero;
    }

    public GenerosEntity(Integer codigoGenero, String nombreGenero, String descripcionGenero) {
        this.codigoGenero = codigoGenero;
        this.nombreGenero = nombreGenero;
        this.descripcionGenero = descripcionGenero;
    }

    public Integer getCodigoGenero() {
        return codigoGenero;
    }

    public void setCodigoGenero(Integer codigoGenero) {
        this.codigoGenero = codigoGenero;
    }

    public String getNombreGenero() {
        return nombreGenero;
    }

    public void setNombreGenero(String nombreGenero) {
        this.nombreGenero = nombreGenero;
    }

    public String getDescripcionGenero() {
        return descripcionGenero;
    }

    public void setDescripcionGenero(String descripcionGenero) {
        this.descripcionGenero = descripcionGenero;
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
        hash += (codigoGenero != null ? codigoGenero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GenerosEntity)) {
            return false;
        }
        GenerosEntity other = (GenerosEntity) object;
        if ((this.codigoGenero == null && other.codigoGenero != null) || (this.codigoGenero != null && !this.codigoGenero.equals(other.codigoGenero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.www.edu.entities.GenerosEntity[ codigoGenero=" + codigoGenero + " ]";
    }
    
}
