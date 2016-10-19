/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.fsi.rt1.modelo;

import java.io.Serializable;
import java.util.Collection;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Yoiner Esteban Gomez Ayala yoiner.gomez22@gmail.com
 */
@Entity
@Table(name = "configuracion_vuelo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ConfiguracionVuelo.findAll", query = "SELECT c FROM ConfiguracionVuelo c"),
    @NamedQuery(name = "ConfiguracionVuelo.findById", query = "SELECT c FROM ConfiguracionVuelo c WHERE c.id = :id"),
    @NamedQuery(name = "ConfiguracionVuelo.findByNombre", query = "SELECT c FROM ConfiguracionVuelo c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "ConfiguracionVuelo.findByNumeroPilotos", query = "SELECT c FROM ConfiguracionVuelo c WHERE c.numeroPilotos = :numeroPilotos"),
    @NamedQuery(name = "ConfiguracionVuelo.findByNumeroCopilotos", query = "SELECT c FROM ConfiguracionVuelo c WHERE c.numeroCopilotos = :numeroCopilotos"),
    @NamedQuery(name = "ConfiguracionVuelo.findByNumeroAzafatas", query = "SELECT c FROM ConfiguracionVuelo c WHERE c.numeroAzafatas = :numeroAzafatas")})
public class ConfiguracionVuelo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 13)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_pilotos")
    private int numeroPilotos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_copilotos")
    private int numeroCopilotos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_azafatas")
    private int numeroAzafatas;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "configuracionVueloId")
    private Collection<TipoAvion> tipoAvionCollection;

    public ConfiguracionVuelo() {
    }

    public ConfiguracionVuelo(Integer id) {
        this.id = id;
    }

    public ConfiguracionVuelo(Integer id, String nombre, int numeroPilotos, int numeroCopilotos, int numeroAzafatas) {
        this.id = id;
        this.nombre = nombre;
        this.numeroPilotos = numeroPilotos;
        this.numeroCopilotos = numeroCopilotos;
        this.numeroAzafatas = numeroAzafatas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumeroPilotos() {
        return numeroPilotos;
    }

    public void setNumeroPilotos(int numeroPilotos) {
        this.numeroPilotos = numeroPilotos;
    }

    public int getNumeroCopilotos() {
        return numeroCopilotos;
    }

    public void setNumeroCopilotos(int numeroCopilotos) {
        this.numeroCopilotos = numeroCopilotos;
    }

    public int getNumeroAzafatas() {
        return numeroAzafatas;
    }

    public void setNumeroAzafatas(int numeroAzafatas) {
        this.numeroAzafatas = numeroAzafatas;
    }

    @XmlTransient
    public Collection<TipoAvion> getTipoAvionCollection() {
        return tipoAvionCollection;
    }

    public void setTipoAvionCollection(Collection<TipoAvion> tipoAvionCollection) {
        this.tipoAvionCollection = tipoAvionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConfiguracionVuelo)) {
            return false;
        }
        ConfiguracionVuelo other = (ConfiguracionVuelo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.udea.fsi.rt1.modelo.ConfiguracionVuelo[ id=" + id + " ]";
    }
    
}
