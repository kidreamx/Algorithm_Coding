import java.io.*;
import java.text.NumberFormat;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] sa = br.readLine().split(" ");
        int N = Integer.parseInt(sa[0]);
        int M = Integer.parseInt(sa[1]);
        int[] arr = new int[N];
        int diff = Integer.MAX_VALUE;
        int correct=0;
        sa = br.readLine().split(" ");
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(sa[i]);
        }
        for(int i=0;i<N-2;i++){
            for(int j=i+1;j<N-1;j++){
                for(int k=j+1;k<N;k++){
                    if(diff > (Math.abs(M - (arr[i]+arr[j]+arr[k]))) && M >= arr[i]+arr[j]+arr[k]){
                        diff =  Math.abs(M - (arr[i]+arr[j]+arr[k]));
                        correct = arr[i]+arr[j]+arr[k];
                    }
                }
            }
        }
        bw.write(correct+"");
        bw.flush();
        bw.close();
    }


}
