package baekjoon.그리디.A와_B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br   = new BufferedReader(new InputStreamReader(System.in));
		String         S    = br.readLine();
		String         T    = br.readLine();

		char[]         sArr = S.toCharArray();
		char[]         tArr = T.toCharArray();

		for (int i = tArr.length - 1; i >= sArr.length - 1; i--) {
			if (tArr[i] == 'B' && i > 1) {
				// 현위치가 B이기에 문자열을 뒤집는 연산을 했다
				swap(tArr, i - 1);
			}

		}

		// 문자열 T를 S와 같은 길이로 돌려놧을떄 둘이 다른 부분이 있으면 0 출력
		for (int i = 0; i < sArr.length; i++) {

			if (sArr[i] != tArr[i]) {
				System.out.println(0);
				return;
			}
		}

		System.out.println(1);
	}

	public static void swap(char[] arr, int idx) {
		int j = idx;

		// 문자열을 뒤집는다
		for (int i = 0; i <= idx / 2; i++) {

			char tmp = arr[i];
			arr[i] = arr[j];
			arr[j] = tmp;
			j--;

		}
	}

}
