package baekjoon.그리디.최대_상승;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader  br  = new BufferedReader(new InputStreamReader(System.in));
		int             N   = Integer.parseInt(br.readLine());

		StringTokenizer st  = new StringTokenizer(br.readLine());

		// 구매 가능한 최소 가격
		int             min = Integer.MAX_VALUE;

		// 수익 최대값
		int             max = 0;

		for (int i = 0; i < N; i++) {
			int tmp = Integer.parseInt(st.nextToken());

			// 날이 갈수록 살수잇는 최소 가격 갱신
			min = Math.min(tmp, min);

			// 수익률 최대값 갱신
			max = Math.max(tmp - min, max);
		}

		System.out.println(max);

	}

}
