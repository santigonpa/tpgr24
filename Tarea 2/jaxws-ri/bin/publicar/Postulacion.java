
package publicar;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para postulacion complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>{@code
 * <complexType name="postulacion">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="ofertaLaboral" type="{http://publicar.controladores/}ofertaLaboral" minOccurs="0"/>
 *         <element name="postulante" type="{http://publicar.controladores/}postulante" minOccurs="0"/>
 *         <element name="fecha" type="{http://publicar.controladores/}localDate" minOccurs="0"/>
 *         <element name="curri" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="motivacion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="video" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "postulacion", propOrder = {
    "ofertaLaboral",
    "postulante",
    "fecha",
    "curri",
    "motivacion",
    "video"
})
public class Postulacion {

    protected OfertaLaboral ofertaLaboral;
    protected Postulante postulante;
    protected LocalDate fecha;
    protected String curri;
    protected String motivacion;
    protected String video;

    /**
     * Obtiene el valor de la propiedad ofertaLaboral.
     * 
     * @return
     *     possible object is
     *     {@link OfertaLaboral }
     *     
     */
    public OfertaLaboral getOfertaLaboral() {
        return ofertaLaboral;
    }

    /**
     * Define el valor de la propiedad ofertaLaboral.
     * 
     * @param value
     *     allowed object is
     *     {@link OfertaLaboral }
     *     
     */
    public void setOfertaLaboral(OfertaLaboral value) {
        this.ofertaLaboral = value;
    }

    /**
     * Obtiene el valor de la propiedad postulante.
     * 
     * @return
     *     possible object is
     *     {@link Postulante }
     *     
     */
    public Postulante getPostulante() {
        return postulante;
    }

    /**
     * Define el valor de la propiedad postulante.
     * 
     * @param value
     *     allowed object is
     *     {@link Postulante }
     *     
     */
    public void setPostulante(Postulante value) {
        this.postulante = value;
    }

    /**
     * Obtiene el valor de la propiedad fecha.
     * 
     * @return
     *     possible object is
     *     {@link LocalDate }
     *     
     */
    public LocalDate getFecha() {
        return fecha;
    }

    /**
     * Define el valor de la propiedad fecha.
     * 
     * @param value
     *     allowed object is
     *     {@link LocalDate }
     *     
     */
    public void setFecha(LocalDate value) {
        this.fecha = value;
    }

    /**
     * Obtiene el valor de la propiedad curri.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurri() {
        return curri;
    }

    /**
     * Define el valor de la propiedad curri.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurri(String value) {
        this.curri = value;
    }

    /**
     * Obtiene el valor de la propiedad motivacion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMotivacion() {
        return motivacion;
    }

    /**
     * Define el valor de la propiedad motivacion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMotivacion(String value) {
        this.motivacion = value;
    }

    /**
     * Obtiene el valor de la propiedad video.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVideo() {
        return video;
    }

    /**
     * Define el valor de la propiedad video.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVideo(String value) {
        this.video = value;
    }

}
