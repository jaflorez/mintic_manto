package com.claro.WSMinticAutogestion.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.claro.WSMinticAutogestion.vo.CallSpeedTestVO;

import co.com.claro.www.speedtest.ManageAPSearchingSoapProxy;
import co.com.claro.www.speedtest.SearchAPByTextResult;
import co.com.claro.www.workflow.RunSpeedTestOnDemandWorkflowSoapProxy;
import co.com.claro.www.workflow.TrackingIDAndProcessID;

public class ConsultaSoapUtil {

	public ConsultaSoapUtil() {
		super();
	}
	public int ConsultarApId(String url_speed_test, String findId) {
		int response= 0;
		try {
			ManageAPSearchingSoapProxy prx = new ManageAPSearchingSoapProxy(url_speed_test);
			SearchAPByTextResult apByTextResult;
			apByTextResult = prx.searchAPByText(findId, 50);
			response = apByTextResult.getAPFound()[0].getAp_id();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
	}
	public CallSpeedTestVO llamar_speed_test(String url_speed_test,String mail_speed_test,String ap_id) {
		CallSpeedTestVO callSpeedTestVo = null;
		//RunSpeedTestOnDemandWorkflowSoapProxy workflowSoapProxy = new RunSpeedTestOnDemandWorkflowSoapProxy(url_speed_test);
		int apid = Integer.parseInt(ap_id);
		int APListIDs[] = {apid};
		callSpeedTestVo = new CallSpeedTestVO(ap_id,"TMP01","registro");
	//	TrackingIDAndProcessID processID;
//		try {
//			processID = workflowSoapProxy.executeAndReturnPID(APListIDs, mail_speed_test);
//			callSpeedTestVo = new CallSpeedTestVO(ap_id,processID.getProcessID(),"registro");
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return callSpeedTestVo;
	}
	
	

}
