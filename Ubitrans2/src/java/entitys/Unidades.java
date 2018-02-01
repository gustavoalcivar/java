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
@Table(name = "unidades")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Unidades.findAll", query = "SELECT u FROM Unidades u"),
    @NamedQuery(name = "Unidades.findByIdUnidad", query = "SELECT u FROM Unidades u WHERE u.idUnidad = :idUnidad"),
    @NamedQuery(name = "Unidades.findByPlaca", query = "SELECT u FROM Unidades u WHERE u.placa = :placa"),
    @NamedQuery(name = "Unidades.findByCapacidad", query = "SELECT u FROM Unidades u WHERE u.capacidad = :capacidad"),
    @NamedQuery(name = "Unidades.findByNumeroDeUnidad", query = "SELECT u FROM Unidades u WHERE u.numeroDeUnidad = :numeroDeUnidad")})
public class Unidades implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "id_unidad")
    private String idUnidad;
    @Size(max = 7)
    @Column(name = "placa")
    private String placa;
    @Column(name = "capacidad")
    private Short capacidad;
    @Column(name = "numero_de_unidad")
    private Short numeroDeUnidad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUnidad")
    private Collection<UnidadRuta> unidadRutaCollection;

    public Unidades() {
    }

    public Unidades(String idUnidad) {
        this.idUnidad = idUnidad;
    }

    public String getIdUnidad() {
        return idUnidad;
    }

    public void setIdUnidad(String idUnidad) {
        this.idUnidad = idUnidad;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Short getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Short capacidad) {
        this.capacidad = capacidad;
    }

    public Short getNumeroDeUnidad() {
        return numeroDeUnidad;
    }

    public void setNumeroDeUnidad(Short numeroDeUnidad) {
        this.numeroDeUnidad = numeroDeUnidad;
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
        hash += (idUnidad != null ? idUnidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Unidades)) {
            return false;
        }
        Unidades other = (Unidades) object;
        if ((this.idUnidad == null && other.idUnidad != null) || (this.idUnidad != null && !this.idUnidad.equals(other.idUnidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitys.Unidades[ idUnidad=" + idUnidad + " ]";
    }
    
}
