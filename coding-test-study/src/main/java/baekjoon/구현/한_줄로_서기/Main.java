package baekjoon.구현.한_줄로_서기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] arr1 = new int[N];
		int[] arr2 = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr1[i] = Integer.parseInt(st.nextToken());
		}

		arr2[arr1[0]] = 1;

		for (int i = 1; i < N; i++) {
			int cnt = 0;
			for (int j = 0; j < N; j++) {
				if (cnt == arr1[i] && arr2[j] == 0) {
					arr2[j] = i + 1;
					break;
				}
				if (cnt == arr1[i]) {
					continue;
				}
				if (arr2[j] == 0 || arr2[j] > i + 1) {
					cnt++;
				}

			}
		}

		for (int i : arr2) {
			System.out.print(i + " ");
		}

	}

}
