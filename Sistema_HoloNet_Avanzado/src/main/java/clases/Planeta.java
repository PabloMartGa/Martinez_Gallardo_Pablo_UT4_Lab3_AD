/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author DAM2P
 */
import jakarta.persistence.*;
 
@Entity
@Table(name = "planetas")
public class Planeta {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "planeta_id")
    private Integer planetaId;
 
    @Column(name = "nombre", nullable = false, unique = true, length = 100)
    private String nombre;
 
    @Column(name = "afiliacion", length = 50)
    private String afiliacion;
 
    public Planeta() {
    }
 
    public Planeta(String nombre, String afiliacion) {
        this.nombre = nombre;
        this.afiliacion = afiliacion;
    }
 
    public Integer getPlanetaId() { return planetaId; }
    public void setPlanetaId(Integer planetaId) { this.planetaId = planetaId; }
 
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
 
    public String getAfiliacion() { return afiliacion; }
    public void setAfiliacion(String afiliacion) { this.afiliacion = afiliacion; }
 
    @Override
    public String toString() {
        return "Planeta{id=" + planetaId + ", nombre='" + nombre + "', afiliacion='" + afiliacion + "'}";
    }
}
