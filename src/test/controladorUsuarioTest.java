package test;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import excepciones.EmailYaExisteException;
import excepciones.NicknameYaExisteException;
import java.time.format.DateTimeFormatter;
import excepciones.UsuarioNoExisteException;
import excepciones.campoInvalidoException;
import excepciones.yaExistePostulacionAOfertaException;
import logica_Controladores.IControladorUsuario;
import logica_DataTypes.DataEmpresa;
import logica_DataTypes.DataPostulante;
import logica_DataTypes.DataUsuario;
import logica_Entidades.Postulante;
import logica_Entidades.TipoPublicacion;
import logica_Entidades.Empresa;
import logica_Entidades.OfertaLaboral;
import logica_Entidades.Postulacion;
import logica_Manejadores.IManejadorOferta;
import logica_Manejadores.IManejadorUsuario;
import utils.Fabrica;

class controladorUsuarioTest {

	private static IControladorUsuario cu;
	private static IManejadorUsuario mu;
	private static IManejadorOferta mo;
	private static Postulante p1;
	private static Postulante p2;
	private static Empresa e1;
	private static Empresa e2;
	private static Postulacion postulacion1;
	@BeforeAll
	public static void setUpBeforeClass() throws UsuarioNoExisteException {
		
		Fabrica f = Fabrica.getInstance();
		cu = f.getInUser();
		
		assertThrows(UsuarioNoExisteException.class, () -> {
			cu.getDataUsuarios();
	    });
		
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		mu = f.getInManejadorUsuario();
		mo = f.getInManejadorOferta();
		LocalDate f1 = LocalDate.of(2023, 9, 15);
		LocalDate f2 = LocalDate.of(2023, 9, 15);
		p1 = new Postulante("Pedro", "Herni", "pepi", "pepi@gmail.com", f1, "Uru");
		p2 = new Postulante("Maria", "Lopes", "mari", "marilaosa@gmail.com", f2, "Esp");
		e1 = new Empresa("McDonalds", "Ronald", "ElDonal", "cajitaFeliz@gmail.com", "Comida rapida", "www.mCDonalds.com");
		e2 = new Empresa("LifeCinema", "vida", "cine", "noMirenCuevana@gmail.com", "Descuentos con tarjetas seleccionadas", "www.lifeCinemas.com");
		LocalDate at1 = LocalDate.parse("10-08-2023", dateFormatter);
		LocalTime hi1 = LocalTime.parse("09:00");
		LocalTime hf1 = LocalTime.parse("18:00");
		LocalDate ao1 = LocalDate.of(2023, 9, 15);
		TipoPublicacion tp1 = new TipoPublicacion("Premium","Obten maxima visibilidad.",1,30,4000,at1);
		mu.addUsuario(e1);
		mu.addUsuario(e2);
		mu.addUsuario(p1);
		mu.addUsuario(p2);
		OfertaLaboral o1 = new OfertaLaboral("Desarolaldor Frontend","Unete a nuestro equipo de desarrollo frontend y crea experiencias de usuario excepcionales.","Montevideo","Montevideo",hi1,hf1,90000,4000,ao1);
		e1.agregarOfertas(o1.getNombreOferta(), o1);
		o1.setEmpresa((Empresa)e1);
		o1.setTipoPublicacion(tp1);
		
		postulacion1 = new Postulacion(f1,"sou un cv","soy una motivacion",p1,o1);
		try {
			cu.agregarPostulacionAPostulante(p1.getNickName(),postulacion1);
		} catch (yaExistePostulacionAOfertaException e) {
			// TODO Auto-generated catch block
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

		
			cu.altaUsuarioPostulante(nickName, nombre, apellido, email, fecha111, nacionalidad);
			cu.altaUsuarioEmpresa(nickName2, nombre2, apellido2, email2, descripcion, web);
			Postulante p = mu.obtenerPostulante(nickName);
			Empresa e = (Empresa) mu.obtenerEmpresa(nickName2);
			DataUsuario pruebaDataPos = cu.listarInfoUser(nickName);
			DataEmpresa pruebaDataEmp = new DataEmpresa("McDonalds", "Ronald", "ElDonal", "cajitaFeliz@gmail.com", "Comida rapida", "www.mCDonalds.com");
			
			Map<String, OfertaLaboral> mapaOfEmpresa =  cu.obtenerOfertarDeEmpresa(pruebaDataEmp);
			OfertaLaboral pruebaEncuentro = mapaOfEmpresa.get("Desarolaldor Frontend");
			assertEquals("Desarolaldor Frontend",pruebaEncuentro.getNombreOferta());
			
			
			assertEquals(nickName,pruebaDataPos.getNickName());
			assertEquals(nickName, p.getNickName());
			assertEquals(nickName2, e.getNickName());
			assertEquals(nombre, p.getNombre());
			assertEquals(nombre2, e.getNombre());
			assertEquals(apellido, p.getApellido());
			assertEquals(apellido2, e.getApellido());
			assertEquals(email, p.getEmail());
			assertEquals(email2, e.getEmail());
			assertEquals(fecha111, p.getNacimineto());
			assertEquals(descripcion, e.getDescripcion());
			assertEquals(nacionalidad, p.getNacionalidad());
			assertEquals(web, e.getLinkWeb());
			
			
	
		
	
		
	}
	
	@Test
	
	void postulanteRepetido() throws NicknameYaExisteException, EmailYaExisteException, campoInvalidoException{
		LocalDate n1 = LocalDate.of(1995, 5, 1);
		IControladorUsuario cu = Fabrica.getInstance().getInUser();
	    //ESTO LO QUE HACE ES FIJARSE SI PASA LA EXCEPCION QUE PONGO DENTRO DEL ASSERTTHROWS
		//SI OCURRE LA EXCEPCION EL TEST VA A SALIR BIEN LUEGO EN LOS SIGUIENTES TEST DE ABAJO HAGO LO MISMO CON OTRAS EXC
	    assertThrows(NicknameYaExisteException.class, () -> {
	        cu.altaUsuarioPostulante("Pedro", "holaworld", "apellido", "nombreInva@gmail.com",n1, "www.noFunc.com");
	    });
	}
	
	
	
	

	
	
	
	
	@Test
	
	void empresaRepetido() throws NicknameYaExisteException, EmailYaExisteException, campoInvalidoException{
		IControladorUsuario cu = Fabrica.getInstance().getInUser();
	    
	    assertThrows(NicknameYaExisteException.class, () -> {
	        cu.altaUsuarioEmpresa("McDonalds", "holaworld", "apellido", "nombreInva@gmail.com","No deberia funcionar", "www.noFunc.com");
	    });
	}
	

	@Test
	void darDeAltaNickInvalidoEmp() throws campoInvalidoException, NicknameYaExisteException, EmailYaExisteException{
		IControladorUsuario cu = Fabrica.getInstance().getInUser();
	    
	    assertThrows(campoInvalidoException.class, () -> {
	        cu.altaUsuarioEmpresa("", "holaworld", "apellido", "nombreInva@gmail.com","No deberia funcionar", "www.noFunc.com");
	    });
	}

	@Test
	void darDeAltaeNickInvalidoPost() throws campoInvalidoException, NicknameYaExisteException, EmailYaExisteException{
		IControladorUsuario cu = Fabrica.getInstance().getInUser();
		LocalDate n1 = LocalDate.of(1995, 5, 1);
		assertThrows(campoInvalidoException.class, () -> {
			cu.altaUsuarioPostulante("", "prueba", "nacInv", "nacInv@gmail.com",n1 , "");
		});
	}
	
	@Test 
	void darAltaNombreInvalidoPost()throws campoInvalidoException, NicknameYaExisteException, EmailYaExisteException{
		IControladorUsuario cu = Fabrica.getInstance().getInUser();
		LocalDate n1 = LocalDate.of(1995, 5, 1);
		assertThrows(campoInvalidoException.class, () -> {
			cu.altaUsuarioPostulante("holamundo", "", "nacInv", "nacInv@gmail.com",n1 , "");
		});

		
	}
	
	@Test
	@DisplayName("Prueba de alta con nombre de empresa inválido")
	void darAltaNombreInvalidoEmp() {
	    IControladorUsuario cu = Fabrica.getInstance().getInUser();
	    
	    assertThrows(campoInvalidoException.class, () -> {
	        cu.altaUsuarioEmpresa("prueba5", "", "apellido", "nombreInva@gmail.com","No deberia funcionar", "www.noFunc.com");
	    });
	}


	
	@Test
	@DisplayName("Prueba de alta con apellido de empresa inválido")
	void darAltaApellidoInvalidoEmp1() {
	    IControladorUsuario cu = Fabrica.getInstance().getInUser();
	    
	    assertThrows(campoInvalidoException.class, () -> {
	        cu.altaUsuarioEmpresa("prueba5", "", "apellido", "nombreInva@gmail.com","No deberia funcionar", "www.noFunc.com");
	    });
	}
	
	
	@Test
	void darAltaEmailInvalidoPost()throws campoInvalidoException, NicknameYaExisteException, EmailYaExisteException{
		
		IControladorUsuario cu = Fabrica.getInstance().getInUser();
	    
	    assertThrows(campoInvalidoException.class, () -> {
	        cu.altaUsuarioEmpresa("prueba5", "hola", "apellido", "","No deberia funcionar", "www.noFunc.com");
	    });
	}
	
	
	@Test
	void darAltaDescripcionInvalido()throws campoInvalidoException, NicknameYaExisteException, EmailYaExisteException{
		IControladorUsuario cu = Fabrica.getInstance().getInUser();
	    
	    assertThrows(campoInvalidoException.class, () -> {
	        cu.altaUsuarioEmpresa("prueba5", "hola", "apellido", "hola","", "www.noFunc.com");
	    });
		
	}
	
	@Test
	void darAltaNacionalidadInvalido()throws campoInvalidoException, NicknameYaExisteException, EmailYaExisteException{
		IControladorUsuario cu = Fabrica.getInstance().getInUser();
		LocalDate n1 = LocalDate.of(1995, 5, 1);
		assertThrows(campoInvalidoException.class, () -> {
			cu.altaUsuarioPostulante("prueba", "prueba", "nacInv", "nacInv@gmail.com",n1 , "");
		});
	}
	
	@Test
	void testeoDelEmailYaExiste()throws campoInvalidoException, NicknameYaExisteException, EmailYaExisteException{
		IControladorUsuario cu = Fabrica.getInstance().getInUser();
		LocalDate n1 = LocalDate.of(1995, 5, 1);
		assertThrows(EmailYaExisteException.class, () -> {
			cu.altaUsuarioPostulante("prueba", "prueba", "nacInv", "pepi@gmail.com",n1 , "");
		});
	}
	
	@Test
	void darAltaLinkInvalido()throws campoInvalidoException, NicknameYaExisteException, EmailYaExisteException{
IControladorUsuario cu = Fabrica.getInstance().getInUser();
	    
	    assertThrows(campoInvalidoException.class, () -> {
	        cu.altaUsuarioEmpresa("prueba5", "hola", "apellido", "hola","hola", "");
	    });
	}
	
	@Test
	void testListarUsuarios() throws UsuarioNoExisteException {
		Set<DataUsuario> usuarios = cu.getDataUsuarios();
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
		Set<DataPostulante> postulantes = cu.getDataPostulante();
		
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
		Set<DataEmpresa> empresas = cu.getDataEmpresa();
		
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

}