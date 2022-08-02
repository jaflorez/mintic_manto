CREATE DATABASE  IF NOT EXISTS `mintic` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `mintic`;
-- MySQL dump 10.13  Distrib 8.0.25, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: mintic
-- ------------------------------------------------------
-- Server version	8.0.25

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `centro_digital`
--

DROP TABLE IF EXISTS `centro_digital`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `centro_digital` (
  `id_beneficiario` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `llave` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `id_mintic` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `nombre_ct_pob` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `municipio` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `departamento` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `vlan` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `ip_router` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `server_data` int DEFAULT NULL,
  PRIMARY KEY (`id_beneficiario`),
  UNIQUE KEY `uk_llave` (`llave`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `consolidado`
--

DROP TABLE IF EXISTS `consolidado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `consolidado` (
  `id_unificado` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `nombre_sede` varchar(400) COLLATE utf8_unicode_ci DEFAULT NULL,
  `bts_original` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `equipo_acceso_original` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `puerto_original` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `bts_diseno_mw` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `equipo_acceso` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `puerto_1` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ip_red` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `conectante` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  `nemonico` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  `referencia` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `slot` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `puerto_2` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `sitio_a` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `sitio_b` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `gateway` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `vlan` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `mask` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ip_sitio_a_local_bts` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ip_sitio_b_remoto_cd` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `gestion_switch_cambium` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `5_equipo_alu_origen_servicio` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `3_sap_id_origen_7705` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `6_nombre_de_interfaz_en_7750` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `8_ip_de_interfaz_en_7750` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `fase` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `cierre_um` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `id_beneficiario` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `estado_operación` varchar(300) COLLATE utf8_unicode_ci DEFAULT NULL,
  `comentarios` varchar(2000) COLLATE utf8_unicode_ci DEFAULT NULL,
  `archivo` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `filtro_temp2` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `equipo`
--

DROP TABLE IF EXISTS `equipo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `equipo` (
  `id_beneficiario` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `tipo` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `mac` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id_beneficiario`,`tipo`),
  KEY `fk_equipo_cd_idx` (`id_beneficiario`),
  CONSTRAINT `fk_equipo_centro_digital` FOREIGN KEY (`id_beneficiario`) REFERENCES `centro_digital` (`id_beneficiario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `generador_scripts`
--

DROP TABLE IF EXISTS `generador_scripts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `generador_scripts` (
  `id_mintic` varchar(12) COLLATE utf8_unicode_ci NOT NULL,
  `id_beneficiario` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ot` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `codigo_servicio` varchar(9) COLLATE utf8_unicode_ci DEFAULT NULL,
  `llave` varchar(18) COLLATE utf8_unicode_ci DEFAULT NULL,
  `nombre_municipio` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `coddanemuni` varchar(9) COLLATE utf8_unicode_ci DEFAULT NULL,
  `nombre_departamento` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `coddanedepar` varchar(6) COLLATE utf8_unicode_ci DEFAULT NULL,
  `nombre_centro_pob` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `coddaneinstitucionedu` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `matricula` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `bw_down_kbps` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `bw_up_kbps` varchar(9) COLLATE utf8_unicode_ci DEFAULT NULL,
  `total_bw` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `latitud` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `longitud` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `red` varchar(18) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ip_ether1` varchar(18) COLLATE utf8_unicode_ci DEFAULT NULL,
  `mask_ether1` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `pe_wan` varchar(18) COLLATE utf8_unicode_ci DEFAULT NULL,
  `vlan_ether1` varchar(9) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ip_ether2` varchar(16) COLLATE utf8_unicode_ci DEFAULT NULL,
  `mask_ether2` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `red_indoor` varchar(15) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ip_indoor` varchar(15) COLLATE utf8_unicode_ci DEFAULT NULL,
  `mask_ether3` varchar(18) COLLATE utf8_unicode_ci DEFAULT NULL,
  `vlan_ether3` varchar(7) COLLATE utf8_unicode_ci DEFAULT NULL,
  `pcs_pool_1` varchar(8) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ip_outdoor1` varchar(17) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ip_outdoor2` varchar(17) COLLATE utf8_unicode_ci DEFAULT NULL,
  `mask_ether4_5` varchar(18) COLLATE utf8_unicode_ci DEFAULT NULL,
  `vlan_ether4_5` varchar(7) COLLATE utf8_unicode_ci DEFAULT NULL,
  `pcs_pool_2` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `bts_estación_base` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `tipo_equipo` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `equipo_ipran` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `puerto` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `pe_capa_3` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `interfaz_pe_capa_3` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `new_bst` varchar(5) COLLATE utf8_unicode_ci DEFAULT NULL,
  `tipo_equipo2` varchar(5) COLLATE utf8_unicode_ci DEFAULT NULL,
  `new_equipo_` varchar(5) COLLATE utf8_unicode_ci DEFAULT NULL,
  `new_pto` varchar(5) COLLATE utf8_unicode_ci DEFAULT NULL,
  `capa_3` varchar(5) COLLATE utf8_unicode_ci DEFAULT NULL,
  `interfaz` varchar(5) COLLATE utf8_unicode_ci DEFAULT NULL,
  `rediseño` varchar(5) COLLATE utf8_unicode_ci DEFAULT NULL,
  `rediseño2` varchar(5) COLLATE utf8_unicode_ci DEFAULT NULL,
  `cambios` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `obs_general` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `grupo` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `fecha_reconfigurar` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `vlan_wan` varchar(6) COLLATE utf8_unicode_ci DEFAULT NULL,
  `aliado_confi` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `nombre_ing_confi` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `fecha_config` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `estado_config` varchar(12) COLLATE utf8_unicode_ci DEFAULT NULL,
  `fecha_visita_s_o` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `estado_sharepoint` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `new_pem_aliado` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `proveedor_um_tercero` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `aliado_campo` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `pim_` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `pim_contacto` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `nombre_pem` varchar(150) COLLATE utf8_unicode_ci DEFAULT NULL,
  `hora_inicio` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `hora_fin` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ultra_causa_no_exitosa` varchar(400) COLLATE utf8_unicode_ci DEFAULT NULL,
  `justificacion_estado_pem` varchar(800) COLLATE utf8_unicode_ci DEFAULT NULL,
  `fecha_pem` varchar(15) COLLATE utf8_unicode_ci DEFAULT NULL,
  `estado_pem` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `backup_fw_ingenio` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `pem_estado_calidad` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `sistema_electrico` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `kill_` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `prueba_de_aislamineto_banda_ku` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `tecnologia` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `nombre_ing_de_soporte` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `hora_inicio_mig` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `hora_fin_mig` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ultra_causa_mig` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `justificacion_estado_migracion` varchar(400) COLLATE utf8_unicode_ci DEFAULT NULL,
  `fecha_migracion` varchar(15) COLLATE utf8_unicode_ci DEFAULT NULL,
  `estado_migracion` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `nombre_ing_sop` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `hora_inicio_sop` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `hora_fin_sop` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `justificacion_estado_sop` varchar(400) COLLATE utf8_unicode_ci DEFAULT NULL,
  `fecha_sop` varchar(15) COLLATE utf8_unicode_ci DEFAULT NULL,
  `estado_soporte_s_o` varchar(15) COLLATE utf8_unicode_ci DEFAULT NULL,
  `nombre_ing_de_pruebas` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `hora_inicio_prueba` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `hora_fin_pruebas` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `justificacion_estado_pruebas` varchar(2000) COLLATE utf8_unicode_ci DEFAULT NULL,
  `fecha_pruebas` varchar(15) COLLATE utf8_unicode_ci DEFAULT NULL,
  `estado_pruebas` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `nombre_ing_de_mtto` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `hora_inicio_mtto` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `hora_fin_mtto` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ultra_causa_mtto` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `justificacion_estado_mtto` varchar(400) COLLATE utf8_unicode_ci DEFAULT NULL,
  `fecha_mtto` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `estado_mtto` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `responsable`
--

DROP TABLE IF EXISTS `responsable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `responsable` (
  `id_responsable` int NOT NULL AUTO_INCREMENT,
  `id_beneficiario` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `name_resp` varchar(150) COLLATE utf8_unicode_ci NOT NULL,
  `phone` varchar(150) COLLATE utf8_unicode_ci DEFAULT NULL,
  `email` varchar(150) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id_responsable`),
  KEY `fk_responsable_centro_digital` (`id_beneficiario`),
  CONSTRAINT `fk_responsable_centro_digital` FOREIGN KEY (`id_beneficiario`) REFERENCES `centro_digital` (`id_beneficiario`)
) ENGINE=InnoDB AUTO_INCREMENT=9173 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tmp_access_point`
--

DROP TABLE IF EXISTS `tmp_access_point`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tmp_access_point` (
  `description_ap` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `name_ap` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ip_ap` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `network` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `product` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `msn` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `site` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `mac` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `parent_mac` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `site_id` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `server_data` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tmp_rd_sw`
--

DROP TABLE IF EXISTS `tmp_rd_sw`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tmp_rd_sw` (
  `managed_account` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `mac` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `device_name` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ip_address` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ipv6_address` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `device_type` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `serial_number` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `description` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `active_sw_version` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `duration` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `status` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `status_time` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `status_time_seconds` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `height` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tmp_rs`
--

DROP TABLE IF EXISTS `tmp_rs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tmp_rs` (
  `name_rs` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ip` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `network` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `product` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `type` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `mac` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `mode` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `tower` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `status` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `description` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tmp_swmc`
--

DROP TABLE IF EXISTS `tmp_swmc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tmp_swmc` (
  `mac` varchar(30) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping routines for database 'mintic'
--
/*!50003 DROP PROCEDURE IF EXISTS `sp_update_ap` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_update_ap`()
BEGIN	
    DELETE from tmp_access_point WHERE name_ap like('%DEMO%');
    
	DELETE from tmp_access_point WHERE left(name_ap,13) NOT IN(SELECT llave from centro_digital where llave = left(name_ap,13) );
    DELETE FROM equipo where TIPO IN('AP-INT','AP-EXT1','AP-EXT2');
    
    
	INSERT INTO equipo(id_beneficiario,tipo,mac) 
	SELECT LEFT(name_ap, 5) as id_bene,'AP-INT' as tipo,mac from tmp_access_point 
	WHERE LEFT(name_ap, 5) in (select id_beneficiario from centro_digital where id_beneficiario = LEFT(name_ap, 5) )
	AND name_ap LIKE('%AP-INT') and site_id != ''  ;    

	INSERT INTO equipo(id_beneficiario,tipo,mac) 
	SELECT LEFT(name_ap, 5) as id_bene,'AP-EXT1' as tipo,max(mac) AS MAC from tmp_access_point 
	WHERE LEFT(name_ap, 5) in (select id_beneficiario from centro_digital where id_beneficiario = LEFT(name_ap, 5) )
	AND name_ap LIKE('%AP-EXT1') and site_id != '' 
	GROUP BY LEFT(name_ap, 5),name_ap;
	INSERT INTO equipo(id_beneficiario,tipo,mac) 
	SELECT LEFT(name_ap, 5) as id_bene,'AP-EXT2' as tipo,max(mac) AS MAC from tmp_access_point 
	WHERE LEFT(name_ap, 5) in (select id_beneficiario from centro_digital where id_beneficiario = LEFT(name_ap, 5) )
	AND name_ap LIKE('%AP-EXT2') and site_id != '' 
	GROUP BY LEFT(name_ap, 5),name_ap;
    update centro_digital set server_data = 1 where  id_beneficiario in(select left(name_ap,5) from tmp_access_point where server_data = 1 );
    update centro_digital set server_data = 2 where  id_beneficiario in(select left(name_ap,5) from tmp_access_point where server_data = 2 );
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_update_consolidado` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_update_consolidado`()
BEGIN	
    SELECT '?' AS TMP;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_update_generador_scripts` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_update_generador_scripts`()
BEGIN
	INSERT INTO `centro_digital`(id_beneficiario,llave,id_mintic,nombre_ct_pob,municipio,departamento,ip_router,vlan)
	SELECT 	id_beneficiario,llave,id_mintic,nombre_centro_pob,nombre_municipio,nombre_departamento,ip_ether2,vlan_wan 
		FROM generador_scripts 
	WHERE NOT isnull(id_beneficiario)
		AND ID_BENEFICIARIO NOT IN(SELECT ID_BENEFICIARIO FROM CENTRO_DIGITAL);

	UPDATE centro_digital AS a, generador_scripts AS b
	SET a.vlan = b.vlan_wan, a.llave=b.llave,a.id_mintic=b.id_mintic,
		a.nombre_ct_pob=b.nombre_centro_pob,a.municipio=b.nombre_municipio,
		a.departamento=nombre_departamento,a.ip_router= b.ip_ether2
	WHERE a.id_beneficiario=b.id_beneficiario;    
        

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_update_rs` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_update_rs`()
BEGIN	
    select 'saludo';
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_update_sw_rs` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`mintic_db`@`%` PROCEDURE `sp_update_sw_rs`()
BEGIN
	DELETE FROM equipo where tipo = 'RD-CD';
	INSERT INTO equipo(id_beneficiario,tipo,mac)
		SELECT   b.id_beneficiario,'RD-CD',a.mac FROM tmp_rd_sw AS a
		INNER  JOIN centro_digital b ON LEFT(a.device_name,5) = b.id_beneficiario
		WHERE a.device_type LIKE('%SM') and a.status = 'Online';

	DELETE FROM equipo WHERE tipo = 'RD-BT';
    
	INSERT INTO equipo(id_beneficiario,tipo,mac)
		SELECT b.id_beneficiario,'RD-BT',mac  from tmp_rd_sw as a
		INNER  JOIN consolidado b on a.ip_address = b.ip_sitio_a_local_bts
		INNER JOIN centro_digital c on c.id_beneficiario = b.id_beneficiario
		WHERE a.device_type like('%AP%') and length(b.id_beneficiario)=5 and a.status = 'Online'; 

	DELETE FROM equipo WHERE tipo = 'SW-BT';
	INSERT INTO equipo(id_beneficiario,tipo,mac)
		SELECT  c.id_beneficiario,'SW-BT',mac
		FROM  tmp_rd_sw AS a 
		INNER JOIN  consolidado b ON b.gestion_switch_cambium = a.ip_address
		INNER JOIN centro_digital c ON c.id_beneficiario = b.id_beneficiario
		WHERE (a.device_type LIKE('%EX1010%') OR a.device_type LIKE('%2020R%')) AND a.status = 'Online';
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-08-02 17:40:22
