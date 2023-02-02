package baekjoon.그리디.등수_매기기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		int            N   = Integer.parseInt(br.readLine());

		int[]          arr = new int[N];

		// 예상 등수 입력
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		// 예상 등수 정렬
		Arrays.sort(arr);

		long cnt = 0;

		// 불만도 카운팅
		for (int i = 1; i <= N; i++) {
			cnt += Math.abs(arr[i - 1] - i);
		}

		System.out.println(cnt);
	}

}
