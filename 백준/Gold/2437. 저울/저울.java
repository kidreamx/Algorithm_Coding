import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        String[] sa = br.readLine().split(" ");
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(sa[i]);
        }
        Arrays.sort(arr);
        int std = 1;
        for(int i=0;i<N;i++){
            if(arr[i]>std){
                break;
            }
            std +=arr[i];
        }
        System.out.println(std);

    }
}