/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Borja Andrades
 */
@Entity
@Table(name = "palmares")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Palmares.findAll", query = "SELECT p FROM Palmares p"),
    @NamedQuery(name = "Palmares.findByIdPalmares", query = "SELECT p FROM Palmares p WHERE p.idPalmares = :idPalmares"),
    @NamedQuery(name = "Palmares.findByEquipo", query = "SELECT p FROM Palmares p WHERE p.equipo = :equipo"),
    @NamedQuery(name = "Palmares.findByLiga", query = "SELECT p FROM Palmares p WHERE p.liga = :liga"),
    @NamedQuery(name = "Palmares.findByCopaRey", query = "SELECT p FROM Palmares p WHERE p.copaRey = :copaRey"),
    @NamedQuery(name = "Palmares.findByChampions", query = "SELECT p FROM Palmares p WHERE p.champions = :champions"),
    @NamedQuery(name = "Palmares.findBySupEspa\u00f1a", query = "SELECT p FROM Palmares p WHERE p.supEspa\u00f1a = :supEspa\u00f1a"),
    @NamedQuery(name = "Palmares.findBySupEuropa", query = "SELECT p FROM Palmares p WHERE p.supEuropa = :supEuropa"),
    @NamedQuery(name = "Palmares.findByEuropaLiga", query = "SELECT p FROM Palmares p WHERE p.europaLiga = :europaLiga")})
public class Palmares implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdPalmares")
    private Integer idPalmares;
    @Basic(optional = false)
    @Column(name = "Equipo")
    private String equipo;
    @Column(name = "Liga")
    private Short liga;
    @Column(name = "CopaRey")
    private Short copaRey;
    @Column(name = "Champions")
    private Short champions;
    @Column(name = "SupEspa\u00f1a")
    private Short supEspaña;
    @Column(name = "SupEuropa")
    private Short supEuropa;
    @Column(name = "EuropaLiga")
    private Short europaLiga;
    @JoinColumn(name = "IdEquipo", referencedColumnName = "IdEquipo")
    @ManyToOne(optional = false)
    private Equipos idEquipo;

    public Palmares() {
    }

    public Palmares(Integer idPalmares) {
        this.idPalmares = idPalmares;
    }

    public Palmares(Integer idPalmares, String equipo) {
        this.idPalmares = idPalmares;
        this.equipo = equipo;
    }

    public Integer getIdPalmares() {
        return idPalmares;
    }

    public void setIdPalmares(Integer idPalmares) {
        this.idPalmares = idPalmares;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public Short getLiga() {
        return liga;
    }

    public void setLiga(Short liga) {
        this.liga = liga;
    }

    public Short getCopaRey() {
        return copaRey;
    }

    public void setCopaRey(Short copaRey) {
        this.copaRey = copaRey;
    }

    public Short getChampions() {
        return champions;
    }

    public void setChampions(Short champions) {
        this.champions = champions;
    }

    public Short getSupEspaña() {
        return supEspaña;
    }

    public void setSupEspaña(Short supEspaña) {
        this.supEspaña = supEspaña;
    }

    public Short getSupEuropa() {
        return supEuropa;
    }

    public void setSupEuropa(Short supEuropa) {
        this.supEuropa = supEuropa;
    }

    public Short getEuropaLiga() {
        return europaLiga;
    }

    public void setEuropaLiga(Short europaLiga) {
        this.europaLiga = europaLiga;
    }

    public Equipos getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(Equipos idEquipo) {
        this.idEquipo = idEquipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPalmares != null ? idPalmares.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Palmares)) {
            return false;
        }
        Palmares other = (Palmares) object;
        if ((this.idPalmares == null && other.idPalmares != null) || (this.idPalmares != null && !this.idPalmares.equals(other.idPalmares))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Database.Palmares[ idPalmares=" + idPalmares + " ]";
    }
    
}
