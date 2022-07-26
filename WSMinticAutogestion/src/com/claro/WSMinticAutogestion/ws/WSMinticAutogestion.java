package com.claro.WSMinticAutogestion.ws;

import java.io.BufferedReader;

import java.io.InputStream;
import java.io.InputStreamReader;


import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.claro.WSMinticAutogestion.controller.Controller;
import com.claro.WSMinticAutogestion.json.CentroDigital;
import com.claro.WSMinticAutogestion.util.BufferedUtil;

import com.google.gson.Gson;

/**
 * Clase Principal de Servicio
 */
@Path("/nodes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class WSMinticAutogestion {
	
	private Controller controller;
	/**
	 * Metodo Post de Consults de la información expert track actual del nodo
	 * @param inputStream
	 * @return  response json
	 */
	@POST
	@Path("/consultaCentroDigitial")
	public Response consultaCentroDigital (InputStream idConsulta)  {
	  String json = "";
	  new BufferedUtil();
	  CentroDigital objCentro = new CentroDigital();
	  BufferedReader rd = new BufferedReader(new InputStreamReader(idConsulta));
	  JSONParser jp = new JSONParser();
	  String line = "";
	  String jsonRequest = "";
	  System.out.println("Flag 01");
	  try {
		  while((line = rd.readLine()) != null){
			  jsonRequest = jsonRequest+line.trim();
		  }
		  System.out.println("Flag 02");
		  System.out.println("Valor JSON Enviado: "+jsonRequest);
		  JSONObject jso = (JSONObject)jp.parse(jsonRequest);
		  String id = jso.get("id").toString();
		  controller = new Controller();
		  System.out.println("Flag 03 :" + id);
		  try {
			  objCentro = controller.consultarCentroDigital(id);
			  System.out.println("Flag 03++ :" + objCentro.getNombre_ct_pob());
		  } catch (Exception e) {
			  System.out.println("Flag 04 :" + e.toString());
			  e.printStackTrace();
		  }
		  System.out.println("Flag 04");
	  }
	  catch (Exception e) {
		  System.out.println("Exception: "+e.toString());
		  e.printStackTrace();
	  }
	  System.out.println("Flag 05");
	  Gson gson = new Gson();
	  json = gson.toJson(objCentro);
	  System.out.println("Flag 06");
	  return Response.status(201).entity(json).build();
	}

}
