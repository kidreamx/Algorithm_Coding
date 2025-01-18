import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] chars = br.readLine().toCharArray();
        int[] count = new int[26];
        int odds = 0;
        StringBuffer header= new StringBuffer();
        StringBuffer middle= new StringBuffer();
        StringBuffer back = new StringBuffer();
        int odds_number;
        for(int i = 0; i < chars.length; i++){
            count[chars[i] - 'A']++;
        }
        for(int i = 0; i < 26; i++){
            if(count[i] % 2 ==1){
                odds++;
                odds_number = i;
            }
        }
        if(odds >=2){
            bw.write("I'm Sorry Hansoo");
        }
        else{
            for(int i=0;i<26;i++){
                if(count[i] % 2 ==0){
                    for(int j=0;j<count[i]/2;j++){
                        header.append((char)('A'+i));
                        back.append((char)('A'+i));
                    }
                }
                else{
                    for(int j=0;j<count[i]/2;j++){
                        header.append((char)('A'+i));
                        back.append((char)('A'+i));
                    }
                    middle.append((char)('A'+i));
                }
            }
        }
        bw.write(header.toString()+middle.toString()+back.reverse().toString());
        bw.flush();
        bw.close();
    }
}