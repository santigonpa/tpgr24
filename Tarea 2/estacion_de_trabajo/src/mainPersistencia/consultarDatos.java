package mainPersistencia;

import java.util.List;

import jakarta.persistence.TypedQuery;

import org.eclipse.persistence.indirection.IndirectList;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import logica_entidades.Empresa;
import logica_entidades.OfertaLaboral;
import logica_entidades.Postulacion;
import logica_entidades.Postulante;
import logica_entidades.Usuario;

public class consultarDatos{
	public static void main(String[] args) {
        // Crear una instancia de EntityManagerFactory
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TrabajoUYJPA");
        EntityManager em = emf.createEntityManager();

        try {
            // Consultas a la base de datos
            List<OfertaLaboral> ofertas = em.createQuery("SELECT o FROM OfertaLaboral o", OfertaLaboral.class).getResultList();
            for (OfertaLaboral oferta : ofertas) {
                // Procesar y mostrar los datos de cada oferta
                System.out.println(oferta); // Reemplaza esto con el método de impresión adecuado
            }

            // Más consultas según sea necesario...
        } catch (Exception e) {
            e.printStackTrace(); // Manejar las excepciones adecuadamente
        } finally {
            // Cerrar el EntityManager
            em.close();
            emf.close();
        }
    }
}