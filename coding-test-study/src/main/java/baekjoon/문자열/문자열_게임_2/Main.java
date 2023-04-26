package baekjoon.문자열.문자열_게임_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			char[] str = br.readLine().toCharArray();
			int[] cntArr = new int[26];

			for (char c : str) {
				cntArr[c - 'a']++;
			}

			int K = Integer.parseInt(br.readLine());

			// k가 1일때
			if (K == 1) {
				System.out.println("1 1");
				continue;
			}

			int result1 = Integer.MAX_VALUE;
			int result2 = 0;

			for (int j = 0; j < str.length; j++) {

				// 전체 문자열에서 해당 알바펫 갯수가 K보다 적으면 불가능
				if (cntArr[str[j] - 'a'] < K) {
					continue;
				}

				// 현재 카운트
				int cnt = 1;
				for (int k = j + 1; k < str.length; k++) {

					if (str[j] == str[k]) {
						// 탐색하는 위치에 있는 알파벳이 같으면 카운트 증가
						cnt++;
					}

					// 카운팅이 완료됫으면 조건별 변수 초기화
					if (cnt == K) {
						result1 = Math.min(result1, k - j + 1);
						result2 = Math.max(result2, k - j + 1);
						break;

					}

				}

			}

			if (result2 == 0) {
				System.out.println(-1);
			} else {
				System.out.println(result1 + " " + result2);
			}

		}
	}
}
