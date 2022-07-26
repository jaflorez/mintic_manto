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
import com.claro.WSMinticAutogestion.util.BufferedUtil;
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
	/**
	 * Metodo de Consulta de KPI de un nodo
	 * @param nodo
	 * @param date
	 * @return
	 * @throws Exception
	 */
    public CentroDigital consultarCentroDigitalOld(String idConsulta) throws Exception {
    	centroDigital = new CentroDigital();
    	centroDigital.setDepartamento("Antioquia");
    	centroDigital.setMunicipio("TURBO");
    	centroDigital.setId_beneficiario("4578787");
    	centroDigital.setId_mintic("100056789");
    	centroDigital.setNombre_ct_pob("CORREG. EL DOS");
    	
    	centroDigital.setVlan(idConsulta);
    	Radio radio_cd = new Radio();
    	radio_cd.setAp_mac("");
    	radio_cd.setMac("");
    	radio_cd.setDl_rssi("45");
    	radio_cd.setDl_snr("455");
    	radio_cd.setLan_mode_status("full");
    	radio_cd.setLan_speed_status("1000 Mpbs");
    	radio_cd.setStatus("online");
    	radio_cd.setTower("tower");
    	centroDigital.setRadio_cd(radio_cd);
    	Radio radio_bt = new Radio();
    	radio_bt.setAp_mac("");
    	radio_bt.setMac("");
    	radio_bt.setDl_rssi("45");
    	radio_bt.setDl_snr("455");
    	radio_bt.setLan_mode_status("full");
    	radio_bt.setLan_speed_status("1000 Mpbs");
    	radio_bt.setStatus("online");
    	radio_bt.setTower("tower");
    	centroDigital.setRadio_bts(radio_bt);
    	
    	Radio radio = new Radio();
    	radio.setAp_mac("");
    	radio.setMac("");
    	radio.setDl_rssi("45");
    	radio.setDl_snr("455");
    	radio.setLan_mode_status("full");
    	radio.setLan_speed_status("1000 Mpbs");
    	radio.setStatus("online");
    	radio.setTower("tower");
    	centroDigital.setRadio_cd(radio);    	
    	List<AccessPoint>  listaAP = new ArrayList<>();
    	AccessPoint ap = new AccessPoint();
    	ap.setTipo("INT");
    	ap.setName("10848-VZVF898-AP-EXT1");
    	ap.setMac("BC:A9:93:0C:7B:69");
    	ap.setStatus("online");
    	ap.setSite("10848-VZVF898 TURBO EL TRES"); 
    	listaAP.add(ap);
    	AccessPoint ap1 = new AccessPoint();
    	ap1.setTipo("EXT_1");
    	ap1.setName("10848-VZVF898-AP-EXT1");
    	ap1.setMac("BC:A9:93:0C:7B:69");
    	ap1.setStatus("online");
    	ap1.setSite("10848-VZVF898 TURBO EL TRES"); 
    	listaAP.add(ap1);

    	AccessPoint ap2 = new AccessPoint();
    	ap2.setTipo("EXT_2");
    	ap2.setName("10848-VZVF898-AP-EXT1");
    	ap2.setMac("BC:A9:93:0C:7B:69");
    	ap2.setStatus("online");
    	ap2.setSite("10848-VZVF898 TURBO EL TRES"); 
    	listaAP.add(ap2);
    	centroDigital.setAps(listaAP);
    	Switch_bts switch_bts = new Switch_bts();
    	switch_bts.setIp("10.68.224.14");
    	switch_bts.setMac("58:C1:7A:FA:D9:80");
    	switch_bts.setName_sw("ANT-EL-TOTUMO");
    	switch_bts.setStatus("online");
    	switch_bts.setTower("ANT.El Totumo");
    	centroDigital.setSwitch_bts(switch_bts);
    	
    	
    	Router_mk mk = new Router_mk();
    	List<Interfaces_rt>  listaIR = new ArrayList<>();
    	Interfaces_rt i_rt1 = new Interfaces_rt();
    	i_rt1.setAddress("10.167.139.232/30");
    	i_rt1.setInterface_("vlan-WAN");
    	i_rt1.setNetwork_("10.167.139.232");
    	listaIR.add(i_rt1);
    	Interfaces_rt i_rt2 = new Interfaces_rt();
    	i_rt2.setAddress("10.167.139.232/30");
    	i_rt2.setInterface_("bridge_LAN");
    	i_rt2.setNetwork_("10.167.139.232");
    	listaIR.add(i_rt2);
    	mk.setInterfaces(listaIR);
    	List<Coneccion_rt>  listaCn = new ArrayList<>();
    	Coneccion_rt cn_rt_1 = new Coneccion_rt();
    	cn_rt_1.setFull_duplex("true");
    	cn_rt_1.setName("ether1-WAN");
    	cn_rt_1.setRunning("true");
    	cn_rt_1.setRx_fcs_error("0");
    	cn_rt_1.setSpeed("100Mbps");
    	listaCn.add(cn_rt_1);
    	Coneccion_rt cn_rt_2 = new Coneccion_rt();
    	cn_rt_2.setFull_duplex("true");
    	cn_rt_2.setName("ether1-WAN");
    	cn_rt_2.setRunning("true");
    	cn_rt_2.setRx_fcs_error("0");
    	cn_rt_2.setSpeed("100Mbps");
    	listaCn.add(cn_rt_2);
    	Coneccion_rt cn_rt_3 = new Coneccion_rt();
    	cn_rt_3.setFull_duplex("true");
    	cn_rt_3.setName("ether1-WAN");
    	cn_rt_3.setRunning("true");
    	cn_rt_3.setRx_fcs_error("0");
    	cn_rt_3.setSpeed("100Mbps");
    	listaCn.add(cn_rt_3);
    	Coneccion_rt cn_rt_4 = new Coneccion_rt();
    	cn_rt_4.setFull_duplex("true");
    	cn_rt_4.setName("ether1-WAN");
    	cn_rt_4.setRunning("true");
    	cn_rt_4.setRx_fcs_error("0");
    	cn_rt_4.setSpeed("100Mbps");
    	listaCn.add(cn_rt_4);
    	mk.setConectividad(listaCn);
    	centroDigital.setRouter_mk(mk);
    	List<ResponsableVO>  listaRs = new ArrayList<>();
    	ResponsableVO responsable = new ResponsableVO(1,"","","","");
    	listaRs.add(responsable);
    	centroDigital.setResponsables(listaRs);
		return centroDigital;
	}
    public CentroDigital consultarCentroDigital(String idConsulta) throws Exception {
    	Properties properties = BufferedUtil.readPropertiesFile("D:/CLARO/mintic/MinticAutogestion.properties");
    	MinticDAO minticDAO = new MinticDAO();
    	Connection connection = minticDAO.getConnection(properties.getProperty("DB_STR_CONNECTION"),properties.getProperty("DB_USER"),properties.getProperty("DB_PWD"));
    	CentroDigital  centroDigital = new CentroDigital();
    	CentroDigitalDAO centroDigitalDAO = new CentroDigitalDAO(connection);
    	CentroDigitalVO centroDigitalVO = null;
   		centroDigitalVO = centroDigitalDAO.findById(idConsulta);
   		System.out.println("CD 01 Clt DAO");
   		
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
    	String[] tokens  =  consultaRestUtil.generar_tokens(properties.getProperty("PATH_TOKENS"),properties.getProperty("SCRIPT_TOKENS"));
    	Radio rd_cd = null;
    	System.out.println("CD 01 Clt DAO 02 - 04");
    	for(EquipoVO eq:centroDigitalVO.getEquipos()) {
    		if(eq.getTipo().equals("AP-INT") || eq.getTipo().equals("AP-EXT1") || eq.getTipo().equals("AP-EXT2")) {
    			if(centroDigitalVO.getServer_data() == 1) {
    				AccessPoint ap = consultaRestUtil.consultar_ap(properties.getProperty("URL_AP1_CLT"),eq.getMac(),tokens[1],eq.getTipo());
    				listaAP.add(ap);		
    			}
    			if(centroDigitalVO.getServer_data() == 2) {
    				AccessPoint ap = consultaRestUtil.consultar_ap(properties.getProperty("URL_AP2_CLT"),eq.getMac(),tokens[2],eq.getTipo());
    				listaAP.add(ap);		
    			}
    		}
    		if(eq.getTipo().equals("RD-CD")) {
    			rd_cd = consultaRestUtil.consultar_rd_cd(properties.getProperty("URL_RD_CD_CLT"),eq.getMac(),tokens[0]);
    		}
    	}
    	System.out.println("CD 01 Clt EQUIPOS");
    	centroDigital.setAps(listaAP);
    	centroDigital.setRadio_cd(rd_cd);
    	System.out.println("CD 01 Clt RESPONSABLES");
    	Router_mk router_mk = new Router_mk();
    	router_mk = consultaRestUtil.consultar_router();
    	centroDigital.setRouter_mk(router_mk);
    	centroDigital.setResponsables(centroDigital.getResponsables());
    	if(rd_cd != null) {
    		if(rd_cd.getAp_mac() != null ) {
    			Radio radio_bts = consultaRestUtil.consultar_rd_bts(properties.getProperty("URL_RD_BT_CLT"),rd_cd.getAp_mac(),tokens[0]);
    			centroDigital.setRadio_bts(radio_bts);
    			Switch_bts switch_bts = consultaRestUtil.consultar_switch_bts(properties.getProperty("URL_SW_BT_CLT"),rd_cd.getAp_mac(),tokens[0]);
    			centroDigital.setSwitch_bts(switch_bts);
    		}
    	}
    	connection.close();
    	System.out.println("CD 01 fin");
    	System.out.println("fin");
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
