package com.claro.WSMinticAutogestion.ws;

import java.io.BufferedReader;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.claro.WSMinticAutogestion.controller.Controller;
import com.claro.WSMinticAutogestion.json.SpeedTestResult;
import com.claro.WSMinticAutogestion.vo.ResponsableVO;
import com.claro.WSMinticAutogestion.json.CentroDigital;

import com.google.gson.Gson;

/**
 * Clase Principal de Servicio
 */
@Path("/nodes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class WSMinticAutogestion {
	
	private Controller controller;
	@Context
	private ServletContext context;

	@POST
	@Path("/consultaCentroDigital")
	public Response consultaCentroDigital (InputStream idConsulta)  {
	  String json = "";
	  CentroDigital objCentro = new CentroDigital();
	  try {
		  InputStream input = this.context.getResourceAsStream("/WEB-INF/WSMinticAutoatencion.properties");
		  Properties properties = new Properties();
		  properties.load(input);
		  BufferedReader rd = new BufferedReader(new InputStreamReader(idConsulta));
		  JSONParser jp = new JSONParser();
		  String line = "";
		  String jsonRequest = "";
		  while((line = rd.readLine()) != null){
			  jsonRequest = jsonRequest+line.trim();
		  }
		  JSONObject jso = (JSONObject)jp.parse(jsonRequest);
		  String id = jso.get("id").toString();
		  controller = new Controller(properties);
		  try {
			  objCentro = controller.consultarCentroDigital(id);
		  } catch (Exception e) {
			  e.printStackTrace();
		  }
	  }
	  catch (Exception e) {
		  System.out.println("Exception: "+e.toString());
		  e.printStackTrace();
	  }
	  Gson gson = new Gson();
	  json = gson.toJson(objCentro);
	  return Response.status(201).entity(json).build();
	}
	
	@POST
	@Path("/closedProccessSpeedTest")
	public Response cancelarSpeedTest (InputStream consulta)  {
		  String json = "";
		  SpeedTestResult objCallSpeedTest = new SpeedTestResult();
		  
		  try {
			  InputStream input = this.context.getResourceAsStream("/WEB-INF/WSMinticAutoatencion.properties");
			  Properties properties = new Properties();
			  properties.load(input);
			  BufferedReader rd = new BufferedReader(new InputStreamReader(consulta));
			  JSONParser jp = new JSONParser();
			  String line = "";
			  String jsonRequest = "";
			  while((line = rd.readLine()) != null){
				  jsonRequest = jsonRequest+line.trim();
			  }
			  JSONObject jso = (JSONObject)jp.parse(jsonRequest);
			  String user_id = jso.get("user_id").toString();
			  String ap_id = jso.get("ap_id").toString();
			  controller = new Controller(properties);
			  try {
				  controller.cancelarConsultaSpeeTest(user_id, ap_id);
			  } catch (Exception e) {
				  e.printStackTrace();
			  }
		  }
		  catch (Exception e) {
			  System.out.println("Exception: "+e.toString());
			  e.printStackTrace();
		  }
		  Gson gson = new Gson();
		  json = gson.toJson(objCallSpeedTest);
		  return Response.status(201).entity(json).build();
	}	
	@POST
	@Path("/consultaSpeedTest")
	public Response consultaSpeedTest (InputStream consulta)  {
	  String json = "";
	  SpeedTestResult objCallSpeedTest = new SpeedTestResult();
	  
	  try {
		  InputStream input = this.context.getResourceAsStream("/WEB-INF/WSMinticAutoatencion.properties");
		  Properties properties = new Properties();
		  properties.load(input);
		  BufferedReader rd = new BufferedReader(new InputStreamReader(consulta));
		  JSONParser jp = new JSONParser();
		  String line = "";
		  String jsonRequest = "";
		  while((line = rd.readLine()) != null){
			  jsonRequest = jsonRequest+line.trim();
		  }
		  JSONObject jso = (JSONObject)jp.parse(jsonRequest);
		  String user_id = jso.get("user_id").toString();
		  String ap_id = jso.get("ap_id").toString();
		  String fecha_solicitud = jso.get("fecha_solicitud").toString();
		  controller = new Controller(properties);
		  try {
			  objCallSpeedTest = controller.getTestVelocidad(user_id, ap_id,fecha_solicitud);
			  
		  } catch (Exception e) {
			  e.printStackTrace();
		  }
	  }
	  catch (Exception e) {
		  System.out.println("Exception: "+e.toString());
		  e.printStackTrace();
	  }
	  Gson gson = new Gson();
	  json = gson.toJson(objCallSpeedTest);
	  return Response.status(201).entity(json).build();
	}
	@POST
	@Path("/consultaResponsables")
	public Response consultaResponsable (InputStream idConsulta)  {
	  String json = "";
	  List<ResponsableVO> listaResponsable= new ArrayList<>();
	  
	  try {
		  InputStream input = this.context.getResourceAsStream("/WEB-INF/WSMinticAutoatencion.properties");
		  Properties properties = new Properties();
		  properties.load(input);
		  BufferedReader rd = new BufferedReader(new InputStreamReader(idConsulta));
		  JSONParser jp = new JSONParser();
		  String line = "";
		  String jsonRequest = "";
		  while((line = rd.readLine()) != null){
			  jsonRequest = jsonRequest+line.trim();
		  }
		  JSONObject jso = (JSONObject)jp.parse(jsonRequest);
		  String id_beneficiario = jso.get("id_beneficiario").toString();
		  controller = new Controller(properties);
		  try {
			  listaResponsable =  controller.consultarResponsables(id_beneficiario);
		  } catch (Exception e) {
			  e.printStackTrace();
		  }
	  }
	  catch (Exception e) {
		  System.out.println("Exception: "+e.toString());
		  e.printStackTrace();
	  }
	  Gson gson = new Gson();
	  json = gson.toJson(listaResponsable);
	  return Response.status(201).entity(json).build();
	}
	
	@POST
	@Path("/eliminarResponsable")
	public Response eliminarResponsable (InputStream idConsulta)  {
		return null;
	}
	
	@POST
	@Path("/modificarResponsable")
	public Response modificarResponsable (InputStream idConsulta)  {
		return null;
	}
	
	@POST
	@Path("/crearResponsable")
	public Response crearResponsable (InputStream idConsulta)  {
		return null;
	}
	
	
	

}
