package baekjoon.그리디.저울;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader  br  = new BufferedReader(new InputStreamReader(System.in));

		int             N   = Integer.parseInt(br.readLine());
		int[]           arr = new int[N];
		StringTokenizer st  = new StringTokenizer(br.readLine());

		// 추 입력
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// 추를 가벼운순으로 정렬
		Arrays.sort(arr);

		int sum = 0;
		for (int i = 0; i < N; i++) {

			// 지금까지 누적합에 1을 더한것보다 현재 추가 더 무거우면 누적합에 1을 더한값을 못만든다
			if (sum + 1 < arr[i]) {
				break;
			}
			sum += arr[i];

		}

		System.out.println(sum + 1);

	}

}
