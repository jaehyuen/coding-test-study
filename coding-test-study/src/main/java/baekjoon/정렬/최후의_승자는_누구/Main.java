package baekjoon.정렬.최후의_승자는_누구;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader  br  = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  = new StringTokenizer(br.readLine());

		int             N   = Integer.parseInt(st.nextToken());
		int             M   = Integer.parseInt(st.nextToken());

		// 카드 갯수보다 한칸더 해준다
		int[][]         arr = new int[N][M + 1];

		// 입력 받고 정렬한다
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(arr[i]);

		}
		// 최고점수
		int totalMax = 0;
		for (int i = M; i > 0; i--) {

			// 단계별 큰점수
			int max = 0;
			for (int j = 0; j < N; j++) {
				max = Math.max(max, arr[j][i]);
			}

			// 가장 큰 점수를 지닌사람을 배열의 첫째자리에 점수 카운팅
			for (int j = 0; j < N; j++) {
				if (arr[j][i] == max) {
					arr[j][0] += 1;
					totalMax   = Math.max(totalMax, arr[j][0]);
				}
			}

		}

		// 최고 점수만 출력
		for (int i = 0; i < N; i++) {
			if (totalMax == arr[i][0]) {
				System.out.print((i + 1) + " ");
			}
		}

	}

}
