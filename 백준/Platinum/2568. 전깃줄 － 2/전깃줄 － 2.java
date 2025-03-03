import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] line = new int[N][2];
        boolean[] visited = new boolean[500001];
        for(int i=0;i<N;i++){
            String[] sa = br.readLine().split(" ");
            line[i][0] = Integer.parseInt(sa[0]);
            visited[line[i][0]] = true;
            line[i][1] = Integer.parseInt(sa[1]);
        }
        Arrays.sort(line,(o1,o2)->{
           return o1[0]-o2[0];
        });
        int[] dp = new int[N];
        int[] order = new int[N];
        int length=0;
        Arrays.fill(order,-1);
        for(int i=0;i<N;i++){
            int num = line[i][1];
            int low =0, high=length;
            while(low<high){
                int mid = (low+high)/2;
                if(line[dp[mid]][1]<num){
                    low = mid+1;
                }else{
                    high = mid;
                }
            }
            int pos = low;
            dp[pos] = i;
            if(pos>0){
                order[i] = dp[pos-1];
            }
            if(pos==length){
                length++;
            }
        }
        System.out.println(N-length);
        int[] list = new int[length];
        int index = dp[length-1];
        for(int i=length-1;i>=0;i--){
            list[i] = line[index][0];
            index = order[index];
        }
        for(int i=0;i<list.length;i++){
            visited[list[i]] = false;
        }
        for(int i=0;i<N;i++){
            if(visited[line[i][0]]){
                System.out.println(line[i][0]);
            }
        }
    }
}