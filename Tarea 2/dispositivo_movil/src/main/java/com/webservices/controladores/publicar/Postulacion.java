
package com.webservices.controladores.publicar;

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
 *         <element name="fecha" type="{http://publicar.controladores/}localDate" minOccurs="0"/>
 *         <element name="curri" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="motivacion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="post" type="{http://publicar.controladores/}postulante" minOccurs="0"/>
 *         <element name="ofer" type="{http://publicar.controladores/}ofertaLaboral" minOccurs="0"/>
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
    "fecha",
    "curri",
    "motivacion",
    "post",
    "ofer"
})
public class Postulacion {

    protected LocalDate fecha;
    protected String curri;
    protected String motivacion;
    protected Postulante post;
    protected OfertaLaboral ofer;

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
     * Obtiene el valor de la propiedad post.
     * 
     * @return
     *     possible object is
     *     {@link Postulante }
     *     
     */
    public Postulante getPost() {
        return post;
    }

    /**
     * Define el valor de la propiedad post.
     * 
     * @param value
     *     allowed object is
     *     {@link Postulante }
     *     
     */
    public void setPost(Postulante value) {
        this.post = value;
    }

    /**
     * Obtiene el valor de la propiedad ofer.
     * 
     * @return
     *     possible object is
     *     {@link OfertaLaboral }
     *     
     */
    public OfertaLaboral getOfer() {
        return ofer;
    }

    /**
     * Define el valor de la propiedad ofer.
     * 
     * @param value
     *     allowed object is
     *     {@link OfertaLaboral }
     *     
     */
    public void setOfer(OfertaLaboral value) {
        this.ofer = value;
    }

}
