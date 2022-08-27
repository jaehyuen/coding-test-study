package baekjoon.그래프.트리의_지름;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static ArrayList<ArrayList<int[]>> tree = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i <= n; i++) {
			tree.add(new ArrayList<>());
		}

		// 트리 연결
		for (int i = 0; i < n - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int tmp1 = Integer.parseInt(st.nextToken());
			int tmp2 = Integer.parseInt(st.nextToken());
			int tmp3 = Integer.parseInt(st.nextToken());

			tree.get(tmp1).add(new int[] { tmp2, tmp3 });
		}

		int max = 0;
		for (int i = 1; i <= n; i++) {

			ArrayList<int[]> now = tree.get(i);

			int max1 = 0;
			int max2 = 0;

			for (int j = 0; j < now.size(); j++) {

				int tmp = dfs(now.get(j));

				// 1, 2번쨰로 긴 길이를 구한다
				if (tmp > max1) {
					max2 = max1;
					max1 = tmp;
				} else if (tmp > max2) {
					max2 = tmp;
				}
			}

			// 두 길이를 더해 최대값에 저장
			max = Math.max(max, max1 + max2);

		}
		System.out.println(max);
	}

	public static int dfs(int[] now) {
		int dis = 0;

		for (int[] next : tree.get(now[0])) {
			dis = Math.max(dis, dfs(next));
		}

		return dis + now[1];
	}
}
