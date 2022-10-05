package com.claro.WSMinticAutogestion.util;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Clase utilitaria para llamado de valores de un archivo de propiedades Externo
 * @author Diego Torres
 *
 */
public class PropertiesUtil {
	
//	public static final String PROPERTIES_PATH  = "E:\\ConectaServicios\\wsConectaMovilTest.properties" ;
	
	
//	public static final String PROPERTIES_PATH  = "D:\\OneDrive - GLOBAL HITSS\\Servicios App Movil\\wsConectaMovilTest.properties" ;
	public static final String PROPERTIES_PATH  = "D:\\CLARO\\certificacion\\WSConectaMovilTest\\configREQ2021-154.properties" ;
	//public static final String PROPERTIES_PATH  = "/WEB-INF/WSConectaMovil.properties" ;
	
	

	private Properties properties;
	private static PropertiesUtil instance;
	
	private PropertiesUtil() throws IOException {
		properties = new Properties();
		
		FileReader reader=new FileReader(PROPERTIES_PATH);  	      	     
		properties.load(reader);  		      
	     
	}
		
	public static PropertiesUtil getInstance() throws IOException {
		if (instance == null){
			instance = new PropertiesUtil();
		}
		return instance;
	}
	public String obtenerPropiedad (String nombre) {
		return properties.getProperty(nombre);
	}

	public String toString() {
		return properties.toString();
	}

	public Properties getProperties() {
		return properties;
	}

	public Integer obtenerPropiedadEntera (String nombre) {
		return Integer.parseInt(properties.getProperty(nombre));
	}
	
	
}
