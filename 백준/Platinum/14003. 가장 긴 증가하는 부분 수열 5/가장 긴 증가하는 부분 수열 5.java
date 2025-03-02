import java.util.*;
import java.io.*;

public class Main{
    static int N;
    static int[] arr,dp;
    static int[] parent;
    public static void main(String[] args )throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        String[] sa = br.readLine().split(" ");
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(sa[i]);
        }
        dp = new int[N];
        parent = new int[N];
        int answer = lengthLISBinarySearch(arr);
        int[] lis = new int[answer];
        int index = dp[answer- 1]; // 최장 수열의 마지막 원소 인덱스
        for (int i = answer - 1; i >= 0; i--) {
            lis[i] = arr[index];
            index = parent[index];
        }

        // 결과 출력: 길이와 수열
        StringBuilder sb = new StringBuilder();
        sb.append(answer).append("\n");
        for (int num : lis) {
            sb.append(num).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
    static int lengthLISBinarySearch(int[] arr){
        dp = new int[arr.length];
        int index=0;
        for(int i=0;i<arr.length;i++){
            int num = arr[i];
            int low = 0, high = index;
            while(low<high){
                int mid = (low+high)/2;
                if(arr[dp[mid]]<num){
                    low = mid+1;
                }else{
                    high = mid;
                }
            }
            int pos = low;
            dp[pos] = i;
            if(pos>0){
                parent[i] = dp[pos-1];
            }
            if(pos == index){
                index++;
            }
        }
        return index;
    }
}