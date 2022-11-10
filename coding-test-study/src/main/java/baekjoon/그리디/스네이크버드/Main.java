package baekjoon.그리디.스네이크버드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader  br  = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  = new StringTokenizer(br.readLine());

		int             N   = Integer.parseInt(st.nextToken());
		int             L   = Integer.parseInt(st.nextToken());

		int[]           arr = new int[N];

		st = new StringTokenizer(br.readLine());

		// 과일 높이 입력 및 정렬
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		// 먹을수 있을떄까지 카운팅
		for (int i = 0; i < N; i++) {
			if (arr[i] <= L) {
				L++;
			} else {
				break;
			}
		}

		System.out.println(L);
	}

}
