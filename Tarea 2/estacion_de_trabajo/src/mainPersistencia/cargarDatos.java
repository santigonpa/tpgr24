package mainPersistencia;

import java.util.ArrayList;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import logica_entidades.OfertaLaboral;
import utils.Fabrica;
import logica_manejadores.IManejadorOferta;

public class cargarDatos {
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
	EntityTransaction transaction = enM.getTransaction();
	transaction.begin();

	//Crear e insertar ofertas finalizadas y otros datos
	
		ArrayList<OfertaLaboral> ofertasFin = imo.getOfertasFinalizadas();
		//OfertaLaboral oferta1 = new OfertaLaboral();
		// Configurar oferta1 con los datos necesarios
		for (OfertaLaboral oferPer : ofertasFin){
			enM.persist(oferPer);
		}
		// Crear e insertar más objetos según sea necesario
	
		// Confirmar la transacción
		transaction.commit();
		
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