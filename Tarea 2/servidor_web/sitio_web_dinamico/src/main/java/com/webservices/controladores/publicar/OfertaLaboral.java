
package com.webservices.controladores.publicar;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ofertaLaboral complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>{@code
 * <complexType name="ofertaLaboral">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         <element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="descripcion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="ciudad" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="departamento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="horaInicio" type="{http://publicar.controladores/}localTime" minOccurs="0"/>
 *         <element name="horaFin" type="{http://publicar.controladores/}localTime" minOccurs="0"/>
 *         <element name="remuneracion" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         <element name="costoDeOfertaLaboral" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         <element name="fechaDeAlta" type="{http://publicar.controladores/}localDate" minOccurs="0"/>
 *         <element name="fechaDeFinalizacion" type="{http://publicar.controladores/}localDate" minOccurs="0"/>
 *         <element name="estado" type="{http://publicar.controladores/}estadoOferta" minOccurs="0"/>
 *         <element name="imagen" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         <element name="tipoDePago" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="ordenPostulaciones" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         <element name="postulacionesSobreLaOferta" type="{http://publicar.controladores/}postulacion" maxOccurs="unbounded" minOccurs="0"/>
 *         <element name="empresaAsociada" type="{http://publicar.controladores/}empresa" minOccurs="0"/>
 *         <element name="tipoDeOferta" type="{http://publicar.controladores/}tipoPublicacion" minOccurs="0"/>
 *         <element name="palabrasClave" type="{http://publicar.controladores/}keyWord" maxOccurs="unbounded" minOccurs="0"/>
 *         <element name="fechaCalif" type="{http://publicar.controladores/}localDate" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ofertaLaboral", propOrder = {
    "id",
    "nombre",
    "descripcion",
    "ciudad",
    "departamento",
    "horaInicio",
    "horaFin",
    "remuneracion",
    "costoDeOfertaLaboral",
    "fechaDeAlta",
    "fechaDeFinalizacion",
    "estado",
    "imagen",
    "tipoDePago",
    "ordenPostulaciones",
    "postulacionesSobreLaOferta",
    "empresaAsociada",
    "tipoDeOferta",
    "palabrasClave",
    "fechaCalif"
})
public class OfertaLaboral {

    protected int id;
    protected String nombre;
    protected String descripcion;
    protected String ciudad;
    protected String departamento;
    protected LocalTime horaInicio;
    protected LocalTime horaFin;
    protected int remuneracion;
    protected int costoDeOfertaLaboral;
    protected LocalDate fechaDeAlta;
    protected LocalDate fechaDeFinalizacion;
    @XmlSchemaType(name = "string")
    protected EstadoOferta estado;
    protected byte[] imagen;
    protected String tipoDePago;
    @XmlElement(nillable = true)
    protected List<String> ordenPostulaciones;
    @XmlElement(nillable = true)
    protected List<Postulacion> postulacionesSobreLaOferta;
    protected Empresa empresaAsociada;
    protected TipoPublicacion tipoDeOferta;
    @XmlElement(nillable = true)
    protected List<KeyWord> palabrasClave;
    protected LocalDate fechaCalif;

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
     * Obtiene el valor de la propiedad descripcion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Define el valor de la propiedad descripcion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescripcion(String value) {
        this.descripcion = value;
    }

    /**
     * Obtiene el valor de la propiedad ciudad.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * Define el valor de la propiedad ciudad.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCiudad(String value) {
        this.ciudad = value;
    }

    /**
     * Obtiene el valor de la propiedad departamento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDepartamento() {
        return departamento;
    }

    /**
     * Define el valor de la propiedad departamento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDepartamento(String value) {
        this.departamento = value;
    }

    /**
     * Obtiene el valor de la propiedad horaInicio.
     * 
     * @return
     *     possible object is
     *     {@link LocalTime }
     *     
     */
    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    /**
     * Define el valor de la propiedad horaInicio.
     * 
     * @param value
     *     allowed object is
     *     {@link LocalTime }
     *     
     */
    public void setHoraInicio(LocalTime value) {
        this.horaInicio = value;
    }

    /**
     * Obtiene el valor de la propiedad horaFin.
     * 
     * @return
     *     possible object is
     *     {@link LocalTime }
     *     
     */
    public LocalTime getHoraFin() {
        return horaFin;
    }

    /**
     * Define el valor de la propiedad horaFin.
     * 
     * @param value
     *     allowed object is
     *     {@link LocalTime }
     *     
     */
    public void setHoraFin(LocalTime value) {
        this.horaFin = value;
    }

    /**
     * Obtiene el valor de la propiedad remuneracion.
     * 
     */
    public int getRemuneracion() {
        return remuneracion;
    }

    /**
     * Define el valor de la propiedad remuneracion.
     * 
     */
    public void setRemuneracion(int value) {
        this.remuneracion = value;
    }

