package baekjoon.구현.누울_자리를_찾아라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[][] map = new char[N][N];

		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}

		int cnt1 = 0;
		int cnt2 = 0;

		for (int i = 0; i < N; i++) {

			// 누을곳 크기 카운팅
			int tmp1 = 0;
			int tmp2 = 0;
			
			for (int j = 0; j < N; j++) {
				// 가로 카운팅
				if (map[i][j] == '.') {
					tmp1++;
				} else if (tmp1 >= 2) {

					//벽인데 연속된 자리가 2이상이면 누을 자리 증가
					cnt1++;
					tmp1 = 0;
				}else {
					tmp1 = 0;
				}

				// 세로 카운팅
				if (map[j][i] == '.') {
					tmp2++;
				} else if (tmp2 >= 2) {
					//벽인데 연속된 자리가 2이상이면 누을 자리 증가
					cnt2++;
					tmp2 = 0;
				}else {
					tmp2 = 0;
				}


			}

			// 가로 카운팅 2
			if (tmp1 >= 2) {
				cnt1++;
			}

			// 세로 카운팅 2
			if (tmp2 >= 2) {
				cnt2++;
			}
		}

		System.out.println(cnt1 + " " + cnt2);
	}

}
