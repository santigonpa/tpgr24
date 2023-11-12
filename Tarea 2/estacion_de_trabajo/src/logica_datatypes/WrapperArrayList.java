package logica_datatypes;

import jakarta.xml.bind.annotation.XmlAccessorType;

import java.util.ArrayList;

import jakarta.xml.bind.annotation.XmlAccessType;


@XmlAccessorType(XmlAccessType.FIELD)
public class WrapperArrayList {

	private ArrayList<?> lista;
	
	public WrapperArrayList() {
	    this.lista = new ArrayList<>();
	  }
	
	public WrapperArrayList(ArrayList<?> lista) {
	    this.lista = lista;
	  }
	
	public ArrayList<?> getLista() {
	    return lista;
	  }
	
	public void setLista(ArrayList<?> lista) {
	    this.lista = lista;
	  }
	
		
}
