
package publicar;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para dataKeyWord complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>{@code
 * <complexType name="dataKeyWord">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="palabraClave" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dataKeyWord", propOrder = {
    "palabraClave"
})
public class DataKeyWord {

    protected String palabraClave;

    /**
     * Obtiene el valor de la propiedad palabraClave.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPalabraClave() {
        return palabraClave;
    }

    /**
     * Define el valor de la propiedad palabraClave.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPalabraClave(String value) {
        this.palabraClave = value;
    }

}
