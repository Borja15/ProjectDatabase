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
@Table(name = "jugadores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Jugadores.findAll", query = "SELECT j FROM Jugadores j"),
    @NamedQuery(name = "Jugadores.findByIdJugador", query = "SELECT j FROM Jugadores j WHERE j.idJugador = :idJugador"),
    @NamedQuery(name = "Jugadores.findByNombre", query = "SELECT j FROM Jugadores j WHERE j.nombre = :nombre"),
    @NamedQuery(name = "Jugadores.findByApellidos", query = "SELECT j FROM Jugadores j WHERE j.apellidos = :apellidos"),
    @NamedQuery(name = "Jugadores.findByApodo", query = "SELECT j FROM Jugadores j WHERE j.apodo = :apodo"),
    @NamedQuery(name = "Jugadores.findByEdad", query = "SELECT j FROM Jugadores j WHERE j.edad = :edad"),
    @NamedQuery(name = "Jugadores.findByGoles", query = "SELECT j FROM Jugadores j WHERE j.goles = :goles"),
    @NamedQuery(name = "Jugadores.findByEquipo", query = "SELECT j FROM Jugadores j WHERE j.equipo = :equipo"),
    @NamedQuery(name = "Jugadores.findBySancionado", query = "SELECT j FROM Jugadores j WHERE j.sancionado = :sancionado")})
public class Jugadores implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdJugador")
    private Integer idJugador;
    @Basic(optional = false)
    @Column(name = "Nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "Apellidos")
    private String apellidos;
    @Column(name = "Apodo")
    private String apodo;
    @Column(name = "Edad")
    private Short edad;
    @Column(name = "Goles")
    private Short goles;
    @Basic(optional = false)
    @Column(name = "Equipo")
    private String equipo;
    @Column(name = "Sancionado")
    private Boolean sancionado;
    @JoinColumn(name = "IdEquipo", referencedColumnName = "IdEquipo")
    @ManyToOne(optional = false)
    private Equipos idEquipo;

    public Jugadores() {
    }

    public Jugadores(Integer idJugador) {
        this.idJugador = idJugador;
    }

    public Jugadores(Integer idJugador, String nombre, String apellidos, String equipo) {
        this.idJugador = idJugador;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.equipo = equipo;
    }

    public Integer getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(Integer idJugador) {
        this.idJugador = idJugador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getApodo() {
        return apodo;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }

    public Short getEdad() {
        return edad;
    }

    public void setEdad(Short edad) {
        this.edad = edad;
    }

    public Short getGoles() {
        return goles;
    }

    public void setGoles(Short goles) {
        this.goles = goles;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public Boolean getSancionado() {
        return sancionado;
    }

    public void setSancionado(Boolean sancionado) {
        this.sancionado = sancionado;
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
        hash += (idJugador != null ? idJugador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Jugadores)) {
            return false;
        }
        Jugadores other = (Jugadores) object;
        if ((this.idJugador == null && other.idJugador != null) || (this.idJugador != null && !this.idJugador.equals(other.idJugador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Database.Jugadores[ idJugador=" + idJugador + " ]";
    }
    
}
