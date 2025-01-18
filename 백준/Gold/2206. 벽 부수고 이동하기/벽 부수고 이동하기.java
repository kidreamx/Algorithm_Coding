import java.util.*;
import java.io.*;

public class Main {
	static class Point{
		int x,y,len,broken;
		Point(int x, int y, int len, int broken){
			this.x = x;
			this.y = y;
			this.len = len;
			this.broken = broken;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] sa = br.readLine().split(" ");
		int N = Integer.parseInt(sa[0]);
		int M = Integer.parseInt(sa[1]);
		int[] dx = {1,0,-1,0};
		int[] dy = {0,-1,0,1};
		
		int[][] arr = new int[N+1][M+1];
		Queue<Point> wall = new LinkedList<>();
		for(int i=1;i<=N;i++) {
			char[] chars = br.readLine().toCharArray();
			for(int j=1;j<=M;j++) {
				arr[i][j] = chars[j-1]-'0';
			}
		}
		
		int min = Integer.MAX_VALUE;
		Queue<Point> queue = new LinkedList<>();
		boolean[][][] visited = new boolean[N+1][M+1][2];
		queue.add(new Point(1,1,1,0));
		visited[1][1][0] = true;
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			if(p.x==M && p.y == N) {
				min = Math.min(min, p.len);
				continue;
			}
			for(int i=0;i<4;i++) {
				int x = p.x+dx[i];
				int y = p.y+dy[i];
				if(x>=1 && x<=M && y>=1 && y<=N ) {
					if(arr[y][x] == 0 && !visited[y][x][p.broken]){
						visited[y][x][p.broken] = true;
						queue.add(new Point(x,y,p.len+1, p.broken));
					}
					else if(arr[y][x]==1 && p.broken==0 && !visited[y][x][1]) {
						visited[y][x][1] = true;
						queue.add(new Point(x,y,p.len+1,1));
					}
				}
			}
		}	
		if(min == Integer.MAX_VALUE) {
			System.out.println(-1);
		}
		else {
			System.out.println(min);
		}
	}
}