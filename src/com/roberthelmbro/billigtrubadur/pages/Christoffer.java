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

public class Christoffer extends Background {

	
	public static String label = "Christoffer";
	public static String fileName = "christoffer.html";
	
	private String title = "Billig trubadur - " + label;
	private String[] keywords = {"band", "artister", "Christoffer", "Berg", "boka", "trubadur"};
	private static final String description = "Billiga trubadurer helt enkelt";

	private void generateBody(){
		html.setFont(Settings.headerFontColor, Settings.baseFont, Settings.headerFontSize);
		html.writeTextLn("Christoffer Berg");
		html.setFont(Settings.standardFontColor, Settings.baseFont, Settings.standardFontSize);
		html.writeText("Släppte nyss epn Några sånger.<br/><br/>");
		
		html.setFont(semiHeaderFontColor, Settings.baseFont, semiHeaderFontSize);
		html.writeText("Instrument<br/>");
		html.setFont(Settings.standardFontColor, Settings.baseFont, Settings.standardFontSize);
		html.writeText("Gitarr<br/><br/>");
		
		
		html.setFont(semiHeaderFontColor, Settings.baseFont, semiHeaderFontSize);
		html.writeText("Spelar<br/>");
		html.setFont(Settings.standardFontColor, Settings.baseFont, Settings.standardFontSize);
		html.writeText("Eget material. Lyssna på Christoffer på");
		html.setFont(Settings.linkFontColor, Settings.baseFont, Settings.standardFontSize);
		html.writeTextLink("Soundcloud", "https://soundcloud.com/somfolk", HtmlUtil.newWindow);
		html.setFont(Settings.standardFontColor, Settings.baseFont, Settings.standardFontSize);
		html.writeText(" eller ");
		html.setFont(Settings.linkFontColor, Settings.baseFont, Settings.standardFontSize);
		html.writeTextLink("Spotify", "http://open.spotify.com/artist/02Uq2R8evvTP7St90NLbBs", HtmlUtil.newWindow);
		
		
		html.lineBreak(2);
		
		
		html.setFont(semiHeaderFontColor, Settings.baseFont, semiHeaderFontSize);
		html.writeText("Standardpris<br/>");
		html.setFont(Settings.standardFontColor, Settings.baseFont, Settings.standardFontSize);
		html.writeText("2000 kr<br/><br/>");
		
		html.setFont(semiHeaderFontColor, Settings.baseFont, semiHeaderFontSize);
		html.writeText("Utgångsort<br/>");
		html.setFont(Settings.standardFontColor, Settings.baseFont, Settings.standardFontSize);
		html.writeText("Göteborg<br/><br/>");
		
		html.setFont(semiHeaderFontColor, Settings.baseFont, semiHeaderFontSize);
		html.writeText("Ljudanläggning<br/>");
		html.setFont(Settings.standardFontColor, Settings.baseFont, Settings.standardFontSize);
		html.writeText("Efter överenskommelse.<br/><br/>");
		
		
		
		html.setFont(semiHeaderFontColor, Settings.baseFont, semiHeaderFontSize);
		html.writeText("Kontakt och bokning<br/>");
		html.setFont(Settings.standardFontColor, Settings.baseFont, Settings.standardFontSize);
		html.writeText("070-6744 682");
		html.setFont(Settings.linkFontColor, baseFont, Settings.linkFontSize);
		html.mailTo("rafd-@hotmail.com", "rafd-@hotmail.com");
		html.writeText("<br/>");
		
		//html.writeText("<object width=\"480\" height=\"385\"><param name=\"movie\" value=\"http://www.youtube.com/v/JaL-Y3aRmK0?fs=1&amp;hl=sv_SE&amp;rel=0\"></param><param name=\"allowFullScreen\" value=\"true\"></param><param name=\"allowscriptaccess\" value=\"always\"></param><embed src=\"http://www.youtube.com/v/JaL-Y3aRmK0?fs=1&amp;hl=sv_SE&amp;rel=0\" type=\"application/x-shockwave-flash\" allowscriptaccess=\"always\" allowfullscreen=\"true\" width=\"480\" height=\"385\"></embed></object>");
		
		div.drawImage(Settings.imagesPath + "christoffer1.png", 504, 0, 273, 0, 3);
		div.drawImageLink(Settings.imagesPath + "svTrubBanner.png", "http://sverigestrubadurer.appspot.com", 0, 420, 777, 80, 3);
		div.drawImage(Settings.imagesPath + "christoffer2.png", 0, 515, 356, 0, 3);
		div.drawImage(Settings.imagesPath + "christoffer3.png", 369, 515, 408, 0, 3);
		
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
			ImageLoader.upploadImageResource("christoffer1.png", uploadType);
			ImageLoader.upploadImageResource("christoffer2.png", uploadType);
			ImageLoader.upploadImageResource("christoffer3.png", uploadType);
		}

		public static void main(String args[])throws FileNotFoundException, IOException{
			Christoffer christoffer = new Christoffer();
			christoffer.generateFile(Settings.testTargetPath);
			christoffer.uploadResources(UploadType.TEST);
			String command = "cmd /c start " + Settings.testTargetPath + fileName;
			try {
				Runtime.getRuntime().exec(command);
			} catch (IOException ioe) {
				System.out.println("exc");// TODO
			}
	}
}
