/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sistema_holonet_avanzado;

import clases.Nave;
import clases.Planeta;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author DAM2P
 */
public class Sistema_HoloNet_Avanzado {

    public static void main(String[] args) {
         
        HolonetControl control = new HolonetControl();
        
        try (SessionFactory factory = new Configuration().configure().buildSessionFactory()){
 
            // ---------- Desafío 1 ----------
            try (Session session = factory.openSession()) {
                String bando = "Imperio";
                System.out.println("=== DESAFÍO 1: Naves del bando '" + bando + "' (sin Mantenimiento) ===");
                List<Nave> naves = control.obtenerNavesPorBandoPlaneta(session, bando);
                if (naves.isEmpty()) {
                    System.out.println("  (sin resultados)");
                }
                for (Nave n : naves) {
                    System.out.printf("  %-28s | %-18s | %-10s | Planeta: %s%n",
                            n.getNombre(), n.getModelo(), n.getEstadoSistema(),
                            n.getPlanetaOrigen().getNombre());
                }
            }
 
            // ---------- Desafío 2 ----------
            List<Nave> flotaCritica;
            try (Session session = factory.openSession()) {
                System.out.println("\n=== DESAFÍO 2: Flota crítica con planeta (FETCH JOIN) ===");
                flotaCritica = control.obtenerFlotaCriticaConPlaneta(session);
            }
            // Sesión ya cerrada: el planeta ya está cargado, no hay LazyInitializationException
            for (Nave n : flotaCritica) {
                Planeta p = n.getPlanetaOrigen();
                System.out.printf("  %-28s | Estado: %-8s | Planeta: %s (%s)%n",
                        n.getNombre(), n.getEstadoSistema(),
                        p != null ? p.getNombre() : "null",
                        p != null ? p.getAfiliacion() : "-");
            }
 
            // ---------- Desafío 3 ----------
            try (Session session = factory.openSession()) {
                System.out.println("\n=== DESAFÍO 3: Reporte de planetas asignados (LEFT JOIN) ===");
                System.out.printf("  %-28s | %s%n", "NAVE", "PLANETA");
                System.out.println("  " + "-".repeat(45));
                for (Object[] fila : control.obtenerReportePlanetasAsignados(session)) {
                    System.out.printf("  %-28s | %s%n", fila[0], fila[1]); // fila[1] puede ser null
                }
            }
        }
    }
}
