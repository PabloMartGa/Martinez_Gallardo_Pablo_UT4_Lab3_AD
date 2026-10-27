/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistema_holonet_avanzado;

import clases.Nave;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author DAM2P
 */
public class HolonetControl {
    
    public List<Nave> obtenerNavesPorBandoPlaneta(Session session, String bando) {
        String hql = "SELECT n FROM Nave n "
                   + "INNER JOIN n.planetaOrigen p "
                   + "WHERE p.afiliacion = :bando "
                   + "AND n.estadoSistema <> 'Mantenimiento'";
        return session.createQuery(hql, Nave.class)
                .setParameter("bando", bando)
                .getResultList();
    }
 
    
    public List<Nave> obtenerFlotaCriticaConPlaneta(Session session) {
        String hql = "SELECT n FROM Nave n "
                   + "LEFT JOIN FETCH n.planetaOrigen "
                   + "WHERE n.estadoSistema = 'Critico'";
        return session.createQuery(hql, Nave.class).getResultList();
    }
 
    
    
    public List<Object[]> obtenerReportePlanetasAsignados(Session session) {
        String hql = "SELECT n.nombre, p.nombre FROM Nave n "
                   + "LEFT JOIN n.planetaOrigen p";
        return session.createQuery(hql, Object[].class).getResultList();
    }
}
