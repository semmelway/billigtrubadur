package com.roberthelmbro.billigtrubadur.uploadutil;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import r.fileutil.FileUtil;

public class ImageLoader {
	
	private static String imageResourceFolder = "./res/billigTrubadur/images/";
	
	public enum UploadType { TEST, PUBLISH}
	
    
    
	
	/**
	 * Uploads a picture from the local resource folder to the in <code>Settings<code> specified images path
	 * 
	 * @param fileName
	 */
	public static void upploadImageResource(String fileName, UploadType uploadType){
		//URL resourceURL = ImageLoader.class.getResource(imageResourceFolder + fileName);
		
		
		File resourceFile = new File(imageResourceFolder + fileName);
		
		if(!resourceFile.isFile() || !resourceFile.canRead())
			System.out.println("Failed to read " + imageResourceFolder + fileName);
		
		
		
		
		
		//if(resourceURL == null)
		//	System.out.println("Could not find " + imageResourceFolder + fileName);
		
	//	File resourceFile = new File(resourceURL.getPath());
		
		File targetFile = null;
		switch (uploadType) {
		case TEST:
			targetFile = new File(Settings.testTargetPath + Settings.imagesPath + fileName);
			break;
		case PUBLISH:
			targetFile = new File(Settings.publishTargetPath + Settings.imagesPath + fileName);
			break;
		}
		
		
		try{
			FileUtil.copyFile(resourceFile,targetFile);
			System.out.println(fileName + " uploaded.");
		}catch(IOException ioe){
			System.out.println("IOException while upploading " + fileName);
			ioe.printStackTrace();
		}
	}
}
