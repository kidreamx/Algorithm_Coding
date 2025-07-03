import java.util.*;
import java.io.*;

public class Main{
	static class Line implements Comparable<Line>{
		int start;
		int end;
		Line(int start, int end){
			this.start= start;
			this.end = end;
		}
		@Override
		public int compareTo(Line o) {
			if(this.start == o.start) {
				return this.end - o.end;
			}else {
				return this.start- o.start;
			}
		}
		
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<Line> list = new ArrayList<>();
		List<Line> result = new ArrayList<>();
		for(int i=0;i<N;i++) {
			String[] sa = br.readLine().split(" ");
			int start= Integer.parseInt(sa[0]);
			int end = Integer.parseInt(sa[1]);
			list.add(new Line(start,end));
		}
		Collections.sort(list);
		result.add(list.get(0));
		for(int index=1;index<list.size();index++) {
			Line first = result.get(result.size()-1);
			Line second = list.get(index);
			if(first.end >= second.start) {
				if(first.end<=second.end) {
					first.end = second.end;
				}
			}else {
				result.add(second);
			}
		}
		int sum=0;
		for(Line l : result) {
			sum += l.end- l.start;
		}
		System.out.println(sum);
	}
}