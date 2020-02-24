package mix_questions;

import java.util.HashSet;
import java.util.*;

public class BeutifulNumberCodeForces {

	private String getStr(String numS,long n,int k){
		HashSet<Integer>set= new HashSet<Integer>();
	       for (int i = 0; i < numS.length() - k; i++) {
				if ((numS.charAt(i) != numS.charAt(i + k)) && (!set.contains(i))) {
					
					char c1 = numS.charAt(i);
					char c2 = numS.charAt(i + k);
					if (i == 0 && c1 != c2) {
						StringBuilder string = new StringBuilder(numS);
						string.setCharAt(i, c1);
						string.setCharAt(i + k, c1);
						set.add(i);
						set.add(i+k);
						numS = string.toString();
						continue;
					}
					//if(i-k>=0)continue;
					//System.out.println("c1:" + c1);
					char c3 = numS.charAt(i - 1);
					if (c3 > c1) {
						//System.out.println("c3>c1");
						c1 = String.valueOf(((Integer.valueOf(c1) -48) + (Integer.valueOf(c3) -48) + 1)).charAt(0);
					} else {
						//System.out.println("else: "+c1 );
						c1 = String.valueOf(((Integer.valueOf(c1) -48)+ 1)).charAt(0);
					}
					StringBuilder string = new StringBuilder(numS);
					string.setCharAt(i, c1);
					string.setCharAt(i + k, c1);
					numS = string.toString();

				}
				set.add(i);
				set.add(i+k);
				//System.out.println("nums: "+ numS);
			}
			return numS;
	   }
	   public static void main(String[] args){
	       try{
	    	   BeutifulNumberCodeForces test= new BeutifulNumberCodeForces();
	    int k;
	    long n;
	    Scanner sc= new Scanner(System.in);
	    n=sc.nextLong();
	    k=sc.nextInt();
	    String str = sc.next();
	     //System.out.println(str);
	    String res=test.getStr(str,n,k);
	    System.out.println(res.length());
	     System.out.println(res);
	       }catch(Exception e){
	           
	       }
	      
	   }

}
