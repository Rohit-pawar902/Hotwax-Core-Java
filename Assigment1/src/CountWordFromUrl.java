


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


public class CountWordFromUrl {

	public static String getUrlData(String url) {
		Document doc = null;
		String data="";
		try {
				doc = Jsoup.connect(url).get();
			    data =doc.text();
		}catch(IOException e){
			e.printStackTrace();
		}
		
		return data;
	} 

//Counting frequency of wordlist data
	public static void findFrequencyOfWords(String []wordList,String urlData){
		TreeMap<String,Integer> wordsFrequency =new TreeMap<>();
        
		//urlData Splitted on comma and space	  	
		String allDataWords[] = urlData.split(",| ");

        //Key-wordList,value-frequency of them initialy set to 0 
		for(String word:wordList) {
			wordsFrequency.put(word,0);
		}
		
	    // updating frequency
		for(String urlWord:allDataWords) {
			if(wordsFrequency.containsKey(urlWord)) {
				wordsFrequency.put(urlWord,wordsFrequency.get(urlWord)+1);
			} 
		}
		
		//Sorting on the Frequency
		Set<Entry<String,Integer>> entries = wordsFrequency.entrySet();
		ArrayList<Entry<String,Integer>> arr = new ArrayList<>(entries);
		Collections.sort(arr,(e1,e2)->{
			return e2.getValue()-e1.getValue();
		});
		
		System.out.println("Word Frequency on URl-->"+arr);
	}
	public static void main(String[] args) {
	  try {
			BufferedReader readingUrls = new BufferedReader(new FileReader("urls.txt"));
			BufferedReader readingWords = new BufferedReader(new FileReader("words.txt"));
			String urlsList[]=readingUrls.readLine().split(",");
			String wordsList[]=readingWords.readLine().split(",");
			
			for(String url: urlsList) {
				System.out.println("Url -> "+url);
				String urlData=getUrlData(url);
				System.out.println("\nURL Data --> "+urlData+"\n");
				findFrequencyOfWords(wordsList,urlData);
				System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			}
				
		System.out.println("done...");	
	  } catch (IOException e) {
		  System.out.println("hello");
		  e.printStackTrace();
	  } 

	}

}
