package cl.comp.inspeccion.util;

public class Utils {

  public static String getProperty(String nombProperty) {
	try {
		LoadProperties props = LoadProperties.getInstance();
		
		return props.getProperty(nombProperty);
	} catch (Exception ie) {
		return "Error";
	}
  }
}
