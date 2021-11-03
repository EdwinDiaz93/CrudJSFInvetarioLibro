/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.www.edu.entities;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author DTO
 */
@Entity
@Table(name = "LIBROS", catalog = "", schema = "DC13018")
@NamedQueries({
    @NamedQuery(name = "LibrosEntity.findAll", query = "SELECT l FROM LibrosEntity l")
    , @NamedQuery(name = "LibrosEntity.findByCodigoLibro", query = "SELECT l FROM LibrosEntity l WHERE l.codigoLibro = :codigoLibro")
    , @NamedQuery(name = "LibrosEntity.findByNombreLibro", query = "SELECT l FROM LibrosEntity l WHERE l.nombreLibro = :nombreLibro")
    , @NamedQuery(name = "LibrosEntity.findByExistencias", query = "SELECT l FROM LibrosEntity l WHERE l.existencias = :existencias")
    , @NamedQuery(name = "LibrosEntity.findByPrecio", query = "SELECT l FROM LibrosEntity l WHERE l.precio = :precio")
    , @NamedQuery(name = "LibrosEntity.findByDescripcionL", query = "SELECT l FROM LibrosEntity l WHERE l.descripcionL = :descripcionL")})
public class LibrosEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(generator="LIB_SEQ")
    @SequenceGenerator(name="LIB_SEQ",sequenceName="LIB_SEQ", allocationSize=100)
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_LIBRO", nullable = false, precision = 38, scale = 0)
    private Integer codigoLibro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "NOMBRE_LIBRO", nullable = false, length = 150)
    private String nombreLibro;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private BigInteger existencias;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private double precio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "DESCRIPCION_L", nullable = false, length = 100)
    private String descripcionL;
    @JoinColumn(name = "CODIGO_AUTOR", referencedColumnName = "CODIGO_AUTOR")
    @ManyToOne
    private AutoresEntity codigoAutor;
    @JoinColumn(name = "CODIGO_EDITORIAL", referencedColumnName = "CODIGO_EDITORIAL")
    @ManyToOne
    private EditorialesEntity codigoEditorial;
    @JoinColumn(name = "CODIGO_GENERO", referencedColumnName = "CODIGO_GENERO")
    @ManyToOne
    private GenerosEntity codigoGenero;

    public LibrosEntity() {
    }

    public LibrosEntity(Integer codigoLibro) {
        this.codigoLibro = codigoLibro;
    }

    public LibrosEntity(Integer codigoLibro, String nombreLibro, BigInteger existencias, double precio, String descripcionL) {
        this.codigoLibro = codigoLibro;
        this.nombreLibro = nombreLibro;
        this.existencias = existencias;
        this.precio = precio;
        this.descripcionL = descripcionL;
    }

    public Integer getCodigoLibro() {
        return codigoLibro;
    }

    public void setCodigoLibro(Integer codigoLibro) {
        this.codigoLibro = codigoLibro;
    }

    public String getNombreLibro() {
        return nombreLibro;
    }

    public void setNombreLibro(String nombreLibro) {
        this.nombreLibro = nombreLibro;
    }

    public BigInteger getExistencias() {
        return existencias;
    }

    public void setExistencias(BigInteger existencias) {
        this.existencias = existencias;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcionL() {
        return descripcionL;
    }

    public void setDescripcionL(String descripcionL) {
        this.descripcionL = descripcionL;
    }

    public AutoresEntity getCodigoAutor() {
        return codigoAutor;
    }

    public void setCodigoAutor(AutoresEntity codigoAutor) {
        this.codigoAutor = codigoAutor;
    }

    public EditorialesEntity getCodigoEditorial() {
        return codigoEditorial;
    }

    public void setCodigoEditorial(EditorialesEntity codigoEditorial) {
        this.codigoEditorial = codigoEditorial;
    }

    public GenerosEntity getCodigoGenero() {
        return codigoGenero;
    }

    public void setCodigoGenero(GenerosEntity codigoGenero) {
        this.codigoGenero = codigoGenero;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoLibro != null ? codigoLibro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LibrosEntity)) {
            return false;
        }
        LibrosEntity other = (LibrosEntity) object;
        if ((this.codigoLibro == null && other.codigoLibro != null) || (this.codigoLibro != null && !this.codigoLibro.equals(other.codigoLibro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.www.edu.entities.LibrosEntity[ codigoLibro=" + codigoLibro + " ]";
    }
    
}
