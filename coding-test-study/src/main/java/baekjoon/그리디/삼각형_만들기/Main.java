package baekjoon.그리디.삼각형_만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		int            N   = Integer.parseInt(br.readLine());

		int[]          arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(arr);
		// System.out.println(Arrays.toString(arr));

		int result = -1;
		for (int i = N - 1; i > 1; i--) {
			if (arr[i] < arr[i - 1] + arr[i - 2]) {
				result = arr[i] + arr[i - 1] + arr[i - 2];
				break;
			}
		}

		System.out.println(result);

	}
}
