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
@Table(name = "EDITORIALES", catalog = "", schema = "DC13018")
@NamedQueries({
    @NamedQuery(name = "EditorialesEntity.findAll", query = "SELECT e FROM EditorialesEntity e")
    , @NamedQuery(name = "EditorialesEntity.findByCodigoEditorial", query = "SELECT e FROM EditorialesEntity e WHERE e.codigoEditorial = :codigoEditorial")
    , @NamedQuery(name = "EditorialesEntity.findByNombreEditorial", query = "SELECT e FROM EditorialesEntity e WHERE e.nombreEditorial = :nombreEditorial")
    , @NamedQuery(name = "EditorialesEntity.findByContacto", query = "SELECT e FROM EditorialesEntity e WHERE e.contacto = :contacto")
    , @NamedQuery(name = "EditorialesEntity.findByTelefono", query = "SELECT e FROM EditorialesEntity e WHERE e.telefono = :telefono")})
public class EditorialesEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(generator="EDI_SEQ")
    @SequenceGenerator(name="EDI_SEQ",sequenceName="EDI_SEQ", allocationSize=1)
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_EDITORIAL", nullable = false, precision = 38, scale = 0)
    private Integer codigoEditorial;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "NOMBRE_EDITORIAL", nullable = false, length = 150)
    private String nombreEditorial;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(nullable = false, length = 150)
    private String contacto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(nullable = false, length = 50)
    private String telefono;
    @OneToMany(mappedBy = "codigoEditorial")
    private List<LibrosEntity> librosEntityList;

    public EditorialesEntity() {
    }

    public EditorialesEntity(Integer codigoEditorial) {
        this.codigoEditorial = codigoEditorial;
    }

    public EditorialesEntity(Integer codigoEditorial, String nombreEditorial, String contacto, String telefono) {
        this.codigoEditorial = codigoEditorial;
        this.nombreEditorial = nombreEditorial;
        this.contacto = contacto;
        this.telefono = telefono;
    }

    public Integer getCodigoEditorial() {
        return codigoEditorial;
    }

    public void setCodigoEditorial(Integer codigoEditorial) {
        this.codigoEditorial = codigoEditorial;
    }

    public String getNombreEditorial() {
        return nombreEditorial;
    }

    public void setNombreEditorial(String nombreEditorial) {
        this.nombreEditorial = nombreEditorial;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
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
        hash += (codigoEditorial != null ? codigoEditorial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EditorialesEntity)) {
            return false;
        }
        EditorialesEntity other = (EditorialesEntity) object;
        if ((this.codigoEditorial == null && other.codigoEditorial != null) || (this.codigoEditorial != null && !this.codigoEditorial.equals(other.codigoEditorial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.www.edu.entities.EditorialesEntity[ codigoEditorial=" + codigoEditorial + " ]";
    }
    
}
