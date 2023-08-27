package test;

//import static org.junit.Assert.assertThrows;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;


import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import excepciones.EmailYaExisteException;
import excepciones.NicknameYaExisteException;
import excepciones.NombreRepetidoOfertaException;
import excepciones.NombreTipoPubliYaExisteException;
import logica_Controladores.IControladorOferta;
import logica_Entidades.OfertaLaboral;
import logica_Entidades.TipoPublicacion;
import logica_Entidades.KeyWord;
import logica_Manejadores.IManejadorOferta;
import logica_Manejadores.IManejadorPyT;
import logica_Manejadores.IManejadorUsuario;
import utils.Fabrica;

class controladorOfertaTest {

	private static IControladorOferta co;
    private static IManejadorOferta mo;
    private static IManejadorUsuario mu;
    private static IManejadorPyT mpyt;
    LocalDate f1 = LocalDate.of(1990, 1, 1);
    LocalTime d2 = LocalTime.of(8, 0); 
    LocalTime d1 = LocalTime.of(17,0); 

    @BeforeAll
    public static void setUpBeforeClass() throws Exception {
        Fabrica f = Fabrica.getInstance();
        co = f.getInOfer();
        mo = f.getInManejadorOferta();
        mu = f.getInManejadorUsuario();
        mpyt = f.getInManejadorPyT();
       
    }

    @Test
    void registroOfertaLaboralExitoso() throws NombreRepetidoOfertaException {
        String nombre = "Developer";
        String ciudad = "Montevideo";
        String descripcion = "Developer jr frontend";
        int costoDeOfertaLaboral = 150;
        LocalTime horaFin = d1;
        LocalTime horaInicio = d2;
        String departamento = "Montevideo";
        int remuneracion = 2500;
        LocalDate fechaDeAlta = f1;
        Set<KeyWord> palabrasClave = new HashSet<>();

        
            co.darAltaOferta(nombre,descripcion,ciudad,departamento,horaInicio,horaFin,remuneracion,costoDeOfertaLaboral,fechaDeAlta);
            OfertaLaboral o = mo.obtenerOferta(nombre);

            assertEquals(nombre, o.getNombreOferta());
            assertEquals(descripcion, o.getDescripcion());
            assertEquals(ciudad, o.getCiudad());
            assertEquals(departamento, o.getDepartamento());
            assertEquals(horaFin, o.getHoraFin());
            assertEquals(horaInicio, o.getHoraInicio());
            assertEquals(remuneracion, o.getRemuneracion());
            assertEquals(fechaDeAlta, o.getFecha());
            assertEquals(costoDeOfertaLaboral, o.getCosto());
       }
    
    
	@Test
	void OfertaRepetida() throws NombreRepetidoOfertaException{
	    LocalDate f1 = LocalDate.of(1990, 1, 1);
	    LocalTime d2 = LocalTime.of(14, 0); 
	    LocalTime d1 = LocalTime.of(19, 0); 

	    co.darAltaOferta("Doctor","Cirujano cardio", "La teja", "Montevideo", d2,d1, 1500, 1000, f1);
	    
	    assertThrows(NombreRepetidoOfertaException.class, () -> {
	    	co.darAltaOferta("Doctor","Cirujano cardio", "La teja", "Montevideo", d2,d1, 1500, 1000, f1);
	    });	
	}


	@Test
	void altaDeTipoDePubliDeOferOk() throws NombreTipoPubliYaExisteException{
		LocalDate fecha = LocalDate.of(1990, 1, 1);;
		co.altaDeTipoDePubliDeOferLab("Tipo oferta", "Descripcion prueba", 1, 10, 100, fecha);
		TipoPublicacion publi = mpyt.obtenerTipoPublicacion("Tipo oferta");
		assertEquals("Tipo oferta", publi.getNombre());
		assertEquals("Descripcion prueba", publi.getDescripcion());
		assertEquals(1, publi.getExposicion());
		assertEquals(100, publi.getDuracion());
		assertEquals(10, publi.getCosto());
		assertEquals(fecha, publi.getFecha());
	}
	
	@Test
	void tipoDePubliRepetida() throws NombreTipoPubliYaExisteException{
		LocalDate fecha = LocalDate.of(1990, 1, 1);
		co.altaDeTipoDePubliDeOferLab("Tipo oferta", "Descripcion prueba", 1, 10, 100, fecha);
		
		assertThrows(NombreTipoPubliYaExisteException.class, () -> {
			co.altaDeTipoDePubliDeOferLab("Tipo oferta", "Descripcion prueba", 1, 10, 100, fecha);
		});	
	}
}