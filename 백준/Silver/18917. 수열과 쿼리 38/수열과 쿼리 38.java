import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        long prefixSum = 0;
        long xor = 0;
        for(int i=0;i<M;i++){
            String[] sa = br.readLine().split(" ");
            int direct = Integer.parseInt(sa[0]);
            if(direct==1){
                prefixSum+= Integer.parseInt(sa[1]);
                xor ^= Integer.parseInt(sa[1]);
            }else if(direct==2){
                prefixSum -= Integer.parseInt(sa[1]);
                xor ^= Integer.parseInt(sa[1]);
            }else if(direct==3){
                sb.append(prefixSum+"\n");
            }else if(direct==4){

                sb.append(xor+"\n");
            }
        }
        System.out.println(sb);
    }
}