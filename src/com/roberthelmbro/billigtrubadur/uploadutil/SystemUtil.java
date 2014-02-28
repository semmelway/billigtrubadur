package com.roberthelmbro.billigtrubadur.uploadutil;

import java.io.IOException;

public class SystemUtil {
	
	public static void open(String url) {
		String system = System.getProperty("os.name");

		System.out.println("System:: " + system);

		if (system.equals("Linux")) {
			try {
				Runtime.getRuntime().exec("chromium-browser " + url);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if(false /**windows*/) {
			//		String command = "cmd /c start " + url;
			//		try {
			//			Runtime.getRuntime().exec(command);
			//		} catch (IOException ioe) {
			//			System.out.println("exc");// TODO
			//		}
		}
	}

}
