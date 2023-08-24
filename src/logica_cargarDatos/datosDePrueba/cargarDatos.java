package logica_cargarDatos.datosDePrueba;

import logica_Entidades.Postulante;
import logica_Entidades.Usuario;
import logica_Manejadores.IManejadorOferta;
import logica_Manejadores.IManejadorPyT;
import logica_Manejadores.IManejadorUsuario;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import utils.Fabrica;

public class cargarDatos {
	Fabrica fabrica = Fabrica.getInstance();
	IManejadorUsuario mu = fabrica.getInManejadorUsuario();
	IManejadorOferta mo = fabrica.getInManejadorOferta();
	IManejadorPyT mpyt = fabrica.getInManejadorPyT();
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
	
	
	Usuario P1 = new Postulante("lgarcia","Lucia","Garcia","lgarcia85@gmail.com",n1,"Uruguaya");
	Usuario P2 = new Postulante("matilo","Matias","Lopez","matias.lopez90@hotmail.com",n2,"Argentina");
	Usuario P3 = new Postulante("maro","Maria","Rodriguez","marrod@gmail.com",n3,"Uruguaya");
	Usuario P4 = new Postulante("javierf","Javier","Fernandez","javierf93@yahoo.com",n4,"Mexicana");
	Usuario P5 = new Postulante("valen25","Valentina","Martinez","vale87@gmail.com",n5,"Uruguaya");
	Usuario P6 = new Postulante("andpel2","Andres","Perez","anpe92@hotmail.com",n6,"Chilena");
	Usuario P7 = new Postulante("sicam","Camila","Silva","camisilva89@gmail.com",n7,"Uruguaya");
	Usuario P8 = new Postulante("sebgon","Sebastian","Gonzalez","gonza95@yahoo.com",n8,"Colombiana");
	Usuario P9 = new Postulante("isabel","Isabella","Lopez","loisa@gmail.com",n9,"Uruguaya");
	Usuario P10 = new Postulante("marram02","Martin","Ramirez","marram@hotmail.com",n10,"Argentina");
	


}
