CREATE DATABASE  IF NOT EXISTS `mintic` /*!40100 DEFAULT CHARACTER SET latin1 COLLATE latin1_spanish_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `mintic`;


DROP TABLE IF EXISTS `centro_digital`;
CREATE TABLE `centro_digital` (
  `id_beneficiario` varchar(20) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `llave` varchar(45) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `id_mintic` varchar(45) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `nombre_ct_pob` varchar(200) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `municipio` varchar(200) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `departamento` varchar(200) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `vlan` varchar(20) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `ip_router` varchar(20) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `server_data` int DEFAULT NULL,
  `bw_down_kbps` varchar(20) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `bw_up_kbps` varchar(20) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `ap_id` mediumint DEFAULT NULL,
  PRIMARY KEY (`id_beneficiario`),
  UNIQUE KEY `uk_llave` (`llave`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

DROP TABLE IF EXISTS `consolidado`;
CREATE TABLE `consolidado` (
  `id_unificado` varchar(200) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `nombre_sede` varchar(400) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `bts_original` varchar(100) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `equipo_acceso_original` varchar(100) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `puerto_original` varchar(50) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `bts_diseno_mw` varchar(50) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `equipo_acceso` varchar(100) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `puerto_1` varchar(200) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `ip_red` varchar(200) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `conectante` varchar(500) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `nemonico` varchar(500) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `referencia` varchar(100) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `slot` varchar(200) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `puerto_2` varchar(200) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `sitio_a` varchar(200) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `sitio_b` varchar(100) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `gateway` varchar(20) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `vlan` varchar(20) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `mask` varchar(20) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `ip_sitio_a_local_bts` varchar(20) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `ip_sitio_b_remoto_cd` varchar(20) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `gestion_switch_cambium` varchar(50) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `5_equipo_alu_origen_servicio` varchar(100) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `3_sap_id_origen_7705` varchar(200) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `6_nombre_de_interfaz_en_7750` varchar(100) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `8_ip_de_interfaz_en_7750` varchar(20) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `fase` varchar(20) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `cierre_um` varchar(20) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `id_beneficiario` varchar(50) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `estado_operación` varchar(300) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `comentarios` varchar(2000) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `archivo` varchar(100) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `filtro_temp2` varchar(200) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

DROP TABLE IF EXISTS `equipo`;
CREATE TABLE `equipo` (
  `id_beneficiario` varchar(20) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `tipo` varchar(10) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `mac` varchar(30) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `ip` varchar(30) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`id_beneficiario`,`tipo`),
  KEY `fk_equipo_cd_idx` (`id_beneficiario`),
  CONSTRAINT `fk_equipo_centro_digital` FOREIGN KEY (`id_beneficiario`) REFERENCES `centro_digital` (`id_beneficiario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

DROP TABLE IF EXISTS `generador_scripts`;
CREATE TABLE `generador_scripts` (
  `id_mintic` varchar(12) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `id_beneficiario` varchar(10) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `ot` varchar(20) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `codigo_servicio` varchar(9) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `llave` varchar(18) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `nombre_municipio` varchar(200) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `coddanemuni` varchar(9) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `nombre_departamento` varchar(200) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `coddanedepar` varchar(6) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `nombre_centro_pob` varchar(200) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `coddaneinstitucionedu` varchar(50) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `matricula` varchar(50) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `bw_down_kbps` varchar(10) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `bw_up_kbps` varchar(9) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `total_bw` varchar(10) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `latitud` varchar(50) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `longitud` varchar(50) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `red` varchar(18) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `ip_ether1` varchar(18) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `mask_ether1` varchar(20) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `pe_wan` varchar(18) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `vlan_ether1` varchar(9) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `ip_ether2` varchar(16) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `mask_ether2` varchar(20) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `red_indoor` varchar(15) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `ip_indoor` varchar(15) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `mask_ether3` varchar(18) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `vlan_ether3` varchar(7) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `pcs_pool_1` varchar(8) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `ip_outdoor1` varchar(17) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `ip_outdoor2` varchar(17) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `mask_ether4_5` varchar(18) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `vlan_ether4_5` varchar(7) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `pcs_pool_2` varchar(100) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `bts_estación_base` varchar(100) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `tipo_equipo` varchar(50) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `equipo_ipran` varchar(100) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `puerto` varchar(100) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `pe_capa_3` varchar(30) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `interfaz_pe_capa_3` varchar(50) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `new_bst` varchar(5) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `tipo_equipo2` varchar(5) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `new_equipo_` varchar(5) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `new_pto` varchar(5) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `capa_3` varchar(5) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `interfaz` varchar(5) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `rediseño` varchar(5) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `rediseño2` varchar(5) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `cambios` varchar(100) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `obs_general` varchar(100) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `grupo` varchar(50) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `fecha_reconfigurar` varchar(20) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `vlan_wan` varchar(6) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `aliado_confi` varchar(50) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `nombre_ing_confi` varchar(100) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `fecha_config` varchar(50) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `estado_config` varchar(12) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `fecha_visita_s_o` varchar(100) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `estado_sharepoint` varchar(100) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `new_pem_aliado` varchar(200) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `proveedor_um_tercero` varchar(100) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `aliado_campo` varchar(100) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `pim_` varchar(100) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `pim_contacto` varchar(200) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `nombre_pem` varchar(150) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `hora_inicio` varchar(30) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `hora_fin` varchar(50) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `ultra_causa_no_exitosa` varchar(400) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `justificacion_estado_pem` varchar(800) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `fecha_pem` varchar(15) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `estado_pem` varchar(30) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `backup_fw_ingenio` varchar(50) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `pem_estado_calidad` varchar(50) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `sistema_electrico` varchar(50) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `kill_` varchar(50) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `prueba_de_aislamineto_banda_ku` varchar(50) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `tecnologia` varchar(100) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `nombre_ing_de_soporte` varchar(100) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `hora_inicio_mig` varchar(20) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `hora_fin_mig` varchar(20) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `ultra_causa_mig` varchar(100) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `justificacion_estado_migracion` varchar(400) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `fecha_migracion` varchar(15) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `estado_migracion` varchar(20) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `nombre_ing_sop` varchar(30) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `hora_inicio_sop` varchar(100) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `hora_fin_sop` varchar(100) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `justificacion_estado_sop` varchar(400) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `fecha_sop` varchar(15) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `estado_soporte_s_o` varchar(15) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `nombre_ing_de_pruebas` varchar(30) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `hora_inicio_prueba` varchar(100) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `hora_fin_pruebas` varchar(100) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `justificacion_estado_pruebas` varchar(2000) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `fecha_pruebas` varchar(15) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `estado_pruebas` varchar(30) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `nombre_ing_de_mtto` varchar(200) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `hora_inicio_mtto` varchar(20) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `hora_fin_mtto` varchar(20) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `ultra_causa_mtto` varchar(200) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `justificacion_estado_mtto` varchar(400) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `fecha_mtto` varchar(20) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `estado_mtto` varchar(100) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

DROP TABLE IF EXISTS `responsable`;
CREATE TABLE `responsable` (
  `id_responsable` int NOT NULL AUTO_INCREMENT,
  `id_beneficiario` varchar(20) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `name_resp` varchar(150) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `phone` varchar(150) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `email` varchar(150) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`id_responsable`),
  KEY `fk_responsable_centro_digital` (`id_beneficiario`),
  CONSTRAINT `fk_responsable_centro_digital` FOREIGN KEY (`id_beneficiario`) REFERENCES `centro_digital` (`id_beneficiario`)
) ENGINE=InnoDB AUTO_INCREMENT=9166 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
DROP TABLE IF EXISTS `speed_test_call`;
CREATE TABLE `speed_test_call` (
  `speed_test_call_id` int NOT NULL AUTO_INCREMENT,
  `usuario` varchar(80) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `ap_id` varchar(30) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `workflow_process_id` varchar(45) COLLATE latin1_spanish_ci NOT NULL,
  `fecha` timestamp NOT NULL,
  `estado` varchar(30) COLLATE latin1_spanish_ci NOT NULL,
  `fecha_solicitud` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`speed_test_call_id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

DROP TABLE IF EXISTS `tmp_access_point`;
CREATE TABLE `tmp_access_point` (
  `description_ap` varchar(200) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `name_ap` varchar(100) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `ip_ap` varchar(30) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `network` varchar(30) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `product` varchar(30) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `msn` varchar(30) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `site` varchar(200) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `mac` varchar(30) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `parent_mac` varchar(30) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `site_id` varchar(200) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `server_data` int DEFAULT NULL,
  KEY `uk_mac` (`mac`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
DROP TABLE IF EXISTS `tmp_radios_switch_api`;
CREATE TABLE `tmp_radios_switch_api` (
  `name_rs` varchar(200) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `ip` varchar(50) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `network` varchar(200) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `product` varchar(200) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `type` varchar(200) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `mac` varchar(200) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `mode` varchar(200) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `tower` varchar(200) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `status` varchar(50) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `description` varchar(200) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
DROP TABLE IF EXISTS `tmp_radios_switch_cnmaestro`;
CREATE TABLE `tmp_radios_switch_cnmaestro` (
  `managed_account` varchar(200) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `mac` varchar(200) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `device_name` varchar(200) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `ip_address` varchar(200) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `ipv6_address` varchar(200) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `device_type` varchar(200) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `serial_number` varchar(200) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `description` varchar(200) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `active_sw_version` varchar(200) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `duration` varchar(200) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `status` varchar(200) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `status_time` varchar(200) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `status_time_seconds` varchar(200) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `height` varchar(200) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
DELIMITER ;;
CREATE DEFINER=`mintic_db`@`%` PROCEDURE `sp_update_access_point`()
BEGIN	
    DELETE from tmp_access_point WHERE name_ap like('%DEMO%');
    
	DELETE from tmp_access_point WHERE left(name_ap,13) NOT IN(SELECT llave from centro_digital where llave = left(name_ap,13) );
    DELETE FROM equipo where TIPO IN('AP-INT','AP-EXT1','AP-EXT2');
    
	INSERT INTO equipo(id_beneficiario,tipo,mac,ip) 
	SELECT LEFT(name_ap, 5) as id_bene,'AP-INT' as tipo,mac,ip_ap from tmp_access_point 
	WHERE LEFT(name_ap, 5) in (select id_beneficiario from centro_digital where id_beneficiario = LEFT(name_ap, 5) )
	AND name_ap LIKE('%AP-INT') and site_id != ''  ;    

	INSERT INTO equipo(id_beneficiario,tipo,mac,ip) 
	SELECT LEFT(name_ap, 5) as id_bene,'AP-EXT1' as tipo,max(mac) AS MAC,max(ip_ap) as ip_ap from tmp_access_point 
	WHERE LEFT(name_ap, 5) in (select id_beneficiario from centro_digital where id_beneficiario = LEFT(name_ap, 5) )
	AND name_ap LIKE('%AP-EXT1') and site_id != '' 
	GROUP BY LEFT(name_ap, 5),name_ap;
	
    INSERT INTO equipo(id_beneficiario,tipo,mac,ip) 
	SELECT LEFT(name_ap, 5) as id_bene,'AP-EXT2' as tipo,max(mac) AS MAC,max(ip_ap) as ip_ap from tmp_access_point 
	WHERE LEFT(name_ap, 5) in (select id_beneficiario from centro_digital where id_beneficiario = LEFT(name_ap, 5) )
	AND name_ap LIKE('%AP-EXT2') and site_id != '' 
	GROUP BY LEFT(name_ap, 5),name_ap;
    update centro_digital set server_data = 1 where  id_beneficiario in(select left(name_ap,5) from tmp_access_point where server_data = 1 );
    update centro_digital set server_data = 2 where  id_beneficiario in(select left(name_ap,5) from tmp_access_point where server_data = 2 );
END ;;
DELIMITER ;
DELIMITER ;;
CREATE DEFINER=`mintic_db`@`%` PROCEDURE `sp_update_consolidado`()
BEGIN	
    SELECT '?' AS TMP;

END ;;
DELIMITER ;
DELIMITER ;;
CREATE DEFINER=`mintic_db`@`%` PROCEDURE `sp_update_generador_scripts`()
BEGIN
	INSERT INTO `centro_digital`(id_beneficiario,llave,id_mintic,nombre_ct_pob,municipio,departamento,ip_router,vlan,bw_down_kbps,bw_up_kbps)
	SELECT 	id_beneficiario,llave,id_mintic,nombre_centro_pob,nombre_municipio,nombre_departamento,ip_ether2,vlan_wan,bw_down_kbps,bw_up_kbps 
		FROM generador_scripts 
	WHERE NOT isnull(id_beneficiario)
		AND ID_BENEFICIARIO NOT IN(SELECT ID_BENEFICIARIO FROM CENTRO_DIGITAL);

	UPDATE centro_digital AS a, generador_scripts AS b
	SET a.vlan = b.vlan_wan, a.llave=b.llave,a.id_mintic=b.id_mintic,
		a.nombre_ct_pob=b.nombre_centro_pob,a.municipio=b.nombre_municipio,
		a.departamento=nombre_departamento,a.ip_router= b.ip_ether2,
        a.bw_down_kbps = b.bw_down_kbps,a.bw_up_kbps = b.bw_up_kbps
	WHERE a.id_beneficiario=b.id_beneficiario;    
END ;;
DELIMITER ;
DELIMITER ;;
CREATE DEFINER=`mintic_db`@`%` PROCEDURE `sp_update_radios_switch_cnmaestro`()
BEGIN
	DELETE FROM equipo where tipo = 'RD-CD';
	INSERT INTO equipo(id_beneficiario,tipo,mac)
		SELECT   b.id_beneficiario,'RD-CD',a.mac FROM tmp_radios_switch_cnmaestro AS a
		INNER  JOIN centro_digital b ON LEFT(a.device_name,5) = b.id_beneficiario
		WHERE a.device_type LIKE('%SM') and a.status = 'Online';

	DELETE FROM equipo WHERE tipo = 'RD-BT';
	INSERT INTO equipo(id_beneficiario,tipo,mac)
		SELECT b.id_beneficiario,'RD-BT',mac  from tmp_radios_switch_cnmaestro as a
		INNER  JOIN consolidado b on a.ip_address = b.ip_sitio_a_local_bts
		INNER JOIN centro_digital c on c.id_beneficiario = b.id_beneficiario
		WHERE a.device_type like('%AP%') and length(b.id_beneficiario)=5 and a.status = 'Online'; 

	DELETE FROM equipo WHERE tipo = 'SW-BT';
	INSERT INTO equipo(id_beneficiario,tipo,mac)
		SELECT  c.id_beneficiario,'SW-BT',mac
		FROM  tmp_radios_switch_cnmaestro AS a 
		INNER JOIN  consolidado b ON b.gestion_switch_cambium = a.ip_address
		INNER JOIN centro_digital c ON c.id_beneficiario = b.id_beneficiario
		WHERE (a.device_type LIKE('%EX1010%') OR a.device_type LIKE('%2020R%')) AND a.status = 'Online';
END ;;
DELIMITER ;

