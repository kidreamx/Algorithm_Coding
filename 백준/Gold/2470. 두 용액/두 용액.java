import java.util.*;
import java.io.*;

public class Main{
    static int N;
    static long result;
    static long answer1,answer2;
    static long[] fluid;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input(br);
        binarySearch();
        System.out.println(answer1+" "+answer2);
    }
    static void input(BufferedReader br) throws IOException{
        N = Integer.parseInt(br.readLine());
        fluid = new long[N];
        String[] sa = br.readLine().split(" ");
        for(int i=0;i<N;i++){
            fluid[i] = Integer.parseInt(sa[i]);
        }
        Arrays.sort(fluid);
    }
    static void binarySearch(){
        int start = 0;
        int end = N-1;
        result = Math.abs(fluid[start] + fluid[end]);
        answer1 = fluid[start];
        answer2 = fluid[end];
        while(start<end){
            if(result> Math.abs(fluid[start]+fluid[end])){
                result = Math.abs(fluid[start]+fluid[end]);
                answer1 = fluid[start];
                answer2 = fluid[end];
            }
            if(fluid[start]+fluid[end]<0){
                start++;
            }else{
                end--;
            }
        }
    }
}