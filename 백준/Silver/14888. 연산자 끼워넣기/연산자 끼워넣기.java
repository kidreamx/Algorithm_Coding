import java.io.*;
import java.util.*;

public class Main{
    static int N;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static List<Character> list = new ArrayList<>();
    static int[] arr;
    static boolean[] visited;
    static int[] signal;
    static char[] sign;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N-1];
        sign = new char[N-1];
        arr = new int[N];
        String[] sa = br.readLine().split(" ");
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(sa[i]);
        }
        signal = new int[4];
        sa = br.readLine().split(" ");
        for(int i=0;i<4;i++){
            signal[i] = Integer.parseInt(sa[i]);
        }
        int index=0;
        for(int i=0;i<4;i++){
            for(int j=0;j<signal[i];j++){
                if(i==0){
                    sign[index] = '+';
                    index++;
                }
                else if(i==1){
                    sign[index] = '-';
                    index++;
                }
                else if(i==2){
                    sign[index] = '*';
                    index++;
                }
                else {
                    sign[index] = '/';
                    index++;
                }
            }
        }
        dfs(0);
        System.out.println(max);
        System.out.println(min);
    }
    static void dfs(int depth){
        if(depth == N-1){
            int sum=0;
            for(int i=0;i<list.size();i++){
                if(list.get(i)=='+'){
                    if(i==0){
                        sum += arr[i] + arr[i+1];
                    }
                    else {
                        sum = sum + arr[i + 1];
                    }
                }
                else if(list.get(i)=='-'){
                    if(i==0){
                        sum += arr[i] - arr[i+1];
                    }
                    else{
                        sum = sum - arr[i+1];
                    }
                }
                else if(list.get(i)=='*'){
                    if(i==0){
                        sum += arr[i] * arr[i+1];
                    }
                    else{
                        sum = sum * arr[i+1];
                    }

                }
                else if(list.get(i)== '/'){
                    if(i==0){
                        sum += arr[i] / arr[i+1];
                    }
                    else{
                        sum = sum / arr[i+1];
                    }
                }
            }

            max = Math.max(max, sum);

            min = Math.min(min, sum);
            return;
        }
        for(int i=0 ; i<N-1;i++){
            if(visited[i]){
                continue;
            }
            visited[i] = true;
            list.add(sign[i]);
            dfs(depth+1);
            list.remove(list.size()-1);
            visited[i] = false;
        }

    }

}

