import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = br.readLine().split(" ");
        int N = Integer.parseInt(sa[0]);
        int S = Integer.parseInt(sa[1]);
        int[] num =  new int[N];
        sa = br.readLine().split(" ");
        for(int i=0;i<N;i++){
            num[i] = Integer.parseInt(sa[i]);
        }
        int minLength=Integer.MAX_VALUE;
        int start = 0;
        int end = 1;
        if(num[start]>=S){
            minLength = 1;
        }
        int sum = num[start]+num[end];
        int sumlength=2;

        while(true){
            if(sum>=S){
                minLength = Math.min(minLength,sumlength);
                while(start<=end){
                    sum = sum-num[start];
                    if(sum>=S){
                        sumlength--;
                        minLength= Math.min(minLength,sumlength);
                        start++;
                    }else{
                        sum = sum+num[start];
                        break;
                    }
                }
            }
            end++;
            if(end==N){
                break;
            }
            sum+= num[end];
            sumlength++;

        }
        if(minLength== Integer.MAX_VALUE){
            System.out.println(0);
        }
        else {
            System.out.println(minLength);
        }
    }
}