/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entitys;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author GUSTAVO
 */
@Entity
@Table(name = "rutas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rutas.findAll", query = "SELECT r FROM Rutas r"),
    @NamedQuery(name = "Rutas.findByIdRuta", query = "SELECT r FROM Rutas r WHERE r.idRuta = :idRuta"),
    @NamedQuery(name = "Rutas.findByNombreRuta", query = "SELECT r FROM Rutas r WHERE r.nombreRuta = :nombreRuta"),
    @NamedQuery(name = "Rutas.findByDescripcionRuta", query = "SELECT r FROM Rutas r WHERE r.descripcionRuta = :descripcionRuta")})
public class Rutas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "id_ruta")
    private String idRuta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nombre_ruta")
    private String nombreRuta;
    @Size(max = 50)
    @Column(name = "descripcion_ruta")
    private String descripcionRuta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRuta")
    private Collection<ParadaRuta> paradaRutaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRuta")
    private Collection<UnidadRuta> unidadRutaCollection;

    public Rutas() {
    }

    public Rutas(String idRuta) {
        this.idRuta = idRuta;
    }

    public Rutas(String idRuta, String nombreRuta) {
        this.idRuta = idRuta;
        this.nombreRuta = nombreRuta;
    }

    public String getIdRuta() {
        return idRuta;
    }

    public void setIdRuta(String idRuta) {
        this.idRuta = idRuta;
    }

    public String getNombreRuta() {
        return nombreRuta;
    }

    public void setNombreRuta(String nombreRuta) {
        this.nombreRuta = nombreRuta;
    }

    public String getDescripcionRuta() {
        return descripcionRuta;
    }

    public void setDescripcionRuta(String descripcionRuta) {
        this.descripcionRuta = descripcionRuta;
    }

    @XmlTransient
    public Collection<ParadaRuta> getParadaRutaCollection() {
        return paradaRutaCollection;
    }

    public void setParadaRutaCollection(Collection<ParadaRuta> paradaRutaCollection) {
        this.paradaRutaCollection = paradaRutaCollection;
    }

    @XmlTransient
    public Collection<UnidadRuta> getUnidadRutaCollection() {
        return unidadRutaCollection;
    }

    public void setUnidadRutaCollection(Collection<UnidadRuta> unidadRutaCollection) {
        this.unidadRutaCollection = unidadRutaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRuta != null ? idRuta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rutas)) {
            return false;
        }
        Rutas other = (Rutas) object;
        if ((this.idRuta == null && other.idRuta != null) || (this.idRuta != null && !this.idRuta.equals(other.idRuta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitys.Rutas[ idRuta=" + idRuta + " ]";
    }
    
}
