package baekjoon.구현.중복된_숫자;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader  br   = new BufferedReader(new InputStreamReader(System.in));
		int             N    = Integer.parseInt(br.readLine());

		StringTokenizer st   = new StringTokenizer(br.readLine());

		int             sum1 = 0;
		int             sum2 = 0;

		// 1 ~ n-1 까지 더한값, 모든 입력값을 더한값을 구한다
		for (int i = 0; i < N; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			sum2 += tmp;
			sum1 += i;
		}

		// 위에서 구한 값을 뺴주면 중복값이 나옴
		System.out.println(sum2 - sum1);

	}
}
