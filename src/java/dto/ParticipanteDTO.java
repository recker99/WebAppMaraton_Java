/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.Serializable;

/**
 *
 * @author ivanb
 */
public class ParticipanteDTO implements Serializable {
    private int id, distancia;
    private String nombre, sexo, categoria;
    
    public ParticipanteDTO() {
    }

    public ParticipanteDTO(int id, int distancia, String nombre, String sexo, String categoria) {
        this.id = id;
        this.distancia = distancia;
        this.nombre = nombre;
        this.sexo = sexo;
        this.categoria = categoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "ParticipanteDTO{" + "id=" + id + ", distancia=" + distancia + ", nombre=" + nombre + ", sexo=" + sexo + ", categoria=" + categoria + '}';
    }
    
}
