package baekjoon.브루트포스.도영이가_만든_맛있는_음식;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[][] arr;
	static boolean[] v;
	static int N;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		arr = new int[N][2];
		v = new boolean[N];

		// 신맛, 쓴맛 저장
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int tmp1 = Integer.parseInt(st.nextToken());
			int tmp2 = Integer.parseInt(st.nextToken());

			arr[i][0] = tmp1;
			arr[i][1] = tmp2;

		}

		// 모든 경우의수를 파악해본다
		for (int i = 0; i < N; i++) {
			v[i] = true;
			find(arr[i][1], arr[i][0]);
			v[i] = false;
		}
		System.out.println(min);

	}

	public static void find(int sum, int mul) {

		min = Math.min(Math.abs(sum - mul), min);

		for (int i = 0; i < N; i++) {
			if (!v[i]) {
				v[i] = true;
				find(arr[i][1] + sum, arr[i][0] * mul);
				v[i] = false;
			}

		}

	}
}