    /**
     * Obtiene el valor de la propiedad costoDeOfertaLaboral.
     * 
     */
    public int getCostoDeOfertaLaboral() {
        return costoDeOfertaLaboral;
    }

    /**
     * Define el valor de la propiedad costoDeOfertaLaboral.
     * 
     */
    public void setCostoDeOfertaLaboral(int value) {
        this.costoDeOfertaLaboral = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaDeAlta.
     * 
     * @return
     *     possible object is
     *     {@link LocalDate }
     *     
     */
    public LocalDate getFechaDeAlta() {
        return fechaDeAlta;
    }

    /**
     * Define el valor de la propiedad fechaDeAlta.
     * 
     * @param value
     *     allowed object is
     *     {@link LocalDate }
     *     
     */
    public void setFechaDeAlta(LocalDate value) {
        this.fechaDeAlta = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaDeFinalizacion.
     * 
     * @return
     *     possible object is
     *     {@link LocalDate }
     *     
     */
    public LocalDate getFechaDeFinalizacion() {
        return fechaDeFinalizacion;
    }

    /**
     * Define el valor de la propiedad fechaDeFinalizacion.
     * 
     * @param value
     *     allowed object is
     *     {@link LocalDate }
     *     
     */
    public void setFechaDeFinalizacion(LocalDate value) {
        this.fechaDeFinalizacion = value;
    }

    /**
     * Obtiene el valor de la propiedad estado.
     * 
     * @return
     *     possible object is
     *     {@link EstadoOferta }
     *     
     */
    public EstadoOferta getEstado() {
        return estado;
    }

    /**
     * Define el valor de la propiedad estado.
     * 
     * @param value
     *     allowed object is
     *     {@link EstadoOferta }
     *     
     */
    public void setEstado(EstadoOferta value) {
        this.estado = value;
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
     * Obtiene el valor de la propiedad tipoDePago.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoDePago() {
        return tipoDePago;
    }

    /**
     * Define el valor de la propiedad tipoDePago.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoDePago(String value) {
        this.tipoDePago = value;
    }

    /**
     * Gets the value of the ordenPostulaciones property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a {@code set} method for the ordenPostulaciones property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOrdenPostulaciones().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     * @return
     *     The value of the ordenPostulaciones property.
     */
    public List<String> getOrdenPostulaciones() {
        if (ordenPostulaciones == null) {
            ordenPostulaciones = new ArrayList<>();
        }
        return this.ordenPostulaciones;
    }

    /**
     * Gets the value of the postulacionesSobreLaOferta property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a {@code set} method for the postulacionesSobreLaOferta property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPostulacionesSobreLaOferta().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Postulacion }
     * 
     * 
     * @return
     *     The value of the postulacionesSobreLaOferta property.
     */
    public List<Postulacion> getPostulacionesSobreLaOferta() {
        if (postulacionesSobreLaOferta == null) {
            postulacionesSobreLaOferta = new ArrayList<>();
        }
        return this.postulacionesSobreLaOferta;
    }

    /**
     * Obtiene el valor de la propiedad empresaAsociada.
     * 
     * @return
     *     possible object is
     *     {@link Empresa }
     *     
     */
    public Empresa getEmpresaAsociada() {
        return empresaAsociada;
    }

    /**
     * Define el valor de la propiedad empresaAsociada.
     * 
     * @param value
     *     allowed object is
     *     {@link Empresa }
     *     
     */
    public void setEmpresaAsociada(Empresa value) {
        this.empresaAsociada = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoDeOferta.
     * 
     * @return
     *     possible object is
     *     {@link TipoPublicacion }
     *     
     */
    public TipoPublicacion getTipoDeOferta() {
        return tipoDeOferta;
    }

    /**
     * Define el valor de la propiedad tipoDeOferta.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoPublicacion }
     *     
     */
    public void setTipoDeOferta(TipoPublicacion value) {
        this.tipoDeOferta = value;
    }

    /**
     * Gets the value of the palabrasClave property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a {@code set} method for the palabrasClave property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPalabrasClave().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link KeyWord }
     * 
     * 
     * @return
     *     The value of the palabrasClave property.
     */
    public List<KeyWord> getPalabrasClave() {
        if (palabrasClave == null) {
            palabrasClave = new ArrayList<>();
        }
        return this.palabrasClave;
    }

    /**
     * Obtiene el valor de la propiedad fechaCalif.
     * 
     * @return
     *     possible object is
     *     {@link LocalDate }
     *     
     */
    public LocalDate getFechaCalif() {
        return fechaCalif;
    }

    /**
     * Define el valor de la propiedad fechaCalif.
     * 
     * @param value
     *     allowed object is
     *     {@link LocalDate }
     *     
     */
    public void setFechaCalif(LocalDate value) {
        this.fechaCalif = value;
    }

}
