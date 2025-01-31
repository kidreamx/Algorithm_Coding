import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] chars = br.readLine().toCharArray();
        int N =Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[][] alpha = new int[chars.length+1][26];
        for(int i=1;i<=chars.length;i++){
            for(int j=0;j<26;j++){
                if(j==chars[i-1]-'a') alpha[i][j] = alpha[i-1][j]+1;
                else alpha[i][j] = alpha[i-1][j];
            }
        }
        int[] answer = new int[N];
        for(int i=0;i<N;i++){
            String[] sa = br.readLine().split(" ");
            char c = sa[0].charAt(0);
            int start = Integer.parseInt(sa[1])+1;
            int end = Integer.parseInt(sa[2])+1;
            answer[i] = alpha[end][c-'a'] - alpha[start-1][c-'a'];
        }
        for(int i=0;i<N;i++){
            sb.append(answer[i]+"\n");
        }
        System.out.println(sb);
    }
}