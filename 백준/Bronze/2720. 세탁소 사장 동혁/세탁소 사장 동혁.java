import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T= Integer.parseInt(br.readLine());
		int[] quter = new int[T];
		int[] daim = new int[T];
		int[] nikal = new int[T];
		int[] peny = new int[T];
		for(int i=0;i<T;i++) {
			int money = Integer.parseInt(br.readLine());
			quter[i] = money/25;
			money = money%25;
			daim[i] = money/10;
			money = money%10;
			nikal[i] = money/5;
			money = money%5;
			peny[i] = money/1;
			
		}
		for(int i=0;i<T;i++) {
			System.out.println(quter[i]+" "+daim[i]+" "+nikal[i]+" "+peny[i]);
		}
	}
}