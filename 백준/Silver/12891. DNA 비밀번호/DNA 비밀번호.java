import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = br.readLine().split(" ");
        int S = Integer.parseInt(sa[0]);
        int P = Integer.parseInt(sa[1]);
        char[] chars = br.readLine().toCharArray();
        char[] window = new char[S];
        int[] alpha = new int[4];
        int[] comAlpha = new int[4];
        sa = br.readLine().split(" ");
        for(int i=0;i<4;i++){
            alpha[i] = Integer.parseInt(sa[i]);
        }
        for(int i=0;i<P;i++){
            if(chars[i] == 'A'){
                comAlpha[0]++;
            }
            else if(chars[i] == 'C'){
                comAlpha[1]++;
            }else if(chars[i]=='G'){
                comAlpha[2]++;
            }else if(chars[i]=='T'){
                comAlpha[3]++;
            }
        }
        int cnt=0;
        int answer=0;
        for(int i=0;i<4;i++){
            if(comAlpha[i]>=alpha[i]){
                cnt++;
            }
        }
        if(cnt==4){
            answer++;
        }
        int start = 0;
        int end = start+P;

        while(end<S){
            if(chars[start]=='A'){
                comAlpha[0]--;
            }else if(chars[start]=='C'){
                comAlpha[1]--;
            }else if(chars[start]=='G'){
                comAlpha[2]--;
            }else if(chars[start]=='T'){
                comAlpha[3]--;
            }

            if(chars[end]=='A'){
                comAlpha[0]++;
            }else if(chars[end]=='C'){
                comAlpha[1]++;
            }else if(chars[end]=='G'){
                comAlpha[2]++;
            }else if(chars[end]=='T'){
                comAlpha[3]++;
            }
            cnt=0;
            for(int i=0;i<4;i++){
                if(comAlpha[i]>=alpha[i]){
                    cnt++;
                }
            }
            if(cnt==4){
                answer++;
            }
            start++;
            end++;
        }
        System.out.println(answer);
    }
}