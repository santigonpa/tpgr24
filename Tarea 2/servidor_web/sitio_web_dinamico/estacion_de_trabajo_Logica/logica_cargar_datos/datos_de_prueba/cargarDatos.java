package logica_cargar_datos.datos_de_prueba;

import logica_manejadores.IManejadorOferta;
import logica_manejadores.IManejadorPyT;
import logica_manejadores.IManejadorUsuario;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import logica_entidades.Empresa;
import logica_entidades.KeyWord;
import logica_entidades.OfertaLaboral;
import logica_entidades.Postulacion;
import logica_entidades.Postulante;
import logica_entidades.TipoPublicacion;
import logica_entidades.Usuario;
import utils.Fabrica;

public class cargarDatos {
	public void cargar() {
		Fabrica fabrica = Fabrica.getInstance();
		IManejadorUsuario muser = fabrica.getInManejadorUsuario();
		IManejadorOferta mofer = fabrica.getInManejadorOferta();
		IManejadorPyT mpyt = fabrica.getInManejadorPyT();
				
		
		//------------------------------//
		//Carga de usuarios
		
		//Cambio formato a LocalDate
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate fech1 = LocalDate.parse("15-03-1985", dateFormatter);
		LocalDate fech2 = LocalDate.parse("21-08-1990", dateFormatter);
		LocalDate fech3 = LocalDate.parse("10-11-1988", dateFormatter);
		LocalDate fech4 = LocalDate.parse("05-06-1993", dateFormatter);
		LocalDate fech5 = LocalDate.parse("25-02-1987", dateFormatter);
		LocalDate fech6 = LocalDate.parse("12-04-1992", dateFormatter);
		LocalDate fech7 = LocalDate.parse("30-09-1989", dateFormatter);
		LocalDate fecha8 = LocalDate.parse("18-01-1995", dateFormatter);
		LocalDate fecha9 = LocalDate.parse("07-07-1991", dateFormatter);
		LocalDate fecha10 = LocalDate.parse("02-12-1986", dateFormatter);
		
		
		
		//Creo Postulantes
		Usuario postu1 = new Postulante("lgarcia", "Lucia", "Garcia", "lgarcia85@gmail.com", fech1, "Uruguaya", null, "awdrg543");
		Usuario postu2 = new Postulante("matilo", "Matias", "Lopez", "matias.lopez90@hotmail.com", fech2, "Argentina", null, "edrft543");
		Usuario postu3 = new Postulante("maro", "Maria", "Rodriguez", "marrod@gmail.com", fech3, "Uruguaya", null, "r5t6y7u8");
		Usuario postu4 = new Postulante("javierf", "Javier", "Fernandez", "javierf93@yahoo.com", fech4, "Mexicana", null, "45idgaf67");
		Usuario postu5 = new Postulante("valen25", "Valentina", "Martinez", "vale87@gmail.com", fech5, "Uruguaya", null, "poiuy987");
		Usuario postu6 = new Postulante("andpel2", "Andres", "Perez", "anpe92@hotmail.com", fech6, "Chilena" , null, "xdrgb657");
		Usuario postu7 = new Postulante("sicam", "Camila", "Silva", "camisilva89@gmail.com", fech7, "Uruguaya", null, "mnjkiu89");
		Usuario postu8 = new Postulante("sebgon", "Sebastian", "Gonzalez", "gonza95@yahoo.com", fecha8, "Colombiana", null, "ytrewq10");
		Usuario postu9 = new Postulante("isabel", "Isabella", "Lopez", "loisa@gmail.com", fecha9, "Uruguaya", null, "sbsplol1");
		Usuario postu10 = new Postulante("marram02", "Martin", "Ramirez", "marram@hotmail.com", fecha10, "Argentina", null, "okmnji98");
		
		//Creo Empresas
		Empresa empre1 = new Empresa("EcoTech", "Sophia", "Johnosn", "info@EcoTehc.com", "EcoTech Innovations es una empresa lider en soluciones tecnol´ogicas sostenibles. Nuestro enfoque se centra en desarrollar y comercializar productos y servicios que aborden los desafios ambientales mas apremiantes de nuestro tiempo. Desde sistemas de energıa renovable y dispositivos de monitorizacion ambiental hasta soluciones de gestion de residuos inteligentes, nuestra mision es proporcionar herramientas que permitan a las empresas y comunidades adoptar practicas mas ecologicas sin comprometer la eficiencia. Creemos en la convergencia armoniosa entre la tecnologia y la naturaleza, y trabajamos incansablemente para impulsar un futuro mas limpio y sostenible.", "http://www.EcoTechInnovations.com", null, "qsxcdw43");
		Empresa empre2 = new Empresa("FusionTech", "William", "Smith", "contacto@FusionTech.net", "FusionTech Dynamics es una empresa pionera en el ambito de la inteligencia artificial y la automatizacion avanzada. Nuestro equipo multidisciplinario de ingenieros, cientificos de datos y desarrolladores crea soluciones innovadoras que aprovechan la potencia de la IA para transformar industrias. Desde la optimizacion de procesos industriales hasta la creacion de asistentes virtuales altamente personalizados, nuestro objetivo es revolucionar la forma en que las empresas operan y se conectan con sus clientes. Creemos en la sinergia entre la mente humana y las capacidades de la IA, y trabajamos para construir un mundo donde la tecnologia mejore y amplie nuestras capacidades innatas.", "http://www.FusionTechDynamics.net", null, "qpwoei586");
		Empresa empre3 = new Empresa("GlobalHealth", "Isabella", "Brown", "jobs@GlobalHelath.uy", "GlobalHealth Dynamics es una empresa comprometida con el avance de la atencion medica a nivel mundial. Como lideres en el campo de la salud digital, desarrollamos plataformas y herramientas que permiten a los profesionales de la salud ofrecer diagnosticos mas precisos, tratamientos personalizados y seguimiento continuo de los pacientes. Nuestra vision es crear un ecosistema de salud conectado en el que los datos medicos se utilicen de manera etica y segura para mejorar la calidad de vida de las personas. A traves de la innovacion constante y la colaboracion con expertos medicos, estamos dando forma al futuro de la atencion medica, donde la tecnologia y la compasion se unen parasalvar vidas y mejorar el bienestar en todo el mundo.", "http://www.globalhealthdynamics.uy/info", null, "asdfg654");
		Empresa empre4 = new Empresa("ANTEL", "Washington", "Rocha", "jarrington@ANTEL.com.uy", "En Antel te brindamos servicios de vanguardia en tecnologia de comunicacion en Telefonia Movil, Fija, Banda Ancha y Datos", "ANTEL.com.uy", null, "2nru096");
		Empresa empre5 = new Empresa("MIEM", "Pablo", "Bengoechea", "eldiez@MIEM.org.uy", "Balance Energetico Nacional (BEN). La Direccion Nacional de Energia (DNE) del Ministerio de Industria, Energia y Mineria (MIEM) presenta anualmente el BEN.", "MIEM.com.uy", null, "ibii4xo");
		Empresa empre6 = new Empresa("TechSolutions", "Mercedes", "Venn", "Mercedes@TechSolutions.com.uy", "”TechSolutions Inc.” es una empresa lider en el sector de tecnologia de la informacion y el software. Se especializa en el desarrollo de soluciones de software personalizadas para empresas de diversos tamanos y sectores. Su enfoque se centra en la creacion de aplicaciones empresariales innovadoras que optimizan procesos, mejoran la eficiencia y brindan una ventaja competitiva a sus clientes.", "TechSolutions.com", null, "1ngs03p");
		
		//Agrego Usarios
		muser.addUsuario(postu1);
		muser.addUsuario(postu2);
		muser.addUsuario(postu3);
		muser.addUsuario(postu4);
		muser.addUsuario(postu5);
		muser.addUsuario(postu6);
		muser.addUsuario(postu7);
		muser.addUsuario(postu8);
		muser.addUsuario(postu9);
		muser.addUsuario(postu10);
		muser.addUsuario(empre1);
		muser.addUsuario(empre2);
		muser.addUsuario(empre3);
		muser.addUsuario(empre4);
		muser.addUsuario(empre5);
		muser.addUsuario(empre6);
		
		//------------------------------//		
		
		//Cargo Tipos de Publicacion
		
		//Cambio a LocalDate fecha de alta, fala agregarla a los parametros
		LocalDate at1 = LocalDate.parse("10-08-2023", dateFormatter);
		LocalDate at2 = LocalDate.parse("05-08-2023", dateFormatter);
		LocalDate at3 = LocalDate.parse("15-08-2023", dateFormatter);
		LocalDate at4 = LocalDate.parse("07-08-2023", dateFormatter);
		
		//Creo Tipos
		TipoPublicacion tp1 = new TipoPublicacion("Premium", "Obten maxima visibilidad.", 1, 30, 4000, at1);
		TipoPublicacion tp2 = new TipoPublicacion("Destacada", "Destaca tu anuncio", 2, 15, 500, at2);
		TipoPublicacion tp3 = new TipoPublicacion("Estandar", "Mejora la posicion de tu anuncio", 3, 20, 150, at3);
		TipoPublicacion tp4 = new TipoPublicacion("Basica", "Publica de forma sencilla en la lista de ofertas", 4, 7, 50, at4);
		
		//Agrego Tipos
		
		mpyt.addTipoPublicacion(tp1);
		mpyt.addTipoPublicacion(tp2);
		mpyt.addTipoPublicacion(tp3);
		mpyt.addTipoPublicacion(tp4);

		
		//Cargo Keywords
		KeyWord key1 = new KeyWord("Tiempo completo");
		KeyWord key2 = new KeyWord("Medio tiempo");
		KeyWord key3 = new KeyWord("Remoto");
		KeyWord key4 = new KeyWord("Freelance");
		KeyWord key5 = new KeyWord("Temporal");
		KeyWord key6 = new KeyWord("Permanente");
		KeyWord key7 = new KeyWord("Computacion");
		KeyWord key8 = new KeyWord("Administracion");
		KeyWord key9 = new KeyWord("Logistica");
		KeyWord key10 = new KeyWord("Contabilidad");
		
		//Agrego Kewword
	
		mofer.addKeyword(key1);
		mofer.addKeyword(key2);
		mofer.addKeyword(key3);
		mofer.addKeyword(key4);
		mofer.addKeyword(key5);
		mofer.addKeyword(key6);
		mofer.addKeyword(key7);
		mofer.addKeyword(key8);
		mofer.addKeyword(key9);
		mofer.addKeyword(key10);

		
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
		//HoraFinal
		LocalTime hf1 = LocalTime.parse("18:00");
		LocalTime hf2 = LocalTime.parse("17:00");
		LocalTime hf3 = LocalTime.parse("18:00");
		LocalTime hf4 = LocalTime.parse("13:00");
		LocalTime hf5 = LocalTime.parse("22:00");
		LocalTime hf6 = LocalTime.parse("18:00");
		LocalTime hf7 = LocalTime.parse("19:00");
		LocalTime hf8 = LocalTime.parse("17:30");
		
		//Convierto las Fechas

		LocalDate ao1 = LocalDate.of(2023, 8, 14);
		LocalDate ao2 = LocalDate.of(2023, 8, 14);
		LocalDate ao3 = LocalDate.of(2023, 8, 13);
		LocalDate ao4 = LocalDate.of(2023, 8, 11);
		LocalDate ao5 = LocalDate.of(2023, 8, 20);
		LocalDate ao6 = LocalDate.of(2023, 8, 15);
		LocalDate ao7 = LocalDate.of(2023, 8, 15);
		LocalDate ao8 = LocalDate.of(2023, 8, 16);
		
		
		//Creo Oferta
		OfertaLaboral oferta1 = new OfertaLaboral("Desarolaldor Frontend", "Unete a nuestro equipo de desarrollo frontend y crea experiencias de usuario excepcionales.", "Montevideo", "Montevideo", hi1, hf1, 90000, 4000, ao1, null, "Basico");
		OfertaLaboral oferta2 = new OfertaLaboral("Estrategia de Negocios", "Forma parte de nuestro equipo de estrategia y contribuye al crecimiento de las empresas clientes", "Punta del Este", "Maldonado", hi2, hf2, 80000, 150, ao2, null, "Sin paquete");
		OfertaLaboral oferta3 = new OfertaLaboral("Disenador UX/UI", "Trabaja en colaboracion con nuestro talentoso equipo de dise˜no para crear soluciones impactantes.", "Rosario", "Colonia", hi3, hf3, 65000, 150, ao3, null, "Sin paquete");
		OfertaLaboral oferta4 = new OfertaLaboral("Analista de Datos", "Ayuda a nuestros clientes a tomar decisiones informadas basadas en an´alisis y visualizaciones de datos.", "Maldonado", "Maldonado", hi4, hf4, 40000, 4000, ao4, null, "Sin paquete");
		OfertaLaboral oferta5 = new OfertaLaboral("Content Manager", "Gestiona y crea contenido persuasivo y relevante para impulsar la presencia en linea de nuestros clientes.", "Montevideo", "Montevideo", hi5, hf5, 10000, 500, ao5, null, "Sin paquete");
		OfertaLaboral oferta6 = new OfertaLaboral("Soporte Tecnico", "Ofrece un excelente servicio de soporte t´ecnico a nuestros clientes, resolviendo problemas y brindando soluciones.", "Minas", "Lavalleja", hi6, hf6, 30000, 50, ao6, null, "Destacado");
		OfertaLaboral oferta7 = new OfertaLaboral("A. de Marketing Digital", "Unete a nuestro equipo de marketing y trabaja en estrategias digitales innovadoras.", "Flores", "Flores", hi7, hf7, 80000, 4000, ao7, null, "Sin paquete");
		OfertaLaboral oferta8 = new OfertaLaboral("Contador Senior", "Unete a nuestro equipo contable y ayuda en la gestion financiera de la empresa.", "Colonia Suiza", "Colonia", hi8, hf8, 10000, 500, ao8, null, "Sin paquete");
		
		//Agrego oferta a Empresa
		empre1.agregarOfertas(oferta1.getNombreOferta(), oferta1);
		empre3.agregarOfertas(oferta2.getNombreOferta(), oferta2);
		empre2.agregarOfertas(oferta3.getNombreOferta(), oferta3);
		empre4.agregarOfertas(oferta4.getNombreOferta(), oferta4);
		empre5.agregarOfertas(oferta5.getNombreOferta(), oferta5);
		empre6.agregarOfertas(oferta6.getNombreOferta(), oferta6);
		empre1.agregarOfertas(oferta7.getNombreOferta(), oferta7);
		empre3.agregarOfertas(oferta8.getNombreOferta(), oferta8);
		
		//Agrego Empresa a Oferta
		oferta1.setEmpresa((Empresa) empre1);
		oferta2.setEmpresa((Empresa) empre3);
		oferta3.setEmpresa((Empresa) empre2);
		oferta4.setEmpresa((Empresa) empre4);
		oferta5.setEmpresa((Empresa) empre5);
		oferta6.setEmpresa((Empresa) empre6);
		oferta7.setEmpresa((Empresa) empre1);
		oferta8.setEmpresa((Empresa) empre3);

		
		//Agrego Oferta 
	
		mofer.addOferta(oferta1);
		mofer.addOferta(oferta2);
		mofer.addOferta(oferta3);
		mofer.addOferta(oferta4);
		mofer.addOferta(oferta5);
		mofer.addOferta(oferta6);
		mofer.addOferta(oferta7);
		mofer.addOferta(oferta8);
		
		
		//Agrego Keyword a Oferta
			
		oferta1.agregarKeywordAOferta(key1);
		oferta1.agregarKeywordAOferta(key2);
		oferta1.agregarKeywordAOferta(key3);
		oferta1.agregarKeywordAOferta(key4);
		oferta1.agregarKeywordAOferta(key5);
		oferta1.agregarKeywordAOferta(key6);
		
		oferta2.agregarKeywordAOferta(key5);
		
		oferta3.agregarKeywordAOferta(key2);
		oferta3.agregarKeywordAOferta(key3);
		oferta3.agregarKeywordAOferta(key6);
		
		oferta4.agregarKeywordAOferta(key2);
		
		oferta5.agregarKeywordAOferta(key4);
		
		oferta6.agregarKeywordAOferta(key1);
		
		//Agrego oferta a KeyWord
		key1.agregarOfertaAKeyWord(oferta1);
		key2.agregarOfertaAKeyWord(oferta1);
		key3.agregarOfertaAKeyWord(oferta1);
		key4.agregarOfertaAKeyWord(oferta1);
		key5.agregarOfertaAKeyWord(oferta1);
		key6.agregarOfertaAKeyWord(oferta1);
		
		key5.agregarOfertaAKeyWord(oferta2);
		
		key2.agregarOfertaAKeyWord(oferta3);
		key3.agregarOfertaAKeyWord(oferta3);
		key6.agregarOfertaAKeyWord(oferta3);

		key2.agregarOfertaAKeyWord(oferta4);
		
		key4.agregarOfertaAKeyWord(oferta5);
		
		key1.agregarOfertaAKeyWord(oferta6);
		
		//Linkeo Tipo con Oferta 

		oferta1.setTipoPublicacion(tp1);
		oferta2.setTipoPublicacion(tp3);
		oferta3.setTipoPublicacion(tp3);
		oferta4.setTipoPublicacion(tp1);
		oferta5.setTipoPublicacion(tp2);
		oferta6.setTipoPublicacion(tp4);
		oferta7.setTipoPublicacion(tp1);
		oferta8.setTipoPublicacion(tp2);

		
		//------------------------------//	
		
		//Convierto String a LocalDate
		LocalDate fPos1 = LocalDate.parse("16-08-2023", dateFormatter);
		LocalDate fPos2 = LocalDate.parse("15-08-2023", dateFormatter);
		LocalDate fPos3 = LocalDate.parse("14-08-2023", dateFormatter);
		LocalDate fPos4 = LocalDate.parse("13-08-2023", dateFormatter);
		LocalDate fPos5 = LocalDate.parse("12-08-2023", dateFormatter);
		LocalDate fPos6 = LocalDate.parse("16-08-2023", dateFormatter);
		
		
		//Creo Postulaciones
		Postulacion pos1 = new Postulacion(fPos1, "Licenciada en Administracion, experiencia en gestion de equipos y proyectos. Conocimientos en Office.", "Estoy emocionada por la oportunidad de formar parte de un equipo dinamico y contribuir con mis habilidades de liderazgo.", (Postulante) postu1, oferta1);
		Postulacion pos2 = new Postulacion(fPos2, "Estudiante de Comunicacion, habilidades en redacci´on y manejo de redes sociales. Experiencia en practicas en medios locales", "Me encantaria formar parte de un equipo que me permita desarrollar mis habilidades en comunicacion y marketing.", (Postulante) postu2, oferta2);
		Postulacion pos3 = new Postulacion(fPos3, "Ingeniero en Sistemas, experiencia en desarrollo web y aplicaciones moviles. Conocimientos en JavaScript y React.", "Me entusiasma la posibilidad de trabajar en proyectos desafiantes y seguir creciendo como profesional en el campo de la tecnolog´ıa.", (Postulante) postu3, oferta1);
		Postulacion pos4 = new Postulacion(fPos4, "T´ecnico en Electricidad, experiencia en mantenimiento industrial. Conocimientos en lectura de planos el´ectricos.", "Estoy interesado en formar parte de un equipo que me permita aplicar mis habilidades t´ecnicas y contribuir al mantenimiento eficiente.", (Postulante) postu4, oferta3);
		Postulacion pos5 = new Postulacion(fPos5, "M´usico profesional, experiencia en espect´aculos en vivo. Habilidades en canto y guitarra.", "Me gustar´ıa combinar mi pasi´on por la m´usica con una oportunidad laboral que me permita seguir creciendo como artista.", (Postulante) postu5, oferta2);
		Postulacion pos6 = new Postulacion(fPos6, "Licenciada en Administraci´on, me considero genia, experiencia en gesti´on de equipos y proyectos. Conocimientos en Microsoft Office.", "Estoy emocionada por la oportunidad de formar parte de un equipo din´amico y contribuir con mis habilidades de liderazgo.", (Postulante) postu1, oferta2);
		
		mofer.addPostulacion(pos1);
		mofer.addPostulacion(pos2);
		mofer.addPostulacion(pos3);
		mofer.addPostulacion(pos4);
		mofer.addPostulacion(pos5);
		mofer.addPostulacion(pos6);
		
		oferta1.agregarPostulacionAOferta(pos1);
		oferta2.agregarPostulacionAOferta(pos2);
		oferta1.agregarPostulacionAOferta(pos3);
		oferta3.agregarPostulacionAOferta(pos4);
		oferta2.agregarPostulacionAOferta(pos5);
		oferta2.agregarPostulacionAOferta(pos1);
		
		//------------------------------//	
		//Falta todo lo de Paquete que es opcional, veremos si se hace.
		//.........//
		
		
	}
	

}
