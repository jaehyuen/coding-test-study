package baekjoon.문자열.카드셋트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] str = br.readLine().toCharArray();

		int[] cnt = { 13, 13, 13, 13 };
		boolean[][] v = new boolean[4][13];

		for (int i = 0; i < str.length; i += 3) {
			int idx = -1;

			// 카드별 인덱스 설정
			if (str[i] == 'P') {
				idx = 0;
			} else if (str[i] == 'K') {
				idx = 1;
			} else if (str[i] == 'H') {
				idx = 2;
			} else if (str[i] == 'T') {
				idx = 3;
			}

			int num = Integer.parseInt(str[i + 1] + "" + str[i + 2]) - 1;

			cnt[idx]--;

			if (v[idx][num]) {
				// 중복이면 종료
				System.out.println("GRESKA");

				return;
			} else {

				// 방문 체크
				v[idx][num] = true;
			}
		}

		for (int i : cnt) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

}
