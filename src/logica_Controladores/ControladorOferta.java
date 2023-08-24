package logica_Controladores;

import java.time.LocalTime;
import java.util.Set;

import excepciones.NombreRepetidoOfertaException;
import logica_Entidades.Empresa;
import logica_Entidades.TipoPublicacion;
import utils.Fabrica;
import logica_Entidades.OfertaLaboral;
import logica_Manejadores.IManejadorOferta;
import logica_Manejadores.IManejadorPyT;
import logica_Manejadores.IManejadorUsuario;

public class ControladorOferta implements IControladorOferta {
	
	private static ControladorOferta instancia;
	
	private ControladorOferta() {}
	
	public static ControladorOferta getInstance() {
        if (instancia == null) {
            instancia = new ControladorOferta();
        }
        return instancia;
    }

	public void altaPublicacionOfertaLaboral(String empresa, String tipoPubli, String nombre,
			String descripcion, LocalTime horarioInicio, LocalTime horarioFin, float remuneracion, String ciudad,
			String departamento, java.util.Date fecha, Set<String> palabrasClaveSelec) throws NombreRepetidoOfertaException {
		
		Fabrica fabrica = Fabrica.getInstance();
		IManejadorUsuario mu = fabrica.getInManejadorUsuario();
		IManejadorOferta mo = fabrica.getInManejadorOferta();
		IManejadorPyT mpt = fabrica.getInManejadorPyT();
		
		OfertaLaboral nuevaOferta = mo.obtenerOferta(nombre);
		if(nuevaOferta != null){throw new NombreRepetidoOfertaException("El nombre " + nombre + " ya esta registrado como una oferta"); }
		float costoOfertaLaboral;
		//busco Empresa
		Empresa emp = (Empresa) mu.obtenerUsuario(empresa);
		
		//busco tipo de publicacion
		TipoPublicacion tp = mpt.obtenerTipoPublicacion(tipoPubli);
		
		//pregunto si tiene costo asociado al paquete 
		if(emp.tienePaqueteAsociado()){costoOfertaLaboral = (float) emp.costoPaqueteAsociado();}
		else{costoOfertaLaboral = (float) tp.getCosto();}
		//se crea la nueva oferta
		nuevaOferta = new OfertaLaboral(nombre,descripcion,ciudad, 
				departamento,horarioInicio,horarioFin
				, remuneracion , costoOfertaLaboral,  fecha);
		
		nuevaOferta.setEmpresa(emp);
		emp.linkearOfertaEmpresa(nuevaOferta,nombre);
		nuevaOferta.setTipoPublicacion(tp);
		mo.linkearKeywords(palabrasClaveSelec,nuevaOferta); //linkea la coleccion de keywords a la oferta
		mo.addOferta(nuevaOferta);
			
	}

		
	
	
}
