package baekjoon.그리디.센서;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader  br  = new BufferedReader(new InputStreamReader(System.in));

		int             N   = Integer.parseInt(br.readLine());
		int             K   = Integer.parseInt(br.readLine());

		int[]           censor = new int[N];
		int[]           distance = new int[N - 1];

		StringTokenizer st  = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			censor[i] = Integer.parseInt(st.nextToken());
		}

		// 센서 위치 정렬
		Arrays.sort(censor);

		// 센서간 최단 거리 저장
		for (int i = 0; i < N - 1; i++) {
			distance[i] = censor[i + 1] - censor[i];
		}

		// 거리 정렬
		Arrays.sort(distance);

		int cnt = 0;
		
		//필요한거만 더해준다
		for (int i = 0; i < N - K; i++) {
			cnt += distance[i];
		}

		System.out.println(cnt);

	}

}
