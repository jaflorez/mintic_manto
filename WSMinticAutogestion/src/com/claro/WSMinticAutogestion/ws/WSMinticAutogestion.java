package com.claro.WSMinticAutogestion.ws;

import java.io.BufferedReader;

import java.io.InputStream;
import java.io.InputStreamReader;
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
	/**
	 * Metodo Post de Consults de la información expert track actual del nodo
	 * @param inputStream
	 * @return  response json
	 */
	@POST
	@Path("/consultaCentroDigitial")
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

}
