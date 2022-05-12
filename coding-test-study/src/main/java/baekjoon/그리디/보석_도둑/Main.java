package baekjoon.그리디.보석_도둑;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		// 보석 정보 리스트
		ArrayList<int[]> list = new ArrayList<>();
		// 가방 정보 배열
		int[] arr = new int[K];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			list.add(new int[] { M, V });
		}

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(st.nextToken());

		}

		// 보석을 무게순으로 정렬
		Collections.sort(list, (o1, o2) -> {
			return o1[0] - o2[0];
		});
		// 가방을 무게순으로 정렬
		Arrays.sort(arr);

		// 큐는 가격순
		PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> {
			if (o2[1] == o1[1]) {
				return o1[0] - o2[0];
			}
			return o2[1] - o1[1];
		});
		long result = 0;
		int idx = 0;
		for (int i = 0; i < K; i++) {

			// 가방의 무게에 맞는 보석들을 큐에 넣어줌
			while (idx < N && list.get(idx)[0] <= arr[i]) {
				int[] now = list.get(idx++);
				q.add(now);
			}
			// 그중 가장 무거운것을 가방에 넣어줌
			if (!q.isEmpty())
				result += q.poll()[1];
		}

		System.out.println(result);

	}

}
