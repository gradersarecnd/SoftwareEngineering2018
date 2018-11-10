package edu.nd.se2018.homework.hwk1;
public class Question3 {
	
	public Question3(){}	
	
    public int getMirrorCount(int[] numbers){
    	int mirrorCount = 1;
    	boolean isDone = false;
        //return 0 if len is 0
    	if (numbers.length == 0) return 0;
    	//iterate through the array with temp count
        for (int i = 0; i<numbers.length; i++){
            int temp = 1;
            int count = i;
            //closing in from the end
            for (int j = numbers.length-1; j>= 0 && (count<numbers.length); j--){
                if (!isDone && numbers[count] == numbers[j]){
                    isDone = true;
                    count++;
                    continue;
                }
                if (isDone && numbers[count] == numbers[j]){
                    temp++;
                    count++;
                    if (temp>mirrorCount) {
                    	mirrorCount = temp;
                    }
                    continue;
                }
                if (isDone && numbers[i] != numbers[j] ){
                    isDone = false;
                    count = i;
                    temp = 1;
                    continue;
                }
                if (j == count || (j-count)==1){
                    isDone = false;
                    break;
                }
            }
        }
        return mirrorCount;   
	}
}
