use mintic;
select * from equipo;

select * from equipo  where id_beneficiario = '10537'  limit 20;

select tipo,count(1) from equipo group by tipo;
delete from equipo where tipo = 'SW-BT-12';

call sp_update_radios_switch_cnmaestro();

select * from equipo where id_beneficiario = '10537';

		SELECT   b.id_beneficiario,'RD-CD',a.mac,a.ip_address FROM tmp_radios_switch_cnmaestro AS a
		INNER  JOIN centro_digital b ON LEFT(a.device_name,5) = b.id_beneficiario
		WHERE a.device_type LIKE('%SM') and a.status = 'Online';

		SELECT b.id_beneficiario,'RD-BT',a.mac,a.ip_address  from tmp_radios_switch_cnmaestro as a
		INNER  JOIN consolidado b on a.ip_address = b.ip_sitio_a_local_bts
		INNER JOIN centro_digital c on c.id_beneficiario = b.id_beneficiario
		WHERE a.device_type like('%AP%') and length(b.id_beneficiario)=5 and a.status = 'Online' and b.id_beneficiario != '0' ; 
	DELETE FROM equipo WHERE tipo = 'SW-BT';
	INSERT INTO equipo(id_beneficiario,tipo,mac,ip)
			SELECT b.id_beneficiario,'SW_BT' AS tipo,a.mac,a.ip_address
				FROM  tmp_radios_switch_cnmaestro AS a 
					INNER JOIN  consolidado b ON b.gestion_switch_cambium = a.ip_address
					INNER JOIN centro_digital c ON c.id_beneficiario = b.id_beneficiario
				WHERE (a.device_type LIKE('%EX1010%') OR a.device_type LIKE('%2020R%')) 
					AND a.status = 'Online' and b.id_beneficiario != '0' ;
			
            select gestion_switch_cambium from consolidado where id_beneficiario = '21527';
            
            select * from tmp_radios_switch_cnmaestro where ip_address='10.68.225.150';
            select * from consolidado  b  where gestion_switch_cambium = '10.68.225.150';
            select * from tmp_radios_switch_cnmaestro where ip_address='10.68.225.150';
            

            SELECT b.id_beneficiario,'SW_BT' AS tipo,a.mac,a.ip_address
				FROM  tmp_radios_switch_cnmaestro AS a                     

