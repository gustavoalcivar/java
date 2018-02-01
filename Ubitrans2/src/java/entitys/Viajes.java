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
@Table(name = "viajes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Viajes.findAll", query = "SELECT v FROM Viajes v"),
    @NamedQuery(name = "Viajes.findByIdViaje", query = "SELECT v FROM Viajes v WHERE v.idViaje = :idViaje"),
    @NamedQuery(name = "Viajes.findByFechaViaje", query = "SELECT v FROM Viajes v WHERE v.fechaViaje = :fechaViaje"),
    @NamedQuery(name = "Viajes.findByTiempoSalida", query = "SELECT v FROM Viajes v WHERE v.tiempoSalida = :tiempoSalida")})
public class Viajes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "id_viaje")
    private String idViaje;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_viaje")
    @Temporal(TemporalType.DATE)
    private Date fechaViaje;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tiempo_salida")
    private short tiempoSalida;
    @JoinColumn(name = "id_unidad_ruta", referencedColumnName = "id_unidad_ruta")
    @ManyToOne(optional = false)
    private UnidadRuta idUnidadRuta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idViaje")
    private Collection<Tiempos> tiemposCollection;

    public Viajes() {
    }

    public Viajes(String idViaje) {
        this.idViaje = idViaje;
    }

    public Viajes(String idViaje, Date fechaViaje, short tiempoSalida) {
        this.idViaje = idViaje;
        this.fechaViaje = fechaViaje;
        this.tiempoSalida = tiempoSalida;
    }

    public String getIdViaje() {
        return idViaje;
    }

    public void setIdViaje(String idViaje) {
        this.idViaje = idViaje;
    }

    public Date getFechaViaje() {
        return fechaViaje;
    }

    public void setFechaViaje(Date fechaViaje) {
        this.fechaViaje = fechaViaje;
    }

    public short getTiempoSalida() {
        return tiempoSalida;
    }

    public void setTiempoSalida(short tiempoSalida) {
        this.tiempoSalida = tiempoSalida;
    }

    public UnidadRuta getIdUnidadRuta() {
        return idUnidadRuta;
    }

    public void setIdUnidadRuta(UnidadRuta idUnidadRuta) {
        this.idUnidadRuta = idUnidadRuta;
    }

    @XmlTransient
    public Collection<Tiempos> getTiemposCollection() {
        return tiemposCollection;
    }

    public void setTiemposCollection(Collection<Tiempos> tiemposCollection) {
        this.tiemposCollection = tiemposCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idViaje != null ? idViaje.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Viajes)) {
            return false;
        }
        Viajes other = (Viajes) object;
        if ((this.idViaje == null && other.idViaje != null) || (this.idViaje != null && !this.idViaje.equals(other.idViaje))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitys.Viajes[ idViaje=" + idViaje + " ]";
    }
    
}
