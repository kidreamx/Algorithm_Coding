import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sa =  br.readLine().split(" ");
        int N =Integer.parseInt(sa[0]);
        int L = Integer.parseInt(sa[1]);
        int D = Integer.parseInt(sa[2]);
        int[] listen = new int[10001];
        for(int i=0;i<N;i++){
            for(int j=0;j<L;j++){
                listen[j+((i*L)+5*i)]=1;
            }
        }
        int tmp_d = D;
        while(listen[tmp_d]==1){
            tmp_d+=D;
        }
        System.out.println(tmp_d);

    }
}