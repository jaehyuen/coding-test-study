package baekjoon.그래프.모두의_마블;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		LinkedList<Integer> list = new LinkedList<>();

		int idx = 0;
		int max = 0;

		// 제일 비싼 위치 저장
		for (int i = 0; i < N; i++) {
			int now = Integer.parseInt(st.nextToken());
			list.add(now);
			if (now > max) {
				max = now;
				idx = i;
			}
		}

		int gold = 0;

		// 한장이 남을떄까지 반복
		while (list.size() > 1) {

			// 가장큰 카드를 뽑는다
			int tmp1 = list.remove(idx);
			int tmp2 = 0;

			// 첫번쨰 카드 옆에중 한개를 뽑는다
			if (list.size() > idx) {
				tmp2 = list.remove(idx);
			} else {
				tmp2 = list.remove(--idx);

			}

			// 골드 증감
			gold += tmp1 + tmp2;

			// 다시 위치에 넣어준다
			if (tmp1 > tmp2) {
				list.add(idx, tmp1);
			} else {
				list.add(idx, tmp2);
			}
		}

		System.out.println(gold);

	}
}
