/**
* @author Robert Helmbo, 2007
*/
package com.roberthelmbro.billigtrubadur.pages;

import static com.roberthelmbro.billigtrubadur.uploadutil.Settings.baseFont;
import static com.roberthelmbro.billigtrubadur.uploadutil.Settings.linkFontColor;
import static com.roberthelmbro.billigtrubadur.uploadutil.Settings.linkFontSize;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import com.roberthelmbro.billigtrubadur.uploadutil.ImageLoader;
import com.roberthelmbro.billigtrubadur.uploadutil.Settings;
import com.roberthelmbro.billigtrubadur.uploadutil.ImageLoader.UploadType;
import r.html.Column;
import r.html.Div;
import r.html.HtmlUtil;


public class About extends Background{
	
	public static String label = "Om";
	public static String fileName = "about.html";
	
	private static String trobadourShaddowedImageWithBoarder = "troubadourShaddowedWithBoarder.png";
	
	public void generateBody() {
		
		
		html.setFont(Settings.headerFontColor, "helvetica", Settings.headerFontSize);
		html.writeText("Billig trubadur<br/>");
		html.setFont(Settings.standardFontColor, "helvetica", Settings.standardFontSize);
		html.writeText("Billig trubadur hjälper mindre etablerade trubadurer och liknande artister med marknadsföring, fakturering, ekonomi och utrustning.<br/><br/> ");
		
		html.setFont(Settings.headerFontColor, "helvetica", Settings.headerFontSize);
		html.writeText("Ta steget du också<br/>");
		html.setFont(Settings.standardFontColor, "helvetica", Settings.standardFontSize);
		html.writeText("Är du trubadur och vill synas på Billig trubadur? <br/>");
		html.writeText("Tveka inte att höra av dig. än så länge är mailen elinorspelen@mydisk.se <br/><br/>");
		
		html.setFont(Settings.headerFontColor, "helvetica", Settings.headerFontSize);
		html.writeTextLn("Övrigt");
		
		html.setFont(Settings.standardFontColor, "helvetica", Settings.standardFontSize);
		html.writeText("Här finns tips på trubadurlåtar: ");
		
		html.setFont(linkFontColor, baseFont, linkFontSize);
		html.writeTextLinkLnNewWindow("Saknade ackord", "http://saknadeackord.appspot.com");
		
		html.setFont(Settings.standardFontColor, "helvetica", Settings.standardFontSize);
		html.writeText("Billig trubadur presenteras i samarbete med: ");
		
		html.setFont(linkFontColor, baseFont, linkFontSize);
		html.writeTextLinkLn("Elinorspelen", "http://elinorspelen.mydisk.se", HtmlUtil.newWindow);
		
		html.lineBreak(8);
		

		html.setFont(Settings.standardFontColor, "helvetica", Settings.standardFontSize);
		html.writeText("Hemsidan gjord av: Robert Helmbro<br/>Senast uppdaterad: " + new Date(System.currentTimeMillis()).toString());
		
		
	}
	
		
		public void generateFile(String targetPath)throws FileNotFoundException, IOException{
			html = new HtmlUtil();
			column = new Column(html);
			html.setPrintWriter(targetPath + fileName);
			div = new Div(html);
			String[] keywords = {"Om"};
			html.writeOpenTags();
			html.generateHead("Billig trubadur - Om", "Billiga trubadurer helt enkelt.", keywords,"");
			html.setBackgroundColor(Settings.backgroundColor);
			html.openBody();
			div.centeredDivArea("mainArea", 960);
			
			div.drawImage(Settings.imagesPath + trobadourShaddowedImageWithBoarder, 570, 280, 307, 0, 2);
	
			div.genericStartTag(100, 280, 500, 30, 2);//"body"
			generateBody();
			
			div.genericEndTag();//"body"
			
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
			System.out.println("about.html generated");
		}
		
		public void uploadResources(UploadType uploadType){
			
			ImageLoader.upploadImageResource(trobadourShaddowedImageWithBoarder, uploadType);

		}
	
		public static void main(String args[]) throws FileNotFoundException, IOException{
			new About().generateFile(Settings.testTargetPath);
			new About().uploadResources(UploadType.TEST);
			String command = "cmd /c start " + Settings.testTargetPath + fileName;
			try {
				Runtime.getRuntime().exec(command);
			} catch (IOException ioe) {
				System.out.println("exc");// TODO
			}
	}
}
