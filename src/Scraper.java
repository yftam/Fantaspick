
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class Scraper {
	File file;
	PrintWriter printwrite;
	int scrapCounter;

	
	
	public void createFile(String dirName, String fileName) throws IOException{
		file = new File(dirName + "/" +fileName);
		file.getParentFile().mkdirs();
		file.createNewFile();			
	}

	public void openFile(String fileName) throws IOException {
		printwrite = new PrintWriter(new FileOutputStream (new File(fileName),true));
		
	}


	public void closeFile() throws IOException {
		printwrite.close();
	}


	public void startScrape(String url) throws Exception {

		final Document document = Jsoup.connect(url).get();		
		Elements elements = document.select("div#zg_centerListWrapper");		
		for(Element element : elements.select("div.zg_itemImmersion")) {				
			for(Element subelement1 : element.select("div.zg_itemWrapper")) {
				String itemImgURL = subelement1.select("div.a-section img").attr("src");// image
				String itemID = subelement1.select("div.a-section a.a-link-normal").attr("href");// itemID
				String itemName = subelement1.select("div.p13n-sc-truncate").text();// name
				String itemRating = subelement1.select("div.a-icon-row a").attr("title");// rating		
				String itemPrice = subelement1.select("div.a-row span.p13n-sc-price").text();// price
				String itemReviewTimes = subelement1.select("div.a-icon-row a.a-size-small").text();// Number of Reviews
				String itemPrime = subelement1.select("div.a-row i").attr("aria-label");// Prime?
				printwrite.println(new Date().toString()+";"+itemName+";"+itemRating+";"+itemPrice+";"+itemReviewTimes+";"+itemPrime+itemID+itemImgURL);
				System.out.println(new Date().toString()+";"+itemID+";"+itemName);
			}
		}
	}



}// end class
