/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ivanb
 */
@Entity
@Table(name = "participante", catalog = "maraton", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Participante.findAll", query = "SELECT p FROM Participante p"),
    @NamedQuery(name = "Participante.findById", query = "SELECT p FROM Participante p WHERE p.id = :id"),
    @NamedQuery(name = "Participante.findByNombre", query = "SELECT p FROM Participante p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Participante.findBySexo", query = "SELECT p FROM Participante p WHERE p.sexo = :sexo"),
    @NamedQuery(name = "Participante.findByDistancia", query = "SELECT p FROM Participante p WHERE p.distancia = :distancia"),
    @NamedQuery(name = "Participante.findByCategoria", query = "SELECT p FROM Participante p WHERE p.categoria = :categoria")})
public class Participante implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "sexo", nullable = false, length = 10)
    private String sexo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "distancia", nullable = false)
    private int distancia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "categoria", nullable = false, length = 50)
    private String categoria;

    public Participante() {
    }

    public Participante(Integer id) {
        this.id = id;
    }

    public Participante(Integer id, String nombre, String sexo, int distancia, String categoria) {
        this.id = id;
        this.nombre = nombre;
        this.sexo = sexo;
        this.distancia = distancia;
        this.categoria = categoria;
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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
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
        if (!(object instanceof Participante)) {
            return false;
        }
        Participante other = (Participante) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dominio.Participante[ id=" + id + " ]";
    }
    
}
