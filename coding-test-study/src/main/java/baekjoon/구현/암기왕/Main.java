package baekjoon.구현.암기왕;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < T; i++) {

			HashMap<Integer, Boolean> map = new HashMap<>();
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());

			// 수첩1 작성
			for (int j = 0; j < N; j++) {
				map.put(Integer.parseInt(st.nextToken()), true);
			}

			int M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());

			// 수첩2 작성
			for (int j = 0; j < M; j++) {

				if (map.getOrDefault(Integer.parseInt(st.nextToken()), false)) {
					sb.append(1 + "\n");
				} else {
					sb.append(0 + "\n");
				}
			}
		}
		System.out.println(sb.toString());

	}
}
