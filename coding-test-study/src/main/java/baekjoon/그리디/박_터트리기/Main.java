package baekjoon.그리디.박_터트리기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader  br  = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  = new StringTokenizer(br.readLine());

		int             N   = Integer.parseInt(st.nextToken());
		int             K   = Integer.parseInt(st.nextToken());

		int[]           arr = new int[K];

		int             idx = K - 1;
		int             tmp = 0;

		// 1개씩 차이나도롱 채워줌
		for (int i = 1; i <= K; i++) {
			arr[i - 1]  = i;
			tmp        += i;
		}

		// 기본 조건으로 박을 못채우면 종료
		if (tmp > N) {
			System.out.println(-1);
			return;
		}

		// 제일 많이 있는쪽부터 한개씩 채운다
		for (int i = tmp; i < N; i++) {
			if (idx < 0) {
				idx = K - 1;
			}
			arr[idx]++;
			idx--;
		}

		// 젤 많은곳과 적은곳의 차이 출력
		System.out.println(arr[K - 1] - arr[0]);

	}

}
