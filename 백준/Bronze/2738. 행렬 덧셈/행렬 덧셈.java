import java.io.*;
import java.util.*;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = br.readLine().split(" ");
        int N = Integer.parseInt(sa[0]);
        int M = Integer.parseInt(sa[1]);
        int[][] arr = new int[N][M];
        for(int i=0;i<N;i++){
            sa = br.readLine().split(" ");
            for(int j=0;j<M;j++){
                arr[i][j] = Integer.parseInt(sa[j]);
            }
        }
        for(int i=0;i<N;i++){
            sa = br.readLine().split(" ");
            for(int j=0;j<M;j++){
                arr[i][j] += Integer.parseInt(sa[j]);
            }
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}

