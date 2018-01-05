import java.util.Date;

public class Fantaspick {

	public static void main(String[] args) throws Exception {
		String fileName;
		Scraper scrapper = new Scraper();
		long startTime, endTime;
		int scrapCount;

		try {			
			fileName = "Scrape.txt";
			scrapper.createFile("E:\\_GitHub\\Fantaspick", fileName);
			scrapCount =0;
			
			while (true) {
				startTime = System.nanoTime();
				scrapper.openFile(fileName);
				for(int i = 1; i<=5; i++) {
					scrapper.startScrape("https://www.amazon.ca/gp/bestsellers/hi/ref=sv_hi_0#"+i);
				}
				scrapper.closeFile();
				endTime = System.nanoTime();
				System.out.println(new Date().toString()+(endTime-startTime)*0.000000001+" "+ scrapCount++);
				Thread.sleep(30000);		//1000 = 1 second
			
			}//end while
		

		}catch (Exception e) {
			//System.out.println(new Date());
			//System.err.println(e);
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
