package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

//import static org.junit.Assert.assertThrows;

import static org.junit.jupiter.api.Assertions.assertThrows;


import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import excepciones.NombrePaqueteYaExiste;
import excepciones.NombreRepetidoOfertaException;
import excepciones.NombreTipoPubliYaExisteException;
import excepciones.noExistePublicacionException;
import excepciones.noExisteTipoPubli;
import excepciones.yaExistePostulacionAOfertaException;
import logica_cargar_datos.datos_de_prueba.cargarDatos;
import logica_controladores.IControladorOferta;
import logica_controladores.IControladorUsuario;
import logica_datatypes.DataCompraPaquete;
import logica_datatypes.DataEmpresa;
import logica_datatypes.DataKeyWord;
import logica_datatypes.DataOferta;
import logica_datatypes.DataPaquete;
import logica_datatypes.DataPostulacion;
import logica_datatypes.DataPostulante;
import logica_datatypes.DataTipoPublicacion;
import logica_entidades.CompraPaquete;
import logica_entidades.Empresa;
import logica_entidades.OfertaLaboral;
import logica_entidades.Paquete;
import logica_entidades.Postulacion;
import logica_entidades.Postulante;
import logica_entidades.TipoPublicacion;
import logica_entidades.Usuario;
import logica_entidades.OfertaLaboral.EstadoOferta;
import logica_manejadores.IManejadorOferta;
import logica_manejadores.IManejadorPyT;
import logica_manejadores.IManejadorUsuario;
import utils.Fabrica;

class controladorOfertaTest {

	private static IControladorOferta co;
    private static IManejadorOferta mo;
    private static IManejadorPyT mpyt;
    private static IManejadorUsuario mu;
    private static IControladorUsuario cu;
    LocalDate f1 = LocalDate.of( 1990, 1, 1);
    LocalTime d2 = LocalTime.of( 8, 0); 
    LocalTime d1 = LocalTime.of( 17, 0); 

