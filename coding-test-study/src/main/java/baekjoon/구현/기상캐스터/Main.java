package baekjoon.구현.기상캐스터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static String[] test;

	public static void main(String[] args) throws IOException {

		BufferedReader  br  = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  = new StringTokenizer(br.readLine());

		int             N   = Integer.parseInt(st.nextToken());
		int             M   = Integer.parseInt(st.nextToken());

		int[][]         arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			char[] c = br.readLine()
				.toCharArray();
			for (int j = 0; j < M; j++) {

				if (c[j] == 'c') {
					arr[i][j] = 0;
				} else {
					arr[i][j] = -1;
				}
			}
		}

		for (int i = 0; i < N; i++) {
			System.out.print(arr[i][0] + " ");
			for (int j = 1; j < M; j++) {

				// 현재 위치에 구름이 없고 서쪽에 구름이 있다면 값 변경
				if (arr[i][j] == -1 && arr[i][j - 1] != -1) {
					arr[i][j] = arr[i][j - 1] + 1;
				}
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();

		}

	}
}
