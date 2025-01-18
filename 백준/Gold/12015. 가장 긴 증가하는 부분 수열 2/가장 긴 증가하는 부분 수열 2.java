import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] lts = new int[N];
        String[] sa = br.readLine().split(" ");
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(sa[i]);
        }
        lts[0] = arr[0];
        int result = 1;
        for(int i = 1; i < N; i++) {
            int key = arr[i];
            if(lts[result - 1] < key){
                lts[result] = key;
                result++;
            }
            else{
                int lo = 0;
                int hi = result;
                while(lo < hi){
                    int mid = (lo + hi)/2;
                    if(lts[mid] < key){
                        lo = mid + 1;
                    }
                    else{
                        hi = mid;
                    }
                }
                lts[lo] = key;
            }

        }
        bw.write(result+"");
        bw.flush();
        bw.close();

    }

}

