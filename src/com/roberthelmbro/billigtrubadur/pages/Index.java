	/**
	 * @author Robert Helmbo, 2008
	 */
package com.roberthelmbro.billigtrubadur.pages;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.roberthelmbro.billigtrubadur.uploadutil.ImageLoader;
import com.roberthelmbro.billigtrubadur.uploadutil.Settings;
import com.roberthelmbro.billigtrubadur.uploadutil.ImageLoader.UploadType;
import r.html.HtmlUtil;
import r.html.Div;

public class Index extends Background{
	
	public static String label = "Hem";
	public static String fileName = "index.html";
	public static String[] keywords  = {"trubadur","billig","billigt","underhållning"};
	

	private static String trobadour3 = "trub3.png";
	
	private void generateBody(){
		

		html.setFont(Settings.headerFontColor, "helvetica", Settings.headerFontSize);
		html.writeText("Billig trubadur<br/>");
		html.setFont(Settings.standardFontColor, "helvetica", Settings.standardFontSize);
		html.writeText("Billiga trubadurer helt enkelt. <br/><br/>" +
				"En trubadur passar utmärkt som underhållning på kalaset, bröllopsfesten, puben, firmafesten, kundfesten med mera.<br/><br/> Vi samlar billiga trubadurer från hela sverige. än så länge är täckningen något begränsad men rekrytering pågår! Det skall vara enkelt att boka en trubadur på varje profil står ett standardpris som även täcker resa.");
		
		div.drawImageLink(Settings.imagesPath + "svTrubBanner.png", "https://sverigestrubadurer.appspot.com", 0, 420, 777, 80, 3);
	}
	



	public void generateFile(String targetPath)throws FileNotFoundException, IOException{
		html = new HtmlUtil();
		html.setPrintWriter(targetPath + fileName);
		div = new Div(html);
		html.writeOpenTags();
		html.generateHead("Billig trubadur - Hem", "Billiga trubadurer helt enkelt.", keywords,"");
		html.setBackgroundColor(Settings.backgroundColor);
		html.openBody();
		div.centeredDivArea("mainArea", 960);
		drawBackground(1200);
		div.drawImage(Settings.imagesPath + trobadour3, 570, 280, 307, 0, 2);


		div.genericStartTag(100, 280, 400, 2000, 1);


		generateBody();

		div.genericEndTag();
		div.genericEndTag();
		String n = String.valueOf('"');//use "+n+"


		if (targetPath == Settings.publishTargetPath) {
		//for statistics
		html.print("<!-- Start of StatCounter Code --><script type=\"text/javascript\">var sc_project=6589278; var sc_invisible=1; var sc_security=\"c983c07b\"; </script><script type=\"text/javascript\"src=\"http://www.statcounter.com/counter/counter.js\"></script><noscript><divclass=\"statcounter\"><a title=\"joomla site stats\"href=\"http://statcounter.com/joomla/\" target=\"_blank\"><imgclass=\"statcounter\"src=\"http://c.statcounter.com/6589278/0/c983c07b/1/\"alt=\"joomla site stats\" ></a></div></noscript><!-- End of StatCounter Code -->");
		}
		html.closeBody();
		html.writeCloseTags();
		html.closeConnection();
		div.checkOpenCLose(fileName);
		System.out.println("index.html generated");
	}
	
	public void uploadResources(UploadType uploadType){
		super.uploadResources(uploadType);
		ImageLoader.upploadImageResource(trobadour3, uploadType);
		
	}
	
		public static void main(String args[])throws FileNotFoundException, IOException{
			Index index = new Index();
			index.generateFile(Settings.testTargetPath);
			index.uploadResources(UploadType.TEST);
			index.uploadResources(UploadType.TEST);
			String command = "cmd /c start " + Settings.testTargetPath + fileName;
			try {
				Runtime.getRuntime().exec(command);
			} catch (IOException ioe) {
				System.out.println("exc");// TODO
			}
	}
}
