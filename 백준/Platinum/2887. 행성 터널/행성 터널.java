import java.util.*;
import java.io.*;

public class Main{
    static class Edge implements Comparable<Edge>{
        int u , v ;
        long w;
        Edge(int u, int v , long w){
            this.u = u;
            this.v = v;
            this.w = w;
        }
        @Override
        public int compareTo(Edge o){
            return Long.compare(this.w ,o.w);
        }
    }
    static class Planet implements Comparable<Planet>{
        int index , value;
        Planet(int index, int value){
            this.index = index;
            this.value = value;
        }
        @Override
        public int compareTo(Planet o){
            return this.value - o.value;
        }
    }
    static int N;
    static ArrayList<Edge> edges;
    static int[][] planet;
    static int[] parent;
    static long count=0;
    public static void main(String[] args ) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        planet= new int[N+1][3];
        edges  = new ArrayList<>();
        parent = new int[N+1];
        for(int i=1;i<=N;i++){
            String[] sa = br.readLine().split(" ");
            planet[i][0] = Integer.parseInt(sa[0]);
            planet[i][1] = Integer.parseInt(sa[1]);
            planet[i][2] = Integer.parseInt(sa[2]);
        }
        for(int d=0;d<3;d++){
            Planet[] arr = new Planet[N];
            for(int i=0;i<N;i++){
                arr[i] = new Planet(i+1, planet[i+1][d]);
            }
            Arrays.sort(arr);
            for(int i=0;i<N-1;i++){
                int u = arr[i].index;
                int v = arr[i+1].index;
                long w = Math.abs((long)arr[i].value-arr[i+1].value);
                edges.add(new Edge(u,v,w));
            }
        }
        for(int i=1;i<=N;i++){
            parent[i] = i;
        }

        kruscal();
        System.out.println(count);
    }
    static int find(int x){
        if(parent[x] == x){
            return parent[x];
        }
        return parent[x] = find(parent[x]);
    }
    static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a!=b) parent[a] = b;
    }
    static void kruscal(){
        Collections.sort(edges);
        for(Edge e : edges){
            if(find(e.u) != find(e.v)){
                count += e.w;
                union(e.u,e.v);
            }
        }
    }
}