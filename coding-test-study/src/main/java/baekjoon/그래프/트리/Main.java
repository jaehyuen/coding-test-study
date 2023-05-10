package baekjoon.그래프.트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static int N;
	public static int remove;
	public static int cnt = 0;
	public static List<List<Integer>> tree = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int start = 0;

		// 트리 초기 세팅
		for (int i = 0; i < N; i++) {
			tree.add(new ArrayList<>());
		}
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			int tmp = Integer.parseInt(st.nextToken());

			if (tmp != -1) {
				// 트리 연결
				tree.get(tmp).add(i);
			} else {

				// 탐색 지점 추가
				start = i;
			}
		}
		remove = Integer.parseInt(br.readLine());

		if (remove != start) {
			// 시작 지점을 삭제하는게 아니라면 탐색 시작
			find(start);
		}
		System.out.println(cnt);

	}

	public static void find(int now) {

		int tmp = 0;

		// 자식 노드 탐색
		for (int next : tree.get(now)) {

			// 삭제된 노드가 아니면 탐색
			if (next != remove) {
				tmp++;
				find(next);
			}

		}

		// 자식이 없으면 카운트 증가
		if (tmp == 0) {
			cnt++;
		}

	}

}
