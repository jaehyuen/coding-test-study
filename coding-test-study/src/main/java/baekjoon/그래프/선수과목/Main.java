package baekjoon.그래프.선수과목;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		//간선수 및 최종 결과 저장용 배열
		int[] arr = new int[N + 1];

		//그래프용 리스트
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();

		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int tmp1 = Integer.parseInt(st.nextToken());
			int tmp2 = Integer.parseInt(st.nextToken());

			list.get(tmp1).add(tmp2);
			arr[tmp2]++;
		}

		Queue<int[]> q = new LinkedList<>();
		
		//간선이 0인 노드만 큐에 추가
		for (int i = 1; i <= N; i++) {
			if (arr[i] == 0) {
				q.add(new int[] { i, 1 });
			}
		}

		while (!q.isEmpty()) {
			
			//배열에 두번쨰 요소가 정렬 순서이니 배열에 넣어줌
			int[] now = q.poll();
			arr[now[0]] = now[1];
			
			for (int next : list.get(now[0])) {
				arr[next]--;

				if (arr[next] == 0) {
					q.add(new int[] { next, now[1] + 1 });
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			sb.append(arr[i] + " ");
		}
		System.out.println(sb.toString());
	}

}
