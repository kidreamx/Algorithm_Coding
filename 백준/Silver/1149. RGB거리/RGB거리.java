import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] rgb = new int[N][3];
        final int red = 0;
        final int green = 1;
        final int blue = 2;
        for(int i=0;i<N;i++){
            String[] sa = br.readLine().split(" ");
            rgb[i][red] = Integer.parseInt(sa[0]);
            rgb[i][green] = Integer.parseInt(sa[1]);
            rgb[i][blue] = Integer.parseInt(sa[2]);
        }
        for(int i=1;i<N;i++){
            rgb[i][red] += Math.min(rgb[i-1][green], rgb[i-1][blue]);
            rgb[i][green] += Math.min(rgb[i-1][red], rgb[i-1][blue]);
            rgb[i][blue] += Math.min(rgb[i-1][red], rgb[i-1][green]);
        }
        System.out.println(Math.min(Math.min(rgb[N-1][red],rgb[N-1][blue]),rgb[N-1][green]));

    }
}