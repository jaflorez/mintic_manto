package com.claro.WSMinticAutogestion.util;

import com.claro.WSMinticAutogestion.json.AccessPoint;
import com.claro.WSMinticAutogestion.json.Coneccion_rt;
import com.claro.WSMinticAutogestion.json.Interfaces_rt;
import com.claro.WSMinticAutogestion.json.Radio;
import com.claro.WSMinticAutogestion.json.Router_mk;
import com.claro.WSMinticAutogestion.json.Switch_bts;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.security.cert.X509Certificate;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;



public class ConsultaRestUtil {

	public ConsultaRestUtil() {
		
	}

    public String[]  generar_tokens(String ruta,String callPy){
        try {
            String[] tokens;
            while(true){
                tokens = read_tokens_file(ruta);
                String[] fech = tokens[3].split("T");
                String dateTime = fech[0] + ' ' + fech[1];
                Timestamp timestamp1 = Timestamp.valueOf(dateTime);
                java.util.Date date = new java.util.Date();
                Timestamp timestamp2 = new Timestamp(date.getTime());                
                long minutes = ((timestamp2.getTime() - timestamp1.getTime()) / 1000)  / 60;
                if(minutes > 50){
                    Process p = Runtime.getRuntime().exec(callPy);
                    p.waitFor();
                    Thread.sleep(1000);
                }
                else{
                    break;
                }
            }
            return tokens;
        } catch (IOException ex) {
            Logger.getLogger(ConsultaRestUtil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;
        
    }
	
    private String[]  read_tokens_file(String ruta){
        BufferedReader br = null;
        String[] tokens = null;
        try {
            String file_token = ruta;
            br = new BufferedReader(new FileReader(file_token));
            String st;
            while ((st = br.readLine()) != null){
                tokens = st.split(",");
            }
            return tokens;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ConsultaRestUtil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ConsultaRestUtil.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(ConsultaRestUtil.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return tokens;
    }
    
    public Radio consultar_rd_cd(String url_p,String mac,String token) {
    	Radio radio = null;
		String url_api = url_p.replace("[MAC]", mac);
    	URL url;
        try {
            TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager(){
                public X509Certificate[] getAcceptedIssuers(){return null;}
                public void checkClientTrusted(X509Certificate[] certs, String authType){}
                public void checkServerTrusted(X509Certificate[] certs, String authType){}
            }};
            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
            HostnameVerifier hv = new HostnameVerifier() {
                public boolean verify(String urlHostName, SSLSession session) {
                    if (!urlHostName.equalsIgnoreCase(session.getPeerHost())) {
                        System.out.println("Warning: URL host '" + urlHostName + "' is different to SSLSession host '" + session.getPeerHost() + "'.");
                    }
                    return true;
                }
            };
            HttpsURLConnection.setDefaultHostnameVerifier(hv);
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
            url = new URL(url_api);
            HttpsURLConnection http = (HttpsURLConnection)url.openConnection();
            http.setRequestProperty("Accept", "application/json");
            http.setRequestMethod("GET");
            http.setRequestProperty("Authorization", "Bearer "+token);
            http.setUseCaches(false);
            http.connect();
            String readLine = null;
            StringBuffer jsonResponseData = new StringBuffer();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(http.getInputStream()));
            while ((readLine = bufferedReader.readLine()) != null) {
                    jsonResponseData.append(readLine + "\n");
            }
            bufferedReader.close();
            JSONParser parser = new JSONParser();  
            String data = jsonResponseData.toString();
            JSONObject json = (JSONObject) parser.parse(data);
            JSONArray data_js_arr =(JSONArray) json.get("data");
            JSONObject jsCld = (JSONObject) data_js_arr.get(0);
            JSONObject jsRadio =(JSONObject) jsCld.get("radio");
            radio = new Radio();
            radio.setMac(mac);
            radio.setAp_mac(jsCld.get("ap_mac").toString());
            radio.setLan_mode_status(jsCld.get("lan_mode_status").toString());            
            radio.setLan_speed_status(jsCld.get("lan_speed_status").toString());
            radio.setTower(jsCld.get("tower").toString());
            radio.setLan_mode_status(jsCld.get("status").toString());
            radio.setDl_rssi(jsRadio.get("dl_rssi").toString());
            radio.setDl_snr(jsRadio.get("dl_snr").toString());
            radio.setStatus(jsCld.get("status").toString());
            http.disconnect();			
            
        } catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (KeyManagementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			
		}
		return radio;
    }
    
    public Switch_bts consultar_switch_bts(String url_p,String mac,String token) {
    	Switch_bts  switch_bts = null;
		String url_api = url_p.replace("[MAC]", mac);
    	URL url;
        try {
            TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager(){
                public X509Certificate[] getAcceptedIssuers(){return null;}
                public void checkClientTrusted(X509Certificate[] certs, String authType){}
                public void checkServerTrusted(X509Certificate[] certs, String authType){}
            }};
            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
            HostnameVerifier hv = new HostnameVerifier() {
                public boolean verify(String urlHostName, SSLSession session) {
                    if (!urlHostName.equalsIgnoreCase(session.getPeerHost())) {
                        System.out.println("Warning: URL host '" + urlHostName + "' is different to SSLSession host '" + session.getPeerHost() + "'.");
                    }
                    return true;
                }
            };
            HttpsURLConnection.setDefaultHostnameVerifier(hv);
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
            url = new URL(url_api);
            HttpsURLConnection http = (HttpsURLConnection)url.openConnection();
            http.setRequestProperty("Accept", "application/json");
            http.setRequestMethod("GET");
            http.setRequestProperty("Authorization", "Bearer "+token);
            http.setUseCaches(false);
            http.connect();
            String readLine = null;
            StringBuffer jsonResponseData = new StringBuffer();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(http.getInputStream()));
            while ((readLine = bufferedReader.readLine()) != null) {
                    jsonResponseData.append(readLine + "\n");
            }
            bufferedReader.close();
            JSONParser parser = new JSONParser();  
            String data = jsonResponseData.toString();
            JSONObject json = (JSONObject) parser.parse(data);            
            JSONArray data_js_arr =(JSONArray) json.get("data");
            JSONObject jsCld = (JSONObject) data_js_arr.get(0);
            switch_bts = new Switch_bts();
            switch_bts.setMac(mac);
            switch_bts.setIp(jsCld.get("ip").toString());
            switch_bts.setStatus(jsCld.get("status").toString());
            switch_bts.setTower(jsCld.get("tower").toString());
            switch_bts.setName_sw(jsCld.get("name").toString());
            switch_bts.setLan_speed_status(jsCld.get("lan_speed_status").toString());
            switch_bts.setLan_mode_status(jsCld.get("lan_mode_status").toString());
            http.disconnect();			
            
        } catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (KeyManagementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			
		}
		return switch_bts;
    	
    	
    }
    
