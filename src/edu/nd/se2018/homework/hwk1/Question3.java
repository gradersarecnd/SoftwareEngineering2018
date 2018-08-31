package edu.nd.se2018.homework.hwk1;

public class Question3 {
	
	public Question3(){}	
	
    public int getMirrorCount(int[] numbers){
    	if (numbers.length <= 1)
    		return numbers.length;

    	int start = 0;
    	int kernel = numbers.length + 1;
    	StringBuilder builder = new StringBuilder();
    	for (int i : numbers) {
    		builder.append(i);
    	}
    	String strNumbers = builder.toString();
    	while (kernel != 0) {
    		int end = start + kernel - 1;
    		while (end != numbers.length + 1) {
    			StringBuilder sb = new StringBuilder(strNumbers);
    			if (strNumbers.substring(start, end).equals(sb.reverse().substring(start,end)))
    				return strNumbers.substring(start, end).length();
    		
    			start += 1;
    			end += 1;
    		}
    		start = 0;
    		kernel -= 1;
    	}
		return 1;
	}
}
