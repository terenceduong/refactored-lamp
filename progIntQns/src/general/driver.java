package general;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class driver {
	public static void main(String args[]) {
//		frequent(new int[]{1,2,3,4,5,6,1,5,5,5,5,3,4,5,2,2,9,6,6,7,7,4,3,2,2,1,1});
//		tens(new int[] {1,2,3,4,5,6,7,8,9});
//		rotated(new int[] {1,2,3,5,6,7,8}, 3);
//		System.out.println(fibIT(10));
//		System.out.println(fibREC(10));
//		System.out.println(fibDPDriver(10));
//		once(new int[] {1,2,1,2,3,4,4,2,5,6,7,5,3,6});
//		dup(new int[] {1,2,3,9,100}, new int[] {1,4,2,3,4,5,6,7,8,9});
//		System.out.println(bin(new int[] {1,2,3,4,5,6,7,8,9,11,13,14,15,16,79,99,203,495}, 13));
		printArray(unrot(new int[] {5,6,7,8,1,2,3}));
		
	}
	
	// Implement binary search in a rotated array (ex. {5,6,7,8,1,2,3})
	static int[] unrot(int[] ar) {
		int pivot = -1;
		for (int i = 0; i < ar.length - 1; i++) {
			if (ar[i] > ar[i+1])
				pivot = i+1;
		}
		
		int[] out = new int[ar.length];
		int outPointer = 0;
		for (int i = pivot; i < ar.length; i++) {
			out[outPointer] = ar[i];
			outPointer++;
		}
		for (int i = 0; i < pivot; i++) {
			out[outPointer] = ar[i];
			outPointer++;
		}
		
		return out;
			
	}
	
	
	// Implement binary search of a sorted array of integers
	static int bin(int[] ar, int target) {
		int index = -1;
		int L = 0, R = ar.length - 1;
		int M;
		
		while (1==1) {
			
			for (int i = L; i <= R; i++) {
				System.out.print(ar[i] + ",");
			}
			System.out.println();
			if (L > R)
				return -1;
			else {
				M = (L+R)/2;
			}
			
			if (target < ar[M]) {
				R = M - 1;
			} else if (target > ar[M]) {
				L = M + 1;
			} else {
				return M;
			}
		}
		
//		return index;
	}
	
	// Find the common elements of 2 int arrays
	static ArrayList<Integer> dup(int[] ar1, int[] ar2) {
		ArrayList<Integer> ar = new ArrayList<Integer>();
		for (int i = 0; i < ar1.length; i++) {
			for (int j = 0; j < ar2.length; j++) {
				if (ar1[i] == ar2[j])
					ar.add(ar1[i]);
			}
		}
		
		printArray(ar);
		return ar;
	}
	
	// Find the only element in an array that only occurs once.
	static int once(int[] ar) {
		boolean single = false;
		int pointer = 0;
		while (!single) {
			single = true;
			for (int i = 0; i < ar.length; i++) {
				if (i != pointer && ar[i] == ar[pointer])
					single = false;
			}
			
			if (!single)
				pointer++;
		}
		System.out.println(ar[pointer]);
		return ar[pointer];
	}
	
	
	
	
	// Write fibbonaci iteratively and recursively 
	// (bonus: use dynamic programming)
	static int fibIT(int n) {
		int lastVal = 0;
		int currentVal = 1;
		int temp;
		
		if (n != 1) {
			for (int i = 1; i < n; i++) {
				temp = currentVal;
				currentVal += lastVal;
				lastVal = temp;
			}
		}
		return currentVal;
	}
	
	static int fibREC(int n) {
		if (n == 0)
			return 0;
		else if (n == 1)
			return 1;
		else {
			return (fibREC(n-1) + fibREC(n-2));
		}
	}
	
	

	
	static ArrayList<Integer> cache = new ArrayList<Integer>();
	static int fibDPDriver(int n) {
		cache.add(0);
		cache.add(1);
		return fibDP(n);
	}
	
	static int fibDP(int n) {
		if (n < cache.size())
			return (cache.get(n));
		else {
			cache.add(fibDP(n-2) + fibDP(n-1));
			printArray(cache);
		}
		
		return cache.get(n);
	}
	
	static void printArray(ArrayList<Integer> ar) {
		String space = "";
		for (int i = 0; i < ar.size(); i++) {
			System.out.print(space + ar.get(i));
			space = ", ";
		}
		System.out.println();
	}
	static void printArray(int[] ar) {
		String space = "";
		for (int i = 0; i < ar.length; i++) {
			System.out.print(space + ar[i]);
			space = ", ";
		}
		System.out.println();
	}
	// Given 2 integer arrays, determine of the 2nd array is a rotated 
	// version of the 1st array. Ex. Original Array A={1,2,3,5,6,7,8} 
	// Rotated Array B={5,6,7,8,1,2,3}
	
	static int[] rotated(int[] ar, int pivot) {
		int[] out = new int[ar.length];
		
		int pointer = 0;
		for (int i = pivot; i < ar.length; i++) {
			out[pointer] = ar[i];
			pointer++;
		}
		for (int i = 0; i < pivot; i++) {
			out[pointer] = ar[i];
			pointer++;
		}
		
		String space = "";
		for (int i = 0; i < ar.length; i++) {
			System.out.print(space + ar[i]);
			space = ", ";
		}
		System.out.println();
		
		space = "";
		for (int i = 0; i < out.length; i++) {
			System.out.print(space + out[i]);
			space = ", ";
		}
		System.out.println();
		return out;
	}
	
	
	// find pairs in an integer array whose sum is equal to 10 
	// (bonus: do it in linear time)
	static ArrayList<Pair> tens(int[] ar) {
		ArrayList<Pair> pairs = new ArrayList<Pair>();
		
		int currentValue;
		int otherValue;
		for (int i = 0; i < ar.length; i++) {
			currentValue = ar[i];
			for (int j = i; j < ar.length; j++) {
				otherValue = ar[j];
				if (currentValue + otherValue == 10)
					pairs.add(new Pair(currentValue, otherValue));
			}
		}
		
		String space = "";
		for (int i = 0; i < pairs.size(); i++) {
			System.out.print(space + pairs.get(i).toString());
			space = ", ";
		}
		
		System.out.println();
		return pairs;
	}
	
	static class Pair {
		int x;
		int y;
		
		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public String toString() {
			return String.format("(%d, %d)", x, y);
		}
	}
	
	// find the most frequent integer in an array
	static int frequent(int[] ar) {
		if (ar.length == 0)
			return Integer.MAX_VALUE;
		
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < ar.length; i++) {
			if(map.containsKey(ar[i])) {
				map.put(ar[i], map.get(ar[i]) + 1);
			}
			else {
				map.put(ar[i], 1);
			}
			
			
		}
		
		int maxFreq = 0;
		int result = ar[0];
		for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
			if (entry.getValue() > maxFreq) {
				maxFreq = entry.getValue();
				result = entry.getKey();
			}
		}
		
		System.out.println(map.toString());
		System.out.println(result);
		return result;
	}
	
}

