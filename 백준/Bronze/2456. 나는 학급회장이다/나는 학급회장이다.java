import java.util.*;
import java.io.*;
import java.math.*;

public class Main  {
	
	static int max_3(int cnt_1, int cnt_2, int cnt_3) {
		int max = 0;
		int index = 0;
		if(max < cnt_1) {
			max = cnt_1;
			index = 1;
		}
		if(max < cnt_2) {
			max = cnt_2;
			index = 2;
		}
		
		if(max < cnt_3) {
			max = cnt_3;
			index = 3;
		}
		
		return index;
	}
	static int max_count(int cnt_1, int cnt_2, int cnt_3) {
		int max=0;
		int count=0;
		if(max < cnt_1) {
			max = cnt_1;
			count=1;
		}
		if(max < cnt_2) {
			max = cnt_2;
			count=1;
		}
		else if(max == cnt_2) {
			count++;
		}
		if(max < cnt_3) {
			max = cnt_3;
			count=1;
		}
		else if(max == cnt_3) {
			count++;
		}
		return count;
	}
	
	
	public static void main(String[] args)  throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[][] cnt = new int[4][4];
		int first,second, third;
		int[] sum = new int[4];
		int max_count=0;
		int solo = 0;
		int max=0;
		boolean[] max_index =new boolean[3];
		for(int i=0;i<N;i++) {
			String[] sa = br.readLine().split(" ");
			first = Integer.parseInt(sa[0]);
			cnt[1][first]++;
			second = Integer.parseInt(sa[1]);
			cnt[2][second]++;
			third = Integer.parseInt(sa[2]);
			cnt[3][third]++;
			sum[1]+= first;
			sum[2]+= second;
			sum[3]+= third;
		}
		for(int i=0;i<3;i++) {
			if(max<sum[i+1]) {
				max_count = 0;
				max = sum[i+1];
				max_index = new boolean[3];
				max_index[i] = true;
				solo = i+1;
				max_count++;
			}
			else if(max == sum[i+1]) {
				max_index[i]= true;
				max_count++;
				
			}
		
		}
		if(max_count==3) {
			if(max_count(cnt[1][3],cnt[2][3],cnt[3][3]) == 1) {
				solo = max_3(cnt[1][3],cnt[2][3],cnt[3][3]);
			}
			else {
				solo = 0;
			}
			bw.write(solo+" "+ max);
		}
		else if(max_count==2) {
			int first1 = 0 , second1 = 0;
			int cnt1=0;
			for(int i=0;i<3;i++) {
				if(max_index[i]) {
					if(cnt1==0) {
						first1 = i+1;
						cnt1++;
					}
					else {
						second1 = i+1;
						cnt1++;
					}
				}
			}
			if(cnt[first1][3] == cnt[second1][3]) {
				if(cnt[first1][2] == cnt[second1][2]) {
					solo = 0;
				}
				else {
					if(cnt[first1][2] == Math.max(cnt[first1][2], cnt[second1][2])) {
						solo = first1;
					}
					else if (cnt[second1][2] == Math.max(cnt[first1][2], cnt[second1][2])) {
						solo = second1;
					}
				}
			}
			else {
				if(cnt[first1][3] == Math.max(cnt[first1][3], cnt[second1][3])) {
					solo = first1;
				}
				else if (cnt[second1][3] == Math.max(cnt[first1][3], cnt[second1][3])) {
					solo = second1;
				};
			}
			bw.write(solo+" "+ max);
		}
		else {
			bw.write(solo +" "+ max);	
		}
		
		
		
		br.close();
		bw.flush();
		bw.close();
		
		
	}
}
