package baekjoon.그래프.숨바꼭질_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		if (N > K) {
			// 현재 위치가 동생의 위치보다 크면 무조건 N - K 번 뒤로 이동
			System.out.println(N - K);
			StringBuilder sb = new StringBuilder();

			for (int i = N; i >= K; i--) {
				sb.append(i + " ");
			}

			System.out.println(sb.toString());
			return;
		}

		// 이전 경로를 저장해주는 배열
		int[] v = new int[100001];

		Queue<Integer> q = new LinkedList<>();
		q.add(N);
		Arrays.fill(v, -1);

		while (!q.isEmpty()) {
			int now = q.poll();

			// 동생 위치를 방문햇으면 종료
			if (v[K] != -1) {
				break;
			}

			add(now * 2, now, q, v);
			add(now + 1, now, q, v);
			add(now - 1, now, q, v);

		}

		int now = K;
		int cnt = 0;
		String route = "";

		v[N] = -1;
		while (true) {
			route = now + " " + route;

			if (v[now] == -1) {
				break;
			}

			// 경로 카운트 증가
			cnt++;
			// 이전 위치로 이동
			now = v[now];
		}

		System.out.println(cnt);
		System.out.println(route);
	}

	public static void add(int next, int now, Queue<Integer> q, int[] v) {

		// 위치 범위 체크
		if (next < 0 || next > 100000) {
			return;
		}

		// 방문 체크
		if (v[next] == -1) {
			// 위치 범위에 들어가면 큐에 등록
			q.add(next);

			// 이전 위치 등록
			v[next] = now;
		}
	}

}
