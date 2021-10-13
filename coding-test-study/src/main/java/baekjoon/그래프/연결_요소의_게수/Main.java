package baekjoon.그래프.연결_요소의_게수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[]   arr;
	static int[][] node;

	public static void main(String[] args) throws IOException {
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int             N  = Integer.parseInt(st.nextToken());
		int             M  = Integer.parseInt(st.nextToken());
		arr  = new int[N + 1];
		node = new int[N + 1][N + 1];


		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int tmp1 = Integer.parseInt(st.nextToken());
			int tmp2 = Integer.parseInt(st.nextToken());

			node[tmp1][tmp2] = 1;
			node[tmp2][tmp1] = 1;

		}

		Queue<Integer> q      = new LinkedList<>();
		int            result = 0;

		for (int i = 1; i <= N; i++) {
			if (arr[i] == 0) {

				result++;

				dfs(i);

			}
		}

		System.out.println(result);

	}

	public static void dfs(int idx) {

		if (arr[idx] == 1) {
			return;
		}

		arr[idx] = 1;

		for (int i = 1; i < node[idx].length; i++) {
			if (arr[i] == 0 && node[idx][i] == 1) {
				dfs(i);
			}
		}

	}

}
