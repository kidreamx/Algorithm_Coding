import java.util.*;
import java.io.*;

public class Main{
    static int N,M,K;
    static long []tree;
    static long []arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] sa = br.readLine().split(" ");
        N = Integer.parseInt(sa[0]);
        M = Integer.parseInt(sa[1]);
        K = Integer.parseInt(sa[2]);
        arr = new long[N];
        tree = new long[getTreeSize()];
        for(int i=0;i<N;i++){
            arr[i] = Long.parseLong(br.readLine());
        }
        init(0,N-1,1);
        for(int i=0;i<M+K;i++){
            sa = br.readLine().split(" ");
            int a = Integer.parseInt(sa[0]);
            int b = Integer.parseInt(sa[1]);
            long c = Long.parseLong(sa[2]);
            if(a == 1){
                long dif = c-arr[b-1];
                update(0,N-1,1,b-1,dif);
                arr[b-1] = c;
            }else if( a== 2){
                sb.append(pSum(0,N-1,1,b-1, (int)(c-1))+"\n");
            }
        }
        System.out.println(sb);
    }
    public static int getTreeSize(){
        // 최대 높이
        int h = (int)Math.ceil(Math.log(N)/Math.log(2))+1;
        // 최대 값
        return (int)Math.pow(2,h);
    }

    public static long init(int start, int end , int node){
        if(start == end) return tree[node] = arr[start];
        int mid = (start+end)/2;
        return tree[node] = init(start, mid , node*2) + init(mid+1, end , node*2+1);
    }

    public static void update(int start, int end, int node, int idx, long dif){
        if(start<= idx && idx <= end){
            tree[node] += dif;
        }else return;

        // 그 아래로는 내려갈수 없어서
        if(start == end) return;

        int mid = (start+end)/2;
        update(start, mid, node*2, idx, dif);
        update(mid+1, end , node*2+1, idx, dif);
    }

    public static long pSum(int start, int end , int node, int l, int r){
        if(r<start || l> end) return 0;
        if(l<=start && end <=r) return tree[node];
        int mid = (start+end)/2;

        return pSum(start,mid, node*2 , l, r)+ pSum(mid+1,end,node*2+1, l , r);
    }
}