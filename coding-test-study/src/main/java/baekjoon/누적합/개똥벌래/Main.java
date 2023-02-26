package baekjoon.누적합.개똥벌래;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());

		int[] bottom = new int[H + 1];
		int[] top = new int[H + 1];

		int[] cnt = new int[H];

		for (int i = 0; i < N / 2; i++) {

			// 석순, 종류석 입력
			int b = Integer.parseInt(br.readLine());
			int t = Integer.parseInt(br.readLine());

			// 석순, 종류석의 끝점 카운트
			bottom[b]++;
			top[H - t + 1]++;

		}

		// 높이에 따라 파과하는 카운트를 늘린다
		for (int i = H - 1; i >= 1; i--) {
			bottom[i] += bottom[i + 1];
		}

		int min = Integer.MAX_VALUE;
		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i = 1; i <= H; i++) {
			top[i] += top[i - 1];
			cnt[i - 1] = top[i] + bottom[i];

			// 최소값 갱신
			min = Math.min(cnt[i - 1], min);

			// 횟수별 카운팅
			map.put(cnt[i - 1], map.getOrDefault(cnt[i - 1], 0) + 1);

		}
		System.out.println(min + " " + map.get(min));

	}

}
