/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entitys;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author GUSTAVO
 */
@Entity
@Table(name = "tiempos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tiempos.findAll", query = "SELECT t FROM Tiempos t"),
    @NamedQuery(name = "Tiempos.findByIdTiempo", query = "SELECT t FROM Tiempos t WHERE t.idTiempo = :idTiempo"),
    @NamedQuery(name = "Tiempos.findByTiempo", query = "SELECT t FROM Tiempos t WHERE t.tiempo = :tiempo")})
public class Tiempos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "id_tiempo")
    private String idTiempo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tiempo")
    private short tiempo;
    @JoinColumn(name = "id_viaje", referencedColumnName = "id_viaje")
    @ManyToOne(optional = false)
    private Viajes idViaje;
    @JoinColumn(name = "id_parada_ruta", referencedColumnName = "id_parada_ruta")
    @ManyToOne(optional = false)
    private ParadaRuta idParadaRuta;

    public Tiempos() {
    }

    public Tiempos(String idTiempo) {
        this.idTiempo = idTiempo;
    }

    public Tiempos(String idTiempo, short tiempo) {
        this.idTiempo = idTiempo;
        this.tiempo = tiempo;
    }

    public String getIdTiempo() {
        return idTiempo;
    }

    public void setIdTiempo(String idTiempo) {
        this.idTiempo = idTiempo;
    }

    public short getTiempo() {
        return tiempo;
    }

    public void setTiempo(short tiempo) {
        this.tiempo = tiempo;
    }

    public Viajes getIdViaje() {
        return idViaje;
    }

    public void setIdViaje(Viajes idViaje) {
        this.idViaje = idViaje;
    }

    public ParadaRuta getIdParadaRuta() {
        return idParadaRuta;
    }

    public void setIdParadaRuta(ParadaRuta idParadaRuta) {
        this.idParadaRuta = idParadaRuta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTiempo != null ? idTiempo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tiempos)) {
            return false;
        }
        Tiempos other = (Tiempos) object;
        if ((this.idTiempo == null && other.idTiempo != null) || (this.idTiempo != null && !this.idTiempo.equals(other.idTiempo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitys.Tiempos[ idTiempo=" + idTiempo + " ]";
    }
    
}
