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
	  
	  
	  String line = "";
	  String jsonRequest = "";
	  try {
		  while((line = rd.readLine()) != null){
			  jsonRequest = jsonRequest+line.trim();
		  }
		  System.out.println("Valor JSON Enviado: "+jsonRequest);
		  controller = new Controller();
		  try {
			  objCentro = controller.consultarCentroDigital(jsonRequest);
			  
		  } catch (Exception e) {
			  e.printStackTrace();
		  }
	  }
	  catch (Exception e) {
		  e.printStackTrace();
	  }
	  Gson gson = new Gson();
	  json = gson.toJson(objCentro);
	  return Response.status(201).entity(json).build();
	}

}
