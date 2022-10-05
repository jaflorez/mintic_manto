package load_data;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jaflo
 */
public class Utilidades {
    public static Properties readPropertiesFile(String fileName) throws IOException {
      FileInputStream fis = null;
      Properties prop = null;
      try {
         fis = new FileInputStream(fileName);
         prop = new Properties();
         prop.load(fis);
      } catch(FileNotFoundException ex) {
          Logger.getLogger(Load_data.class.getName()).log(Level.SEVERE, null, ex);
      } catch(IOException ex) {
          Logger.getLogger(Load_data.class.getName()).log(Level.SEVERE, null, ex);
      } finally {
         fis.close();
      }
      return prop;
   }
   public static Connection getConection(String jdbcURL,String username,String password) throws SQLException{
      Connection connection;
      connection = DriverManager.getConnection(jdbcURL, username, password);
      return connection;
   }
   public static String clean_string(String cadena){
       String result = cadena.trim();
       return "";
   
   }
    
}
