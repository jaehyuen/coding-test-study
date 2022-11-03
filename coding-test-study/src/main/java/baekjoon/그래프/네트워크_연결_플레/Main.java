package baekjoon.그래프.네트워크_연결_플레;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int[] arr1;
	public static int[] arr2;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder  sb = new StringBuilder();
		int            T  = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());

			arr1 = new int[N + 1];
			arr2 = new int[N + 1];

			for (int j = 0; j <= N; j++) {
				arr1[j] = j;
			}

			while (true) {

				StringTokenizer st   = new StringTokenizer(br.readLine());
				String          func = st.nextToken();

				if (func.equals("O")) {
					break;
				} else if (func.equals("I")) {

					// 둘이 이어준다
					int I   = Integer.parseInt(st.nextToken());
					int J   = Integer.parseInt(st.nextToken());

					int tmp = (Math.abs(I - J) % 1000);

					arr1[I] = J;

					// 라인의 길이를 저장한다
					arr2[I] = tmp;

				} else {
					int I = Integer.parseInt(st.nextToken());

					// 길이를 찾는다
					find(I);
					sb.append(arr2[I] + "\n");

				}

			}

		}
		System.out.println(sb.toString());

	}

	public static int find(int node) {
		if (node == arr1[node]) {
			return node;
		}

		int result = find(arr1[node]);
		arr2[node] += arr2[arr1[node]];
		arr1[node]  = result;

		return result;
	}
}
