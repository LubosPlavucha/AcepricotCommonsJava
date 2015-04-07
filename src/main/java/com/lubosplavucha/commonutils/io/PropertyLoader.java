/**
 * 
 */
package com.lubosplavucha.commonutils.io;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * @author quixy
 *
 */
public abstract class PropertyLoader {

	
	private final static String SUFFIX = ".properties";
	private static boolean LOAD_AS_RESOURCE_BUNDLE = true;
	
	
	/**
	 * Loads property file and maps it into Properties object. Property file must be on the classpath.
	 * 
	 * @param fileName - property file name
	 * @param loader - classloader; the property file is supposed to be on the classpath, so the classloader can loads it
	 * @return Properties object
	 */
	public static Properties loadProperties (String fileName, ClassLoader loader) {
		
		if (fileName == null)
            throw new IllegalArgumentException ("null input: name");
        
        if (fileName.startsWith ("/"))
        	fileName = fileName.substring (1);
            
        if (fileName.endsWith (SUFFIX))
        	fileName = fileName.substring (0, fileName.length () - SUFFIX.length ());
		
		Properties properties = null;
        InputStream inputStream = null;
		
        try {
            if (loader == null) 
            	loader = ClassLoader.getSystemClassLoader ();
            
            if (LOAD_AS_RESOURCE_BUNDLE) {
            	fileName = fileName.replace ('/', '.');
                final ResourceBundle resourceBundle = ResourceBundle.getBundle (fileName);
                
                properties = new Properties();
    			
    			for (Enumeration<String> keys = resourceBundle.getKeys (); keys.hasMoreElements ();) {
                    final String key = (String) keys.nextElement ();
                    final String value = resourceBundle.getString (key);
                    properties.put (key, value);
                } 
    			
            } else {
            	
            	fileName = fileName.replace ('.', '/');
                
                if (!fileName.endsWith(SUFFIX))
                	fileName = fileName.concat(SUFFIX);
                                
                inputStream = loader.getResourceAsStream(fileName);
                if (inputStream != null) {
                	properties = new Properties ();
                	properties.load (inputStream); // Can throw IOException
                }
            }
		} catch(Exception e) {
			e.printStackTrace();
			properties = null;
		} finally {			
			 if (inputStream != null)
				try { 
					 inputStream.close (); 
				} catch (Throwable ignore) {
					
				}
		}
		return properties;
	}
	
}
