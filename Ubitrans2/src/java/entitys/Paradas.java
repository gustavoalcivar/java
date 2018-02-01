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
@Table(name = "paradas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Paradas.findAll", query = "SELECT p FROM Paradas p"),
    @NamedQuery(name = "Paradas.findByIdParada", query = "SELECT p FROM Paradas p WHERE p.idParada = :idParada"),
    @NamedQuery(name = "Paradas.findByNombreParada", query = "SELECT p FROM Paradas p WHERE p.nombreParada = :nombreParada"),
    @NamedQuery(name = "Paradas.findByDistancia", query = "SELECT p FROM Paradas p WHERE p.distancia = :distancia"),
    @NamedQuery(name = "Paradas.findByDescripcionParada", query = "SELECT p FROM Paradas p WHERE p.descripcionParada = :descripcionParada")})
public class Paradas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "id_parada")
    private String idParada;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nombre_parada")
    private String nombreParada;
    @Basic(optional = false)
    @NotNull
    @Column(name = "distancia")
    private int distancia;
    @Size(max = 50)
    @Column(name = "descripcion_parada")
    private String descripcionParada;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idParada")
    private Collection<ParadaRuta> paradaRutaCollection;

    public Paradas() {
    }

    public Paradas(String idParada) {
        this.idParada = idParada;
    }

    public Paradas(String idParada, String nombreParada, int distancia) {
        this.idParada = idParada;
        this.nombreParada = nombreParada;
        this.distancia = distancia;
    }

    public String getIdParada() {
        return idParada;
    }

    public void setIdParada(String idParada) {
        this.idParada = idParada;
    }

    public String getNombreParada() {
        return nombreParada;
    }

    public void setNombreParada(String nombreParada) {
        this.nombreParada = nombreParada;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public String getDescripcionParada() {
        return descripcionParada;
    }

    public void setDescripcionParada(String descripcionParada) {
        this.descripcionParada = descripcionParada;
    }

    @XmlTransient
    public Collection<ParadaRuta> getParadaRutaCollection() {
        return paradaRutaCollection;
    }

    public void setParadaRutaCollection(Collection<ParadaRuta> paradaRutaCollection) {
        this.paradaRutaCollection = paradaRutaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idParada != null ? idParada.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paradas)) {
            return false;
        }
        Paradas other = (Paradas) object;
        if ((this.idParada == null && other.idParada != null) || (this.idParada != null && !this.idParada.equals(other.idParada))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitys.Paradas[ idParada=" + idParada + " ]";
    }
    
}
