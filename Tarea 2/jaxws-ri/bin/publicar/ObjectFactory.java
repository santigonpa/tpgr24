
package publicar;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the publicar package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _EmailYaExisteException_QNAME = new QName("http://publicar.controladores/", "EmailYaExisteException");
    private final static QName _NicknameYaExisteException_QNAME = new QName("http://publicar.controladores/", "NicknameYaExisteException");
    private final static QName _UsuarioNoExisteException_QNAME = new QName("http://publicar.controladores/", "UsuarioNoExisteException");
    private final static QName _CampoInvalidoException_QNAME = new QName("http://publicar.controladores/", "campoInvalidoException");
    private final static QName _YaExistePostulacionAOfertaException_QNAME = new QName("http://publicar.controladores/", "yaExistePostulacionAOfertaException");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: publicar
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link KeyWord }
     * 
     * @return
     *     the new instance of {@link KeyWord }
     */
    public KeyWord createKeyWord() {
        return new KeyWord();
    }

    /**
     * Create an instance of {@link KeyWord.Ofertas }
     * 
     * @return
     *     the new instance of {@link KeyWord.Ofertas }
     */
    public KeyWord.Ofertas createKeyWordOfertas() {
        return new KeyWord.Ofertas();
    }

    /**
     * Create an instance of {@link Empresa }
     * 
     * @return
     *     the new instance of {@link Empresa }
     */
    public Empresa createEmpresa() {
        return new Empresa();
    }

    /**
     * Create an instance of {@link Empresa.Paquetes }
     * 
     * @return
     *     the new instance of {@link Empresa.Paquetes }
     */
    public Empresa.Paquetes createEmpresaPaquetes() {
        return new Empresa.Paquetes();
    }

    /**
     * Create an instance of {@link Empresa.Ofertas }
     * 
     * @return
     *     the new instance of {@link Empresa.Ofertas }
     */
    public Empresa.Ofertas createEmpresaOfertas() {
        return new Empresa.Ofertas();
    }

    /**
     * Create an instance of {@link WrapperHashMap }
     * 
     * @return
     *     the new instance of {@link WrapperHashMap }
     */
    public WrapperHashMap createWrapperHashMap() {
        return new WrapperHashMap();
    }

    /**
     * Create an instance of {@link WrapperHashMap.Mapa }
     * 
     * @return
     *     the new instance of {@link WrapperHashMap.Mapa }
     */
    public WrapperHashMap.Mapa createWrapperHashMapMapa() {
        return new WrapperHashMap.Mapa();
    }

    /**
     * Create an instance of {@link EmailYaExisteException }
     * 
     * @return
     *     the new instance of {@link EmailYaExisteException }
     */
    public EmailYaExisteException createEmailYaExisteException() {
        return new EmailYaExisteException();
    }

    /**
     * Create an instance of {@link NicknameYaExisteException }
     * 
     * @return
     *     the new instance of {@link NicknameYaExisteException }
     */
    public NicknameYaExisteException createNicknameYaExisteException() {
        return new NicknameYaExisteException();
    }

    /**
     * Create an instance of {@link UsuarioNoExisteException }
     * 
     * @return
     *     the new instance of {@link UsuarioNoExisteException }
     */
    public UsuarioNoExisteException createUsuarioNoExisteException() {
        return new UsuarioNoExisteException();
    }

    /**
     * Create an instance of {@link CampoInvalidoException }
     * 
     * @return
     *     the new instance of {@link CampoInvalidoException }
     */
    public CampoInvalidoException createCampoInvalidoException() {
        return new CampoInvalidoException();
    }

    /**
     * Create an instance of {@link YaExistePostulacionAOfertaException }
     * 
     * @return
     *     the new instance of {@link YaExistePostulacionAOfertaException }
     */
    public YaExistePostulacionAOfertaException createYaExistePostulacionAOfertaException() {
        return new YaExistePostulacionAOfertaException();
    }

    /**
     * Create an instance of {@link DataUsuario }
     * 
     * @return
     *     the new instance of {@link DataUsuario }
     */
    public DataUsuario createDataUsuario() {
        return new DataUsuario();
    }

    /**
     * Create an instance of {@link WrapperArrayList }
     * 
     * @return
     *     the new instance of {@link WrapperArrayList }
     */
    public WrapperArrayList createWrapperArrayList() {
        return new WrapperArrayList();
    }

    /**
     * Create an instance of {@link Paquete }
     * 
     * @return
     *     the new instance of {@link Paquete }
     */
    public Paquete createPaquete() {
        return new Paquete();
    }

    /**
     * Create an instance of {@link LocalDate }
     * 
     * @return
     *     the new instance of {@link LocalDate }
     */
    public LocalDate createLocalDate() {
        return new LocalDate();
    }

    /**
     * Create an instance of {@link TipoPublicacion }
     * 
     * @return
     *     the new instance of {@link TipoPublicacion }
     */
    public TipoPublicacion createTipoPublicacion() {
        return new TipoPublicacion();
    }

    /**
     * Create an instance of {@link Postulacion }
     * 
     * @return
     *     the new instance of {@link Postulacion }
     */
    public Postulacion createPostulacion() {
        return new Postulacion();
    }

    /**
     * Create an instance of {@link OfertaLaboral }
     * 
     * @return
     *     the new instance of {@link OfertaLaboral }
     */
    public OfertaLaboral createOfertaLaboral() {
        return new OfertaLaboral();
    }

    /**
     * Create an instance of {@link LocalTime }
     * 
     * @return
     *     the new instance of {@link LocalTime }
     */
    public LocalTime createLocalTime() {
        return new LocalTime();
    }

    /**
     * Create an instance of {@link CompraPaquete }
     * 
     * @return
     *     the new instance of {@link CompraPaquete }
     */
    public CompraPaquete createCompraPaquete() {
        return new CompraPaquete();
    }

    /**
     * Create an instance of {@link Postulante }
     * 
     * @return
     *     the new instance of {@link Postulante }
     */
    public Postulante createPostulante() {
        return new Postulante();
    }

    /**
     * Create an instance of {@link KeyWord.Ofertas.Entry }
     * 
     * @return
     *     the new instance of {@link KeyWord.Ofertas.Entry }
     */
    public KeyWord.Ofertas.Entry createKeyWordOfertasEntry() {
        return new KeyWord.Ofertas.Entry();
    }

    /**
     * Create an instance of {@link Empresa.Paquetes.Entry }
     * 
     * @return
     *     the new instance of {@link Empresa.Paquetes.Entry }
     */
    public Empresa.Paquetes.Entry createEmpresaPaquetesEntry() {
        return new Empresa.Paquetes.Entry();
    }

    /**
     * Create an instance of {@link Empresa.Ofertas.Entry }
     * 
     * @return
     *     the new instance of {@link Empresa.Ofertas.Entry }
     */
    public Empresa.Ofertas.Entry createEmpresaOfertasEntry() {
        return new Empresa.Ofertas.Entry();
    }

    /**
     * Create an instance of {@link WrapperHashMap.Mapa.Entry }
     * 
     * @return
     *     the new instance of {@link WrapperHashMap.Mapa.Entry }
     */
    public WrapperHashMap.Mapa.Entry createWrapperHashMapMapaEntry() {
        return new WrapperHashMap.Mapa.Entry();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EmailYaExisteException }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EmailYaExisteException }{@code >}
     */
    @XmlElementDecl(namespace = "http://publicar.controladores/", name = "EmailYaExisteException")
    public JAXBElement<EmailYaExisteException> createEmailYaExisteException(EmailYaExisteException value) {
        return new JAXBElement<>(_EmailYaExisteException_QNAME, EmailYaExisteException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NicknameYaExisteException }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link NicknameYaExisteException }{@code >}
     */
    @XmlElementDecl(namespace = "http://publicar.controladores/", name = "NicknameYaExisteException")
    public JAXBElement<NicknameYaExisteException> createNicknameYaExisteException(NicknameYaExisteException value) {
        return new JAXBElement<>(_NicknameYaExisteException_QNAME, NicknameYaExisteException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UsuarioNoExisteException }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UsuarioNoExisteException }{@code >}
     */
    @XmlElementDecl(namespace = "http://publicar.controladores/", name = "UsuarioNoExisteException")
    public JAXBElement<UsuarioNoExisteException> createUsuarioNoExisteException(UsuarioNoExisteException value) {
        return new JAXBElement<>(_UsuarioNoExisteException_QNAME, UsuarioNoExisteException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CampoInvalidoException }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CampoInvalidoException }{@code >}
     */
    @XmlElementDecl(namespace = "http://publicar.controladores/", name = "campoInvalidoException")
    public JAXBElement<CampoInvalidoException> createCampoInvalidoException(CampoInvalidoException value) {
        return new JAXBElement<>(_CampoInvalidoException_QNAME, CampoInvalidoException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YaExistePostulacionAOfertaException }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link YaExistePostulacionAOfertaException }{@code >}
     */
    @XmlElementDecl(namespace = "http://publicar.controladores/", name = "yaExistePostulacionAOfertaException")
    public JAXBElement<YaExistePostulacionAOfertaException> createYaExistePostulacionAOfertaException(YaExistePostulacionAOfertaException value) {
        return new JAXBElement<>(_YaExistePostulacionAOfertaException_QNAME, YaExistePostulacionAOfertaException.class, null, value);
    }

}
