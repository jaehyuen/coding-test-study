package baekjoon.구현.반복수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	static String[] test;

	public static void main(String[] args) throws IOException {

		BufferedReader     br   = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer    st   = new StringTokenizer(br.readLine());

		int                A    = Integer.parseInt(st.nextToken());
		int                P    = Integer.parseInt(st.nextToken());

		ArrayList<Integer> list = new ArrayList<>();

		list.add(A);

		while (true) {

			int    sum = 0;

			char[] str = String.valueOf(A)
				.toCharArray();

			// 다음 요소 생성
			for (char c : str) {
				sum += Math.pow(c - '0', P);
			}
			A = sum;

			// 반복되면 종료
			if (list.contains(sum)) {

				break;
			}

			list.add(sum);

		}

		int cnt = 0;

		// 카운팅한다
		for (int i : list) {
			if (i == A) {
				System.out.println(cnt);
				return;
			}
			cnt++;
		}
	}
}
