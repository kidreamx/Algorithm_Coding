import java.io.*;
import java.util.*;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] arr = new int[9][9];
        int max=0;
        int max_r=1,max_l=1;
        for(int i=0;i<9;i++){
            String[] sa = br.readLine().split(" ");
            for(int j=0;j<9;j++) {
                if (max < Integer.parseInt(sa[j])) {
                    max = Integer.parseInt(sa[j]);
                    max_r = i+1;
                    max_l = j+1;
                }
            }
         }

        System.out.println(max);
        System.out.println(max_r+" "+max_l);
    }
}

