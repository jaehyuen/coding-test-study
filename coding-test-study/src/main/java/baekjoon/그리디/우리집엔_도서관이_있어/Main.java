package baekjoon.그리디.우리집엔_도서관이_있어;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		int            N   = Integer.parseInt(br.readLine());

		int[]          arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());

		}

		int cnt = 0;

		// 가장 큰수부터 정렬되잇는 갯수를 구한다
		for (int i = N - 1; i >= 0; i--) {

			if (arr[i] == N - cnt) {
				cnt++;
			}

		}
		System.out.println(N - cnt);

	}

}
