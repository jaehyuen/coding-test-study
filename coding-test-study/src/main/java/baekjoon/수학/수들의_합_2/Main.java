package baekjoon.수학.수들의_합_2;

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
		int M = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int start = 0;
		int end = 0;

		int cnt = 0;
		while (start < N && end < N) {

			// 시작, 끝 까지 값을 더한다
			int sum = 0;
			for (int i = start; i <= end; i++) {
				sum += arr[i];
			}

			// 더한 값이 같으면 카운트 증가 및 시작 위치 증가
			if (sum == M) {
				cnt++;
				start++;
			} else if (sum > M) {
				// 더한 값이 크면 시작 위치 증가
				start++;
			} else if (sum < M && end < N) {
				// 더한 값이 작으며 배열 길이보다 작으면 끝 위치 증가
				end++;
			}

		}

		System.out.println(cnt);

	}
}
