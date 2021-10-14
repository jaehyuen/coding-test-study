package baekjoon.구현.좌표_압축;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());

		}
		int[] arr2 = arr.clone();
		Arrays.sort(arr2);
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		StringBuilder sb = new StringBuilder();

		int idx = 0;
		for (int i = 0; i < N; i++) {
			if (!map.containsKey(arr2[i]))
				map.put(arr2[i], idx++);

		}

		for (int i = 0; i < N; i++) {

			sb.append(map.get(arr[i]) + " ");
		}

		System.out.println(sb.toString());
	}

}
