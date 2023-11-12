package logica_entidades;

import java.io.Serializable;
import java.util.Objects;

public class PostulacionId implements Serializable {
    private int ofertaLaboral;
    private int postulante;

    public PostulacionId() {
        // Constructor vacío necesario para JPA
    }

    public PostulacionId(int ofertaLaboralId, int postulanteId) {
        this.ofertaLaboral = ofertaLaboralId;
        this.postulante = postulanteId;
    }

    public int getOfertaLaboralId() {
        return ofertaLaboral;
    }

    public void setOfertaLaboralId(int ofertaLaboralId) {
        this.ofertaLaboral = ofertaLaboralId;
    }

    public int getPostulanteId() {
        return postulante;
    }

    public void setPostulanteId(int postulanteId) {
        this.postulante = postulanteId;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostulacionId that = (PostulacionId) o;
        return Objects.equals(ofertaLaboral, that.ofertaLaboral) &&
                Objects.equals(postulante, that.postulante);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ofertaLaboral, postulante);
    }
    
    // Constructores, getters, setters, y hashCode/equals necesarios
}