package baekjoon.구현.십자가_찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader  br  = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  = new StringTokenizer(br.readLine());

		int             N   = Integer.parseInt(st.nextToken());
		int             M   = Integer.parseInt(st.nextToken());

		char[][]        arr = new char[N][M];
		boolean[][]     v   = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine()
				.toCharArray();

		}

		ArrayList<int[]> list = new ArrayList<int[]>();

		for (int i = 1; i < N - 1; i++) {
			for (int j = 1; j < M - 1; j++) {

				// 별이면 십자가를 찾는다
				if (arr[i][j] == '*') {

					int cnt = 0;
					while (true) {
						cnt++;

						// 격자 범위 체크
						if (i - cnt < 0 || i + cnt >= N || j - cnt < 0 || j + cnt >= M) {
							break;
						}

						if (arr[i - cnt][j] != '*' || arr[i + cnt][j] != '*' || arr[i][j - cnt] != '*'
								|| arr[i][j + cnt] != '*') {
							break;

						}

						// 방문 체크
						v[i - cnt][j] = true;
						v[i + cnt][j] = true;
						v[i][j - cnt] = true;
						v[i][j + cnt] = true;
						v[i][j]       = true;

						list.add(new int[] { i + 1, j + 1, cnt });
					}

				}
			}
		}

		// 방문 안햇으면 -1 출력
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == '*' && !v[i][j]) {
					System.out.println(-1);
					return;
				}
			}
		}
		int           size = list.size();
		StringBuilder sb   = new StringBuilder();
		System.out.println(size > 0 ? size : -1);

		for (int[] i : list) {
//			System.out.println(i[0] + " " + i[1] + " " + i[2]);
			sb.append(i[0] + " " + i[1] + " " + i[2] + "\n");
		}
		System.out.println(sb.toString());

	}

}