    @BeforeAll
    public static void setUpBeforeClass() throws Exception {
        Fabrica f = Fabrica.getInstance();
        co = f.getInOfer();
        mo = f.getInManejadorOferta();
        mu = f.getInManejadorUsuario();
        cu = f.getInUser();
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
        new ArrayList<>();

        
            co.darAltaOferta(nombre,descripcion,ciudad,departamento,horaInicio,horaFin,remuneracion,costoDeOfertaLaboral,fechaDeAlta, null, null);
    		OfertaLaboral  publiOfer = mo.obtenerOferta(nombre);
            OfertaLaboral o = mo.obtenerOferta(nombre);
            Empresa emp = mu.obtenerEmpresa("EcoTech");
            o.setEmpresa(emp);
            emp.agregarOfertas(nombre, o);

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

	    co.darAltaOferta("Doctor", "Cirujano cardio", "La teja", "Montevideo", d2,d1, 1500, 1000, f1, null, null);
		OfertaLaboral  publiOfer = mo.obtenerOferta("Doctor");
	    assertThrows(NombreRepetidoOfertaException.class, () -> {
	    	co.darAltaOferta("Doctor","Cirujano cardio", "La teja", "Montevideo", d2,d1, 1500, 1000, f1, null, null);
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
	void altaDePublicacionDeOferOk() throws NombreRepetidoOfertaException, noExistePublicacionException {
		LocalTime hora1 = LocalTime.of(11, 30);
		LocalTime hora2 = LocalTime.of(16, 0);
		LocalDate fecha1 = LocalDate.of(2023, 9, 12);
		ArrayList<String> palabrasClave1 = new ArrayList<>();
		ArrayList<DataKeyWord> setdt = mo.getDataKeyWord();
		for(DataKeyWord dtk : setdt) {
			palabrasClave1.add(dtk.getPalabraClave());
		}
		ArrayList<DataOferta> dataOfers = mo.getDataOfertasFinalizadas();
		ArrayList<OfertaLaboral> dataOfertasLaborales = mo.getOfertasFinalizadas();
		
		co.altaPublicacionOfertaLaboralGeneral("EcoTech", "Premium", "Nombre ofer", "Descripcion", hora1, hora2, 50, "San Carlos", "Maldonado", fecha1, palabrasClave1, null, null);
		
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
	void publicacionOfertaRepetida()throws NombreRepetidoOfertaException, noExistePublicacionException {
		LocalTime hora1 = LocalTime.of(11, 30);
		LocalTime hora2 = LocalTime.of(16, 0);
		LocalDate fecha1 = LocalDate.of(2023, 9, 12);
		ArrayList<String> palabrasClave1 = new ArrayList<>();
		co.altaPublicacionOfertaLaboralGeneral("EcoTech", "Premium", "Nombre ofer2", "Descripcion", hora1, hora2, 50, "San Carlos", "Maldonado", fecha1, palabrasClave1, null, null);
		OfertaLaboral  publiOfer = mo.obtenerOferta("Nombre ofer2");
		assertThrows(NombreRepetidoOfertaException.class, () -> {
			co.altaPublicacionOfertaLaboralGeneral("EcoTech", "Premium", "Nombre ofer2", "Descripcion", hora1, hora2, 50, "San Carlos", "Maldonado", fecha1, palabrasClave1, null, null);
		});
	}
	
	@Test
	void agregoPostulacion() throws yaExistePostulacionAOfertaException{
		LocalDate fecha1 = LocalDate.of(2023, 9, 12);
		co.agregarPostulacion("lgarcia","Soporte Tecnico","hombre","arania",fecha1,"");
	}
	
	@Test 
	void agregoPostulacionRepetida() throws yaExistePostulacionAOfertaException{
		LocalDate fecha1 = LocalDate.of(2023, 9, 12);
		assertThrows(yaExistePostulacionAOfertaException.class, () -> {
			co.agregarPostulacion("lgarcia","Soporte Tecnico","hombre","arania",fecha1,"");
		});
	}
	
	@Test
	void testeoDeDataPubli() {
		ArrayList<DataTipoPublicacion> setDtPubli = mpyt.getDataTipoPublicacion();
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

	
	@Test
	void testeoGetOfertasPorKeys() {
		String key = "Freelance";
		ArrayList<DataOferta> dataOfers = mo.obtenerOfertasConfirmadasPorKey(key);
		String ofer = "A. de Marketing Digital";
		String comparacion = null;
		for(DataOferta dto : dataOfers) {
			if(ofer == dto.getNombre()) {
				comparacion = dto.getNombre();
				break;
			}
		}
		assertEquals(ofer,comparacion);
	}
	
	@Test
	void testeoobtenerPos() {
		String ofer = "Soporte Tecnico";
		String empre = "EcoTech";
		@SuppressWarnings("unused")
		ArrayList<Postulacion> postulaciones = mo.obtenerPostulaciones(ofer,empre);
	}
	
	@Test
	void testeoAltaPubliOferConPaquete() throws NombreRepetidoOfertaException, noExistePublicacionException, noExisteTipoPubli{
		LocalTime hora1 = LocalTime.of(11, 30);
		LocalTime hora2 = LocalTime.of(16, 0);
		LocalDate fecha1 = LocalDate.of(2023, 9, 12);
		ArrayList<String> palabrasClave1 = new ArrayList<>();
		ArrayList<DataKeyWord> setdt = mo.getDataKeyWord();
		for(DataKeyWord dtk : setdt) {
			palabrasClave1.add(dtk.getPalabraClave());
		}
		
		co.altaPublicacionOfertaLaboralConPaquete("EcoTech", "Premium", "Nombre ofer3", "Descripcion", hora1, hora2, 50, "San Carlos", "Maldonado", fecha1, palabrasClave1, null, null);
		
		OfertaLaboral  publiOfer = mo.obtenerOferta("Nombre ofer3");
		publiOfer.setEstado(EstadoOferta.ACEPTADA);
		assertEquals("EcoTech", publiOfer.getEmpresa().getNickName());
		assertEquals("Premium", publiOfer.getTipoDeOferta().getNombre());
		assertEquals("Nombre ofer3", publiOfer.getNombreOferta());
		assertEquals("San Carlos", publiOfer.getCiudad());
		assertEquals("Maldonado", publiOfer.getDepartamento());
		assertEquals(hora1, publiOfer.getHoraInicio());
		assertEquals(hora2, publiOfer.getHoraFin());
		assertEquals(fecha1, publiOfer.getFecha());
		assertEquals(palabrasClave1, publiOfer.getKeyWordsString());
	}
	
	@Test
	void testeoNoExistePublicacion() throws NombreRepetidoOfertaException, noExistePublicacionException, noExisteTipoPubli{
		LocalTime hora1 = LocalTime.of(11, 30);
		LocalTime hora2 = LocalTime.of(16, 0);
		LocalDate fecha1 = LocalDate.of(2023, 9, 12);
		ArrayList<String> palabrasClave1 = new ArrayList<>();
		ArrayList<DataKeyWord> setdt = mo.getDataKeyWord();
		for(DataKeyWord dtk : setdt) {
			palabrasClave1.add(dtk.getPalabraClave());
		}
		
		assertThrows(noExistePublicacionException.class, () -> {
			co.altaPublicacionOfertaLaboralConPaquete("EcoTech", "Ni idea", "Nombre ofer4", "Descripcion", hora1, hora2, 50, "San Carlos", "Maldonado", fecha1, palabrasClave1, null, null);

		});
	}
	
	@Test
	void crearPaqueteDeTipoPubliDeOfertasLaboralesTest() throws NombrePaqueteYaExiste, NombreRepetidoOfertaException, noExistePublicacionException, noExisteTipoPubli {
		LocalDate fecha1 = LocalDate.of(2023, 9, 12);
		LocalTime hora1 = LocalTime.of(11, 30);
		LocalTime hora2 = LocalTime.of(16, 0);
		LocalDate fecha11 = LocalDate.of(2023, 9, 12);
		ArrayList<String> palabrasClave1 = new ArrayList<>();
		ArrayList<DataKeyWord> setdt = mo.getDataKeyWord();
		for(DataKeyWord dtk : setdt) {
			palabrasClave1.add(dtk.getPalabraClave());
		}
		co.crearPaqueteDeTipoDePublicacionDeOfertasLaborales("Paquete Pro", "descripcion", 30, 20, fecha1, 3720, null);
		Paquete paqui = mpyt.getPaquete("Paquete Pro");
		cu.comprarPaquete(paqui, "FusionTech");
		
	}
	
	@Test
	void crearPaqueteDeTipoPubliDeOfertasLaboralesInvalido() throws NombrePaqueteYaExiste {
		LocalDate fecha1 = LocalDate.of(2023, 9, 12);
		co.crearPaqueteDeTipoDePublicacionDeOfertasLaborales("Paquete Pro2", "descripcion", 30, 20, fecha1, 3720, null);
		
		assertThrows(NombrePaqueteYaExiste.class, () -> {
			co.crearPaqueteDeTipoDePublicacionDeOfertasLaborales("Paquete Pro2", "descripcion", 30, 20, fecha1, 3720, null);
		});
	}
	
	@Test
	void getPostulantesStringTest() {
		String ofer = "Desarrollador Frontend";
		ArrayList<String> postu = co.getPostulantesString(ofer);
		String pos = "lgarcia";
		String comparacion = null;
		for(String dpos : postu) {
			if(pos == dpos) {
				comparacion = dpos;
				break;
			}
		}
		assertEquals(pos,comparacion);
	}
	
	@Test 
	void getDataPaqueteTest() {
		String paq = "Destacado";
		ArrayList<DataPaquete> paquetes = mpyt.getDataPaquete();
		String comparacion = null;
		for(DataPaquete paqs : paquetes) {
			if(paq == paqs.getNombre()) {
				comparacion = paqs.getNombre();
				break;
			}
		}
		assertEquals(paq,comparacion);
		
		}
		/*@Test 
		void testeoDataTipoPubli() {
			DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			LocalDate at1 = LocalDate.parse("10-08-2023", dateFormatter);
			LocalTime hi13 = LocalTime.parse("14:00");
			LocalTime hf13 = LocalTime.parse("18:00");
			LocalDate ao13 = LocalDate.of(2023,10,1);
			OfertaLaboral o134 = new OfertaLaboral() );
			o134.setCiudad("Montevideo");
			o134.setCostoOfer(4000);
			o134.setDepartamento("Montevideo");
			o134.setDescripcion("Asegura la calidad.");
			o134.setEmpresa(null);
			o134.setEstado(null);
			o134.setFechaAlta(ao13);
			o134.setTipoPublicacionConString("Premium");
			o134.setTipodePago(null);
			o134.setRemuneracion(60000);
			o134.setPostulaciones(null);
			o134.setNombre("Ingeniero ");
			o134.setPalabrasClav(null);
			o134.setImagen(null);
			o134.setHorarioIni(hi13);
			o134.setHorarioFin(hf13);
			TipoPublicacion tp1 = new TipoPublicacion("Premium+","Obten maxima visibilidad+.",1,30,4000,at1);
			o134.setTipoPublicacion(tp1);
			TipoPublicacion datos = o134.getTipoDeOferta();
			DataTipoPublicacion data = datos.getDTTipoPublicacion();
			assertEquals(data.getCosto(),datos.getCosto());
			
		}*/
	@Test
	void getVideoEmbedTest() {
		String embed1 = "https://www.youtube.com/embed/5USuekk16e0";
		String embed2 = co.getVideoEmbed("https://www.youtube.com/watch?v=5USuekk16e0");
		
		assertEquals(embed1, embed2); 
	}
	
	@Test
	void aceptarOfertaLaboralTest() throws NombreRepetidoOfertaException  {
		OfertaLaboral ofer  = mo.obtenerOferta("Desarrollador de Software Senior");
		co.aceptarOfertaLaboral(ofer.getDataOferta());

	}
	
	@Test
	void rechazarOfertaLaboralTest() throws NombreRepetidoOfertaException  {
		OfertaLaboral ofer  = mo.obtenerOferta("Desarrollador de Software Full Stack");
		co.rechazarOfertaLaboral(ofer.getDataOferta());

	}
	
	
	@Test
	void getDataOfertaTest() {
		DataOferta dofer = mo.getDataOferta("Desarrollador Frontend");
		assertEquals(dofer.getNombre(), "Desarrollador Frontend"); 
	}
	
	@Test
	void getDataKeyWordPorNombreTest() {
		DataKeyWord dkw = mo.getDataKeyWordPorNombre("Tiempo completo");
		String str = dkw.toString();
		assertEquals(dkw.getPalabraClave(), "Tiempo completo"); 
		assertEquals(str, "Tiempo completo"); 
	}
	
	@Test
	void finalizarOfertaTest() {
		mo.finalizarOferta("Desarrollador Frontend");
	}
	
	@Test
	void getOfertasConfimadasOrdenadasPorVisitasTest() {
		ArrayList<OfertaLaboral> arr = new ArrayList<>();
		arr = mo.getOfertasConfimadasOrdenadasPorVisitas();
	}
	
	
	
	@Test
	void testDataTypes() {
		//Data Compra Paquete
		DataCompraPaquete dcp = new DataCompraPaquete();
	    LocalDate compra = LocalDate.of( 2023, 9, 9);
	    LocalDate vencimiento = LocalDate.of( 2024, 9, 9);
		dcp.setFechaCompra(compra);
		dcp.setFechaVenc(vencimiento);
		assertEquals(dcp.getFechaCompra(), compra); 
		assertEquals(dcp.getFechaVenc(), vencimiento); 
		
		//Data Empresa
		DataEmpresa demp = new DataEmpresa();
		demp.setDescripcion("no se"); 
		demp.setLinkWeb("www.a.com");
		assertEquals(demp.getDescripcion(), "no se"); 
		assertEquals(demp.getLinkWeb(), "www.a.com"); 
		
		//Data Postu
		DataPostulante dpos = new DataPostulante();
		dpos.setNacimiento("19/02/2002"); 
		dpos.setNacionalidad("uru");
		assertEquals(dpos.getNacimineto(), "19/02/2002"); 
		assertEquals(dpos.getNacionalidad(), "uru"); 
		
		//Data TipoPubli
		DataTipoPublicacion tp2 = new DataTipoPublicacion();
		tp2.setNombres("Destacada");
		tp2.setDescripcion("Destaca tu anuncio");
		tp2.setExposicion(2);
		tp2.setDuracion(15);
		tp2.setCosto(500);
		tp2.setFecha("19/02/2002");
		assertEquals(tp2.getNombre(), "Destacada"); 
		assertEquals(tp2.getDescripcion(), "Destaca tu anuncio"); 
		assertEquals(tp2.getExposicion(), 2); 
		assertEquals(tp2.getDuracion(), 15); 
		assertEquals(tp2.getCosto(), 500); 
		assertEquals(tp2.getFecha(), "19/02/2002"); 
		
		//DataOferta
		DataOferta doferta = mo.getDataOferta("A. de Marketing Digital");
		String hi7 = "10:00";
		String hf7 = "19:00";
		String ao7 = "02/11/2023";
		doferta.setFechaCalif("13/11/2023");
		doferta.setFechaFin("13/11/2023");
		String fechaFin = doferta.getFechaFin();
		String fechaCalif = doferta.getFechaCalif();
		assertEquals(doferta.getEmpresa(), "EcoTech");
		assertEquals(doferta.getDescripcion(), "Únete a nuestro equipo de marketing y trabaja en estrategias digitales innovadoras.");
		assertEquals(doferta.getCiudad(), "Flores");
		assertEquals(doferta.getDepartamento(), "Flores");
		assertEquals(doferta.getHoraInicio(), hi7);
		assertEquals(doferta.getHoraFin(), hf7);
		assertEquals(doferta.getRemuneracion(), 80000);
		assertEquals(doferta.getFechaDeAlta(), ao7);
		assertEquals(doferta.getCostoDeOfertaLaboral(), 4000);
		assertEquals(fechaFin, "13/11/2023");
		assertEquals(fechaCalif, "13/11/2023");

		//DataPaquete
		DataPaquete dpaq = new DataPaquete();
		dpaq.setNombre("Premium");
		dpaq.setDescripcion("Publica ofertas laborales premium que incluyen promoción en nuestras redes sociales y listado en la sección destacada por 60 días.");
		dpaq.setValidez(60);
		dpaq.setDescuento(15);
		dpaq.setFechaDeAlta("13-08-2023");
		dpaq.setCosto(7055);
		assertEquals(dpaq.getNombre(), "Premium");
		assertEquals(dpaq.getDescripcion(), "Publica ofertas laborales premium que incluyen promoción en nuestras redes sociales y listado en la sección destacada por 60 días.");
		assertEquals(dpaq.getValidez(), 60);
		assertEquals(dpaq.getDescuento(), 15);
		assertEquals(dpaq.getFechaDeAlta(), "13-08-2023");
		assertEquals(dpaq.getCosto(), 7055);
		
		//Data Postulacion
		DataPostulacion dPos = new DataPostulacion();
		dPos.setFecha("30-09-2023");
		dPos.setCurri("Músico profesional, experiencia en espectáculos en vivo. Habilidades en canto y guitarra.");
		dPos.setMotivacion("Me gustaría combinar mi pasión por la música con una oportunidad laboral que me permita seguir creciendo como artista.");
		dPos.setNickPostulante("valen25");
		dPos.setNombreOferta("Estrategia de Negocios");
		assertEquals(dPos.getFecha(), "30-09-2023");
		assertEquals(dPos.getCurri(), "Músico profesional, experiencia en espectáculos en vivo. Habilidades en canto y guitarra.");
		assertEquals(dPos.getMotivacion(), "Me gustaría combinar mi pasión por la música con una oportunidad laboral que me permita seguir creciendo como artista.");
		assertEquals(dPos.getNickPostulante(), "valen25");
		assertEquals(dPos.getNombreOferta(), "Estrategia de Negocios");

	}
	
	@Test
	void testGetDTTipoPubli() {
		TipoPublicacion tp1 = new TipoPublicacion();
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate at1 = LocalDate.parse("10-08-2023", dateFormatter);
		tp1.setNombre("Pepe");
		tp1.setDescripcion("Obtén máxima visibilidad.");
		tp1.setExposicion(1);
		tp1.setDuracion(30);
		tp1.setCosto(4000);
		tp1.setFecha(at1);
		DataTipoPublicacion dtp = tp1.getDTTipoPublicacion();
		assertEquals(dtp.getNombre(),"Pepe");
	
	}	
	
	@Test
	void testGetDTPaquete() {
		Paquete paq1 = new Paquete();
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate fhp1 = LocalDate.parse("16-08-2023", dateFormatter);
		paq1.setNombre("No se");
		paq1.setDescripcion("Publica ofertas laborales en nuestra plataforma por un período de 30 días.");
		paq1.setValidez(30);
		paq1.setDescuento(20);
		paq1.setFechaAlta(fhp1);
		paq1.setCosto(3720);
		paq1.setImagen(null);
		
		DataPaquete dtp = paq1.getDTPaquete();
		assertEquals(dtp.getNombre(),"No se");
	}
	
	@Test
	void testGetDTCompraPaquete() {
		CompraPaquete comp1 = new CompraPaquete();
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate fc1 = LocalDate.parse("31-10-2023", dateFormatter); //e1 y pq3
		LocalDate fvc1 = fc1.plusDays(60);
		comp1.setFechaCompr(fc1);
		comp1.setFechaVenc(fvc1);
		DataCompraPaquete dtcp = comp1.getDTCompraPaquete();

		assertEquals(dtcp.getFechaCompra(),fc1);
	}
	
	@Test
	void getPublicacionesYOferVencidasTest() {
		Empresa emp = mu.obtenerEmpresa("EcoTech");
		ArrayList<DataTipoPublicacion> publicaciones = new ArrayList<>();
		publicaciones = emp.getPublicaciones();
		HashMap<String, OfertaLaboral> oferVenc = new HashMap<>();
		oferVenc = emp.getOfertasVencidas();
		HashMap<String, OfertaLaboral> oferAprobVenc = new HashMap<>();
		oferVenc = emp.getOfertasAprobadasYVencidasDeEmpresa();
		}
	
	@Test
	void seguirOdejarDeSeguirUsuarioTest() {
		Usuario user1 = mu.obtenerUsuario("lgarcia");
		Usuario user2 = mu.obtenerUsuario("EcoTech");
		user1.agregarSeguidor(user2);
		user2.dejarDeSeguirAUsuario(user2);
		user1.agregarSeguidor(user2);
		user1.quitarSeguidor(user2);
		
	}
	
	}
	
