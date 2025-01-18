import java.util.*;
import java.io.*;
import java.math.*;

public class Main  {
	
	public static void main(String[] args)  throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    int K = Integer.parseInt(br.readLine());
	    int a = 1;
	    int b = 0;
	    for(int i=0;i<K;i++) {
	    	int tmp_a = a;
	    	int tmp_b = b;
	    	for(int k=0;k<tmp_a;k++) {
	    		a--;
	    		b++;
	    	}
	    	for(int k=0;k<tmp_b;k++) {
	    		a++;
	    	}
	    }
	    bw.write(a + " " + b);
		bw.flush();
		bw.close();
			
		
		
	}
}