    public List<Coneccion_rt> consultar_router_conecciones(String urlApi,String ip,String usr,String psw) {
        String usernameColonPassword = usr+ ":" + psw;
        String urlApiIPN = urlApi.replace("[IP]", ip);
        BufferedReader httpResponseReader = null;
        List<Coneccion_rt>  listaCR = new ArrayList<>();        
        try {
        	String basicAuthPayload = "Basic " + Base64.getEncoder().encodeToString(usernameColonPassword.getBytes());
            TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager(){
                public X509Certificate[] getAcceptedIssuers(){return null;}
                public void checkClientTrusted(X509Certificate[] certs, String authType){}
                public void checkServerTrusted(X509Certificate[] certs, String authType){}
            }};
            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
            HostnameVerifier hv = new HostnameVerifier() {
                public boolean verify(String urlHostName, SSLSession session) {
                    if (!urlHostName.equalsIgnoreCase(session.getPeerHost())) {
                        System.out.println("Warning: URL host '" + urlHostName + "' is different to SSLSession host '" + session.getPeerHost() + "'.");
                    }
                    return true;
                }
            };
            HttpsURLConnection.setDefaultHostnameVerifier(hv);
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
            URL serverUrl = new URL(urlApiIPN);
            HttpURLConnection urlConnection = (HttpURLConnection) serverUrl.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.addRequestProperty("Authorization", basicAuthPayload);
            httpResponseReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String readLine;
            StringBuffer jsonResponseData = new StringBuffer();
            while((readLine = httpResponseReader.readLine()) != null) {
            	jsonResponseData.append(readLine + "\n");
            }
            httpResponseReader.close();
            String data = jsonResponseData.toString();
            JSONParser parser=new JSONParser();
            Object obj = parser.parse(data);
            JSONArray jsonArr = (JSONArray)obj;
            Coneccion_rt coneccion_rt;
            
            for (int i = 0; i < jsonArr.size(); i++) {
                JSONObject jsonObj = (JSONObject) jsonArr.get(i);
                try {
                    coneccion_rt = new Coneccion_rt();
                    coneccion_rt.setFull_duplex(jsonObj.get("full-duplex").toString());
                    coneccion_rt.setName(jsonObj.get("name").toString());
                    coneccion_rt.setRunning(jsonObj.get("running").toString());
                    coneccion_rt.setRx_fcs_error(jsonObj.get("rx-fcs-error").toString());
                    coneccion_rt.setSpeed(jsonObj.get("speed").toString());
                    listaCR.add(coneccion_rt);
				} catch (Exception e) {
					System.out.println(e);
		            Logger.getLogger(ConsultaRestUtil.class.getName()).log(Level.SEVERE, null, e);
				}
                
            }
            return listaCR;
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(ConsultaRestUtil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (KeyManagementException ex) {
            Logger.getLogger(ConsultaRestUtil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
            if (httpResponseReader != null) {
                try {
                    httpResponseReader.close();
                } catch (IOException ioe) {
                }
            }
        }
    	
    	return listaCR;
    }
    
    public List<Interfaces_rt> consultar_router_interfaces(String urlApi,String ip,String usr,String psw) {
        String usernameColonPassword = usr+ ":" + psw;
        String urlApiIPN = urlApi.replace("[IP]", ip);
        BufferedReader httpResponseReader = null;
        List<Interfaces_rt>  listaIR = new ArrayList<>();        
        try {
        	String basicAuthPayload = "Basic " + Base64.getEncoder().encodeToString(usernameColonPassword.getBytes());
            TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager(){
                public X509Certificate[] getAcceptedIssuers(){return null;}
                public void checkClientTrusted(X509Certificate[] certs, String authType){}
                public void checkServerTrusted(X509Certificate[] certs, String authType){}
            }};
            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
            HostnameVerifier hv = new HostnameVerifier() {
                public boolean verify(String urlHostName, SSLSession session) {
                    if (!urlHostName.equalsIgnoreCase(session.getPeerHost())) {
                        System.out.println("Warning: URL host '" + urlHostName + "' is different to SSLSession host '" + session.getPeerHost() + "'.");
                    }
                    return true;
                }
            };
            HttpsURLConnection.setDefaultHostnameVerifier(hv);
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
            URL serverUrl = new URL(urlApiIPN);
            HttpURLConnection urlConnection = (HttpURLConnection) serverUrl.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.addRequestProperty("Authorization", basicAuthPayload);
            httpResponseReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String readLine;
            StringBuffer jsonResponseData = new StringBuffer();
            while((readLine = httpResponseReader.readLine()) != null) {
            	jsonResponseData.append(readLine + "\n");
            }
            httpResponseReader.close();
            String data = jsonResponseData.toString();
            JSONParser parser=new JSONParser();
            Object obj = parser.parse(data);
            JSONArray jsonArr = (JSONArray)obj;
            Interfaces_rt interfaces_rt;
            for (int i = 0; i < jsonArr.size(); i++) {
                JSONObject jsonObj = (JSONObject) jsonArr.get(i);
                interfaces_rt = new Interfaces_rt(jsonObj.get("address").toString(), jsonObj.get("interface").toString(), jsonObj.get("network").toString());
                listaIR.add(interfaces_rt);
            }
            return listaIR;
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(ConsultaRestUtil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (KeyManagementException ex) {
            Logger.getLogger(ConsultaRestUtil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
            if (httpResponseReader != null) {
                try {
                    httpResponseReader.close();
                } catch (IOException ioe) {
                }
            }
        }
    	
    	return listaIR;
    }
    
    public Router_mk consultar_router_data() {
    	Router_mk mk = new Router_mk();
    	List<Interfaces_rt>  listaIR = new ArrayList<>();
    	Interfaces_rt i_rt1 = new Interfaces_rt();
    	i_rt1.setAddress("10.167.139.232/30");
    	i_rt1.setInterface_("vlan-WAN");
    	i_rt1.setNetwork_("10.167.139.232");
    	listaIR.add(i_rt1);
    	Interfaces_rt i_rt2 = new Interfaces_rt();
    	i_rt2.setAddress("10.167.139.232/30");
    	i_rt2.setInterface_("bridge_LAN");
    	i_rt2.setNetwork_("10.167.139.232");
    	listaIR.add(i_rt2);
    	mk.setInterfaces(listaIR);
    	List<Coneccion_rt>  listaCn = new ArrayList<>();
    	Coneccion_rt cn_rt_1 = new Coneccion_rt();
    	cn_rt_1.setFull_duplex("true");
    	cn_rt_1.setName("ether1-WAN");
    	cn_rt_1.setRunning("true");
    	cn_rt_1.setRx_fcs_error("0");
    	cn_rt_1.setSpeed("100Mbps");
    	listaCn.add(cn_rt_1);
    	Coneccion_rt cn_rt_2 = new Coneccion_rt();
    	cn_rt_2.setFull_duplex("true");
    	cn_rt_2.setName("ether1-WAN");
    	cn_rt_2.setRunning("true");
    	cn_rt_2.setRx_fcs_error("0");
    	cn_rt_2.setSpeed("100Mbps");
    	listaCn.add(cn_rt_2);
    	Coneccion_rt cn_rt_3 = new Coneccion_rt();
    	cn_rt_3.setFull_duplex("true");
    	cn_rt_3.setName("ether1-WAN");
    	cn_rt_3.setRunning("true");
    	cn_rt_3.setRx_fcs_error("0");
    	cn_rt_3.setSpeed("100Mbps");
    	listaCn.add(cn_rt_3);
    	Coneccion_rt cn_rt_4 = new Coneccion_rt();
    	cn_rt_4.setFull_duplex("true");
    	cn_rt_4.setName("ether1-WAN");
    	cn_rt_4.setRunning("true");
    	cn_rt_4.setRx_fcs_error("0");
    	cn_rt_4.setSpeed("100Mbps");
    	listaCn.add(cn_rt_4);
    	mk.setConectividad(listaCn);
    	return mk;
    }
    
    public Radio consultar_rd_bts(String url_p,String mac,String token) {
    	Radio radio = null;
		String url_api = url_p.replace("[MAC]", mac);
    	URL url;
        try {
            TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager(){
                public X509Certificate[] getAcceptedIssuers(){return null;}
                public void checkClientTrusted(X509Certificate[] certs, String authType){}
                public void checkServerTrusted(X509Certificate[] certs, String authType){}
            }};
            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
            HostnameVerifier hv = new HostnameVerifier() {
                public boolean verify(String urlHostName, SSLSession session) {
                    if (!urlHostName.equalsIgnoreCase(session.getPeerHost())) {
                        System.out.println("Warning: URL host '" + urlHostName + "' is different to SSLSession host '" + session.getPeerHost() + "'.");
                    }
                    return true;
                }
            };
            HttpsURLConnection.setDefaultHostnameVerifier(hv);
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
            url = new URL(url_api);
            HttpsURLConnection http = (HttpsURLConnection)url.openConnection();
            http.setRequestProperty("Accept", "application/json");
            http.setRequestMethod("GET");
            http.setRequestProperty("Authorization", "Bearer "+token);
            http.setUseCaches(false);
            http.connect();
            String readLine = null;
            StringBuffer jsonResponseData = new StringBuffer();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(http.getInputStream()));
            while ((readLine = bufferedReader.readLine()) != null) {
                    jsonResponseData.append(readLine + "\n");
            }
            bufferedReader.close();
            JSONParser parser = new JSONParser();  
            String data = jsonResponseData.toString();
            JSONObject json = (JSONObject) parser.parse(data);            
            JSONArray data_js_arr =(JSONArray) json.get("data");
            JSONObject jsCld = (JSONObject) data_js_arr.get(0);
            radio = new Radio();
            radio.setMac(mac);
            radio.setName(jsCld.get("name").toString());
            radio.setTower(jsCld.get("tower").toString());
            radio.setStatus(jsCld.get("status").toString());
            radio.setLan_mode_status(jsCld.get("lan_mode_status").toString());            
            radio.setLan_speed_status(jsCld.get("lan_speed_status").toString());
            http.disconnect();			
            
        } catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (KeyManagementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			
		}
		return radio;
    	
    	
    }
    
	public AccessPoint consultar_ap(String url_p,String mac,String token,String tipo) {
		
		AccessPoint accessPoint = null;
		String url_api = url_p.replace("[MAC]", mac);
    	URL url;
        try {
            TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager(){
                public X509Certificate[] getAcceptedIssuers(){return null;}
                public void checkClientTrusted(X509Certificate[] certs, String authType){}
                public void checkServerTrusted(X509Certificate[] certs, String authType){}
            }};
            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
            HostnameVerifier hv = new HostnameVerifier() {
                public boolean verify(String urlHostName, SSLSession session) {
                    if (!urlHostName.equalsIgnoreCase(session.getPeerHost())) {
                        System.out.println("Warning: URL host '" + urlHostName + "' is different to SSLSession host '" + session.getPeerHost() + "'.");
                    }
                    return true;
                }
            };
            HttpsURLConnection.setDefaultHostnameVerifier(hv);
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
            url = new URL(url_api);
            HttpsURLConnection http = (HttpsURLConnection)url.openConnection();
            http.setRequestProperty("Accept", "application/json");
            http.setRequestMethod("GET");
            http.setRequestProperty("Authorization", "Bearer "+token);
            http.setUseCaches(false);
            http.connect();
            String readLine = null;
            StringBuffer jsonResponseData = new StringBuffer();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(http.getInputStream()));
            while ((readLine = bufferedReader.readLine()) != null) {
                    jsonResponseData.append(readLine + "\n");
            }
            bufferedReader.close();
            JSONParser parser = new JSONParser();  
            String data = jsonResponseData.toString();
            JSONObject json = (JSONObject) parser.parse(data);
            JSONArray data_js_arr =(JSONArray) json.get("data");
            JSONObject jsCld = (JSONObject) data_js_arr.get(0);
            accessPoint = new AccessPoint();
            accessPoint.setSite(jsCld.get("site").toString());
            accessPoint.setName(jsCld.get("name").toString());
            accessPoint.setMac(mac);
            accessPoint.setStatus(jsCld.get("status").toString());
            accessPoint.setTipo(tipo);
            http.disconnect();			
        } catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (KeyManagementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			
		}
		return accessPoint;
	}

}
