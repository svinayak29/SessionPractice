package com.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {

	
	public String readData(String key) throws IOException {
		FileInputStream fs = new FileInputStream(".\\src\\test\\resources\\Data.properties");
		Properties pObj = new Properties();
		pObj.load(fs);
		String value = pObj.getProperty(key);
		return value;
	}
}
