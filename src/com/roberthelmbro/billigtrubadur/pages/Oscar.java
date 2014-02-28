	/**
	 * @author Robert Helmbo, 2008
	 */
package com.roberthelmbro.billigtrubadur.pages;

import static com.roberthelmbro.billigtrubadur.uploadutil.Settings.baseFont;
import static com.roberthelmbro.billigtrubadur.uploadutil.Settings.semiHeaderFontColor;
import static com.roberthelmbro.billigtrubadur.uploadutil.Settings.semiHeaderFontSize;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.roberthelmbro.billigtrubadur.uploadutil.ImageLoader;
import com.roberthelmbro.billigtrubadur.uploadutil.Settings;
import com.roberthelmbro.billigtrubadur.uploadutil.ImageLoader.UploadType;
import r.html.HtmlUtil;
import r.html.Div;

public class Oscar extends Background{
	
	public static String label = "Oscar";
	public static String fileName = "oscar.html";
	
	private String title = "Billig trubadur " + label;
	private String[] keywords = {"band", "artister", "Robert", "boka", "trubadur"};
	private static final String description = "Billiga trubadurer helt enkelt";


	private void generateBody(){
		
		
		
		html.setFont(Settings.headerFontColor, Settings.baseFont, Settings.headerFontSize);
		html.writeText("Björn<br/>");
		html.setFont(Settings.standardFontColor, Settings.baseFont, Settings.standardFontSize);
		html.writeText(
				"Med Björn i n�rheten har man alltid n�ra till skratt. Sk�nare kille f�r man leta efter och gitarren h�nger med n�stan j�mt." +
				"<br/><br/>");
		
		html.setFont(semiHeaderFontColor, Settings.baseFont, semiHeaderFontSize);
		html.writeText("Instrument<br/>");
		html.setFont(Settings.standardFontColor, Settings.baseFont, Settings.standardFontSize);
		html.writeText("Gitarr, munspel, piano, ukelele<br/><br/>");
		
		
		html.setFont(semiHeaderFontColor, Settings.baseFont, semiHeaderFontSize);
		html.writeText("Spelar<br/>");
		html.setFont(Settings.standardFontColor, Settings.baseFont, Settings.standardFontSize);
		html.writeText("Egna l�tar med influenser av Lars Winnerb�k, Ida Redig med flera.<br/>Andras l�tar, Lars Winnerb�ck, Cornelis Vreeswijk, Gyllene Tider, Oasis med mera.<br/><br/>");
		
		html.setFont(semiHeaderFontColor, Settings.baseFont, semiHeaderFontSize);
		html.writeText("Standardpris<br/>");
		html.setFont(Settings.standardFontColor, Settings.baseFont, Settings.standardFontSize);
		html.writeText("1500 kr<br/><br/>");
		
		html.setFont(semiHeaderFontColor, Settings.baseFont, semiHeaderFontSize);
		html.writeText("Utg�ngsort<br/>");
		html.setFont(Settings.standardFontColor, Settings.baseFont, Settings.standardFontSize);
		html.writeText("Uddevalla<br/><br/>");
		
		
		
		html.setFont(semiHeaderFontColor, Settings.baseFont, semiHeaderFontSize);
		html.writeText("Kontakt och bokning<br/>");
		html.setFont(Settings.standardFontColor, Settings.baseFont, Settings.standardFontSize);
		html.writeText("073-57 400 10 <br/>");
		html.setFont(Settings.linkFontColor, baseFont, Settings.linkFontSize);
		html.mailTo("b_grahn91@hotmail.com", "b_grahn91@hotmail.com");
		html.writeText("<br/>");
		
		//html.writeText("<object width=\"480\" height=\"385\"><param name=\"movie\" value=\"http://www.youtube.com/v/JaL-Y3aRmK0?fs=1&amp;hl=sv_SE&amp;rel=0\"></param><param name=\"allowFullScreen\" value=\"true\"></param><param name=\"allowscriptaccess\" value=\"always\"></param><embed src=\"http://www.youtube.com/v/JaL-Y3aRmK0?fs=1&amp;hl=sv_SE&amp;rel=0\" type=\"application/x-shockwave-flash\" allowscriptaccess=\"always\" allowfullscreen=\"true\" width=\"480\" height=\"385\"></embed></object>");
		
		div.drawImage(Settings.imagesPath + "bjorn1.jpg", 504, 0, 273, 0, 3);
		div.drawImage(Settings.imagesPath + "bjorn2.png", 0, 415, 333, 0, 3);
		div.drawImage(Settings.imagesPath + "bjorn3.png", 342, 415, 435, 0, 3);
		
		int utilCordinateY = -220;
	}
	
	
	public void generateFile(String targetPath)throws FileNotFoundException, IOException{
		html = new HtmlUtil();
		html.setPrintWriter(targetPath + fileName);
		div = new Div(html);
		html.writeOpenTags();
		html.generateHead(title, description, keywords,"");
		html.setBackgroundColor(Settings.backgroundColor);
		html.openBody();
		div.centeredDivArea("mainArea", 960);
		div.genericStartTag(100, 280, 500, 30, 2);//"body"
		
		generateBody();

		div.genericEndTag();
		drawBackground(1500);
		div.genericEndTag();//mainArea
		if (targetPath == Settings.publishTargetPath) {
			//for statistics
			html.print("<!-- Start of StatCounter Code --><script type=\"text/javascript\">var sc_project=6589278; var sc_invisible=1; var sc_security=\"c983c07b\"; </script><script type=\"text/javascript\"src=\"http://www.statcounter.com/counter/counter.js\"></script><noscript><divclass=\"statcounter\"><a title=\"joomla site stats\"href=\"http://statcounter.com/joomla/\" target=\"_blank\"><imgclass=\"statcounter\"src=\"http://c.statcounter.com/6589278/0/c983c07b/1/\"alt=\"joomla site stats\" ></a></div></noscript><!-- End of StatCounter Code -->");
			}
		html.closeBody();
		html.writeCloseTags();
		html.closeConnection();
		div.checkOpenCLose(fileName);
		System.out.println(fileName + " generated");
	}
		
		public void uploadResources(UploadType uploadType){
			ImageLoader.upploadImageResource("bjorn1.png", uploadType);
			ImageLoader.upploadImageResource("bjorn2.png", uploadType);
			ImageLoader.upploadImageResource("bjorn3.png", uploadType);
		}
	
		public static void main(String args[])throws FileNotFoundException, IOException{
			Oscar oscar = new Oscar();
			oscar.generateFile(Settings.testTargetPath);
			oscar.uploadResources(UploadType.TEST);
			String command = "cmd /c start " + Settings.testTargetPath + fileName;
			try {
				Runtime.getRuntime().exec(command);
			} catch (IOException ioe) {
				System.out.println("exc");// TODO
			}
	}
}
