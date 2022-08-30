package com.claro.WSMinticAutogestion.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConsultaSoapUtil {

	public ConsultaSoapUtil() {
		super();
	}
	public void ActualizarAPID(String path_py_ap_id, String centro_digital_id) {
        try {
        	System.out.println(path_py_ap_id + " "+ centro_digital_id);
            Process p = Runtime.getRuntime().exec(path_py_ap_id + " "+ centro_digital_id );
            p.waitFor();
        } catch (IOException ex) {
            Logger.getLogger(ConsultaRestUtil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException e) {
			e.printStackTrace();
			Logger.getLogger(ConsultaRestUtil.class.getName()).log(Level.SEVERE, null, e);
		}
	}
	public void llamar_speed_test(String path_script_speed_tet,String usuario,String ap_id,String fecha_solicitud) {
        try {
            Process p = Runtime.getRuntime().exec(path_script_speed_tet + " "+ usuario + " " + ap_id + " \"" + fecha_solicitud +"\"");
            p.waitFor();
        } catch (IOException ex) {
            Logger.getLogger(ConsultaRestUtil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException e) {
			e.printStackTrace();
			Logger.getLogger(ConsultaRestUtil.class.getName()).log(Level.SEVERE, null, e);
		}
	}
	
	

}
