package com.vtiger.comcast.genericUtility;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
/**
 * 
 * @author Manju
 *
 */

public class FileUtility {
	
	/**
	 * it is used to read the data from commonData.properties file based on key which you pass as an argumentt
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	
public String getPropertyKeyValue(String key) throws Throwable {
	FileInputStream fis=new FileInputStream("./Data/commonData.properties7");
	Properties pobj=new Properties();
	pobj.load(fis);
	String value = pobj.getProperty(key);
	return value;
    }

}
