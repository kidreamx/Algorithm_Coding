import java.util.*;
import java.io.*;
import java.math.*;

public class Main  {
	
	
	public static void main(String[] args)  throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		int degree_1;
		int degree_2;
		int degree_3 ;
		int max=0, max_index=0;
		for(int i=0;i<T;i++) {
			max = 0;
			max_index = 0;
			String[] sa = br.readLine().split(" ");
			degree_1 = Integer.parseInt(sa[0]);
			if(max<degree_1) {
				max = degree_1;
				max_index = 1;
			}
			degree_2 = Integer.parseInt(sa[1]);
			if(max<degree_2) {
				max = degree_2;
				max_index = 2;
			}
			 degree_3 = Integer.parseInt(sa[2]);
			 if(max<degree_3) {
					max = degree_3;
					max_index = 3;
				}
			 String s = "";
			 {
				 
				 
					 if(max_index==3) {
						 if(max >= degree_1 + degree_2) {
							 s = "invalid!";
						 }
						 else {
							 if(degree_1 == degree_2  && degree_2 == degree_3 && degree_3 == degree_1) {
									s = "equilateral";
							 }
							 else if(degree_1 == degree_2  || degree_2 == degree_3 || degree_3 == degree_1) {
									s = "isosceles";
							}
							 else {
								 s= "scalene";
							 }
						 }
					 }
					 else if(max_index==2) {
						 if(max >= degree_1 + degree_3) {
							 s = "invalid!";
						 }
						 else {
							 if(degree_1 == degree_2  && degree_2 == degree_3 && degree_3 == degree_1) {
									s = "equilateral";
							 }
							 else if(degree_1 == degree_2  || degree_2 == degree_3 || degree_3 == degree_1) {
									s = "isosceles";
							}
							 else {
							 s= "scalene";
							 }
						 }
					 }
					 else if(max_index==1) {
						 if(max >= degree_2 + degree_3) {
							 s = "invalid!";
						 }
						 else {
							 if(degree_1 == degree_2  && degree_2 == degree_3 && degree_3 == degree_1) {
									s = "equilateral";
							 }
							 else if(degree_1 == degree_2  || degree_2 == degree_3 || degree_3 == degree_1) {
									s = "isosceles";
							}
							 else {
								 s= "scalene";
							 }
						 }
					 }
					 else {
						 s = "scalene";
					 }
				 }
			 
			 bw.write("Case #"+(i+1)+": "+  s+"\n");
		}
		
		br.close();
		bw.flush();
		bw.close();
		
		
	}
}
