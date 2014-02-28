package com.roberthelmbro.billigtrubadur.pages;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.roberthelmbro.billigtrubadur.uploadutil.ImageLoader;
import com.roberthelmbro.billigtrubadur.uploadutil.Settings;
import com.roberthelmbro.billigtrubadur.uploadutil.ImageLoader.UploadType;
import r.html.Column;
import r.html.Div;
import r.html.HtmlUtil;

public class Information extends Background{
	public static String label = "Bokningsinfo";
	public static String fileName = "information.html";
	
	private static String trobadour4 = "trub4.png";
	
	public void generateBody() {
		
		html.setFont(Settings.headerFontColor, "helvetica", Settings.headerFontSize);
		html.writeText("Bokning<br/>");
		html.setFont(Settings.standardFontColor, "helvetica", Settings.standardFontSize);
		html.writeText("För att boka kontaktar du trubaduren du vill boka direkt. Antigen via mail eller telefon. Kontaktinfo finns under respektive trubadurs profil. Det går också bra att skicka ett mail till elinorspelen@mydisk.se<br/><br/> ");
		
		html.setFont(Settings.headerFontColor, "helvetica", Settings.headerFontSize);
		html.writeText("Standardpris<br/>");
		html.setFont(Settings.standardFontColor, "helvetica", Settings.standardFontSize);
		html.writeText("På varje trubadurs profil står ett standardpris angivet. Standardpriset täcker allt som behövs för de flesta: <br/> - 2 timmars framträdande <br/> - Resa, max 4 mil från utgångsorten <br/> - Om trubaduren har egen ljudanläggning ingår även den.<br/><br/>  ");
		html.writeText("Om kraven skiljer sig markant från det som ingår i standardpriset tillkommer: <br/> - 18 kronor per mil kompletterande resa<br/> - 500 kronor per timme extra speltid <br/><br/>");

	}
	
		
		public void generateFile(String targetPath)throws FileNotFoundException, IOException{
			html = new HtmlUtil();
			column = new Column(html);
			html.setPrintWriter(targetPath + fileName);
			div = new Div(html);
			String[] keywords = {"Bokningsinfo"};
			html.writeOpenTags();
			html.generateHead("Billig trubadur - Bokningsinfo", "Billiga trubadurer helt enkelt.", keywords,"");
			html.setBackgroundColor(Settings.backgroundColor);
			html.openBody();
			
			div.centeredDivArea("mainArea", 960);
			
			div.drawImage(Settings.imagesPath + trobadour4, 570, 280, 307, 0, 2);
	
			div.genericStartTag(100, 280, 450, 30, 2);//"body"
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
			System.out.println( fileName + " generated");
		}
		
		public void uploadResources(UploadType uploadType){
			ImageLoader.upploadImageResource(trobadour4, uploadType);
			
		}
	
		public static void main(String args[]) throws FileNotFoundException, IOException{
			new Information().generateFile(Settings.testTargetPath);
			new Information().uploadResources(UploadType.TEST);
			String command = "cmd /c start " + Settings.testTargetPath + fileName;
			try {
				Runtime.getRuntime().exec(command);
			} catch (IOException ioe) {
				System.out.println("exc");// TODO
			}
	}
}
