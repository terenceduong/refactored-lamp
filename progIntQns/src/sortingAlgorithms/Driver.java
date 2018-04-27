package sortingAlgorithms;

import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import org.junit.jupiter.api.Test;

public class Driver {
	
	public static void main(String[] args) {
		int[] ar = new int[10];
		for(int i = 0; i < ar.length; i++) {
			ar[i] = (int) (Math.random() * 100);
		}
//		bubbleSort(ar);
//		selectionSort(ar);
//		insertionSort(ar);
//		printArray(mergeSort(ar));
//		testMerge1();
		testRotate();
	}	
	
	@Test
	public static void testMerge1() {
		int[] ar = new int[] {10,9,8};
		assertArrayEquals(new int[] {8,9,10}, mergeSort(ar));
		
		for (int i : ar) {
			System.out.println(i);
		}
		
		HashMap<String, ArrayList<String>> a = new HashMap<String, ArrayList<String>>();
		Set<String> b = a.keySet();
		
	}
	
	@Test
	public static void testRotate() {
		int[] ar = new int[] {1,2,3,4};
		assertArrayEquals(new int[] {3,4,1,2}, solution(ar,2));
		assertArrayEquals(new int[] {1,2,3,4}, solution(ar,4));
		assertArrayEquals(new int[] {}, solution(new int[] {},4));
		assertArrayEquals(new int[] {1}, solution(new int[] {1}, 200));
	}
	
    public static int[] solution(int[] A, int K) {
        // write your code in Java SE 8
        if (A.length < 2 || K == 0) {
        } else {
	        int[] newA = new int[A.length];
	        if (K != 0) {
	            newA[0] = A[A.length-1];
	            // System.out.println(A[A.length-1]);
	            for (int i = 1; i < A.length; i++) {
	                newA[i] = A[i-1];
	            }
	            return solution(newA, K-1);
	        }
        }
        return A;
    }
    
    

	
	static int[] mergeSort(int[] ar) {
		printArray(ar);
		if (ar.length < 2)
			//sorted
			return ar;
		else {
			int m = ar.length / 2;
			int[] left = new int[m];
			for (int i = 0; i < m; i++) {
				left[i] = ar[i];
			}
			left = mergeSort(left);
			
			int[] right = new int[ar.length - m];
			for (int i = m; i < ar.length; i++) {
				right[i - m] = ar[i];
			}
			right = mergeSort(right);
			
			return combine(left, right);
		}
	}
	
	static int[] combine(int[] l, int[] r) {
		System.out.println("combine l and r");
		printArray(l);
		printArray(r);
		if (l.length == 0) {
			return r;
		} else if (r.length == 0) {
			return l;
		}
		
		int leftIndex = 0;
		int rightIndex = 0;
		int[] out = new int[l.length + r.length];
		for (int i = 0; i < out.length; i++) {
			if (leftIndex >= l.length) {
				out[i] = r[rightIndex++];
			} else if (rightIndex >= r.length) {
				out[i] = l[leftIndex++];
			} else {
				if (l[leftIndex] > r[rightIndex]) {
					out[i] = r[rightIndex++];
				} else {
					out[i] = l[leftIndex++];
				}
			}
		}
		System.out.println("***out***");
		printArray(out);
		System.out.println();
		return out;
	}
	
	static void insertionSort(int[] ar) {
		printArray(ar);
		
		int currentValue;
		int currentIndex;
		for (int i = 1; i < ar.length; i++) {
			currentValue = ar[i];
			currentIndex = i;
			
			while (currentIndex > 0 && ar[currentIndex-1] > currentValue) {
				ar[currentIndex] = ar[currentIndex-1];
				currentIndex--;
			}
			
			ar[currentIndex] = currentValue;
			printArray(ar);
		}
		
	}
	
	
	static void selectionSort(int[] ar) {
		printArray(ar);
		int min = Integer.MAX_VALUE;
		int minIndex = -1;
		
		for (int i = 0; i < ar.length; i ++) {
			min = Integer.MAX_VALUE;
			minIndex = -1;
			
			for (int j = i; j < ar.length; j++) {
				if (ar[j] < min) {
					min = ar[j];
					minIndex = j;
				}
			}
			
			for (int j = minIndex; j > i; j--) {
				int temp = ar[j];
				ar[j] = ar[j-1];
				ar[j-1] = temp;
			}
			printArray(ar);
		}
	}
	
	static void bubbleSort(int[] ar) {
		printArray(ar);
		boolean sorted = false;
		
		while (!sorted) {
			sorted = true;
			for (int i = 0; i < ar.length - 1; i++) {
				if (ar[i] > ar[i+1]) {
					int temp = ar[i];
					ar[i] = ar[i+1];
					ar[i+1] = temp;
					sorted = false;
					printArray(ar);
				}
			}
		}
	}

	
	static void printArray(int[] ar) {
		String space = "";
		for (int i = 0; i < ar.length; i++) {
			System.out.print(space + ar[i]);
			space = ", ";
		}
		System.out.println();
	}
}
