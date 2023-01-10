package baekjoon.그리디.방탈출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader  br  = new BufferedReader(new InputStreamReader(System.in));

		int             N   = Integer.parseInt(br.readLine());
		boolean[]       arr = new boolean[N + 2];

		StringTokenizer st  = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			if (Integer.parseInt(st.nextToken()) == 1) {
				arr[i] = true;
			}
		}
		int cnt = 0;
		for (int i = 0; i < N; i++) {

			// 0(false)로 변경
			if (arr[i]) {

				cnt++;

				// 오른쪽 두개도 변경
				arr[i + 1] = !arr[i + 1];
				arr[i + 2] = !arr[i + 2];
			}
		}

		System.out.println(cnt);

	}

}
