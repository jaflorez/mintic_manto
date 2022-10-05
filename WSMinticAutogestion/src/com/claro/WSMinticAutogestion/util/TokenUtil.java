package com.claro.WSMinticAutogestion.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Properties;

import com.claro.WSMinticAutogestion.dao.TokenDAO;
import com.claro.WSMinticAutogestion.vo.TokenVO;


public class TokenUtil {
	public String[] consultar_tokens(Properties properties,Connection connection) throws Exception {
		String[] result = new String[3];
		try {
			TokenDAO tokenDao = new TokenDAO(connection);
			TokenVO tokenVO = tokenDao.consultar_token();
			if(tokenVO == null) {
				System.err.println("Error en el proceso, no se puede consultar el token");
				throw new Exception("No se pueden cargar los tokes"); 
			}
			Timestamp timestamp1 = new Timestamp(tokenVO.getFecha().getTime());
            java.util.Date date = new java.util.Date();
            Timestamp timestamp2 = new Timestamp(date.getTime());                
            long minutos = ((timestamp2.getTime() - timestamp1.getTime()) / 1000)  / 60;
            long limite = Long.parseLong(properties.getProperty("TOK_MINUTOS_VIGENCIA"));
            if(minutos > limite) {
            	ConsultaRestUtil consultaRestUtil = new ConsultaRestUtil();
            	String str_token;
            	str_token = consultaRestUtil.get_token_from_server(properties.getProperty("URL_AP1_TOKEN"), properties.getProperty("USR_AP1_CLIENT_ID"), properties.getProperty("USR_AP1_CLIENT_SECRET"));
            	tokenVO.setToken_access_point_srv1(str_token);
            	str_token = consultaRestUtil.get_token_from_server(properties.getProperty("URL_AP2_TOKEN"), properties.getProperty("USR_AP2_CLIENT_ID"), properties.getProperty("USR_AP2_CLIENT_SECRET"));
            	tokenVO.setToken_access_point_srv2(str_token);
            	str_token = consultaRestUtil.get_token_from_server(properties.getProperty("URL_RD_SW_TOKEN"), properties.getProperty("USR_RD_SW_CLIENT_ID"), properties.getProperty("USR_RD_SW_CLIENT_SECRET"));
            	tokenVO.setToken_router_switch_srv1(str_token);
            	Date fecha = new Date(System.currentTimeMillis());
            	tokenVO.setFecha(fecha);
            	tokenDao.update(tokenVO);
            }
            result[0]= tokenVO.getToken_router_switch_srv1();
			result[1]= tokenVO.getToken_access_point_srv1();
			result[2]= tokenVO.getToken_access_point_srv2();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error TokenUtil");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return result;
	}
	

}
