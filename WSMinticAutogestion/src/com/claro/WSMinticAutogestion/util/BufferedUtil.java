package com.claro.WSMinticAutogestion.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * Clase utilitaria para llamado de valores de un archivo de propiedades Externo
 * @author Luis Bucheli
 *
 */
public class BufferedUtil {

	/**
	 * Metodo que lee el archivo de propiedades y obtiene el valor segun el
	 * nombre de la proiedad enviada
	 * @param valorEnum
	 * @return
	 */
	public String obtenerValorFileProperties(String valorEnum) {

		String valorFinal = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader("D:/CLARO/mintic/MinticAutogestion.properties"));
			//BufferedReader br = new BufferedReader(new FileReader("/usr/share/tomee/conf/wsExpertTrack.properties"));
			String linea=br.readLine();

			while(linea!=null){
				
				String datos[] = linea.split("=");

				if(datos != null){	
					
					if(datos[0].trim().equals(valorEnum)){
						if(datos.length == 2){
							valorFinal = datos[1].trim();
							break;
						}
						if(datos.length > 2){
							for(int i = 1; i < datos.length; i++){
								valorFinal = valorFinal+datos[i].trim()+"=";
							}
							valorFinal = valorFinal.substring(0, valorFinal.length()-1);
							break;
						}
					}
				}
				linea=br.readLine();
			}
			br.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return valorFinal.isEmpty()?null:valorFinal;
	}
    public static Properties readPropertiesFile(String fileName) throws IOException {
        FileInputStream fis = null;
        Properties prop = null;
        try {
           fis = new FileInputStream(fileName);
           prop = new Properties();
           prop.load(fis);
        } catch(FileNotFoundException ex) {
        	ex.printStackTrace();
        } catch(IOException ex) {
        	ex.printStackTrace();
        } finally {
           fis.close();
        }
        return prop;
     }
 

}
