use mintic;
select * from speed_test_call;
select * from speed_test_call WHERE ap_id='10537' ;
select * from speed_test_call ;
select * from token ;
update token  set fecha='2022-10-06 07:26:40';
SELECT TIMESTAMPDIFF(SECOND,'2022-10-06 11:00:00',sysdate()) segund; 
select *,TIMESTAMPDIFF(SECOND,fecha,sysdate()) segund from speed_test_call;
select *,TIMESTAMPDIFF(SECOND,fecha,sysdate()) segund from speed_test_call where TIMESTAMPDIFF(SECOND,fecha,sysdate()) > 60 and estado='registro';

update speed_test_call set estado = 'cancelada' where TIMESTAMPDIFF(SECOND,fecha,sysdate()) > 60 and estado='registro';












/*
'registro'
*/









