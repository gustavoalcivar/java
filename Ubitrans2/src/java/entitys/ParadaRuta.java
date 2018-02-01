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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "parada_ruta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ParadaRuta.findAll", query = "SELECT p FROM ParadaRuta p"),
    @NamedQuery(name = "ParadaRuta.findByIdParadaRuta", query = "SELECT p FROM ParadaRuta p WHERE p.idParadaRuta = :idParadaRuta"),
    @NamedQuery(name = "ParadaRuta.findByNumeroDeParada", query = "SELECT p FROM ParadaRuta p WHERE p.numeroDeParada = :numeroDeParada")})
public class ParadaRuta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "id_parada_ruta")
    private String idParadaRuta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_de_parada")
    private short numeroDeParada;
    @JoinColumn(name = "id_ruta", referencedColumnName = "id_ruta")
    @ManyToOne(optional = false)
    private Rutas idRuta;
    @JoinColumn(name = "id_parada", referencedColumnName = "id_parada")
    @ManyToOne(optional = false)
    private Paradas idParada;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idParadaRuta")
    private Collection<Tiempos> tiemposCollection;

    public ParadaRuta() {
    }

    public ParadaRuta(String idParadaRuta) {
        this.idParadaRuta = idParadaRuta;
    }

    public ParadaRuta(String idParadaRuta, short numeroDeParada) {
        this.idParadaRuta = idParadaRuta;
        this.numeroDeParada = numeroDeParada;
    }

    public String getIdParadaRuta() {
        return idParadaRuta;
    }

    public void setIdParadaRuta(String idParadaRuta) {
        this.idParadaRuta = idParadaRuta;
    }

    public short getNumeroDeParada() {
        return numeroDeParada;
    }

    public void setNumeroDeParada(short numeroDeParada) {
        this.numeroDeParada = numeroDeParada;
    }

    public Rutas getIdRuta() {
        return idRuta;
    }

    public void setIdRuta(Rutas idRuta) {
        this.idRuta = idRuta;
    }

    public Paradas getIdParada() {
        return idParada;
    }

    public void setIdParada(Paradas idParada) {
        this.idParada = idParada;
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
        hash += (idParadaRuta != null ? idParadaRuta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ParadaRuta)) {
            return false;
        }
        ParadaRuta other = (ParadaRuta) object;
        if ((this.idParadaRuta == null && other.idParadaRuta != null) || (this.idParadaRuta != null && !this.idParadaRuta.equals(other.idParadaRuta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitys.ParadaRuta[ idParadaRuta=" + idParadaRuta + " ]";
    }
    
}
