package com.claro.WSMinticAutogestion.util;

import com.claro.WSMinticAutogestion.json.AccessPoint;
import com.claro.WSMinticAutogestion.json.Radio;
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
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.security.cert.X509Certificate;
import java.sql.Timestamp;
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
                }
                else{
                    break;
                }
            }
            return tokens;
        } catch (IOException ex) {
            Logger.getLogger(ConsultaRestUtil.class.getName()).log(Level.SEVERE, null, ex);
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
            switch_bts.setIp(jsCld.get("ip").toString());
            switch_bts.setStatus(jsCld.get("status").toString());
            switch_bts.setTower(jsCld.get("tower").toString());
            switch_bts.setName_sw(jsCld.get("name").toString());
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
