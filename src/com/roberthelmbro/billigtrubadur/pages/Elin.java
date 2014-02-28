/**
 * @author Robert Helmbo, 2013
 */
package com.roberthelmbro.billigtrubadur.pages;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.roberthelmbro.billigtrubadur.uploadutil.ImageLoader;
import com.roberthelmbro.billigtrubadur.uploadutil.Settings;
import com.roberthelmbro.billigtrubadur.uploadutil.ImageLoader.UploadType;
import r.html.HtmlUtil;
import r.html.Div;

import static com.roberthelmbro.billigtrubadur.uploadutil.Settings.baseFont;
import static com.roberthelmbro.billigtrubadur.uploadutil.Settings.linkFontColor;
import static com.roberthelmbro.billigtrubadur.uploadutil.Settings.linkFontSize;
import static com.roberthelmbro.billigtrubadur.uploadutil.Settings.semiHeaderFontColor;
import static com.roberthelmbro.billigtrubadur.uploadutil.Settings.semiHeaderFontSize;
public class Elin extends Background {
	
	public static String label = "HRTENMSNDKWLEKMDSNF";
	public static String fileName = "sdfkjfkdjirenvkdkfh.html";
	
	private String title = "Billig trubadur - " + label;
	private String[] keywords = {"band", "artister", "Robert", "boka", "trubadur"};
	private String description = "Billiga trubadurer helt enkelt";


	private void generateBody(){
		
		
		
		html.setFont(Settings.headerFontColor, Settings.baseFont, Settings.headerFontSize);
		html.writeText("Elin Swenson<br/>");
		html.setFont(Settings.standardFontColor, Settings.baseFont, Settings.standardFontSize);
		html.writeText(
				"�lskar att sjunga och spela sin akustiska gitarr." +
				"<br/><br/>");
		
		html.setFont(semiHeaderFontColor, Settings.baseFont, semiHeaderFontSize);
		html.writeText("Instrument<br/>");
		html.setFont(Settings.standardFontColor, Settings.baseFont, Settings.standardFontSize);
		html.writeText("Gitarr<br/><br/>");
		
		
		html.setFont(semiHeaderFontColor, Settings.baseFont, semiHeaderFontSize);
		html.writeText("Spelar<br/>");
		html.setFont(Settings.standardFontColor, Settings.baseFont, Settings.standardFontSize);
		html.writeText("Sam Smith, Bob Dylan, Bruce Soringsteen, Taylor Swift med mera.<br/>");
		html.setFont(linkFontColor, Settings.baseFont, linkFontSize);
		html.writeTextLink("Lyssna p� Elins Youtube-kanal", "http://www.youtube.com/knaaas", HtmlUtil.newWindow);
		html.lineBreak(2);
		
		html.setFont(semiHeaderFontColor, Settings.baseFont, semiHeaderFontSize);
		html.writeText("Standardpris<br/>");
		html.setFont(Settings.standardFontColor, Settings.baseFont, Settings.standardFontSize);
		html.writeText("2000 kr<br/><br/>");
		
		html.setFont(semiHeaderFontColor, Settings.baseFont, semiHeaderFontSize);
		html.writeText("Utg�ngsort<br/>");
		html.setFont(Settings.standardFontColor, Settings.baseFont, Settings.standardFontSize);
		html.writeText("V�rnamo<br/><br/>");
		
		html.setFont(semiHeaderFontColor, Settings.baseFont, semiHeaderFontSize);
		html.writeText("Ljudanl�ggning<br/>");
		html.setFont(Settings.standardFontColor, Settings.baseFont, Settings.standardFontSize);
		html.writeText("Efter �verenskommelse.<br/><br/>");
		
		
		
		
		
		html.setFont(semiHeaderFontColor, Settings.baseFont, semiHeaderFontSize);
		html.writeText("Kontakt och bokning<br/>");
		html.setFont(Settings.standardFontColor, Settings.baseFont, Settings.standardFontSize);
		//html.writeText("073-57 400 10 <br/>");
		html.setFont(Settings.linkFontColor, baseFont, Settings.linkFontSize);
		html.mailTo("elinswenson@gmail.com", "elinswenson@gmail.com");
		html.writeText("<br/>");
		
		//html.writeText("<object width=\"480\" height=\"385\"><param name=\"movie\" value=\"http://www.youtube.com/v/JaL-Y3aRmK0?fs=1&amp;hl=sv_SE&amp;rel=0\"></param><param name=\"allowFullScreen\" value=\"true\"></param><param name=\"allowscriptaccess\" value=\"always\"></param><embed src=\"http://www.youtube.com/v/JaL-Y3aRmK0?fs=1&amp;hl=sv_SE&amp;rel=0\" type=\"application/x-shockwave-flash\" allowscriptaccess=\"always\" allowfullscreen=\"true\" width=\"480\" height=\"385\"></embed></object>");
		
		div.drawImage(Settings.imagesPath + "elin1.png", 504, 0, 273, 0, 3);
		//div.drawImage(Settings.imagesPath + "bjorn2.png", 0, 415, 333, 0, 3);
		//div.drawImage(Settings.imagesPath + "bjorn3.png", 342, 415, 435, 0, 3);
		
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
			ImageLoader.upploadImageResource("elin1.png", uploadType);
		}
	
		public static void main(String args[])throws FileNotFoundException, IOException{
			Elin bjorn = new Elin();
			bjorn.generateFile(Settings.testTargetPath);
			bjorn.uploadResources(UploadType.TEST);
			String command = "cmd /c start " + Settings.testTargetPath + fileName;
			try {
				Runtime.getRuntime().exec(command);
			} catch (IOException ioe) {
				System.out.println("exc");
			}
	}
}
