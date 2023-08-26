package test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertEquals;


import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Set;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import excepciones.EmailYaExisteException;
import excepciones.NicknameYaExisteException;
import excepciones.UsuarioNoExisteException;
import excepciones.campoInvalidoException;
import logica_Controladores.IControladorUsuario;
import logica_DataTypes.DataEmpresa;
import logica_DataTypes.DataPostulante;
import logica_DataTypes.DataUsuario;
import logica_Entidades.Postulante;
import logica_Entidades.Usuario;
import logica_Entidades.Empresa;
import logica_Manejadores.IManejadorUsuario;
import utils.Fabrica;

class controladorUsuarioTest {

	private static IControladorUsuario cu;
	private static IManejadorUsuario mu;
	private static Postulante p1;
	private static Postulante p2;
	private static Empresa e1;
	private static Empresa e2;
	
	@BeforeAll
	public static void setUpBeforeClass() {
		Fabrica f = Fabrica.getInstance();
		cu = f.getInUser();
		mu = f.getInManejadorUsuario();
		LocalDate f1 = LocalDate.of(1990,01,01);
		LocalDate f2 = LocalDate.of(1990,05,01);
		p1 = new Postulante("Pedro", "Herni", "pepi", "pepi@gmail.com", f1, "Uru");
		p2 = new Postulante("Maria", "Lopes", "mari", "marilaosa@gmail.com", f2, "Esp");
		e1 = new Empresa("McDonalds", "Ronald", "ElDonal", "cajitaFeliz@gmail.com", "Comida rapida", "www.mCDonalds.com");
		e2 = new Empresa("LifeCinema", "vida", "cine", "noMirenCuevana@gmail.com", "Descuentos con tarjetas seleccionadas", "www.lifeCinemas.com");
		mu.addUsuario(e1);
		mu.addUsuario(e2);
		mu.addUsuario(p1);
		mu.addUsuario(p2);
	}

