package leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WhatsTheSum {

	public static void main(String[] args) throws NumberFormatException, IOException {
		//Scanner sc =new Scanner(System.in);
		BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
	      
		int t= Integer.parseInt(reader.readLine());
		int sum=0;
		while(t>0) {
			sum=0;
			int n= Integer.parseInt(reader.readLine());
			Map<Integer, Integer> mp = new HashMap<Integer, Integer>();
			while(n>0) {
				int a= Integer.parseInt(reader.readLine());
				int b= Integer.parseInt(reader.readLine());
				if(a>8)
					mp.put(a, 0);
				else {
					int get= mp.get(a)==null?0:mp.get(a);
					if(get<b) {
						sum=sum-get;
						sum=sum+b;
						mp.put(a, b);
					}
				}
				
			n--;	
			}
			
			t--;
			System.out.println(sum);
		}
	}

}
