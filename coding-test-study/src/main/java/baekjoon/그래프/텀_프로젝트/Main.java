package baekjoon.그래프.텀_프로젝트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static int[]     arr;
	public static boolean[] v1;
	public static boolean[] v2;

	public static int       cnt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int            T  = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			int             n  = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());

			// 지목 배열
			arr = new int[n + 1];

			// 방문 체크
			v1  = new boolean[n + 1];
			// 사이클 체크
			v2  = new boolean[n + 1];

			cnt = 0;
			// 지목 리스트 입력
			for (int j = 1; j <= n; j++) {

				arr[j] = Integer.parseInt(st.nextToken());

				// 본인 지목은 팀이 완성됨
				if (arr[j] == j) {
					v1[j] = true;
					v2[j] = true;
					cnt++;
				}
			}

			for (int j = 1; j <= n; j++) {
				if (!v2[j]) {
					find(j);
				}
			}
			System.out.println(n - cnt);

		}
	}

	public static void find(int now) {
		if (v1[now]) {
			// 방문 한곳이면 리턴
			return;
		}

		// 방문 처리
		v1[now] = true;

		if (!v1[arr[now]]) {
			find(arr[now]);
		} else {

			// 다음노드가 이미 방문한곳 이면 그 노드는 무조건 싸이클이 존재한다
			if (v2[arr[now]] != true) {
				cnt++;
				for (int i = arr[now]; i != now; i = arr[i])
					cnt++;
			}
		}
		v2[now] = true;
	}

}
