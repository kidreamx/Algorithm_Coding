import java.util.*;
import java.io.*;

public class Main {
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int sum = 0;
		int line = 2;
		for(int i=0;i<N;i++){
			line = line + line-1;
		}
		sum = line*line;
		System.out.println(sum);
		
	}
}