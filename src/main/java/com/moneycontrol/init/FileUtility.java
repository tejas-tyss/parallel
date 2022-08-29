package com.moneycontrol.init;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 *@author Janardhan
 *This Class Contains Method to read the data From property file
 */

public class FileUtility {

	/**
	 * @author Janardhan
	 * Method is used to read the data from the property file using Properties,FileInputStream java.util,java.io
	 * @param key
	 * @return String
	 */
	public String readDataFromPropertyFile(String key)
	{
		Properties prop=new Properties();
		try
		{
			prop.load(new FileInputStream(IPath.propertyPath));
		}
		catch (FileNotFoundException e) 
		{
			Logs.error(getClass(), "File is not found", e);
		}
		catch (IOException e)
		{
			Logs.error(getClass(),"Failed to fetch the file from current directory", e);
		}
		String value=prop.getProperty(key);
		//Logs.info(getClass(), "Read Data From Property File "+value);
		return value;
	}
}
