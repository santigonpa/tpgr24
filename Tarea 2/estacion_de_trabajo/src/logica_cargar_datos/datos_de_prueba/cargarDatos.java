package logica_cargar_datos.datos_de_prueba;

import logica_manejadores.IManejadorOferta;
import logica_manejadores.IManejadorPyT;
import logica_manejadores.IManejadorUsuario;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import excepciones.yaExistePostulacionAOfertaException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import logica_controladores.IControladorUsuario;
import logica_entidades.CompraPaquete;
import logica_entidades.Empresa;
import logica_entidades.KeyWord;
import logica_entidades.Usuario;
import logica_entidades.OfertaLaboral;
import logica_entidades.Paquete;
import logica_entidades.Postulacion;
import logica_entidades.Postulante;
import logica_entidades.TipoPublicacion;
import logica_entidades.OfertaLaboral.EstadoOferta;
import utils.Fabrica;

public class cargarDatos {
	
	public byte[] getFile(String name)
            throws  IOException {
		byte[] byteArray = null;
        try {
                File f = new File("img/" + name);
                @SuppressWarnings("resource")
				FileInputStream streamer = new FileInputStream(f);
                byteArray = new byte[streamer.available()];
                streamer.read(byteArray);
        } catch (IOException e) {
                throw e;
        }
        return byteArray;
	}
	
	
	public void cargar() throws IOException {
		Fabrica fabrica = Fabrica.getInstance();
		IManejadorUsuario mu = fabrica.getInManejadorUsuario();
		@SuppressWarnings("unused")
		IControladorUsuario icu = fabrica.getInUser();
		IManejadorOferta mo = fabrica.getInManejadorOferta();
		IManejadorPyT mpyt = fabrica.getInManejadorPyT();
		IControladorUsuario cu = fabrica.getInUser();	
		
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
		

		//Creo Postulantes
		byte[] p1img = this.getFile("U1.jpg");
		byte[] p2img = this.getFile("U2.jpg");
		byte[] p3img = this.getFile("U3.jpg");
		byte[] p4img = this.getFile("U4.jpg");
		byte[] p5img = this.getFile("U5.jpg");
		byte[] p6img = this.getFile("U6.jpg");
		byte[] p7img = this.getFile("U7.jpg");
		byte[] p8img = this.getFile("U8.jpg");
		byte[] p9img = this.getFile("U9.jpg");
		byte[] p10img = this.getFile("U10.jpg");
		byte[] p11img = this.getFile("U11.jpg");
		byte[] p12img = this.getFile("U12.jpg");
		byte[] p13img = this.getFile("U13.jpg");
		byte[] p14img = this.getFile("U14.jpg");
		byte[] p15img = this.getFile("U15.jpg");
		byte[] p16img = this.getFile("U16.jpg");
		byte[] o1img = this.getFile("O1.jpg");
		byte[] o2img = this.getFile("O2.jpg");
		byte[] o3img = this.getFile("O3.jpg");
		byte[] o4img = this.getFile("O4.jpg");
		byte[] o5img = this.getFile("O5.jpg");
		byte[] o6img = this.getFile("O6.jpg");
		byte[] o7img = this.getFile("O7.jpg");
		byte[] o8img = this.getFile("O8.jpg");
		byte[] o9img = this.getFile("O9.jpg");
		byte[] o10img = this.getFile("O10.jpg");
		byte[] o11img = this.getFile("O11.jpg");
		byte[] o12img = this.getFile("O12.jpg");
		byte[] o13img = this.getFile("O13.jpg");
		Postulante p1 = new Postulante();
		p1.setNickName("lgarcia");
		p1.setNombre("Lucia");
		p1.setApellido("Garcia");
		p1.setEmail("lgarcia85@gmail.com");
		p1.setNacimiento(n1);
		p1.setNacionalidad("Uruguaya");
		p1.setImagen(p1img);
		p1.setPsw("awdrg543");
		
		Postulante p2 = new Postulante();
		p2.setNickName("matilo");
		p2.setNombre("Matias");
		p2.setApellido("Lopez");
		p2.setEmail("matias.lopez90@hotmail.com");
		p2.setNacimiento(n2);
		p2.setNacionalidad("Argentina");
		p2.setImagen(p2img);
		p2.setPsw("edrft543");

		Usuario p3 = new Postulante();
		((Postulante) p3).setNickName("maro");
		((Postulante) p3).setNombre("Maria");
		((Postulante) p3).setApellido("Rodriguez");
		((Postulante) p3).setEmail("marrod@gmail.com");
		((Postulante) p3).setNacimiento(n3);
		((Postulante) p3).setNacionalidad("Uruguaya");
		((Postulante) p3).setImagen(p3img);
		((Postulante) p3).setPsw("r5t6y7u8");

		Postulante p4 = new Postulante();
		p4.setNickName("javierf");
		p4.setNombre("Javier");
		p4.setApellido("Fernandez");
		p4.setEmail("javierf93@yahoo.com");
		p4.setNacimiento(n4);
		p4.setNacionalidad("Mexicana");
		p4.setImagen(p4img);
		p4.setPsw("45idgaf67");

		Postulante p5 = new Postulante();
		p5.setNickName("valen25");
		p5.setNombre("Valentina");
		p5.setApellido("Martinez");
		p5.setEmail("vale87@gmail.com");
		p5.setNacimiento(n5);
		p5.setNacionalidad("Uruguaya");
		p5.setImagen(p5img);
		p5.setPsw("poiuy987");

		Postulante p6 = new Postulante();
		p6.setNickName("andpel2");
		p6.setNombre("Andres");
		p6.setApellido("Perez");
		p6.setEmail("anpe92@hotmail.com");
		p6.setNacimiento(n6);
		p6.setNacionalidad("Chilena");
		p6.setImagen(p6img);
		p6.setPsw("xdrgb657");

		Postulante p7 = new Postulante();
		p7.setNickName("sicam");
		p7.setNombre("Camila");
		p7.setApellido("Silva");
		p7.setEmail("camisilva89@gmail.com");
		p7.setNacimiento(n7);
		p7.setNacionalidad("Uruguaya");
		p7.setImagen(p7img);
		p7.setPsw("mnjkiu89");

		Postulante p8 = new Postulante();
		p8.setNickName("sebgon");
		p8.setNombre("Sebastian");
		p8.setApellido("Gonzalez");
		p8.setEmail("gonza95@yahoo.com");
		p8.setNacimiento(n8);
		p8.setNacionalidad("Colombiana");
		p8.setImagen(p8img);
		p8.setPsw("ytrewq10");

		Postulante p9 = new Postulante();
		p9.setNickName("isabel");
		p9.setNombre("Isabella");
		p9.setApellido("Lopez");
		p9.setEmail("loisa@gmail.com");
		p9.setNacimiento(n9);
		p9.setNacionalidad("Uruguaya");
		p9.setImagen(p9img);
		p9.setPsw("sbsplol1");

		Postulante p10 = new Postulante();
		p10.setNickName("marram02");
		p10.setNombre("Martin");
		p10.setApellido("Ramirez");
		p10.setEmail("marram@hotmail.com");
		p10.setNacimiento(n10);
		p10.setNacionalidad("Argentina");
		p10.setImagen(p10img);
		p10.setPsw("okmnji98");

		//Creo Empresas
		Empresa e1 = new Empresa();
		e1.setNickName("EcoTech");
		e1.setNombre("Sophia");
		e1.setApellido("Johnson");
		e1.setEmail("info@EcoTehc.com");
		e1.setDescripcion("EcoTech Innovations es una empresa lider en soluciones tecnológicas sostenibles. Nuestro enfoque se centra en desarrollar y comercializar productos y servicios que aborden los desafíos ambientales más apremiantes de nuestro tiempo. Desde sistemas de energía renovable y dispositivos de monitorización ambiental hasta soluciones de gestión de residuos inteligentes, nuestra misión es proporcionar herramientas que permitan a las empresas y comunidades adoptar prácticas más ecológicas sin comprometer la eficiencia. Creemos en la convergencia armoniosa entre la tecnología y la naturaleza, y trabajamos incansablemente para impulsar un futuro más limpio y sostenible.");
		e1.setLinkWeb("http://www.EcoTechInnovations.com");
		e1.setImagen(p11img);
		e1.setPsw("qsxcdw43");

		Empresa e2 = new Empresa();
		e2.setNickName("FusionTech");
		e2.setNombre("William");
		e2.setApellido("Smith");
		e2.setEmail("contacto@FusionTech.net");
		e2.setDescripcion("FusionTech Dynamics es una empresa pionera en el ámbito de la inteligencia artificial y la automatización avanzada. Nuestro equipo multidisciplinario de ingenieros, científicos de datos y desarrolladores crea soluciones innovadoras que aprovechan la potencia de la IA para transformar industrias. Desde la optimización de procesos industriales hasta la creación de asistentes virtuales altamente personalizados, nuestro objetivo es revolucionar la forma en que las empresas operan y se conectan con sus clientes. Creemos en la sinergia entre la mente humana y las capacidades de la IA, y trabajamos para construir un mundo donde la tecnología mejore y amplíe nuestras capacidades innatas.");
		e2.setLinkWeb("http://www.FusionTechDynamics.net");
		e2.setImagen(p12img);
		e2.setPsw("qpwoei586");

		Empresa e3 = new Empresa();
		e3.setNickName("GlobalHealth");
		e3.setNombre("Isabella");
		e3.setApellido("Brown");
		e3.setEmail("jobs@GlobalHelath.uy");
		e3.setDescripcion("GlobalHealth Dynamics es una empresa comprometida con el avance de la atención médica a nivel mundial. Como líderes en el campo de la salud digital, desarrollamos plataformas y herramientas que permiten a los profesionales de la salud ofrecer diagnósticos más precisos, tratamientos personalizados y seguimiento continuo de los pacientes. Nuestra visión es crear un ecosistema de salud conectado en el que los datos médicos se utilicen de manera ética y segura para mejorar la calidad de vida de las personas. A través de la innovación constante y la colaboración con expertos médicos, estamos dando forma al futuro de la atención médica, donde la tecnología y la compasión se unen para salvar vidas y mejorar el bienestar en todo el mundo.");
		e3.setLinkWeb("http://www.globalhealthdynamics.uy/info");
		e3.setImagen(p13img);
		e3.setPsw("asdfg654");

		Empresa e4 = new Empresa();
		e4.setNickName("ANTEL");
		e4.setNombre("Washington");
		e4.setApellido("Rocha");
		e4.setEmail("jarrington@ANTEL.com.uy");
		e4.setDescripcion("En Antel te brindamos servicios de vanguardia en tecnología de comunicación en Telefonia Movil, Fija, Banda Ancha y Datos");
		e4.setLinkWeb("ANTEL.com.uy");
		e4.setImagen(p14img);
		e4.setPsw("2nru096");

		Empresa e5 = new Empresa();
		e5.setNickName("MIEM");
		e5.setNombre("Pablo");
		e5.setApellido("Bengoechea");
		e5.setEmail("eldiez@MIEM.org.uy");
		e5.setDescripcion("Balance Energetico Nacional (BEN). La Dirección Nacional de Energía (DNE) del Ministerio de Industria, Energía y Minería (MIEM) presenta anualmente el BEN.");
		e5.setLinkWeb("MIEM.com.uy");
		e5.setImagen(p15img);
		e5.setPsw("ibii4xo");

		Empresa e6 = new Empresa();
		e6.setNickName("TechSolutions");
		e6.setNombre("Mercedes");
		e6.setApellido("Venn");
		e6.setEmail("Mercedes@TechSolutions.com.uy");
		e6.setDescripcion("TechSolutions Inc. es una empresa líder en el sector de tecnología de la información y el software. Se especializa en el desarrollo de soluciones de software personalizadas para empresas de diversos tamaños y sectores. Su enfoque se centra en la creación de aplicaciones empresariales innovadoras que optimizan procesos, mejoran la eficiencia y brindan una ventaja competitiva a sus clientes.");
		e6.setLinkWeb("TechSolutions.com");
		e6.setImagen(p16img);
		e6.setPsw("1ngs03p");

		//Agrego Usarios
		mu.addUsuario(p1);
		mu.addUsuario(p2);
		mu.addUsuario(p3);
		mu.addUsuario((Usuario)p4);
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
		mu.addUsuario((Usuario)e6);
		
		//------------------------------//	
		
		
		//-----------------------------//
		
		//Seguidores y seguidos
		
		((Postulante) p1).seguirAUsuario(e1);
		((Empresa)e1).agregarSeguidor(p1);
		
		((Postulante) p1).seguirAUsuario(e2);
		((Empresa)e2).agregarSeguidor(p1);

		((Postulante) p1).seguirAUsuario(e3);
		((Empresa)e3).agregarSeguidor(p1);

		((Postulante) p1).seguirAUsuario(e4);
		((Empresa)e4).agregarSeguidor(p1);
		
		((Postulante) p1).seguirAUsuario(e5);
		((Empresa)e5).agregarSeguidor(p1);
		
		((Postulante) p2).seguirAUsuario(e1);
		((Empresa)e1).agregarSeguidor(p2);

				
		((Postulante) p3).seguirAUsuario(e2);
		((Empresa)e2).agregarSeguidor(p3);

				
		((Postulante) p3).seguirAUsuario(e3);
		((Empresa)e3).agregarSeguidor(p3);

				
		((Postulante) p3).seguirAUsuario(e5);
		((Empresa)e5).agregarSeguidor(p3);

				
		((Postulante) p3).seguirAUsuario(e6);
		((Empresa)e6).agregarSeguidor(p3);

				
		((Postulante) p4).seguirAUsuario(e2);
		((Empresa)e2).agregarSeguidor(p4);

		
		((Postulante) p4).seguirAUsuario(e4);
		((Empresa)e4).agregarSeguidor(p4);
		
		
		((Postulante) p5).seguirAUsuario(e3);
		((Empresa)e3).agregarSeguidor(p5);
		
		
		((Postulante) p5).seguirAUsuario(e5);
		((Empresa)e5).agregarSeguidor(p5);
		
		
		((Postulante) p5).seguirAUsuario(e6);
		((Empresa)e6).agregarSeguidor(p5);
		
		
		((Postulante) p6).seguirAUsuario(e2);
		((Empresa)e2).agregarSeguidor(p6);
		
		
		((Postulante) p6).seguirAUsuario(e4);
		((Empresa)e4).agregarSeguidor(p6);
		
		
		((Postulante) p6).seguirAUsuario(e5);
		((Empresa)e5).agregarSeguidor(p6);
		
		
		((Postulante) p7).seguirAUsuario(e1);
		((Empresa)e1).agregarSeguidor(p7);
		
		
		((Postulante) p7).seguirAUsuario(e4);
		((Empresa)e4).agregarSeguidor(p7);
		
		
		((Postulante) p8).seguirAUsuario(e2);
		((Empresa)e2).agregarSeguidor(p8);

		
		((Postulante) p8).seguirAUsuario(e3);
		((Empresa)e3).agregarSeguidor(p8);

		
		((Postulante) p9).seguirAUsuario(p1);
		((Postulante)p1).agregarSeguidor(p9);
		
		((Postulante) p9).seguirAUsuario(e1);
		((Empresa)e1).agregarSeguidor(p9);
		
		((Postulante) p9).seguirAUsuario(e2);
		((Empresa)e2).agregarSeguidor(p9);

		((Postulante) p9).seguirAUsuario(e5);
		((Empresa)e5).agregarSeguidor(p9);

		((Empresa) e1).seguirAUsuario(p1);
		((Postulante)p1).agregarSeguidor(p1);
		
		((Empresa) e1).seguirAUsuario(e2);
		((Empresa)e2).agregarSeguidor(e1);
		
		((Empresa) e2).seguirAUsuario(e3);
		((Empresa)e3).agregarSeguidor(e2);

		((Empresa) e3).seguirAUsuario(p1);
		((Postulante)p1).agregarSeguidor(e3);

		((Empresa) e3).seguirAUsuario(e4);
		((Empresa)e4).agregarSeguidor(e3);

		((Empresa) e3).seguirAUsuario(e5);
		((Empresa)e5).agregarSeguidor(e3);

		((Empresa) e3).seguirAUsuario(e6);
		((Empresa)e6).agregarSeguidor(e3);

		((Empresa) e4).seguirAUsuario(e5);
		((Empresa)e5).agregarSeguidor(e4);

		((Empresa) e5).seguirAUsuario(e4);
		((Empresa)e4).agregarSeguidor(e5);

		((Empresa) e6).seguirAUsuario(e5);
		((Empresa)e5).agregarSeguidor(e6);





		
		//Cargo Tipos de Publicacion
		
		//Cambio a LocalDate fecha de alta, fala agregarla a los parametros
		LocalDate at1 = LocalDate.parse("10-08-2023", dateFormatter);
		LocalDate at2 = LocalDate.parse("05-08-2023", dateFormatter);
		LocalDate at3 = LocalDate.parse("15-08-2023", dateFormatter);
		LocalDate at4 = LocalDate.parse("07-08-2023", dateFormatter);
		
		//Creo Tipos
	
		TipoPublicacion tp1 = new TipoPublicacion();
		tp1.setNombre("Premium");
		tp1.setDescripcion("Obtén máxima visibilidad.");
		tp1.setExposicion(1);
		tp1.setDuracion(30);
		tp1.setCosto(4000);
		tp1.setFecha(at1);

		TipoPublicacion tp2 = new TipoPublicacion();
		tp2.setNombre("Destacada");
		tp2.setDescripcion("Destaca tu anuncio");
		tp2.setExposicion(2);
		tp2.setDuracion(15);
		tp2.setCosto(500);
		tp2.setFecha(at2);

		TipoPublicacion tp3 = new TipoPublicacion();
		tp3.setNombre("Estandar");
		tp3.setDescripcion("Mejora la posición de tu anuncio");
		tp3.setExposicion(3);
		tp3.setDuracion(20);
		tp3.setCosto(150);
		tp3.setFecha(at3);

		TipoPublicacion tp4 = new TipoPublicacion();
		tp4.setNombre("Basica");
		tp4.setDescripcion("Publica de forma sencilla en la lista de ofertas");
		tp4.setExposicion(4);
		tp4.setDuracion(7);
		tp4.setCosto(50);
		tp4.setFecha(at4);
//Agrego Tipos
		
		mpyt.addTipoPublicacion(tp1);
		mpyt.addTipoPublicacion(tp2);
		mpyt.addTipoPublicacion(tp3);
		mpyt.addTipoPublicacion(tp4);
		
		//Cargo Keywords
		KeyWord k1 = new KeyWord();
		k1.setPalabra("Tiempo completo");

		KeyWord k2 = new KeyWord();
		k2.setPalabra("Medio tiempo");

		KeyWord k3 = new KeyWord();
		k3.setPalabra("Remoto");

		KeyWord k4 = new KeyWord();
		k4.setPalabra("Freelance");

		KeyWord k5 = new KeyWord();
		k5.setPalabra("Temporal");

		KeyWord k6 = new KeyWord();
		k6.setPalabra("Permanente");

		KeyWord k7 = new KeyWord();
		k7.setPalabra("Computacion");

		KeyWord k8 = new KeyWord();
		k8.setPalabra("Administracion");

		KeyWord k9 = new KeyWord();
		k9.setPalabra("Logistica");

		KeyWord k10 = new KeyWord();
		k10.setPalabra("Contabilidad");

		
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
		LocalTime hi10 = LocalTime.parse("09:00");
		LocalTime hi11 = LocalTime.parse("04:00");
		LocalTime hi12 = LocalTime.parse("04:00");
		LocalTime hi13 = LocalTime.parse("14:00");
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
		LocalDate ao3 = LocalDate.of(2023,10,29);
		LocalDate ao4 = LocalDate.of(2023,10,19);
		LocalDate ao5 = LocalDate.of(2023,10,20);
		LocalDate ao6 = LocalDate.of(2023,11,2);
		LocalDate ao7 = LocalDate.of(2023,11,2);
		LocalDate ao8 = LocalDate.of(2023,11,4);
		LocalDate ao9 = LocalDate.of(2023,10,29);
		LocalDate ao10 = LocalDate.of(2023,11,4);
		LocalDate ao11 = LocalDate.of(2023,10,25);
		LocalDate ao12 = LocalDate.of(2023,11,5);
		LocalDate ao13 = LocalDate.of(2023,11,1);
		
		
		//Creo Oferta   // FALTAN OFERTAS 
		OfertaLaboral o1 = new OfertaLaboral();
		o1.setNombre("Desarrollador Frontend");
		o1.setDescripcion("Únete a nuestro equipo de desarrollo frontend y crea experiencias de usuario excepcionales.");
		o1.setCiudad("Montevideo");
		o1.setDepartamento("Montevideo");
		o1.setHorarioIni(hi1);
		o1.setHorarioFin(hf1);
		o1.setRemuneracion(90000);
		o1.setCostoOfer(4000);
		o1.setFechaAlta(ao1);
		o1.setImagen(o1img);
		o1.setTipodePago("Basico");
		o1.setEstado(EstadoOferta.ACEPTADA);
		o1.setVisitas(5);
		
		OfertaLaboral o2 = new OfertaLaboral();
		o2.setNombre("Estrategia de Negocios");
		o2.setDescripcion("Forma parte de nuestro equipo de estrategia y contribuye al crecimiento de las empresas clientes");
		o2.setCiudad("Punta del Este");
		o2.setDepartamento("Maldonado");
		o2.setHorarioIni(hi2);
		o2.setHorarioFin(hf2);
		o2.setRemuneracion(80000);
		o2.setCostoOfer(150);
		o2.setFechaAlta(ao2);
		o2.setImagen(o2img);
		o2.setTipodePago("Sin paquete");
		o2.setEstado(EstadoOferta.ACEPTADA);
		o2.setVisitas(10);
		
		OfertaLaboral o3 = new OfertaLaboral();
		o3.setNombre("Diseñador UX/UI");
		o3.setDescripcion("Trabaja en colaboración con nuestro talentoso equipo de diseño para crear soluciones impactantes.");
		o3.setCiudad("Rosario");
		o3.setDepartamento("Colonia");
		o3.setHorarioIni(hi3);
		o3.setHorarioFin(hf3);
		o3.setRemuneracion(65000);
		o3.setCostoOfer(150);
		o3.setFechaAlta(ao3);
		o3.setImagen(o3img);
		o3.setTipodePago("Sin paquete");
		o3.setEstado(EstadoOferta.ACEPTADA);
		o3.setVisitas(0);
		
		OfertaLaboral o4 = new OfertaLaboral();
		o4.setNombre("Analista de Datos");
		o4.setDescripcion("Ayuda a nuestros clientes a tomar decisiones informadas basadas en análisis y visualizaciones de datos.");
		o4.setCiudad("Maldonado");
		o4.setDepartamento("Maldonado");
		o4.setHorarioIni(hi4);
		o4.setHorarioFin(hf4);
		o4.setRemuneracion(40000);
		o4.setCostoOfer(4000);
		o4.setFechaAlta(ao4);
		o4.setImagen(o4img);
		o4.setTipodePago("Sin paquete");
		o4.setEstado(EstadoOferta.INGRESADA);
		o4.setVisitas(15);
		
		OfertaLaboral o5 = new OfertaLaboral();
		o5.setNombre("Content Manager");
		o5.setDescripcion("Gestiona y crea contenido persuasivo y relevante para impulsar la presencia en línea de nuestros clientes.");
		o5.setCiudad("Montevideo");
		o5.setDepartamento("Montevideo");
		o5.setHorarioIni(hi5);
		o5.setHorarioFin(hf5);
		o5.setRemuneracion(10000);
		o5.setCostoOfer(500);
		o5.setFechaAlta(ao5);
		o5.setImagen(o5img);
		o5.setTipodePago("Sin paquete");
		o5.setEstado(EstadoOferta.FINALIZADA);
		o5.setVisitas(20);
		
		OfertaLaboral o6 = new OfertaLaboral();
		o6.setNombre("Soporte Tecnico");
		o6.setDescripcion("Ofrece un excelente servicio de soporte técnico a nuestros clientes, resolviendo problemas y brindando soluciones.");
		o6.setCiudad("Minas");
		o6.setDepartamento("Lavalleja");
		o6.setHorarioIni(hi6);
		o6.setHorarioFin(hf6);
		o6.setRemuneracion(30000);
		o6.setCostoOfer(50);
		o6.setFechaAlta(ao6);
		o6.setImagen(o6img);
		o6.setTipodePago("Destacado");
		o6.setEstado(EstadoOferta.ACEPTADA);
		o6.setVisitas(25);
		
		OfertaLaboral o7 = new OfertaLaboral();
		o7.setNombre("A. de Marketing Digital");
		o7.setDescripcion("Únete a nuestro equipo de marketing y trabaja en estrategias digitales innovadoras.");
		o7.setCiudad("Flores");
		o7.setDepartamento("Flores");
		o7.setHorarioIni(hi7);
		o7.setHorarioFin(hf7);
		o7.setRemuneracion(80000);
		o7.setCostoOfer(4000);
		o7.setFechaAlta(ao7);
		o7.setImagen(o7img);
		o7.setTipodePago("Sin paquete");
		o7.setEstado(EstadoOferta.ACEPTADA);
		o7.setVisitas(30);
		
		OfertaLaboral o8 = new OfertaLaboral();
		o8.setNombre("Contador Senior");
		o8.setDescripcion("Únete a nuestro equipo contable y ayuda en la gestión financiera de la empresa.");
		o8.setCiudad("Colonia Suiza");
		o8.setDepartamento("Colonia");
		o8.setHorarioIni(hi8);
		o8.setHorarioFin(hf8);
		o8.setRemuneracion(10000);
		o8.setCostoOfer(500);
		o8.setFechaAlta(ao8);
		o8.setImagen(o8img);
		o8.setTipodePago("Sin paquete");
		o8.setEstado(EstadoOferta.RECHAZADA);
		o8.setVisitas(35);
		
		OfertaLaboral o9 = new OfertaLaboral();
		o9.setNombre("Técnico/a Básico Red");
		o9.setDescripcion("RÉGIMEN DE CONTRATO EN FUNCIÓN PÚBLICA EN UN TODO DE ACUERDO CON LA NORMATIVA VIGENTE (LEY 16.127, DEL 7 DE AGOSTO DE 1990, ARTÍCULO 1°, LITERAL A) Y B), CON LA MODIFICACIÓN INTRODUCIDA POR EL ARTÍCULO 11 DE LA LEY 17.930, DEL 19 DE DICIEMBRE DE 2005).");
		o9.setCiudad("Paysandú");
		o9.setDepartamento("Paysandú");
		o9.setHorarioIni(hi9);
		o9.setHorarioFin(hf9);
		o9.setRemuneracion(40000);
		o9.setCostoOfer(500);
		o9.setFechaAlta(ao9);
		o9.setImagen(o9img);
		o9.setTipodePago("Sin paquete");
		o9.setEstado(EstadoOferta.ACEPTADA);
		o9.setVisitas(40);
		
		OfertaLaboral o10 = new OfertaLaboral();
		o10.setNombre("Desarrollador de Software Senior");
		o10.setDescripcion("Únete a nuestro equipo y lidera proyectos de desarrollo de software sostenible y ecológico. Impulsa la innovación y contribuye a un futuro más verde.");
		o10.setCiudad("Montevideo");
		o10.setDepartamento("Montevideo");
		o10.setHorarioIni(hi10);
		o10.setHorarioFin(hf10);
		o10.setRemuneracion(123000);
		o10.setCostoOfer(500);
		o10.setFechaAlta(ao10);
		o10.setImagen(o10img);
		o10.setTipodePago("Destacada");
		o10.setEstado(EstadoOferta.INGRESADA);
		o10.setVisitas(45);
		
		OfertaLaboral o11 = new OfertaLaboral();
		o11.setNombre("Desarrollador de Software Full Stack");
		o11.setDescripcion("Únete a nuestro equipo para crear soluciones de software personalizadas de extremo a extremo. Colabora en proyectos emocionantes y desafiantes.");
		o11.setCiudad("Río Negro");
		o11.setDepartamento("Fray Bentos");
		o11.setHorarioIni(hi11);
		o11.setHorarioFin(hf11);
		o11.setRemuneracion(135000);
		o11.setCostoOfer(4000);
		o11.setFechaAlta(ao11);
		o11.setImagen(o11img);
		o11.setTipodePago("Premium");
		o11.setEstado(EstadoOferta.INGRESADA);
		o11.setVisitas(50);
			
		OfertaLaboral o12 = new OfertaLaboral();
		o12.setNombre("Gerente de Proyecto");
		o12.setDescripcion("Únete a nuestro equipo de gestión de proyectos y lidera la entrega exitosa de soluciones de software personalizadas. Colabora con equipos multidisciplinarios y clientes exigentes.");
		o12.setCiudad("Montevideo");
		o12.setDepartamento("Montevideo");
		o12.setHorarioIni(hi12);
		o12.setHorarioFin(hf12);
		o12.setRemuneracion(230000);
		o12.setCostoOfer(500);
		o12.setFechaAlta(ao12);
		o12.setImagen(o12img);
		o12.setTipodePago("Destacada");
		o12.setEstado(EstadoOferta.ACEPTADA);
		o12.setVisitas(55);
		
		OfertaLaboral o13 = new OfertaLaboral();
		o13.setNombre("Ingeniero de Calidad de Software");
		o13.setDescripcion("Asegura la calidad de nuestros productos de software sostenibles. Únete a nosotros para garantizar un impacto positivo en el medio ambiente.");
		o13.setCiudad("Montevideo");
		o13.setDepartamento("Montevideo");
		o13.setHorarioIni(hi13);
		o13.setHorarioFin(hf13);
		o13.setRemuneracion(60000);
		o13.setCostoOfer(4000);
		o13.setFechaAlta(ao13);
		o13.setImagen(o13img);
		o13.setTipodePago("Premium");
		o13.setEstado(EstadoOferta.INGRESADA);
		o13.setVisitas(7);
		
		//falta agregar la compra con el paquete
		//Agrego oferta a Empresa
		((Empresa) e1).agregarOfertas(o1.getNombreOferta(),o1);
		((Empresa) e3).agregarOfertas(o2.getNombreOferta(),o2);
		((Empresa) e2).agregarOfertas(o3.getNombreOferta(),o3);
		((Empresa) e4).agregarOfertas(o4.getNombreOferta(),o4);
		((Empresa) e5).agregarOfertas(o5.getNombreOferta(),o5);
		((Empresa) e6).agregarOfertas(o6.getNombreOferta(),o6);
		((Empresa) e1).agregarOfertas(o7.getNombreOferta(),o7);
		((Empresa) e3).agregarOfertas(o8.getNombreOferta(),o8);
		((Empresa) e4).agregarOfertas(o9.getNombreOferta(),o9);
		((Empresa) e1).agregarOfertas(o10.getNombreOferta(),o10);
		((Empresa) e6).agregarOfertas(o11.getNombreOferta(),o11);
		((Empresa) e6).agregarOfertas(o12.getNombreOferta(),o12);
		((Empresa) e1).agregarOfertas(o13.getNombreOferta(),o13);
		
	
		
		//Agrego Empresa a Oferta
		o1.setEmpresa((Empresa) e1);
		o2.setEmpresa((Empresa) e3);
		o3.setEmpresa((Empresa) e2);
		o4.setEmpresa((Empresa) e4);
		o5.setEmpresa((Empresa) e5);
		o6.setEmpresa((Empresa) e6);
		o7.setEmpresa((Empresa) e1);
		o8.setEmpresa((Empresa) e3);
		o9.setEmpresa((Empresa) e4);
		o10.setEmpresa((Empresa) e1);
		o11.setEmpresa((Empresa) e6);
		o12.setEmpresa((Empresa) e6);
		o13.setEmpresa((Empresa) e1);
		
		 ;
		
		//Agrego Oferta
		mo.addOferta(o1);
		mo.addOferta(o2);
		mo.addOferta(o3);
		mo.addOferta(o4);
		mo.addOferta(o5);
		mo.addOferta(o6);
		mo.addOferta(o7);
		mo.addOferta(o8);
		mo.addOferta(o9); 
		mo.addOferta(o10);
		mo.addOferta(o11);
		mo.addOferta(o12);
		mo.addOferta(o13);
		
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
		
		o7.agregarKeywordAOferta(k4);
		
		o8.agregarKeywordAOferta(k1);
		
		o9.agregarKeywordAOferta(k5);
		
		o10.agregarKeywordAOferta(k1);
		o10.agregarKeywordAOferta(k6);
		o10.agregarKeywordAOferta(k9);
		
		o11.agregarKeywordAOferta(k3);
		
		o12.agregarKeywordAOferta(k3);
		o12.agregarKeywordAOferta(k6);
		
		o13.agregarKeywordAOferta(k1);
		o13.agregarKeywordAOferta(k10);
		
		//Agrego oferta a KeyWord
		k1.agregarOfertaAKeyWord(o1);
		k2.agregarOfertaAKeyWord(o1);
		k3.agregarOfertaAKeyWord(o1);
		k4.agregarOfertaAKeyWord(o1);
		k5.agregarOfertaAKeyWord(o1);
		k6.agregarOfertaAKeyWord(o1);
		
		k5.agregarOfertaAKeyWord(o2);
		k5.agregarOfertaAKeyWord(o9);
		
		k2.agregarOfertaAKeyWord(o3);
		k3.agregarOfertaAKeyWord(o3);
		k6.agregarOfertaAKeyWord(o3);

		k2.agregarOfertaAKeyWord(o4);
		
		k4.agregarOfertaAKeyWord(o5);
		
		k1.agregarOfertaAKeyWord(o6);
		
		k4.agregarOfertaAKeyWord(o7);
		
		k1.agregarOfertaAKeyWord(o8);
		
		k5.agregarOfertaAKeyWord(o9);
		
		k1.agregarOfertaAKeyWord(o10);
		k6.agregarOfertaAKeyWord(o10);
		k9.agregarOfertaAKeyWord(o10);
		
		k3.agregarOfertaAKeyWord(o11);
		
		k3.agregarOfertaAKeyWord(o12);
		k6.agregarOfertaAKeyWord(o12);
		
		k1.agregarOfertaAKeyWord(o13);
		k10.agregarOfertaAKeyWord(o13);
		
		//Linkeo Tipo con Oferta 

		o1.setTipoPublicacion(tp1);
		o2.setTipoPublicacion(tp3);
		o3.setTipoPublicacion(tp3);
		o4.setTipoPublicacion(tp1);
		o5.setTipoPublicacion(tp2);
		o6.setTipoPublicacion(tp4);
		o7.setTipoPublicacion(tp1);
		o8.setTipoPublicacion(tp2);
		o9.setTipoPublicacion(tp1);
		o10.setTipoPublicacion(tp2);
		o11.setTipoPublicacion(tp1);
		o12.setTipoPublicacion(tp2);
		o13.setTipoPublicacion(tp1);
		
		
		//------------------------------//	
		
		//Convierto String a LocalDate
		LocalDate fPos1 = LocalDate.parse("01-10-2023", dateFormatter);
		LocalDate fPos2 = LocalDate.parse("30-09-2023", dateFormatter);
		LocalDate fPos3 = LocalDate.parse("02-10-2023", dateFormatter);
		LocalDate fPos4 = LocalDate.parse("30-10-2023", dateFormatter);
		LocalDate fPos5 = LocalDate.parse("30-09-2023", dateFormatter);
		LocalDate fPos6 = LocalDate.parse("02-10-2023", dateFormatter);
		LocalDate fPos7 = LocalDate.parse("21-10-2023", dateFormatter);
		LocalDate fPos8 = LocalDate.parse("22-10-2023", dateFormatter);
		
		//Creo Postulaciones
		Postulacion pos1 = new Postulacion();
		pos1.setFecha(fPos1);
		pos1.setCurri("Licenciada en Administración, experiencia en gestión de equipos y proyectos. Conocimientos en Office.");
		pos1.setMotivacion("Estoy emocionada por la oportunidad de formar parte de un equipo dinámico y contribuir con mis habilidades de liderazgo.");
		pos1.setPost((Postulante)p1);
		pos1.setOfer(o1);

		Postulacion pos2 = new Postulacion();
		pos2.setFecha(fPos2);
		pos2.setCurri("Estudiante de Comunicación, habilidades en redacción y manejo de redes sociales. Experiencia en prácticas en medios locales");
		pos2.setMotivacion("Me encantaría formar parte de un equipo que me permita desarrollar mis habilidades en comunicación y marketing.");
		pos2.setPost((Postulante)p2);
		pos2.setOfer(o2);

		Postulacion pos3 = new Postulacion();
		pos3.setFecha(fPos3);
		pos3.setCurri("Ingeniero en Sistemas, experiencia en desarrollo web y aplicaciones móviles. Conocimientos en JavaScript y React.");
		pos3.setMotivacion("Me entusiasma la posibilidad de trabajar en proyectos desafiantes y seguir creciendo como profesional en el campo de la tecnología.");
		pos3.setPost((Postulante)p3);
		pos3.setOfer(o1);

		Postulacion pos4 = new Postulacion();
		pos4.setFecha(fPos4);
		pos4.setCurri("Técnico en Electricidad, experiencia en mantenimiento industrial. Conocimientos en lectura de planos eléctricos.");
		pos4.setMotivacion("Estoy interesado en formar parte de un equipo que me permita aplicar mis habilidades técnicas y contribuir al mantenimiento eficiente.");
		pos4.setPost((Postulante)p4);
		pos4.setOfer(o3);

		Postulacion pos5 = new Postulacion();
		pos5.setFecha(fPos5);
		pos5.setCurri("Músico profesional, experiencia en espectáculos en vivo. Habilidades en canto y guitarra.");
		pos5.setMotivacion("Me gustaría combinar mi pasión por la música con una oportunidad laboral que me permita seguir creciendo como artista.");
		pos5.setPost((Postulante)p5);
		pos5.setOfer(o2);

		Postulacion pos6 = new Postulacion();
		pos6.setFecha(fPos6);
		pos6.setCurri("Licenciada en Administración, me considero genia, experiencia en gestión de equipos y proyectos. Conocimientos en Microsoft Office.");
		pos6.setMotivacion("Estoy emocionada por la oportunidad de formar parte de un equipo dinámico y contribuir con mis habilidades de liderazgo.");
		pos6.setPost((Postulante)p1);
		pos6.setOfer(o2);

		Postulacion pos7 = new Postulacion();
		pos7.setFecha(fPos7);
		pos7.setCurri("Licenciada en Administracion, me considero la mejor menejadora de contenidos del mundo, tengo experiencia en gestion de equipos y proyectos. Conocimientos en Microsoft Office.");
		pos7.setMotivacion("Estoy emocionada por la oportunidad de formar parte de un equipo tan bonito y contribuir con mis habilidades de liderazgo.");
		pos7.setPost((Postulante)p1);
		pos7.setOfer(o5);
		
		Postulacion pos8 = new Postulacion();
		pos8.setFecha(fPos8);
		pos8.setCurri("Me manejo las redes, tengo 20M de seguidores.");
		pos8.setMotivacion("Me gustaría combinar mi pasión por la música con una oportunidad laboral que me permita seguir creciendo como artista");
		pos8.setPost((Postulante) p5);
		pos8.setOfer(o5);
		
		
		//videos en las postulaciones
		pos1.setVideo("https://www.youtube.com/embed/sqh77QZS0G4");
		pos2.setVideo("https://www.youtube.com/embed/ekm1D3sKoVA");
		pos4.setVideo("https://www.youtube.com/embed/uNCzhfQCqAs");
		pos5.setVideo("https://www.youtube.com/embed/jwiV9gbjEi8");
		pos8.setVideo("https://www.youtube.com/embed/jwiV9gbjEi8");
		
		
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
		
		
		try {
			cu.agregarPostulacionAPostulante(p1.getNickName() ,pos1);
			cu.agregarPostulacionAPostulante(p2.getNickName(), pos2);
			cu.agregarPostulacionAPostulante(p3.getNickName(), pos3);
			cu.agregarPostulacionAPostulante(p4.getNickName(), pos4);
			cu.agregarPostulacionAPostulante(p5.getNickName(), pos5);
			cu.agregarPostulacionAPostulante(p1.getNickName(), pos6);
		} catch (yaExistePostulacionAOfertaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		ArrayList<String> ordenPostulaciones1 = new ArrayList<>();
		ordenPostulaciones1.add(0, p3.getNickName());
		ordenPostulaciones1.add(1, p1.getNickName());
		o1.setOrdenPostulaciones(ordenPostulaciones1);
		o1.setFechaCalificacion(LocalDate.now());
		
		ArrayList<String> ordenPostulaciones2 = new ArrayList<>();
		ordenPostulaciones2.add(0, p1.getNickName());
		ordenPostulaciones2.add(1, p5.getNickName());
		ordenPostulaciones2.add(2, p2.getNickName());
		o2.setOrdenPostulaciones(ordenPostulaciones2);
		o2.setFechaCalificacion(LocalDate.now());
		
		
		//------------------------------//	
		//PAQUETES
	
		//Fechas para paquetes
		
		LocalDate fhp1 = LocalDate.parse("16-08-2023", dateFormatter);
		LocalDate fhp2 = LocalDate.parse("15-08-2023", dateFormatter);
		LocalDate fhp3 = LocalDate.parse("14-08-2023", dateFormatter);
		LocalDate fhp4 = LocalDate.parse("13-08-2023", dateFormatter);
		
		//Imagenes de paquetes
		byte[] paq1img = this.getFile("imagenPaquete1.jpg");
		byte[] paq2img = this.getFile("imagenPaquete2.jpg");
		byte[] paq3img = this.getFile("imagenPaquete3.jpg");
		byte[] paq4img = this.getFile("imagenPaquete4.jpg");
		
		//Creo los paquetes
		
		Paquete paq1 = new Paquete();
		paq1.setNombre("Básico");
		paq1.setDescripcion("Publica ofertas laborales en nuestra plataforma por un período de 30 días.");
		paq1.setValidez(30);
		paq1.setDescuento(20);
		paq1.setFechaAlta(fhp1);
		paq1.setCosto(3720);
		paq1.setImagen(paq1img);

		Paquete paq2 = new Paquete();
		paq2.setNombre("Destacado");
		paq2.setDescripcion("Publica ofertas laborales destacadas que se mostrarán en la parte superior de los resultados de búsqueda por 45 días.");
		paq2.setValidez(45);
		paq2.setDescuento(10);
		paq2.setFechaAlta(fhp2);
		paq2.setCosto(315);
		paq2.setImagen(paq2img);

		Paquete paq3 = new Paquete();
		paq3.setNombre("Premium");
		paq3.setDescripcion("Publica ofertas laborales premium que incluyen promoción en nuestras redes sociales y listado en la sección destacada por 60 días.");
		paq3.setValidez(60);
		paq3.setDescuento(15);
		paq3.setFechaAlta(fhp3);
		paq3.setCosto(7055);
		paq3.setImagen(paq3img);

		Paquete paq4 = new Paquete();
		paq4.setNombre("Express");
		paq4.setDescripcion("Publica ofertas laborales urgentes resaltadas en color y se mostrarán en la sección de urgente por 15 días.");
		paq4.setValidez(15);
		paq4.setDescuento(5);
		paq4.setFechaAlta(fhp4);
		paq4.setCosto(950);
		paq4.setImagen(paq4img);

		//Setteo los tipos de publicacion
		
		paq1.setPublicaciones(tp1, 1);
		paq1.setPublicaciones(tp2, 1);
		paq1.setPublicaciones(tp3, 1);
		
		paq2.setPublicaciones(tp3, 2);
		paq2.setPublicaciones(tp4, 1);
		
		paq3.setPublicaciones(tp1, 2);
		paq3.setPublicaciones(tp3, 2);
		
		paq4.setPublicaciones(tp2, 2);
			
		//Los añado al manejador
		
		mpyt.addPaquete(paq1);
		mpyt.addPaquete(paq2);
		mpyt.addPaquete(paq3);
		mpyt.addPaquete(paq4);
		 
		//Asocio paquetes comprados a las empresas
		((Empresa) e1).agregarPaquetes(paq1.getNombre(), paq1);
		((Empresa) e2).agregarPaquetes(paq2.getNombre(), paq2);
		((Empresa) e6).agregarPaquetes(paq2.getNombre(), paq2);
		((Empresa) e1).agregarPaquetes(paq3.getNombre(), paq3);
		((Empresa) e1).agregarPaquetes(paq4.getNombre(), paq4);
		
		//Fechas de las compras
		LocalDate fc1 = LocalDate.parse("31-10-2023", dateFormatter); //e1 y pq3
		LocalDate fvc1 = fc1.plusDays(60);
		LocalDate fc2 = LocalDate.parse("08-10-2023", dateFormatter); 
		LocalDate fvc2 = fc2.plusDays(45);
		LocalDate fc3 = LocalDate.parse("13-10-2023", dateFormatter); 
		LocalDate fvc3 = fc3.plusDays(45);

		
		
		//Creo los compra paquete
		CompraPaquete comp1 = new CompraPaquete();
		comp1.setFechaCompr(fc1);
		comp1.setFechaVenc(fvc1);
		comp1.setPaquete(paq3);
		
		CompraPaquete comp2 = new CompraPaquete();
		comp2.setFechaCompr(fc2);
		comp2.setFechaVenc(fvc2);
		comp2.setPaquete(paq2);
		
		CompraPaquete comp3 = new CompraPaquete();
		comp3.setFechaCompr(fc3);
		comp3.setFechaVenc(fvc3);
		comp3.setPaquete(paq2);
		
		//Le asigno a cada empresa como "compra paquete" su ultimo paquete comprado
		((Empresa) e1).setCompra(comp1);
		((Empresa) e2).setCompra(comp3); //u12 
		((Empresa) e6).setCompra(comp2); //u16
		
		
	
	}		
}
