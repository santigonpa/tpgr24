package com.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import com.model.EstadoSesion;
import utils.Fabrica;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import logica_Entidades.Empresa;
import logica_Entidades.KeyWord;
import logica_Entidades.OfertaLaboral;
import logica_Entidades.OfertaLaboral.EstadoOferta;
import logica_Entidades.Paquete;
import logica_Entidades.Postulacion;
import logica_Entidades.Postulante;
import logica_Entidades.TipoPublicacion;
import logica_Entidades.Usuario;
import logica_Manejadores.IManejadorOferta;
import logica_Manejadores.IManejadorPyT;
import logica_Manejadores.IManejadorUsuario;



/**
 * Servlet implementation class Home
 */
@WebServlet (description = "Servlet para la carga de datos", urlPatterns = { "/CargarDatos" })
public class ServletCargarDatos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public ServletCargarDatos() {
        super();
    }
    private static boolean datosCargados = false; // Bandera para verificar si los datos ya se cargaron

    public void init() throws ServletException {
    
    }
    
    public static void iniciarLaSession(HttpServletRequest request) {
		HttpSession session = request.getSession();
		//si la sesion no esta creada, crea una la cual le pone el estado de no logeado, si esta logeado mantiene su usuario
		if (session.getAttribute("estadoSesion") == null) {
			session.setAttribute("estadoSesion", EstadoSesion.NO_LOGEADO);
		}
	}
    
    public static EstadoSesion getEstado(HttpServletRequest request){	
    	//obtiene el tipo de la sesion
		return (EstadoSesion) request.getSession().getAttribute("estadoSesion");
	}
    
    
    private void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    	
    	iniciarLaSession(request); // inicializa la sesion, le pone el atributo donde va (ver codigo arriba)
		
		switch (getEstado(request)){
			
		case NO_LOGEADO:
				// hace que se ejecute el jsp sin cambiar la url
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/home/iniciar.jsp"); //obtiene dispatcher construido con la ruta
				dispatcher.forward(request, response); // envia los datos hacia la ruta con el request y response
				break;
		case SI_LOGEADO:
				// hace que se ejecute el jsp sin cambiar la url
				RequestDispatcher dispatcher2 = request.getRequestDispatcher("/WEB-INF/home/iniciarLogged.jsp"); //obtiene dispatcher construido con la ruta
				dispatcher2.forward(request, response); // envia los datos hacia la ruta con el request y response
				break;
		default:
			break;
		}
	}
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
		if (!datosCargados) {
            datosCargados = true; // Establece la bandera en true para indicar que los datos se han cargado
            
            
			Fabrica fabrica = Fabrica.getInstance();
			IManejadorUsuario mu = fabrica.getInManejadorUsuario();
			IManejadorOferta mo = fabrica.getInManejadorOferta();
			IManejadorPyT mpyt = fabrica.getInManejadorPyT();
					
			
			//------------------------------//
			//Carga de usuarios
			
			//Cambio formato a LocalDate
			DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			LocalDate n1 = LocalDate.parse("15-03-1985", dateFormatter);
			LocalDate n2 = LocalDate.parse("21-08-1990", dateFormatter);
			LocalDate n3 = LocalDate.parse("10-11-1988", dateFormatter);
			LocalDate n4 = LocalDate.parse("05-06-1993", dateFormatter);
			LocalDate n5 = LocalDate.parse("25-02-1987", dateFormatter);
			LocalDate n6 = LocalDate.parse("12-04-1992", dateFormatter);
			LocalDate n7 = LocalDate.parse("30-09-1989", dateFormatter);
			LocalDate n8 = LocalDate.parse("18-01-1995", dateFormatter);
			LocalDate n9 = LocalDate.parse("07-07-1991", dateFormatter);
			LocalDate n10 = LocalDate.parse("02-12-1986", dateFormatter);
			
			ServletContext context = getServletContext();
	
	        // Obtiene la ruta de ejecución del servlet
	        String rutaEjecucion = context.getRealPath("media/img/");
	        System.out.println(rutaEjecucion);
	    	 
			//Cambio de https a Byte
			byte[] imagen1 = cargarImagenEnBytes(rutaEjecucion + "U1.jpg");
			byte[] imagen2 = cargarImagenEnBytes(rutaEjecucion + "U2.jpg");
			byte[] imagen3 = cargarImagenEnBytes(rutaEjecucion + "U3.jpg");
			byte[] imagen4 = cargarImagenEnBytes(rutaEjecucion + "U4.jpg");
			byte[] imagen5 = cargarImagenEnBytes(rutaEjecucion + "U5.jpg");
			byte[] imagen6 = cargarImagenEnBytes(rutaEjecucion + "U6.jpg");
			byte[] imagen7 = cargarImagenEnBytes(rutaEjecucion + "U7.jpg");
			byte[] imagen8 = cargarImagenEnBytes(rutaEjecucion + "U8.jpg");
			byte[] imagen9 = cargarImagenEnBytes(rutaEjecucion + "U9.jpg");
			byte[] imagen10= cargarImagenEnBytes(rutaEjecucion + "U10.jpg");
			byte[] imagen11 = cargarImagenEnBytes(rutaEjecucion + "U11.jpg");
			byte[] imagen12 = cargarImagenEnBytes(rutaEjecucion + "U12.jpg");
			byte[] imagen13 = cargarImagenEnBytes(rutaEjecucion + "U13.jpg");
			byte[] imagen14 = cargarImagenEnBytes(rutaEjecucion + "U14.jpg");
			byte[] imagen15 = cargarImagenEnBytes(rutaEjecucion + "U15.jpg");
			byte[] imagen16 = cargarImagenEnBytes(rutaEjecucion + "U16.jpg");
			
			//Creo Postulantes
			Usuario p1 = new Postulante("lgarcia", "Lucia", "Garcia", "lgarcia85@gmail.com", n1, "Uruguaya", imagen1, "awdrg543");
			Usuario p2 = new Postulante("matilo","Matias","Lopez","matias.lopez90@hotmail.com",n2,"Argentina",imagen2,"edrft543");
			Usuario p3 = new Postulante("maro","Maria","Rodriguez","marrod@gmail.com",n3,"Uruguaya",imagen3,"r5t6y7u8");
			Usuario p4 = new Postulante("javierf","Javier","Fernandez","javierf93@yahoo.com",n4,"Mexicana",imagen4,"45idgaf67");
			Usuario p5 = new Postulante("valen25","Valentina","Martinez","vale87@gmail.com",n5,"Uruguaya",imagen5,"poiuy987");
			Usuario p6 = new Postulante("andpel2","Andres","Perez","anpe92@hotmail.com",n6,"Chilena",imagen6,"xdrgb657");
			Usuario p7 = new Postulante("sicam","Camila","Silva","camisilva89@gmail.com",n7,"Uruguaya",imagen7,"mnjkiu89");
			Usuario p8 = new Postulante("sebgon","Sebastian","Gonzalez","gonza95@yahoo.com",n8,"Colombiana",imagen8,"ytrewq10");
			Usuario p9 = new Postulante("isabel","Isabella","Lopez","loisa@gmail.com",n9,"Uruguaya",imagen9,"sbsplol1");
			Usuario p10 = new Postulante("marram02","Martin","Ramirez","marram@hotmail.com",n10,"Argentina",imagen10,"okmnji98");
			
			//Creo Empresas
			Empresa e1 = new Empresa("EcoTech","Sophia","Johnosn","info@EcoTehc.com","EcoTech Innovations es una empresa lider en soluciones tecnol´ogicas sostenibles. Nuestro enfoque se centra en desarrollar y comercializar productos y servicios que aborden los desafios ambientales mas apremiantes de nuestro tiempo. Desde sistemas de energıa renovable y dispositivos de monitorizacion ambiental hasta soluciones de gestion de residuos inteligentes, nuestra mision es proporcionar herramientas que permitan a las empresas y comunidades adoptar practicas mas ecologicas sin comprometer la eficiencia. Creemos en la convergencia armoniosa entre la tecnologia y la naturaleza, y trabajamos incansablemente para impulsar un futuro mas limpio y sostenible.","http://www.EcoTechInnovations.com",imagen11,"qsxcdw43");
			Empresa e2 = new Empresa("FusionTech","William","Smith","contacto@FusionTech.net","FusionTech Dynamics es una empresa pionera en el ambito de la inteligencia artificial y la automatizacion avanzada. Nuestro equipo multidisciplinario de ingenieros, cientificos de datos y desarrolladores crea soluciones innovadoras que aprovechan la potencia de la IA para transformar industrias. Desde la optimizacion de procesos industriales hasta la creacion de asistentes virtuales altamente personalizados, nuestro objetivo es revolucionar la forma en que las empresas operan y se conectan con sus clientes. Creemos en la sinergia entre la mente humana y las capacidades de la IA, y trabajamos para construir un mundo donde la tecnologia mejore y amplie nuestras capacidades innatas.","http://www.FusionTechDynamics.net",imagen12,"qpwoei586");
			Empresa e3 = new Empresa("GlobalHealth","Isabella","Brown","jobs@GlobalHelath.uy","GlobalHealth Dynamics es una empresa comprometida con el avance de la atencion medica a nivel mundial. Como lideres en el campo de la salud digital, desarrollamos plataformas y herramientas que permiten a los profesionales de la salud ofrecer diagnosticos mas precisos, tratamientos personalizados y seguimiento continuo de los pacientes. Nuestra vision es crear un ecosistema de salud conectado en el que los datos medicos se utilicen de manera etica y segura para mejorar la calidad de vida de las personas. A traves de la innovacion constante y la colaboracion con expertos medicos, estamos dando forma al futuro de la atencion medica, donde la tecnologia y la compasion se unen parasalvar vidas y mejorar el bienestar en todo el mundo.","http://www.globalhealthdynamics.uy/info",imagen13,"asdfg654");
			Empresa e4 = new Empresa("ANTEL","Washington","Rocha","jarrington@ANTEL.com.uy","En Antel te brindamos servicios de vanguardia en tecnologia de comunicacion en Telefonia Movil, Fija, Banda Ancha y Datos","ANTEL.com.uy",imagen14,"2nru096");
			Empresa e5 = new Empresa("MIEM","Pablo","Bengoechea","eldiez@MIEM.org.uy","Balance Energetico Nacional (BEN). La Direccion Nacional de Energia (DNE) del Ministerio de Industria, Energia y Mineria (MIEM) presenta anualmente el BEN.","MIEM.com.uy",imagen15,"ibii4xo");
			Empresa e6 = new Empresa("TechSolutions","Mercedes","Venn","Mercedes@TechSolutions.com.uy", "”TechSolutions Inc.” es una empresa lider en el sector de tecnologia de la informacion y el software. Se especializa en el desarrollo de soluciones de software personalizadas para empresas de diversos tamanos y sectores. Su enfoque se centra en la creacion de aplicaciones empresariales innovadoras que optimizan procesos, mejoran la eficiencia y brindan una ventaja competitiva a sus clientes.","TechSolutions.com",imagen16,"1ngs03p");
			
			//Agrego Usarios
			mu.addUsuario(p1);
			mu.addUsuario(p2);
			mu.addUsuario(p3);
			mu.addUsuario(p4);
			mu.addUsuario(p5);
			mu.addUsuario(p6);
			mu.addUsuario(p7);
			mu.addUsuario(p8);
			mu.addUsuario(p9);
			mu.addUsuario(p10);
			mu.addUsuario(e1);
			mu.addUsuario(e2);
			mu.addUsuario(e3);
			mu.addUsuario(e4);
			mu.addUsuario(e5);
			mu.addUsuario(e6);
			
			//------------------------------//		
			
			//Cargo Tipos de Publicacion
			
			//Cambio a LocalDate fecha de alta, fala agregarla a los parametros
			LocalDate at1 = LocalDate.parse("10-08-2023", dateFormatter);
			LocalDate at2 = LocalDate.parse("05-08-2023", dateFormatter);
			LocalDate at3 = LocalDate.parse("15-08-2023", dateFormatter);
			LocalDate at4 = LocalDate.parse("07-08-2023", dateFormatter);
			
			//Creo Tipos
			TipoPublicacion tp1 = new TipoPublicacion("Premium","Obten maxima visibilidad.",1,30,4000,at1);
			TipoPublicacion tp2 = new TipoPublicacion("Destacada","Destaca tu anuncio",2,15,500,at2);
			TipoPublicacion tp3 = new TipoPublicacion("Estandar","Mejora la posicion de tu anuncio",3,20,150,at3);
			TipoPublicacion tp4 = new TipoPublicacion("Basica","Publica de forma sencilla en la lista de ofertas",4,7,50,at4);
			
			//Agrego Tipos
			
			mpyt.addTipoPublicacion(tp1);
			mpyt.addTipoPublicacion(tp2);
			mpyt.addTipoPublicacion(tp3);
			mpyt.addTipoPublicacion(tp4);
	
			
			//Cargo Keywords
			KeyWord k1 = new KeyWord("Tiempo completo");
			KeyWord k2 = new KeyWord("Medio tiempo");
			KeyWord k3 = new KeyWord("Remoto");
			KeyWord k4 = new KeyWord("Freelance");
			KeyWord k5 = new KeyWord("Temporal");
			KeyWord k6 = new KeyWord("Permanente");
			KeyWord k7 = new KeyWord("Computacion");
			KeyWord k8 = new KeyWord("Administracion");
			KeyWord k9 = new KeyWord("Logistica");
			KeyWord k10 = new KeyWord("Contabilidad");
			
			//Agrego Kewword
		
			mo.addKeyword(k1);
			mo.addKeyword(k2);
			mo.addKeyword(k3);
			mo.addKeyword(k4);
			mo.addKeyword(k5);
			mo.addKeyword(k6);
			mo.addKeyword(k7);
			mo.addKeyword(k8);
			mo.addKeyword(k9);
			mo.addKeyword(k10);
	
			
			//Agrego Ofertas Laborales
			
			//Convierto las horas a LocalTime
			//Hora inicio
			LocalTime hi1 = LocalTime.parse("09:00");
			LocalTime hi2 = LocalTime.parse("08:00");
			LocalTime hi3 = LocalTime.parse("14:00");
			LocalTime hi4 = LocalTime.parse("09:00");
			LocalTime hi5 = LocalTime.parse("18:00");
			LocalTime hi6 = LocalTime.parse("09:00");
			LocalTime hi7 = LocalTime.parse("10:00");
			LocalTime hi8 = LocalTime.parse("08:30");
			LocalTime hi9 = LocalTime.parse("09:00");
			//LocalTime hi10 = LocalTime.parse("09:00");
			//LocalTime hi11 = LocalTime.parse("04:00");
			//LocalTime hi12 = LocalTime.parse("04:00");
			//LocalTime hi13 = LocalTime.parse("14:00");
			//HoraFinal
			LocalTime hf1 = LocalTime.parse("18:00");
			LocalTime hf2 = LocalTime.parse("17:00");
			LocalTime hf3 = LocalTime.parse("18:00");
			LocalTime hf4 = LocalTime.parse("13:00");
			LocalTime hf5 = LocalTime.parse("22:00");
			LocalTime hf6 = LocalTime.parse("18:00");
			LocalTime hf7 = LocalTime.parse("19:00");
			LocalTime hf8 = LocalTime.parse("17:30");
			LocalTime hf9 = LocalTime.parse("17:00");
			LocalTime hf10 = LocalTime.parse("16:00");
			LocalTime hf11 = LocalTime.parse("13:00");
			LocalTime hf12 = LocalTime.parse("12:00");
			LocalTime hf13 = LocalTime.parse("18:00");
			
			
			//Convierto las Fechas
	
			LocalDate ao1 = LocalDate.of(2023,9,30);
			LocalDate ao2 = LocalDate.of(2023,9,29);
			LocalDate ao3 = LocalDate.of(2023,9,29);
			LocalDate ao4 = LocalDate.of(2023,9,19);
			LocalDate ao5 = LocalDate.of(2023,10,2);
			LocalDate ao6 = LocalDate.of(2023,9,21);
			LocalDate ao7 = LocalDate.of(2023,10,2);
			LocalDate ao8 = LocalDate.of(2023,9,29);
			LocalDate ao9 = LocalDate.of(2023,9,29);
			LocalDate ao10 = LocalDate.of(2023,10,2);
			LocalDate ao11 = LocalDate.of(2023,9,25);
			LocalDate ao12 = LocalDate.of(2023,10,2);
			LocalDate ao13 = LocalDate.of(2023,10,1);
			
			
			//imagenes de ofertas laborales
			//Cambio de https a Byte
			byte[] imagen01 = cargarImagenEnBytes(rutaEjecucion + "O1.jpg");
			byte[] imagen22 = cargarImagenEnBytes(rutaEjecucion + "O2.jpg");
			byte[] imagen33 = cargarImagenEnBytes(rutaEjecucion + "O3.jpg");
			byte[] imagen44 = cargarImagenEnBytes(rutaEjecucion + "O4.jpg");
			byte[] imagen55 = cargarImagenEnBytes(rutaEjecucion + "O5.jpg");
			byte[] imagen66 = cargarImagenEnBytes(rutaEjecucion + "O6.jpg");
			byte[] imagen77 = cargarImagenEnBytes(rutaEjecucion + "O7.jpg");
			byte[] imagen88 = cargarImagenEnBytes(rutaEjecucion + "O8.jpg");
			byte[] imagen99 = cargarImagenEnBytes(rutaEjecucion + "O9.jpg");
			//byte[] imagen100= cargarImagenEnBytes(rutaEjecucion + "O10.jpg");
			//byte[] imagen111 = cargarImagenEnBytes(rutaEjecucion + "O11.jpg");
			//byte[] imagen122 = cargarImagenEnBytes(rutaEjecucion + "O12.jpg");
			//byte[] imagen133 = cargarImagenEnBytes(rutaEjecucion + "O13.jpg");
			
			
			
			//Creo Oferta   // FALTAN OFERTAS 
			OfertaLaboral o1 = new OfertaLaboral("Desarrollador Frontend","Unete a nuestro equipo de desarrollo frontend y crea experiencias de usuario excepcionales.","Montevideo","Montevideo",hi1,hf1,90000,4000,ao1,imagen01);
			OfertaLaboral o2 = new OfertaLaboral("Estrategia de Negocios","Forma parte de nuestro equipo de estrategia y contribuye al crecimiento de las empresas clientes","Punta del Este","Maldonado",hi2,hf2,80000,150,ao2,imagen22);
			OfertaLaboral o3 = new OfertaLaboral("Disenador UX/UI","Trabaja en colaboracion con nuestro talentoso equipo de dise˜no para crear soluciones impactantes.","Rosario","Colonia",hi3,hf3,65000,150,ao3,imagen33);
			OfertaLaboral o4 = new OfertaLaboral("Analista de Datos","Ayuda a nuestros clientes a tomar decisiones informadas basadas en an´alisis y visualizaciones de datos.","Maldonado","Maldonado",hi4,hf4,40000,4000,ao4,imagen44);
			OfertaLaboral o5 = new OfertaLaboral("Content Manager","Gestiona y crea contenido persuasivo y relevante para impulsar la presencia en linea de nuestros clientes.","Montevideo","Montevideo",hi5,hf5,10000,500,ao5,imagen55);
			OfertaLaboral o6 = new OfertaLaboral("Soporte Tecnico","Ofrece un excelente servicio de soporte t´ecnico a nuestros clientes, resolviendo problemas y brindando soluciones.","Minas","Lavalleja",hi6,hf6,30000,50,ao6,imagen66);
			OfertaLaboral o7 = new OfertaLaboral("A. de Marketing Digital","Unete a nuestro equipo de marketing y trabaja en estrategias digitales innovadoras.","Flores","Flores",hi7,hf7,80000,4000,ao7,imagen77);
			OfertaLaboral o8 = new OfertaLaboral("Contador Senior","Unete a nuestro equipo contable y ayuda en la gestion financiera de la empresa.","Colonia Suiza","Colonia",hi8,hf8,10000,500,ao8,imagen88);
			OfertaLaboral o9 = new OfertaLaboral("Técnico/a Básico Red","RÉGIMEN DE CONTRATO EN FUNCIÓN PÚBLICA EN UN TODO DE ACUERDO CON LA NORMATIVA VIGENTE (LEY 16.127, DEL 7 DE AGOSTO DE 1990, ARTÍCULO 1°, LITERAL A) Y B), CON LA MODIFICACIÓN INTRODUCIDA POR EL ARTÍCULO 11 DE LA LEY 17.930, DEL 19 DE DICIEMBRE DE 2005).","Paysandú","Paysandú",hi9,hf9,40000,500,ao9,imagen99);
			
			//Agrego oferta a Empresa
			e1.agregarOfertas(o1.getNombreOferta(),o1);
			e3.agregarOfertas(o2.getNombreOferta(),o2);
			e2.agregarOfertas(o3.getNombreOferta(),o3);
			e4.agregarOfertas(o4.getNombreOferta(),o4);
			e5.agregarOfertas(o5.getNombreOferta(),o5);
			e6.agregarOfertas(o6.getNombreOferta(),o6);
			e1.agregarOfertas(o7.getNombreOferta(),o7);
			e3.agregarOfertas(o8.getNombreOferta(),o8);
			e4.agregarOfertas(o9.getNombreOferta(),o9);
			
			//Agrego Empresa a Oferta
			o1.setEmpresa((Empresa)e1);
			o2.setEmpresa((Empresa)e3);
			o3.setEmpresa((Empresa)e2);
			o4.setEmpresa((Empresa)e4);
			o5.setEmpresa((Empresa)e5);
			o6.setEmpresa((Empresa)e6);
			o7.setEmpresa((Empresa)e1);
			o8.setEmpresa((Empresa)e3);
			o9.setEmpresa((Empresa)e4);
			
			 
			
			//estado oferta 
			o1.setEstado(EstadoOferta.ACEPTADA);
			o2.setEstado(EstadoOferta.ACEPTADA);
			o3.setEstado(EstadoOferta.ACEPTADA);
			o4.setEstado(EstadoOferta.INGRESADA);
			o5.setEstado(EstadoOferta.INGRESADA);
			o6.setEstado(EstadoOferta.ACEPTADA);
			o7.setEstado(EstadoOferta.ACEPTADA);
			o8.setEstado(EstadoOferta.RECHAZADA);
			o9.setEstado(EstadoOferta.ACEPTADA);
			
			//Agrego Oferta
			mo.addOferta(o1);
			mo.addOferta(o2);
			mo.addOferta(o3);
			mo.addOferta(o4);
			mo.addOferta(o5);
			mo.addOferta(o6);
			mo.addOferta(o7);
			mo.addOferta(o8);
			
			
			//Agrego Keyword a Oferta
				
			o1.agregarKeywordAOferta(k1);
			o1.agregarKeywordAOferta(k2);
			o1.agregarKeywordAOferta(k3);
			o1.agregarKeywordAOferta(k4);
			o1.agregarKeywordAOferta(k5);
			o1.agregarKeywordAOferta(k6);
			
			o2.agregarKeywordAOferta(k5);
			
			o3.agregarKeywordAOferta(k2);
			o3.agregarKeywordAOferta(k3);
			o3.agregarKeywordAOferta(k6);
			
			o4.agregarKeywordAOferta(k2);
			
			o5.agregarKeywordAOferta(k4);
			
			o6.agregarKeywordAOferta(k1);
			
			//Agrego oferta a KeyWord
			k1.agregarOfertaAKeyWord(o1);
			k2.agregarOfertaAKeyWord(o1);
			k3.agregarOfertaAKeyWord(o1);
			k4.agregarOfertaAKeyWord(o1);
			k5.agregarOfertaAKeyWord(o1);
			k6.agregarOfertaAKeyWord(o1);
			
			k5.agregarOfertaAKeyWord(o2);
			
			k2.agregarOfertaAKeyWord(o3);
			k3.agregarOfertaAKeyWord(o3);
			k6.agregarOfertaAKeyWord(o3);
	
			k2.agregarOfertaAKeyWord(o4);
			
			k4.agregarOfertaAKeyWord(o5);
			
			k1.agregarOfertaAKeyWord(o6);
			
			//Linkeo Tipo con Oferta 
	
			o1.setTipoPublicacion(tp1);
			o2.setTipoPublicacion(tp3);
			o3.setTipoPublicacion(tp3);
			o4.setTipoPublicacion(tp1);
			o5.setTipoPublicacion(tp2);
			o6.setTipoPublicacion(tp4);
			o7.setTipoPublicacion(tp1);
			o8.setTipoPublicacion(tp2);
	
			
			//------------------------------//	
			
			//Convierto String a LocalDate
			LocalDate fPos1 = LocalDate.parse("16-08-2023", dateFormatter);
			LocalDate fPos2 = LocalDate.parse("15-08-2023", dateFormatter);
			LocalDate fPos3 = LocalDate.parse("14-08-2023", dateFormatter);
			LocalDate fPos4 = LocalDate.parse("13-08-2023", dateFormatter);
			LocalDate fPos5 = LocalDate.parse("12-08-2023", dateFormatter);
			LocalDate fPos6 = LocalDate.parse("16-08-2023", dateFormatter);
			
			
			//Creo Postulaciones
			Postulacion pos1 = new Postulacion(fPos1,"Licenciada en Administracion, experiencia en gestion de equipos y proyectos. Conocimientos en Office.","Estoy emocionada por la oportunidad de formar parte de un equipo dinamico y contribuir con mis habilidades de liderazgo.",(Postulante)p1,o1);
			Postulacion pos2 = new Postulacion(fPos2,"Estudiante de Comunicacion, habilidades en redacci´on y manejo de redes sociales. Experiencia en practicas en medios locales","Me encantaria formar parte de un equipo que me permita desarrollar mis habilidades en comunicacion y marketing.",(Postulante)p2,o2);
			Postulacion pos3 = new Postulacion(fPos3,"Ingeniero en Sistemas, experiencia en desarrollo web y aplicaciones moviles. Conocimientos en JavaScript y React.","Me entusiasma la posibilidad de trabajar en proyectos desafiantes y seguir creciendo como profesional en el campo de la tecnolog´ıa.",(Postulante)p3,o1);
			Postulacion pos4 = new Postulacion(fPos4,"T´ecnico en Electricidad, experiencia en mantenimiento industrial. Conocimientos en lectura de planos el´ectricos.","Estoy interesado en formar parte de un equipo que me permita aplicar mis habilidades t´ecnicas y contribuir al mantenimiento eficiente.",(Postulante)p4,o3);
			Postulacion pos5 = new Postulacion(fPos5,"M´usico profesional, experiencia en espect´aculos en vivo. Habilidades en canto y guitarra.","Me gustar´ıa combinar mi pasi´on por la m´usica con una oportunidad laboral que me permita seguir creciendo como artista.",(Postulante)p5,o2);
			Postulacion pos6 = new Postulacion(fPos6,"Licenciada en Administraci´on, me considero genia, experiencia en gesti´on de equipos y proyectos. Conocimientos en Microsoft Office.","Estoy emocionada por la oportunidad de formar parte de un equipo din´amico y contribuir con mis habilidades de liderazgo.",(Postulante)p1,o2);
			
			mo.addPostulacion(pos1);
			mo.addPostulacion(pos2);
			mo.addPostulacion(pos3);
			mo.addPostulacion(pos4);
			mo.addPostulacion(pos5);
			mo.addPostulacion(pos6);
			
			o1.agregarPostulacionAOferta(pos1);
			o2.agregarPostulacionAOferta(pos2);
			o1.agregarPostulacionAOferta(pos3);
			o3.agregarPostulacionAOferta(pos4);
			o2.agregarPostulacionAOferta(pos5);
			o2.agregarPostulacionAOferta(pos1);
			
			//------------------------------//	
			//Falta todo lo de Paquete que es opcional, veremos si se hace.
			
			//Creo un paquete(ojala no se rompa todo)
			
			//Fechas para paquetes
			
			LocalDate fhp1 = LocalDate.parse("16-08-2023", dateFormatter);
			LocalDate fhp2 = LocalDate.parse("15-08-2023", dateFormatter);
			LocalDate fhp3 = LocalDate.parse("14-08-2023", dateFormatter);
			LocalDate fhp4 = LocalDate.parse("13-08-2023", dateFormatter);
			
			//Creo los paquetes
			
			Paquete paq1 = new Paquete("Básico", "Publica ofertas laborales en nuestra\n"
					+ "plataforma por un período de 30 d´ıas", 30, 20, fhp1, 3720, null);
			Paquete paq2 = new Paquete("Destacado", "Publica ofertas laborales destacadas\n"
					+ "que se mostrar´a en la parte superior de\n"
					+ "los resultados de búsqueda por 45 días", 45, 10, fhp2, 315, null);
			Paquete paq3 = new Paquete("Premium", "Publica ofertas laborales premium que\n"
					+ "incluye promoción en nuestras redes so-\n"
					+ "ciales y listado en la sección destacada\n"
					+ "por 60 días", 60, 15, fhp3, 7055, null);
			Paquete paq4 = new Paquete("Express", "Publica ofertas laborales urgentes re-\n"
					+ "saltada en color y se mostrará en la\n"
					+ "sección de urgente por 15 días.", 15, 5, fhp4, 950, null);
			
			//Los añado al manejador
			
			mpyt.addPaquete(paq1);
			mpyt.addPaquete(paq2);
			mpyt.addPaquete(paq3);
			mpyt.addPaquete(paq4);
		}
	}
	private byte[] cargarImagenEnBytes(String rutaImagen) {
        try {
            File imagenFile = new File(rutaImagen);
            return Files.readAllBytes(imagenFile.toPath());
        } catch (IOException e) {
            e.printStackTrace();
            return null; // Manejo de error: devuelve null o maneja el error de otra manera
        }
    }
		

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	
	
	
}