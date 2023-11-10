package com.utils;

import java.io.InputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {
    private static Properties properties = loadProperties();

    private static Properties loadProperties() {
        Properties props = new Properties();
        try (InputStream input = Config.class.getResourceAsStream("/com/config.properties")) {
            if (input == null) {
                System.out.println("Lo siento, no se puede encontrar el archivo config.properties");
                return props;
            }

            // Cargar las propiedades desde el archivo de configuración
            props.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return props;
    }

    public static String getHostIP() {
        return properties.getProperty("hostIP");
    }

    public static int getHostPort() {
        return Integer.parseInt(properties.getProperty("hostPort"));
    }
    
    public static String getWebServiceBaseURL() {
        return getHostURL();
    }
    
    private static String getHostURL() {
        return "http://" + getHostIP() + ":" + getHostPort();
    }
}
