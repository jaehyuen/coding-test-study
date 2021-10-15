package baekjoon.분할정복.Z;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
//	static int[][] arr;
//	static int[] xArr = { 0, 1, 0, 1 };
//	static int[] yArr = { 0, 0, 1, 1 };
	static int N;
	static int r;
	static int c;
	static int cnt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		double size = Math.pow(2, N);
//		arr = new int[(int) size][(int) size];
//
//		test(N, 0, 0, 0);
//
//		System.out.println(arr[r][c]);
		test((int) size, r, c);
		System.out.println(cnt);
	}

	public static void test(int size, int r, int c) {
		int nextSize = size / 2;
		if (size == 1) {
			return;
		} else {
			if (r < nextSize && c < nextSize) {
				test(nextSize, r, c);
			} else if (r < nextSize && c >= nextSize) {
				cnt += nextSize * nextSize;
				test(nextSize, r, c - nextSize);

			} else if (r >= nextSize && c < nextSize) {
				cnt += nextSize * nextSize * 2;
				test(nextSize, r - nextSize, c);

			} else if (r >= nextSize && c >= nextSize) {
				cnt += nextSize * nextSize * 3;
				test(nextSize, r - nextSize, c - nextSize);
			}
		}

	}

//	public static int test(int N, int x, int y, int cnt) {
//		double size = Math.pow(2, N);
//		if (arr[r][c] != 0) {
//			return 0;
//		}
//		if (N > 1) {
//
//			cnt = test(N - 1, x, y, cnt);
//			cnt = test(N - 1, x + (int) size / 2, y, cnt);
//			cnt = test(N - 1, x, y + (int) size / 2, cnt);
//			cnt = test(N - 1, x + (int) size / 2, y + (int) size / 2, cnt);
//		} else {
//			for (int i = 0; i < 4; i++) {
//
//				arr[y + yArr[i]][x + xArr[i]] = cnt++;
//			}
//		}
//
//		return cnt;
//	}

}
