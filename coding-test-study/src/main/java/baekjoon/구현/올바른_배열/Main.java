package baekjoon.구현.올바른_배열;

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

		// 배열 정렬
		Arrays.sort(arr);

		// 시작, 끝 값
		int start = 0;
		int end   = 0;

		// 최소값
		int min   = 51;

		while (end < N) {

			// 시작과 끝의 차이가 5이고 5개를 포함하면 올바른 배열이라 바로 리턴
			if (arr[end] - arr[start] == 5 && (end - start + 1) == 5) {
				System.out.println(0);
				return;
			}

			// 둘의 차이가 5이하이면 최소값 갱신
			if ((arr[end] - arr[start]) < 5) {
				min = Math.min(min, 5 - (end - start + 1));
			}

			if (end - start >= 4) {
				//5개 이상 벌어지면 시작 지점을 움직임
				start++;
			} else if (arr[end] - arr[start] >= 5) {
				// 양끝 차이가 5이상이면 시작 지점을 움직임
				start++;
			} else {
				end++;
			}

		}
		System.out.println(min);

	}
}
