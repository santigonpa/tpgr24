package utils;

import com.sun.tools.javac.Main;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.Map;
import java.util.Properties;

public class Config {

    private static Properties conf;
    private static boolean seCargoConfiguracion = false;
    private static final String nombreArchivoConfig = "config.properties";
    private static final String path = System.getProperty("user.dir") + File.separator + nombreArchivoConfig;

    public static void cargarConfiguracion() {
        if (seCargoConfiguracion) {
            return;
        } else {
            System.out.println("Entre a no se cargó la config");

            File carpetaConfigLocal = new File(System.getProperty("user.dir"));
            if (!carpetaConfigLocal.exists()) {
                if (carpetaConfigLocal.mkdirs()) {
                    System.out.println("Carpeta de configuración no encontrada, creando en " + carpetaConfigLocal.getAbsolutePath());
                } else {
                    System.out.println("No se pudo crear la carpeta de configuración.");
                }
            }

            File configFileLocal = new File(path);
            if (!configFileLocal.exists()) {
                System.out.println("No se encontró el archivo de configuración... generando configuración por defecto en " + configFileLocal);
                try (InputStream defaultConfig = Main.class.getClassLoader().getResourceAsStream(nombreArchivoConfig)) {
                    Files.copy(defaultConfig, configFileLocal.toPath());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            conf = new Properties();
            File configFileHome = new File(path);
            try (InputStream str = Files.newInputStream(configFileHome.toPath())) {
                conf.load(str);
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Lee propiedades que no estaban en las configuraciones del home/usuario/.TrabajoUY
            Properties properties = new Properties();
            try (InputStream configFileProject = Main.class.getClassLoader().getResourceAsStream(nombreArchivoConfig)) {
                properties.load(configFileProject);

                for (Map.Entry<Object, Object> prop : properties.entrySet()) {
                    if (conf.getProperty((String) prop.getKey()) == null) {
                        conf.setProperty((String) prop.getKey(), properties.getProperty((String) prop.getKey()));
                    }
                }
                conf.store(new FileOutputStream(path), "");

            } catch (IOException e1) {
                e1.printStackTrace();
            }

            seCargoConfiguracion = true;
        }
    }

    public static String getWebServiceBaseURL() {
        if (!seCargoConfiguracion) {
            cargarConfiguracion();
            seCargoConfiguracion = true;
        }
        return getHostURL();
    }

    private static String getHostURL() {
        return "http://" + getHostIP() + ":" + getHostPort();
    }

    private static String getHostIP() {
        return conf.getProperty("hostIP");
    }

    private static String getHostPort() {
        return conf.getProperty("hostPort");
    }
}


