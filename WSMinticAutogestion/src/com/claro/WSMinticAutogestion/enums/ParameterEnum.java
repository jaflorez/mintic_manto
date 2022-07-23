package com.claro.WSMinticAutogestion.enums;


/**
 * Clase de Enumeracion de Parametros de la Aplicacion
 * @author WILSON GONZALEZ
 *
 */
public enum ParameterEnum {

	//Conexiones Base de datos

	//Driver
	DRIVER("conexion.driver"),
	DRIVER_ORACLE("conexion.driver.oracle"),

	//Produccion
	URL_POLLER("conexionPoller.path"),
	USUARIO_POLLER("conexionPoller.usuario"),
	PASSWORD_POLLER("conexionPoller.pass"),
	
	URL_EXPERTTRACK("conexionExpertTrack.path"),
	USUARIO_EXPERTTRACK("conexionExpertTrack.usuario"),
	PASSWORD_EXPERTTRACK("conexionExpertTrack.pass"),

	//Mensajes de Usuario
	
	//SNMP
	SNMPVERSION("snmp.version"), 
	COMMUNITY("snmp.community"),
	   
	OID_VBAT("oid.vbat"),
	OID_VIN("oid.vin"),
	OID_VOUT("oid.vout"),
	OID_IOUT("oid.iout"),
	OID_FIRMWAREDSM("oid.firmwaredsm"),
	OID_FIRMWARECM("oid.firmwarecm"),
	OID_FAULTED("oid.faulted"),
	OID_T1("oid.t1"),
	OID_T2("oid.t2"),
	OID_T3("oid.t3"),
	OID_T4("oid.t4"),
	IP_ERROR_CONSULTA_SNMP("snmp.ip.errorConsulta"),
	
	
	//ALARMAS
	REG_MAX_ALARMAS("reg.max.alarmas"),
	//Rangos para consuktas de fechas de Historico
	RANGO_HORAS_HIST_OPTICA("rango.horas.hist.optica"),
	RANGO_DIAS_HIST_ESTADO_FUENTE("rango.dias.hist.optica.estado.fuente"),

	//General
	BANDERA_PRODUCCION("bandera.produccion");


	private String value;

	/**
	 * Metodo Constructor
	 * @param value
	 */
	private ParameterEnum(String value) {
		this.value = value;
	}

	/**
	 * Metodo de captura de valor
	 * @return
	 */
	public String getValue() {
		return value;
	}


}
