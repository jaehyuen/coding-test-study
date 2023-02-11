package baekjoon.그리디.수_고르기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];

		st = new StringTokenizer(br.readLine());

		// 수 입력
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// 정렬
		Arrays.sort(arr);

		int sum = 0;

		// 가장 큰수를 K 만큼 더해주고 0~K 까지 더한 수를 뺴주면 최대값이다
		for (int i = 0; i < K; i++) {
			sum += arr[N - 1 - i];
			sum -= i;
		}

		System.out.println(sum);
	}

}
