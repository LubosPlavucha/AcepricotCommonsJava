/**
 * 
 */
package com.lubosplavucha.commonutils.io;

import java.io.File;


/**
 * @author quixy
 *
 */
public class SystemUtils {

	
	public static String getClassDirectory(Class<?> clazz) {
		File file = new File(clazz.getProtectionDomain().getCodeSource().getLocation().getPath());
		if(file.isFile())
			return file.getParent();
		else
			return file.getAbsolutePath();
	}
	
	
	//public static String getPathToAppBundle() {
	//	return com.apple.eio.FileManager.getPathToApplicationBundle();
	//}
	
}
