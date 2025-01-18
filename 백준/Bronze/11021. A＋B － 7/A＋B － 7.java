import java.util.*;
import java.io.*;
import java.math.*;

public class Main  {
	
	public static void main(String[] args)  throws Exception {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		int[] sum = new int[T];
		for(int i=0;i<T;i++) {
			int x = scanner.nextInt();
			int y = scanner.nextInt();
			sum[i] = x+y;
		}
		for(int i=1;i<=T;i++) {
			System.out.println("Case #"+i+": "+sum[i-1]);
		}
			
		
		
	}
}
