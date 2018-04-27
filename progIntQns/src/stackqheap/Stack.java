package stackqheap;

import java.util.ArrayList;

public class Stack<T> {
	ArrayList<T> data;
	Stack() {
		data = new ArrayList<T>();
	}
	
	void push(T a) {
		data.add(a);
	}
	
	T pop() {
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
