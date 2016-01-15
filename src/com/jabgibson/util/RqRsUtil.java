package com.jabgibson.util;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

public class RqRsUtil {

	public static boolean isAuthorizedBasic(String user, String pass, String auth) {
		boolean answer = false;
		
		if (auth != null && auth.startsWith("Basic")) {
	        // Authorization: Basic base64credentials
	        String base64Credentials = auth.substring("Basic".length()).trim();
	        String credentials = new String(Base64.getDecoder().decode(base64Credentials),
	                Charset.forName("UTF-8"));
	        // credentials = username:password
	        List<String> values = Arrays.asList(credentials.split(":",2));
	        
	        answer = (values.get(0).equals(user) && values.get(1).equals(pass));
		}
		return answer;
	}
}
