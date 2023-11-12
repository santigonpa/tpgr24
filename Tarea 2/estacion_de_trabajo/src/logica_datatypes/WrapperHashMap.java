package logica_datatypes;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import java.util.HashMap;

@XmlAccessorType(XmlAccessType.FIELD)
public class WrapperHashMap {

    private HashMap<String, ?> mapa;

    public WrapperHashMap() {
        this.mapa = new HashMap<>();
    }

    public WrapperHashMap(HashMap<String, ?> mapa) {
        this.mapa = mapa;
    }

    public HashMap<String, ?> getMapa() {
        return mapa;
    }

    public void setMapa(HashMap<String, ?> mapa) {
        this.mapa = mapa;
    }
}
