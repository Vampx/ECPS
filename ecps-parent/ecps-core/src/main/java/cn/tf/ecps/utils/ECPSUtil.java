package cn.tf.ecps.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ECPSUtil {
	
	
		public static String readProp(String key){
			Properties prop = new Properties();
			
			InputStream in = ECPSUtil.class.getClassLoader().getResourceAsStream("ecps.properties");
			String value = null;
			try {
				prop.load(in);
				value = prop.getProperty(key);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return value;
			
		}
	}


