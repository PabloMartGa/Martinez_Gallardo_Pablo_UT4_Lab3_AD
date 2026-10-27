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
@Table(name = "naves")
public class Nave {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nave_id")
    private Integer naveId;
 
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;
 
    @Column(name = "modelo", nullable = false, length = 50)
    private String modelo;
 
    @Column(name = "estado_sistema", nullable = false, length = 20)
    private String estadoSistema;
 
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "planeta_origen_id")
    private Planeta planetaOrigen;
 
    public Nave() {
    }
 
    public Nave(String nombre, String modelo, String estadoSistema, Planeta planetaOrigen) {
        this.nombre = nombre;
        this.modelo = modelo;
        this.estadoSistema = estadoSistema;
        this.planetaOrigen = planetaOrigen;
    }
 
    public Integer getNaveId() { return naveId; }
    public void setNaveId(Integer naveId) { this.naveId = naveId; }
 
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
 
    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }
 
    public String getEstadoSistema() { return estadoSistema; }
    public void setEstadoSistema(String estadoSistema) { this.estadoSistema = estadoSistema; }
 
    public Planeta getPlanetaOrigen() { return planetaOrigen; }
    public void setPlanetaOrigen(Planeta planetaOrigen) { this.planetaOrigen = planetaOrigen; }
 
    // Importante: no se incluye planetaOrigen en toString() para no disparar la carga perezosa.
    @Override
    public String toString() {
        return "Nave{id=" + naveId + ", nombre='" + nombre + "', modelo='" + modelo
                + "', estado='" + estadoSistema + "'}";
    }
}
