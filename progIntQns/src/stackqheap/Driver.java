package stackqheap;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> aStack = new Stack<Integer>();
		aStack.push(2);
		aStack.push(29);
		aStack.push(50);
		
		System.out.println(aStack.toString());
		System.out.println(aStack.pop());
		System.out.println(aStack.toString());
	}

}
