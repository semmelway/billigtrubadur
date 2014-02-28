package com.roberthelmbro.billigtrubadur.uploadutil;

public class Settings {
	/**
	 * The folder where the  webpage should be placed
	 * Called as root folder.
	 */
	public final static String testTargetPath = "/home/CORPUSERS/23053389/temp/billigTrubadur/";
	public final static String publishTargetPath = "/home/CORPUSERS/23053389/temp/r/eGalileoW/BilligTrubadur/war/";
	
	/**
	 * Relative path to images resources at the webpage.
	 * The complete path is built up using <code>targetPath<code>.
	 */
	public final static String imagesPath = "images/";
	
	public final static boolean upploadResources = true;
	
	/**
	 * Colors
	 */
	public final static String backgroundColor = "707070";
	
	/**
	 * Text fonts
	 */
	public final static String headerFontColor = "#333333";
	public final static int headerFontSize = 4;
	
	public final static String semiHeaderFontColor = "#444444";
	public final static int semiHeaderFontSize = 3;
	
	public final static String remarkFontColor = "#888888";
	public final static int remarkFontSize = 1;
	
	public final static String standardFontColor = "#555555";
	public final static int standardFontSize = 2;
	
	public final static String linkFontColor = "#4444BB";
	public final static int linkFontSize = 2;
	
	public final static String baseFont = "helvetica";
	
	public static void main(String[] args){
		GenerateAll.main(args);
	}

}
