/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entitys;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author GUSTAVO
 */
@Entity
@Table(name = "unidad_ruta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UnidadRuta.findAll", query = "SELECT u FROM UnidadRuta u"),
    @NamedQuery(name = "UnidadRuta.findByIdUnidadRuta", query = "SELECT u FROM UnidadRuta u WHERE u.idUnidadRuta = :idUnidadRuta"),
    @NamedQuery(name = "UnidadRuta.findByFechaInicio", query = "SELECT u FROM UnidadRuta u WHERE u.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "UnidadRuta.findByFechaFin", query = "SELECT u FROM UnidadRuta u WHERE u.fechaFin = :fechaFin")})
public class UnidadRuta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "id_unidad_ruta")
    private String idUnidadRuta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUnidadRuta")
    private Collection<Viajes> viajesCollection;
    @JoinColumn(name = "id_unidad", referencedColumnName = "id_unidad")
    @ManyToOne(optional = false)
    private Unidades idUnidad;
    @JoinColumn(name = "id_ruta", referencedColumnName = "id_ruta")
    @ManyToOne(optional = false)
    private Rutas idRuta;

    public UnidadRuta() {
    }

    public UnidadRuta(String idUnidadRuta) {
        this.idUnidadRuta = idUnidadRuta;
    }

    public UnidadRuta(String idUnidadRuta, Date fechaInicio, Date fechaFin) {
        this.idUnidadRuta = idUnidadRuta;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public String getIdUnidadRuta() {
        return idUnidadRuta;
    }

    public void setIdUnidadRuta(String idUnidadRuta) {
        this.idUnidadRuta = idUnidadRuta;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    @XmlTransient
    public Collection<Viajes> getViajesCollection() {
        return viajesCollection;
    }

    public void setViajesCollection(Collection<Viajes> viajesCollection) {
        this.viajesCollection = viajesCollection;
    }

    public Unidades getIdUnidad() {
        return idUnidad;
    }

    public void setIdUnidad(Unidades idUnidad) {
        this.idUnidad = idUnidad;
    }

    public Rutas getIdRuta() {
        return idRuta;
    }

    public void setIdRuta(Rutas idRuta) {
        this.idRuta = idRuta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUnidadRuta != null ? idUnidadRuta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UnidadRuta)) {
            return false;
        }
        UnidadRuta other = (UnidadRuta) object;
        if ((this.idUnidadRuta == null && other.idUnidadRuta != null) || (this.idUnidadRuta != null && !this.idUnidadRuta.equals(other.idUnidadRuta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitys.UnidadRuta[ idUnidadRuta=" + idUnidadRuta + " ]";
    }
    
}
