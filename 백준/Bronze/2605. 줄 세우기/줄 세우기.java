import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        LinkedList<Integer> linkedList = new LinkedList<>();
        int[] arr = new int[N+1];
        String[] sa = br.readLine().split(" ");
        for(int i=1;i<=N;i++){
            arr[i] = Integer.parseInt(sa[i-1]);
            linkedList.add(linkedList.size() - arr[i],i);
        }
        for(int i : linkedList){
            System.out.print(i+" ");
        }

    }
}