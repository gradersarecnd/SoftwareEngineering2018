package edu.nd.se2018.homework.hwk1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;

public class Question2 {

	public Question2(){}
	
	public String getMostFrequentWord(String input, String stopwords){
		//put input words and stop words into list
		String[] inputList = input.split("\\s+");
		String[] stopwordsList = stopwords.split("\\s+");
		//put non stop words into hashmap
		HashMap<String, Integer> map = new HashMap<>();
		for(String word : inputList) {
			if(!Arrays.asList(stopwordsList).contains(word)) {
				if(map.get(word) == null) {
					map.put(word, 1);
				} else {
					map.put(word, map.get(word) + 1);
				}
			}
		}
		//determine the max value
		Entry<String, Integer> maxEntry = null;
		for (Entry<String, Integer> entry : map.entrySet()){
		    if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0){
		        maxEntry = entry;
		    }
		}
		//return null if there are more than one max
		for (Entry<String, Integer> entry : map.entrySet()){
		    if (maxEntry != entry && maxEntry.getValue() == entry.getValue()){
		        return null;
		    }
		}
		//else return the max entry
		return maxEntry.getKey();
	}
}
