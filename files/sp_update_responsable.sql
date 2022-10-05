CREATE TABLE `tmp_responsable` (
  `id_responsable` int NOT NULL AUTO_INCREMENT,
  `id_beneficiario` varchar(20) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `name_resp` varchar(150) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `phone` varchar(150) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `email` varchar(150) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`id_responsable`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

DELIMITER $$
CREATE  PROCEDURE `sp_update_responsable`()
BEGIN	

	insert into responsable(id_beneficiario,name_resp,phone,email)
	SELECT a.id_beneficiario,a.name_resp,a.phone,a.email FROM tmp_responsable a 
		INNER JOIN centro_digital b ON  a.id_beneficiario=b.id_beneficiario
		LEFT JOIN responsable c on c.id_beneficiario = a.id_beneficiario
	where isnull(c.id_beneficiario);
END$$
DELIMITER ;


