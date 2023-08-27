package test;

import static org.junit.Assert.assertThrows;
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
import logica_Controladores.IControladorOferta;
import logica_Entidades.OfertaLaboral;
import logica_Entidades.KeyWord;
import logica_Manejadores.IManejadorOferta;
import utils.Fabrica;

class controladorOfertaTest {

	private static IControladorOferta co;
    private static IManejadorOferta mo;
    LocalDate f1 = LocalDate.of(1990, 1, 1);
    LocalTime d2 = LocalTime.of(2023, 8, 6); 
    LocalTime d1 = LocalTime.of(2013, 5, 6); 

    @BeforeAll
    public static void setUpBeforeClass() throws Exception {
        Fabrica f = Fabrica.getInstance();
        co = f.getInOfer();
        mo = f.getInManejadorOferta();
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
	    LocalTime d2 = LocalTime.of(2023, 8, 6); 
	    LocalTime d1 = LocalTime.of(2013, 5, 6); 

	    assertThrows(NombreRepetidoOfertaException.class, () -> {
	    	co.darAltaOferta("Doctor","Cirujano cardio", "La teja", "Montevideo", d2,d1, 1500, 1000, f1);
	    });	
	}
}
