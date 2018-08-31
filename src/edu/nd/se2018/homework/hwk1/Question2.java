package edu.nd.se2018.homework.hwk1;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Question2 {

	public Question2(){}
	
	public String getMostFrequentWord(String input, String stopwords){
		Map<String, Integer> m = new HashMap<String, Integer>();
		Set<String> stopWords = new HashSet<String>();
		String[] inputArr = input.split("\\s+");
		String[] stopwordsArr = stopwords.split("\\s+");
		String frequentWord = "";
		int maxcount = 0;
		int maximum = 0;
		
		for (String sw : stopwordsArr)
			stopWords.add(sw);
		for (String word : inputArr) {
			if (!Arrays.asList(stopwordsArr).contains(word)) {
				if (m.get(word) == null)
					m.put(word, 1);
				else
					m.put(word, m.get(word) + 1);
			}
		}
		if (m.isEmpty())
			return null;
		maximum = Collections.max(m.values());
		for (Entry<String, Integer> entry : m.entrySet()) {
			if (entry.getValue() == maximum) {
				maxcount += 1;
				frequentWord = entry.getKey();
				if (maxcount > 1)
					return null;
			}
		}
		return frequentWord;
	}
}
