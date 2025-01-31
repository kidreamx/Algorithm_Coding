import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] chars = br.readLine().toCharArray();
        int N =Integer.parseInt(br.readLine());
        int[][] alpha = new int[chars.length][26];
        for(int i=0;i<chars.length;i++){
            if(i==0) alpha[i][chars[i]-'a']++;
            else alpha[i][chars[i]-'a'] = alpha[i-1][chars[i]-'a']+ 1;
            for(int j=0;j<26;j++){
                if(i==chars.length-1) continue;
                alpha[i+1][j] = alpha[i][j];
            }
        }
        int[] answer = new int[N];
        for(int i=0;i<N;i++){
            String[] sa = br.readLine().split(" ");
            char c = sa[0].charAt(0);
            int start = Integer.parseInt(sa[1]);
            int end = Integer.parseInt(sa[2]);
            if(start==0) answer[i] = alpha[end][c-'a'];
            else answer[i] = alpha[end][c-'a'] - alpha[start-1][c-'a'];
        }
        for(int i=0;i<N;i++){
            System.out.println(answer[i]);
        }
    }
}