package baekjoon.자료구조.숫자_카드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader            br  = new BufferedReader(new InputStreamReader(System.in));

		int                       N   = Integer.parseInt(br.readLine());

		StringTokenizer           st;
		StringBuilder             sb  = new StringBuilder();

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {

			int index = Integer.parseInt(st.nextToken());
			map.put(index, map.getOrDefault(index, 0) + 1);
		}

		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < M; i++) {

			sb.append(map.getOrDefault(Integer.parseInt(st.nextToken()), 0) + " ");
		}
		System.out.println(sb.toString());

	}

}
