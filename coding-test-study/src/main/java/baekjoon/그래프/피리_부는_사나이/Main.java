package baekjoon.그래프.피리_부는_사나이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	public static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		char[][] map = new char[N][M];
		arr = new int[N * M];

		// 유니온 파인드를 위해 초기화
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i;
		}

		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}

		// 모든 위치를 묶는다
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {

				int nextX = i;
				int nextY = j;

				if (map[i][j] == 'U') {
					nextX--;
				} else if (map[i][j] == 'D') {
					nextX++;
				} else if (map[i][j] == 'L') {
					nextY--;
				} else if (map[i][j] == 'R') {
					nextY++;
				}

				int a = find((nextX * M) + nextY);
				int b = find((i * M) + j);
				if (a != b) {
					arr[b] = a;
				}

			}
		}

		HashSet<Integer> set = new HashSet<>();

		// 부모의 갯수를 카운팅
		for (int i = 0; i < arr.length; i++) {

			arr[i] = find(i);
			set.add(arr[i]);
		}

		System.out.println(set.size());

	}

	public static int find(int node) {
		if (node == arr[node]) {
			return node;
		}

		return arr[node] = find(arr[node]);
	}
}
