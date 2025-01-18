import java.util.*;
import java.io.*;

public class Main{
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = br.readLine().split(" ");
        int A = Integer.parseInt(sa[0]);
        int B = Integer.parseInt(sa[1]);
        int V = Integer.parseInt(sa[2]);
        int days= (V-B-1)/(A-B)+1;
        System.out.println(days);
    }
}