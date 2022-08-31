use mintic;
CREATE TABLE `stresults` (
  `resultID` varchar(50) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `ap_id` varchar(50) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `expected_download_mbps` varchar(50) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `expected_upload_mbps` varchar(50) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `speedtest_server_url` varchar(50) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `payload_download_size` varchar(50) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `payload_upload_size` varchar(50) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `result_download_mbps` varchar(50) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `result_upload_mbps` varchar(50) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `result_latency_ms` varchar(50) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `result_jitter_ms` varchar(50) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `result_start_date` varchar(50) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `result_end_date` varchar(50) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `result_code` varchar(50) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `result_execution` varchar(50) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `test_type` varchar(50) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `workflow_process_id` varchar(50) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `result_message` varchar(50) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;


INSERT INTO STResults(resultID,ap_id,expected_download_mbps,expected_upload_mbps,speedtest_server_url,payload_download_size,
payload_upload_size,result_download_mbps,result_upload_mbps,result_latency_ms,result_jitter_ms,result_start_date,
result_end_date,result_code,result_execution,test_type,workflow_process_id,result_message)
VALUES
(
	'1450720','4335','12.0','3.0','http://172.28.103.2','10','5','10266.81','9261.40'
	,'521.40','598.30','2022-08-24 11:34:02.783','2022-08-24 11:34:05.000'
	,'0','succeeded','on-demand','MTOD-168804','0'
);
