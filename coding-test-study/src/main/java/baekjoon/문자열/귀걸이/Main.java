package baekjoon.문자열.귀걸이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = 1;
		while (true) {
			int N = Integer.parseInt(br.readLine());

			if (N == 0) {
				return;
			}

			String[] arr = new String[N];
			int[] v = new int[N];

			// 학생 이름 입력
			for (int i = 0; i < N; i++) {
				arr[i] = br.readLine();
			}

			// 압수 리스트 확인
			for (int i = 0; i < 2 * N - 1; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int idx = Integer.parseInt(st.nextToken());
				v[idx - 1]++;
			}

			// 한번 불린 친구를 찾는다
			for (int i = 0; i < N; i++) {
				if (v[i] == 1) {
					System.out.println(cnt++ + " " + arr[i]);
					break;
				}
			}

		}

	}

}
