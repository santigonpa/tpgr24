package test;

import static org.junit.jupiter.api.Assertions.*;

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

class ControladorOfertaTest {

    private static IControladorOferta co;
    private static IManejadorOferta mo;
    LocalDate f1 = LocalDate.of(1990, 1, 1);
    LocalTime d2 = LocalTime.of(12, 0); 
    LocalTime d1 = LocalTime.of(13, 0); 

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
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

        try {
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

        } catch (NombreRepetidoOfertaException e) {
            fail(e.getMessage());
            e.printStackTrace();
        }
    }
    
    
	@Test
	void OfertaRepetida() throws NombreRepetidoOfertaException{
	    LocalDate f1 = LocalDate.of(1990, 1, 1);
	    LocalTime d2 = LocalTime.of(12, 0); 
	    LocalTime d1 = LocalTime.of(13, 0); 
		try {
		co.darAltaOferta("Doctor","Cirujano cardio", "La teja", "Montevideo", d2,d1, 1500, 1000, f1 );
		}catch(NombreRepetidoOfertaException e)  {
			fail(e.getMessage());
			e.printStackTrace();
		}
	}
}
