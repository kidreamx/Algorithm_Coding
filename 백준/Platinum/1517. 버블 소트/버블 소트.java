import java.util.*;
import java.io.*;

public class Main{
    static int N;
    static int[] arr;
    static long cnt;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        cnt=0;
        String[] sa = br.readLine().split(" ");
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(sa[i]);
        }
        merge(0,N-1);
        System.out.println(cnt);
    }
    //4 배열의 크기
    static void merge(int left , int right){
        if(left == right){
            return;
        }
        int mid  = (left+right)/2;
        merge(left , mid);
        merge(mid+1, right);
        sort(left, mid , right);
    }
    static void sort(int left , int mid , int right){
        int[] tmp = new int[right-left+1];
        int leftIndex = left;
        int rightIndex = mid+1;
        for(int i=0;i<right-left+1;i++){
            if(leftIndex==mid+1){
                tmp[i] = arr[rightIndex];
                rightIndex++;
                continue;
            }
            else if(rightIndex==right+1){
                tmp[i] = arr[leftIndex];
                leftIndex++;
                continue;
            }
            if(arr[leftIndex]<=arr[rightIndex]){
                tmp[i] = arr[leftIndex];
                leftIndex++;
            }else{
                tmp[i] = arr[rightIndex];
                // rightIndex - left+i
                cnt+=  mid + 1- leftIndex;
                rightIndex++;
            }
        }
        for(int i=left; i<=right;i++){
            arr[i] = tmp[i-left];
        }

    }
}