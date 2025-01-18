import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s1 = br.readLine();
        char[] chars1 = s1.toCharArray();
        String s2 = br.readLine();
        char[] chars2 = s2.toCharArray();
        int max=0;
        int[][] lcs = new int[s1.length()+1][s2.length()+1];
        for(int i=1;i<=s1.length();i++){
            for(int j=1;j<=s2.length();j++){
                if(chars1[i-1]==chars2[j-1]){
                    lcs[i][j] = lcs[i-1][j-1]+1;
                    if(max<lcs[i][j]){
                        max = lcs[i][j];
                    }
                }
                else{
                    lcs[i][j] = 0;
                }
            }
        }
        bw.write(max+"");


        br.close();
        bw.flush();
        bw.close();

    }

}
