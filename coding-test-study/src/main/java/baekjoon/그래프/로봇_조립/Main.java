package baekjoon.그래프.로봇_조립;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static HashMap<Integer, Integer> parent = new HashMap<Integer, Integer>();
	public static HashMap<Integer, Integer> cnt = new HashMap<Integer, Integer>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			if (st.nextToken().equals("I")) {
				// 부품끼리 연결
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				a = find(a);
				b = find(b);

				if (a != b) {
					// 부모 갱신 및 카운트 갱신
					if (a > b) {
						parent.put(a, b);
						cnt.put(b, cnt.getOrDefault(b, 1) + cnt.getOrDefault(a, 1));
					} else {
						parent.put(b, a);
						cnt.put(a, cnt.getOrDefault(b, 1) + cnt.getOrDefault(a, 1));
					}

				}

			} else {

				// 노드의 부모를 찾아 카운트 출력
				int node = find(Integer.parseInt(st.nextToken()));

				sb.append(cnt.getOrDefault(node, 1) + "\n");

			}
		}
		System.out.println(sb.toString());

	}

	public static int find(int node) {

		// 현재 노드의 부모 조회
		int now = parent.getOrDefault(node, node);

		// 현재 노드가 부모이면 리턴
		if (now == node) {
			return node;
		}

		int result = find(now);
		parent.put(node, result);

		return result;
	}

}
