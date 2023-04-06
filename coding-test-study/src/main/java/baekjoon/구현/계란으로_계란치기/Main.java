package baekjoon.구현.계란으로_계란치기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static int N;

	public static int[][] eggArr;

	public static int max = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		eggArr = new int[N][2];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int durability = Integer.parseInt(st.nextToken());
			int weigth = Integer.parseInt(st.nextToken());

			eggArr[i][0] = durability;
			eggArr[i][1] = weigth;
		}

		find(0, 0);
		System.out.println(max);

	}

	public static void find(int idx, int cnt) {

		// 최데값 갱신
		max = Math.max(max, cnt);

		// 범위 체크
		if (idx == N) {
			return;
		}

		// 손에 든 계란이 꺠졋으면 다음 계란을 든다
		if (eggArr[idx][0] <= 0) {
			find(idx + 1, cnt);
			return;
		}

		for (int i = 0; i < N; i++) {

			if (i != idx && eggArr[i][0] > 0) {
				// 계란 치기
				// 손에 든 계란 내구도 계산
				eggArr[idx][0] -= eggArr[i][1];

				// 공격을 당한 계란 내구도 계산
				eggArr[i][0] -= eggArr[idx][1];

				int tmp = 0;

				// 손에 든 계란 내구도 체크
				if (eggArr[idx][0] <= 0) {
					tmp++;
				}

				// 공격을 당한 계란 내구도 체크
				if (eggArr[i][0] <= 0) {
					tmp++;
				}

				find(idx + 1, cnt + tmp);

				// 내구도 복구
				eggArr[idx][0] += eggArr[i][1];
				eggArr[i][0] += eggArr[idx][1];
			}

		}

	}
}
