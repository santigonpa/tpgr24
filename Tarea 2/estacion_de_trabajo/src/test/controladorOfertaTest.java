package test;

//import static org.junit.Assert.assertThrows;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import excepciones.NombreRepetidoOfertaException;
import excepciones.NombreTipoPubliYaExisteException;
import excepciones.yaExistePostulacionAOfertaException;
import logica_Controladores.IControladorOferta;
import logica_DataTypes.DataKeyWord;
import logica_DataTypes.DataTipoPublicacion;
import logica_Entidades.OfertaLaboral;
import logica_Entidades.TipoPublicacion;
import logica_Manejadores.IManejadorOferta;
import logica_Manejadores.IManejadorPyT;
import logica_cargarDatos.datosDePrueba.cargarDatos;
import utils.Fabrica;

class controladorOfertaTest {

	private static IControladorOferta co;
    private static IManejadorOferta mo;
    private static IManejadorPyT mpyt;
    LocalDate f1 = LocalDate.of(1990, 1, 1);
    LocalTime d2 = LocalTime.of(8, 0); 
    LocalTime d1 = LocalTime.of(17,0); 

    @BeforeAll
    public static void setUpBeforeClass() throws Exception {
        Fabrica f = Fabrica.getInstance();
        co = f.getInOfer();
        mo = f.getInManejadorOferta();
        f.getInManejadorUsuario();
        mpyt = f.getInManejadorPyT();
        cargarDatos cargador = new cargarDatos();
        cargador.cargar();
     
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
        new HashSet<>();

        
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
		co.altaDeTipoDePubliDeOferLab("Tipo oferta dos", "Descripcion prueba", 1, 10, 100, fecha);
		
		assertThrows(NombreTipoPubliYaExisteException.class, () -> {
			co.altaDeTipoDePubliDeOferLab("Tipo oferta dos", "Descripcion prueba", 1, 10, 100, fecha);
		});	
	}
	
	@Test
	void altaDePublicacionDeOferOk() throws NombreRepetidoOfertaException {
		LocalTime hora1 = LocalTime.of(11, 30);
		LocalTime hora2 = LocalTime.of(16, 0);
		LocalDate fecha1 = LocalDate.of(2023, 9, 12);
		Set<String> palabrasClave1 = new HashSet<>();
		Set<DataKeyWord> setdt = mo.getDataKeyWord();
		for(DataKeyWord dtk : setdt) {
			palabrasClave1.add(dtk.getPalabraClave());
		}
		
		co.altaPublicacionOfertaLaboral("EcoTech", "Premium", "Nombre ofer", "Descripcion", hora1, hora2, 50, "San Carlos", "Maldonado", fecha1, palabrasClave1);
		
		OfertaLaboral  publiOfer = mo.obtenerOferta("Nombre ofer");
		assertEquals("EcoTech", publiOfer.getEmpresa().getNickName());
		assertEquals("Premium", publiOfer.getTipoDeOferta().getNombre());
		assertEquals("Nombre ofer", publiOfer.getNombreOferta());
		assertEquals("San Carlos", publiOfer.getCiudad());
		assertEquals("Maldonado", publiOfer.getDepartamento());
		assertEquals(hora1, publiOfer.getHoraInicio());
		assertEquals(hora2, publiOfer.getHoraFin());
		assertEquals(fecha1, publiOfer.getFecha());
		assertEquals(palabrasClave1, publiOfer.getKeyWordsString());
	}
	
	@Test
	void publicacionOfertaRepetida()throws NombreRepetidoOfertaException {
		LocalTime hora1 = LocalTime.of(11, 30);
		LocalTime hora2 = LocalTime.of(16, 0);
		LocalDate fecha1 = LocalDate.of(2023, 9, 12);
		Set<String> palabrasClave1 = new HashSet<>();
		co.altaPublicacionOfertaLaboral("EcoTech", "Premium", "Nombre ofer2", "Descripcion", hora1, hora2, 50, "San Carlos", "Maldonado", fecha1, palabrasClave1);
		
		assertThrows(NombreRepetidoOfertaException.class, () -> {
			co.altaPublicacionOfertaLaboral("EcoTech", "Premium", "Nombre ofer2", "Descripcion", hora1, hora2, 50, "San Carlos", "Maldonado", fecha1, palabrasClave1);
		});
	}
	
	@Test
	void agregoPostulacion() throws yaExistePostulacionAOfertaException{
		LocalDate fecha1 = LocalDate.of(2023, 9, 12);
		co.agregarPostulacion("lgarcia","Soporte Tecnico","hombre","arania",fecha1);
	}
	
	@Test 
	void agregoPostulacionRepetida() throws yaExistePostulacionAOfertaException{
		LocalDate fecha1 = LocalDate.of(2023, 9, 12);
		assertThrows(yaExistePostulacionAOfertaException.class, () -> {
			co.agregarPostulacion("lgarcia","Soporte Tecnico","hombre","arania",fecha1);
		});
	}
	
	@Test
	void testeoDeDataPubli() {
		Set<DataTipoPublicacion> setDtPubli = mpyt.getDataTipoPublicacion();
		String Publi = mpyt.obtenerTipoPublicacion("Premium").getNombre();
		String comparacion = null;
		for(DataTipoPublicacion dtp : setDtPubli) {
			if("Premium" == dtp.getNombre()) {
				comparacion = dtp.getNombre();
				break;
			}
		}
		assertEquals(Publi,comparacion);
	}
	
}