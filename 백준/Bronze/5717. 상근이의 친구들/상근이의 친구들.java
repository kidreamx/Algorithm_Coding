import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true){
            String[] sa = br.readLine().split(" ");
            int a =Integer.parseInt(sa[0]);
            int b = Integer.parseInt(sa[1]);
            if(a==0 && b==0){
                break;
            }else{
                int sum = a+b;
                sb.append(sum+"\n");
            }
        }
        System.out.println(sb);
    }
}