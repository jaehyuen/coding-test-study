package baekjoon.브루트포스.치킨치킨치킨;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static int[][] map;
	public static int[] arr;

	public static int N;
	public static int M;

	public static int cnt = 0;;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		arr = new int[3];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		find(0, 0);

		System.out.println(cnt);

	}

	public static void find(int n, int start) {

		// 치킨 3개를 조합하면 최대값을 계산한다
		if (n == 3) {
			int total = 0;

			for (int i = 0; i < N; i++) {

				int max = 0;
				for (int j : arr) {
					max = Math.max(map[i][j], max);
				}
				total += max;
			}
			cnt = Math.max(cnt, total);
			return;
		}

		for (int i = start; i < M; i++) {
			arr[n] = i;
			find(n + 1, i + 1);
		}
	}
}