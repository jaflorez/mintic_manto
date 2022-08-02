/**
 * 
 */
package com.claro.WSMinticAutogestion.controller;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.claro.WSMinticAutogestion.dao.CentroDigitalDAO;
import com.claro.WSMinticAutogestion.dao.MinticDAO;
import com.claro.WSMinticAutogestion.json.AccessPoint;
import com.claro.WSMinticAutogestion.json.CentroDigital;
import com.claro.WSMinticAutogestion.json.Coneccion_rt;
import com.claro.WSMinticAutogestion.json.Interfaces_rt;
import com.claro.WSMinticAutogestion.json.Radio;
import com.claro.WSMinticAutogestion.json.Router_mk;
import com.claro.WSMinticAutogestion.json.Switch_bts;
import com.claro.WSMinticAutogestion.util.ConsultaRestUtil;
import com.claro.WSMinticAutogestion.vo.CentroDigitalVO;
import com.claro.WSMinticAutogestion.vo.EquipoVO;
import com.claro.WSMinticAutogestion.vo.ResponsableVO;





/**
 * Clase que controla el llamado a las Clases DAO para las consultas a base de datos
 * @author Luis Bucheli
 *
 */
public class Controller {

	
	
	private CentroDigital centroDigital;
	private Properties properties;
	public Controller(Properties properties) {
		super();
		this.properties = properties;
		// TODO Auto-generated constructor stub
	}
	/**
	 * Metodo de Consulta de KPI de un nodo
	 * @param nodo
	 * @param date
	 * @return
	 * @throws Exception
	 */
    public CentroDigital consultarCentroDigital(String idConsulta) {
    	CentroDigital  centroDigital = null;
    	try {
    		
        	MinticDAO minticDAO = new MinticDAO();
        	Connection connection = minticDAO.getConnection(this.properties.getProperty("DB_STR_CONNECTION"),this.properties.getProperty("DB_USER"),this.properties.getProperty("DB_PWD"));
        	centroDigital = new CentroDigital();
        	CentroDigitalDAO centroDigitalDAO = new CentroDigitalDAO(connection);
        	CentroDigitalVO centroDigitalVO = null;
       		centroDigitalVO = centroDigitalDAO.findById(idConsulta);
        	if(connection != null) {
        		connection.close();
            }
        	if(centroDigitalVO == null) {
        		return centroDigital;
        	}
        	centroDigital.setId_beneficiario(centroDigitalVO.getId_beneficiario());
        	centroDigital.setId_mintic(centroDigitalVO.getId_mintic());
        	centroDigital.setMunicipio(centroDigitalVO.getMunicipio());
        	centroDigital.setNombre_ct_pob(centroDigitalVO.getNombre_ct_pob());
        	centroDigital.setVlan(centroDigitalVO.getVlan());
        	centroDigital.setDepartamento(centroDigitalVO.getDepartamento());
        	centroDigital.setResponsables(centroDigitalVO.getResponsables());
        	List<AccessPoint>  listaAP = new ArrayList<>();
        	ConsultaRestUtil consultaRestUtil = new ConsultaRestUtil();
        	String[] tokens  =  consultaRestUtil.generar_tokens(this.properties.getProperty("PATH_TOKENS"),this.properties.getProperty("SCRIPT_TOKENS"));
        	Radio rd_cd = null;
        	Radio radio_bts = null;
        	for(EquipoVO eq:centroDigitalVO.getEquipos()) {
        		if(eq.getTipo().equals("AP-INT") || eq.getTipo().equals("AP-EXT1") || eq.getTipo().equals("AP-EXT2")) {
        			if(centroDigitalVO.getServer_data() == 1) {
        				AccessPoint ap = consultaRestUtil.consultar_ap(this.properties.getProperty("URL_AP1_CLT"),eq.getMac(),tokens[1],eq.getTipo());
        				listaAP.add(ap);		
        			}
        			if(centroDigitalVO.getServer_data() == 2) {
        				AccessPoint ap = consultaRestUtil.consultar_ap(this.properties.getProperty("URL_AP2_CLT"),eq.getMac(),tokens[2],eq.getTipo());
        				listaAP.add(ap);		
        			}
        		}
        		if(eq.getTipo().equals("RD-CD")) {
        			rd_cd = consultaRestUtil.consultar_rd_cd(this.properties.getProperty("URL_RD_CD_CLT"),eq.getMac(),tokens[0]);
        		}
        		if( eq.getTipo().equals("RD-BT")) {
        			 radio_bts = consultaRestUtil.consultar_rd_bts(this.properties.getProperty("URL_RD_BT_CLT"),eq.getMac(),tokens[0]);
        		}
        	}
        	centroDigital.setAps(listaAP);
        	centroDigital.setRadio_cd(rd_cd);
			centroDigital.setRadio_bts(radio_bts);
        	Router_mk router_mk = new Router_mk();
        	String ip_clt = this.properties.getProperty("RT_IP_DEFAULT").length() > 3 ? this.properties.getProperty("RT_IP_DEFAULT") : centroDigitalVO.getIp_router();
        	List<Interfaces_rt> interfaces = consultaRestUtil.consultar_router_interfaces(this.properties.getProperty("URL_RT_INTER"),ip_clt,this.properties.getProperty("URL_RT_USR"),this.properties.getProperty("URL_RT_PSW"));
        	router_mk.setInterfaces(interfaces);
        	List<Coneccion_rt> conecciones = consultaRestUtil.consultar_router_conecciones(this.properties.getProperty("URL_RT_CONECTION"),ip_clt,this.properties.getProperty("URL_RT_USR"),this.properties.getProperty("URL_RT_PSW"));
        	router_mk.setConectividad(conecciones);
        	centroDigital.setRouter_mk(router_mk);
        	
        	if(rd_cd != null) {
        		if(rd_cd.getAp_mac() != null ) {
        			Switch_bts switch_bts = consultaRestUtil.consultar_switch_bts(this.properties.getProperty("URL_SW_BT_CLT"),rd_cd.getAp_mac(),tokens[0]);
        			centroDigital.setSwitch_bts(switch_bts);
        		}
        	}
        	System.out.println("fin");
        	return centroDigital;
		} catch (Exception e) {
			// TODO: handle exception
		}
    	return centroDigital;
    }
    
	/**
	 * Metodo de Consulta de KPI de un nodo
	 * @param nodo
	 * @param date
	 * @return
	 * @throws Exception
	 */
    public String  getTestVelocidad(String idAccessPoint) throws Exception {
    	
		return "";
	}
}
