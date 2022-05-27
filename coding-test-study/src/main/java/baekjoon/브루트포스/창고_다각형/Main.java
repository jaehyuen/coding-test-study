package baekjoon.브루트포스.창고_다각형;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		ArrayList<int[]> list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int tmp1 = Integer.parseInt(st.nextToken());
			int tmp2 = Integer.parseInt(st.nextToken());

			list.add(new int[] { tmp1, tmp2 });

		}

		// 기둥을 정렬한다
		Collections.sort(list, (o1, o2) -> {
			return o1[0] - o2[0];
		});

		int sum = 0;
		int idx = 0;

		// 왼쪽 크기를 구한다
		int[] prev = list.get(0);
		for (int i = 1; i < list.size(); i++) {
			int[] now = list.get(i);

			if (prev[1] <= now[1]) {
				sum += (now[0] - prev[0]) * prev[1];
				prev = now;
				idx = i;
			}
		}

		// 오른쪼고 크기를 구한다
		prev = list.get(list.size() - 1);

		for (int i = list.size() - 1; i >= idx; i--) {
			int[] now = list.get(i);

			if (prev[1] <= now[1]) {
				sum += (prev[0] - now[0]) * prev[1];
				prev = now;
			}
		}

		sum += list.get(idx)[1];

		System.out.println(sum);
	}
}