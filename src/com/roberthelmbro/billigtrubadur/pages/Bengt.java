/**
 * @author Robert Helmbo, 2013
 */
package com.roberthelmbro.billigtrubadur.pages;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.roberthelmbro.billigtrubadur.uploadutil.ImageLoader;
import com.roberthelmbro.billigtrubadur.uploadutil.Settings;
import com.roberthelmbro.billigtrubadur.uploadutil.SystemUtil;
import com.roberthelmbro.billigtrubadur.uploadutil.ImageLoader.UploadType;

import r.html.HtmlUtil;
import r.html.Div;
import static com.roberthelmbro.billigtrubadur.uploadutil.Settings.baseFont;
import static com.roberthelmbro.billigtrubadur.uploadutil.Settings.semiHeaderFontColor;
import static com.roberthelmbro.billigtrubadur.uploadutil.Settings.semiHeaderFontSize;
public class Bengt extends Background {
	
	public static String label = "Bengt";
	public static String fileName = "bengt.html";
	
	private String title = "Billig trubadur - " + label;
	private String[] keywords = {"band", "artister", "bengt", "boka", "trubadur", "fridman"};
	private String description = "Billiga trubadurer helt enkelt";


	private void generateBody(){
		html.setFont(Settings.headerFontColor, Settings.baseFont, Settings.headerFontSize);
		html.writeText("Bengt Fridman<br/>");
		html.setFont(Settings.standardFontColor, Settings.baseFont, Settings.standardFontSize);
		html.writeText(
				"Spelar och sjunger där det behövs" +
				"<br/><br/>");
		
		html.setFont(semiHeaderFontColor, Settings.baseFont, semiHeaderFontSize);
		html.writeText("Instrument<br/>");
		html.setFont(Settings.standardFontColor, Settings.baseFont, Settings.standardFontSize);
		html.writeText("Gitarr och munspel<br/><br/>");
		
		html.setFont(semiHeaderFontColor, Settings.baseFont, semiHeaderFontSize);
		html.writeText("Spelar<br/>");
		html.setFont(Settings.standardFontColor, Settings.baseFont, Settings.standardFontSize);
		html.writeText("Kända gamla låtar, allt från Beatles till Cornelis. Även kristna sånger på svenska, finska och engelska.<br/>");
		html.lineBreak(1);
		
		html.setFont(semiHeaderFontColor, Settings.baseFont, semiHeaderFontSize);
		html.writeText("Standardpris<br/>");
		html.setFont(Settings.standardFontColor, Settings.baseFont, Settings.standardFontSize);
		html.writeText("1500 kr<br/><br/>");
		
		html.setFont(semiHeaderFontColor, Settings.baseFont, semiHeaderFontSize);
		html.writeText("Utgångsort<br/>");
		html.setFont(Settings.standardFontColor, Settings.baseFont, Settings.standardFontSize);
		html.writeText("Köping, Västmanlands län<br/><br/>");
		
		html.setFont(semiHeaderFontColor, Settings.baseFont, semiHeaderFontSize);
		html.writeText("Ljudanläggning<br/>");
		html.setFont(Settings.standardFontColor, Settings.baseFont, Settings.standardFontSize);
		html.writeText("Bengt har egen ljudanläggning.<br/><br/>");
		
		
		
		
		
		html.setFont(semiHeaderFontColor, Settings.baseFont, semiHeaderFontSize);
		html.writeText("Kontakt och bokning<br/>");
		html.setFont(Settings.standardFontColor, Settings.baseFont, Settings.standardFontSize);
		html.writeText("070-238 2127 eller 072-734 7558 <br/>");
		html.setFont(Settings.linkFontColor, baseFont, Settings.linkFontSize);
		html.mailTo("bengt.fridman@fribena.se", "bengt.fridman@fribena.se");
		html.writeText("<br/>");
		
		//html.writeText("<object width=\"480\" height=\"385\"><param name=\"movie\" value=\"http://www.youtube.com/v/JaL-Y3aRmK0?fs=1&amp;hl=sv_SE&amp;rel=0\"></param><param name=\"allowFullScreen\" value=\"true\"></param><param name=\"allowscriptaccess\" value=\"always\"></param><embed src=\"http://www.youtube.com/v/JaL-Y3aRmK0?fs=1&amp;hl=sv_SE&amp;rel=0\" type=\"application/x-shockwave-flash\" allowscriptaccess=\"always\" allowfullscreen=\"true\" width=\"480\" height=\"385\"></embed></object>");
		
		div.drawImage(Settings.imagesPath + "bengt1.png", 504, 0, 273, 0, 3);
		div.drawImageLink(Settings.imagesPath + "svTrubBanner.png", "https://sverigestrubadurer.appspot.com", 0, 420, 777, 80, 3);
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
			ImageLoader.upploadImageResource("bengt1.png", uploadType);
		}
	
		public static void main(String args[])throws FileNotFoundException, IOException{
			Bengt bengt = new Bengt();
			bengt.generateFile(Settings.testTargetPath);
			bengt.uploadResources(UploadType.TEST);
			SystemUtil.open(Settings.testTargetPath + fileName);
	}
}
