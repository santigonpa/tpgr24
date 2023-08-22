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

public class ControladorOferta implements IControladorOferta {
	
	private static ControladorOferta instancia;
	
	private ControladorOferta() {}
	
	public static ControladorOferta getInstance() {
        if (instancia == null) {
            instancia = new ControladorOferta();
        }
        return instancia;
    }

	public void altaPublicacionOfertaLaboral(Empresa empresa, TipoPublicacion tipoPubli, String nombre,
			String descripcion, DataHorario horarioInicio, DataHorario horarioFin, int remuneracion, String ciudad,
			String departamento, Date fecha, Set<KeyWord> palabrasClaveSelec) throws NombreRepetidoOfertaException {
		
		Fabrica fabrica = Fabrica.getInstance();
		ManejadorOferta mo = fabrica.getManejadorOferta();
		
		OfertaLaboral nuevaOferta = mo.obtenerOferta(nombre);
		if(nuevaOferta != null) {throw new NombreRepetidoOfertaException("El nombre " + nombre + " ya esta registrado como una oferta"); }
		int costoOfertaLaboral;
		if(empresa.tienePaqueteAsociado()){costoOfertaLaboral = empresa.costoPaqueteAsociado();}
		else {costoOfertaLaboral = tipoPubli.getCostoAsociado();}
		nuevaOferta = new OfertaLaboral(nombre,descripcion,ciudad, 
				departamento,horarioInicio,horarioFin
				,remuneracion ,costoDeOfertaLaboral,fecha);
	}
		
	
	
}
