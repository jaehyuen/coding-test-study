package baekjoon.그리디.시간_관리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		ArrayList<int[]> list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int T = Integer.parseInt(st.nextToken());
			int S = Integer.parseInt(st.nextToken());

			list.add(new int[] { T, S });
		}

		// 마감시간이 늦은 순으로 정렬
		Collections.sort(list, (o1, o2) -> {
			return o2[1] - o1[1];
		});

		// 마감시간이 젤 늦은 작업을 먼저 진행
		int[] now = list.get(0);
		int time = now[1] - now[0];

		for (int i = 1; i < N; i++) {
			now = list.get(i);

			// 현재 시간이 지금 해야할 작업의 마감시간보다 늦엇으면 다시 돌린다
			if (time > now[1]) {
				time = now[1];
			}
			time -= now[0];
		}

		// 시간이 0보다 빠르면(적으면) -1 출력
		System.out.println(time < 0 ? -1 : time);

	}

}
