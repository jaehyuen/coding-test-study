package baekjoon.구현.I_AM_IRONMAN;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int             N  = Integer.parseInt(st.nextToken());
		int             P  = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		int                     W   = Integer.parseInt(st.nextToken());
		int                     L   = Integer.parseInt(st.nextToken());
		int                     G   = Integer.parseInt(st.nextToken());

		HashMap<String, String> map = new HashMap<String, String>();

		for (int i = 0; i < P; i++) {
			st = new StringTokenizer(br.readLine());

			String name = st.nextToken();
			String flag = st.nextToken();

			map.put(name, flag);

		}

		int score = 0;

		for (int i = 0; i < N; i++) {
			String flag = map.getOrDefault(br.readLine(), "L");

			// 이미 탈출햇으면 무시
			if (score >= G)
				continue;

			if (flag.equals("W")) {
				// 이겼을때
				score += W;
			} else {
				// 졌을때
				score -= L;
			}

			// 점수가 0보다 작으면 초기화
			if (score < 0) {
				score = 0;
			}

		}

		if (score >= G) {
			System.out.println("I AM NOT IRONMAN!!");
		} else {
			System.out.println("I AM IRONMAN!!");
		}

	}
}
