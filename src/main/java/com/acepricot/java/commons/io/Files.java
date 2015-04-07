package com.acepricot.java.commons.io;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Files {
	
	
	public static boolean isSubdirectory(File base, File child) throws IOException {
	    
		base = base.getCanonicalFile();
	    child = child.getCanonicalFile();
	
	    File parentFile = child;
	    while (parentFile != null) {
		    if (base.equals(parentFile)) {
		    	return true;
		    }
		    parentFile = parentFile.getParentFile();
	    }
	    return false;
    }
	
	
	public static List<String> getFileNamesFromDir(File dir, String endsWith) {
		
		List<String> fileNames = new ArrayList<String>();
		
		File[] files = dir.listFiles();
		if(files == null)
			return fileNames;
		
		for (File file : files) {
		    if (file.isFile() && file.getName().endsWith(endsWith)) {
		    	fileNames.add(file.getName());
		    }
		}
		
		return fileNames;
	}

}
