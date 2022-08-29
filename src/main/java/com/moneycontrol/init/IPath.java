package com.moneycontrol.init;

/**
 * @author DanishR
 * This interface defines the common resources path
 */
public interface IPath {
	String propertyPath = ".//src/main/resources/PropertyReader.properties";
	public static String sDirPath = System.getProperty("user.dir");
	public static String sConfigPath = sDirPath + "/src/main/resources/config/config.xlsx";
	public static String sUserCredFile = sDirPath + "/src/test/resources/testdata/app/user_credential.properties";
	
}
