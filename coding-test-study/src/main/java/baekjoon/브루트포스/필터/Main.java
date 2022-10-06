package baekjoon.브루트포스.필터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader  br  = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  = new StringTokenizer(br.readLine());

		int             R   = Integer.parseInt(st.nextToken());
		int             C   = Integer.parseInt(st.nextToken());

		int[][]         arr = new int[R][C];

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int T   = Integer.parseInt(br.readLine());
		int cnt = 0;

		// 필터링 시작
		for (int i = 0; i < R - 2; i++) {
			for (int j = 0; j < C - 2; j++) {
				ArrayList<Integer> list = new ArrayList<Integer>();

				list.add(arr[i][j]);
				list.add(arr[i][j + 1]);
				list.add(arr[i][j + 2]);
				list.add(arr[i + 1][j]);
				list.add(arr[i + 1][j + 1]);
				list.add(arr[i + 1][j + 2]);
				list.add(arr[i + 2][j]);
				list.add(arr[i + 2][j + 1]);
				list.add(arr[i + 2][j + 2]);

				Collections.sort(list);
				if (list.get(4) >= T) {
					cnt++;
				}
			}
		}

		System.out.println(cnt);
	}
}
