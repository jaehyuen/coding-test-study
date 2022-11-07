package baekjoon.그리디.통나무_건너뛰기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder  sb = new StringBuilder();
		int            T  = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			int             N   = Integer.parseInt(br.readLine());
			int[]           arr = new int[N];

			StringTokenizer st  = new StringTokenizer(br.readLine());

			// 통나무 입력
			for (int j = 0; j < N; j++) {
				arr[j] = Integer.parseInt(st.nextToken());

			}

			// 통나무 정렬
			Arrays.sort(arr);

			Deque<Integer> list = new LinkedList<Integer>();
			boolean        flag = true;

			// 높이가 높은 통나무부터 오른쪽 왼쪽순으로 정렬
			for (int j = N - 1; j >= 0; j--) {

				if (flag) {
					list.addFirst(arr[j]);
				} else {
					list.addLast(arr[j]);
				}
				flag = !flag;

			}

			int max   = 0;
			int first = list.poll();
			int prev  = first;

			// 현재와 이전의 절대값을 구해서 최대값 갱신
			while (!list.isEmpty()) {
				int now = list.poll();
				max  = Math.max(Math.abs(prev - now), max);
				prev = now;
			}

			// 처음과 마지 절대값을 구해서 최대값 갱신
			max = Math.max(Math.abs(first - prev), max);

			sb.append(max + "\n");
		}
		System.out.println(sb.toString());

	}

}
