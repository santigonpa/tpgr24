package logica_Controladores;

import java.sql.Date;
import java.time.LocalTime;
import java.util.Set;

import excepciones.NombreRepetidoOfertaException;
import logica_DataTypes.DataHorario;
import logica_Entidades.Empresa;
import logica_Entidades.KeyWord;
import logica_Entidades.TipoPublicacion;

public interface IControladorOferta  {
	
	public abstract void altaPublicacionOfertaLaboral(String empresa, String tipoPubli, String nombre,
			String descripcion, LocalTime horarioInicio, LocalTime horarioFin, float remuneracion, String ciudad,
			String departamento, Date fecha, Set<String> palabrasClaveSelec) throws NombreRepetidoOfertaException;

}
