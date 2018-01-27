package cl.comp.inspeccion.util;

import java.util.Properties;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LoadProperties extends Properties {

	private static final long serialVersionUID = -4119730776090535943L;
	private static Logger logger = Logger.getLogger(LoadProperties.class);
	private static LoadProperties instance;

  /**
   * Constructor de la clase singleton CargasProperties
 * @throws IOException 
   */
  public LoadProperties() throws IOException {
	super();
	InputStream fileStream;
	String fileProp = "";

	if (System.getProperty("catalina.home").indexOf(":\\") > 0) {
	  fileProp = System.getProperty("catalina.home") + "\\conf\\rentanacional.properties";
	} else {// Directorio UNIX
	  fileProp = System.getProperty("catalina.home") + "/conf/rentanacional.properties";
	}
	PropertyConfigurator.configure(fileProp);	
	
	try {
	  fileStream = new FileInputStream(fileProp);
	  load(fileStream);
	} catch (FileNotFoundException e) {
		logger.error("LoadProperties:"+e.getMessage());
	}
  }

  /**
   * metodo que retorna la instancia del objeto singleton
   * 
   * @return
 * @throws IOException 
   */
  public static synchronized LoadProperties getInstance() throws IOException {
	if (instance == null)
	  instance = new LoadProperties();
	return instance;
  }
}
