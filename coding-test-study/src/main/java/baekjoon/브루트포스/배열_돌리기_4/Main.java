package baekjoon.브루트포스.배열_돌리기_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int[][]   cal;
	public static boolean[] v;
	public static int       K;
	public static int       min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int             N  = Integer.parseInt(st.nextToken());
		int             M  = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		int[][] arr = new int[N][M];

		cal = new int[K][3];
		v   = new boolean[K];

		// 초기 배열 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}

		}

		// 연산 입력
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());

			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());

			cal[i][0] = r;
			cal[i][1] = c;
			cal[i][2] = s;
		}
		find(0, arr);

		System.out.println(min);

	}

	public static void find(int idx, int[][] arr) {

		// 연산이 다 끝났을때
		if (idx == K) {

			// 최소값 구하기
			for (int[] ar : arr) {
				int sum = 0;
				for (int a : ar) {
					sum += a;
				}
				min = Math.min(sum, min);
			}

			return;
		}

		for (int i = 0; i < K; i++) {
			if (!v[i]) {
				v[i] = true;

				// 배열 복사
				int[][] newArr = copyArr(arr);

				// 배열 돌리기
				moveArr(newArr, cal[i]);

				// 다음 연산 실행
				find(idx + 1, newArr);

				v[i] = false;
			}
		}

	}

	public static void moveArr(int[][] arr, int[] cal) {
		int startX = cal[0] - cal[2] - 1;
		int startY = cal[1] - cal[2] - 1;
		int endX   = cal[0] + cal[2] - 1;
		int endY   = cal[1] + cal[2] - 1;

		while (startX < endX && startY < endY) {

			int prev = arr[startX][startY];

			// 오른쪽 방향
			for (int i = startY + 1; i <= endY; i++) {

				int tmp = arr[startX][i];
				arr[startX][i] = prev;
				prev           = tmp;

			}

			// 아래쪽 방향
			for (int i = startX + 1; i <= endX; i++) {

				int tmp = arr[i][endY];
				arr[i][endY] = prev;
				prev         = tmp;

			}

			// 왼쪽 방향
			for (int i = endY - 1; i >= startY; i--) {

				int tmp = arr[endX][i];
				arr[endX][i] = prev;
				prev         = tmp;

			}

			// 위쪽 방향
			for (int i = endX - 1; i >= startX; i--) {

				int tmp = arr[i][startY];
				arr[i][startY] = prev;
				prev           = tmp;

			}

			startX++;
			startY++;
			endX--;
			endY--;

		}

	}

	public static int[][] copyArr(int[][] arr) {

		int[][] newArr = new int[arr.length][arr[0].length];

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				newArr[i][j] = arr[i][j];
			}

		}

		return newArr;
	}

}