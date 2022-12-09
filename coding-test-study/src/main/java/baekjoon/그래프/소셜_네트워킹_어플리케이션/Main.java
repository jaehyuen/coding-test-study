package baekjoon.그래프.소셜_네트워킹_어플리케이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static int[] arr;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder  sb = new StringBuilder();
		int            T  = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {

			int n = Integer.parseInt(br.readLine());

			// 부모 배열 초기화
			arr = new int[n];

			for (int j = 0; j < n; j++) {
				arr[j] = j;
			}

			// 친구사이 연결
			int k = Integer.parseInt(br.readLine());
			for (int j = 0; j < k; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());

				int             a  = find(Integer.parseInt(st.nextToken()));
				int             b  = find(Integer.parseInt(st.nextToken()));

				if (a != b) {
					arr[a] = b;

				}
			}

			// 시나리오 스트링 추가
			sb.append("Scenario " + (i + 1) + ":\n");

			// 친구 여부 확인
			int m = Integer.parseInt(br.readLine());
			for (int j = 0; j < m; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());

				int             a  = find(Integer.parseInt(st.nextToken()));
				int             b  = find(Integer.parseInt(st.nextToken()));

				if (a != b) {
					sb.append(0 + "\n");
				} else {
					sb.append(1 + "\n");
				}
			}
			sb.append("\n");

		}

		System.out.println(sb);

	}

	public static int find(int node) {
		if (node == arr[node]) {
			return node;
		}

		return arr[node] = find(arr[node]);
	}

}
