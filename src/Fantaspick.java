import java.util.Date;
import java.sql.*;

public class Fantaspick {

	public static void main(String[] args) throws Exception {
		String fileName;
		Scraper scrapper = new Scraper();
		long startTime, endTime;
		int scrapCount;
		DBConn dbConn;
		
		dbConn = new DBConn();		
		dbConn.ConnectDB(); // connect to SQL DB
		
		
/*		dbConn.ModDB("DELETE from Amz_Product_Details");
		dbConn.QueryDB("SELECT * from Parameter_Settings");
		dbConn.ModDB("INSERT INTO [dbo].[Parameter_Settings]([parameter_name],[parameter_value],[is_active],[created_by],[created_tms],[updated_by],[updated_tms])\r\n" + 
					"     VALUES ('TEST_INSERT_FROM_CODE5','false',1,'test',GETDATE(),'test',GETDATE())");*/
		
				
		//========================================= Scraping================================================

		try {			
		//	fileName = "Scrape.txt";
		//	scrapper.createFile("E:\\_GitHub\\Fantaspick", fileName);
			scrapCount =0;
			
			//while (true) {
				startTime = System.nanoTime();
				//scrapper.openFile(fileName);
	
					scrapper.startScrapeLvl1("https://www.amazon.ca/gp/new-releases/hi/ref=zg_bs_tab_t_bsnr#1", dbConn);
					scrapper.startScrapeLvl1("https://www.amazon.ca/gp/new-releases/hi/ref=zg_bsnr_pg_2?ie=UTF8&pg=2", dbConn);
					scrapper.startScrapeLvl1("https://www.amazon.ca/gp/new-releases/hi/ref=zg_bsnr_pg_3?ie=UTF8&pg=3", dbConn);
					scrapper.startScrapeLvl1("https://www.amazon.ca/gp/new-releases/hi/ref=zg_bsnr_pg_4?ie=UTF8&pg=4", dbConn);
					scrapper.startScrapeLvl1("https://www.amazon.ca/gp/new-releases/hi/ref=zg_bsnr_pg_5?ie=UTF8&pg=5", dbConn);
	
	//			scrapper.startScrapeLvl2("a", dbConn);
				//scrapper.closeFile();
				endTime = System.nanoTime();
				System.out.println(new Date().toString()+" "+(endTime-startTime)*0.000000001+" "+ scrapCount++);
			//	Thread.sleep(3000);		//1000 = 1 second
			
			//}//end while
		

		}catch (Exception e) {
			e.printStackTrace();
		}

		


	}//end main

	


}//end class





/*		===Example===
 * final Document document = Jsoup.connect("http://www.imdb.com/chart/top").get(); // URL
//System.out.println(document.outerHtml()); // html code of whole site	

for(Element row : document.select("table.chart.full-width tr")) {			
	final String title = row.select(".titleColumn").text();
	final String rating = row.select(".imdbRating").text();			
	System.out.println(title + " -> "+ rating);
}
 */		

//final Document document = Jsoup.connect("https://www.amazon.ca/gp/bestsellers/hi/ref=sv_hi_0").get();		
//Elements elements = document.select("div#zg_centerListWrapper");
//for(Element element : elements.select("div.zg_itemImmersion")) {	
//	String itemInfo = element.select("div.zg_itemWrapper").text();
//	System.out.println(itemInfo);
//
//
//}
