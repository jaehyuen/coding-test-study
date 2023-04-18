package baekjoon.문자열.시그널;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static char[][] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		char[] sig = br.readLine().toCharArray();
		arr = new char[5][N / 5];

		for (int i = 0; i < 5; i++) {
			System.arraycopy(sig, 0 + (i * (N / 5)), arr[i], 0, N / 5);
		}

		int idx = 0;
		int startIdx = 0;
		int[] cntArr = new int[4];

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < arr[0].length; i++) {

			int cnt = 0;

			for (int j = 0; j < 5; j++) {

				// 해당 위치가 검은색이면 카운팅
				if (arr[j][i] == '#') {
					cnt++;
				}
			}
			cntArr[idx] = cnt;

			// 숫자 파싱이 끝낫으면
			if (cnt == 0 && idx != 0) {

				sb.append(getStr(idx, cntArr, startIdx));
				idx = 0;

			} else if (cnt != 0) {

				// 숫자의 시작 인덱스 설정
				if (idx == 0) {
					startIdx = i;
				}
				idx++;
			}
		}

		if (idx != 0)
			sb.append(getStr(idx, cntArr, startIdx));

		System.out.println(sb.toString());
	}

	public static String getStr(int idx, int[] cntArr, int startIdx) {
		String str = "";

		// 1
		if (idx == 1) {
			str = "1";
		} else {
			if (cntArr[0] == 5) {
				// 0, 6, 8
				if (cntArr[1] == 2) {
					// 0
					str = "0";
				} else {
					// 6, 8
					if (cntArr[2] == 4) {
						// 6
						str = "6";
					} else {
						// 8
						str = "8";
					}
				}
			} else if (cntArr[0] == 4) {
				// 2, 5, 9
				if (cntArr[2] == 5) {
					// 9
					str = "9";
				} else {
					// 2, 5
					if (arr[1][startIdx] == '#') {
						// 5
						str = "5";
					} else {
						// 2
						str = "2";
					}

				}
			} else if (cntArr[0] == 3) {
				// 3, 4
				if (cntArr[1] == 3) {
					// 3
					str = "3";
				} else {
					// 4
					str = "4";
				}
			} else {
				// 7
				str = "7";
			}
		}

		return str;
	}

}
