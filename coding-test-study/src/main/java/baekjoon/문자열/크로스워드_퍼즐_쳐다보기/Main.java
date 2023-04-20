package baekjoon.문자열.크로스워드_퍼즐_쳐다보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		char[][] arr = new char[R + 1][C + 1];

		for (int i = 0; i < R; i++) {
			String str = br.readLine();

			// 퍼즐 입력 및 왼쪽, 아래쪽 끝에는 벽을 추가
			for (int j = 0; j < C; j++) {
				arr[i][j] = str.charAt(j);
				arr[R][j] = '#';
			}
			arr[i][C] = '#';

		}

		HashSet<String> set = new HashSet<>();
		for (int i = 0; i <= R; i++) {
			String str = "";
			for (int j = 0; j <= C; j++) {
				// 현재 위치가 벽이 아니면
				if (arr[i][j] != '#') {
					str += arr[i][j];
				} else {

					// 단어가 2이상이면
					if (str.length() > 1) {
						set.add(str);

					}
					str = "";
				}

			}
		}

		for (int i = 0; i <= C; i++) {
			String str = "";
			for (int j = 0; j <= R; j++) {
				// 현재 위치가 벽이 아니면
				if (arr[j][i] != '#') {
					str += arr[j][i];
				} else {
					// 단어가 2이상이면
					if (str.length() > 1) {
						set.add(str);

					}
					str = "";
				}

			}
		}

		ArrayList<String> list = new ArrayList<>(set);

		// 사전순으로 정렬
		Collections.sort(list);

		// 첫번째 요소 출력
		System.out.println(list.get(0));
	}

}
