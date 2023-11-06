
package publicar;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para postulante complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>{@code
 * <complexType name="postulante">
 *   <complexContent>
 *     <extension base="{http://publicar.controladores/}usuario">
 *       <sequence>
 *         <element name="nacimiento" type="{http://publicar.controladores/}localDate" minOccurs="0"/>
 *         <element name="nacionalidad" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="postulaciones" type="{http://publicar.controladores/}wrapperArrayList" minOccurs="0"/>
 *       </sequence>
 *     </extension>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "postulante", propOrder = {
    "nacimiento",
    "nacionalidad",
    "postulaciones"
})
public class Postulante
    extends Usuario
{

    protected LocalDate nacimiento;
    protected String nacionalidad;
    protected WrapperArrayList postulaciones;

    /**
     * Obtiene el valor de la propiedad nacimiento.
     * 
     * @return
     *     possible object is
     *     {@link LocalDate }
     *     
     */
    public LocalDate getNacimiento() {
        return nacimiento;
    }

    /**
     * Define el valor de la propiedad nacimiento.
     * 
     * @param value
     *     allowed object is
     *     {@link LocalDate }
     *     
     */
    public void setNacimiento(LocalDate value) {
        this.nacimiento = value;
    }

    /**
     * Obtiene el valor de la propiedad nacionalidad.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNacionalidad() {
        return nacionalidad;
    }

    /**
     * Define el valor de la propiedad nacionalidad.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNacionalidad(String value) {
        this.nacionalidad = value;
    }

    /**
     * Obtiene el valor de la propiedad postulaciones.
     * 
     * @return
     *     possible object is
     *     {@link WrapperArrayList }
     *     
     */
    public WrapperArrayList getPostulaciones() {
        return postulaciones;
    }

    /**
     * Define el valor de la propiedad postulaciones.
     * 
     * @param value
     *     allowed object is
     *     {@link WrapperArrayList }
     *     
     */
    public void setPostulaciones(WrapperArrayList value) {
        this.postulaciones = value;
    }

}
