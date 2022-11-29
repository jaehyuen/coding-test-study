package baekjoon.그래프.영우는_사기꾼;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader              br   = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer             st   = new StringTokenizer(br.readLine());

		int                         N    = Integer.parseInt(st.nextToken());
		int                         M    = Integer.parseInt(st.nextToken());
		int                         K    = Integer.parseInt(st.nextToken());

		int[]                       arr  = new int[N + 1];
		int[]                       cnt  = new int[N + 1];
		ArrayList<HashSet<Integer>> list = new ArrayList<HashSet<Integer>>();

		for (int i = 0; i <= N; i++) {
			list.add(new HashSet<Integer>());
		}

		// 위상 정렬용 변수
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int X = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());

			arr[Y]++;
			list.get(X)
				.add(Y);

		}

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());

			int cmd = Integer.parseInt(st.nextToken());
			int a   = Integer.parseInt(st.nextToken());

			// 생성 일때
			if (cmd == 1) {

				// 차수가 0 일떄만 만들수 잇다
				if (arr[a] == 0) {

					// 처음 지은거면 연관된 건물 차수를 줄여줌
					if (cnt[a] == 0) {
						for (int b : list.get(a)) {
							arr[b]--;
						}
					}

					// 건물갯수 증가
					cnt[a]++;
				} else {
					System.out.println("Lier!");
					return;
				}

			} else {

				// 건물이 갯수가 0이 아니면 삭제
				if (cnt[a] != 0) {
					cnt[a]--;

					// 건물이 없으면 연관된 건물의 찻수 증가
					if (cnt[a] == 0) {
						for (int b : list.get(a)) {
							arr[b]++;
						}
					}
				} else {
					System.out.println("Lier!");
					return;
				}

			}

		}
		System.out.println("King-God-Emperor");

	}
}
