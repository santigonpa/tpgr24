package main;

import java.util.ArrayList;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import logica_entidades.Empresa;
import logica_entidades.OfertaLaboral;
import logica_entidades.Postulacion;
import utils.Fabrica;
import logica_manejadores.IManejadorOferta;

public class datosJPA {
	private static Fabrica fabrica = Fabrica.getInstance();
	private static IManejadorOferta imo = fabrica.getInManejadorOferta();
	
	public static void main(String[] args) {
		EntityManagerFactory emf = null;
		EntityManager enM = null;
		try {	
		//En algún lugar de tu aplicación (puede ser un inicializador, un servlet, etc.)
		emf = Persistence.createEntityManagerFactory("TrabajoUYJPA");
		enM = emf.createEntityManager();
		
		//Iniciar transacción
		
		OfertaLaboral o5 = imo.obtenerOferta("Content Manager");
		EntityTransaction tx = enM.getTransaction();
		tx.begin();
		enM.persist(o5);
		Empresa emp = o5.getEmpresa();
		enM.persist(emp);
		ArrayList<Postulacion> post = o5.getPostulaciones();
		for(Postulacion postulacion : post){
			enM.persist(postulacion.getPostulante());
			enM.persist(postulacion);
		}
		tx.commit();
		System.out.println("Se cargaron los datos correctamente");

		 
			} catch (Exception e) {
				e.printStackTrace();
				enM.getTransaction().rollback();
			} finally {
				// Cerrar EntityManager
				enM.close();
				emf.close();
				}
		}
}