import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t=0;t<T;t++){
            int N = Integer.parseInt(br.readLine());
            boolean fin = false;
            TreeSet<String> set = new TreeSet<>();
            for(int i=0;i<N;i++){
                set.add(br.readLine());
            }
            for(String s : set){
                for(int i=0;i<s.length();i++){
                    if(set.contains(s.substring(0,i))) {
                        sb.append("NO"+"\n");
                        fin = true;
                    }
                    if(fin){
                        break;
                    }
                }
                if (fin) {
                    break;
                }
            }
            if(!fin){
                sb.append("YES"+"\n");
            }
        }
        System.out.println(sb);
    }
}