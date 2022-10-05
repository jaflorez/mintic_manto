/**
 * 
 */
package com.claro.WSMinticAutogestion.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import com.claro.WSMinticAutogestion.dao.CallSpeedTestDAO;
import com.claro.WSMinticAutogestion.dao.CentroDigitalDAO;
import com.claro.WSMinticAutogestion.dao.MinticDAO;
import com.claro.WSMinticAutogestion.dao.ResponsableDAO;
import com.claro.WSMinticAutogestion.json.AccessPoint;
import com.claro.WSMinticAutogestion.json.CentroDigital;
import com.claro.WSMinticAutogestion.json.Coneccion_rt;
import com.claro.WSMinticAutogestion.json.Interfaces_rt;
import com.claro.WSMinticAutogestion.json.Radio;
import com.claro.WSMinticAutogestion.json.Router_mk;
import com.claro.WSMinticAutogestion.json.SpeedTestResult;
import com.claro.WSMinticAutogestion.json.Switch_bts;
import com.claro.WSMinticAutogestion.util.ConsultaRestUtil;
import com.claro.WSMinticAutogestion.util.ConsultaSoapUtil;
import com.claro.WSMinticAutogestion.util.TokenUtil;
import com.claro.WSMinticAutogestion.vo.CallSpeedTestVO;
import com.claro.WSMinticAutogestion.vo.CentroDigitalVO;
import com.claro.WSMinticAutogestion.vo.EquipoVO;
import com.claro.WSMinticAutogestion.vo.ResponsableVO;
import com.claro.WSMinticAutogestion.vo.SpeedTestVO;
import com.claro.WSMinticAutogestion.vo.StResultsVO;
import com.claro.WSMinticSpeedTest.dao.STResultsDAO;
import com.claro.WSMinticSpeedTest.dao.SpeedTestDAO;

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
	public List<ResponsableVO> consultarResponsables(String id_beneficiario) {
		
		MinticDAO minticDAO = new MinticDAO();
		Connection connection = minticDAO.getConnection(this.properties.getProperty("DB_STR_CONNECTION"),this.properties.getProperty("DB_USER"),this.properties.getProperty("DB_PWD"));
		ResponsableDAO responsableDAO;
		List<ResponsableVO> listaResponsable= new ArrayList<>();
		responsableDAO = new ResponsableDAO(connection);
		listaResponsable = responsableDAO.listResponsablesByIdBeneficiario(id_beneficiario);
		return listaResponsable;
	}

    public CentroDigital consultarCentroDigital(String idConsulta) {
    	CentroDigital  centroDigital = null;
    	try {
        	System.out.println(idConsulta);
    		MinticDAO minticDAO = new MinticDAO();
        	Connection connection = minticDAO.getConnection(this.properties.getProperty("DB_STR_CONNECTION"),this.properties.getProperty("DB_USER"),this.properties.getProperty("DB_PWD"));
        	centroDigital = new CentroDigital();
       		if(connection == null) {
       			System.out.println("Error en la coneccion a base de datos MySql");
       			return centroDigital;
            }
        	CentroDigitalDAO centroDigitalDAO = new CentroDigitalDAO(connection);
        	CentroDigitalVO centroDigitalVO = null;
       		centroDigitalVO = centroDigitalDAO.findById(idConsulta);
       		TokenUtil tokenUtil = new TokenUtil();
       		String[] tokens = tokenUtil.consultar_tokens(properties,connection);
       		if(connection != null) {
        		connection.close();
            }
        	if(centroDigitalVO == null) {
        		return centroDigital;
        	}
        	ConsultaSoapUtil consultaSoapUtil = new ConsultaSoapUtil();
        	String  ap_id =  Integer.toString(consultaSoapUtil.ConsultarApId(this.properties.getProperty("URL_SPD_TST_FIND_ID"),idConsulta));
        	centroDigitalVO.setAp_id(ap_id);
        	centroDigital.setId_beneficiario(centroDigitalVO.getId_beneficiario());
        	centroDigital.setId_mintic(centroDigitalVO.getId_mintic());
        	centroDigital.setMunicipio(centroDigitalVO.getMunicipio());
        	centroDigital.setNombre_ct_pob(centroDigitalVO.getNombre_ct_pob());
        	centroDigital.setVlan(centroDigitalVO.getVlan());
        	centroDigital.setDepartamento(centroDigitalVO.getDepartamento());
        	centroDigital.setAp_id(centroDigitalVO.getAp_id());
        	List<AccessPoint>  listaAP = new ArrayList<>();
        	ConsultaRestUtil consultaRestUtil = new ConsultaRestUtil();
        	Radio rd_cd = null;
        	Radio radio_bts = null;
        	Switch_bts switch_bts = null;
        	
        	for(EquipoVO eq:centroDigitalVO.getEquipos()) {
        		try {
	        		if(eq.getTipo().equals("AP-INT") || eq.getTipo().equals("AP-EXT1") || eq.getTipo().equals("AP-EXT2")) {
	        			if(centroDigitalVO.getServer_data() == 1) {
	        				AccessPoint ap = consultaRestUtil.consultar_ap(this.properties.getProperty("URL_AP1_CLT"),eq.getMac(),tokens[1],eq.getTipo());
	        				ap.setIp_address(eq.getIp_address());
	        				listaAP.add(ap);		
	        			}
	        			if(centroDigitalVO.getServer_data() == 2) {
	        				AccessPoint ap = consultaRestUtil.consultar_ap(this.properties.getProperty("URL_AP2_CLT"),eq.getMac(),tokens[2],eq.getTipo());
	        				ap.setIp_address(eq.getIp_address());
	        				listaAP.add(ap);		
	        			}
	        		}
	        		if(eq.getTipo().equals("RD-CD")) {
	        			rd_cd = consultaRestUtil.consultar_rd_cd(this.properties.getProperty("URL_RD_CD_CLT"),eq.getMac(),tokens[0]);
	        			rd_cd.setIp_address(eq.getIp_address());
	        		}
	        		if( eq.getTipo().equals("RD-BT")) {
	        			 radio_bts = consultaRestUtil.consultar_rd_bts(this.properties.getProperty("URL_RD_BT_CLT"),eq.getMac(),tokens[0]);
	        			 radio_bts.setIp_address(eq.getIp_address());
	        		}
	        		if( eq.getTipo().equals("SW-BT")) {
	            			switch_bts = consultaRestUtil.consultar_switch_bts(this.properties.getProperty("URL_SW_BT_CLT"),eq.getMac(),tokens[0]);
	        		}
				} catch (Exception e) {
					System.out.println(e.toString());
				}

        	}
        	centroDigital.setAps(listaAP);
        	centroDigital.setRadio_cd(rd_cd);
			centroDigital.setRadio_bts(radio_bts);
			centroDigital.setSwitch_bts(switch_bts);
        	Router_mk router_mk = new Router_mk();
        	if(!this.properties.getProperty("RT_IP_DEFAULT").equals("NO")){
        		System.out.println("Com IP_address");
        		String ip_clt = this.properties.getProperty("RT_IP_DEFAULT").length() > 3 ? this.properties.getProperty("RT_IP_DEFAULT") : centroDigitalVO.getIp_router();
            	List<Interfaces_rt> interfaces = consultaRestUtil.consultar_router_interfaces(this.properties.getProperty("URL_RT_INTER"),ip_clt,this.properties.getProperty("URL_RT_USR"),this.properties.getProperty("URL_RT_PSW"));
            	router_mk.setIp_address(ip_clt);
            	router_mk.setInterfaces(interfaces);
            	List<Coneccion_rt> conecciones = consultaRestUtil.consultar_router_conecciones(this.properties.getProperty("URL_RT_CONECTION"),ip_clt,this.properties.getProperty("URL_RT_USR"),this.properties.getProperty("URL_RT_PSW"));
            	router_mk.setConectividad(conecciones);
            	centroDigital.setRouter_mk(router_mk);
        	}
        	return centroDigital;
		} catch (Exception e) {
			// TODO: handle exception
		}
    	return centroDigital;
    }
    
    public void cancelarConsultaSpeeTest(String user_id,String ap_id) {
    	MinticDAO minticDAO = new MinticDAO();
    	try {
        	Connection connection = minticDAO.getConnection(this.properties.getProperty("DB_STR_CONNECTION"),this.properties.getProperty("DB_USER"),this.properties.getProperty("DB_PWD"));
        	CallSpeedTestDAO callSpeedTestDAO = new CallSpeedTestDAO(connection);
        	callSpeedTestDAO.UpdateCallSpeedTestVO(user_id, ap_id, "cancelada");
		} catch (Exception e) {
			System.err.println("Error en el proceso" );
			System.err.println(e);
		}
    }
    
    public SpeedTestResult  getTestVelocidad(String user_id,String ap_id,String fecha_solicitud) throws Exception {
		String pattern = "yyyy-MM-dd HH:mm:ss";
		DateFormat df = new SimpleDateFormat(pattern);
    	SpeedTestResult speedTestResult = null;
    	MinticDAO minticDAO = new MinticDAO();
    	try {
        	Connection connection = minticDAO.getConnection(this.properties.getProperty("DB_STR_CONNECTION"),this.properties.getProperty("DB_USER"),this.properties.getProperty("DB_PWD"));
        	CallSpeedTestDAO callSpeedTestDAO = new CallSpeedTestDAO(connection);
        	CallSpeedTestVO callSpeedTestVo = callSpeedTestDAO.FindByUserApid(user_id, ap_id);
        	if(callSpeedTestVo == null) {/*No existe una solicitud pendiente*/
        		ConsultaSoapUtil consultaSoapUtil = new ConsultaSoapUtil();
        		callSpeedTestVo = consultaSoapUtil.llamar_speed_test(this.properties.getProperty("URL_SPD_TST_RUN"),this.properties.getProperty("MAIL_SPEED_TEST"), ap_id);
        		callSpeedTestVo.setUsuario(user_id);
        		Date date = new Date();
        		callSpeedTestVo.setFecha(date);
        		callSpeedTestVo.setFecha_solicitud(df.parse(fecha_solicitud));
        		callSpeedTestDAO.Save(callSpeedTestVo);
        		speedTestResult =  new SpeedTestResult(user_id,ap_id,"corriendo",fecha_solicitud); 
        	}
        	else {
        		String fecha_solicitud_ft = df.format(callSpeedTestVo.getFecha_solicitud());
        		SpeedTestDAO speedTestDAO = new SpeedTestDAO();
        		Connection connection_gestionate = null;
       			connection_gestionate=speedTestDAO.getConnection(this.properties.getProperty("DB_GEST_STR_CONNECTION"),this.properties.getProperty("DB_GEST_USER"), this.properties.getProperty("DB_GEST_PWD"));
        		if(connection_gestionate != null) {
            		STResultsDAO stResultsDAO = new STResultsDAO(connection_gestionate);
            		StResultsVO stResultsVO =stResultsDAO.GetByWorkFlowId(callSpeedTestVo.getWorkflow_process_id());
            		if(stResultsVO != null) {
            			speedTestResult =  new SpeedTestResult(user_id,ap_id,"listo",fecha_solicitud_ft);
            			speedTestResult.setStResultVO(stResultsVO);
            			callSpeedTestDAO.UpdateCallSpeedTestVO(user_id, ap_id, "listo"); 
            		}
            		else {
            			speedTestResult =  new SpeedTestResult(user_id,ap_id,"corriendo",fecha_solicitud_ft);
            		}
        		}
        		else {
        			throw new Exception("Error en la conexion a base de datos de Gestionate");
        		}
        	}
        	return speedTestResult;
			
		} catch (Exception e) {
			System.err.println("Error en el proceso" );
			System.err.println(e);
			// TODO: handle exception
		}
    	return speedTestResult;
    	
	}
}
