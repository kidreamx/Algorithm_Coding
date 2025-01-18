import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] result = new int[T];
        for(int i=0;i<T;i++){
            String[] sa = br.readLine().split(" ");
            int A = Integer.parseInt(sa[0]);
            int B = Integer.parseInt(sa[1]);
            int min = Math.min(A,B);
            int num=1;
            for(int j=1;j<=(min);j++){
                if((A%j) == 0 && (B%j) ==0){
                    num = j;
                }
            }
            result[i] = num *(A/num) *(B/num);
            
        }
        for(int i=0;i<T;i++){
            System.out.println(result[i]);
        }
    }
}
