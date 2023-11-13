package main;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import logica_entidades.OfertaLaboral;

public class consultaDatos {
	    public static void main(String[] args) {
	        // Crear el EntityManager y la EntityManagerFactory
	        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TrabajoUYJPA");
	        EntityManager em = emf.createEntityManager();

	        try {
	            // Iniciar una transacción para la consulta
	            EntityTransaction transaction = em.getTransaction();
	            transaction.begin();

	            // Consulta para obtener todas las ofertas laborales persistidas
	            List<OfertaLaboral> ofertasPersistidas = em.createQuery(
	                    "SELECT o FROM OfertaLaboral o", OfertaLaboral.class)
	                    .getResultList();

	            // Imprimir los resultados
	            System.out.println("Todas las Ofertas Laborales Persistidas:");
	            for (OfertaLaboral oferta : ofertasPersistidas) {
	                System.out.println(oferta.getNombreOferta());
	                System.out.println(oferta.getCiudad());
	            }

	            // Confirmar la transacción
	            transaction.commit();

	        } catch (Exception e) {
	            // Manejar excepciones, hacer rollback si es necesario
	            e.printStackTrace();
	            if (em.getTransaction().isActive()) {
	                em.getTransaction().rollback();
	            }
	        } finally {
	            // Cerrar EntityManager y EntityManagerFactory
	            em.close();
	            emf.close();
	        }
	    }
	}