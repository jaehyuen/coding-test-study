package baekjoon.그리디.행복_유치원;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader  br       = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st       = new StringTokenizer(br.readLine());

		int             N        = Integer.parseInt(st.nextToken());
		int             K        = Integer.parseInt(st.nextToken());

		int[]           children = new int[N];
		int[]           diff     = new int[N - 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			children[i] = Integer.parseInt(st.nextToken());

		}

		// 유치원생을 키순으로 정렬
		Arrays.sort(children);

		// 앞사람과의 차이를 구함
		for (int i = 1; i < N; i++) {
			diff[i - 1] = children[i] - children[i - 1];

		}

		// 앞사람과의 차이값을 정렬
		Arrays.sort(diff);

		int cnt = 0;

		// 현재 구간은 1개 >> K개로 늘려야함
		// 그러면 큰 구간을 없애(분리해) 구간을 늘린다
		// 큰구간을 K-1개 만큼 뺴고 남은 값을 더해주면 됨
		// K-1개 만큼 뺸다는 것은 구간이 작은거 N-K개를 더하는것

		for (int i = 0; i < N - K; i++) {
			cnt += diff[i];

		}
		System.out.println(cnt);
	}

}
