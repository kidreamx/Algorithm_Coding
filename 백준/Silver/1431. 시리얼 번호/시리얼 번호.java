import java.util.*;
import java.io.*;


public class Main  {
	
	public static void main(String[] args)  throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		String[] arr = new String[N];
		int[] num = new int[N];
		boolean[] hasNum  = new boolean[N];
		
		for(int i=0;i<N;i++) {
			arr[i] = br.readLine();
			char[] tmp = arr[i].toCharArray();
			for(int j=0;j<tmp.length;j++) {
				if((int)tmp[j]>=48 && (int)tmp[j]<=57) {
					num[i] += (int)tmp[j]-48;
					hasNum[i] = true;
				}
			}
		}
		
		for(int i=0;i<N-1;i++) {
			for(int j=i+1;j<N;j++) {
				if(arr[i].length()== arr[j].length()) {
					if(num[i]==num[j]) {
						if(num[i]>0 && num[j]>0) {
							if(arr[i].compareTo(arr[j])>0) {
								String tmp;
								tmp =  arr[i];
								arr[i] = arr[j];
								arr[j] = tmp;
								int tmp2;
								tmp2 = num[i];
								num[i] = num[j];
								num[j] = tmp2;
							}
							
						}
						else {
							if(arr[i].compareTo(arr[j])>0) {
								String tmp;
								tmp =  arr[i];
								arr[i] = arr[j];
								arr[j] = tmp;
								int tmp2;
								tmp2 = num[i];
								num[i] = num[j];
								num[j] = tmp2;
							}
							
						}
					}
					else {
							if(num[i]>num[j]) {
								String tmp;
								tmp =  arr[i];
								arr[i] = arr[j];
								arr[j] = tmp;
								int tmp2;
								tmp2 = num[i];
								num[i] = num[j];
								num[j] = tmp2;
							}
						}
						
					
				}
				else { // 1번 기준 길이가 짧을 때
					if(arr[i].length() > arr[j].length()) {
						String tmp;
						tmp =  arr[i];
						arr[i] = arr[j];
						arr[j] = tmp;
						int tmp2;
						tmp2 = num[i];
						num[i] = num[j];
						num[j] = tmp2;
					}
				}
			}
		}
		for(int i=0;i<N;i++) {
			bw.write(arr[i]+"\n");
		}
		bw.flush();
		bw.close();
			
		
		
	}
}
