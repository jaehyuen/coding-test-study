package baekjoon.분할정복.종이의_개수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int a = 0;
	static int b = 0;
	static int c = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		int[][] arr = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {

				arr[i][j] = Integer.parseInt(st.nextToken());

			}
		}

		test(arr, 0, 0, N);
		System.out.println(c);
		System.out.println(a);
		System.out.println(b);

	}

	public static void test(int[][] arr, int y, int x, int size) {
		int paper = arr[y][x];

		boolean isPaper = true;

		for (int i = y; i < y + size; i++) {
			for (int j = x; j < x + size; j++) {
				// 다른게 발견되면?
				if (arr[i][j] != paper) {
					isPaper = false;
					break;
				}
			}
		}

		if (isPaper && paper == 0) {
			a++;
			return;
		} else if (isPaper && paper == 1) {
			b++;
			return;
		} else if (isPaper && paper == -1) {
			c++;
			return;
		}

		size /= 3;

		if (size < 1) {
			return;
		}

		test(arr, y, x, size); 
		test(arr, y, x + size, size); 
		test(arr, y, x + (size * 2), size); 
		test(arr, y + size, x, size);
		test(arr, y + size, x + size, size);
		test(arr, y + size, x + (size * 2), size);
		test(arr, y + (size * 2), x, size);
		test(arr, y + (size * 2), x + size, size);
		test(arr, y + (size * 2), x + (size * 2), size);
	
	}

}