	@Test
	void registroEsExitoso() throws NicknameYaExisteException, campoInvalidoException{
		//para un postulante
		String nickName = "Jofe";
		String nombre = "Josefina";
		String apellido = "Hernandez";
		Date fechaNac = new Date(2, 5, 1987);
		String email = "holaComoEstas@gmail.com";
		String nacionalidad = "Colombia";
		
		//para la empresa
		String nickName2 = "Lulu";
		String nombre2 = "Luna";
		String apellido2 = "Gomez";
		String web = "www.luluG.com.uy";
		String email2 = "luliGmez@gmail.com";
		String descripcion = "contratamos gente";
		
		try {
			cu.altaUsuarioPostulante(nickName, nombre, apellido, email, fechaNac, nacionalidad);
			cu.altaUsuarioEmpresa(nickName2, nombre2, apellido2, email2, descripcion, web);
			Postulante p = mu.obtenerPostulante(nickName);
			Empresa e = (Empresa) mu.obtenerEmpresa(nickName2);
			
			
			assertEquals(nickName, p.getNickName());
			assertEquals(nickName2, e.getNickName());
			assertEquals(nombre, p.getNombre());
			assertEquals(nombre, e.getNombre());
			assertEquals(apellido, p.getApellido());
			assertEquals(apellido, e.getApellido());
			assertEquals(email, p.getEmail());
			assertEquals(email, e.getEmail());
			assertEquals(fechaNac, p.getNacimineto());
			assertEquals(descripcion, e.getDescripcion());
			assertEquals(nacionalidad, p.getNacionalidad());
			assertEquals(web, e.getLinkWeb());
			
			
		}catch(NicknameYaExisteException | EmailYaExisteException e){ 
			fail(e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	@Test
	
	void postulanteRepetido() throws NicknameYaExisteException, EmailYaExisteException, campoInvalidoException{
		Date n1 = new Date(15,03,1985);
		try {
		cu.altaUsuarioPostulante("lgarcia","Lucia","Garcia","lgarcia85@gmail.com",n1,"Uruguaya");
		}catch(NicknameYaExisteException | EmailYaExisteException e) {
			fail(e.getMessage());
			e.printStackTrace();
		}
	}
	

	@Test
	
	void empresaRepetido() throws NicknameYaExisteException, EmailYaExisteException, campoInvalidoException{
		try {
		cu.altaUsuarioEmpresa("EcoTech","Sophia","Johnosn","info@EcoTehc.com","EcoTech Innovations es una empresa lider en soluciones tecnol´ogicas sostenibles. Nuestro enfoque se centra en desarrollar y comercializar productos y servicios que aborden los desafios ambientales mas apremiantes de nuestro tiempo. Desde sistemas de energıa renovable y dispositivos de monitorizacion ambiental hasta soluciones de gestion de residuos inteligentes, nuestra mision es proporcionar herramientas que permitan a las empresas y comunidades adoptar practicas mas ecologicas sin comprometer la eficiencia. Creemos en la convergencia armoniosa entre la tecnologia y la naturaleza, y trabajamos incansablemente para impulsar un futuro mas limpio y sostenible.","http://www.EcoTechInnovations.com");
		}catch(NicknameYaExisteException | EmailYaExisteException e) {
			fail(e.getMessage());
			e.printStackTrace();
		}
	}
	
	@Test
	void darDeAltaNickInvalidoEmp() throws campoInvalidoException, NicknameYaExisteException, EmailYaExisteException{
		try {
			cu.altaUsuarioEmpresa("", "prueba", "nickInv", "nickInva@gmail.com", "No deberia funcionar", "www.noFunc.com");
		}catch(campoInvalidoException e){
			fail(e.getMessage());
		}
	}

	@Test
	void darDeAltaeNickInvalidoPost() throws campoInvalidoException, NicknameYaExisteException, EmailYaExisteException{
		Date n1 = new Date(15,03,1985);
		try {
			cu.altaUsuarioPostulante("", "prueba", "nickInv", "nickInva@gmail.com", n1, "PaisInv");
		}catch(campoInvalidoException e){
			fail(e.getMessage());
		}
	}
	
	@Test 
	void darAltaNombreInvalidoPost()throws campoInvalidoException, NicknameYaExisteException, EmailYaExisteException{
		Date n1 = new Date(15,03,1985);
		try {
			cu.altaUsuarioPostulante("prueba", "", "nombreInv", "nombreInva@gmail.com", n1, "PaisInv");
		}catch(campoInvalidoException e){
			fail(e.getMessage());
		}
	}
	
	@Test 
	void darAltaNombreInvalidoEmp()throws campoInvalidoException, NicknameYaExisteException, EmailYaExisteException{
		try {
			cu.altaUsuarioEmpresa("prueba", "", "nombreInv", "nombreInva@gmail.com","No deberia funcionar", "www.noFunc.com");
		}catch(campoInvalidoException e){
			fail(e.getMessage());
		}
	}
	
	@Test
	void darAltaApellidoInvalidoPost()throws campoInvalidoException, NicknameYaExisteException, EmailYaExisteException{
		Date n1 = new Date(15,03,1985);
		try {
			cu.altaUsuarioPostulante("prueba", "apellidoInt", "", "apellidoInva@gmail.com", n1, "PaisInv");
		}catch(campoInvalidoException e){
			fail(e.getMessage());
		}
	}
	
	@Test
	void darAltaApellidoInvalidoEmp()throws campoInvalidoException, NicknameYaExisteException, EmailYaExisteException{
		try {
			cu.altaUsuarioEmpresa("prueba", "apellidoInt", "", "apellidoInva@gmail.com", "No deberia funcionar", "www.noFunc.com");
		}catch(campoInvalidoException e){
			fail(e.getMessage());
		}
	}
	
	@Test
	void darAltaEmailInvalidoPost()throws campoInvalidoException, NicknameYaExisteException, EmailYaExisteException{
		Date n1 = new Date(15,03,1985);
		try {
			cu.altaUsuarioPostulante("prueba", "prueba", "emailInv", "", n1, "PaisInv");
		}catch(campoInvalidoException e){
			fail(e.getMessage());
		}
	}
	
	@Test
	void darAltaEmailInvalidoEmp()throws campoInvalidoException, NicknameYaExisteException, EmailYaExisteException{
		try {
			cu.altaUsuarioEmpresa("prueba", "prueba", "emailInv", "", "invalido", "www.esInv.com");
		}catch(campoInvalidoException e){
			fail(e.getMessage());
		}
	}
	
	@Test
	void darAltaDescripcionInvalido()throws campoInvalidoException, NicknameYaExisteException, EmailYaExisteException{
		try {
			cu.altaUsuarioEmpresa("prueba", "prueba", "descInv", "descInv@gmail.com", "", "www.esInv.com");
		}catch(campoInvalidoException e){
			fail(e.getMessage());
		}
	}
	
	@Test
	void darAltaNacionalidadInvalido()throws campoInvalidoException, NicknameYaExisteException, EmailYaExisteException{
		Date n1 = new Date(15,03,1985);
		try {
			cu.altaUsuarioPostulante("prueba", "prueba", "nacInv", "nacInv@gmail.com",n1 , "");
		}catch(campoInvalidoException e){
			fail(e.getMessage());
		}
	}
	
	@Test
	void darAltaLinkInvalido()throws campoInvalidoException, NicknameYaExisteException, EmailYaExisteException{
		try {
			cu.altaUsuarioEmpresa("prueba", "prueba", "descInv", "linkInv@gmail.com", "linkInv", "");
		}catch(campoInvalidoException e){
			fail(e.getMessage());
		}
	}

	@Test
	void darAltaFechaInvalidaPost() throws NicknameYaExisteException, EmailYaExisteException, campoInvalidoException{
		try {
	 	cu.altaUsuarioPostulante("prueba", "prueba", "fechaInv", "fechaIn@gmail.com", null, "Francia");
		}catch(campoInvalidoException e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	void testListarUsuarios() throws UsuarioNoExisteException {
		Set<DataUsuario> usuarios = cu.getDataUsuarios();
		
		assertTrue(usuarios.contains(e1));
		assertTrue(usuarios.contains(e2));
		assertTrue(usuarios.contains(p2));
		assertTrue(usuarios.contains(p1));
		
	}

	@Test
	void testListarPostulantes() {
		Set<DataPostulante> postulantes = cu.getDataPostulante();
		
		assertTrue(postulantes.contains(p1));
		assertTrue(postulantes.contains(p2));
	}
	
	@Test
	void testListaEmpresas() throws UsuarioNoExisteException {
		Set<DataEmpresa> empresas = cu.getDataEmpresa();
		
		assertTrue(empresas.contains(e1));
		assertTrue(empresas.contains(e2));
		
	}


}
