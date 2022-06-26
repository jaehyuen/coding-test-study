package baekjoon.구현.비슷한_단어;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[][] arr = new int[N][27];

		int cnt = 0;
		for (int i = 0; i < N; i++) {
			String str = br.readLine();

			// 사용한 알파펫 갯수를 저장한다
			for (char c : str.toCharArray()) {
				arr[i][c - 'A']++;
			}
			// 배열의 마지막에는 문자열 길이를 넣어준다
			arr[i][26] = str.length();

			if (i != 0) {
				// 사용된 알파벳이 같으면 비슷한 단어
				if (Arrays.equals(arr[0], arr[i])) {
					cnt++;
				} else if (arr[0][26] == arr[i][26] || Math.abs(arr[0][26] - arr[i][26]) == 1) {
					//두단어의 사이즈가 같거나 1개차이면 비교해본다
					
					boolean flag = true;
					int tmp = 0;

					for (int j = 0; j < 26; j++) {

						if (arr[0][j] == arr[i][j])
							continue;

						// 두 단어의 차이 계산
						tmp += Math.abs(arr[0][j] - arr[i][j]);

						// 두단어의 사이즈가 같고 tmp값이 3이상이면 비슷한단어 아님
						if (tmp > 2 && arr[0][26] == arr[i][26]) {
							flag = false;
							break;
						}

						// 두단어의 사이즈가 한글자 차이나고 tmp값이 2이상이면 비슷한단어 아님
						if (tmp > 1 && Math.abs(arr[0][26] - arr[i][26]) == 1) {
							flag = false;
							break;
						}
					}

					if (flag) {
						cnt++;
					}
				}
			}

		}

		System.out.println(cnt);

	}
}
