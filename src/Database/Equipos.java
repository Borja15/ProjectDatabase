/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Borja Andrades
 */
@Entity
@Table(name = "equipos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Equipos.findAll", query = "SELECT e FROM Equipos e"),
    @NamedQuery(name = "Equipos.findByIdEquipo", query = "SELECT e FROM Equipos e WHERE e.idEquipo = :idEquipo"),
    @NamedQuery(name = "Equipos.findByEquipo", query = "SELECT e FROM Equipos e WHERE e.equipo = :equipo"),
    @NamedQuery(name = "Equipos.findByEntrenador", query = "SELECT e FROM Equipos e WHERE e.entrenador = :entrenador"),
    @NamedQuery(name = "Equipos.findByPresidente", query = "SELECT e FROM Equipos e WHERE e.presidente = :presidente"),
    @NamedQuery(name = "Equipos.findByCiudad", query = "SELECT e FROM Equipos e WHERE e.ciudad = :ciudad"),
    @NamedQuery(name = "Equipos.findByA\u00f1o", query = "SELECT e FROM Equipos e WHERE e.a\u00f1o = :a\u00f1o"),
    @NamedQuery(name = "Equipos.findByEstadio", query = "SELECT e FROM Equipos e WHERE e.estadio = :estadio"),
    @NamedQuery(name = "Equipos.findByA\u00f1osPrimera", query = "SELECT e FROM Equipos e WHERE e.a\u00f1osPrimera = :a\u00f1osPrimera"),
    @NamedQuery(name = "Equipos.findByA\u00f1osSegunda", query = "SELECT e FROM Equipos e WHERE e.a\u00f1osSegunda = :a\u00f1osSegunda")})
public class Equipos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdEquipo")
    private Integer idEquipo;
    @Basic(optional = false)
    @Column(name = "Equipo")
    private String equipo;
    @Column(name = "Entrenador")
    private String entrenador;
    @Column(name = "Presidente")
    private String presidente;
    @Column(name = "Ciudad")
    private String ciudad;
    @Column(name = "A\u00f1o")
    @Temporal(TemporalType.DATE)
    private Date año;
    @Column(name = "Estadio")
    private String estadio;
    @Column(name = "A\u00f1osPrimera")
    private Short añosPrimera;
    @Column(name = "A\u00f1osSegunda")
    private Short añosSegunda;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEquipo")
    private Collection<Palmares> palmaresCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEquipo")
    private Collection<Jugadores> jugadoresCollection;

    public Equipos() {
    }

    public Equipos(Integer idEquipo) {
        this.idEquipo = idEquipo;
    }

    public Equipos(Integer idEquipo, String equipo) {
        this.idEquipo = idEquipo;
        this.equipo = equipo;
    }

    public Integer getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(Integer idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public String getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(String entrenador) {
        this.entrenador = entrenador;
    }

    public String getPresidente() {
        return presidente;
    }

    public void setPresidente(String presidente) {
        this.presidente = presidente;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Date getAño() {
        return año;
    }

    public void setAño(Date año) {
        this.año = año;
    }

    public String getEstadio() {
        return estadio;
    }

    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }

    public Short getAñosPrimera() {
        return añosPrimera;
    }

    public void setAñosPrimera(Short añosPrimera) {
        this.añosPrimera = añosPrimera;
    }

    public Short getAñosSegunda() {
        return añosSegunda;
    }

    public void setAñosSegunda(Short añosSegunda) {
        this.añosSegunda = añosSegunda;
    }

    @XmlTransient
    public Collection<Palmares> getPalmaresCollection() {
        return palmaresCollection;
    }

    public void setPalmaresCollection(Collection<Palmares> palmaresCollection) {
        this.palmaresCollection = palmaresCollection;
    }

    @XmlTransient
    public Collection<Jugadores> getJugadoresCollection() {
        return jugadoresCollection;
    }

    public void setJugadoresCollection(Collection<Jugadores> jugadoresCollection) {
        this.jugadoresCollection = jugadoresCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEquipo != null ? idEquipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Equipos)) {
            return false;
        }
        Equipos other = (Equipos) object;
        if ((this.idEquipo == null && other.idEquipo != null) || (this.idEquipo != null && !this.idEquipo.equals(other.idEquipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Database.Equipos[ idEquipo=" + idEquipo + " ]";
    }
    
}
