package baekjoon.그래프.케빈_베이컨의_6단계_법칙;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] arr = new int[N + 1][N + 1];

		int max = M * 20;

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				arr[i][j] = max;
				if (i == j)
					arr[i][j] = 0;
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			arr[a][b] = 1;
			arr[b][a] = 1;
		}

		  for (int k = 1; k <= N; k++) {
	            for (int i = 1; i <= N; i++) {
	                for (int j = 1; j <= N; j++) {
	                  
//	                    if (arr[i][j] > arr[i][k] + arr[k][j]) {
//	                        arr[i][j] = arr[i][k] + arr[k][j];
//	                    }
	                	arr[i][j] = Math.min(arr[i][k] + arr[k][j], arr[i][j]);
	                }
	            }
	        }

//		for (int[] ar : arr) {
//			for (int a : ar) {
//				System.out.print(a + ", ");
//			}
//			System.out.println();
//		}

		int total = max;
		int idx = -1;

		for (int i = 1; i <= N; i++) {
			int result = 0;
			for (int j = 1; j <= N; j++) {
				result += arr[i][j];
			}

			if (result < total) {
				idx = i;
				total = result;
			}
		}

		System.out.println(idx);

	}
}
