/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package load_data;

import java.io.FileNotFoundException;
import java.io.FileReader;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.File;
import java.io.FileInputStream;

import java.sql.*;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;


import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.parser.ParseException;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.json.simple.JSONArray;



/**
 *
 * @author jaflo
 */
public class Load_data {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Saludo");
        String ruta_carga = ""; 
        JSONParser parser = new JSONParser();
        try
        {
            Object object = parser.parse(new FileReader("D:\\CLARO\\mintic\\Documentacion\\parametros.json"));
            JSONObject jsonObject = (JSONObject)object;
            ruta_carga = (String) jsonObject.get("ruta_carga");
            Load_data load_data = new Load_data();
//            load_data.load_generador_scripts(ruta_carga+"\\Generador de Script Mintic.xlsm");
 //           load_data.load_consolidado(ruta_carga+"\\CONSOLIDADO.xlsx");
            String[] tokens  =  load_data.generar_tokens();
         //   load_data.actualizar_ap(tokens[1],"https://prycnmap1.claro.net.co/api/v2/devices/?limit=0");
          //  load_data.actualizar_ap(tokens[2],"https://prycnmap2.claro.net.co/api/v2/devices/?limit=0");
            load_data.actualizar_rs(tokens[0],"https://prycnmrs1.claro.net.co/api/v2/devices/?limit=0");
            System.out.println("Fin");
        }
        catch(FileNotFoundException fe)
        {
            Logger.getLogger(Load_data.class.getName()).log(Level.SEVERE, null, fe);
        } catch (IOException | ParseException ex) {
            Logger.getLogger(Load_data.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void load_generador_scripts(String ruta){
        FileInputStream fis = null;
        System.out.println("RTa "+ ruta);
        String jdbcURL = "jdbc:mysql://localhost:3306/mintic_manto?useSSL=false";
        String username = "root";
        String password = "admin";
        int batch_size = 20;
        int counter = 0;
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(jdbcURL, username, password);
            System.out.println("Inicio 01");
            if (connection == null){
                return;
            }
            connection.setAutoCommit(false);
            File myFile = new File(ruta);
            fis = new FileInputStream(myFile);
            XSSFWorkbook myWorkBook = new XSSFWorkbook (fis);
            XSSFSheet mySheet = myWorkBook.getSheetAt(0);
            Iterator<Row> rowIterator = mySheet.iterator();
            String sql = "INSERT INTO mintic_manto.generador_scripts(id_mintic,id_beneficiario,ot,codigo_servicio,llave,nombre_municipio,coddanemuni,nombre_departamento,coddanedepar,nombre_centro_pob,coddaneinstitucionedu,matricula,bw_down_kbps,bw_up_kbps,total_bw,latitud,longitud,red,ip_ether1,mask_ether1,pe_wan,vlan_ether1,ip_ether2,mask_ether2,red_indoor,ip_indoor,mask_ether3,vlan_ether3,pcs_pool_1,ip_outdoor1,ip_outdoor2,mask_ether4_5,vlan_ether4_5,pcs_pool_2,bts_estacion_base,tipo_equipo,equipo_ipran,puerto,pe_capa_3,interfaz_pe_capa_3,cambios,obs_general,grupo,fecha_reconfigurar,vlan_wan,aliado_confi,nombre_ing_confi,fecha_config,estado_config,fecha_visita_s_o,estado_sharepoint,new_pem_aliado,proveedor_um_tercero,aliado_campo,pim_,pim_contacto,nombre_pem,hora_inicio,hora_fin,ultra_causa_no_exitosa,justificacion_estado_pem,fecha_pem,estado_pem,backup_fw_ingenio,pem_estado_calidad,sistema_electrico,kill_,prueba_de_aislamineto_banda_ku,tecnologia,nombre_ing_de_soporte,hora_inicio_mig,hora_fin_mig,ultra_causa_mig,justificacion_estado_migracion,fecha_migracion,estado_migracion,nombre_ing_sop,hora_inicio_sop,hora_fin_sop,justificacion_estado_sop,fecha_sop,estado_soporte_s_o,nombre_ing_de_pruebas,hora_inicio_prueba,hora_fin_pruebas,justificacion_estado_pruebas,fecha_pruebas,estado_pruebas,nombre_ing_de_mtto,hora_inicio_mtto,hora_fin_mtto,ultra_causa_mtto,justificacion_estado_mtto,fecha_mtto,estado_mtto) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
            PreparedStatement statement = connection.prepareStatement(sql); 
            rowIterator.next(); 
            rowIterator.next(); 
            rowIterator.next();
            rowIterator.next();
            rowIterator.next();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                for(int contador_fld=1;contador_fld<=95;contador_fld++){
                    if(row.getCell(contador_fld) != null ){
                        switch (row.getCell(contador_fld).getCellTypeEnum()){
                            case BLANK:
                                statement.setNull(contador_fld, java.sql.Types.NULL);
                                break;
                            case STRING:
                                statement.setString(contador_fld, row.getCell(contador_fld).getStringCellValue());
                                break;
                            case NUMERIC:
                                statement.setString(contador_fld,Double.toString(row.getCell(contador_fld).getNumericCellValue()));
                                break;
                            case BOOLEAN:
                                statement.setString(contador_fld, "Bool");
                                break;
                            default:
                                statement.setString(contador_fld, "str");
                                break;
                       }
                    }
                    else{
                        statement.setNull(contador_fld, java.sql.Types.NULL);
                    }
                }
                statement.addBatch();
                counter++;
                if(counter % batch_size == 0){
                    statement.executeBatch();
                }                
            }
            myWorkBook.close();
            statement.executeBatch();
            connection.commit();
            connection.close();            
            
        } 
        catch (FileNotFoundException ex) {
            Logger.getLogger(Load_data.class.getName()).log(Level.SEVERE, null, ex);        
        } catch (IOException | SQLException ex) {
            Logger.getLogger(Load_data.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        } finally {
            try {
                fis.close();
            } catch (IOException ex) {
                Logger.getLogger(Load_data.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public void load_consolidado(String ruta){
        FileInputStream fis = null;
        String jdbcURL = "jdbc:mysql://localhost:3306/mintic_manto?useSSL=false";
        String username = "root";
        String password = "admin";
        int batch_size = 20;
        int counter = 0;
        Connection connection = null;
        try {
            System.out.println("Inicio");
            connection = DriverManager.getConnection(jdbcURL, username, password);
            System.out.println("Inicio 01");
            if (connection == null){
                System.out.println("End");
                return;
            }
            connection.setAutoCommit(false);
            File myFile = new File(ruta);
            fis = new FileInputStream(myFile);
            XSSFWorkbook myWorkBook = new XSSFWorkbook (fis);
            System.out.println("Arc 03");
            XSSFSheet mySheet = myWorkBook.getSheetAt(0);
            Iterator<Row> rowIterator = mySheet.iterator();
            String sql = "INSERT INTO mintic_manto.consolidado(id_unificado,nombre_sede,bts_original,equipo_acceso_original,puerto_original,bts_diseno_mw,equipo_acceso,puerto_1,ip_red,conectante,nemonico,referencia,slot,puerto_2,sitio_a,sitio_b,gateway,vlan,mask,ip_sitio_a_local_bts,ip_sitio_b_remoto_cd,gestion_switch_cambium,5_equipo_alu_origen_servicio,3_sap_id_origen_7705,6_nombre_de_interfaz_en_7750,8_ip_de_interfaz_en_7750,fase,cierre_um,id_beneficiario,estado_operación,comentarios,archivo,filtro_temp2)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
            PreparedStatement statement = connection.prepareStatement(sql); 
            rowIterator.next(); 
            rowIterator.next(); 
            rowIterator.next();
            rowIterator.next();
            rowIterator.next();
            System.out.println("For");
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                for(int contador_fld=1;contador_fld<=33;contador_fld++){
                    System.out.print(contador_fld+":\t");
                    if(row.getCell(contador_fld) != null ){
                        System.out.print(row.getCell(contador_fld).getCellTypeEnum()+"\t");
                        switch (row.getCell(contador_fld).getCellTypeEnum()){
                            case BLANK:
                                System.out.print("blank:\t");
                                statement.setNull(contador_fld, java.sql.Types.NULL);
                                break;
                            case STRING:
                                statement.setString(contador_fld, row.getCell(contador_fld).getStringCellValue());
                                break;
                            case NUMERIC:
                                statement.setString(contador_fld,Double.toString(row.getCell(contador_fld).getNumericCellValue()));
                                break;
                            case BOOLEAN:
                                statement.setString(contador_fld, "Bool");
                                break;
                            default:
                                statement.setString(contador_fld, "str");
                                break;
                       }
                    }
                    else{
                        System.out.println("Nulo");
                        statement.setNull(contador_fld, java.sql.Types.NULL);
                    }
                }
                statement.addBatch();
                counter++;
                if(counter % batch_size == 0){
                    statement.executeBatch();
                }                
            }
            myWorkBook.close();
            statement.executeBatch();
            connection.commit();
            connection.close();            
            
        } 
        catch (FileNotFoundException ex) {
            Logger.getLogger(Load_data.class.getName()).log(Level.SEVERE, null, ex);        
        } catch (IOException | SQLException ex) {
            Logger.getLogger(Load_data.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        } finally {
            try {
                fis.close();
            } catch (IOException ex) {
                Logger.getLogger(Load_data.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public String[]  generar_tokens(){
        BufferedReader br = null;
        String[] tokens = null;
        try {
            String file_token = "D:\\CLARO\\mintic\\tokengenerator\\tokens\\tokens.txt";
            br = new BufferedReader(new FileReader(file_token));
            String st;
            while ((st = br.readLine()) != null){
                tokens = st.split(",");
            }
            return tokens;
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Load_data.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Load_data.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(Load_data.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return tokens;
    
    }
    /**
     * Funcion para actualizar los Tokens
     * @param tokes 
     */
    public void actualizar_rs(String token,String url_api){
    	URL url;
        String jdbcURL = "jdbc:mysql://localhost:3306/mintic_manto?useSSL=false";
        String username = "root";
        String password = "admin";
        int batch_size = 20;
        int counter = 0;
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(jdbcURL, username, password);

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
            System.err.println("Token : "+token);
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
            StringBuilder jsonResponseData = new StringBuilder();
            System.out.println(http.getResponseCode() );
            System.out.println(http.getResponseMessage());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(http.getInputStream()));
            while ((readLine = bufferedReader.readLine()) != null) {
                    jsonResponseData.append(readLine + "\n");
            }
            bufferedReader.close();
            JSONParser parser = new JSONParser();  
            String data = jsonResponseData.toString();
            JSONObject json = (JSONObject) parser.parse(data); 
            JSONArray data_js =(JSONArray) json.get("data");
            Iterator<JSONObject> iterator = data_js.iterator();
            String sql = "INSERT INTO mintic_manto.tmp_rs(description,name_rs,ip,network,product,type,site,mac,mode,parent_mac,status) VALUES(?,?,?,?,?,?,?,?,?,?,?);";
            PreparedStatement statement = connection.prepareStatement(sql); 
            int size_batch = 20;
            int contador = 0;
            while (iterator.hasNext()) {
                try{
                    JSONObject jsChildObj = iterator.next();
                    System.out.println(jsChildObj.get("name"));
                    statement.setString(1, (jsChildObj.get("description") != null)? jsChildObj.get("description").toString():"");
                    statement.setString(2,(jsChildObj.get("name") != null)? jsChildObj.get("name").toString():"");
                    statement.setString(3, (jsChildObj.get("ip") != null)? jsChildObj.get("ip").toString():"");
                    statement.setString(4, (jsChildObj.get("network") != null)? jsChildObj.get("network").toString():"");
                    statement.setString(5, (jsChildObj.get("product") != null)? jsChildObj.get("product").toString():"");
                    statement.setString(6, (jsChildObj.get("type") != null)? jsChildObj.get("product").toString():"");
                    statement.setString(7, (jsChildObj.get("site") != null)? jsChildObj.get("site").toString():"");
                    statement.setString(8, (jsChildObj.get("mac") != null)? jsChildObj.get("mac").toString():"");
                    statement.setString(9, (jsChildObj.get("mode") != null)? jsChildObj.get("msn").toString():"");
                    statement.setString(10, (jsChildObj.get("parent_mac") != null)? jsChildObj.get("parent_mac").toString():"");
                    statement.setString(11, (jsChildObj.get("status") != null)? jsChildObj.get("status").toString():"");
                    statement.addBatch();
                    contador++;
                }
                catch(Exception ex ){
                    System.out.println(ex);
                }
                if(contador % size_batch == 0){
                    statement.executeBatch();
                }
            }            
            statement.executeBatch();            
            connection.close();
            http.disconnect();			
        } catch (MalformedURLException | ProtocolException e) {
                // TODO Auto-generated catch block
                System.out.println(e);
        } catch (IOException | NoSuchAlgorithmException | KeyManagementException e) {
                // TODO Auto-generated catch block
                System.out.println(e);
                
        } catch (ParseException ex) {
            Logger.getLogger(Load_data.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Load_data.class.getName()).log(Level.SEVERE, null, ex);
        }


    }
    public void actualizar_ap(String token,String url_api)
    {
    	URL url;
        String jdbcURL = "jdbc:mysql://localhost:3306/mintic_manto?useSSL=false";
        String username = "root";
        String password = "admin";
        int batch_size = 20;
        int counter = 0;
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(jdbcURL, username, password);

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
            System.err.println(""+token);
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
            System.out.println(http.getResponseCode() );
            System.out.println(http.getResponseMessage());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(http.getInputStream()));
            while ((readLine = bufferedReader.readLine()) != null) {
                    jsonResponseData.append(readLine + "\n");
            }
            bufferedReader.close();
            JSONParser parser = new JSONParser();  
            String data = jsonResponseData.toString();
            JSONObject json = (JSONObject) parser.parse(data); 
            JSONArray data_js =(JSONArray) json.get("data");
            Iterator<JSONObject> iterator = data_js.iterator();
            String sql = "INSERT INTO mintic_manto.tmp_access_point(description_ap,name_ap,ip_ap,network,product,msn,site,mac,parent_mac,site_id) VALUES(?,?,?,?,?,?,?,?,?,?);";
            PreparedStatement statement = connection.prepareStatement(sql); 
            int size_batch = 20;
            int contador = 0;
            while (iterator.hasNext()) {
                try{
                    JSONObject jsChildObj = iterator.next();
                    System.out.println(  ((jsChildObj.get("name") != null) ? jsChildObj.get("name"):"*")+"\t" );
                    statement.setString(1, (jsChildObj.get("description") != null)? jsChildObj.get("description").toString():"");
                    statement.setString(2,(jsChildObj.get("name") != null)? jsChildObj.get("name").toString():"");
                    statement.setString(3, (jsChildObj.get("ip") != null)? jsChildObj.get("ip").toString():"");
                    statement.setString(4, (jsChildObj.get("network") != null)? jsChildObj.get("network").toString():"");
                    statement.setString(5, (jsChildObj.get("product") != null)? jsChildObj.get("product").toString():"");
                    statement.setString(6, (jsChildObj.get("msn") != null)? jsChildObj.get("msn").toString():"");
                    statement.setString(7, (jsChildObj.get("site") != null)? jsChildObj.get("site").toString():"");
                    statement.setString(8, (jsChildObj.get("mac") != null)? jsChildObj.get("mac").toString():"");
                    statement.setString(9, (jsChildObj.get("parent_mac") != null)? jsChildObj.get("parent_mac").toString():"");
                    statement.setString(10,(jsChildObj.get("site_id") != null)? jsChildObj.get("site_id").toString():"");
                    statement.addBatch();
                    contador++;
                }
                catch(Exception ex ){
                    System.out.println(ex);
                }
                if(contador % size_batch == 0){
                    statement.executeBatch();
                }
            }            
            statement.executeBatch();            
            connection.close();
            http.disconnect();			
        } catch (MalformedURLException | ProtocolException e) {
                // TODO Auto-generated catch block
                System.out.println(e);
        } catch (IOException | NoSuchAlgorithmException | KeyManagementException e) {
                // TODO Auto-generated catch block
                System.out.println(e);
                
        } catch (ParseException ex) {
            Logger.getLogger(Load_data.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Load_data.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
