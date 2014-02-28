package com.roberthelmbro.billigtrubadur.uploadutil;

import java.io.IOException;

import com.roberthelmbro.billigtrubadur.pages.About;
import com.roberthelmbro.billigtrubadur.pages.Amanda;
import com.roberthelmbro.billigtrubadur.pages.Bengt;
import com.roberthelmbro.billigtrubadur.pages.Bjorn;
import com.roberthelmbro.billigtrubadur.pages.Christoffer;
import com.roberthelmbro.billigtrubadur.pages.Elin;
import com.roberthelmbro.billigtrubadur.pages.Index;
import com.roberthelmbro.billigtrubadur.pages.Information;
import com.roberthelmbro.billigtrubadur.pages.Lizette;
import com.roberthelmbro.billigtrubadur.pages.Carl;
import com.roberthelmbro.billigtrubadur.uploadutil.ImageLoader.UploadType;

import r.fileutil.DirectoryUtil;

public class GenerateAll {
	
	public final static int GENERATE_TEST_SITE = 0;
	public final static int PUBLISH = 1;

	public static void run(int mode) {
		
		String targetPath;
		UploadType uploadType;
		
		if(mode == GENERATE_TEST_SITE){
			targetPath = Settings.testTargetPath;
			uploadType = UploadType.TEST;
			
		}else if (mode == PUBLISH){
			targetPath = Settings.publishTargetPath;
			uploadType = UploadType.PUBLISH;
		}
		else{
			throw new IllegalArgumentException();
		}

		Index index = new Index();
		Amanda amanda = new Amanda();
		Bengt bengt = new Bengt();
		Bjorn bjorn = new Bjorn();
		Christoffer christoffer = new Christoffer();
		Lizette lizette = new Lizette();
		Elin elin = new Elin();
		//Oscar modell = new Oscar();
		Carl robert = new Carl();
		//Football football = new Football();
		//Gallery gallery = new Gallery();
		//Find find = new Find();
		//Info info = new Info();
		Information information = new Information();
		About about = new About();

		DirectoryUtil.createFolder(targetPath + Settings.imagesPath);

		if(Settings.upploadResources){
			index.uploadResources(uploadType);
			amanda.uploadResources(uploadType);
			bengt.uploadResources(uploadType);
			elin.uploadResources(uploadType);
			bjorn.uploadResources(uploadType);
			christoffer.uploadResources(uploadType);
			lizette.uploadResources(uploadType);
			//modell.uploadResources(uploadType);
			robert.uploadResources(uploadType);
			//football.uploadResources();
			//gallery.uploadResources();
			//find.uploadResources();
			//info.uploadResources(uploadType);
			information.uploadResources(uploadType);
			about.uploadResources(uploadType);
		}

		try{
			index.generateFile(targetPath);
			amanda.generateFile(targetPath);
			bengt.generateFile(targetPath);
			elin.generateFile(targetPath);
			bjorn.generateFile(targetPath);
			christoffer.generateFile(targetPath);
			lizette.generateFile(targetPath);
			//modell.generateFile(targetPath);
			robert.generateFile(targetPath);
			//football.generateFile(targetPath);
			//gallery.generateFile(targetPath);
			//find.generateFile(targetPath);
			//info.generateFile(targetPath);
			information.generateFile(targetPath);
			about.generateFile(targetPath);

		}catch(IOException ioe){ioe.printStackTrace();}
		
		SystemUtil.open(targetPath + Index.fileName);
		

		

		System.out.println("Done");
	}


	public static void main(String argd[]){

		run(GENERATE_TEST_SITE);
	}
}
