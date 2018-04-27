package missingInt;

class Solution {
	
    public int solution(int N) {
        // write your code in Java SE 8
    	int maxGaps = 0;
    	int leftIndex = -1;
    	boolean searchForZero = true;
    	String bin = Integer.toBinaryString(N);
    	for (int i = 0; i < bin.length(); i++) {
    		if (searchForZero) {
	    		if (bin.charAt(i) == '0') {
	    			leftIndex = i;
	    			searchForZero = false;
	    		}
    		} else {
    			if (bin.charAt(i) == '1') {
    				int zeroes = i-leftIndex;
    				if (zeroes > maxGaps)
    					maxGaps = zeroes;
    				
    				searchForZero = true;
    			}
    		}
    	}
    	return maxGaps;
    	
    }
}