package baekjoon.구현.빗물;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader  br  = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  = new StringTokenizer(br.readLine());

		int             H   = Integer.parseInt(st.nextToken());
		int             W   = Integer.parseInt(st.nextToken());

		// 블록 최대 최소값 저장 배열
		int[]           max = new int[2];
		int[]           min = new int[2];
		min[0] = Integer.MAX_VALUE;

		int[][] road = new int[H][W];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < W; i++) {

			int now = Integer.parseInt(st.nextToken());

			// 길에 블록을 저장한다
			for (int j = H - 1; j >= H - now; j--) {
				road[j][i] = -1;
			}

			// 3번쨰 위치부터 물이 고인다
			if (i > 1) {

				// 현재 블록이 최대 높이의 블록보다 작거나 같고 물이 고일수 있으면 물을 추가한다
				if (now <= max[0] && now > min[0]) {

					// 최대 높이의 블록 가로 위치부터
					for (int j = max[1]; j < i; j++) {

						// 현재 블록의 높이많큼 물이 고인다
						for (int k = H - 1; k >= H - now; k--) {

							road[k][j] = road[k][j] == -1 ? road[k][j] : 1;
						}
					}

					// 물이 고였으니 최소값을 변경한다
					min[0] = now;
					min[1] = i;

				}
				// 현재 블록이 가장 높을
				else if (now > max[0] && now > min[0]) {

					// 기존 최대 높이의 블록 가로 위치부터
					for (int j = max[1]; j < i; j++) {

						// 기존 최대 높이의 높이많큼 물이 고인다
						for (int k = H - 1; k >= H - max[0]; k--) {

							road[k][j] = road[k][j] == -1 ? road[k][j] : 1;
						}
					}

					// 물이 고였으니 최소값을 변경한다
					min[0] = max[0];
					min[1] = max[1];

				}

			}

			if (now > max[0]) {
				max[0] = now;
				max[1] = i;
			}

			if (now < min[0]) {
				min[0] = now;
				min[1] = i;

			}

		}

		// 물 갯수 카운팅
		int cnt = 0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (road[i][j] == 1)
					cnt++;

			}
		}
		System.out.println(cnt);
	}
}
