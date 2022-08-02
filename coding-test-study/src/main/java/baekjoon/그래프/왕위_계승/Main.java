package baekjoon.그래프.왕위_계승;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	static HashMap<String, ArrayList<String>> map1 = new HashMap<>();
	static String                             king = "";

	public static void main(String[] args) throws IOException {

		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int             N  = Integer.parseInt(st.nextToken());
		int             M  = Integer.parseInt(st.nextToken());

		king = br.readLine();

		// 가족관계 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			String            tmp1 = st.nextToken();
			String            tmp2 = st.nextToken();
			String            tmp3 = st.nextToken();

			ArrayList<String> list = new ArrayList<String>();

			list.add(tmp2);
			list.add(tmp3);

			map1.put(tmp1, list);

		}
		double max     = 0;
		String maxName = "";
		for (int i = 0; i < M; i++) {
			// 지원자
			String name = br.readLine();
			double tmp  = dfs(name);
			if (tmp > max) {
				max     = tmp;
				maxName = name;
			}

		}

		System.out.println(maxName);

	}

	public static double dfs(String name) {

		ArrayList<String> list = map1.getOrDefault(name, new ArrayList<String>());

		// 부모가 없으면?
		if (list.isEmpty()) {
			// 왕이면 1 아니면 0
			if (name.equals(king)) {
				return 1;
			} else {
				return 0;
			}
		}

		return (dfs(list.get(0)) + dfs(list.get(1))) / 2;

	}
}
