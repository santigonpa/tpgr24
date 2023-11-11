package mainPersistencia;

import java.time.LocalDate;

import java.time.LocalTime;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import logica_entidades.Empresa;
import logica_entidades.OfertaLaboral;
import logica_entidades.Postulacion;
import logica_entidades.Postulante;
import logica_entidades.Usuario;

public class cargarDatos {

	public static void main(String[] args) {
//En algún lugar de tu aplicación (puede ser un inicializador, un servlet, etc.)
EntityManagerFactory emf = Persistence.createEntityManagerFactory("TrabajoUYJPA");
EntityManager em = emf.createEntityManager();

//Iniciar transacción
EntityTransaction transaction = em.getTransaction();
transaction.begin();

//Crear e insertar ofertas finalizadas y otros datos
try {
 OfertaLaboral oferta1 = new OfertaLaboral();
 // Configurar oferta1 con los datos necesarios
 em.persist(oferta1);

 // Crear e insertar más objetos según sea necesario

 // Confirmar la transacción
 transaction.commit();
} catch (Exception e) {
 // Manejar excepciones, hacer rollback si es necesario
 if (transaction.isActive()) {
     transaction.rollback();
 }
} finally {
 // Cerrar EntityManager
 em.close();
 emf.close();
}
}
}