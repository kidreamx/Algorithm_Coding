import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] chars = br.readLine().toCharArray();
        int ph =0;
        int pq = 0;
        double result;
        for(int i=0; i<chars.length; i++){
            if( chars[i]=='H' || chars[i] =='P' || chars[i]== 'Y'){
                ph++;
            }
            else if(chars[i] == 'S' || chars[i] == 'D'){
                pq++;
            }
            else if(chars[i]== 'A'){
                ph++;
                pq++;
            }
        }
        if(ph==0 && pq==0){
            result =0.5*100;
        }
        else{
            result = (double)ph/(ph+pq)*100;
        }
        System.out.format("%.2f",result);
        bw.flush();
        bw.close();

    }

}

