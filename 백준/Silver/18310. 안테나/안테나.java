import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br;
    static int N;
    static List<Integer> list;
    public static void main(String[] args) throws IOException{
        init();
        calculate();
    }
    public static void init() throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        String[] sa = br.readLine().split(" ");
        for(int i=0;i<N;i++){
            list.add(Integer.parseInt(sa[i]));
        }
    }
    public static void calculate(){
        Collections.sort(list);
        System.out.println(list.get((N-1)/2));

    }
}