package logica_Controladores;

import java.sql.Date;
import java.util.Set;

import excepciones.NombreRepetidoOfertaException;
import logica_DataTypes.DataHorario;
import logica_Entidades.Empresa;
import logica_Entidades.TipoPublicacion;
import utils.Fabrica;
import logica_Entidades.KeyWord;
import logica_Entidades.OfertaLaboral;
import logica_Manejadores.ManejadorOferta;
import logica_Manejadores.ManejadorPaquetesYTiposPubli;
import logica_Manejadores.ManejadorUsuario;

public class ControladorOferta implements IControladorOferta {
	
	private static ControladorOferta instancia;
	
	private ControladorOferta() {}
	
	public static ControladorOferta getInstance() {
        if (instancia == null) {
            instancia = new ControladorOferta();
        }
        return instancia;
    }

	public void altaPublicacionOfertaLaboral(String empresa,String tipoPubli, String nombre,
			String descripcion, DataHorario horarioInicio, DataHorario horarioFin, int remuneracion, String ciudad,
			String departamento, Date fecha, Set<String> palabrasClaveSelec) throws NombreRepetidoOfertaException {
		
		Fabrica fabrica = Fabrica.getInstance();
		ManejadorUsuario mu = fabrica.getManejadorUsuario();
		ManejadorOferta mo = fabrica.getManejadorOferta();
		ManejadorPaquetesYTiposPubli mpt = fabrica.getManejadorPaquetesYTiposPubli();
		
		OfertaLaboral nuevaOferta = mo.obtenerOferta(nombre);
		if(nuevaOferta != null){throw new NombreRepetidoOfertaException("El nombre " + nombre + " ya esta registrado como una oferta"); }
		int costoOfertaLaboral;
		//busco Empresa
		Empresa emp = mu.obtenerUsuario(empresa);
		
		//busco tipo de publicacion
		TipoPublicacion tp = mpt.obtenerTipoPublicacion(tipoPubli);
		
		//pregunto si tiene costo asociado al paquete 
		if(emp.tienePaqueteAsociado()){costoOfertaLaboral = empresa.costoPaqueteAsociado();}
		else{costoOfertaLaboral = tp.getCostoAsociado();}
		//se crea la nueva oferta
		nuevaOferta = new OfertaLaboral(nombre,descripcion,ciudad, 
				departamento,horarioInicio,horarioFin
				,remuneracion ,costoDeOfertaLaboral,fecha);
		
		nuevaOferta.setEmpresa(emp);
		emp.linkearOfertaEmpresa(nuevaOferta);
		nuevaOferta.setTipoPublicacion(tp);
		mo.linkearKeywords(palabrasClaveSelec,nombre); //linkea la coleccion de keywords a la oferta
		mo.addOferta(nuevaOferta);
			
	}
		
	
	
}
