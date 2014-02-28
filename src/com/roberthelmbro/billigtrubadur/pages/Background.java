package com.roberthelmbro.billigtrubadur.pages;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.roberthelmbro.billigtrubadur.uploadutil.GenerateAll;
import com.roberthelmbro.billigtrubadur.uploadutil.ImageLoader;
import com.roberthelmbro.billigtrubadur.uploadutil.Settings;
import com.roberthelmbro.billigtrubadur.uploadutil.ImageLoader.UploadType;
import r.html.Column;
import r.html.HtmlUtil;
import r.html.Div;
import r.html.PrintWriter;

public class Background {
	
	private static String backgroundTopImageFileName = "backgroundTop.png";
	//private static String backgroundTopWithBoarderImageFileName = "backgroundTopWithBoarder.png";
	
	private static String backgroundMiddleImageFileName = "backgroundMiddle.png";
	private static String backgroundBottomImageFileName = "backgroundBottom.png";
	
	private static String highlightShadowLeftFileName = "highlightShadowLeft.png";
	private static String highlightShadowRightFileName = "highlightShadowRight.png";
	private static String highlightMiddleFileName = "highlightMiddle.png";
	
	protected static HtmlUtil html;
	protected static Div div;
	protected Column column;
	protected static PrintWriter out;
	protected int index;

	public Background(){
	}

	protected void setIndex(String[] targets){

		for(int i = 0; i < targets.length; i++){
			String thisClassName = this.getClass().getName().toLowerCase();
			String thisPackageName = this.getClass().getPackage().getName();
			thisClassName = thisClassName.substring(thisPackageName.length() + 1);			
			String thisFileName = thisClassName.concat(".html");
			
			
			if(thisFileName.equals(targets[i])){
				this.index = i;
			}
		}
	}

	protected int sum(int[] numbers){
		int result = 0;
		for (int i = 0; i < numbers.length; i++) {
			result +=numbers[i];
		}
		return result;
	}

	public void drawBackground(int height){
		
		//draw logo text link
		html.setFont("#505050", "gulim", 3);
		div.drawTextLink("billigtrubadur.appspot.com", Index.fileName, 720, 205, 200, 20, 2, HtmlUtil.sameWindow);
		
		//draw background images
		div.drawImage(Settings.imagesPath + backgroundTopImageFileName, 0, 0,960,550, 0);
		div.drawImage(Settings.imagesPath + backgroundBottomImageFileName, 0, height-550, 960, 550, 1);
		for(int i = 550; i < height - 549 ; i+=550){
			div.drawImage(Settings.imagesPath + backgroundMiddleImageFileName, 0, i, 960, 550, 0);
		}
		
		String[] labels = {Index.label,Amanda.label, Bengt.label,Bjorn.label,Carl.label,Christoffer.label,Lizette.label,Information.label,About.label};
		String[] targets = {Index.fileName,Amanda.fileName,Bengt.fileName, Bjorn.fileName,Carl.fileName,Christoffer.fileName,Lizette.fileName,Information.fileName,About.fileName};
		int[] linkTypes = {HtmlUtil.sameWindow,HtmlUtil.sameWindow,HtmlUtil.sameWindow,HtmlUtil.sameWindow,HtmlUtil.sameWindow,HtmlUtil.sameWindow,HtmlUtil.sameWindow,HtmlUtil.sameWindow,HtmlUtil.sameWindow};
		setIndex(targets);
		            //  H   A   B   B   C   C   L   I    O
		int[] widths = {63, 84, 64, 69, 54, 86, 82, 113, 61};

		//draw menu bar

		int x = sumTo(index, widths) + 26;
		int width = widths[index];
		div.drawImage(Settings.imagesPath + highlightShadowLeftFileName, x, 220, 7, 31, 1);
		div.drawImage(Settings.imagesPath + highlightMiddleFileName, x + 7, 220, width - 14, 31, 1);
		div.drawImage(Settings.imagesPath + highlightShadowRightFileName, x + width - 7, 220, 7, 31, 1);
			
		div.genericStartTag(26, 222, sum(widths), 20, 2);
		

		
		html.setFont("#666666", "helvetica", 3);
		
		column = new Column(html);
		column.startTag();
		for (int i = 0; i < widths.length; i++) {
			column.start(widths[i]);
			if(index == i ) {
				html.setFont("#010101", "helvetica", 3);
			}
			html.writeCenteredTextLink(labels[i], targets[i], linkTypes[i]);
			if(index == i) {
				html.setFont("#666666", "helvetica", 3);
			}
			column.end();
		}
		column.endTag();
		div.genericEndTag();
	}
	
	public void uploadResources(UploadType uploadType){
		ImageLoader.upploadImageResource(backgroundTopImageFileName, uploadType);
		ImageLoader.upploadImageResource(backgroundMiddleImageFileName, uploadType);
		ImageLoader.upploadImageResource(backgroundBottomImageFileName, uploadType);
		
		ImageLoader.upploadImageResource(highlightMiddleFileName, uploadType);
		ImageLoader.upploadImageResource(highlightShadowLeftFileName, uploadType);
		ImageLoader.upploadImageResource(highlightShadowRightFileName, uploadType);
	}
	
	private int sumTo(int index, int[] arrayToSum) {
		int sum = 0;
		for (int i = 0; i < arrayToSum.length; i++) {
			if(i == index)
				return sum;
			sum = sum + arrayToSum[i];
		}
		return sum;
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException{
		GenerateAll.run(GenerateAll.GENERATE_TEST_SITE);
		String command = "cmd /c start " + Settings.testTargetPath + Index.fileName;
		try {
			Runtime.getRuntime().exec(command);
		} catch (IOException ioe) {
			System.out.println("exc");// TODO
		}
	}
}