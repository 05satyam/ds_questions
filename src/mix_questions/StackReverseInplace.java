package mix_questions;

import java.util.Stack;

public class StackReverseInplace {

	public static void reverse() {
		Stack<Integer> s= new Stack<Integer>();
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		s.push(5);
		s.push(6);
		s.push(7);
		s.push(8);
		r1(s);
		System.out.println("reverse print");
		s.forEach(System.out::println);
		
	}
	  public static void r1(Stack<Integer> s) {
	        if(s.isEmpty())return;
	       
	        int a = s.peek();
	        s.pop();
	        r1(s);
	        //s.push(a);
	        r2(s,a);
	       
	       
	    }
	    public static void  r2(Stack<Integer> s, int a) {
	        if(s.isEmpty()) {
	            s.push(a);
	            return;
	        }
	        int a1= s.peek();
	        s.pop();
	        r2(s,a);
	        s.push(a1);
	    }
	public static void main(String[] args) {
		reverse();
	}

}
