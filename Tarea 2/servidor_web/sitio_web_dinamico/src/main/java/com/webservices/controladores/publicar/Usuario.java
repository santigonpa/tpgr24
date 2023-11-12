
package com.webservices.controladores.publicar;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para usuario complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>{@code
 * <complexType name="usuario">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         <element name="nickName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="apellido" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="empresa" type="{http://publicar.controladores/}empresa" minOccurs="0"/>
 *         <element name="postulante" type="{http://publicar.controladores/}postulante" minOccurs="0"/>
 *         <element name="psw" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="imagen" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         <element name="usuariosQueMeSiguen" type="{http://publicar.controladores/}usuario" maxOccurs="unbounded" minOccurs="0"/>
 *         <element name="usuariosQueYoSigo" type="{http://publicar.controladores/}usuario" maxOccurs="unbounded" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "usuario", propOrder = {
    "id",
    "nickName",
    "nombre",
    "apellido",
    "email",
    "empresa",
    "postulante",
    "psw",
    "imagen",
    "usuariosQueMeSiguen",
    "usuariosQueYoSigo"
})
@XmlSeeAlso({
    Empresa.class,
    Postulante.class
})
public abstract class Usuario {

    protected int id;
    protected String nickName;
    protected String nombre;
    protected String apellido;
    protected String email;
    protected Empresa empresa;
    protected Postulante postulante;
    protected String psw;
    protected byte[] imagen;
    @XmlElement(nillable = true)
    protected List<Usuario> usuariosQueMeSiguen;
    @XmlElement(nillable = true)
    protected List<Usuario> usuariosQueYoSigo;

    /**
     * Obtiene el valor de la propiedad id.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Define el valor de la propiedad id.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Obtiene el valor de la propiedad nickName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * Define el valor de la propiedad nickName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNickName(String value) {
        this.nickName = value;
    }

    /**
     * Obtiene el valor de la propiedad nombre.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Define el valor de la propiedad nombre.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombre(String value) {
        this.nombre = value;
    }

    /**
     * Obtiene el valor de la propiedad apellido.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Define el valor de la propiedad apellido.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApellido(String value) {
        this.apellido = value;
    }

    /**
     * Obtiene el valor de la propiedad email.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmail() {
        return email;
    }

    /**
     * Define el valor de la propiedad email.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmail(String value) {
        this.email = value;
    }

    /**
     * Obtiene el valor de la propiedad empresa.
     * 
     * @return
     *     possible object is
     *     {@link Empresa }
     *     
     */
    public Empresa getEmpresa() {
        return empresa;
    }

    /**
     * Define el valor de la propiedad empresa.
     * 
     * @param value
     *     allowed object is
     *     {@link Empresa }
     *     
     */
    public void setEmpresa(Empresa value) {
        this.empresa = value;
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
     * Obtiene el valor de la propiedad psw.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPsw() {
        return psw;
    }

    /**
     * Define el valor de la propiedad psw.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPsw(String value) {
        this.psw = value;
    }

    /**
     * Obtiene el valor de la propiedad imagen.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getImagen() {
        return imagen;
    }

    /**
     * Define el valor de la propiedad imagen.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setImagen(byte[] value) {
        this.imagen = value;
    }

    /**
     * Gets the value of the usuariosQueMeSiguen property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a {@code set} method for the usuariosQueMeSiguen property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUsuariosQueMeSiguen().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Usuario }
     * 
     * 
     * @return
     *     The value of the usuariosQueMeSiguen property.
     */
    public List<Usuario> getUsuariosQueMeSiguen() {
        if (usuariosQueMeSiguen == null) {
            usuariosQueMeSiguen = new ArrayList<>();
        }
        return this.usuariosQueMeSiguen;
    }

    /**
     * Gets the value of the usuariosQueYoSigo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a {@code set} method for the usuariosQueYoSigo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUsuariosQueYoSigo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Usuario }
     * 
     * 
     * @return
     *     The value of the usuariosQueYoSigo property.
     */
    public List<Usuario> getUsuariosQueYoSigo() {
        if (usuariosQueYoSigo == null) {
            usuariosQueYoSigo = new ArrayList<>();
        }
        return this.usuariosQueYoSigo;
    }

}
