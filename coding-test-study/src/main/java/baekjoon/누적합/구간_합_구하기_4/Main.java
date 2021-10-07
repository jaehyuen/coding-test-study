package baekjoon.누적합.구간_합_구하기_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader  br  = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  = new StringTokenizer(br.readLine());
		int             N   = Integer.parseInt(st.nextToken());
		int             M   = Integer.parseInt(st.nextToken());

		int[]           arr = new int[N + 1];

		st = new StringTokenizer(br.readLine());

		int sum = 0;

		for (int i = 1; i <= N; i++) {
			sum    += Integer.parseInt(st.nextToken());
			arr[i]  = sum;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end   = Integer.parseInt(st.nextToken());
			System.out.println(arr[end] - arr[start - 1]);
		}

	}

}
