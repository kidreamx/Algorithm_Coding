import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int []result = new int[1000001];
        result[1] = 0;
        result[2] = 1;
        result[3] = 1;
        int sum=0;
        for(int i=4;i<=N;i++){
            if(i%3==0 && i%2==0){
                result[i]= Math.min(result[i/3],result[i/2])+1;
            }
            else if(i%3 == 0){
                result[i] = Math.min(result[i/3],result[i-1])+1;
            }
            else if(i%2 == 0){
                result[i] = Math.min(result[i/2],result[i-1])+1;
            }
            else{
                result[i] = result[i-1]+1;
            }

        }
        System.out.println(result[N]);
    }
}