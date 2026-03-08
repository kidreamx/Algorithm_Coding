import java.util.*;
import java.io.*;

public class Main{
    static List<List<Integer>> list;
    static int N,M;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = br.readLine().split(" ");
        list = new ArrayList<>();
        N = Integer.parseInt(sa[0]);
        M = Integer.parseInt(sa[1]);
        for(int i=0;i<=N;i++){
            list.add(new ArrayList<>());
        }
        int[] degree = new int[N+1];
        for(int i=0;i<M;i++){
            sa = br.readLine().split(" ");
            int size = Integer.parseInt(sa[0]);
            for(int j=1;j<size;j++){
                list.get(Integer.parseInt(sa[j])).add(Integer.parseInt(sa[j+1]));
                degree[Integer.parseInt(sa[j+1])]++;
            }
        }
        Queue<Integer> queue = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();
        for(int i=1;i<=N;i++){
            if(degree[i] == 0){
                queue.add(i);
            }
        }
        while(!queue.isEmpty()){
            int num = queue.poll();
            result.add(num);
            for(int i : list.get(num)){
                degree[i]--;
                if(degree[i] ==0){
                    queue.add(i);
                }
            }
        }
        if(result.size() != N){
            System.out.println(0);
        }else{
            for(int i : result){
                System.out.println(i);
            }
        }
    }
}