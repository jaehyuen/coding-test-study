package baekjoon.구현.추월;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader           br  = new BufferedReader(new InputStreamReader(System.in));
		int                      N   = Integer.parseInt(br.readLine());
		HashMap<String, Integer> map = new HashMap<>();

		// 들어가는 차 저장
		for (int i = 0; i < N; i++) {
			map.put(br.readLine(), i);
		}

		// 나가는 차 저장 배열
		int[] out = new int[N];

		for (int i = 0; i < N; i++) {

			out[i] = map.get(br.readLine());
		}

		int cnt = 0;
		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				if (out[i] > out[j]) {
					cnt++;
					break;
				}
			}
		}
		System.out.println(cnt);

	}
}
