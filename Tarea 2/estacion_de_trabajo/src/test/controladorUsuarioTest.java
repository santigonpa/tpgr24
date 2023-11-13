package test;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import excepciones.EmailYaExisteException;
import excepciones.NicknameYaExisteException;
import java.time.format.DateTimeFormatter;
import excepciones.UsuarioNoExisteException;
import excepciones.campoInvalidoException;
import excepciones.yaExistePostulacionAOfertaException;
import logica_cargar_datos.datos_de_prueba.cargarDatos;
import logica_controladores.IControladorUsuario;
import logica_datatypes.DataEmpresa;
import logica_datatypes.DataOferta;
import logica_datatypes.DataPostulacion;
import logica_datatypes.DataPostulante;
import logica_datatypes.DataUsuario;
import logica_entidades.Empresa;
import logica_entidades.OfertaLaboral;
import logica_entidades.Postulacion;
import logica_entidades.Postulante;
import logica_entidades.TipoPublicacion;
import logica_entidades.Usuario;
import logica_manejadores.IManejadorOferta;
import logica_manejadores.IManejadorUsuario;
import utils.Fabrica;

class controladorUsuarioTest {

	private static IControladorUsuario cu;
	private static IManejadorUsuario mu;
	private static IManejadorOferta mo;
	private static Postulante p1;
	private static Postulante p2;
	private static Empresa e1;
	private static Empresa e2;
	private static TipoPublicacion tp1;
	private static OfertaLaboral o1;
	private static DataEmpresa pruebaDataEmp;
	private static Postulacion postulacion1;
	@BeforeAll
	public static void setUpBeforeClass() throws UsuarioNoExisteException {
		
		Fabrica f = Fabrica.getInstance();
		cu = f.getInUser();
		
		assertThrows(UsuarioNoExisteException.class, () -> {
			cu.getDataUsuarios();
	    });
		
		cargarDatos cargador = new cargarDatos();
        try {
			cargador.cargar();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		
		mu = f.getInManejadorUsuario();
		mo = f.getInManejadorOferta();
		LocalDate f1 = LocalDate.of(2023, 9, 15);
		LocalDate f2 = LocalDate.of(2023, 9, 15);
		//p1 = new Postulante("Pedro", "Herni", "pepi", "pepi@gmail.com", f1, "Uru", null, null);
		p1 = new Postulante();
		p1.setNombre("Pedro");
		p1.setApellido("Herni");
		p1.setNickName("pepi");
		p1.setEmail("pepi@gmail.com");
		p1.setNacimiento(f1);
		p1.setNacionalidad("Uru");
		
	
		//p2 = new Postulante("Maria", "Lopes", "mari", "marilaosa@gmail.com", f2, "Esp", null, null);
		p2 = new Postulante();
		p2.setNombre("Maria");
		p2.setApellido("Lopes");
		p2.setNickName("mari");
		p2.setEmail("marilaosa@gmail.com");
		p2.setNacimiento(f2);
		p2.setNacionalidad("Esp");
		
		//e1 = new Empresa("McDonalds", "Ronald", "ElDonal", "cajitaFeliz@gmail.com", "Comida rapida", "www.mCDonalds.com", null, null);
		e1 = new Empresa();
		e1.setNombre("McDonalds");
		e1.setApellido("Ronald");
		e1.setNickName("ElDonal");
		e1.setEmail("cajitaFeliz@gmail.com");
		e1.setDescripcion("Comida rapida");
		e1.setLinkWeb("www.mCDonalds.com");
		
		//e2 = new Empresa("LifeCinema", "vida", "cine", "noMirenCuevana@gmail.com", "Descuentos con tarjetas seleccionadas", "www.lifeCinemas.com", null, null);
		e2 = new Empresa();
		e2.setNombre("LifeCinema");
		e2.setApellido("vida");
		e2.setNickName("cine");
		e2.setEmail("noMirenCuevana@gmail.com");
		e2.setDescripcion("Descuentos con tarjetas seleccionadas");
		e2.setLinkWeb("www.lifeCinemas.com");
		
		LocalDate at1 = LocalDate.parse("10-08-2023", dateFormatter);
		LocalTime hi1 = LocalTime.parse("09:00");
		LocalTime hf1 = LocalTime.parse("18:00");
		LocalDate ao1 = LocalDate.of(2023, 9, 15);
		//TipoPublicacion tp1 = new TipoPublicacion("Premium", "Obten maxima visibilidad.", 1, 30, 4000, at1);
		tp1 = new TipoPublicacion();
		tp1.setNombre("Premium");
		tp1.setDescripcion("Obten maxima visibilidad.");
		tp1.setExposicion(1);
		tp1.setDuracion(30);
		tp1.setCosto(4000);
		tp1.setFecha(at1);
		
		mu.addUsuario(e1);
		mu.addUsuario(e2);
		mu.addUsuario(p1);
		mu.addUsuario(p2);
		//OfertaLaboral o1 = new OfertaLaboral("Desarolaldor Frontend", "Unete a nuestro equipo de desarrollo frontend y crea experiencias de usuario excepcionales.", "Montevideo", "Montevideo", hi1, hf1, 90000, 4000, ao1,  null, null);
		o1 = new OfertaLaboral();
		o1.setNombre("Desarolaldor Frontend");
		o1.setDescripcion("Unete a nuestro equipo de desarrollo frontend y crea experiencias de usuario excepcionales.");
		o1.setDepartamento("Montevideo");
		o1.setCiudad("Montevideo");
		o1.setHorarioIni(hi1);
		o1.setHorarioFin(hf1);
		o1.setRemuneracion(900000);
		o1.setCostoOfer(4000);
		o1.setFechaAlta(ao1);
		
		e1.agregarOfertas(o1.getNombreOferta(), o1);
		o1.setEmpresa((Empresa) e1);
		o1.setTipoPublicacion(tp1);
		
		//postulacion1 = new Postulacion(f1, "sou un cv", "soy una motivacion", p1, o1);
		postulacion1 = new Postulacion();
		postulacion1.setFecha(f1);
		postulacion1.setCurri("sou un cv");
		postulacion1.setMotivacion("soy una motivacion");
		postulacion1.setPost(p1);
		postulacion1.setOfer(o1);
		
		try {
			cu.agregarPostulacionAPostulante(p1.getNickName(), postulacion1);
			//CU.altaUsuarioEmpresa("nicknei2m", "nom", "ape", "2emaIl", "desc", "web", null, "pass");
			//CU.altaUsuarioPostulante("nickPos", "nom", "ape", "emailPostu", ao1, "naci", null, "contrasenia");
			//CU.modificarDatosEmpresa("nick", "nom", "ape", "ema", "desc", "web", null, "pass");
			//CU.modificarDatosPostulante("nickPos", "nom", "ape", "emailPostu","5/5/0005", "naci", null, "contrasenia");
		} catch (yaExistePostulacionAOfertaException e) {
			
			e.printStackTrace();
		}
		mo.addOferta(o1);
		mo.addPostulacion(postulacion1);
	}

	@Test
	void registroEsExitoso() throws NicknameYaExisteException, campoInvalidoException, EmailYaExisteException{
		//para un postulante
		String nickName = "Jofe";
		String nombre = "Josefina";
		String apellido = "Hernandez";
		String email = "holaComoEstas@gmail.com";
		String nacionalidad = "Colombia";
		
		//para la empresa
		String nickName2 = "Lulu";
		String nombre2 = "Luna";
		String apellido2 = "Gomez";
		String web = "www.luluG.com.uy";
		String email2 = "luliGmez@gmail.com";
		String descripcion = "contratamos gente";
		LocalDate fecha111 = LocalDate.of(2023, 9, 15);

		
			cu.altaUsuarioPostulante(nickName, nombre, apellido, email, fecha111, nacionalidad, null, null);
			cu.altaUsuarioEmpresa(nickName2, nombre2, apellido2, email2, descripcion, web, null, null);
			Postulante p = mu.obtenerPostulante(nickName);
			Empresa e = (Empresa) mu.obtenerEmpresa(nickName2);
			DataUsuario pruebaDataPos = cu.listarInfoUser(nickName);
			//DataEmpresa pruebaDataEmp = new DataEmpresa("McDonalds", "Ronald", "ElDonal", "cajitaFeliz@gmail.com", "Comida rapida", "www.mCDonalds.com", null, null);
			pruebaDataEmp = e1.getDTEmpresa();
			HashMap<String, OfertaLaboral> mapaOfEmpresa =  cu.obtenerOfertarDeEmpresa(pruebaDataEmp);
			OfertaLaboral pruebaEncuentro = mapaOfEmpresa.get("Desarolaldor Frontend");
	}
	
	@Test
	
	void postulanteRepetido() throws NicknameYaExisteException, EmailYaExisteException, campoInvalidoException{
		LocalDate n1 = LocalDate.of(1995, 5, 1);
		IControladorUsuario cu = Fabrica.getInstance().getInUser();
	    //ESTO LO QUE HACE ES FIJARSE SI PASA LA EXCEPCION QUE PONGO DENTRO DEL ASSERTTHROWS
		//SI OCURRE LA EXCEPCION EL TEST VA A SALIR BIEN LUEGO EN LOS SIGUIENTES TEST DE ABAJO HAGO LO MISMO CON OTRAS EXC
	    assertThrows(NicknameYaExisteException.class, () -> {
	        cu.altaUsuarioPostulante("pepi", "holaworld", "apellido", "nombreInva@gmail.com",n1, "www.noFunc.com", null, null);
	    });
	}
	
	
	

	
	
	
	
	@Test
	
	void empresaRepetido() throws NicknameYaExisteException, EmailYaExisteException, campoInvalidoException{
		IControladorUsuario cu = Fabrica.getInstance().getInUser();
	    
	    assertThrows(NicknameYaExisteException.class, () -> {
	        cu.altaUsuarioEmpresa("ElDonal", "holaworld", "apellido", "nombreInva@gmail.com","No deberia funcionar", "www.noFunc.com", null, null);
	    });
	}
	

	@Test
	void darDeAltaNickInvalidoEmp() throws campoInvalidoException, NicknameYaExisteException, EmailYaExisteException{
		IControladorUsuario cu = Fabrica.getInstance().getInUser();
	    
	    assertThrows(campoInvalidoException.class, () -> {
	        cu.altaUsuarioEmpresa("", "", "", "nombreInva@gmail.com","No deberia funcionar", "www.noFunc.com", null, null);
	    });
	}

	@Test
	void darDeAltaeNickInvalidoPost() throws campoInvalidoException, NicknameYaExisteException, EmailYaExisteException{
		IControladorUsuario cu = Fabrica.getInstance().getInUser();
		LocalDate n1 = LocalDate.of(1995, 5, 1);
		assertThrows(campoInvalidoException.class, () -> {
			cu.altaUsuarioPostulante("", "prueba", "nacInv", "nacInv@gmail.com",n1 , "", null, null);
		});
	}
	
	@Test 
	void darAltaNombreInvalidoPost()throws campoInvalidoException, NicknameYaExisteException, EmailYaExisteException{
		IControladorUsuario cu = Fabrica.getInstance().getInUser();
		LocalDate n1 = LocalDate.of(1995, 5, 1);
		assertThrows(campoInvalidoException.class, () -> {
			cu.altaUsuarioPostulante("holamundo", "", "nacInv", "nacInv@gmail.com",n1 , "", null, null);
		});

		
	}
	
	@Test
	@DisplayName("Prueba de alta con nombre de empresa inválido")
	void darAltaNombreInvalidoEmp() {
	    IControladorUsuario cu = Fabrica.getInstance().getInUser();
	    
	    assertThrows(campoInvalidoException.class, () -> {
	        cu.altaUsuarioEmpresa("prueba5", "", "apellido", "nombreInva@gmail.com","No deberia funcionar", "www.noFunc.com", null, null);
	    });
	}


	
	@Test
	@DisplayName("Prueba de alta con apellido de empresa inválido")
	void darAltaApellidoInvalidoEmp1() {
	    IControladorUsuario cu = Fabrica.getInstance().getInUser();
	    
	    assertThrows(campoInvalidoException.class, () -> {
	        cu.altaUsuarioEmpresa("prueba5", "", "apellido", "nombreInva@gmail.com","No deberia funcionar", "www.noFunc.com", null, null);
	    });
	}
	
	
	@Test
	void darAltaEmailInvalidoPost()throws campoInvalidoException, NicknameYaExisteException, EmailYaExisteException{
		
		IControladorUsuario cu = Fabrica.getInstance().getInUser();
	    
	    assertThrows(campoInvalidoException.class, () -> {
	        cu.altaUsuarioEmpresa("prueba5", "hola", "apellido", "","No deberia funcionar", "www.noFunc.com", null, null);
	    });
	}
	
	
	@Test
	void darAltaDescripcionInvalido()throws campoInvalidoException, NicknameYaExisteException, EmailYaExisteException{
		IControladorUsuario cu = Fabrica.getInstance().getInUser();
	    
	    assertThrows(campoInvalidoException.class, () -> {
	        cu.altaUsuarioEmpresa("prueba5", "hola", "apellido", "hola","", "www.noFunc.com", null, "prueba");
	    });
		
	}
	
	@Test
	void darAltaNacionalidadInvalido()throws campoInvalidoException, NicknameYaExisteException, EmailYaExisteException{
		IControladorUsuario cu = Fabrica.getInstance().getInUser();
		LocalDate n1 = LocalDate.of(1995, 5, 1);
		assertThrows(campoInvalidoException.class, () -> {
			cu.altaUsuarioPostulante("prueba", "prueba", "nacInv", "nacInv@gmail.com",n1 , "", null, "prueba");
		});
	}
	
	@Test
	void testeoDelEmailYaExiste()throws campoInvalidoException, NicknameYaExisteException, EmailYaExisteException{
		IControladorUsuario cu = Fabrica.getInstance().getInUser();
		LocalDate n1 = LocalDate.of(1995, 5, 1);
		assertThrows(EmailYaExisteException.class, () -> {
			cu.altaUsuarioPostulante("prueba", "prueba", "nacInv", "pepi@gmail.com",n1 , "", null, "prueba");
		});
	}

	
	@Test
	void testListarUsuarios() throws UsuarioNoExisteException {
		ArrayList<DataUsuario> usuarios = cu.getDataUsuarios();
		String nickNameToSearch1 = p1.getNickName();
		String nickNameToSearch2 = p2.getNickName();
		String nickNameToSearch3 = e1.getNickName();
		String nickNameToSearch4 = e2.getNickName();
		boolean found1 = false;
		boolean found2 = false;
		boolean found3 = false;
		boolean found4 = false;
		
		for (DataUsuario dataUser : usuarios) {
		    if (dataUser.getNickName()==nickNameToSearch1) {
		        found1 = true;
		    }
		    if (dataUser.getNickName().equals(nickNameToSearch2)) {
		        found2 = true;
		    }
		    if (dataUser.getNickName()==nickNameToSearch3) {
		        found3 = true;
		    }
		    if (dataUser.getNickName()==nickNameToSearch4) {
		        found4 = true;
		    }
		}
		
		assertTrue(found1);
		assertTrue(found2);
		assertTrue(found3);
		assertTrue(found4);
		
	}

	@Test
	void testListarPostulantes() {
		ArrayList<DataPostulante> postulantes = cu.getDataPostulante();
		
		String nickNameToSearch1 = p1.getNickName();
		String nickNameToSearch2 = p2.getNickName();
		

		boolean found1 = false;
		boolean found2 = false;
		
		for (DataPostulante dataPostulante : postulantes) {
		    if (dataPostulante.getNickName()==nickNameToSearch1) {
		        found1 = true;
		        break;
		    }
		}
		for (DataPostulante dataPostulante : postulantes) {
		    if (dataPostulante.getNickName().equals(nickNameToSearch2)) {
		        found2 = true;
		        break;
		    }
		}
		
		assertTrue(found1);
		assertTrue(found2);
	}
	
	@Test
	void testListaEmpresas() throws UsuarioNoExisteException {
		ArrayList<DataEmpresa> empresas = cu.getDataEmpresa();
		
		String nickNameToSearch1 = e1.getNickName();
		String nickNameToSearch2 = e2.getNickName();
		

		boolean found1 = false;
		boolean found2 = false;
		
		for (DataEmpresa dataPostulante : empresas) {
		    if (dataPostulante.getNickName()==nickNameToSearch1) {
		        found1 = true;
		        break;
		    }
		}
		for (DataEmpresa dataPostulante : empresas) {
		    if (dataPostulante.getNickName().equals(nickNameToSearch2)) {
		        found2 = true;
		        break;
		    }
		}
		
		assertTrue(found1);
		assertTrue(found2);
		
	}

	/*@Test
	void seAgregaPostulacion() throws yaExistePostulacionAOfertaException {
		
		LocalDate f = LocalDate.of(2023, 8, 10);
		Postulante p = mu.obtenerPostulante("lgarcia");
		
		cu.
		
		assertTrue(postulaciones.contains(post));
	}*/
	
	@Test
	void usuarioNoExiste () throws UsuarioNoExisteException {
		cu.getDataUsuarios();
		//No podemos testearla porque tendriamos que borrar todos los usuarios para que se ejecute la excepcion, otra opcion es borrarla
	}

	
	@Test
	void testObtenerOfertasConfirmadasEmpresa() {
		ArrayList<DataOferta> ofertas = mu.obtenerOfertasConfirmadasDeEmpresa("EcoTech");
		boolean found = false;
		for (DataOferta ofer : ofertas) {
		    if (ofer.getNombre().equals("A. de Marketing Digital")) {
		    	found = true;
		    	break;
		    }
		}
		assertTrue(found);
	}
	
	@Test
	void testObtenerOfertasEmpresa() {
		ArrayList<DataOferta> ofertas = mu.obtenerOfertasDeUnaEmpresa("EcoTech");
		boolean found = false;
		for (DataOferta ofer : ofertas) {
		    if (ofer.getNombre().equals("A. de Marketing Digital")) {
		    	found = true;
		    	break;
		    }
		}
		assertTrue(found);
	}
	
	@Test
	void testeoModificarPostulante() {
		LocalDate fecha111 = LocalDate.of(2023, 9, 15);
		// Define el formato que deseas
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        @SuppressWarnings("unused")
		ArrayList<Postulacion> datas = cu.obtenerPostulaciones("lgarcia");
        // Formatea la fecha en el formato deseado
        String fechaFormateada = fecha111.format(formato);
		cu.modificarDatosPostulante("lgarcia", "luchi", "garcia sosa","lgarcia85@gmail.com" , fechaFormateada, "hola", null, "ola");
		
		assertEquals(mu.getDataPostulante("lgarcia").getNombre(),"luchi");
	}
	
	@Test
	void testeoModificarEmpresa() {
		
		cu.modificarDatosEmpresa("EcoTech", "piter", "pereira", "info@EcoTech.com", "poner", "algo", null, "ejemplo");
		
		assertEquals(mu.getDataEmpresa("EcoTech").getNombre(),"piter");
	}
	
	@Test
	void testeoEntidadesUsuario() {
		@SuppressWarnings("unused")
		//ArrayList<DataOferta> oferArr= CU.getDataOfertasDeEmpresa("EcoTech");
		Postulante lgarcia = mu.obtenerPostulante("lgarcia");
		Postulacion postu = lgarcia.encontrarPostulacionPorNombreOferta("Desarrollador Frontend");
		Postulacion postu2 = lgarcia.encontrarPostulacionPorNombreOferta("Estratega de Negocios");
		boolean verIgualdad = (postu.equals(postu2));
		String cvPostu = postu.getCV();
		String motiPostu =postu.getMotivacion();
		String nombrePostulante = postu.getNombrePostulante();
		String nombreOfert = postu.getNombreOfer();
		assertEquals(nombrePostulante, postu.getNombrePostulante());
		assertEquals(nombreOfert, postu.getNombreOfer());
		assertEquals(cvPostu,postu.getCV());
		assertEquals(motiPostu,postu.getMotivacion());
		DataPostulacion dataPos = postu.getDTPostulacion();
		assertNull(dataPos.getApellido(),postu.getPostulante().getApellido());
		assertFalse(verIgualdad);
		DataPostulante postulant = lgarcia.getDTPostulante();
		assertEquals(postulant.getNickName(),"lgarcia");
		Empresa eco = mu.obtenerEmpresa("EcoTech");
		eco.modificarEm("hola", "nuevos", "datos", "empresa");
		lgarcia.modificarPos("apellido", "nuevo", 3,12, 2000, "Uruguay");
		assertEquals(mu.getDataEmpresa("EcoTech").getNombre(),"hola");
		assertEquals(mu.getDataPostulante("lgarcia").getNombre(),"apellido");
		
		@SuppressWarnings("unused")
		ArrayList<DataOferta> oferts = mu.obtenerOfertasFinalizadas("EcoTech");
		@SuppressWarnings("unused")
		ArrayList<DataOferta> ofertsRech =mu.obtenerOfertasRechazadasIngresadas("EcoTech");
		DataUsuario lgarciaData = ((Usuario) lgarcia).getDTUsuario();
		assertEquals(lgarciaData.getNombre(),"apellido");
		assertEquals(postu.getNickPostulante(),"lgarcia");
		HashMap<String, OfertaLaboral> mapa = eco.getOfertasRechazadasIngresadas();
		@SuppressWarnings("unused")
		ArrayList<DataOferta> oferT = cu.getDataOfertasDeEmpresa("EcoTech");
		assertNull(mapa.get("Desarrollador Frontend"));
	
		
	}
	
	@Test
	void testObtenerOfertarDeEmpresa() {
		
		DataEmpresa ecoTech = mu.getDataEmpresa("EcoTech");
		HashMap<String,OfertaLaboral> mapa = cu.obtenerOfertarDeEmpresa(ecoTech);
		assertNotEquals(mapa.get("EcoTech"),"EcoTech");
	}
	
	@Test
	void testListarInfoUser() {
		DataUsuario user = cu.listarInfoUser("lgarcia");
		assertEquals(user.getNickName(),"lgarcia");
	}
	
	
	
	
}