import java.io.*;
import java.util.*;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sa =  br.readLine().split(" ");
        char[] B = sa[0].toCharArray();
        int N = Integer.parseInt(sa[1]);
        double result=0;
        for(int i=0;i<B.length;i++){
            double tmp;
            if(B[i]>='A' && B[i]<='Z'){
                tmp =B[i]-'A'+10;
            }
            else{
                tmp = B[i]-'0';
            }
            result+= Math.pow(N,B.length-1-i)*tmp;
        }

        System.out.println((int)result);
    }
}

