package baekjoon.브루트포스.숫자_정사각형;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int      N;
	static int      M;
	static char[][] arr;
	static int      max = 1;

	public static void main(String[] args) throws IOException {
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N   = Integer.parseInt(st.nextToken());
		M   = Integer.parseInt(st.nextToken());

		arr = new char[N][M];

		// 직사각형 입력
		for (int i = 0; i < N; i++) {

			arr[i] = br.readLine()
				.toCharArray();

		}
		find(Math.max(N, M));
		System.out.println(max * max);

	}

	public static void find(int size) {

		// 증감값
		int tmp = size - 1;

		// 모든 직사각형을 탐색
		for (int i = 0; i + tmp < N; i++) {
			for (int j = 0; j + tmp < M; j++) {

				// 4면이 동일하면 탐색 종료
				if (arr[i][j] == arr[i + tmp][j] && arr[i][j] == arr[i][j + tmp]
						&& arr[i][j] == arr[i + tmp][j + tmp]) {
					max = size;
					return;
				}
			}
		}

		// 못찾으면 사이즈 줄여서 다시 탐색
		find(size - 1);

	}
}