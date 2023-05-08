package baekjoon.문자열.전화번호_목록;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());

			String[] arr = new String[n];

			// 전화번호 입력
			for (int j = 0; j < n; j++) {
				arr[j] = br.readLine();
			}

			// 정렬
			Arrays.sort(arr);

			boolean flag = false;

			for (int j = 1; j < n; j++) {

				// 앞에잇는 번호가 현재 번호의 접두사면 멈춤
				if (arr[j].startsWith(arr[j - 1])) {
					flag = true;
					break;
				}
			}

			if (flag) {
				System.out.println("NO");
			} else {
				System.out.println("YES");
			}

		}

	}

}
