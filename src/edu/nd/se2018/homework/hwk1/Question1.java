package edu.nd.se2018.homework.hwk1;

import java.util.HashSet;
import java.util.Set;

public class Question1 {
		
	public Question1(){}
	
	public int getSumWithoutDuplicates(int[] numbers){
		Set<Integer> set = new HashSet<Integer>();
		//put numbers into hashset to get rid of duplicates
		for(int i: numbers) {
			set.add(i);
		}
		int sum = 0;
		//add up the numbers
		for(int i: set) {
			sum += i;
		}

		return sum;	
	}
}
