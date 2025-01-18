import java.io.*;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int count=0;
        int first , second, third;
        for(int i=1;i<=N;i++){
            if(i<100){
                count++;
            }
            else {
                first = i/100;
                second = (i/10)%10;
                third = (i%100)%10;
                if((first-second) == (second - third)){
                    count++;
                }
            }
        }
        bw.write(count+"");
        br.close();
        bw.flush();
        bw.close();
    }


}
