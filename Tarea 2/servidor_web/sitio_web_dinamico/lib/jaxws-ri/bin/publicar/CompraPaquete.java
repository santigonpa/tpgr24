
package publicar;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para compraPaquete complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>{@code
 * <complexType name="compraPaquete">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="fechaCompra" type="{http://publicar.controladores/}localDate" minOccurs="0"/>
 *         <element name="fechaVenc" type="{http://publicar.controladores/}localDate" minOccurs="0"/>
 *         <element name="paqCompr" type="{http://publicar.controladores/}paquete" minOccurs="0"/>
 *         <element name="tipoPublicaciones" type="{http://publicar.controladores/}tipoPublicacion" maxOccurs="unbounded" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "compraPaquete", propOrder = {
    "fechaCompra",
    "fechaVenc",
    "paqCompr",
    "tipoPublicaciones"
})
public class CompraPaquete {

    protected LocalDate fechaCompra;
    protected LocalDate fechaVenc;
    protected Paquete paqCompr;
    @XmlElement(nillable = true)
    protected List<TipoPublicacion> tipoPublicaciones;

    /**
     * Obtiene el valor de la propiedad fechaCompra.
     * 
     * @return
     *     possible object is
     *     {@link LocalDate }
     *     
     */
    public LocalDate getFechaCompra() {
        return fechaCompra;
    }

    /**
     * Define el valor de la propiedad fechaCompra.
     * 
     * @param value
     *     allowed object is
     *     {@link LocalDate }
     *     
     */
    public void setFechaCompra(LocalDate value) {
        this.fechaCompra = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaVenc.
     * 
     * @return
     *     possible object is
     *     {@link LocalDate }
     *     
     */
    public LocalDate getFechaVenc() {
        return fechaVenc;
    }

    /**
     * Define el valor de la propiedad fechaVenc.
     * 
     * @param value
     *     allowed object is
     *     {@link LocalDate }
     *     
     */
    public void setFechaVenc(LocalDate value) {
        this.fechaVenc = value;
    }

    /**
     * Obtiene el valor de la propiedad paqCompr.
     * 
     * @return
     *     possible object is
     *     {@link Paquete }
     *     
     */
    public Paquete getPaqCompr() {
        return paqCompr;
    }

    /**
     * Define el valor de la propiedad paqCompr.
     * 
     * @param value
     *     allowed object is
     *     {@link Paquete }
     *     
     */
    public void setPaqCompr(Paquete value) {
        this.paqCompr = value;
    }

    /**
     * Gets the value of the tipoPublicaciones property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a {@code set} method for the tipoPublicaciones property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTipoPublicaciones().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TipoPublicacion }
     * 
     * 
     * @return
     *     The value of the tipoPublicaciones property.
     */
    public List<TipoPublicacion> getTipoPublicaciones() {
        if (tipoPublicaciones == null) {
            tipoPublicaciones = new ArrayList<>();
        }
        return this.tipoPublicaciones;
    }

}
