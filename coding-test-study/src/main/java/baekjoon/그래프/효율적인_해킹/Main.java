package baekjoon.그래프.효율적인_해킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	static HashMap<Integer, ArrayList<Integer>> map;
	static boolean[] v;
	static int[] result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int max = Integer.MIN_VALUE;

		// 방문, 해킹 가능 갯수 저장 배열
		v = new boolean[N + 1];
		result = new int[N + 1];

		// 신뢰정보 저장 맵
		map = new HashMap<Integer, ArrayList<Integer>>();

		for (int i = 0; i < M; i++) {

			st = new StringTokenizer(br.readLine());

			int tmp1 = Integer.parseInt(st.nextToken());
			int tmp2 = Integer.parseInt(st.nextToken());

			ArrayList<Integer> set = map.getOrDefault(tmp1, new ArrayList<Integer>());
			set.add(tmp2);

			map.put(tmp1, set);

		}

		// 해킹 가능 대수 dfs로 파악
		for (int i = 1; i <= N; i++) {

			Arrays.fill(v, false);
			v[i] = true;
			dfs(i);

		}

		// 최대 해킹 가능 대수 확인
		for (int i = 1; i <= N; i++) {
			max = Math.max(max, result[i]);
		}

		// 최대 가능한 경우를 오름차순으로 출력
		for (int i = 1; i <= N; i++) {
			if (result[i] == max) {
				sb.append(i + " ");

			}
		}
		System.out.println(sb.toString());
		System.out.println(Arrays.toString(result));
	}

	public static void dfs(int now) {
		for (int next : map.getOrDefault(now, new ArrayList<Integer>())) {
			if (!v[next]) {
				v[next] = true;
				result[next]++;
				dfs(next);

			}
		}
	}
}
