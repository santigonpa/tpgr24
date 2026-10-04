# TrabajoUY

TrabajoUY es el proyecto realizado para la materia **Taller de Programación** de la
**Facultad de Ingeniería de la Universidad de la República (Udelar)** durante el
año **2023**.

Este repositorio conserva las distintas entregas del proyecto. Las instrucciones
de este documento corresponden a la aplicación completa de **Tarea 2**.

## Arquitectura

La aplicación está dividida en dos procesos:

- **Servidor central:** aplicación Java/Swing que contiene la lógica de negocio y
  publica cinco servicios SOAP mediante JAX-WS en `localhost:9128`.
- **Sitio web:** aplicación Jakarta Servlet/JSP empaquetada como WAR y desplegada
  en Tomcat 10. Consume los servicios SOAP del servidor central.

Los módulos principales son:

```text
Tarea 2/
├── estacion_de_trabajo/                 # servidor central y aplicación Swing
├── servidor_web/
│   └── sitio_web_dinamico/             # aplicación web Maven (WAR)
└── jaxws-ri/                           # distribución y utilidades JAX-WS
```

## Requisitos

- JDK 17
- Maven 3.8 o posterior
- Apache Tomcat 10.1.x
- Puertos locales disponibles:
  - `9128` para los servicios SOAP
  - `8080` para Tomcat

La configuración fue verificada con Temurin JDK 17, Maven 3.9.11 y Tomcat
10.1.11 en macOS ARM64.

> Es necesario usar Tomcat 10, no Tomcat 9: el proyecto utiliza los paquetes
> `jakarta.servlet.*` y el descriptor Jakarta EE 10.

## Configuración

El servidor central y el sitio web deben apuntar al mismo host y puerto SOAP.
Verificar que estos archivos contengan:

- `Tarea 2/estacion_de_trabajo/config.properties`
- `Tarea 2/estacion_de_trabajo/src/config.properties`
- `Tarea 2/servidor_web/sitio_web_dinamico/src/main/java/com/config.properties`

```properties
hostIP=localhost
hostPort=9128
```

## Compilación

Ejecutar los siguientes comandos desde la raíz del repositorio.

### 1. Servidor central

```bash
cd "Tarea 2/estacion_de_trabajo"
mvn clean package
cd ../..
```

El artefacto ejecutable queda en:

```text
Tarea 2/estacion_de_trabajo/target/TrabajoUYJPA-jar-with-dependencies.jar
```

### 2. Sitio web

```bash
cd "Tarea 2/servidor_web/sitio_web_dinamico"
mvn clean package
cd ../../..
```

El WAR queda en:

```text
Tarea 2/servidor_web/sitio_web_dinamico/target/TrabajoUY.war
```

## Ejecución

El orden de arranque es importante: primero se inicia el servidor central y
después Tomcat.

### 1. Iniciar el servidor central

Desde la raíz del repositorio:

```bash
cd "Tarea 2/estacion_de_trabajo"
java -jar target/TrabajoUYJPA-jar-with-dependencies.jar
```

Se abrirá la interfaz Swing y en la terminal se informará la publicación de los
servicios:

```text
http://localhost:9128/ManejadorUsuario
http://localhost:9128/ManejadorPaquetesYTiposPubli
http://localhost:9128/ControladorOfertas
http://localhost:9128/ManejadorOferta
http://localhost:9128/ControladorUsuario
```

Mantener este proceso abierto mientras se utiliza el sitio web.

### 2. Cargar los datos de prueba

La carga inicial no es automática. En la ventana del servidor central elegir:

```text
Sistema → Cargar Datos
```

Debe hacerse una sola vez por ejecución. La aplicación mantiene estos datos en
memoria.

### 3. Desplegar el WAR en Tomcat 10

Definir `CATALINA_HOME` con la ubicación de Tomcat y copiar el WAR:

```bash
export CATALINA_HOME="/ruta/a/apache-tomcat-10.1.x"
cp "Tarea 2/servidor_web/sitio_web_dinamico/target/TrabajoUY.war" \
  "$CATALINA_HOME/webapps/TrabajoUY.war"
```

Para ejecutar Tomcat en primer plano y ver los logs:

```bash
"$CATALINA_HOME/bin/catalina.sh" run
```

Como alternativa, se puede iniciar en segundo plano:

```bash
"$CATALINA_HOME/bin/startup.sh"
```

En Windows se deben usar `catalina.bat run` o `startup.bat`.

### 4. Abrir la aplicación

Visitar:

```text
http://localhost:8080/TrabajoUY/
```

La página inicial redirige a:

```text
http://localhost:8080/TrabajoUY/home
```

## Verificación

El WSDL de cada servicio se puede consultar agregando `?wsdl`. Por ejemplo:

```bash
curl -fsS -o /dev/null -w "SOAP: %{http_code}\n" \
  "http://localhost:9128/ControladorUsuario?wsdl"
curl -fsS -o /dev/null -w "Web: %{http_code}\n" \
  "http://localhost:8080/TrabajoUY/home"
```

Ambas solicitudes deben responder con estado HTTP `200`.

## Detener la aplicación

- Cerrar la ventana Swing detiene el servidor central y sus servicios SOAP.
- Si Tomcat fue iniciado en primer plano, presionar `Ctrl+C`.
- Si fue iniciado con `startup.sh`, ejecutar:

```bash
"$CATALINA_HOME/bin/shutdown.sh"
```

## Solución de problemas

### El sitio muestra un error de conexión SOAP

Confirmar que el servidor central siga abierto, que haya publicado los cinco
servicios y que `localhost:9128` coincida en los tres archivos de configuración.

### Un puerto ya está ocupado

En macOS o Linux se puede identificar el proceso con:

```bash
lsof -nP -iTCP:9128 -sTCP:LISTEN
lsof -nP -iTCP:8080 -sTCP:LISTEN
```

Cerrar la instancia anterior antes de volver a iniciar el servidor central o
Tomcat.

### Maven no encuentra Java

Comprobar la versión y definir `JAVA_HOME` con un JDK 17:

```bash
java -version
mvn -version
```

### Tomcat no despliega la aplicación

Revisar los logs de `catalina.sh run`, confirmar que se esté usando Tomcat 10.1
y volver a generar el WAR con `mvn clean package`.

### La página se ve sin algunas fuentes o estilos

Bootstrap, Font Awesome y algunas fuentes se cargan desde CDN. Para obtener el
estilo completo, el navegador debe tener acceso a Internet.
