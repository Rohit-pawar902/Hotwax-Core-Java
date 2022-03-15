


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


public class CountWordFromUrl {

	public static String getUrlData(String url) {
		Document doc = null;
		String data="";
		try {
				doc = Jsoup.connect(url).get();
			    data =doc.text();
//			    System.out.println(data);
		}catch(IOException e){
			e.printStackTrace();
		}
		
		return data;
	} 

	public static void main(String[] args) {
	  try {
			BufferedReader readingUrls = new BufferedReader(new FileReader("urls.txt"));
			BufferedReader readingWords = new BufferedReader(new FileReader("words.txt"));
			String urlsList[]=readingUrls.readLine().split(",");
			String wordsList[]=readingWords.readLine().split(",");
			
			for(String url: urlsList) {
//				System.out.print(url);
				String urlData=getUrlData(url);
				System.out.println(urlData+"\n++++++++++++++++++++++++++++++++++++++++++++");
//				findFrequencyOfWords(wordList,urlData);
			}
				
		System.out.println("done...");	
	  } catch (IOException e) {
		  System.out.println("hello");
		  e.printStackTrace();
	  } 

	}

}
