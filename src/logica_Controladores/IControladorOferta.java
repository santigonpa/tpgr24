package logica_Controladores;

import java.sql.Date;
import java.util.Set;

import excepciones.NombreRepetidoOfertaException;
import logica_DataTypes.DataHorario;
import logica_Entidades.Empresa;
import logica_Entidades.KeyWord;
import logica_Entidades.TipoPublicacion;

public interface IControladorOferta  {
	
	public abstract void altaPublicacionOfertaLaboral(Empresa empresa, TipoPublicacion tipoPubli, String nombre,
			String descripcion, DataHorario horarioInicio, DataHorario horarioFin, int remuneracion, String ciudad,
			String departamento, Date fecha, Set<KeyWord> palabrasClaveSelec) throws NombreRepetidoOfertaException;

}
