package stackqheap;

import java.util.ArrayList;

public class Queue<T> {
	ArrayList<T> data;
	
	Queue() {data = new ArrayList<T>();}
	
	void queue(T a) {
		data.add(0, a);
	}
	
	T dequeue() {
		if (data.size() > 0)
			return data.remove(data.size() - 1);
		else 
			return null;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		String space = "";
		
		for (int i = 0; i < data.size(); i++) {
			sb.append(space + data.get(i));
			space = ", ";
		}
		
		return sb.toString();
	}
}
