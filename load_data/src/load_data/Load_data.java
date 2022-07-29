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
import java.text.NumberFormat;
import java.util.Properties;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.json.simple.JSONArray;

import org.apache.oltu.oauth2.client.OAuthClient;
import org.apache.oltu.oauth2.client.URLConnectionClient;
import org.apache.oltu.oauth2.client.request.OAuthClientRequest;
import org.apache.oltu.oauth2.client.response.OAuthJSONAccessTokenResponse;
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.apache.oltu.oauth2.common.message.types.GrantType;


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
        Properties prop=null;
        try {
            prop = Utilidades.readPropertiesFile("resources/MinticAutogestion.properties");
            System.out.println("Prop: "+ prop.getProperty("PATH_FILES"));
        } catch (IOException ex) {
            System.out.println("No cargo");
            Logger.getLogger(Load_data.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(0);
        }
        try
        {
            ruta_carga = prop.getProperty("PATH_FILES");
            Load_data load_data = new Load_data();
            Connection con = Utilidades.getConection(prop.getProperty("DB_STR_CONNECTION"), prop.getProperty("DB_USER"), prop.getProperty("DB_PWD"));
            load_data.load_generador_scripts(ruta_carga+"//Generador de Script Mintic.xlsm",con);
            load_data.load_consolidado(ruta_carga+"//CONSOLIDADO.xlsx",con);
            String[] tokens  =  load_data.generar_tokens(prop.getProperty("PATH_TOKENS"),prop.getProperty("SCRIPT_TOKENS"));           
            load_data.actualizar_ap(tokens[1],prop.getProperty("URL_AP1_LST"),1,con);
            load_data.actualizar_ap(tokens[2],prop.getProperty("URL_AP2_LST"),2,con);
            load_data.actualizar_aps(con);
            /*Se ajusta temporalmente mientra se resuelve la conexion al servidor*/
            load_data.actualizar_rs_file(prop.getProperty("PATH_FILES")+"//cnMaestro-device.xlsx" ,con);
            Connection con_resp = Utilidades.getConection(prop.getProperty("DB_RESP_STR_CONNECTION"), prop.getProperty("DB_RESP_USER"), prop.getProperty("DB_RESP_PWD"));
            load_data.actualizar_responsables(con_resp, con);
            con_resp.close();
            con.close();
            System.out.println("---- Fin --- ");
        }
        catch(SQLException ex)
        {
            Logger.getLogger(Load_data.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void load_generador_scripts(String ruta,Connection connection){
        FileInputStream fis = null;
        System.out.println("Cargando archivo generador de Script "+ ruta);
        int batch_size = 20;
        int counter = 0;
        try {
            File myFile = new File(ruta);
            if(myFile.exists()){
                fis = new FileInputStream(myFile);
                XSSFWorkbook myWorkBook = new XSSFWorkbook (fis);
                XSSFSheet mySheet = myWorkBook.getSheetAt(0);
                Iterator<Row> rowIterator = mySheet.iterator();                
                String sql ="DELETE FROM generador_scripts";
                PreparedStatement statement = connection.prepareStatement(sql); 
                statement.execute();
                sql = "INSERT INTO generador_scripts(id_mintic,id_beneficiario,ot,codigo_servicio,llave,nombre_municipio,coddanemuni,nombre_departamento,coddanedepar,nombre_centro_pob,coddaneinstitucionedu,matricula,bw_down_kbps,bw_up_kbps,total_bw,latitud,longitud,red,ip_ether1,mask_ether1,pe_wan,vlan_ether1,ip_ether2,mask_ether2,red_indoor,ip_indoor,mask_ether3,vlan_ether3,pcs_pool_1,ip_outdoor1,ip_outdoor2,mask_ether4_5,vlan_ether4_5,pcs_pool_2,bts_estación_base,tipo_equipo,equipo_ipran,puerto,pe_capa_3,interfaz_pe_capa_3,new_bst,tipo_equipo2,new_equipo_,new_pto,capa_3,interfaz,rediseño,rediseño2,cambios,obs_general,grupo,fecha_reconfigurar,vlan_wan,aliado_confi,nombre_ing_confi,fecha_config,estado_config,fecha_visita_s_o,estado_sharepoint,new_pem_aliado,proveedor_um_tercero,aliado_campo,pim_,pim_contacto,nombre_pem,hora_inicio,hora_fin,ultra_causa_no_exitosa,justificacion_estado_pem,fecha_pem,estado_pem,backup_fw_ingenio,pem_estado_calidad,sistema_electrico,kill_,prueba_de_aislamineto_banda_ku,tecnologia,nombre_ing_de_soporte,hora_inicio_mig,hora_fin_mig,ultra_causa_mig,justificacion_estado_migracion,fecha_migracion,estado_migracion,nombre_ing_sop,hora_inicio_sop,hora_fin_sop,justificacion_estado_sop,fecha_sop,estado_soporte_s_o,nombre_ing_de_pruebas,hora_inicio_prueba,hora_fin_pruebas,justificacion_estado_pruebas,fecha_pruebas,estado_pruebas,nombre_ing_de_mtto,hora_inicio_mtto,hora_fin_mtto,ultra_causa_mtto,justificacion_estado_mtto,fecha_mtto,estado_mtto)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
                statement = connection.prepareStatement(sql); 
                rowIterator.next(); 
                rowIterator.next(); 
                rowIterator.next();
                rowIterator.next();
                rowIterator.next();
                while (rowIterator.hasNext()) {
                    Row row = rowIterator.next();
                    for(int contador_fld=1;contador_fld<=103;contador_fld++){
                        if(row.getCell(contador_fld) != null ){
                            switch (row.getCell(contador_fld).getCellTypeEnum()){
                                case BLANK:
                                    statement.setNull(contador_fld, java.sql.Types.NULL);
                                    break;
                                case STRING:
                                    statement.setString(contador_fld, row.getCell(contador_fld).getStringCellValue());
                                    break;
                                case NUMERIC:
                                    NumberFormat nf = NumberFormat.getNumberInstance();
                                    nf.setMaximumFractionDigits(0);
                                    String rounded = nf.format(row.getCell(contador_fld).getNumericCellValue());
                                    rounded = rounded.replace(".", "");
                                    statement.setString(contador_fld,rounded);
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
                fis.close();
                myFile.delete();
                sql = "CALL sp_update_generador_scripts();";
                statement = connection.prepareStatement(sql); 
                statement.execute();
            }
            else{
                System.out.println("No exite el archivo: "+ ruta);
            }
            
            
        } 
        catch (FileNotFoundException ex) {
            Logger.getLogger(Load_data.class.getName()).log(Level.SEVERE, null, ex);        
        } catch (IOException | SQLException ex) {
            Logger.getLogger(Load_data.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }
    }
    public void load_consolidado(String ruta,Connection connection){
        FileInputStream fis = null;
        System.out.println("Cargando Consolidado: " + ruta);
        int batch_size = 20;
        int counter = 0;
        try {
            File myFile = new File(ruta);
            if(myFile.exists()){
                String sql = "DELETE FROM consolidado;";
                PreparedStatement statement = connection.prepareStatement(sql); 
                statement.execute();
                fis = new FileInputStream(myFile);
                XSSFWorkbook myWorkBook = new XSSFWorkbook (fis);
                XSSFSheet mySheet = myWorkBook.getSheet("Unificados");
                Iterator<Row> rowIterator = mySheet.iterator();

                sql = "INSERT INTO mintic.consolidado(id_unificado,nombre_sede,bts_original,equipo_acceso_original,puerto_original,bts_diseno_mw,equipo_acceso,puerto_1,ip_red,conectante,nemonico,referencia,slot,puerto_2,sitio_a,sitio_b,gateway,vlan,mask,ip_sitio_a_local_bts,ip_sitio_b_remoto_cd,gestion_switch_cambium,5_equipo_alu_origen_servicio,3_sap_id_origen_7705,6_nombre_de_interfaz_en_7750,8_ip_de_interfaz_en_7750,fase,cierre_um,id_beneficiario,estado_operación,comentarios,archivo,filtro_temp2)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
                statement = connection.prepareStatement(sql); 
                rowIterator.next();
                rowIterator.next();
                int contador_xls;
                System.out.println("Inicio Cargue");
                while (rowIterator.hasNext()) {
                    Row row = rowIterator.next();
                    for(int contador_fld=1;contador_fld<=33;contador_fld++){
                        contador_xls = contador_fld -1;
                        if(row.getCell(contador_xls) != null ){
                            switch (row.getCell(contador_xls).getCellTypeEnum()){
                                case BLANK:
                                    statement.setNull(contador_fld, java.sql.Types.NULL);
                                    break;
                                case STRING:
                                    statement.setString(contador_fld, row.getCell(contador_xls).getStringCellValue());
                                    break;
                                case NUMERIC:
                                    NumberFormat nf = NumberFormat.getNumberInstance();
                                    nf.setMaximumFractionDigits(0);
                                    String rounded = nf.format(row.getCell(contador_xls).getNumericCellValue());
                                    rounded = rounded.replace(".", "");
                                    statement.setString(contador_fld,rounded);
                                    break;                                    
                                case BOOLEAN:
                                    statement.setString(contador_fld, "");
                                    break;
                                default:
                                    statement.setString(contador_fld, "");
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
                fis.close();
                myFile.delete();          
                sql = "CALL sp_update_consolidado();";
                statement = connection.prepareStatement(sql); 
                statement.execute();
                
            }
            else{
                System.out.println("No existe el archivo:" +ruta );
            }
            
        } 
        catch (FileNotFoundException ex) {
            Logger.getLogger(Load_data.class.getName()).log(Level.SEVERE, null, ex);        
        } catch (IOException | SQLException ex) {
            Logger.getLogger(Load_data.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        } 
    }
    public String[]  generar_tokens(String ruta,String callPy){
        BufferedReader br = null;
        boolean no_es_vigente = false;
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
                System.out.println("Min:"+minutes);
                if(minutes > 50){
                    System.out.println("Recargo:"+callPy);
                    Process p = Runtime.getRuntime().exec(callPy);
                    System.out.println("Llama");
                }
                else{
                    System.out.println("Fin Break");
                    break;
                }
            }
            
            return tokens;
            
        } catch (IOException ex) {
            Logger.getLogger(Load_data.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
    }
    public String[]  read_tokens_file(String ruta){
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
     * @param connection_resp
     * @param connection 
     */
    public void actualizar_responsables(Connection connection_resp,Connection connection)
    {
        try {
            String sql = "DELETE FROM responsable;";
            PreparedStatement statement = connection.prepareStatement(sql); 
            statement.execute();
            Statement stmt = connection_resp.createStatement();
            sql = "SELECT ID_BENEFICIO,CONTACTO_RECTOR,TEL_RECTOR,CORREO_ELEC FROM mintic_rectores_escuelas;";
            ResultSet rsResp = stmt.executeQuery(sql);
            String sqlInsert = "";
            while (rsResp.next()) {
                sqlInsert  = "insert into responsable(id_beneficiario,name_resp,phone,email) ";
                sqlInsert  +=" select id_beneficiario,'"+rsResp.getString(2)+"' as Nombre,'"+rsResp.getString(3)+"' as telefono,'"+rsResp.getString(4)+"' as correo from centro_digital where id_beneficiario = '"+rsResp.getString(1)+"';";
                statement = connection.prepareStatement(sqlInsert); 
                statement.execute();
            }            
        } catch (SQLException ex) {
            Logger.getLogger(Load_data.class.getName()).log(Level.SEVERE, null, ex);            
        }
    }
    public void actualizar_rs_file(String rutaFile,Connection connection){
        System.out.println("Procesando:"+rutaFile);
        try {
            
            File myFile = new File(rutaFile);
            if(myFile.exists()){
                FileInputStream fis = new FileInputStream(myFile);
                XSSFWorkbook myWorkBook = new XSSFWorkbook (fis);
                XSSFSheet mySheet = myWorkBook.getSheetAt(0);
                Iterator<Row> rowIterator = mySheet.iterator();                
                String sql ="DELETE FROM tmp_rd_sw";
                PreparedStatement statement = connection.prepareStatement(sql); 
                statement.execute();
                sql = "INSERT INTO mintic.tmp_rd_sw(managed_account,mac,device_name,ip_address,ipv6_address,device_type,serial_number,description,active_sw_version,duration,status,status_time,status_time_seconds,height)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
                rowIterator.next();
                while (rowIterator.hasNext()) {
                    Row row = rowIterator.next();
                    statement = connection.prepareStatement(sql); 
                    for(int contador_fld=0;contador_fld<=13;contador_fld++){
                        if(row.getCell(contador_fld) != null ){
                            switch (row.getCell(contador_fld).getCellTypeEnum()){
                                case BLANK:
                                    statement.setNull(contador_fld+1, java.sql.Types.NULL);
                                    break;
                                case STRING:
                                    statement.setString(contador_fld+1, row.getCell(contador_fld).getStringCellValue());
                                    break;
                                case NUMERIC:
                                    NumberFormat nf = NumberFormat.getNumberInstance();
                                    nf.setMaximumFractionDigits(0);
                                    String rounded = nf.format(row.getCell(contador_fld).getNumericCellValue());
                                    rounded = rounded.replace(".", "");
                                    statement.setString(contador_fld+1,rounded);
                                    break;                                    
                                case BOOLEAN:
                                    statement.setString(contador_fld+1, "");
                                    break;
                                default:
                                    statement.setString(contador_fld+1, "");
                                    break;
                           }
                        }
                        else{
                            statement.setString(contador_fld+1, "");
                        }
                    }
                    statement.execute();
                }
                myWorkBook.close();
                fis.close();
                myFile.delete();          
                sql = "CALL sp_update_sw_rs();";
                statement = connection.prepareStatement(sql); 
                statement.execute();
            }
            else{
                System.out.println("No exite el archivo"+ rutaFile);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Load_data.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | SQLException ex) {
            Logger.getLogger(Load_data.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void actualizar_rs(String token,String url_api,Connection connection){
    	URL url;
        int batch_size = 20;
        int counter = 0;
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
            StringBuilder jsonResponseData = new StringBuilder();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(http.getInputStream()));
            while ((readLine = bufferedReader.readLine()) != null) {
                jsonResponseData.append(readLine).append("\n");
            }
            bufferedReader.close();
            JSONParser parser = new JSONParser();  
            String data = jsonResponseData.toString();
            JSONObject json = (JSONObject) parser.parse(data); 
            JSONArray data_js =(JSONArray) json.get("data");
            Iterator<JSONObject> iterator = data_js.iterator();
            String sql = "DELETE FROM tmp_rs;";
            PreparedStatement statement = connection.prepareStatement(sql); 
            statement.execute();
            sql = "INSERT INTO mintic.tmp_rs(name_rs,ip,network,product,type,mac,mode,tower,status) VALUES(?,?,?,?,?,?,?,?,?);";
            statement = connection.prepareStatement(sql); 
            int contador = 0;
            while (iterator.hasNext()) {
                try{
                    sql = "INSERT INTO mintic.tmp_rs(name_rs,ip,network,product,type,mac,mode,tower,status,description) VALUES(?,?,?,?,?,?,?,?,?,?);";
                    statement = connection.prepareStatement(sql); 
                    JSONObject jsChildObj = iterator.next();
                    statement.setString(1, (jsChildObj.get("name") != null)? jsChildObj.get("name").toString():"");
                    statement.setString(2, (jsChildObj.get("ip") != null)? jsChildObj.get("ip").toString():"");
                    statement.setString(3, (jsChildObj.get("network") != null)? jsChildObj.get("network").toString():"");
                    statement.setString(4, (jsChildObj.get("product") != null)? jsChildObj.get("product").toString():"");
                    statement.setString(5, (jsChildObj.get("type") != null)? jsChildObj.get("type").toString():"");
                    statement.setString(6, (jsChildObj.get("mac") != null)? jsChildObj.get("mac").toString():"");
                    statement.setString(7, (jsChildObj.get("mode") != null)? jsChildObj.get("mode").toString():"");
                    statement.setString(8, (jsChildObj.get("tower") != null)? jsChildObj.get("tower").toString():"");
                    statement.setString(9, (jsChildObj.get("status") != null)? jsChildObj.get("status").toString():"");
                    statement.setString(10, (jsChildObj.get("description") != null)? jsChildObj.get("description").toString():"");
                    statement.execute();
                    System.out.print( contador+"Desc[");
                    System.out.print((jsChildObj.get("description") != null)? jsChildObj.get("description").toString():"?");
                    System.out.print( contador+"]:");
                    System.out.println( jsChildObj.get("name"));
                    contador++;
                }
                catch(Exception ex ){
                    System.out.println(ex);
                    break;
                }
            }            
            http.disconnect();			
        } catch (MalformedURLException | ProtocolException ex) {
            Logger.getLogger(Load_data.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        } catch (IOException | NoSuchAlgorithmException | KeyManagementException ex) {
            Logger.getLogger(Load_data.class.getName()).log(Level.SEVERE, null, ex);
                // TODO Auto-generated catch block
            System.out.println(ex);
        } catch (ParseException ex) {
            Logger.getLogger(Load_data.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Load_data.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public String getToken(String url_api)
    {
    	String token="";
        try {
            String TOKEN_REQUEST_URL = "https://prycnmap1.claro.net.co/api/v2/access/token";
            String CLIENT_ID = "BCpnQMEtTg7jh6Lz";
            String CLIENT_SECRET =    "tna3EXrimdsKHoqPYPS8DIO8xx68UY";            
            OAuthClient client = new OAuthClient(new URLConnectionClient());

            OAuthClientRequest request =
                    OAuthClientRequest.tokenLocation(TOKEN_REQUEST_URL)
                    .setGrantType(GrantType.CLIENT_CREDENTIALS)
                    .setClientId(CLIENT_ID)
                    .setClientSecret(CLIENT_SECRET)
                    // .setScope() here if you want to set the token scope
                    .buildQueryMessage();

            token = client.accessToken(request, OAuthJSONAccessTokenResponse.class)
                    .getAccessToken();
            System.out.println("Tk:" + token );
        } catch (OAuthSystemException ex) { 
            Logger.getLogger(Load_data.class.getName()).log(Level.SEVERE, null, ex);
        } catch (OAuthProblemException ex) {
            Logger.getLogger(Load_data.class.getName()).log(Level.SEVERE, null, ex);
        }
        return token;
    }
    public void actualizar_aps(Connection connection){
        try {
            String sql = "CALL  sp_update_ap();";
            PreparedStatement statement = connection.prepareStatement(sql); 
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Load_data.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void actualizar_rss(Connection connection){
        try {
            String sql = "CALL  sp_update_rs();";
            PreparedStatement statement = connection.prepareStatement(sql); 
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Load_data.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    
    
    public void actualizar_ap(String token,String url_api,int server_data,Connection connection)
    {
    	URL url;
        int batch_size = 20;
        int counter = 0;
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
            JSONArray data_js =(JSONArray) json.get("data");
            Iterator<JSONObject> iterator = data_js.iterator();
            String sql = "DELETE FROM  tmp_access_point WHERE server_data = ? ;";
            PreparedStatement statement = connection.prepareStatement(sql); 
            statement.setInt(1, server_data);
            statement.execute();
            sql = "INSERT INTO tmp_access_point(description_ap,name_ap,ip_ap,network,product,msn,site,mac,parent_mac,site_id,server_data) VALUES(?,?,?,?,?,?,?,?,?,?,?);";
            statement = connection.prepareStatement(sql); 
            int size_batch = 20;
            int contador = 0;
            while (iterator.hasNext()) {
                try{
                    JSONObject jsChildObj = iterator.next();
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
                    statement.setInt(11,server_data);
                    statement.addBatch();
                    contador++;
                }
                catch(SQLException ex ){
                    System.out.println(ex);
                }
                if(contador % size_batch == 0){
                    statement.executeBatch();
                }
            }            
            statement.executeBatch();            
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
