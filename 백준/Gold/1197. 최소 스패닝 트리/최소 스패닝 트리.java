import java.util.*;
import java.io.*;

public class Main{
	static class Edge implements Comparable<Edge>{
		int u,v,w;
		Edge(int u , int v, int w){
			this.u = u;
			this.v = v;
			this.w = w;
		}
		@Override
		public int compareTo(Edge o) {
			return this.w - o.w;
		}
		
	}
	static int V,E;
	static int[] parent;
	static Edge[] edges;
	static int count;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] sa = br.readLine().split(" ");
		V = Integer.parseInt(sa[0]);
		E = Integer.parseInt(sa[1]);
		edges  = new Edge[E];
		for(int i=0;i<E;i++) {
			sa = br.readLine().split(" ");
			edges[i] = new Edge(Integer.parseInt(sa[0]),Integer.parseInt(sa[1]),Integer.parseInt(sa[2]));
		}
		parent = new int[V+1];
		for(int i=1;i<=V;i++) {
			parent[i] = i;
		}
		count=0;
		kruscal();
		System.out.println(count);
	}
	static int find(int x) {
		if(parent[x] == x) {
			return parent[x];
		}
		return parent[x] = find(parent[x]);
	}
	static boolean union(int a , int b) {
		a = find(a);
		b = find(b);
		if(a!= b) {
			parent[a] = b;
			return true;
		}
		return false;
	}
	static void kruscal() {
		Arrays.sort(edges);
		for(Edge e: edges) {
			if(union(e.u,e.v)) {
				count+=e.w;
			}
		}
	}
}