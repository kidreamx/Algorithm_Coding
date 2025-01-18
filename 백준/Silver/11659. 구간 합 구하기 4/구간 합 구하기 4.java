import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] sa = br.readLine().split(" ");
        int N = Integer.parseInt(sa[0]);
        int M = Integer.parseInt(sa[1]);
        int[] arr= new int[N];
        sa = br.readLine().split(" ");
        for(int i=0;i<N;i++){
            if(i==0) {
                arr[i] = Integer.parseInt(sa[i]);
            }
            else{
                arr[i] = Integer.parseInt(sa[i])+arr[i-1];
            }

        }
        for(int i=0;i<M;i++){
            sa = br.readLine().split(" ");
            int result=0;
            if(Integer.parseInt(sa[0])==1){
                result = arr[Integer.parseInt(sa[1])-1];
            }
            else {
                result = arr[Integer.parseInt(sa[1]) - 1] - arr[Integer.parseInt(sa[0]) - 2];
            }
            bw.write(result + "\n");

        }
        bw.flush();
        bw.close();

    }

}

