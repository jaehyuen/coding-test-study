package baekjoon.그래프.숨바꼭질;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		// 경로 저장
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();

		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			// 양쪽으로 연결
			list.get(A).add(B);
			list.get(B).add(A);
		}

		Queue<Integer> q = new LinkedList<Integer>();
		int[] v = new int[N + 1];

		// 가장 먼거리 체크용 변수
		int max = 0;

		// 시작 지점 추가
		q.add(1);
		v[1] = 1;

		while (!q.isEmpty()) {
			int now = q.poll();

			for (int next : list.get(now)) {

				// 방문 안했을때
				if (v[next] == 0) {
					q.add(next);
					v[next] = v[now] + 1;
					max = Math.max(v[next], max);
				}
			}
		}

		int idx = 0;
		int cnt = 0;

		for (int i = 1; i <= N; i++) {

			// 숨어야하는 헛간 체크
			if (idx == 0 && v[i] == max) {
				idx = i;
			}

			// 같은 거리 체크
			if (v[i] == max) {
				cnt++;
			}
		}

		System.out.println(idx + " " + (max - 1) + " " + cnt);
	}

}
